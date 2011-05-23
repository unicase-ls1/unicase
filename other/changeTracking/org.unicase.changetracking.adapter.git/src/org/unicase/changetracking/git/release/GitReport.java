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

/**
 * Git implementation of a release checking report.
 * 
 * Contains additional information which is needed by the Git release building
 * operation.
 * 
 * @author jfinis
 * 
 */
public class GitReport extends ReleaseCheckReport {

	private Repository repo;
	private Ref baseBranch;
	private List<Ref> branchesToMerge;

	/**
	 * Default constructor if all information is available.
	 * 
	 * @param repoLoc repository location of the release
	 * @param workItemStats work item statistics
	 * @param errorMessages list of problems
	 * @param checkedOut currently not used
	 * @param upToDate whether an update was conducted before the checks
	 * @param resultMap change package results
	 */
	public GitReport(RepositoryLocation repoLoc, WorkItemStatistics workItemStats, List<Problem> errorMessages, boolean checkedOut, boolean upToDate, HashMap<ChangePackage, ChangePackageState> resultMap) {
		super(repoLoc, workItemStats, errorMessages, checkedOut, upToDate, resultMap);
	}

	/**
	 * Constructor if no local repository for the release is checked out. In
	 * this case, some information like the change package states cannot be
	 * retrieved.
	 * 
	 * @param repoLoc repository location of the release
	 * @param workItemStats work item statistics
	 * @param set change packages
	 * @param errorMessages list of problems
	 * @param checkedOut currently not used
	 */
	public GitReport(RepositoryLocation repoLoc, WorkItemStatistics workItemStats, Set<ChangePackage> set, List<Problem> errorMessages, boolean checkedOut) {
		super(repoLoc, workItemStats, set, errorMessages, checkedOut);
	}

	/**
	 * Sets the git specific data.
	 * 
	 * @param repo the local repository
	 * @param baseBranch the branch of the release
	 * @param branchesToMerge the branches to be merged
	 */
	public void setGitData(Repository repo, Ref baseBranch, List<Ref> branchesToMerge) {
		this.repo = repo;
		this.baseBranch = baseBranch;
		this.branchesToMerge = branchesToMerge;
	}

	/**
	 * Returns the branch of the release.
	 * 
	 * @return the release's branch
	 */
	public Ref getBaseBranch() {
		return baseBranch;
	}

	/**
	 * Returns the list of branches to be merged.
	 * 
	 * @return branches to merge
	 */
	public List<Ref> getBranchesToMerge() {
		return branchesToMerge;
	}

	/**
	 * Returns the local repository.
	 * 
	 * @return local repo
	 */
	public Repository getLocalRepo() {
		return repo;
	}

}
