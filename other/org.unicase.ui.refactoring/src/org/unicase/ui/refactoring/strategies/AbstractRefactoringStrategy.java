/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies;

import java.util.ArrayList;

import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.swt.widgets.Shell;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.validation.refactoring.strategy.RefactoringResult;
import org.unicase.ui.validation.refactoring.strategy.RefactoringStrategy;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.InvalidHandleException;
import org.unicase.workspace.exceptions.UnkownProjectException;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * @author pfeifferc
 */
public abstract class AbstractRefactoringStrategy implements RefactoringStrategy {

	/**
	 * The validation constraint status.
	 */
	private IConstraintStatus status;

	/**
	 * Child model elements created.
	 */
	private ArrayList<ModelElement> childModelElementsCreated;

	/**
	 * Child model elements to be referenced.
	 */
	private ArrayList<ModelElement> childModelElementsReferenced;

	/**
	 * Parent model elements created.
	 */
	private ArrayList<ModelElement> parentModelElementsCreated;

	/**
	 * Parent model elements to be referenced.
	 */
	private ArrayList<ModelElement> parentModelElementsReferenced;

	/**
	 * The shell.
	 */
	private Shell shell;

	/**
	 * The composite operation handle.
	 */
	private static CompositeOperationHandle operationHandle;

	// BEGIN SUPRESS CATCH EXCEPTION

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.validation.refactoring.strategy.RefactoringStrategy#startRefactoring()
	 */
	public RefactoringResult startRefactoring() {
		if(getInvalidModelElement().getProject() == null) {
			WorkspaceUtil.logException("Exception occured while refactoring the project: " +
					"invalid model element has no project", new UnkownProjectException());
			return RefactoringResult.ABORT;
		}
		// storage
		childModelElementsCreated = new ArrayList<ModelElement>();
		childModelElementsReferenced = new ArrayList<ModelElement>();
		parentModelElementsCreated = new ArrayList<ModelElement>();
		parentModelElementsReferenced = new ArrayList<ModelElement>();
		// key, value storage
		RefactoringResult refactoringResult = RefactoringResult.ABORT;
		// start the operations
		startOperations();
		try {
			refactoringResult = performRefactoring();
		} catch (Exception e) {
			WorkspaceUtil.logException("Exception occured while refactoring the project", e);
		} finally {
			if (refactoringResult == RefactoringResult.SUCCESS_CREATE) {
				// end operations composite
				endOperations();
			} else if (refactoringResult == RefactoringResult.NO_VIOLATION) {
				// TODO: implement preference save
				abortOperations();
			} else {
				// abort operations composite
				abortOperations();
			}
		}
		return refactoringResult;
	}

	// END SUPRESS CATCH EXCEPTION

	/**
	 * The abstract method which must be implemented to perform the refactoring.
	 * 
	 * @return true if successful
	 */
	protected abstract RefactoringResult performRefactoring();

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.validation.refactoring.strategy.RefactoringStrategy#getConstraintStatus()
	 */
	public IConstraintStatus getConstraintStatus() {
		return status;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.validation.refactoring.strategy.RefactoringStrategy#setConstraintStatus(org.eclipse.emf.validation.model.IConstraintStatus)
	 */
	public void setConstraintStatus(IConstraintStatus status) {
		this.status = status;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.validation.refactoring.strategy.RefactoringStrategy#getDescription()
	 */
	public abstract String getDescription();

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.validation.refactoring.strategy.RefactoringStrategy#getId()
	 */
	public abstract String getId();

	/**
	 * Start the operations composite.
	 */
	private void startOperations() {
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				operationHandle = WorkspaceManager.getProjectSpace((ModelElement) status.getTarget())
					.beginCompositeOperation();
			}

		}.run();
	}

	/**
	 * Aborts the refactoring operation.
	 */
	private void abortOperations() {
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

	/**
	 * Ends the refactoring operation.
	 */
	private void endOperations() {
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				try {
					operationHandle.end(getId(), "Refactored the project: "+ AbstractRefactoringStrategy.this.getDescription(), ((ModelElement) getConstraintStatus().getTarget())
						.getModelElementId());
				} catch (InvalidHandleException e) {
					WorkspaceUtil.logException("Ending composite operation failed during refactoring.", e);
				}
			}

		}.run();
	}

	/**
	 * @return the child model elements that were referenced
	 */
	public ArrayList<ModelElement> getChildModelElements() {
		return childModelElementsReferenced;
	}

	/**
	 * @return the parent model elements that were referenced
	 */
	public ArrayList<ModelElement> getParentModelElements() {
		return parentModelElementsReferenced;
	}

	/**
	 * @return the child model elements that were created
	 */
	public ArrayList<ModelElement> getChildModelElementsCreated() {
		return childModelElementsCreated;
	}

	/**
	 * @return the parent model elements that were created
	 */
	public ArrayList<ModelElement> getParentModelElementsCreated() {
		return parentModelElementsCreated;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.validation.refactoring.strategy.RefactoringStrategy#setShell(org.eclipse.swt.widgets.Shell)
	 */
	public void setShell(Shell shell) {
		this.shell = shell;
	}

	/**
	 * @return the shell
	 */
	public Shell getShell() {
		return shell;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.validation.refactoring.strategy.RefactoringStrategy#getInvalidModelElement()
	 */
	public ModelElement getInvalidModelElement() {
		return (ModelElement) getConstraintStatus().getTarget();
	}
}
