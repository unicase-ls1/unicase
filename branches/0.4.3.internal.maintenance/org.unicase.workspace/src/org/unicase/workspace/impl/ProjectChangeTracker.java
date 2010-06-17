/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.impl;

import java.io.File;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
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
import org.unicase.workspace.changeTracking.notification.NotificationInfo;
import org.unicase.workspace.changeTracking.notification.filter.FilterStack;
import org.unicase.workspace.changeTracking.notification.filter.NotificationFilter;
import org.unicase.workspace.changeTracking.notification.recording.NotificationRecorder;
import org.unicase.workspace.changeTracking.notification.recording.NotificationRecordingHint;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Tracks changes on a project that is contained in a project space.
 * 
 * @author koegel
 */
public class ProjectChangeTracker implements ProjectChangeObserver {

	private final ProjectSpaceImpl projectSpace;
	private boolean isRecording;
	private NotificationRecorder notificationRecorder;
	private CreateDeleteOperation deleteOperation;
	private CompositeOperation compositeOperation;

	/**
	 * Name of unknown creator.
	 */
	public static final String UNKOWN_CREATOR = "unknown";
	private DirtyResourceSet dirtyResourceSet;

	/**
	 * Constructor.
	 * 
	 * @param projectSpace the project space the change tracker is operating on.
	 */
	public ProjectChangeTracker(ProjectSpaceImpl projectSpace) {
		this.projectSpace = projectSpace;
		this.isRecording = false;
		dirtyResourceSet = new DirtyResourceSet();
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
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				addElementToResouce(modelElement);
			}
		}.run();
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
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#modelElementDeleteCompleted(org.unicase.metamodel.Project,
	 *      org.unicase.metamodel.ModelElement)
	 */
	public void modelElementDeleteCompleted(Project project, ModelElement modelElement) {
		if (isRecording) {

			notificationRecorder.stopRecording();
			recordingFinished();

			if (deleteOperation == null) {
				throw new IllegalStateException("DeleteCompleted called without previous delete start call");
			}
			deleteOperation.setDelete(true);
			deleteOperation.setModelElement(ModelUtil.clone(modelElement));
			deleteOperation.setModelElementId(modelElement.getModelElementId());

			if (this.compositeOperation != null) {
				this.compositeOperation.getSubOperations().add(deleteOperation);
				projectSpace.saveResource(compositeOperation.eResource());
			} else {
				projectSpace.addOperation(deleteOperation);
			}

			deleteOperation = null;

			Resource resource = modelElement.eResource();
			if (resource != null) {
				resource.getContents().remove(modelElement);
				dirtyResourceSet.addDirtyResource(resource);
			}
			for (ModelElement child : modelElement.getAllContainedModelElements()) {
				Resource childResource = child.eResource();
				if (childResource != null) {
					childResource.getContents().remove(child);
					dirtyResourceSet.addDirtyResource(childResource);
				}
			}

		}
		dirtyResourceSet.save();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#modelElementDeleteStarted(org.unicase.metamodel.Project,
	 *      org.unicase.metamodel.ModelElement)
	 */
	public void modelElementDeleteStarted(Project project, ModelElement modelElement) {
		if (isRecording) {
			this.deleteOperation = OperationsFactory.eINSTANCE.createCreateDeleteOperation();
			deleteOperation.setClientDate(new Date());
			notificationRecorder.newRecording(NotificationRecordingHint.DELETE);
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
		save(modelElement);
		if (notificationRecorder.isRecordingComplete()) {
			if (isRecording) {
				recordingFinished();
			}
			dirtyResourceSet.save();
		}
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

		// add resulting operations as suboperations to composite, delete or top-level operations
		// handle delete, verify reference operations only
		if (deleteOperation != null) {
			// check, that all ops are reference ops
			for (AbstractOperation op : ops) {
				if (op instanceof ReferenceOperation) {
					deleteOperation.getSubOperations().add((ReferenceOperation) op);
				} else {
					WorkspaceUtil.log("NON-REFERNCE OP AS SUBOP OF A DELETE OPERATION DETECTED: "
						+ op.getClass().getCanonicalName(), null, 0);
				}
			}

		} else if (compositeOperation != null) {
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
		// TODO Auto-generated method stub

	}
}
