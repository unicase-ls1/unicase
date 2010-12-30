/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholderview.roles;

import java.util.List;

/**
 * Abstract class for the role access data.
 * @author kterzieva
 *
 */
public abstract class RoleDataAccessObject {

	private String name;
	private List<String> reviewSet;
	private List<String> filterSet;
	private final String roleId;

	/**
	 * The construct.
	 * @param roleId the role
	 */
	protected RoleDataAccessObject(String roleId){
		this.roleId = roleId;
	}

	
	/**
	 * Gets the name.
	 * @return name the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * @param name the name
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the element set for the review view.
	 * @return reviewSet the review set
	 */
	public List<String> getReviewSet() {
		return reviewSet;
	}
	
	/**
	 * Sets the element set for the review view.
	 * @param reviewSet the review set
	 */
	public void setReviewSet(List<String> reviewSet) {
		this.reviewSet = reviewSet;
	}

	/**
	 * Gets the filter set.
	 * @return filterSet the filter set
	 */
	public List<String> getFilterSet() {
		return filterSet;
	}

	/**
	 * Gets the filter set.
	 * @param filterSet the filter set
	 */
	public void setFilterSet(List<String> filterSet) {
		this.filterSet = filterSet;
	}

	/**
	 * Loads the data for a role.
	 */
	
	public abstract void load();
	
	/**
	 * Saves the data for a role.
	 */
	public abstract void save();

	/**
	 * Gets the role.
	 * @return roleId the role
	 */
	public String getRoleId() {
		return roleId;
	}
}
