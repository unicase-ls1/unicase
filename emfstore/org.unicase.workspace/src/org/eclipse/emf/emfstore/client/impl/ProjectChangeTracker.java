/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.emfstore.client.CompositeOperationHandle;
import org.eclipse.emf.emfstore.client.Configuration;
import org.eclipse.emf.emfstore.client.changeTracking.NotificationToOperationConverter;
import org.eclipse.emf.emfstore.client.changeTracking.commands.CommandObserver;
import org.eclipse.emf.emfstore.client.changeTracking.commands.EMFStoreCommandStack;
import org.eclipse.emf.emfstore.client.changeTracking.notification.NotificationInfo;
import org.eclipse.emf.emfstore.client.changeTracking.notification.filter.FilterStack;
import org.eclipse.emf.emfstore.client.changeTracking.notification.recording.NotificationRecorder;
import org.eclipse.emf.emfstore.client.observers.PostCreationListener;
import org.eclipse.emf.emfstore.client.util.WorkspaceUtil;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.impl.CreateDeleteOperationImpl;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticCompositeOperation;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.impl.ProjectImpl;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.metamodel.util.ProjectChangeObserver;
import org.unicase.util.UnicaseUtil;

/**
 * Tracks changes on a project that is contained in a project space.
 * 
 * @author koegel
 */
public class ProjectChangeTracker implements ProjectChangeObserver, CommandObserver {

	private final ProjectSpaceImpl projectSpace;
	private boolean isRecording;
	private NotificationRecorder notificationRecorder;
	private CompositeOperation compositeOperation;
	private boolean autoSave;

	/**
	 * Indicates whether a resource may be split when a model element has been added.
	 */
	private boolean splitResource;

	/**
	 * Name of unknown creator.
	 */
	public static final String UNKOWN_CREATOR = "unknown";
	private DirtyResourceSet dirtyResourceSet;
	private EMFStoreCommandStack emfStoreCommandStack;
	private int currentOperationListSize;
	private EditingDomain editingDomain;
	private Set<EObject> currentClipboard;
	private List<AbstractOperation> operations;
	private List<EObject> removedElements;

	private NotificationToOperationConverter converter;
	private List<PostCreationListener> postCreationListeners;
	private boolean commandIsRunning;

	/**
	 * @return the removedElements
	 */
	public List<EObject> getRemovedElements() {
		return removedElements;
	}

	/**
	 * Constructor.
	 * 
	 * @param projectSpace the project space the change tracker is operating on.
	 */
	public ProjectChangeTracker(ProjectSpaceImpl projectSpace) {
		this.projectSpace = projectSpace;
		this.isRecording = false;
		this.autoSave = true;
		this.splitResource = true;
		dirtyResourceSet = new DirtyResourceSet();

		if (!projectSpace.isTransient()) {
			editingDomain = Configuration.getEditingDomain();

			CommandStack commandStack = editingDomain.getCommandStack();

			if (commandStack instanceof EMFStoreCommandStack) {
				emfStoreCommandStack = (EMFStoreCommandStack) commandStack;
				emfStoreCommandStack.addCommandStackObserver(this);
			} else {
				throw new IllegalStateException("Setup of ResourceSet is invalid, there is no EMFStoreCommandStack!");
			}
		}
		operations = projectSpace.getOperations();
		removedElements = new ArrayList<EObject>();
		converter = new NotificationToOperationConverter(projectSpace.getProject());
		postCreationListeners = new ArrayList<PostCreationListener>();

		// BEGIN SUPRESS CATCH EXCEPTION
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.workspace.notify.postcreationlistener");
		for (IConfigurationElement e : config) {
			try {
				PostCreationListener l = (PostCreationListener) e.createExecutableExtension("class");
				postCreationListeners.add(l);
			} catch (CoreException e1) {
				WorkspaceUtil.logException("Cannot instantiate extension!", e1);
			} catch (RuntimeException e2) {
				WorkspaceUtil.logException("Severe runtime exception occured", e2);
			}
		}
		// END SUPRESS CATCH EXCEPTION
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#modelElementAdded(org.unicase.metamodel.Project,
	 *      org.unicase.metamodel.ModelElement)
	 */
	public void modelElementAdded(Project project, EObject modelElement) {
		// if element was just pasted from clipboard then do nothing
		if (this.getModelElementsFromClipboard().contains(modelElement)) {
			return;
		}

		addToResource(modelElement);

		// notify post creation listeners
		notifyPostCreationListeners(modelElement);

		if (isRecording) {
			// setup change recorder, stop operation recording and destruct cross references
			ChangeRecorder changeRecorder = new ChangeRecorder();
			Set<EObject> rootObjects = new HashSet<EObject>();
			rootObjects.add(project);
			rootObjects.add(modelElement);
			rootObjects.addAll(modelElement.eCrossReferences());
			changeRecorder.beginRecording(rootObjects);
			stopChangeRecording();
			ModelUtil.deleteOutgoingCrossReferences(modelElement, true, false);
			ModelUtil.deleteIncomingCrossReferencesFromProject(modelElement, project, true, false);

			// stop change recorder, start operation recorded and reapply reversed recorded changes
			ChangeDescription changeDesc = changeRecorder.endRecording();
			CompositeOperation oldCompositeOperation = this.compositeOperation;
			this.compositeOperation = OperationsFactory.eINSTANCE.createCompositeOperation();
			startChangeRecording();
			changeDesc.apply();
			changeRecorder.dispose();
			// collect recorded operations and add to create operation
			CreateDeleteOperation createDeleteOperation = createCreateDeleteOperation(modelElement, false);
			List<AbstractOperation> recordedOperations = compositeOperation.getSubOperations();
			this.compositeOperation = oldCompositeOperation;
			List<ReferenceOperation> recordedReferenceOperations = new ArrayList<ReferenceOperation>();
			for (AbstractOperation operation : recordedOperations) {
				if (operation instanceof ReferenceOperation) {
					recordedReferenceOperations.add((ReferenceOperation) operation);
				} else {
					ModelUtil.logException(new IllegalStateException(
						"Non Reference Operation detected in create operation recording."));
				}
			}
			createDeleteOperation.getSubOperations().addAll(recordedReferenceOperations);
			if (this.compositeOperation != null) {
				this.compositeOperation.getSubOperations().add(createDeleteOperation);
			} else {
				projectSpace.addOperation(createDeleteOperation);
			}
		}
	}

	private void notifyPostCreationListeners(EObject modelElement) {
		// do not record changes since the creation listeners may only change attributes
		boolean wasRecording = isRecording;
		if (isRecording) {
			stopChangeRecording();
		}
		for (PostCreationListener l : postCreationListeners) {
			l.onCreation(projectSpace, modelElement);
		}
		if (wasRecording) {
			startChangeRecording();
		}
	}

	/**
	 * Add model element to a resource, assign a new resource if necessary.
	 * 
	 * @param modelElement the model element
	 * @generated NOT
	 */
	void addToResource(final EObject modelElement) {
		if (projectSpace.isTransient()) {
			return;
		}
		addElementToResouce(modelElement);
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
			stopChangeRecording();
			splitResource = false;
			// model element lost its parent, revert changes
			changeDesc.apply();
			startChangeRecording();
			return false;
		}
		changeRecorder.dispose();
		setModelElementIdAndChildrenIdOnResource(resource, modelElement);

		return true;
	}

	private void addElementToResouce(final EObject modelElement) {
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

	private void unsetModelElementIdAndChildrenIdOnResource(XMIResource resource, EObject modelElement) {
		resource.setID(modelElement, null);

		TreeIterator<EObject> it = modelElement.eAllContents();
		while (it.hasNext()) {
			EObject child = it.next();
			resource.setID(child, null);
		}
	}

	private void checkIfFileExists(String newfileName) {
		if (new File(newfileName).exists()) {
			throw new IllegalStateException("File fragment \"" + newfileName
				+ "\" already exists - ProjectSpace corrupted.");
		}
	}

	/**
	 * Stops current recording of changes and adds recorded changes to this project spaces changes.
	 * 
	 * @generated NOT
	 */
	public void stopChangeRecording() {
		this.isRecording = false;
	}

	/**
	 * Starts change recording on this workspace, resumes previous recordings if there are any.
	 * 
	 * @generated NOT
	 */
	public void startChangeRecording() {
		if (notificationRecorder == null) {
			notificationRecorder = new NotificationRecorder();
		}
		this.removedElements.clear();
		// notificationRecorder;
		isRecording = true;
	}

	/**
	 * Save all dirty resources to disk now if autosave is active.
	 */
	public void saveDirtyResources() {
		if (autoSave) {
			dirtyResourceSet.save();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification,
	 *      org.unicase.metamodel.Project, org.unicase.metamodel.ModelElement)
	 */
	public void notify(Notification notification, Project project, EObject modelElement) {

		// filter unwanted notifications
		if (FilterStack.DEFAULT.check(new NotificationInfo(notification))) {
			return;
		}

		save(modelElement);
		if (isRecording) {
			notificationRecorder.record(notification);
		}
		if (notificationRecorder.isRecordingComplete()) {
			if (isRecording) {
				recordingFinished();
			}
			if (!commandIsRunning) {
				saveDirtyResources();
			}
		}
	}

	private void recordingFinished() {

		// create operations from "valid" notifications, log invalid ones, accumulate the ops
		List<AbstractOperation> ops = new LinkedList<AbstractOperation>();
		List<NotificationInfo> rec = notificationRecorder.getRecording().asMutableList();
		for (NotificationInfo n : rec) {
			if (!n.isValid()) {
				WorkspaceUtil.log("INVALID NOTIFICATION MESSAGE DETECTED: " + n.getValidationMessage(), null, 0);
				continue;
			} else {
				AbstractOperation op = converter.convert(n);
				if (op != null) {
					ops.add(op);
				} else {
					// we should never get here, this would indicate a consistency error,
					// n.isValid() should have been false
					WorkspaceUtil.log("INVALID NOTIFICATION CLASSIFICATION,"
						+ " notification is valid, but cannot be converted to an operation: " + n.toString(), null, 0);
					continue;
				}
			}
		}

		// add resulting operations as suboperations to composite or top-level operations
		if (compositeOperation != null) {
			compositeOperation.getSubOperations().addAll(ops);
			// FIXME: ugly hack for recording of create operation cross references
			if (compositeOperation.eResource() != null) {
				projectSpace.saveResource(compositeOperation.eResource());
			}
		} else {
			if (ops.size() > 1) {
				CompositeOperation op = OperationsFactory.eINSTANCE.createCompositeOperation();
				op.getSubOperations().addAll(ops);
				// set the last operation as the main one for natural composites
				op.setMainOperation(ops.get(ops.size() - 1));
				op.setModelElementId((ModelElementId) EcoreUtil.copy(op.getMainOperation().getModelElementId()));
				projectSpace.addOperation(op);
			} else if (ops.size() == 1) {
				projectSpace.addOperation(ops.get(0));
			}
		}

	}

	/**
	 * Aborts the current composite operation.
	 */
	public void abortCompositeOperation() {
		projectSpace.undoLastOperation();
		this.compositeOperation = null;
		currentOperationListSize = operations.size();
		removedElements.clear();
	}

	/**
	 * Returns the notification recorder of the project space.
	 * 
	 * @return the notification recorder
	 */
	public NotificationRecorder getNotificationRecorder() {
		return notificationRecorder;
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

	/**
	 * Create a CreateDeleteOperation.
	 * 
	 * @param modelElement the model element to delete or create
	 * @param delete whether the element is deleted or created
	 * @return the operation
	 */
	private CreateDeleteOperation createCreateDeleteOperation(EObject modelElement, boolean delete) {
		CreateDeleteOperation createDeleteOperation = OperationsFactory.eINSTANCE.createCreateDeleteOperation();
		createDeleteOperation.setDelete(delete);
		EObject element = modelElement;

		List<EObject> allContainedModelElements = ModelUtil.getAllContainedModelElementsAsList(element, false);
		allContainedModelElements.add(element);
		EObject copiedElement = EcoreUtil.copy(element);
		List<EObject> copiedAllContainedModelElements = ModelUtil.getAllContainedModelElementsAsList(copiedElement,
			false);
		copiedAllContainedModelElements.add(copiedElement);

		for (int i = 0; i < allContainedModelElements.size(); i++) {
			EObject child = allContainedModelElements.get(i);

			if (ModelUtil.isIgnoredDatatype(child)) {
				continue;
			}

			EObject copiedChild = copiedAllContainedModelElements.get(i);
			ModelElementId childId = projectSpace.getProject().getModelElementId(child);

			((CreateDeleteOperationImpl) createDeleteOperation).getEObjectToIdMap().put(copiedChild, childId);
		}

		createDeleteOperation.setModelElement(copiedElement);
		createDeleteOperation.setModelElementId(projectSpace.getProject().getModelElementId(modelElement));

		createDeleteOperation.setClientDate(new Date());
		return createDeleteOperation;
	}

	/**
	 * Complete the current composite operation.
	 */
	public void endCompositeOperation() {
		projectSpace.notifyOperationExecuted(compositeOperation);
		this.compositeOperation = null;
	}

	/**
	 * Replace and complete the current composite operation.
	 * 
	 * @param semanticCompositeOperation the semantic operation that replaces the composite operation
	 */
	public void endCompositeOperation(SemanticCompositeOperation semanticCompositeOperation) {
		List<AbstractOperation> operations = projectSpace.getOperations();
		operations.remove(operations.size() - 1);
		operations.add(semanticCompositeOperation);
		compositeOperation = semanticCompositeOperation;
		endCompositeOperation();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.ProjectSpace#beginCompositeOperation()
	 */
	public CompositeOperationHandle beginCompositeOperation() {

		// notificationRecorder.newRecording();
		if (this.compositeOperation != null) {
			throw new IllegalStateException("Can only have one composite at once!");
		}
		this.compositeOperation = OperationsFactory.eINSTANCE.createCompositeOperation();
		projectSpace.addOperation(this.compositeOperation);
		CompositeOperationHandle handle = new CompositeOperationHandle(this, compositeOperation);
		return handle;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#projectDeleted(org.unicase.metamodel.Project)
	 */
	public void projectDeleted(Project project) {
		if (emfStoreCommandStack != null) {
			emfStoreCommandStack.removeCommandStackObserver(this);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#modelElementRemoved(org.unicase.metamodel.Project,
	 *      org.unicase.metamodel.ModelElement)
	 */
	public void modelElementRemoved(Project project, EObject modelElement) {
		removedElements.add(modelElement);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.changeTracking.commands.CommandObserver#commandCompleted(org.eclipse.emf.common.command.Command)
	 */
	public void commandCompleted(Command command) {
		commandIsRunning = false;
		// means that we have not seen a command start yet
		if (currentClipboard == null) {
			return;
		}

		List<EObject> deletedElements = new ArrayList<EObject>();
		for (int i = removedElements.size() - 1; i >= 0; i--) {
			EObject removedElement = removedElements.get(i);
			if (!projectSpace.getProject().containsInstance(removedElement)) {
				if (!deletedElements.contains(removedElement)) {
					deletedElements.add(0, removedElement);
				}
			}

		}
		removedElements.clear();

		Set<EObject> newElementsOnClipboardAfterCommand = getModelElementsFromClipboard();
		newElementsOnClipboardAfterCommand.removeAll(currentClipboard);

		// handle deleted elements => cut command
		for (EObject deletedElement : deletedElements) {
			if (newElementsOnClipboardAfterCommand.contains(deletedElement)) {
				// element was cut
				projectSpace.getProject().getCutElements().add(deletedElement);
			} else {
				// element was deleted
				handleElementDelete(deletedElement);
				cleanResources(deletedElement);
			}
		}

		// remove all deleted elements
		newElementsOnClipboardAfterCommand.removeAll(deletedElements);

		saveDirtyResources();
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

	private void deleteOutgoingCrossReferencesOfContainmentTree(EObject modelElement) {
		deleteOutgoingCrossReferences(modelElement);
		for (EObject child : ModelUtil.getAllContainedModelElements(modelElement, false)) {
			deleteOutgoingCrossReferences(child);
		}
	}

	private void deleteOutgoingCrossReferences(EObject modelElement) {
		// delete all non containment cross references to other elments
		for (EReference reference : modelElement.eClass().getEAllReferences()) {
			EClassifier eType = reference.getEType();
			if (reference.isContainer() || reference.isContainment() || !reference.isChangeable()) {
				continue;
			}

			if (eType instanceof EClass) {
				modelElement.eUnset(reference);
			}
		}
	}

	private void handleElementDelete(EObject deletedElement) {
		deleteOutgoingCrossReferencesOfContainmentTree(deletedElement);

		if (!UnicaseUtil.isSelfContained(deletedElement, true)) {
			throw new IllegalStateException(
				"Element was removed from containment of project but still has cross references!: "
					+ ModelUtil.getProject(deletedElement).getModelElementId(deletedElement).getId());
		}

		if (!isRecording) {
			return;
		}

		CreateDeleteOperation deleteOperation = OperationsFactory.eINSTANCE.createCreateDeleteOperation();
		deleteOperation.setClientDate(new Date());

		List<EObject> allContainedModelElements = ModelUtil.getAllContainedModelElementsAsList(deletedElement, false);
		allContainedModelElements.add(deletedElement);
		EObject copiedElement = EcoreUtil.copy(deletedElement);
		deleteOperation.setModelElement(copiedElement);
		deleteOperation.setModelElementId(((ProjectImpl) projectSpace.getProject())
			.getDeletedModelElementId(deletedElement));
		List<EObject> copiedAllContainedModelElements = ModelUtil.getAllContainedModelElementsAsList(copiedElement,
			false);
		copiedAllContainedModelElements.add(copiedElement);

		for (int i = 0; i < allContainedModelElements.size(); i++) {
			EObject child = allContainedModelElements.get(i);
			EObject copiedChild = copiedAllContainedModelElements.get(i);
			ModelElementId childId = ((ProjectImpl) projectSpace.getProject()).getDeletedModelElementId(child);
			((CreateDeleteOperationImpl) deleteOperation).getEObjectToIdMap().put(copiedChild, childId);
		}

		deleteOperation.setDelete(true);

		List<CompositeOperation> compositeOperationsToDelete = new ArrayList<CompositeOperation>();
		deleteOperation.getSubOperations().addAll(
			extractReferenceOperationsForDelete(deletedElement, compositeOperationsToDelete));
		operations.removeAll(compositeOperationsToDelete);

		if (this.compositeOperation != null) {
			this.compositeOperation.getSubOperations().add(deleteOperation);
			projectSpace.saveResource(compositeOperation.eResource());
		} else {
			projectSpace.addOperation(deleteOperation);
		}

		// remove deleted model element and children from resource
		ModelUtil.removeModelElementAndChildrenFromResource(deletedElement);
	}

	@SuppressWarnings("unchecked")
	private List<ReferenceOperation> extractReferenceOperationsForDelete(EObject deletedElement,
		List<CompositeOperation> compositeOperationsToDelete) {
		Set<ModelElementId> allDeletedElementsIds = new HashSet<ModelElementId>();
		for (EObject child : ModelUtil.getAllContainedModelElements(deletedElement, false)) {
			ModelElementId childId = ((ProjectImpl) projectSpace.getProject()).getDeletedModelElementId(child);
			allDeletedElementsIds.add(childId);
		}
		allDeletedElementsIds.add(((ProjectImpl) projectSpace.getProject()).getDeletedModelElementId(deletedElement));

		List<ReferenceOperation> referenceOperationsForDelete = new ArrayList<ReferenceOperation>();
		if (currentOperationListSize >= operations.size()) {
			return referenceOperationsForDelete;
		}
		List<AbstractOperation> newOperations = operations.subList(currentOperationListSize, operations.size());
		for (int i = newOperations.size() - 1; i >= 0; i--) {
			AbstractOperation operation = newOperations.get(i);
			if (belongsToDelete(operation, allDeletedElementsIds)) {
				referenceOperationsForDelete.add(0, (ReferenceOperation) operation);
				continue;
			}
			if (operation instanceof CompositeOperation && ((CompositeOperation) operation).getMainOperation() != null) {
				CompositeOperation compositeOperation = (CompositeOperation) operation;
				boolean doesNotBelongToDelete = false;
				for (AbstractOperation subOperation : compositeOperation.getSubOperations()) {
					if (!belongsToDelete(subOperation, allDeletedElementsIds)) {
						doesNotBelongToDelete = true;
						break;
					}
				}
				if (!doesNotBelongToDelete) {
					referenceOperationsForDelete.addAll(0,
						(Collection<? extends ReferenceOperation>) compositeOperation.getSubOperations());
					compositeOperationsToDelete.add(compositeOperation);
				}
				continue;
			}
			break;
		}

		return referenceOperationsForDelete;
	}

	private boolean belongsToDelete(AbstractOperation operation, Set<ModelElementId> allDeletedElementsIds) {
		if (operation instanceof ReferenceOperation) {
			ReferenceOperation referenceOperation = (ReferenceOperation) operation;
			Set<ModelElementId> allInvolvedModelElements = referenceOperation.getAllInvolvedModelElements();
			if (allInvolvedModelElements.removeAll(allDeletedElementsIds)) {
				return isDestructorReferenceOperation(referenceOperation);
			}
		}
		return false;
	}

	private boolean isDestructorReferenceOperation(ReferenceOperation referenceOperation) {
		if (referenceOperation instanceof MultiReferenceOperation) {
			MultiReferenceOperation multiReferenceOperation = (MultiReferenceOperation) referenceOperation;
			return !multiReferenceOperation.isAdd();
		} else if (referenceOperation instanceof SingleReferenceOperation) {
			SingleReferenceOperation singleReferenceOperation = (SingleReferenceOperation) referenceOperation;
			return singleReferenceOperation.getOldValue() != null && singleReferenceOperation.getNewValue() == null;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.changeTracking.commands.CommandObserver#commandFailed(org.eclipse.emf.common.command.Command,
	 *      org.eclipse.core.runtime.OperationCanceledException)
	 */
	public void commandFailed(Command command, Exception exception) {

		// this is a backup in order to remove obsolete operations. In most (all?) cases though, the rollback of the
		// transaction does this.

		for (int i = projectSpace.getOperations().size() - 1; i >= currentOperationListSize; i--) {
			projectSpace.getOperations().remove(i);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.changeTracking.commands.CommandObserver#commandStarted(org.eclipse.emf.common.command.Command)
	 */
	public void commandStarted(Command command) {
		currentOperationListSize = projectSpace.getOperations().size();
		currentClipboard = getModelElementsFromClipboard();
		commandIsRunning = true;

	}

	private Set<EObject> getModelElementsFromClipboard() {
		Set<EObject> result = new HashSet<EObject>();
		if (editingDomain == null) {
			return result;
		}
		Collection<Object> clipboard = editingDomain.getClipboard();
		if (clipboard == null) {
			return result;
		}
		for (Object element : clipboard) {
			if (element instanceof EObject) {
				result.add((EObject) element);
			}
		}
		return result;
	}

	/**
	 * Enable or disable save. I save is disabled, dirty resources will not bes saved.
	 * 
	 * @param newValue true if auto save should be enabled
	 */
	public void setAutoSave(boolean newValue) {
		autoSave = newValue;
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

}
