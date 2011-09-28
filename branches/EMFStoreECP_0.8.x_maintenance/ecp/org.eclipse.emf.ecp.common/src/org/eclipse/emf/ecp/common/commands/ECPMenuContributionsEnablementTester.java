/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen. All rights
 * reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public
 * License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.common.commands;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

/** 
 * Tests the enablement of ECP Menu contributions. The contributions are enabled by default and can be disabled by an extension point.
 * @author koegel
 *
 */
public class ECPMenuContributionsEnablementTester extends PropertyTester {

	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		
		if (expectedValue instanceof Boolean) {
			Boolean menuContributionEnabled = true;
			IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(
				"org.eclipse.emf.ecp.common.menuContributionEnablement");
			if (elements != null && elements.length > 0) {
				IConfigurationElement configurationElement = elements[0];
				menuContributionEnabled = Boolean.parseBoolean(configurationElement.getAttribute("enabled"));
				for (IConfigurationElement child: configurationElement.getChildren()) {
					String commandID = child.getAttribute("commandID");
					menuContributionEnabled = !args[0].equals(commandID);
					if (!menuContributionEnabled) {
						break;
					}
				}
			}
			
			return expectedValue.equals(menuContributionEnabled);
		}
		return false;
	}

}
