package org.unicase.changetracking.git.commands;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.lib.Repository;
import org.unicase.changetracking.git.Activator;
import org.unicase.changetracking.git.GitRepoFindUtil;
import org.unicase.changetracking.git.exceptions.NoMatchingLocalRepositoryInWorkspace;
import org.unicase.changetracking.git.exceptions.UnexpectedGitException;
import org.unicase.model.changetracking.RepositoryLocation;
import org.unicase.model.changetracking.git.GitBranch;
import org.unicase.model.changetracking.git.GitBranchChangePackage;
import org.unicase.model.changetracking.git.GitRepository;
import org.unicase.workspace.util.UnicaseCommand;

public class GitApplyChangePackageCommand extends UnicaseCommand {

	
	//private GitBranchChangePackage myChangePackage;

	//public GitApplyChangePackage(GitBranchChangePackage changePackage){
		//this.myChangePackage = changePackage;
	//}
	
	@Override
	protected void doRun() {
	//	applyChangePackage(myChangePackage);
	}
	
	public void applyChangePackage(GitBranchChangePackage changePackage) throws NoMatchingLocalRepositoryInWorkspace {
		//1. Retrieve and check necessary data
		GitBranch branch = changePackage.getBranch();
		if(branch == null){
			throw new UnexpectedGitException("The change package has no associated branch");
		}
		
		RepositoryLocation repoLocationModel = branch.getLocation();
		if(repoLocationModel == null){
			throw new UnexpectedGitException("The git branch associated with the change package has no repository location.");
		}
		if(!(repoLocationModel instanceof GitRepository)){
			throw new UnexpectedGitException("The repository associated with the git branch is not a git repository.");
		}
		GitRepository gitRepoLocation = (GitRepository) repoLocationModel;
		
		//1. Find a local repo matching the repo of the change package.
		Repository repo = GitRepoFindUtil.findAssociatedLocalRepo(gitRepoLocation);
		if(repo == null){
			throw new NoMatchingLocalRepositoryInWorkspace("Found no local repository associated with this git repository. Clone from it first.");
		}
		
		//2. Pull the branch from remote
		//TODO: The pull
		
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
		
		
	}
	


}
