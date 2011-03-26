package org.unicase.changetracking.git.commands;

import java.net.URISyntaxException;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryState;
import org.unicase.changetracking.commands.ChangeTrackingCommand;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult;
import org.unicase.changetracking.exceptions.MisuseException;
import org.unicase.changetracking.git.GitRepoFindUtil;
import org.unicase.changetracking.git.GitUtil;
import org.unicase.changetracking.git.SelectivePullOperation;
import org.unicase.changetracking.git.exceptions.NoMatchingLocalRepositoryInWorkspace;
import org.unicase.changetracking.git.exceptions.UnexpectedGitException;
import org.unicase.model.changetracking.RepositoryLocation;
import org.unicase.model.changetracking.git.GitBranch;
import org.unicase.model.changetracking.git.GitBranchChangePackage;
import org.unicase.model.changetracking.git.GitRepository;

public class GitApplyChangePackageCommand extends ChangeTrackingCommand {

	
	
	private GitBranchChangePackage myChangePackage;

	public GitApplyChangePackageCommand(GitBranchChangePackage changePackage){
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
	
	public ChangeTrackingCommandResult applyChangePackage(GitBranchChangePackage changePackage) throws NoMatchingLocalRepositoryInWorkspace {
		//1. Retrieve and check necessary data
		GitBranch branch = changePackage.getBranch();
		if(branch == null){
			throw new MisuseException("The change package has no associated branch");
		}
		
		RepositoryLocation repoLocationModel = branch.getLocation();
		if(repoLocationModel == null){
			throw new MisuseException("The git branch associated with the change package has no repository location.");
		}
		if(!(repoLocationModel instanceof GitRepository)){
			throw new MisuseException("The repository associated with the git branch is not a git repository.");
		}
		GitRepository gitRepoLocation = (GitRepository) repoLocationModel;
		
		//1. Find a local repo matching the repo of the change package.
		Repository repo = GitRepoFindUtil.findAssociatedLocalRepo(gitRepoLocation);
		if(repo == null){
			//TODO Add dialog to do cloning or specification
			throw new NoMatchingLocalRepositoryInWorkspace("Found no local repository associated with this git repository. Clone from it first.");
		}
		
		//Make sure that the local repository is in a valid state
		boolean indexClean = GitUtil.isIndexAndWorkDirClean(repo);
		if(!indexClean){
			throw new MisuseException("Cannot apply change package to workspace while working directory or index contains changes.\n\nFollowing changes were found:\n" + GitUtil.getModificationsAsString(repo,10));
		}
		
		//Check that it is in a safe state
		if(RepositoryState.SAFE != repo.getRepositoryState()){
			throw new MisuseException("Local repository is not in a safe state");
		}
		
		//2. Pull the branch from remote
		try {
			//FIXME correct progress monitor support
				new SelectivePullOperation(repo, GitUtil.getUriFromRemote(gitRepoLocation), 20, GitUtil.getRefSpecFromGitBranch(branch)).execute(new NullProgressMonitor());
		} catch (URISyntaxException e1) {
			throw new UnexpectedGitException("The URL of the repository location '" + gitRepoLocation.getUrl() + "' is no valid URI");
		}
		
		//3. Checkout the branch
		try {
			new Git(repo).checkout().setName(branch.getBranchName()).call();
		} catch (JGitInternalException e) {
			throw new UnexpectedGitException(e);
		} catch (RefAlreadyExistsException e) {
			throw new UnexpectedGitException(e);
		} catch (RefNotFoundException e) {
			throw new UnexpectedGitException(e);
		} catch (InvalidRefNameException e) {
			throw new UnexpectedGitException(e);
		}
		
		return successResult("The change package was successfully applied onto your workspace.");
		
		
	}
	


}