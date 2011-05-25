/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.vcs;

import org.unicase.model.changetracking.RepositoryLocation;

/**
 * The name validator interface is to be implemented to provide name validation
 * for different version control systems.
 * 
 * @author jfinis
 * 
 */
public interface INameValidator {

	/**
	 * Cleans a name, i.e. removes all characters which are not allowed in names
	 * used in the target version control system.
	 * 
	 * @param name name to be cleans
	 * @return cleaned name
	 */
	String cleanName(String name);

	/**
	 * Returns whether a tag name is valid for a repository location. The name
	 * might either be invalid because it contains forbidden characters or
	 * because the repository location already contains a tag with that name.
	 * 
	 * The method returns either null indicating that the name is valid or a
	 * string message which states why the name is not valid.
	 * 
	 * @param text tag name to be checked
	 * @param repoLoc repository location for which to check the tag name
	 * @return null if valid or a problem description message
	 */
	String isNewTagNameValid(String text, RepositoryLocation repoLoc);
}
