/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;

/**
 * Represents an exception when invoking an operation on an EObject.
 * 
 * @author koegel
 */
@SuppressWarnings("serial")
public class OperationInvocationException extends Exception {

	/**
	 * Constructor.
	 * 
	 * @param eObject the eObject to invoke the operation on.
	 * @param operation the operation
	 * @param cause the underlying exception
	 */
	public OperationInvocationException(EObject eObject, EOperation operation, Exception cause) {
		super("Invoking the operation " + operation.getName() + " on the EObject " + eObject.toString() + " of type "
			+ eObject.eClass().getName() + " failed!", cause);
	}
}
