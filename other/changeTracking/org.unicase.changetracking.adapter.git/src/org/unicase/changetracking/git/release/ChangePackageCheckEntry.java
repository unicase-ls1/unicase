/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.release;

import org.unicase.changetracking.release.ChangePackageState;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.git.GitBranch;

public class ChangePackageCheckEntry extends CheckEntry {

	private ChangePackage changePackage;
	private GitBranch branch;
	private ChangePackageState state;
	
	
	
	public ChangePackageCheckEntry(ChangePackage cp) {
		this.changePackage = cp;
	}

	
	public ChangePackageState getState() {
		return state;
	}

	public void setState(ChangePackageState state) {
		this.state = state;
	}

	

	
	public ChangePackage getChangePackage() {
		return changePackage;
	}

	public void setChangePackage(ChangePackage changePackage) {
		this.changePackage = changePackage;
	}

	public GitBranch getBranch() {
		return branch;
	}

	public void setBranch(GitBranch branch) {
		this.branch = branch;
	}
	
	
}
