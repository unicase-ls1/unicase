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

import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;

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
