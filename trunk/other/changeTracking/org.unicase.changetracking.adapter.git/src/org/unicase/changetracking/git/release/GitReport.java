/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.release;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.unicase.changetracking.release.ChangePackageState;
import org.unicase.changetracking.release.Problem;
import org.unicase.changetracking.release.ReleaseCheckReport;
import org.unicase.changetracking.release.WorkItemStatistics;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.RepositoryLocation;

public class GitReport extends ReleaseCheckReport{

	private Repository repo;
	private Ref baseBranch;
	private List<Ref> branchesToMerge;

	public GitReport(RepositoryLocation repoLoc,
			WorkItemStatistics workItemStats, List<Problem> errorMessages,
			boolean checkedOut, boolean upToDate,
			HashMap<ChangePackage, ChangePackageState> resultMap) {
		super(repoLoc, workItemStats, errorMessages, checkedOut, upToDate, resultMap);
	}

	public GitReport(RepositoryLocation repoLoc,
			WorkItemStatistics workItemStats, Set<ChangePackage> set,
			List<Problem> errorMessages, boolean checkedOut) {
		super(repoLoc, workItemStats, set, errorMessages, checkedOut);
	}
	
	public void setGitData(Repository repo, Ref baseBranch, List<Ref> branchesToMerge){
		this.repo = repo;
		this.baseBranch = baseBranch;
		this.branchesToMerge = branchesToMerge;
	}

	public Ref getBaseBranch() {
		return baseBranch;
	}

	public List<Ref> getBranchesToMerge() {
		return branchesToMerge;
	}

	public Repository getLocalRepo() {
		return repo;
	}

	
}
