package org.unicase.changetracking.release;

import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.revwalk.RevCommit;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.git.GitBranch;

public class CheckEntry {

	private Ref ref;
	private RevCommit commit;
	

	public Ref getRef() {
		return ref;
	}

	public void setRef(Ref ref) {
		this.ref = ref;
	}

	public RevCommit getCommit() {
		return commit;
	}

	public void setCommit(RevCommit commit) {
		this.commit = commit;
	}
	
	
}
