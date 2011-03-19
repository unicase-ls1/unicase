/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.exceptions;

import java.util.List;

import org.eclipse.emf.emfstore.client.ProjectSpace;
import org.unicase.emfstore.conflictDetection.ConflictDetector;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;

/**
 * Represents the exception that there are conflicting changes.
 * 
 * @author koegel
 */
@SuppressWarnings("serial")
public class ChangeConflictException extends WorkspaceException {

	private List<ChangePackage> newPackages;
	private ProjectSpace projectSpace;
	private ConflictDetector conflictDetector;

	/**
	 * Retrieve the list of change packages that caused the exception.
	 * 
	 * @return the list
	 */
	public List<ChangePackage> getNewPackages() {
		return newPackages;
	}

	/**
	 * Constructor.
	 * 
	 * @param newPackages the list of change packages that caused the exception
	 * @param conflictDetector the ConflictDetector
	 * @param projectSpace the ProjectSpace
	 */
	public ChangeConflictException(List<ChangePackage> newPackages, ProjectSpace projectSpace,
		ConflictDetector conflictDetector) {
		super("Conflict detected on update");
		this.newPackages = newPackages;
		this.projectSpace = projectSpace;
		this.conflictDetector = conflictDetector;
	}

	/**
	 * @return the ConflictDetector.
	 */
	public ConflictDetector getConflictDetector() {
		return conflictDetector;
	}

	/**
	 * @return the ProjectSpace.
	 */
	public ProjectSpace getProjectSpace() {
		return projectSpace;
	}
}
