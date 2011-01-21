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
		progressMonitor.beginTask("Building Release", 6);
		try{
		
			// 1. Checks...
			
			//Make sure that the local repository is in a valid state
			progressMonitor.subTask("Checking requirements");
			boolean indexClean = GitUtil.isIndexAndWorkDirClean(localRepo);
			if(!indexClean){
				throw new UnexpectedGitException("Cannot build release while working directory or index contains changes");
			}
			
			//Check that it is in a safe state
			if(RepositoryState.SAFE != localRepo.getRepositoryState()){
				throw new UnexpectedGitException("Local repository is not in a safe state");
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
			
			// 2. Check out the base branch
			progressMonitor.subTask("Checking out base branch");
			Git git = new Git(localRepo);
			try {
				git.checkout().setName(baseBranch.getName()).call();
			} catch (JGitInternalException e) {
				throw new UnexpectedGitException("Checking out the base branch failed.",e);
			} catch (RefAlreadyExistsException e) {
				throw new UnexpectedGitException("Checking out the base branch failed.",e);
			} catch (RefNotFoundException e) {
				throw new UnexpectedGitException("Checking out the base branch failed.",e);
			} catch (InvalidRefNameException e) {
				throw new UnexpectedGitException("Checking out the base branch failed.",e);
			}
			progressMonitor.worked(1);
			
			// 3. Merge the unmerged branches onto it
			if(!branchesToMerge.isEmpty()){
				progressMonitor.subTask("Merging unmerged branches");
				MergeCommand merge = git.merge();
				merge.setStrategy(MergeStrategy.RESOLVE);
				for(Ref branch : branchesToMerge){
					merge.include(branch);			
				}
				MergeResult mergeRes;
				try {
					mergeRes = merge.call();
				} catch (NoHeadException e) {
					throw new UnexpectedGitException(e.getMessage(), e);
				} catch (ConcurrentRefUpdateException e) {
					throw new UnexpectedGitException(e.getMessage(), e);
				} catch (CheckoutConflictException e) {
					throw new UnexpectedGitException(e.getMessage(), e);
				} catch (InvalidMergeHeadsException e) {
					throw new UnexpectedGitException(e.getMessage(), e);
				} catch (WrongRepositoryStateException e) {
					throw new UnexpectedGitException(e.getMessage(), e);
				} catch (NoMessageException e) {
					throw new UnexpectedGitException(e.getMessage(), e);
				}
				switch(mergeRes.getMergeStatus()){
				case ALREADY_UP_TO_DATE:
				case FAST_FORWARD:
				case MERGED:
					break;
				case CONFLICTING:
					throw new UnexpectedGitException("There were conflicts. Resolve these and commit");
				case FAILED:
					throw new UnexpectedGitException("Merge failed!");
				case NOT_SUPPORTED:
					throw new UnexpectedGitException("Merge not yet supported by jgit!");
				}
			}
			progressMonitor.worked(2);
			
			// 4. Add tag for the release
			progressMonitor.subTask("Creating tag");
			TagCommand tagCommand = git.tag().setName(tagName);
			tagCommand.setMessage("This is the automatically built release '" + release.getName() + "'");
			RevTag tag;
			try {
				tag = tagCommand.call();
			} catch (JGitInternalException e) {
				throw new UnexpectedGitException("Creating a tag for the release failed.",e);
			} catch (ConcurrentRefUpdateException e) {
				throw new UnexpectedGitException("Creating a tag for the release failed.",e);
			} catch (InvalidTagNameException e) {
				throw new UnexpectedGitException("Creating a tag for the release failed.",e);
			} catch (NoHeadException e) {
				throw new UnexpectedGitException("Creating a tag for the release failed.",e);
			}
			progressMonitor.worked(1);
			
			// 5. Create tag in UNICASE and associate with release
			progressMonitor.subTask("Updating model data");
			GitRevision revision = GitFactory.eINSTANCE.createGitRevision();
			revision.setTagName(tagName);
			revision.setHash(tag.getName());
			GitUtil.addToProjectRelative(revision, release);
			release.setBuilt(true);
			//FIXME for some reason, this does not work, even when directly set in the MEEditor
			release.setBuiltRevision(revision);
			progressMonitor.worked(1);
			
		} finally {
			progressMonitor.done();
		}
	}

	
}
