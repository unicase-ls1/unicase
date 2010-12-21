/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.urml.stakeholderview.roles;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.unicase.metamodel.util.ModelUtil;

/**
 * Class for reading the content of the stakeholder role extension point.
 * 
 * @author kterzieva
 */

public class StakeholderRegistry {

	
	private static final String EXTENSION_POINT_ID = "org.unicase.stakeholders.roles";

	private List<StakeholderRole> roles = new ArrayList<StakeholderRole>();
	
	/**
	 * The construct.
	 * @author kterzieva
	 * 
	 */
	public StakeholderRegistry() {
		init();
	}
	
	private void init(){
		IConfigurationElement[] registeredRoles = Platform.getExtensionRegistry().getConfigurationElementsFor(
		EXTENSION_POINT_ID);
		for (IConfigurationElement e : registeredRoles) {
			String name = e.getAttribute("name");
			try {
				
				StakeholderRole role = (StakeholderRole) e.createExecutableExtension("class");
				role.setName(name);
				
				roles.add(role);

			} catch (CoreException e2) {
				ModelUtil.logException(e2);
			}
		}
	}

	/**
	 * Gets the stakeholder roles.
	 * @return the roles
	 */
	public List<StakeholderRole> getRoles() {
		return roles;
	}
}
