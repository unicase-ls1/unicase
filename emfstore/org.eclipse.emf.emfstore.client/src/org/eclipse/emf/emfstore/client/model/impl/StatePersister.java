package org.eclipse.emf.emfstore.client.model.impl;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.emfstore.client.model.Configuration;
import org.eclipse.emf.emfstore.client.model.changeTracking.commands.CommandObserver;
import org.eclipse.emf.emfstore.client.model.changeTracking.commands.EMFStoreCommandStack;
import org.eclipse.emf.emfstore.client.model.changeTracking.notification.NotificationInfo;
import org.eclipse.emf.emfstore.client.model.changeTracking.notification.filter.EmptyRemovalsFilter;
import org.eclipse.emf.emfstore.client.model.changeTracking.notification.filter.FilterStack;
import org.eclipse.emf.emfstore.client.model.changeTracking.notification.filter.NotificationFilter;
import org.eclipse.emf.emfstore.client.model.changeTracking.notification.filter.TouchFilter;
import org.eclipse.emf.emfstore.client.model.changeTracking.notification.filter.TransientFilter;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.emf.emfstore.common.model.IdEObjectCollection;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.util.EObjectChangeNotifier;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.common.model.util.ProjectChangeObserver;

public class StatePersister implements CommandObserver, ProjectChangeObserver {

	private IdEObjectCollection collection;

	/**
	 * Set containing all dirty resources.
	 */
	private DirtyResourceSet dirtyResourceSet;

	/**
	 * Indicates whether a command is running.
	 */
	private boolean commandIsRunning;

	/**
	 * Indicates whether a resource is saved automatically.
	 */
	private boolean autoSave;

	/**
	 * Indicates whether a resource may be split when a model element has been
	 * added.
	 */
	private boolean splitResource;
	private EMFStoreCommandStack commandStack;
	private FilterStack filterStack;

	// TODO: 2nd parameter, commandstack
	// change notifier per methode setzen
	public StatePersister(EObjectChangeNotifier changeNotifier, EMFStoreCommandStack commandStack,
		IdEObjectCollection collection) {
		this.autoSave = true;
		this.commandStack = commandStack;
		this.collection = collection;
		this.commandStack.addCommandStackObserver(this);
		this.dirtyResourceSet = new DirtyResourceSet();

		filterStack = new FilterStack(new NotificationFilter[] { new TouchFilter(), new TransientFilter(),
			new EmptyRemovalsFilter() });
	}

	public void commandStarted(Command command) {
		commandIsRunning = true;
	}

	public void commandCompleted(Command command) {
		commandIsRunning = false;
		saveDirtyResources();
	}

	public void commandFailed(Command command, Exception exception) {
		commandIsRunning = false;
	}

	private void cleanResources(EObject deletedElement) {
		Resource resource = deletedElement.eResource();
		if (resource != null) {
			resource.getContents().remove(deletedElement);
			dirtyResourceSet.addDirtyResource(resource);
		}
		for (EObject child : ModelUtil.getAllContainedModelElements(deletedElement, false)) {
			Resource childResource = child.eResource();
			if (childResource != null) {
				childResource.getContents().remove(child);
				dirtyResourceSet.addDirtyResource(childResource);
			}
		}
	}

	/**
	 * Adds the given model element's resource to the set of dirty resources.
	 * 
	 * @param modelElement
	 *            the model element
	 */
	private void addToDirtyResources(EObject modelElement) {
		Resource resource = modelElement.eResource();

		if (resource != null) {
			dirtyResourceSet.addDirtyResource(resource);
			setModelElementIdAndChildrenIdOnResource((XMIResource) resource, modelElement);
		}
	}

	/**
	 * Save all dirty resources to disk now if autosave is active.
	 */
	public void saveDirtyResources() {
		if (autoSave) {
			dirtyResourceSet.save();
		}
	}

	public void notify(Notification notification, IdEObjectCollection rootEObject, EObject modelElement) {
		// filter unwanted notifications that did not change anything in the
		// state
		if (filterStack.check(new NotificationInfo(notification))) {
			return;
		}
		addToDirtyResources(modelElement);
		if (!commandIsRunning) {
			saveDirtyResources();
		}
	}

	public void modelElementAdded(IdEObjectCollection rootEObject, EObject modelElement) {
		XMIResource oldResource = (XMIResource) modelElement.eResource();

		// do not split if splitting disabled or the element is a map entry
		if (oldResource != null && Configuration.isResourceSplittingEnabled()
			&& !(modelElement instanceof BasicEMap.Entry)) {
			addToNewResourceIfRequired(modelElement, oldResource);
		}

		addToDirtyResources(modelElement);
	}

	public void modelElementRemoved(IdEObjectCollection rootEObject, EObject modelElement) {
		// TODO: put
		// ModelUtil.removeModelElementAndChildrenFromResource(modelElement);
		// and unsetModelElementAnd.. into one place

		cleanResources(modelElement);
	}

	public void projectDeleted(IdEObjectCollection rootEObject) {
		if (commandStack != null) {
			commandStack.removeCommandStackObserver(this);
		}
	}

	private static Resource currentResource;

	private void addToNewResourceIfRequired(final EObject modelElement, XMIResource oldResource) {

		if (currentResource == null || currentResource.getURI() == null) {
			currentResource = oldResource;
		}
		URI oldUri = currentResource.getURI();
		String oldFileName = oldUri.toFileString();

		if (!oldUri.isFile()) {
			throw new IllegalStateException("Project contains ModelElements that are not part of a file resource.");
		}

		File oldFile = new File(oldFileName);
		if (oldFile.length() > Configuration.getMaxResourceFileSizeOnExpand()) {

			String newFileName;
			try {
				newFileName = File.createTempFile("frag", Configuration.getProjectFragmentFileExtension(),
					new File(oldFile.getParent())).getAbsolutePath();
			} catch (IOException e) {
				// TODO: reasonable error message
				throw new IllegalStateException("File fragment \"" + "\" already exists - ProjectSpace corrupted.");
			}

			URI fileURI = URI.createFileURI(newFileName);
			XMIResource newResource = (XMIResource) currentResource.getResourceSet().createResource(fileURI);

			newResource.getContents().add(modelElement);
			setModelElementIdAndChildrenIdOnResource(newResource, modelElement);
			currentResource = newResource;

		}
	}

	private void setModelElementIdAndChildrenIdOnResource(XMIResource resource, EObject modelElement) {
		ModelElementId modelElementId = getIDForEObject(modelElement);
		String modelElementIdString = modelElementId.getId();

		resource.setID(modelElement, modelElementIdString);

		TreeIterator<EObject> it = modelElement.eAllContents();
		while (it.hasNext()) {
			EObject child = it.next();
			ModelElementId childId = getIDForEObject(child);
			resource.setID(child, childId.getId());
		}
	}

	private ModelElementId getIDForEObject(EObject modelElement) {
		ModelElementId modelElementId = collection.getModelElementId(modelElement);
		if (modelElementId == null) {
			modelElementId = collection.getDeletedModelElementId(modelElement);
		}

		if (modelElementId == null) {
			WorkspaceUtil.handleException(new IllegalStateException("No ID for model element" + modelElement));
		}
		return modelElementId;
	}

	/**
	 * Enable or disable save. I save is disabled, dirty resources will not bes
	 * saved.
	 * 
	 * @param newValue
	 *            true if auto save should be enabled
	 */
	public void setAutoSave(boolean newValue) {
		autoSave = newValue;
	}

	/**
	 * Sets whether a resource split may occur when a model element is added.
	 * 
	 * @param splitResource
	 *            whether resource splitting should occur
	 */
	public void setSplitResource(boolean splitResource) {
		this.splitResource = splitResource;
	}

	/**
	 * Determines whether resource splitting is enabled.
	 * 
	 * @return true, if resource splitting may occur
	 */
	public boolean isSplitResource() {
		return splitResource;
	}

}
