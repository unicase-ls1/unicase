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
import org.unicase.changetracking.git.GitNameUtil;
import org.unicase.changetracking.git.GitUtil;
import org.unicase.changetracking.git.GitWrapper;
import org.unicase.changetracking.git.exceptions.UnexpectedGitException;
import org.unicase.changetracking.git.release.GitReport;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.model.changetracking.git.GitFactory;
import org.unicase.model.changetracking.git.GitRevision;

public class GitBuildReleaseCommand extends BuildReleaseCommand{

	
	private ChangeTrackingRelease release;
	private Repository localRepo;
	private Ref baseBranch;
	private List<Ref> branchesToMerge;
	private String tagName;
	private boolean isContinuing;
	private boolean conflictOccurred;
	
	



	public Repository getLocalRepo() {
		return localRepo;
	}


	
	
	
	public GitBuildReleaseCommand(ChangeTrackingRelease release2,
			String tagName2, GitReport checkReport) {
		this.release = release2;
		this.tagName = tagName2;
		this.localRepo = checkReport.getLocalRepo();
		this.baseBranch = checkReport.getBaseBranch();
		this.branchesToMerge = checkReport.getBranchesToMerge();
	}





	@Override
	protected ChangeTrackingCommandResult doRun() {

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
						throw new MisuseException("Local repository still contains unresolved changes. Resolve these and add the conflicting files afterwards");
					} else {
						throw new MisuseException("Local repository is in an invalid state. Have you commited the conflict merge by hand? If so, restart building the release.");
					}
				}
			} else {
				//Make sure that the local repository is in a valid state
				boolean indexClean = GitUtil.isIndexAndWorkDirClean(localRepo);
				if(!indexClean){
					throw new MisuseException("Cannot build release while working directory or index contains changes");
				}
				
				//Check that it is in a safe state
				if(RepositoryState.SAFE != localRepo.getRepositoryState()){
					throw new MisuseException("Local repository is not in a safe state");
				}

			}
			
			//Check that the release is not built yet
			if(release.isBuilt()){
				throw new MisuseException("Release is already built");
			}
			
			//Check that the tag name is valid
			if(tagName == null){
				throw new MisuseException("No tag name provided");
			} 
		
			String error = GitNameUtil.isNewTagNameValid(tagName,localRepo);
			if(error != null){
				throw new MisuseException("Tag name '" + tagName + "' is invalid: " + error);
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
					return warningResult("There were conflicts while merging branch " + branch.getName() + ". Resolve these, add them to mark them as resolved and then go on with building.");
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
			ChangeTrackingUtil.addToProjectRelative(revision, release, false);
			release.setBuilt(true);
			//FIXME for some reason, this does not work, even when directly set in the MEEditor
			release.setBuiltRevision(revision);
			release.setBuildDate(new Date());
			progressMonitor.worked(1);
			
			//FIXME Add push
			progressMonitor.subTask("Pushing created revisions to remote repository");
			progressMonitor.worked(3);
		} finally {
			progressMonitor.done();
		}
		return successResult("Release successfully built.");
	}





	public void setContinue(boolean b) {
		this.isContinuing = b;
	}





	public boolean hadConflicts() {
		return conflictOccurred;
	}

	
}
