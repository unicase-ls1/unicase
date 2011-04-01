/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.navigator;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

/**
 * Property tester to test if a given menu configuration action is enabled.
 * 
 * @author koegel
 */
public class MenuConfigurationEnablementTester extends PropertyTester {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[],
	 *      java.lang.Object)
	 */
	public boolean test(Object receiver, String property, Object[] args, final Object expectedValue) {
		if (expectedValue instanceof Boolean && args.length == 1 && args[0] instanceof String) {
			IConfigurationElement[] rawExtensions = Platform.getExtensionRegistry().getConfigurationElementsFor(
				"org.eclipse.emf.ecp.navigator.menuconfiguration");
			for (IConfigurationElement extension : rawExtensions) {
				if (extension.getName().equals(args[0])) {
					String isEnabled = extension.getAttribute("enabled");
					if (isEnabled != null && isEnabled.equals("false")) {
						return !((Boolean) expectedValue).booleanValue();
					}
				}
			}
		}
		return ((Boolean) expectedValue).booleanValue();
	}

}
