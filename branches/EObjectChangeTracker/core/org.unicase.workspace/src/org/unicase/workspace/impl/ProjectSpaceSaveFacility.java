package org.unicase.workspace.impl;

import java.io.File;
import java.util.Collections;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.unicase.metamodel.ModelElementId;
import org.unicase.workspace.Configuration;

public class ProjectSpaceSaveFacility implements ResourceSaveFacility {

	private final ProjectSpaceImpl projectSpace;
	private final DirtyResourceSet dirtyResourceSet;

	/**
	 * Indicates whether a resource may be split when a model element has been added.
	 */
	private boolean splitResource;

	private boolean autoSave;

	ProjectSpaceSaveFacility(ProjectSpaceImpl projectSpace) {
		this.projectSpace = projectSpace;

		splitResource = true;
		autoSave = true;
		dirtyResourceSet = new DirtyResourceSet();
	}

	public void addElementToResouce(final EObject modelElement) {
		if (projectSpace.isTransient()) {
			// don't save
			return;
		}

		XMIResource oldResource = (XMIResource) modelElement.eResource();
		addToParentResourceIfPossible(oldResource, modelElement);
		URI oldUri = oldResource.getURI();
		String oldFileName = oldUri.toFileString();

		if (!oldUri.isFile()) {
			throw new IllegalStateException("Project contains ModelElements that are not part of a file resource.");
		}

		if (new File(oldFileName).length() > Configuration.getMaxResourceFileSizeOnExpand()) { // && splitResource) {
			String newfileName = Configuration.getWorkspaceDirectory() + Configuration.getProjectSpaceDirectoryPrefix()
				+ projectSpace.getIdentifier() + File.separatorChar + Configuration.getProjectFolderName()
				+ File.separatorChar + projectSpace.getResourceCount()
				+ Configuration.getProjectFragmentFileExtension();
			projectSpace.setResourceCount(projectSpace.getResourceCount() + 1);
			projectSpace.saveProjectSpaceOnly();
			checkIfFileExists(newfileName);
			URI fileURI = URI.createFileURI(newfileName);
			XMIResource newResource = (XMIResource) oldResource.getResourceSet().createResource(fileURI);

			if (addToParentResourceIfPossible(newResource, modelElement)) {
				// if resource has been successfully, remove IDs of model element on old resource
				unsetModelElementIdAndChildrenIdOnResource(oldResource, modelElement);
			}
		}
		save(modelElement);
	}

	/**
	 * Tries to add the given model element to the resource of the parent. If it hereby loses its parent, the split is
	 * reversed.
	 * 
	 * @param modelElement the model element to be added to the resource
	 * @return true, is a split occurred successfully, else false
	 */
	private boolean addToParentResourceIfPossible(XMIResource resource, EObject modelElement) {
		if (!splitResource) {
			return false;
		}

		EObject parent = modelElement.eContainer();
		ChangeRecorder changeRecorder = new ChangeRecorder();
		changeRecorder.beginRecording(Collections.singleton(parent));
		// try to pin resource
		resource.getContents().add(modelElement);
		ChangeDescription changeDesc = changeRecorder.endRecording();

		if (modelElement.eContainer() != parent) {
			// TODO Adrian
			// stopChangeRecording();
			// splitResource = false;
			// // model element lost its parent, revert changes
			// changeDesc.apply();
			// startChangeRecording();
			return false;
		}

		setModelElementIdAndChildrenIdOnResource(resource, modelElement);

		return true;
	}

	private void checkIfFileExists(String newfileName) {
		if (new File(newfileName).exists()) {
			throw new IllegalStateException("File fragment \"" + newfileName
				+ "\" already exists - ProjectSpace corrupted.");
		}
	}

	private void unsetModelElementIdAndChildrenIdOnResource(XMIResource resource, EObject modelElement) {
		resource.setID(modelElement, null);

		TreeIterator<EObject> it = modelElement.eAllContents();
		while (it.hasNext()) {
			EObject child = it.next();
			resource.setID(child, null);
		}
	}

	/**
	 * Save the given model elements resource.
	 * 
	 * @param modelElement the model elements
	 */
	private void save(EObject modelElement) {
		Resource resource = modelElement.eResource();

		if (projectSpace.isTransient()) {
			return;
		}
		if (resource != null) {
			dirtyResourceSet.addDirtyResource(resource);
		}
	}

	private void setModelElementIdAndChildrenIdOnResource(XMIResource resource, EObject modelElement) {
		String modelElementId = projectSpace.getProject().getModelElementId(modelElement).getId();
		resource.setID(modelElement, modelElementId);

		TreeIterator<EObject> it = modelElement.eAllContents();
		while (it.hasNext()) {
			EObject child = it.next();
			ModelElementId childId = projectSpace.getProject().getModelElementId(child);
			resource.setID(child, childId.getId());
		}
	}

	/**
	 * Sets whether a resource split may occur when a model element is added.
	 * 
	 * @param splitResource whether resource splitting should occur
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

	/**
	 * Save all dirty resources to disk now if autosave is active.
	 */
	public void saveDirtyResources() {
		if (autoSave) {
			dirtyResourceSet.save();
		}
	}

	public void setAutoSave(boolean newValue) {
		autoSave = newValue;
	}
}
