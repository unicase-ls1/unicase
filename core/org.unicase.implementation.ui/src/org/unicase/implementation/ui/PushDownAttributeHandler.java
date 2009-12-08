/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.ui;

import org.unicase.implementation.operations.OperationsPackage;
// BEGIN IGNORE UNNECCESSARY IMPORT
import org.unicase.implementation.operations.PushDownAttributeOperation;
// END IGNORE UNNECCESSARY IMPORT

/**
 * Handler for {@link PushDownAttributeOperation}.
 * 
 * @author herrmi
 */
public class PushDownAttributeHandler extends OperationHandlerBase {

	/**
	 * Constructor.
	 */
	public PushDownAttributeHandler() {
		super(OperationsPackage.Literals.PUSH_DOWN_ATTRIBUTE_OPERATION);
	}

}
