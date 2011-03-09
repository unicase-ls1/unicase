/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.templates;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.swt.widgets.Shell;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.validation.refactoring.RefactoringResult;
import org.unicase.ui.validation.refactoring.RefactoringStrategy;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.InvalidHandleException;
import org.unicase.workspace.exceptions.UnkownProjectException;
import org.unicase.workspace.util.UnicaseCommandWithResult;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * @author pfeifferc
 */
public abstract class UnicaseRefactoringStrategy implements RefactoringStrategy {

	// VALIDATION data objects

	/**
	 * The validation constraint status.
	 */
	private Set<IConstraintStatus> constraintStati;

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

	private EObject invalidEObject;

	private ProjectSpace projectSpace;

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
		return new UnicaseCommandWithResult<RefactoringResult>() { 

			@Override
			public RefactoringResult doRun() {
				RefactoringResult refactoringResult = RefactoringResult.ABORT;
				projectSpace = null;
				if(getInvalidEObject() instanceof ProjectSpace) {
					projectSpace = ((ProjectSpace) getInvalidEObject());
				} else if (getInvalidEObject() instanceof UnicaseModelElement) {
					projectSpace = WorkspaceManager.getProjectSpace((UnicaseModelElement) getInvalidEObject());
				} else if (getInvalidEObject() instanceof Project) {
					projectSpace = WorkspaceManager.getProjectSpace((Project) getInvalidEObject());
				}
				if (projectSpace == null) {
					WorkspaceUtil.logException("Exception occured while refactoring the project: "
							+ "invalid model element has no project", new UnkownProjectException());
					return refactoringResult;
				}
				// storage
				childModelElementsCreated = new ArrayList<EObject>();
				childModelElementsReferenced = new ArrayList<EObject>();
				parentModelElementsCreated = new ArrayList<EObject>();
				parentModelElementsReferenced = new ArrayList<EObject>();
				try {
					// start the operations
					startOperations();
					if(operationHandle == null) {
						throw new OperationCanceledException("Operation handle null, aborting...");
					}
					refactoringResult = performRefactoring();
				} catch (Exception e) {
					WorkspaceUtil.logException("Exception occured while refactoring the project", e);
				} finally {
					if(operationHandle == null || !operationHandle.isValid()) {
						return refactoringResult;
					}
					if (refactoringResult == RefactoringResult.SUCCESS_CREATE) {
						// end operations composite
						endOperations();
					} else {
						// abort operations composite
						abortOperations();
					}
				}
				return refactoringResult;
			}
		}.run();
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
		operationHandle = projectSpace.beginCompositeOperation();
	}

	/**
	 * Aborts the refactoring operation.
	 */
	private void abortOperations() {
		try {
			operationHandle.abort();
		} catch (InvalidHandleException e) {
			WorkspaceUtil.logException("Aborting composite operation failed during refactoring.", e);
		}
	}

	/**
	 * Ends the refactoring operation.
	 * @return 
	 */
	private boolean endOperations() {
		try {
			operationHandle.end(getId(), "Refactored the project: "
					+ UnicaseRefactoringStrategy.this.getDescription(), null);
			return true;
		} catch (InvalidHandleException e) {
			WorkspaceUtil.logException("Ending composite operation failed during refactoring.", e);
			return false;
		}
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
	 * {@inheritDoc}
	 */
	public void setInvalidEObject(EObject invalidEObject) {
		this.invalidEObject = invalidEObject;
	}

	/**
	 * {@inheritDoc}
	 */
	public EObject getInvalidEObject() {
		return invalidEObject;
	}

	/**
	 * @return getInvalidStructuralFeature
	 */
	public EStructuralFeature getFirstInvalidStructuralFeature() {
		IConstraintStatus constraintStatus = getConstraintStati().iterator().next();
		for(EObject eObject: constraintStatus.getResultLocus()) {
			if(eObject instanceof EStructuralFeature) {
				return (EStructuralFeature) eObject;
			}
		}
		return null;
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

	/**
	 * @return projectSpace
	 */
	public ProjectSpace getProjectSpace() {
		return projectSpace;
	}

	/**
	 * {@inheritDoc}
	 */
	public Set<IConstraintStatus> getConstraintStati() {
		return constraintStati;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setConstraintStati(Set<IConstraintStatus> constraintStati) {
		this.constraintStati = constraintStati;
	}
}