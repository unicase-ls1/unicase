package org.unicase.ui.validation.refactoring.strategy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.swt.widgets.Shell;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.InvalidHandleException;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

public abstract class AbstractRefactoringStrategy {

	private String id;
	private IConstraintStatus status;
	private static CompositeOperationHandle operationHandle;

	// BEGIN SUPPRESS CATCH EXCEPTION

	public void startRefactoring(Shell shell) {
		boolean success = false;
		// start the operations
		startOperations();
		try {
			success = performRefactoring(shell);
		} catch (Exception e) {
			WorkspaceUtil.logException("There was an exception", e);
		} finally {
			if (success) {
				endOperations();
			} else {
				abortOperations();
			}
		}
	}

	// END SUPPRESS CATCH EXCEPTION

	public abstract boolean performRefactoring(Shell shell);

	public IConstraintStatus getConstraintStatus() {
		return status;
	}

	public void setConstraintStatus(IConstraintStatus status) {
		this.status = status;
	}

	public abstract String getDescription();

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void startOperations() {
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				operationHandle = WorkspaceManager.getProjectSpace(status.getTarget()).beginCompositeOperation();
			}

		}.run();
	}

	public void abortOperations() {
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				try {
					operationHandle.abort();
				} catch (InvalidHandleException e) {
					WorkspaceUtil.logException("Aborting composite operation failed during refactoring.", e);
				}
			}

		}.run();
	}

	public void endOperations() {
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				try {
					EObject target = (getConstraintStatus().getTarget());
					ModelElementId targetId = ModelUtil.getProject(target).getModelElementId(target);
					operationHandle.end(getId(), getDescription(), targetId);
				} catch (InvalidHandleException e) {
					WorkspaceUtil.logException("Ending composite operation failed during refactoring.", e);
				}
			}

		}.run();
	}
}
