/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git;

import org.eclipse.core.resources.IProject;
import org.eclipse.egit.core.GitTag;
import org.unicase.changetracking.exceptions.VCSException;
import org.unicase.changetracking.git.common.GitRepoFindUtil;
import org.unicase.changetracking.vcs.VCSAdapter;
import org.unicase.changetracking.vcs.VCSAdapterProvider;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.RepositoryRevision;
import org.unicase.model.changetracking.RepositoryStream;
import org.unicase.model.changetracking.git.GitBranch;
import org.unicase.model.changetracking.git.GitBranchChangePackage;

/**
 * Adapter provider for Git. Mainly identifies the different objects by their
 * class.
 * 
 * @author jfinis
 * 
 */
public class GitVCSAdapterProvider implements VCSAdapterProvider {

	/**
	 * Is able to provide if repo stream is a git branch.
	 * 
	 * {@inheritDoc}
	 */
	public boolean providesForStream(RepositoryStream stream) {
		return stream instanceof GitBranch;
	}

	/**
	 * Is able to provide if revision is a git tag.
	 * 
	 * {@inheritDoc}
	 */
	public boolean providesForRevision(RepositoryRevision revision) {
		return revision instanceof GitTag;
	}

	/**
	 * Is able to provide if the change package is a git branch change package.
	 * 
	 * {@inheritDoc}
	 */
	public boolean providesForChangePackage(ChangePackage pkg) {
		return pkg instanceof GitBranchChangePackage;
	}

	/**
	 * Is able to provide if the project is under git version control.
	 * 
	 * {@inheritDoc}
	 */
	public boolean providesForProjects(IProject... projects) {
		try {
			return null != GitRepoFindUtil.findRepoForProjects(projects);
		} catch (VCSException e) {
			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public VCSAdapter create() {
		return new GitVCSAdapter();
	}

}
