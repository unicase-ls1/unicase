/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.releasechecking;

import org.unicase.changetracking.release.ChangePackageState;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.git.GitBranch;

/**
 * Data structure for storing information correspondent to a change package
 * during the release checking process.
 * 
 * @author jfinis
 * 
 */
public class ChangePackageCheckEntry extends CheckEntry {

	private ChangePackage changePackage;
	private GitBranch branch;
	private ChangePackageState state;

	/**
	 * Default constructor.
	 * 
	 * @param cp change package
	 */
	public ChangePackageCheckEntry(ChangePackage cp) {
		this.changePackage = cp;
	}

	/**
	 * Returns the change package state.
	 * 
	 * @return change package state
	 */
	public ChangePackageState getState() {
		return state;
	}

	/**
	 * Sets the change package state.
	 * 
	 * @param state change package state
	 */
	public void setState(ChangePackageState state) {
		this.state = state;
	}

	/**
	 * returns the change package.
	 * 
	 * @return change package
	 */
	public ChangePackage getChangePackage() {
		return changePackage;
	}

	/**
	 * Sets the change package.
	 * 
	 * @param changePackage change package.
	 */
	public void setChangePackage(ChangePackage changePackage) {
		this.changePackage = changePackage;
	}

	/**
	 * Returns the branch of the change package.
	 * 
	 * @return branch
	 */
	public GitBranch getBranch() {
		return branch;
	}

	/**
	 * Sets the branch of the change package.
	 * 
	 * @param branch branch
	 */
	public void setBranch(GitBranch branch) {
		this.branch = branch;
	}

}
