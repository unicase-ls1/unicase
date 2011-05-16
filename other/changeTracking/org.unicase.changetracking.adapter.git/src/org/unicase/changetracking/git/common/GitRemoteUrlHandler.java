/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
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
