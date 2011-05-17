/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git;

import org.eclipse.core.resources.IProject;
import org.eclipse.egit.core.GitTag;
import org.unicase.changetracking.git.common.GitRepoFindUtil;
import org.unicase.changetracking.vcs.VCSAdapter;
import org.unicase.changetracking.vcs.VCSAdapterProvider;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.RepositoryRevision;
import org.unicase.model.changetracking.RepositoryStream;
import org.unicase.model.changetracking.git.GitBranch;
import org.unicase.model.changetracking.git.GitBranchChangePackage;

public class GitVCSAdapterProvider implements VCSAdapterProvider {

	public boolean providesForStream(RepositoryStream stream) {
		return stream instanceof GitBranch;
	}

	public boolean providesForRevision(RepositoryRevision revision) {
		return revision instanceof GitTag;
	}

	public boolean providesForChangePackage(ChangePackage pkg) {
		return pkg instanceof GitBranchChangePackage;
	}

	public boolean providesForProject(IProject project) {
		return null != GitRepoFindUtil.findRepository(project.getFullPath().toFile());
	}

	public VCSAdapter create() {
		return new GitVCSAdapter();
	}

}
