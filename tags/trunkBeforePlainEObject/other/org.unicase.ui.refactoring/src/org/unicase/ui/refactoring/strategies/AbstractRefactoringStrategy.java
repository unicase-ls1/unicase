/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.swt.widgets.Shell;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.commands.ECPCommand;
import org.unicase.ui.validation.refactoring.RefactoringResult;
import org.unicase.ui.validation.refactoring.RefactoringStrategy;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.InvalidHandleException;
import org.unicase.workspace.exceptions.UnkownProjectException;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * @author pfeifferc
 */
public abstract class AbstractRefactoringStrategy implements RefactoringStrategy {

	// VALIDATION data objects

	/**
	 * The validation constraint status.
	 */
	private IConstraintStatus constraintStatus;

	/**
	 * The validation constraint status.
	 */
	private EStructuralFeature invalidStructuralFeature;

	// REFACTORING data objects

	/**
	 * ID of the {@link RefactoringStrategy}.
	 */
	private String id;

	/**
	 * Description of the {@link RefactoringStrategy}.
	 */
	private String description;

	/**
	 * Name of the {@link RefactoringStrategy}.
	 */
	private String name;
	
	/**
	 * Child model elements created.
	 */
	private List<EObject> childModelElementsCreated;

	/**
	 * Child model elements to be referenced.
	 */
	private List<EObject> childModelElementsReferenced;

	/**
	 * Parent model elements created.
	 */
	private List<EObject> parentModelElementsCreated;

	/**
	 * Parent model elements to be referenced.
	 */
	private List<EObject> parentModelElementsReferenced;

	// UI objects

	/**
	 * The shell.
	 */
	private Shell shell;

	// OPERATION objects

	/**
	 * The composite operation handle.
	 */
	private static CompositeOperationHandle operationHandle;

	// BEGIN SUPRESS CATCH EXCEPTION

	/* (non-Javadoc)
	 * @see org.unicase.ui.refactoring.strategies.RefactoringStrategy#startRefactoring()
	 */
	public RefactoringResult startRefactoring() {
		RefactoringResult refactoringResult = RefactoringResult.ABORT;
		if (((ModelElement) getInvalidEObject()).getProject() == null) {
			WorkspaceUtil.logException("Exception occured while refactoring the project: "
				+ "invalid model element has no project", new UnkownProjectException());
			return refactoringResult;
		}
		// storage
		childModelElementsCreated = new ArrayList<EObject>();
		childModelElementsReferenced = new ArrayList<EObject>();
		parentModelElementsCreated = new ArrayList<EObject>();
		parentModelElementsReferenced = new ArrayList<EObject>();
		// key, value storage
		// start the operations
		startOperations();
		try {
			if(operationHandle == null) {
				throw new OperationCanceledException("Operation handle null, aborting...");
			}
			refactoringResult = performRefactoring();
		} catch (Exception e) {
			WorkspaceUtil.logException("Exception occured while refactoring the project", e);
		} finally {
			if(operationHandle == null) {
				return refactoringResult;
			}
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
	 * Start the operations composite.
	 */
	private void startOperations() {
		new ECPCommand(getInvalidEObject()) {

			@Override
			protected void doRun() {
				operationHandle = WorkspaceManager.getProjectSpace((ModelElement) getConstraintStatus().getTarget())
					.beginCompositeOperation();
			}
		}.run();
	}

	/**
	 * Aborts the refactoring operation.
	 */
	private void abortOperations() {
		new ECPCommand(getInvalidEObject()) {

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
		new ECPCommand(getInvalidEObject()) {

			@Override
			protected void doRun() {
				try {
					operationHandle.end(getId(), "Refactored the project: "
						+ AbstractRefactoringStrategy.this.getDescription(), ((ModelElement) getConstraintStatus()
						.getTarget()).getModelElementId());
				} catch (InvalidHandleException e) {
					WorkspaceUtil.logException("Ending composite operation failed during refactoring.", e);
				}
			}

			private String getId() {
				// TODO Auto-generated method stub
				return null;
			}

		}.run();
	}

	/**
	 * @return getChildModelElements
	 */
	public List<EObject> getChildModelElements() {
		return childModelElementsReferenced;
	}
	
	/**
	 * 
	 * @return getParentModelElements
	 */
	public List<EObject> getParentModelElements() {
		return parentModelElementsReferenced;
	}
	
	/**
	 * @return getChildModelElementsCreated
	 */
	public List<EObject> getChildModelElementsCreated() {
		return childModelElementsCreated;
	}

	/**
	 * @return getParentModelElementsCreated
	 */
	public List<EObject> getParentModelElementsCreated() {
		return parentModelElementsCreated;
	}

	/**
	 * Set shell.
	 * @param shell {@link Shell}
	 */
	public void setShell(Shell shell) {
		this.shell = shell;
	}

	/**
	 * @return shell
	 */
	public Shell getShell() {
		return shell;
	}

	/**
	 * @return getInvalidEObject
	 */
	public EObject getInvalidEObject() {
		return (ModelElement) getConstraintStatus().getTarget();
	}

	/**
	 * @return getConstraintStatus
	 */
	public IConstraintStatus getConstraintStatus() {
		return constraintStatus;
	}

	/**
	 * @param constraintStatus {@link IConstraintStatus}
	 */
	public void setConstraintStatus(IConstraintStatus constraintStatus) {
		this.constraintStatus = constraintStatus;
	}

	/**
	 * @param invalidStructuralFeature {@link EStructuralFeature}
	 */
	public void setInvalidStructuralFeature(EStructuralFeature invalidStructuralFeature) {
		this.invalidStructuralFeature = invalidStructuralFeature;
	}

	/**
	 * @return getInvalidStructuralFeature
	 */
	public EStructuralFeature getInvalidStructuralFeature() {
		return invalidStructuralFeature;
	}

	/**
	 * @param name the
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param description the
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return getDescription
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param id the
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return getId
	 */
	public String getId() {
		return id;
	}
}