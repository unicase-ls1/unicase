/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.ui;
// BEGIN IGNORE UNNECCESSARY IMPORT
import org.unicase.implementation.operations.InlineClassOperation;
import org.unicase.implementation.operations.OperationsPackage;

/**
 * Handler for the {@link InlineClassOperation}.
 * 
 * @author herrmi
 */
public class InlineClassHandler extends OperationHandlerBase {

	/**
	 * Constructor.
	 */
	public InlineClassHandler() {
		super(OperationsPackage.Literals.INLINE_CLASS_OPERATION);
	}
}
