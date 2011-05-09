package org.unicase.changetracking.git;

import org.eclipse.jgit.lib.Repository;
import org.unicase.model.changetracking.git.GitRepository;

public class GitRemoteUrlHandler {

	private Repository repo;
	private GitRepository repoModel;

	public GitRemoteUrlHandler(GitRepository repoModel, Repository repo){
		this.repoModel = repoModel;
		this.repo = repo;
	}
	
	public String buildRemoteString(){
		return repoModel.getUrl();
	}
}
