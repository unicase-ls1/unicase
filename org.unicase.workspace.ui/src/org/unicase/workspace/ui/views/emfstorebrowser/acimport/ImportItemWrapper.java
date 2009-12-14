/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.acimport;

import java.util.ArrayList;

import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;

/**
 * This class is necessary for at least some import sources, e.g. LDAP. If we do
 * not have more information then a (textual) reference to a specific entry of
 * the source (e.g. an UID in the case of LDAP) then we can save this reference
 * in the sourceObj-field of this class, using it later on to create appropriate
 * ACOrgUnits.
 * 
 * @author deser
 */
public class ImportItemWrapper {

	private Object sourceObj; // holds a (textual or any other) reference to a
								// source object. Most likely a String is
	// needed here
	private ACOrgUnit orgUnit;
	private ImportItemWrapper parentOrgUnit;
	private ArrayList<ImportItemWrapper> childOrgUnits;

	/**
	 * @param sourceObj
	 *            A specific object, which can be used for example to identify
	 *            an import source. For example in the implementation of the
	 *            LDAP import this Object is a String which contains the unique
	 *            name of the LDAP entry.
	 * @param orgUnit
	 *            An orgUnit which is the actual object that gets imported later
	 *            on.
	 */
	public ImportItemWrapper(Object sourceObj, ACOrgUnit orgUnit) {
		super();
		this.sourceObj = sourceObj;
		this.orgUnit = orgUnit;
	}

	/**
	 * @param sourceObj
	 *            A specific object, which can be used for example to identify
	 *            an import source.
	 * @param orgUnit
	 *            An orgUnit which is the actual object that gets imported later
	 *            on.
	 * @param parentOrgUnit
	 *            The parent orgUnit of this object.
	 */
	public ImportItemWrapper(Object sourceObj, ACOrgUnit orgUnit,
			ImportItemWrapper parentOrgUnit) {
		super();
		this.sourceObj = sourceObj;
		this.orgUnit = orgUnit;
		this.parentOrgUnit = parentOrgUnit;
	}

	/**
	 * @return the source object
	 */
	public Object getSourceObj() {
		return sourceObj;
	}

	/**
	 * @return the wrapped orgUnit
	 */
	public ACOrgUnit getOrgUnit() {
		return orgUnit;
	}

	/**
	 * @param parentOrgUnit
	 *            the parent orgUnit of this (wrapped) orgUnit
	 */
	public void setParentOrgUnit(ImportItemWrapper parentOrgUnit) {
		this.parentOrgUnit = parentOrgUnit;
	}

	/**
	 * @return the parent orgUnit of this (wrapped) orgUnit
	 */
	public ImportItemWrapper getParentOrgUnit() {
		return parentOrgUnit;
	}

	/**
	 * @param childOrgUnits
	 *            the children of this (wrapped) orgUnit
	 */
	public void setChildOrgUnits(ArrayList<ImportItemWrapper> childOrgUnits) {
		this.childOrgUnits = childOrgUnits;
	}

	/**
	 * @return the children of this (wrapped) orgUnit
	 */
	public ArrayList<ImportItemWrapper> getChildOrgUnits() {
		return childOrgUnits;
	}

}
