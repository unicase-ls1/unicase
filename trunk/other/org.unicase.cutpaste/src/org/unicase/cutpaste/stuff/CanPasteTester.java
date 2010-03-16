/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.cutpaste.stuff;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import org.eclipse.core.expressions.PropertyTester;

/**
 * This property tester checks if the paste handler is active.
 * 
 * @author weiglt
 */
public class CanPasteTester extends PropertyTester {

	private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	private Transferable transferable;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[],
	 *      java.lang.Object)
	 */
	public boolean test(Object receiver, String property, Object[] args, final Object expectedValue) {
		transferable = clipboard.getContents(null);
		return (transferable.isDataFlavorSupported(new DataFlavor(org.unicase.metamodel.ModelElement.class,
			"ModelElement")))
			&& (transferable.isDataFlavorSupported(new DataFlavor(org.unicase.workspace.CompositeOperationHandle.class,
				"CompositeOperationHandle")));
	}
}
