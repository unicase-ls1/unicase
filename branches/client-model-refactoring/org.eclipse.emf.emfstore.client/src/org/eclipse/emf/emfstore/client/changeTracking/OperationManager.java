package org.eclipse.emf.emfstore.client.changeTracking;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.core.ProjectSpaceControllerInternal;
import org.eclipse.emf.emfstore.client.observers.OperationListener;
import org.eclipse.emf.emfstore.client.observers.PostCreationListener;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.CompositeOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.SemanticCompositeOperation;

public class OperationManager implements OperationRecorderListener {

	private OperationRecorder operationRecorder;
	private List<OperationListener> operationListeners;
	private List<PostCreationListener> postCreationListeners;
	// private CompositeOperation compositeOperation;
	private ProjectSpaceControllerInternal projectSpace;

	public OperationManager(OperationRecorder operationRecorder,
			ProjectSpaceControllerInternal projectSpace) {
		this.operationRecorder = operationRecorder;
		operationRecorder.addOperationRecorderListener(this);
		operationListeners = new ArrayList<OperationListener>();
		postCreationListeners = new ArrayList<PostCreationListener>();
		this.projectSpace = projectSpace;
	}

	/**
	 * Undo the last operation of the projectSpace.
	 */
	public void undoLastOperation() {
		if (!projectSpace.getOperations().isEmpty()) {
			List<AbstractOperation> operations = projectSpace.getOperations();
			AbstractOperation lastOperation = operations
					.get(operations.size() - 1);
			operationRecorder.stopChangeRecording();
			lastOperation.reverse().apply(operationRecorder.getRootEObject());
			notifyOperationUndone(lastOperation);
			operationRecorder.startChangeRecording();
			operations.remove(lastOperation);
		}
		// TODO: EM, update dirty state
		// updateDirtyState();
	}

	public List<EObject> getRemovedElements() {
		return operationRecorder.getRemovedElements();
	}

	/**
	 * 
	 * @param operationListener
	 */
	public void addOperationListener(OperationListener operationListener) {
		operationListeners.add(operationListener);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param operationListner
	 */
	public void removeOperationListener(OperationListener operationListner) {
		operationListeners.remove(operationListner);

	}

	// TODO: EM, changed to public
	public void notifyOperationUndone(AbstractOperation operation) {
		for (OperationListener operationListener : operationListeners) {
			operationListener.operationUnDone(operation);
		}
	}

	/**
	 * Notify the operation observer that an operation has just completed.
	 * 
	 * @param operation
	 *            the operation
	 */
	public void notifyOperationExecuted(AbstractOperation operation) {

		// do not notify on composite start, wait until completion
		if (operation instanceof CompositeOperation) {
			// check of automatic composite, if yes then continue
			if (((CompositeOperation) operation).getMainOperation() == null) {
				return;
			}
		}

		for (OperationListener operationListener : operationListeners) {
			operationListener.operationExecuted(operation);
		}
	}

	// public CompositeOperationHandle beginCompositeOperation() {
	// // notificationRecorder.newRecording();
	// if (this.compositeOperation != null) {
	// throw new IllegalStateException(
	// "Can only have one composite at once!");
	// }
	// this.compositeOperation = OperationsFactory.eINSTANCE
	// .createCompositeOperation();
	// operationRecorder.addOperation(this.compositeOperation);
	// CompositeOperationHandle handle = new CompositeOperationHandle(this,
	// compositeOperation);
	// return handle;
	// }

	/**
	 * Aborts the current composite operation.
	 */
	public void abortCompositeOperation() {
		undoLastOperation();
		operationRecorder.abortCompositeOperation();
	}

	/**
	 * Complete the current composite operation.
	 */
	public void endCompositeOperation() {
		notifyOperationExecuted(operationRecorder.getCompositeOperation());
		operationRecorder.endCompositeOperation();
	}

	/**
	 * Replace and complete the current composite operation.
	 * 
	 * @param semanticCompositeOperation
	 *            the semantic operation that replaces the composite operation
	 */
	public void endCompositeOperation(
			SemanticCompositeOperation semanticCompositeOperation) {
		List<AbstractOperation> operations = projectSpace.getOperations();
		operations.remove(operations.size() - 1);
		operations.add(semanticCompositeOperation);
		endCompositeOperation();
	}

	public CompositeOperationHandle beginCompositeOperation() {
		return operationRecorder.beginCompositeOperation();
	}

	// TODO: EM
	// private void notifyPostCreationListeners(EObject modelElement) {
	// // do not record changes since the creation listeners may only change
	// // attributes
	// boolean wasRecording = isRecording;
	// if (isRecording) {
	// stopChangeRecording();
	// }
	// for (PostCreationListener l : postCreationListeners) {
	// l.onCreation(projectSpace, modelElement);
	// }
	// if (wasRecording) {
	// startChangeRecording();
	// }
	// }

	public void operationRecorded(AbstractOperation operation) {
		projectSpace.addOperation(operation);
	}

	public void clearOperations() {
		operationRecorder.clearOperations();
	}
}
