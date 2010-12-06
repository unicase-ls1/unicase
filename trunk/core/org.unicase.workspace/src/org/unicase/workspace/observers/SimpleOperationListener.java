/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.observers;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.workspace.ProjectSpace;

/**
 * Clients (like GUI classes) who are not interested if an operation has been run forward or backward (i.e. undone) can
 * use this add this listener to project space.
 * 
 * @author hodaie
 */
// TODO Chain use ObserverBus and extends IObserver
public abstract class SimpleOperationListener implements OperationListener, CommitObserver {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.OperationListener#operationExecuted(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	public void operationExecuted(AbstractOperation operation) {
		operationPerformed(operation);

	}

	/**
	 * {@inheritDoc} When a project is committed all operations in project space are cleared and there are no modified
	 * model elements. This is of interest for GUI elements to updated their state. Note: in this case the operation is
	 * NULL!
	 * 
	 * @see org.unicase.workspace.observers.CommitObserver#commitCompleted(org.unicase.workspace.ProjectSpace,
	 *      org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec)
	 */
	public void commitCompleted(ProjectSpace projectSpace, PrimaryVersionSpec newRevision) {
		operationPerformed(null);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.CommitObserver#inspectChanges(org.unicase.workspace.ProjectSpace,
	 *      org.unicase.emfstore.esmodel.versioning.ChangePackage)
	 */
	public boolean inspectChanges(ProjectSpace projectSpace, ChangePackage changePackage) {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.OperationListener#operationUnDone(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	public void operationUnDone(AbstractOperation operation) {
		operationPerformed(operation.reverse());

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param operation
	 */
	public abstract void operationPerformed(AbstractOperation operation);

}
