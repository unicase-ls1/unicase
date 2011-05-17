/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git;

import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.jgit.lib.Repository;
import org.unicase.changetracking.commands.BuildReleaseCommand;
import org.unicase.changetracking.commands.ChangeTrackingCommand;
import org.unicase.changetracking.commands.CheckReleaseCommand;
import org.unicase.changetracking.common.IDecisionProvider;
import org.unicase.changetracking.exceptions.CancelledByUserException;
import org.unicase.changetracking.exceptions.UnexpectedChangeTrackingException;
import org.unicase.changetracking.exceptions.VCSException;
import org.unicase.changetracking.git.commands.GitApplyChangePackageCommand;
import org.unicase.changetracking.git.commands.GitBuildReleaseCommand;
import org.unicase.changetracking.git.commands.GitCheckReleaseCommand;
import org.unicase.changetracking.git.commands.GitCreateChangePackageCommand;
import org.unicase.changetracking.git.common.GitNameValidator;
import org.unicase.changetracking.git.common.GitRepoFindUtil;
import org.unicase.changetracking.git.common.GitUtil;
import org.unicase.changetracking.git.release.GitReport;
import org.unicase.changetracking.git.ui.RemoteURLInput;
import org.unicase.changetracking.release.ReleaseCheckReport;
import org.unicase.changetracking.vcs.BasicVCSAdapter;
import org.unicase.changetracking.vcs.NameValidator;
import org.unicase.metamodel.Project;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.model.changetracking.RepositoryLocation;
import org.unicase.model.changetracking.RepositoryStream;
import org.unicase.model.changetracking.git.GitBranch;
import org.unicase.model.changetracking.git.GitBranchChangePackage;
import org.unicase.model.changetracking.git.GitFactory;
import org.unicase.model.changetracking.git.GitRepository;
import org.unicase.model.task.WorkItem;

public class GitVCSAdapter extends BasicVCSAdapter {

	public Repository findRepo(IProject p) throws VCSException{
		Repository repo = GitRepoFindUtil.findRepository(p.getLocation().toFile());
		if(repo == null){
			throw new VCSException("The selected resource is not under git version control.");
		}
		return repo;
	}
	

	@Override
	public RepositoryLocation findRepoLocation(IProject p, Project p2) throws VCSException{
		Repository r = findRepo(p);
		return GitRepoFindUtil.findRemoteInProject(r, p2);
	}

	@Override
	public RepositoryLocation createRepositoryLocation(IProject workspaceProject)
			throws VCSException, CancelledByUserException {
			
		String remoteUrl = new RemoteURLInput().show();
		
		final GitRepository gitRepoModel = GitUtil.initGitRepoModelFromRepo(findRepo(workspaceProject));
		gitRepoModel.setUrl(remoteUrl);
		gitRepoModel.setName(remoteUrl);
		
		return gitRepoModel;
	}







	@Override
	public String performEarlyCreateChangePackageChecks(IProject localProject)
			throws VCSException {
		Repository repo = findRepo(localProject);
		if(!repo.getRepositoryState().canCommit()){
			return ("The repository is in a state which disallows committing");
		}
		return null;
	}


	@Override
	public ChangeTrackingCommand createChangePackage(IProject localProject,
			WorkItem workItem, RepositoryLocation remoteRepo, String name,
			String shortDescription, String longDescription) {
		return new GitCreateChangePackageCommand(this,localProject,workItem,(GitRepository) remoteRepo,name,shortDescription,longDescription);
	}


	@Override
	public NameValidator getNameValidator() {
		return new GitNameValidator();
	}


	@Override
	public BuildReleaseCommand buildRelease(ChangeTrackingRelease release,
			String tagName, ReleaseCheckReport checkReport) {
		return new GitBuildReleaseCommand(release, tagName, (GitReport) checkReport);
	}


	@Override
	public RepositoryStream createRepositoryStream(IProject localProject, 
			RepositoryLocation repoLocation) {
		Repository r;
		try {
			r = findRepo(localProject);
			String branchName = r.getBranch();
	
			GitBranch branch = GitFactory.eINSTANCE.createGitBranch();
			branch.setName(branchName);
			branch.setBranchName(branchName);
			branch.setLocation(repoLocation);
			return branch;
		} catch (VCSException e) {
			throw new UnexpectedChangeTrackingException(e);
		} catch (IOException e) {
			throw new UnexpectedChangeTrackingException(e);
		}
	}


	@Override
	public CheckReleaseCommand checkRelease(IDecisionProvider decisionProvider, ChangeTrackingRelease release) {
		return new GitCheckReleaseCommand(release);
	}


	@Override
	public ChangeTrackingCommand applyChangePackage(ChangePackage changePackage) {
		return new GitApplyChangePackageCommand((GitBranchChangePackage) changePackage);
	}


	public boolean doesChangePackageNeedRepoLocation() {
		return true;
	}

}