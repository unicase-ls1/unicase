/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.model.observers;

import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;

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
	 * @see org.eclipse.emf.emfstore.client.model.observers.OperationListener#operationExecuted(org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation)
	 */
	public void operationExecuted(AbstractOperation operation) {
		operationPerformed(operation);

	}

	/**
	 * {@inheritDoc} When a project is committed all operations in project space are cleared and there are no modified
	 * model elements. This is of interest for GUI elements to updated their state. Note: in this case the operation is
	 * NULL!
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.observers.CommitObserver#commitCompleted(org.eclipse.emf.emfstore.client.model.ProjectSpace,
	 *      org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec)
	 */
	public void commitCompleted(ProjectSpace projectSpace, PrimaryVersionSpec newRevision) {
		operationPerformed(null);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.observers.CommitObserver#inspectChanges(org.eclipse.emf.emfstore.client.model.ProjectSpace,
	 *      org.eclipse.emf.emfstore.server.model.versioning.ChangePackage)
	 */
	public boolean inspectChanges(ProjectSpace projectSpace, ChangePackage changePackage) {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.observers.OperationListener#operationUnDone(org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation)
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
