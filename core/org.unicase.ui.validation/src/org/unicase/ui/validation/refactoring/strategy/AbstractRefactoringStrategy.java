/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.validation.refactoring.strategy;

import java.util.ArrayList;

import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.swt.widgets.Shell;
import org.unicase.metamodel.ModelElement;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.InvalidHandleException;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * 
 * @author pfeifferc
 *
 */
public abstract class AbstractRefactoringStrategy {

	/**
	 * The validation constraint status.
	 */
	private IConstraintStatus status;

	/**
	 * Child model elements to be created.
	 */
	private ArrayList<ModelElement> childModelElementsCreated;

	/**
	 * Child model elements to be referenced.
	 */
	private ArrayList<ModelElement> childModelElementsReferenced;

	/**
	 * Parent model elements to be created.
	 */
	private ArrayList<ModelElement> parentModelElementsCreated;

	/**
	 * Parent model elements to be referenced.
	 */
	private ArrayList<ModelElement> parentModelElementsReferenced;
	
	
	
	
	private String id;
	/**
	 * The shell.
	 */
	private Shell shell;
	private static CompositeOperationHandle operationHandle;

	// BEGIN SUPRESS CATCH EXCEPTION

	/**
	 * This will start the refactoring.
	 * 
	 * @param shell the
	 */
	public void startRefactoring() {
		// storage
		childModelElementsCreated = new ArrayList<ModelElement>();
		childModelElementsReferenced = new ArrayList<ModelElement>();
		parentModelElementsCreated = new ArrayList<ModelElement>();
		parentModelElementsReferenced = new ArrayList<ModelElement>();
		// key, value storage
		boolean success = false;
		// start the operations
		startOperations();
		try {
			success = performRefactoring();
		} catch (Exception e) {
			WorkspaceUtil.logException("There was an exception", e);
		} finally {
			if(success) {
				endOperations();
			} else {
				abortOperations();
			}
		}
	}

	// END SUPRESS CATCH EXCEPTION

	/**
	 * The abstract method which must be implemented to perform the refactoring.
	 * 
	 * @return true if successful
	 */
	public abstract boolean performRefactoring();
	
	/**
	 * @return the constraint status
	 */
	public IConstraintStatus getConstraintStatus() {
		return status;
	}

	/**
	 * @param status the
	 */
	public void setConstraintStatus(IConstraintStatus status) {
		this.status = status;
	}

	/**
	 * @return the description
	 */
	public abstract String getDescription();

	/**
	 * @param id he
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Start the operations composite.
	 */
	public void startOperations() {
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				operationHandle = WorkspaceManager.getProjectSpace((ModelElement) status.getTarget()).beginCompositeOperation();
			}

		}.run();
	}

	/**
	 * Aborts the refactoring operation.
	 */
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

	/**
	 * Ends the refactoring operation.
	 */
	public void endOperations() {
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				try {
					operationHandle.end(getId(), getDescription(),
							((ModelElement) getConstraintStatus().getTarget()).getModelElementId());
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
	 * @param shell the
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
}
