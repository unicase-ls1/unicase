/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.common;

import org.unicase.changetracking.vcs.INameValidator;
import org.unicase.model.changetracking.RepositoryLocation;
import org.unicase.model.changetracking.git.GitRepository;

/**
 * Git implementation of a name validator.
 * 
 * Validates name to be suitable for git.
 * 
 * 
 * @author jfinis
 * 
 */
public class GitNameValidator implements INameValidator {

	/**
	 * {@inheritDoc}
	 */
	public String cleanName(String name) {
		return GitNameUtil.cleanName(name);
	}

	/**
	 * {@inheritDoc}
	 */
	public String isNewTagNameValid(String text, RepositoryLocation repoLoc) {
		return GitNameUtil.isNewTagNameValid(text, GitRepoFindUtil.findAssociatedLocalRepo((GitRepository) repoLoc));
	}

}
