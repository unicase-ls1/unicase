/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.impl;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;
import org.unicase.model.util.ModelUtil;
import org.unicase.model.util.ProjectChangeObserver;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.changeTracking.NotificationToOperationConverter;
import org.unicase.workspace.changeTracking.notification.NotificationInfo;
import org.unicase.workspace.changeTracking.notification.filter.FilterStack;
import org.unicase.workspace.changeTracking.notification.filter.NotificationFilter;
import org.unicase.workspace.changeTracking.notification.recording.NotificationRecorder;
import org.unicase.workspace.changeTracking.notification.recording.NotificationRecordingHint;
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
	private boolean isDeleting;

	/**
	 * Constructor.
	 * 
	 * @param projectSpace the project space the change tracker is operating on.
	 */
	public ProjectChangeTracker(ProjectSpaceImpl projectSpace) {
		this.projectSpace = projectSpace;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementAdded(org.unicase.model.Project,
	 *      org.unicase.model.ModelElement)
	 */
	public void modelElementAdded(Project project, ModelElement modelElement) {
		projectSpace.addToResource(modelElement);
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
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementDeleteCompleted(org.unicase.model.Project,
	 *      org.unicase.model.ModelElement)
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
			projectSpace.notifyOperationExecuted(deleteOperation);
			deleteOperation = null;

			Resource resource = modelElement.eResource();
			if (resource != null) {
				resource.getContents().remove(modelElement);
				projectSpace.saveResource(resource);
			}
			for (ModelElement child : modelElement.getAllContainedModelElements()) {
				Resource childResource = child.eResource();
				if (childResource != null) {
					childResource.getContents().remove(child);
					projectSpace.saveResource(childResource);
				}
			}

		}
		this.isDeleting = false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementDeleteStarted(org.unicase.model.Project,
	 *      org.unicase.model.ModelElement)
	 */
	public void modelElementDeleteStarted(Project project, ModelElement modelElement) {
		isDeleting = true;
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
	 * @see org.unicase.model.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification,
	 *      org.unicase.model.Project, org.unicase.model.ModelElement)
	 */
	public void notify(Notification notification, Project project, ModelElement modelElement) {
		if (isRecording) {
			notificationRecorder.record(notification);
			if (notificationRecorder.isRecordingComplete()) {
				recordingFinished();
			}
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

		// if this model element is the one to be deleted and if it is not in a separate resource
		if (resource == null && modelElement.getProject() == null && this.isDeleting) {
			return;
		}
		if (resource == null) {
			String message = "Save failed: ModelElement \"" + modelElement.getIdentifier() + "\" has no resource!";
			WorkspaceUtil.logWarning(message, new IllegalStateException(message));
			return;
		}
		try {
			resource.save(Configuration.getResourceSaveOptions());
		} catch (IOException e) {
			String message = "Save failed: ModelElement \"" + modelElement.getIdentifier();
			WorkspaceUtil.logException(message, e);
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
	 * Completes the current composite operation.
	 */
	public void endCompositeOperation() {
		projectSpace.notifyOperationExecuted(compositeOperation);
		this.compositeOperation = null;
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
}
