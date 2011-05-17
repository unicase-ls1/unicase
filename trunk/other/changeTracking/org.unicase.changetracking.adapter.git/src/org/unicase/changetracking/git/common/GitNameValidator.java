/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.common;

import org.unicase.changetracking.vcs.NameValidator;
import org.unicase.model.changetracking.RepositoryLocation;
import org.unicase.model.changetracking.git.GitRepository;

public class GitNameValidator implements NameValidator{

	public String cleanName(String name) {
		return GitNameUtil.cleanName(name);
	}

	public String isNewTagNameValid(String text, RepositoryLocation repoLoc) {
		return GitNameUtil.isNewTagNameValid(text, GitRepoFindUtil.findAssociatedLocalRepo((GitRepository) repoLoc));
	}

}
