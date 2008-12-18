/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.exceptions;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;

/**
 * Represents the exception that there are conflicting changes.
 * @author koegel
 *
 */
@SuppressWarnings("serial")
public class ChangeConflictException extends WorkspaceException {
	
	private List<ChangePackage> newPackages;
	
	/**
	 * Retrieve the list of change packages that caused the exception.
	 * @return the list
	 */
	public List<ChangePackage> getNewPackages() {
		return newPackages;
	}

	/**
	 * Constructor.
	 * @param newPackages the list of change packages that caused the exception
	 */
	public ChangeConflictException(List<ChangePackage> newPackages) {
		super("Conflict detected on update");
		this.newPackages = newPackages;
	}
}
