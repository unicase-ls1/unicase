/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.ui.commands;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.jface.viewers.TreeNode;

/**
 * Tests if the value of the tree node is instance of the given class.
 * 
 * @author shterev
 */
public class TreeNodeClassTester extends PropertyTester {

	/**
	 * {@inheritDoc}
	 * 
	 */
	public boolean test(Object receiver, String property, Object[] args, final Object expectedValue) {
		if (receiver instanceof TreeNode) {
			TreeNode node = (TreeNode) receiver;
			Class<?> clazz;
			try {
				clazz = Class.forName((String)expectedValue);
				if(clazz.isAssignableFrom(node.getValue().getClass())){
					return true;
				}
			} catch (ClassNotFoundException e) {
				return false;
			}
		}
		return false;

	}

}
