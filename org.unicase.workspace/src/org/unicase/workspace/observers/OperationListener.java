/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.observers;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

/**
 * Operation listeners are added to a project space and informed whenever an operation is executed of undone.
 * 
 * @author hodaie
 */
// TODO Chain use ObserverBus and extends IObserver
public interface OperationListener {

	/**
	 * Operation is executed.
	 * 
	 * @param operation operation
	 */
	void operationExecuted(AbstractOperation operation);

	/**
	 * operation undone.
	 * 
	 * @param operation operation
	 */
	void operationUnDone(AbstractOperation operation);
}
