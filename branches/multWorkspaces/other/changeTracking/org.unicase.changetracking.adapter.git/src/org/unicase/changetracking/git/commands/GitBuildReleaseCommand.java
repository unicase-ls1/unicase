/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.commands;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jgit.api.MergeResult;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryState;
import org.eclipse.jgit.revwalk.RevTag;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.PushResult;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.RemoteRefUpdate;
import org.eclipse.jgit.transport.URIish;
import org.unicase.changetracking.commands.BuildReleaseCommand;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult;
import org.unicase.changetracking.common.ChangeTrackingUtil;
import org.unicase.changetracking.exceptions.ErrorInModelException;
import org.unicase.changetracking.exceptions.MisuseException;
import org.unicase.changetracking.git.common.GitNameUtil;
import org.unicase.changetracking.git.common.GitPushOperation;
import org.unicase.changetracking.git.common.GitUtil;
import org.unicase.changetracking.git.common.GitWrapper;
import org.unicase.changetracking.git.exceptions.UnexpectedGitException;
import org.unicase.changetracking.git.releasechecking.GitReport;
import org.unicase.changetracking.release.ChangePackageState;
import org.unicase.changetracking.release.ReleaseBuildingSettings;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.Release;
import org.unicase.model.changetracking.git.GitBranch;
import org.unicase.model.changetracking.git.GitBranchChangePackage;
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

	private static final String SUCCESS_MESSAGE_NO_UPLOAD = "Release successfully built.\n\nDo not forget to upload the results to the remote repository once you have checked them!";
	private static final String SUCCESS_MESSAGE = "Release successfully built and pushed to remote.";
	
	private Release release;
	private Repository localRepo;
	private Ref baseBranch;
	private List<Ref> branchesToMerge;
	private boolean isContinuing;
	private boolean conflictOccurred;
	private GitRepository remoteRepo;
	private Map<ChangePackage, ChangePackageState> changePackageResults;
	private GitRevision builtRevision;
	private ReleaseBuildingSettings settings;
	private CredentialsProvider credentials;

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
	 * @param settings build settings
	 * @param checkReport the report from the previous release check
	 */
	public GitBuildReleaseCommand(Release release2, ReleaseBuildingSettings settings, GitReport checkReport) {
		this.release = release2;
		this.settings = settings;
		this.localRepo = checkReport.getLocalRepo();
		this.baseBranch = checkReport.getBaseBranch();
		this.changePackageResults = checkReport.getChangePackageResults();
		this.remoteRepo = (GitRepository) checkReport.getRepoLocation();
		this.branchesToMerge = checkReport.getBranchesToMerge();
		this.credentials = GitUtil.getDefaultCredentialsProvider();
	}

	@Override
	protected ChangeTrackingCommandResult doRun() {

		IProgressMonitor progressMonitor = getProgressMonitor();
		progressMonitor.beginTask("Building Release", 7 + branchesToMerge.size() * 2);
		conflictOccurred = false;

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
		RevTag tag = git.createTag(settings.getTagName(), "This is the automatically built release '" + release.getName() + "'");
		progressMonitor.worked(1);

		// 5. Create tag in UNICASE and associate with release
		progressMonitor.subTask("Updating model data");
		builtRevision = GitFactory.eINSTANCE.createGitRevision();
		builtRevision.setTagName(settings.getTagName());
		builtRevision.setHash(tag.getName());
		builtRevision.setName("Release: " + release.getName());
		ChangeTrackingUtil.addToProjectRelative(builtRevision, release, false);
		release.setBuilt(true);

		release.setBuiltRevision(builtRevision);
		release.setBuildDate(new Date());
		progressMonitor.worked(1);

		// 6. Push the tag and the updated branch
		if(settings.wantUploadToRemote()){
			progressMonitor.subTask("Pushing created revisions to remote repository");
			try{
				pushToRemote();
			} catch (UnexpectedGitException e){
				throw new UnexpectedGitException("The release has been built successfully, but the pushing of the results was unsuccessful. Perform the pushing manually.\n\nFailure reason:\n" + e.getMessage(),e.getCause());
			}
		}
		progressMonitor.worked(3);

		if(settings.wantUploadToRemote()){
			return successResult(SUCCESS_MESSAGE);
		} else {
			return successResult(SUCCESS_MESSAGE_NO_UPLOAD);
		}
	}

	/**
	 * Pushes the resulting build to the remote repository.
	 */
	private void pushToRemote() {
	
		//Get uri
		URIish repoURI;
		try {
			repoURI = GitUtil.getURIFromRemote(remoteRepo);
		} catch (URISyntaxException e) {
			throw new UnexpectedGitException(e);
		}
		
		//Get list of things to be pushed
		List<RefSpec> pushSpec = buildPushSpec();
		
		//Do the push
		PushResult pushResult = new GitPushOperation(localRepo, repoURI, pushSpec, false, 15000, credentials).run(new NullProgressMonitor());
		
		//Check that everything went well
		StringBuilder errors = new StringBuilder();
		for(RemoteRefUpdate updateResult : pushResult.getRemoteUpdates()){
			if(!GitUtil.isRemoteRefUpdateSuccessful(updateResult)){
				errors.append("\nUnable to push '" + updateResult.getSrcRef() + "': " + updateResult.getMessage() + " (" + updateResult.getStatus()+ ")");
			}
		}
		
		//There were errors? -> throw exception
		if(errors.length() > 0){
			errors.insert(0, "Some parts of the result could not be pushed to the remote repository:");
			throw new UnexpectedGitException(errors.toString());
		}
		
	}

	/**
	 * Builds the list of ref specs to be pushed to the
	 * remote repository after a successful build. The following
	 * refs have to be pushed:
	 * 
	 * -The release branch
	 * 
	 * -All unmerged change package branches
	 * 
	 * -The created tag
	 * 
	 * @return list of ref specs to be pushed to the remote repo
	 */
	private List<RefSpec> buildPushSpec() {
		ArrayList<RefSpec> result = new ArrayList<RefSpec>();
		
		//Add release branch spec
		try {
			result.add(GitNameUtil.getRefSpecFromGitBranch((GitBranch) ChangeTrackingUtil.getRepoStreamOfRelease(release), true));
		} catch (ErrorInModelException e1) {
			//cannot happen. Already checked during release checking
		}
		
		//Add specs of unmerged branches
		for(Entry<ChangePackage, ChangePackageState> e : changePackageResults.entrySet()){
			if(e.getValue() == ChangePackageState.UNMERGED){
				ChangePackage cp = e.getKey();
				GitBranch b = ((GitBranchChangePackage)cp).getBranch();
				result.add(GitNameUtil.getRefSpecFromGitBranch(b, true));
			}
		}
		
		//Add tag
		result.add(GitNameUtil.getRefSpecFromGitTag(builtRevision, true));
		
		return result;
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
		String tagName = settings.getTagName();
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
