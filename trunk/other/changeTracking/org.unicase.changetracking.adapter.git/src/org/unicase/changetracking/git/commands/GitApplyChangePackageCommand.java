/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.commands;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryState;
import org.eclipse.jgit.transport.FetchResult;
import org.eclipse.jgit.transport.TrackingRefUpdate;
import org.unicase.changetracking.commands.ChangeTrackingCommand;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult;
import org.unicase.changetracking.exceptions.MisuseException;
import org.unicase.changetracking.git.common.GitFetchOperation;
import org.unicase.changetracking.git.common.GitNameUtil;
import org.unicase.changetracking.git.common.GitRepoFindUtil;
import org.unicase.changetracking.git.common.GitUtil;
import org.unicase.changetracking.git.common.GitWrapper;
import org.unicase.changetracking.git.exceptions.NoMatchingLocalRepositoryInWorkspace;
import org.unicase.changetracking.git.exceptions.UnexpectedGitException;
import org.unicase.model.changetracking.RepositoryLocation;
import org.unicase.model.changetracking.git.GitBranch;
import org.unicase.model.changetracking.git.GitBranchChangePackage;
import org.unicase.model.changetracking.git.GitRepository;

/**
 * Git implementation for the change package application.
 * 
 * @author jfinis
 * 
 */
public class GitApplyChangePackageCommand extends ChangeTrackingCommand {

	private GitBranchChangePackage myChangePackage;

	/**
	 * Default constructor.
	 * 
	 * @param changePackage change package to be applied
	 */
	public GitApplyChangePackageCommand(GitBranchChangePackage changePackage) {
		this.myChangePackage = changePackage;
	}

	@Override
	protected ChangeTrackingCommandResult doRun() {
		try {
			return applyChangePackage(myChangePackage);
		} catch (NoMatchingLocalRepositoryInWorkspace e) {
			return misuseResult(e.getMessage());
		}
	}

	/**
	 * performs the application.
	 * 
	 * @param changePackage change pakcage to be applied
	 * @return result
	 * @throws NoMatchingLocalRepositoryInWorkspace if no matching repository is
	 *             found in the workspace
	 */
	private ChangeTrackingCommandResult applyChangePackage(GitBranchChangePackage changePackage) throws NoMatchingLocalRepositoryInWorkspace {

		IProgressMonitor progressMonitor = getProgressMonitor();
		progressMonitor.beginTask("Applying change package", 8);
		
		//*** 1. Retrieve and check necessary data ***
		progressMonitor.subTask("Checking requirements");
		
		GitBranch branch = changePackage.getBranch();
		if (branch == null) {
			throw new MisuseException("The change package has no associated branch");
		}

		RepositoryLocation repoLocationModel = branch.getLocation();
		if (repoLocationModel == null) {
			throw new MisuseException("The git branch associated with the change package has no repository location.");
		}
		if (!(repoLocationModel instanceof GitRepository)) {
			throw new MisuseException("The repository associated with the git branch is not a git repository.");
		}
		GitRepository gitRepoLocation = (GitRepository) repoLocationModel;
		progressMonitor.worked(1);

		//*** 2. Find and check a local repo matching the repo of the change package. ***
		progressMonitor.subTask("Checking local repository");
		
		Repository repo = GitRepoFindUtil.findAssociatedLocalRepo(gitRepoLocation);
		if (repo == null) {
			throw new NoMatchingLocalRepositoryInWorkspace("Found no local repository associated with this git repository. Clone from it first.");
		}

		// Make sure that the local repository is in a valid state
		boolean indexClean = GitUtil.isIndexAndWorkDirClean(repo);
		if (!indexClean) {
			throw new MisuseException("Cannot apply change package to workspace while working directory or index contains changes.\n\nFollowing changes were found:\n" + GitUtil.getModificationsAsString(repo, 10));
		}

		// Check that it is in a safe state
		if (RepositoryState.SAFE != repo.getRepositoryState()) {
			throw new MisuseException("Local repository is not in a safe state");
		}
		progressMonitor.worked(1);

		//*** 3. Pull the branch from remote ***
		SubProgressMonitor subMonitor = new SubProgressMonitor(progressMonitor, 4);
		GitFetchOperation fetchOp = new GitFetchOperation(gitRepoLocation, repo, GitUtil.getDefaultCredentialsProvider(), 15000, GitNameUtil.getRefSpecFromGitBranch(branch,true));
		fetchOp.setProgressMonitor(subMonitor);
		FetchResult fetchResult = fetchOp.run();
		for(TrackingRefUpdate updateResult : fetchResult.getTrackingRefUpdates()){
			if(!GitUtil.isRefUpdateSuccessful(updateResult)){
				throw new UnexpectedGitException("The branch could not be fetched from the remote repository.");
			}
		}
	
		//*** 4. Checkout the branch ***
		progressMonitor.subTask("Checking out branch");
		new GitWrapper(repo).checkout(branch.getBranchName());
		progressMonitor.worked(1);

		return successResult("The change package was successfully applied onto your workspace.");

	}
	


}
