/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.impl;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;

/**
 * Saves a list of changes to a specified location.
 * 
 * @author Adrian Staudt
 */
public class ChangeOperationSaver {

	private boolean autoSave;

	/**
	 * Indicates whether a resource may be split when a model element has been added.
	 */
	private boolean splitResource;

	public ChangeOperationSaver() {
		this.autoSave = true;
		this.splitResource = true;

	}

	public void save(List<ChangePackage> changePackages) {

	}

	/**
	 * Enable or disable save. I save is disabled, dirty resources will not bes saved.
	 * 
	 * @param newValue true if auto save should be enabled
	 */
	public void setAutoSave(boolean newValue) {
		autoSave = newValue;
	}

	/**
	 * Sets whether a resource split may occur when a model element is added.
	 * 
	 * @param splitResource whether resource splitting should occur
	 */
	public void setSplitResource(boolean splitResource) {
		this.splitResource = splitResource;
	}

	/**
	 * Determines whether resource splitting is enabled.
	 * 
	 * @return true, if resource splitting may occur
	 */
	public boolean isSplitResource() {
		return splitResource;
	}

	public void saveDirtyResources() {
		// TODO Auto-generated method stub

	}
}
