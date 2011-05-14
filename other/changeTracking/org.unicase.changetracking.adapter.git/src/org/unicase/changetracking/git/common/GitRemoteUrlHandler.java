package org.unicase.changetracking.git.common;

import org.eclipse.jgit.lib.Repository;
import org.unicase.model.changetracking.git.GitRepository;

public class GitRemoteUrlHandler {

	private GitRepository repoModel;

	public GitRemoteUrlHandler(GitRepository repoModel, Repository repo){
		this.repoModel = repoModel;
	}
	
	public String buildRemoteString(){
		return repoModel.getUrl();
	}
}
