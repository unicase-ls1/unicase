package org.unicase.changetracking.release;

import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.revwalk.RevCommit;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.git.GitBranch;

public class ChangePackageCheckEntry extends CheckEntry {

	private ChangePackage changePackage;
	private GitBranch branch;
	private BranchState state;
	
	
	
	public ChangePackageCheckEntry(ChangePackage cp) {
		this.changePackage = cp;
	}

	
	public BranchState getState() {
		return state;
	}

	public void setState(BranchState state) {
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
