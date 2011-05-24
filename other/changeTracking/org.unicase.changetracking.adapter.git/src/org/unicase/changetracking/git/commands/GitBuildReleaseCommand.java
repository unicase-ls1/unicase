/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.commands;

import java.util.Date;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jgit.api.MergeResult;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryState;
import org.eclipse.jgit.revwalk.RevTag;
import org.unicase.changetracking.commands.BuildReleaseCommand;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult;
import org.unicase.changetracking.common.ChangeTrackingUtil;
import org.unicase.changetracking.exceptions.MisuseException;
import org.unicase.changetracking.git.common.GitNameUtil;
import org.unicase.changetracking.git.common.GitUtil;
import org.unicase.changetracking.git.common.GitWrapper;
import org.unicase.changetracking.git.common.SayYesCredentialsProvider;
import org.unicase.changetracking.git.exceptions.UnexpectedGitException;
import org.unicase.changetracking.git.release.GitReport;
import org.unicase.model.changetracking.Release;
import org.unicase.model.changetracking.git.GitFactory;
import org.unicase.model.changetracking.git.GitRepository;
import org.unicase.model.changetracking.git.GitRevision;

/**
 * Git implementation of the release building use case.
 * 
 * @author jfinis
 * 
 */
public class GitBuildReleaseCommand extends BuildReleaseCommand {

	private Release release;
	private Repository localRepo;
	private Ref baseBranch;
	private List<Ref> branchesToMerge;
	private String tagName;
	private boolean isContinuing;
	private boolean conflictOccurred;
	@SuppressWarnings("unused")
	private SayYesCredentialsProvider credentials;
	@SuppressWarnings("unused")
	private GitRepository remoteRepo;

	/**
	 * Returns the local repository which is used for the release building.
	 * 
	 * @return local repository
	 */
	public Repository getLocalRepo() {
		return localRepo;
	}

	/**
	 * Default constructor.
	 * 
	 * @param release2 release to be built
	 * @param tagName2 name of the tag to be created for the relase
	 * @param checkReport the report from the previous release check
	 */
	public GitBuildReleaseCommand(Release release2, String tagName2, GitReport checkReport) {
		this.release = release2;
		this.tagName = tagName2;
		this.localRepo = checkReport.getLocalRepo();
		this.baseBranch = checkReport.getBaseBranch();
		this.remoteRepo = (GitRepository) checkReport.getRepoLocation();
		this.branchesToMerge = checkReport.getBranchesToMerge();
		// FIXME correct credentials provider
		this.credentials = new SayYesCredentialsProvider("gexicide", "git2day");
	}

	@Override
	protected ChangeTrackingCommandResult doRun() {

		IProgressMonitor progressMonitor = getProgressMonitor();
		progressMonitor.beginTask("Building Release", 7 + branchesToMerge.size() * 2);
		conflictOccurred = false;
		try {

			// 1. Checks...
			progressMonitor.subTask("Checking requirements");
			performChecks();
			progressMonitor.worked(1);

			// 2. Check out the base branch or do a merging commit.
			GitWrapper git = new GitWrapper(localRepo);
			if (isContinuing) {
				progressMonitor.subTask("Commiting resolved merge conflicts");
				git.commitResolvedMergeConflicts();
			} else {
				progressMonitor.subTask("Checking out base branch");
				git.checkout(baseBranch.getName());
			}
			progressMonitor.worked(1);

			// 3. Merge the unmerged branches onto it
			while (!branchesToMerge.isEmpty()) {
				Ref branch = branchesToMerge.remove(0);
				progressMonitor.subTask("Merging branch " + branch.getName());
				MergeResult mergeRes = git.mergeWithResolve(branch);
				switch (mergeRes.getMergeStatus()) {
				case ALREADY_UP_TO_DATE:
				case FAST_FORWARD:
				case MERGED:
					break;
				case CONFLICTING:
					conflictOccurred = true;
					return warningResult("There were conflicts while merging branch " + branch.getName() + ". Resolve these, add them to mark them as resolved and then go on with building.");
				case FAILED:
					throw new UnexpectedGitException("Merge failed!");
				case NOT_SUPPORTED:
					throw new UnexpectedGitException("Merge not yet supported by jgit!");
				default:
					break;
				}
				progressMonitor.worked(2);
			}

			// 4. Add tag for the release
			progressMonitor.subTask("Creating tag");
			RevTag tag = git.createTag(tagName, "This is the automatically built release '" + release.getName() + "'");
			progressMonitor.worked(1);

			// 5. Create tag in UNICASE and associate with release
			progressMonitor.subTask("Updating model data");
			GitRevision revision = GitFactory.eINSTANCE.createGitRevision();
			revision.setTagName(tagName);
			revision.setHash(tag.getName());
			revision.setName("Release: " + release.getName());
			ChangeTrackingUtil.addToProjectRelative(revision, release, false);
			release.setBuilt(true);
			
			// FIXME for some reason, this does not work, even when directly set
			// in the MEEditor
			release.setBuiltRevision(revision);
			release.setBuildDate(new Date());
			progressMonitor.worked(1);

			// 6. Push the tag and the updated branch
			progressMonitor.subTask("Pushing created revisions to remote repository");
//			// Push to remote repo
//			URIish repoURI;
//			try {
//				repoURI = GitUtil.getURIFromCredentials(remoteRepo, credentials);
//			} catch (URISyntaxException e) {
//				throw new MisuseException(e);
//			}
//			List<RefSpec> pushSpec = Arrays.asList(GitUtil.getRefSpecFromGitBranch(branch));
//			//TODO: Correct progress monitor support
//			PushResult pushResult = new GitPushOperation(repo, repoURI, pushSpec, false, 15000).run(progressMonitor);
//			for(RemoteRefUpdate updateResult : pushResult.getRemoteUpdates()){
//				if(!GitUtil.isRemoteRefUpdateSuccessful(updateResult)){
//					throw new UnexpectedGitException("Was unable to push the created branch to the remote repository.\nReason: " + updateResult.getMessage() + " (" + updateResult.getStatus()+ ")");
//				}
//			}
			progressMonitor.worked(3);
		} finally {
			progressMonitor.done();
		}
		return successResult("Release successfully built.");
	}

	/**
	 * Performs various checks to ensure that all used objects are in a state
	 * which allow the building. If a problem is found, a MisuseException is
	 * thrown.
	 */
	private void performChecks() {
		if (isContinuing) {
			// Make sure we are in a merge resolved state
			if (RepositoryState.MERGING_RESOLVED != localRepo.getRepositoryState()) {
				if (RepositoryState.MERGING == localRepo.getRepositoryState()) {
					throw new MisuseException("Local repository still contains unresolved changes. Resolve these and add the conflicting files afterwards");
				} else {
					throw new MisuseException("Local repository is in an invalid state. Have you commited the conflict merge by hand? If so, restart building the release.");
				}
			}
		} else {
			// Make sure that the local repository is in a valid state
			boolean indexClean = GitUtil.isIndexAndWorkDirClean(localRepo);
			if (!indexClean) {
				throw new MisuseException("Cannot build release while working directory or index contains changes");
			}

			// Check that it is in a safe state
			if (RepositoryState.SAFE != localRepo.getRepositoryState()) {
				throw new MisuseException("Local repository is not in a safe state");
			}

		}

		// Check that the release is not built yet
		if (release.isBuilt()) {
			throw new MisuseException("Release is already built");
		}

		// Check that the tag name is valid
		if (tagName == null) {
			throw new MisuseException("No tag name provided");
		}

		String error = GitNameUtil.isNewTagNameValid(tagName, localRepo);
		if (error != null) {
			throw new MisuseException("Tag name '" + tagName + "' is invalid: " + error);
		}
	}

	/**
	 * Setting the continue flag indicates that the relase building is being
	 * continued after having been interrupted by a merge conflict.
	 * 
	 * @param b whether the command is continueing after a conflict
	 */
	public void setContinue(boolean b) {
		this.isContinuing = b;
	}

	/**
	 * Returns true if any conflicts occurred during the release building.
	 * 
	 * @return whether conflicts occurred
	 */
	public boolean hadConflicts() {
		return conflictOccurred;
	}

}
