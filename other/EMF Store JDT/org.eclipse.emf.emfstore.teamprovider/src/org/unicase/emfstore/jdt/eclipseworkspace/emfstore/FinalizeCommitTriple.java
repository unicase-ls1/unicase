/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.unicase.emfstore.jdt.eclipseworkspace.emfstore;

import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.ui.commands.CommitProjectHandler;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;

/**
 * This class carries three information. The CommitProjectHandler that involved the prepare commit phase. The involved
 * ProjectSpace and the ChangePacke that has to be finally committed.
 * 
 * @author Adrian Staudt
 */
public class FinalizeCommitTriple {

	private final CommitProjectHandler commitProjectHandler;
	private final ProjectSpace projectSpace;
	private final ChangePackage changePackage;

	/**
	 * Constructor.
	 * 
	 * @param commitProjectHandler A commit project handler.
	 * @param projectSpace A project space.
	 * @param changePackage A change package.
	 */
	public FinalizeCommitTriple(CommitProjectHandler commitProjectHandler, ProjectSpace projectSpace,
		ChangePackage changePackage) {
		this.commitProjectHandler = commitProjectHandler;
		this.projectSpace = projectSpace;
		this.changePackage = changePackage;
	}

	/**
	 * Gets the commit project handler.
	 * 
	 * @return The commit project handler.
	 */
	public CommitProjectHandler getCommitProjectHandler() {
		return commitProjectHandler;
	}

	/**
	 * Gets the project space.
	 * 
	 * @return The project space.
	 */
	public ProjectSpace getProjectSpace() {
		return projectSpace;
	}

	/**
	 * Gets the change package.
	 * 
	 * @return The change package.
	 */
	public ChangePackage getChangePackage() {
		return changePackage;
	}

}
