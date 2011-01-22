package org.unicase.changetracking.git.commands;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.MergeCommand;
import org.eclipse.jgit.api.MergeResult;
import org.eclipse.jgit.api.TagCommand;
import org.eclipse.jgit.api.errors.CheckoutConflictException;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.InvalidMergeHeadsException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.InvalidTagNameException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryState;
import org.eclipse.jgit.merge.MergeStrategy;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTag;
import org.unicase.changetracking.git.GitNameUtil;
import org.unicase.changetracking.git.GitUtil;
import org.unicase.changetracking.git.GitWrapper;
import org.unicase.changetracking.git.exceptions.UnexpectedGitException;
import org.unicase.changetracking.release.Problem;
import org.unicase.changetracking.release.Problem.Severity;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.model.changetracking.git.GitFactory;
import org.unicase.model.changetracking.git.GitRevision;
import org.unicase.workspace.util.UnicaseCommandWithResult;

public class GitBuildReleaseCommand extends UnicaseProgressMonitorCommand{

	
	private ChangeTrackingRelease release;
	private Repository localRepo;
	private Ref baseBranch;
	private List<Ref> branchesToMerge;
	private String tagName;
	private boolean isContinuing;
	private boolean conflictOccurred;
	
	public GitBuildReleaseCommand(ChangeTrackingRelease release, Repository localRepo, Ref baseBranch, List<Ref> branchesToMerge, String tagName) {
		this.release = release;
		this.localRepo = localRepo;
		this.baseBranch = baseBranch;
		this.branchesToMerge = branchesToMerge;
		this.tagName = tagName;
	}
	
	@Override
	protected void doRun() {
		
		IProgressMonitor progressMonitor = getProgressMonitor();
		progressMonitor.beginTask("Building Release", 7 + branchesToMerge.size()*2);
		conflictOccurred = false;
		
		try{
			
			// 1. Checks...
			progressMonitor.subTask("Checking requirements");
			if(isContinuing){
				//Make sure we are in a merge resolved state
				if(RepositoryState.MERGING_RESOLVED != localRepo.getRepositoryState()){
					if(RepositoryState.MERGING == localRepo.getRepositoryState()){
						throw new UnexpectedGitException("Local repository still contains unresolved changes. Resolve these and add the conflicting files afterwards");
					} else {
						throw new UnexpectedGitException("Local repository is in an invalid state. Have you commited the conflict merge by hand? If so, restart building the release.");
					}
				}
			} else {
				//Make sure that the local repository is in a valid state
				boolean indexClean = GitUtil.isIndexAndWorkDirClean(localRepo);
				if(!indexClean){
					throw new UnexpectedGitException("Cannot build release while working directory or index contains changes");
				}
				
				//Check that it is in a safe state
				if(RepositoryState.SAFE != localRepo.getRepositoryState()){
					throw new UnexpectedGitException("Local repository is not in a safe state");
				}

			}
			
			//Check that the release is not built yet
			if(release.isBuilt()){
				throw new UnexpectedGitException("Release is already built");
			}
			
			//Check that the tag name is valid
			if(tagName == null){
				throw new UnexpectedGitException("No tag name provided");
			} 
		
			String error = GitNameUtil.isNewTagNameValid(tagName,localRepo);
			if(error != null){
				throw new UnexpectedGitException("Tag name '" + tagName + "' is invalid: " + error);
			}
			progressMonitor.worked(1);
			
			// 2. Check out the base branch or do a merging commit.
			GitWrapper git = new GitWrapper(localRepo);
			if(isContinuing){
				progressMonitor.subTask("Commiting resolved merge conflicts");
				git.commitResolvedMergeConflicts();
			} else {
				progressMonitor.subTask("Checking out base branch");
				git.checkout(baseBranch.getName());
			}
			progressMonitor.worked(1);
			
			// 3. Merge the unmerged branches onto it
			while(!branchesToMerge.isEmpty()){
				Ref branch = branchesToMerge.remove(0);;
				progressMonitor.subTask("Merging branch " + branch.getName());
				MergeResult mergeRes = git.mergeWithResolve(branch);
				switch(mergeRes.getMergeStatus()){
				case ALREADY_UP_TO_DATE:
				case FAST_FORWARD:
				case MERGED:
					break;
				case CONFLICTING:
					conflictOccurred = true;
					throw new UnexpectedGitException("There were conflicts while merging branch " + branch.getName() + ". Resolve these and then go on with building.");
				case FAILED:
					throw new UnexpectedGitException("Merge failed!");
				case NOT_SUPPORTED:
					throw new UnexpectedGitException("Merge not yet supported by jgit!");
				}
				progressMonitor.worked(2);
			}
			
			// 4. Add tag for the release
			progressMonitor.subTask("Creating tag");
			RevTag tag = git.createTag(tagName, "This is the automatically built release '" + release.getName() + "'");;
			progressMonitor.worked(1);
			
			// 5. Create tag in UNICASE and associate with release
			progressMonitor.subTask("Updating model data");
			GitRevision revision = GitFactory.eINSTANCE.createGitRevision();
			revision.setTagName(tagName);
			revision.setHash(tag.getName());
			revision.setName("Release: " + release.getName());
			GitUtil.addToProjectRelative(revision, release);
			release.setBuilt(true);
			//FIXME for some reason, this does not work, even when directly set in the MEEditor
			release.setBuiltRevision(revision);
			progressMonitor.worked(1);
			
			//FIXME Add push
			progressMonitor.subTask("Pushing created revisions to remote repository");
			progressMonitor.worked(3);
		} finally {
			progressMonitor.done();
		}
	}

	
}
