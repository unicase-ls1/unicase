package org.eclipse.emf.emfstore.client.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.emfstore.client.changeTracking.commands.CommandObserver;
import org.eclipse.emf.emfstore.client.changeTracking.commands.EMFStoreCommandStack;
import org.eclipse.emf.emfstore.common.model.IdEObjectCollection;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.util.EObjectChangeNotifier;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.common.model.util.ProjectChangeObserver;

public class StatePersister implements CommandObserver, ProjectChangeObserver {

	private EObjectChangeNotifier changeNotifier;
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

	// TODO: 2nd parameter, commandstack
	// change notifier per methode setzen
	public StatePersister(EObjectChangeNotifier changeNotifier,
			EMFStoreCommandStack commandStack, IdEObjectCollection collection) {
		this.autoSave = true;
		this.commandStack = commandStack;
		this.changeNotifier = changeNotifier;
		this.collection = collection;
		this.commandStack.addCommandStackObserver(this);
		this.dirtyResourceSet = new DirtyResourceSet();
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
		for (EObject child : ModelUtil.getAllContainedModelElements(
				deletedElement, false)) {
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
			setModelElementIdAndChildrenIdOnResource((XMIResource) resource,
					modelElement);
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

	public void notify(Notification notification,
			IdEObjectCollection rootEObject, EObject modelElement) {
		addToDirtyResources(modelElement);
		if (!commandIsRunning) {
			saveDirtyResources();
		}
	}

	public void modelElementAdded(IdEObjectCollection rootEObject,
			EObject modelElement) {
		addToResource(modelElement);
	}

	public void modelElementRemoved(IdEObjectCollection rootEObject,
			EObject modelElement) {
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

	/**
	 * Add model element to a resource, assign a new resource if necessary.
	 * 
	 * @param modelElement
	 *            the model element
	 * @generated NOT
	 */
	void addToResource(final EObject modelElement) {
		addElementToResouce(modelElement);
	}

	private void addElementToResouce(final EObject modelElement) {
		XMIResource oldResource = (XMIResource) modelElement.eResource();

		if (oldResource != null) {
			addToParentResourceIfPossible(oldResource, modelElement);
			URI oldUri = oldResource.getURI();
			String oldFileName = oldUri.toFileString();

			if (!oldUri.isFile()) {
				throw new IllegalStateException(
						"Project contains ModelElements that are not part of a file resource.");
			}

			if (new File(oldFileName).length() > Configuration
					.getMaxResourceFileSizeOnExpand() && splitResource) {

				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
						"File-ddMMyy-hhmmss.SSS.txt");

				String newFileName;
				try {
					newFileName = File.createTempFile(
							simpleDateFormat.format(new Date()),
							"",
							new File(Configuration.getWorkspaceDirectory()
									+ Configuration
											.getProjectSpaceDirectoryPrefix()))
							.getAbsolutePath();
				} catch (IOException e) {
					// TODO: reasonable error message
					throw new IllegalStateException("File fragment \""
							+ "\" already exists - ProjectSpace corrupted.");
				}
				// TODO: EM
				// String newfileName = Configuration.getWorkspaceDirectory()
				// + Configuration.getProjectSpaceDirectoryPrefix()
				// + projectSpace.getIdentifier() + File.separatorChar
				// + Configuration.getProjectFolderName() + File.separatorChar
				// + projectSpace.getResourceCount()
				// + Configuration.getProjectFragmentFileExtension();
				// projectSpace.setResourceCount(projectSpace.getResourceCount()
				// +
				// 1);
				// projectSpace.saveProjectSpaceOnly();
				// checkIfFileExists(newFileName);
				URI fileURI = URI.createFileURI(newFileName);
				XMIResource newResource = (XMIResource) oldResource
						.getResourceSet().createResource(fileURI);

				oldResource.getContents().remove(modelElement);
				addToParentResourceIfPossible(newResource, modelElement);

				// if resource has been successfully, remove IDs of model
				// element on old resource
				// unsetModelElementIdAndChildrenIdOnResource(oldResource,
				// modelElement);
				// }
			}
		}

		addToDirtyResources(modelElement);
	}

	/**
	 * Tries to add the given model element to the resource of the parent. If it
	 * hereby loses its parent, the split is reversed.
	 * 
	 * @param modelElement
	 *            the model element to be added to the resource
	 * @return true, is a split occurred successfully, else false
	 */
	private boolean addToParentResourceIfPossible(XMIResource resource,
			EObject modelElement) {

		if (!splitResource) {
			return false;
		}

		EObject parent = modelElement.eContainer();
		ChangeRecorder changeRecorder = new ChangeRecorder();
		changeRecorder.beginRecording(Collections.singleton(parent));
		// try to pin resource
		resource.getContents().add(modelElement);
		ChangeDescription changeDesc = changeRecorder.endRecording();

		// TODO: enable resource splitting again
		if (modelElement.eContainer() != parent) {
			// stopChangeRecording();
			splitResource = false;
			// model element lost its parent, revert changes
			changeDesc.apply();
			// startChangeRecording();
			return false;
		}
		changeRecorder.dispose();
		// setModelElementIdAndChildrenIdOnResource(resource, modelElement);

		return true;
	}

	private void setModelElementIdAndChildrenIdOnResource(XMIResource resource,
			EObject modelElement) {
		String modelElementId = collection.getModelElementId(modelElement)
				.getId();
		resource.setID(modelElement, modelElementId);

		TreeIterator<EObject> it = modelElement.eAllContents();
		while (it.hasNext()) {
			EObject child = it.next();
			ModelElementId childId = collection.getModelElementId(child);
			resource.setID(child, childId.getId());
		}
	}

	private void unsetModelElementIdAndChildrenIdOnResource(
			XMIResource resource, EObject modelElement) {
		resource.setID(modelElement, null);
		TreeIterator<EObject> it = modelElement.eAllContents();

		while (it.hasNext()) {
			EObject child = it.next();
			resource.setID(child, null);
		}
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
