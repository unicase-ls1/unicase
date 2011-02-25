/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.acimport;

import java.util.ArrayList;

import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;

/**
 * @author deser
 */
public class ImportWrapper {

	private Object sourceObj;
	private ACOrgUnit orgUnit;
	private ImportWrapper parentOrgUnit;
	private ArrayList<ImportWrapper> childOrgUnits;

	/**
	 * @param sourceObj A specific object, which can be used for example to identify an import source. For example in
	 *            the implementation of the LDAP import this Object is a String which contains the unique name of the
	 *            LDAP entry.
	 * @param orgUnit An orgUnit which is the actual object that gets imported later on.
	 */
	public ImportWrapper(Object sourceObj, ACOrgUnit orgUnit) {
		super();
		this.sourceObj = sourceObj;
		this.orgUnit = orgUnit;
	}

	/**
	 * @param sourceObj A specific object, which can be used for example to identify an import source.
	 * @param orgUnit An orgUnit which is the actual object that gets imported later on.
	 * @param parentOrgUnit The parent orgUnit of this object.
	 */
	public ImportWrapper(Object sourceObj, ACOrgUnit orgUnit, ImportWrapper parentOrgUnit) {
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
	 * @param parentOrgUnit the parent orgUnit of this (wrapped) orgUnit
	 */
	public void setParentOrgUnit(ImportWrapper parentOrgUnit) {
		this.parentOrgUnit = parentOrgUnit;
	}

	/**
	 * @return the parent orgUnit of this (wrapped) orgUnit
	 */
	public ImportWrapper getParentOrgUnit() {
		return parentOrgUnit;
	}

	/**
	 * @param childOrgUnits the children of this (wrapped) orgUnit
	 */
	public void setChildOrgUnits(ArrayList<ImportWrapper> childOrgUnits) {
		this.childOrgUnits = childOrgUnits;
	}

	/**
	 * @return the children of this (wrapped) orgUnit
	 */
	public ArrayList<ImportWrapper> getChildOrgUnits() {
		return childOrgUnits;
	}

}
