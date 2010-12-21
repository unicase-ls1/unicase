/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholderview.roles;

import org.eclipse.jface.viewers.ViewerFilter;

/**
 * The abstract class for stakeholder role.
 * 
 * @author kterzieva
 */

public abstract class StakeholderRole {
	
	private String name;
	
	/**
	 * Gets the filter for filtering the content of the specific role.
	 * 
	 * @return name the name of the stakeholder role
	 */
	
	public abstract ViewerFilter getViewerFilter();

	/**
	 * Sets the name of the stakeholder role.
	 * @param name the name
	 */
	final void setName(String name){
		this.name = name;
	}
	
	/**
	 * Gets the name of the role.
	 * 
	 * @return name the name of the stakeholder role
	 */
	public String getName(){
		return name;
	}
}
