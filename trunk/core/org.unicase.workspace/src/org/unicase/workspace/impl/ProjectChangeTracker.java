/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticCompositeOperation;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.metamodel.util.ProjectChangeObserver;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.changeTracking.NotificationToOperationConverter;
import org.unicase.workspace.changeTracking.commands.CommandObserver;
import org.unicase.workspace.changeTracking.commands.EMFStoreTransactionalCommandStack;
import org.unicase.workspace.changeTracking.notification.NotificationInfo;
import org.unicase.workspace.changeTracking.notification.filter.FilterStack;
import org.unicase.workspace.changeTracking.notification.filter.NotificationFilter;
import org.unicase.workspace.changeTracking.notification.recording.NotificationRecorder;
import org.unicase.workspace.util.WorkspaceUtil;

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

	/**
	 * Name of unknown creator.
	 */
	public static final String UNKOWN_CREATOR = "unknown";
	private DirtyResourceSet dirtyResourceSet;
	private EMFStoreTransactionalCommandStack emfStoreTransactionalCommandStack;
	private int currentOperationListSize;
	private TransactionalEditingDomain editingDomain;
	private Set<ModelElement> currentClipboard;
	private List<AbstractOperation> operations;
	private List<ModelElement> removedElements;

	/**
	 * @return the removedElements
	 */
	public List<ModelElement> getRemovedElements() {
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
		dirtyResourceSet = new DirtyResourceSet();

		if (!projectSpace.isTransient()) {
			editingDomain = Configuration.getEditingDomain();

			CommandStack commandStack = editingDomain.getCommandStack();

			if (!(commandStack instanceof EMFStoreTransactionalCommandStack)) {
				throw new IllegalStateException(
					"Setup of ResourceSet is invalid, there is no EMFStoreTransactionalCommandStack!");
			}
			emfStoreTransactionalCommandStack = (EMFStoreTransactionalCommandStack) commandStack;
			emfStoreTransactionalCommandStack.addCommandStackObserver(this);
		}
		operations = projectSpace.getOperations();
		removedElements = new ArrayList<ModelElement>();

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#modelElementAdded(org.unicase.metamodel.Project,
	 *      org.unicase.metamodel.ModelElement)
	 */
	public void modelElementAdded(Project project, ModelElement modelElement) {
		addToResource(modelElement);
		if (isRecording) {
			appendCreator(modelElement);
			CreateDeleteOperation createDeleteOperation = createCreateDeleteOperation(modelElement, false);
			if (this.compositeOperation != null) {
				this.compositeOperation.getSubOperations().add(createDeleteOperation);
			} else {
				projectSpace.addOperation(createDeleteOperation);
			}
		}
	}

	/**
	 * Add model element to a resource, assign a new resource if necessary.
	 * 
	 * @param modelElement the model element
	 * @generated NOT
	 */
	void addToResource(final ModelElement modelElement) {
		if (projectSpace.isTransient()) {
			return;
		}
		addElementToResouce(modelElement);
	}

	private void addElementToResouce(final ModelElement modelElement) {
		Resource oldResource = modelElement.eResource();
		URI oldUri = oldResource.getURI();
		if (!oldUri.isFile()) {
			throw new IllegalStateException("Project contains ModelElements that are not part of a file resource.");
		}
		String oldFileName = oldUri.toFileString();
		if (new File(oldFileName).length() > Configuration.getMaxResourceFileSizeOnExpand()) {
			String newfileName = Configuration.getWorkspaceDirectory() + Configuration.getProjectSpaceDirectoryPrefix()
				+ projectSpace.getIdentifier() + File.separatorChar + Configuration.getProjectFolderName()
				+ File.separatorChar + projectSpace.getResourceCount()
				+ Configuration.getProjectFragmentFileExtension();
			projectSpace.setResourceCount(projectSpace.getResourceCount() + 1);
			projectSpace.saveProjectSpaceOnly();
			checkIfFileExists(newfileName);
			URI fileURI = URI.createFileURI(newfileName);
			Resource newResource = oldResource.getResourceSet().createResource(fileURI);
			newResource.getContents().add(modelElement);
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
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification,
	 *      org.unicase.metamodel.Project, org.unicase.metamodel.ModelElement)
	 */
	public void notify(Notification notification, Project project, ModelElement modelElement) {
		notificationRecorder.record(notification);
		if (notificationRecorder.isRecordingComplete()) {
			if (isRecording) {
				recordingFinished();
			}
			dirtyResourceSet.save();

		}
		save(modelElement);
	}

	private void recordingFinished() {

		// canonize recorded notifications
		NotificationFilter f = FilterStack.DEFAULT;
		f.filter(notificationRecorder.getRecording());

		// create operations from "valid" notifications, log invalid ones, accumulate the ops
		List<AbstractOperation> ops = new LinkedList<AbstractOperation>();
		List<NotificationInfo> rec = notificationRecorder.getRecording().asMutableList();
		for (NotificationInfo n : rec) {
			if (!n.isValid()) {
				WorkspaceUtil.log("INVALID NOTIFICATION MESSAGE DETECTED: " + n.getValidationMessage(), null, 0);
				continue;
			} else {
				AbstractOperation op = NotificationToOperationConverter.convert(n);
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
			projectSpace.saveResource(compositeOperation.eResource());
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
		recordingFinished();
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

	private void save(ModelElement modelElement) {
		Resource resource = modelElement.eResource();

		if (projectSpace.isTransient()) {
			return;
		}
		if (resource != null) {
			dirtyResourceSet.addDirtyResource(resource);
		}
	}

	/**
	 * Appends the creator's name and the creation date.
	 * 
	 * @param modelElement the model element.
	 */
	private void appendCreator(ModelElement modelElement) {
		stopChangeRecording();
		if (modelElement.getCreator() == null || modelElement.getCreator().equals("")) {
			Usersession usersession = projectSpace.getUsersession();
			// used when the project has not been shared yet
			// and there is practically no possible way of
			// knowing who the creator was...
			String creator = UNKOWN_CREATOR;
			if (usersession != null) {
				creator = usersession.getACUser().getName();
			}
			modelElement.setCreator(creator);
		}
		if (modelElement.getCreationDate() == null) {
			modelElement.setCreationDate(new Date());
		}
		startChangeRecording();
	}

	/**
	 * Create a CreateDeleteOperation.
	 * 
	 * @param modelElement the model element to delete or create
	 * @param delete whether the element is deleted or created
	 * @return the operation
	 */
	private CreateDeleteOperation createCreateDeleteOperation(ModelElement modelElement, boolean delete) {
		CreateDeleteOperation createDeleteOperation = OperationsFactory.eINSTANCE.createCreateDeleteOperation();
		createDeleteOperation.setDelete(delete);
		createDeleteOperation.setModelElement((ModelElement) EcoreUtil.copy(modelElement));
		createDeleteOperation.setModelElementId(modelElement.getModelElementId());
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
	 * @see org.unicase.workspace.ProjectSpace#beginCompositeOperation()
	 */
	public CompositeOperationHandle beginCompositeOperation() {
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
		emfStoreTransactionalCommandStack.removeCommandStackObserver(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#modelElementRemoved(org.unicase.metamodel.Project,
	 *      org.unicase.metamodel.ModelElement)
	 */
	public void modelElementRemoved(Project project, ModelElement modelElement) {
		removedElements.add(modelElement);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.changeTracking.commands.CommandObserver#commandCompleted(org.eclipse.emf.common.command.Command)
	 */
	public void commandCompleted(Command command) {
		// means that we have not seen a command start yet
		if (currentClipboard == null) {
			return;
		}

		List<ModelElement> deletedElements = new ArrayList<ModelElement>();
		for (int i = removedElements.size() - 1; i >= 0; i--) {
			ModelElement removedElement = removedElements.get(i);
			if (!projectSpace.getProject().contains(removedElement)) {
				if (!deletedElements.contains(removedElement)) {
					deletedElements.add(0, removedElement);
				}
			}

		}
		removedElements.clear();

		Set<ModelElement> newElementsOnClipboardAfterCommand = getModelElementsFromClipboard();
		newElementsOnClipboardAfterCommand.removeAll(currentClipboard);

		// handle deleted elements => cut command
		for (ModelElement deletedElement : deletedElements) {
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

		// handle copied elements => copy command
		for (ModelElement copiedElement : newElementsOnClipboardAfterCommand) {
			reassignModelElementIds(copiedElement);
		}
		dirtyResourceSet.save();

	}

	private void cleanResources(ModelElement deletedElement) {
		Resource resource = deletedElement.eResource();
		if (resource != null) {
			resource.getContents().remove(deletedElement);
			dirtyResourceSet.addDirtyResource(resource);
		}
		for (ModelElement child : deletedElement.getAllContainedModelElements()) {
			Resource childResource = child.eResource();
			if (childResource != null) {
				childResource.getContents().remove(child);
				dirtyResourceSet.addDirtyResource(childResource);
			}
		}
	}

	private void handleElementDelete(ModelElement deletedElement) {
		if (!ModelUtil.isSelfContained(deletedElement, true)) {
			throw new IllegalStateException(
				"Element was removed from containment of project but still has cross references!: "
					+ deletedElement.getIdentifier());
		}

		if (!isRecording) {
			return;
		}

		CreateDeleteOperation deleteOperation = OperationsFactory.eINSTANCE.createCreateDeleteOperation();
		deleteOperation.setClientDate(new Date());

		deleteOperation.setDelete(true);
		deleteOperation.setModelElement(ModelUtil.clone(deletedElement));
		deleteOperation.setModelElementId(deletedElement.getModelElementId());

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
	}

	@SuppressWarnings("unchecked")
	private List<ReferenceOperation> extractReferenceOperationsForDelete(ModelElement deletedElement,
		List<CompositeOperation> compositeOperationsToDelete) {
		Set<ModelElementId> allDeletedElementsIds = new HashSet<ModelElementId>();
		for (ModelElement child : deletedElement.getAllContainedModelElements()) {
			allDeletedElementsIds.add(child.getModelElementId());
		}
		allDeletedElementsIds.add(deletedElement.getModelElementId());

		List<AbstractOperation> newOperations = operations.subList(currentOperationListSize, operations.size());
		List<ReferenceOperation> referenceOperationsForDelete = new ArrayList<ReferenceOperation>();
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

	private void reassignModelElementIds(ModelElement copiedElement) {
		ModelUtil.reassignModelElementIds(copiedElement);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.changeTracking.commands.CommandObserver#commandFailed(org.eclipse.emf.common.command.Command,
	 *      org.eclipse.core.runtime.OperationCanceledException)
	 */
	public void commandFailed(Command command, OperationCanceledException exception) {
		// do nothing
		// TODO: rollback operations?
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.changeTracking.commands.CommandObserver#commandStarted(org.eclipse.emf.common.command.Command)
	 */
	public void commandStarted(Command command) {
		currentOperationListSize = projectSpace.getOperations().size();
		currentClipboard = getModelElementsFromClipboard();

	}

	private Set<ModelElement> getModelElementsFromClipboard() {
		Collection<Object> clipboard = editingDomain.getClipboard();
		Set<ModelElement> result = new HashSet<ModelElement>();
		if (clipboard == null) {
			return result;
		}
		for (Object element : clipboard) {
			if (element instanceof ModelElement) {
				result.add((ModelElement) element);
			}
		}
		return result;
	}

}
