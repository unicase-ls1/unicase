/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.common;

import java.io.IOException;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.RefSpec;
import org.unicase.model.changetracking.git.GitBranch;
import org.unicase.model.changetracking.git.GitRevision;

/**
 * Utility class for Git name handling.
 * 
 * @author jfinis
 * 
 */
public final class GitNameUtil {

	/**
	 * Util class.
	 */
	private GitNameUtil() {}

	/**
	 * Checks whether a name for a new branch is valid. If not, an error message
	 * stating the problem with the name is returned.
	 * 
	 * @param name name to be checked
	 * @param repo repo in which the branch is to be created
	 * @return null if the name is valid, otherwise a message stating the
	 *         problem
	 */
	public static String isNewBranchNameValid(String name, Repository repo) {
		return isNewRefNameValid(Constants.R_HEADS, "branch", name, repo, true);
	}

	/**
	 * Checks whether a name for a new tag is valid. If not, an error message
	 * stating the problem is returned.
	 * 
	 * @param name tag name to be checked
	 * @param repo repo in which the tag is to be created
	 * @return null if the name is valid, otherwise a message stating the
	 *         problem
	 */
	public static String isNewTagNameValid(String name, Repository repo) {
		return isNewRefNameValid(Constants.R_TAGS, "tag", name, repo, true);
	}

	/**
	 * Checks whether the name of a newly created git ref is valid.
	 * 
	 * @param prefix prefix, like "refs/tags/" for tags
	 * @param refType ref type, like "tag". Will only be used in error messages.
	 * @param name name to be checked
	 * @param repo repo for which the name is to be checked
	 * @param errorOnEmpty whether the empty name "" should trigger an error.
	 * @return null if the name is valid, otherwise a message stating the
	 *         problem
	 */
	private static String isNewRefNameValid(String prefix, String refType, String name, Repository repo, boolean errorOnEmpty) {

		// Check for empty name
		if (name.length() == 0) {
			if (errorOnEmpty) {
				return "The " + refType + " name may not be empty";
			} else {
				return null;
			}
		}

		// Check for already existant name
		String testFor = prefix + name;
		try {
			if (repo.resolve(testFor) != null) {
				return "A " + refType + " with this name already exists";
			}
		} catch (IOException e1) {
			return e1.getMessage();
		}

		// Check for name validity
		if (!Repository.isValidRefName(testFor)) {
			return "This is not a valid " + refType + " name";
		}

		// Fine, no errors :)
		return null;

	}

	/**
	 * Returns a new IInputValidor which validates the input by calling
	 * isNewRefNameValid(...).
	 * 
	 * @see GitNameUtil#isNewRefNameValid(String, String, String, Repository,
	 *      boolean)
	 * 
	 * @param repo repo for which to check the input name
	 * @param refType ref type, used in error messages
	 * @param refPrefix prefix, like "refs/tags/" for tags
	 * @param errorOnEmptyName whether to return an error if the input is the
	 *            empty string.
	 * @return input validator.
	 */
	public static IInputValidator getRefNameInputValidator(final Repository repo, final String refType, final String refPrefix, final boolean errorOnEmptyName) {
		return new IInputValidator() {
			public String isValid(String newText) {
				return isNewRefNameValid(refPrefix, refType, newText, repo, errorOnEmptyName);
			}
		};
	}

	/**
	 * Cleans a git ref name by removing all forbidden characters.
	 * 
	 * @param name git ref name
	 * @return cleaned name
	 */
	// BEGIN COMPLEX CODE
	public static String cleanName(String name) {
		name = name.trim();
		StringBuilder sb = new StringBuilder(name.length());
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			switch (c) {
			case ' ':
			case '\n':
			case '\t':
			case '\r':
				sb.append('_');
				break;
			case '/':
			case '\\':
			case '{':
			case '@':
			case '~':
			case '^':
			case ':':
			case '?':
			case '[':
			case '*':
				break;
			default:
				sb.append(c);
				break;
			}
		}
		return sb.toString();
	}

	// END COMPLEX CODE

	/**
	 * Returns the full name of a git branch in the repository. I.e.
	 * refs/heads/BRANCHNAME
	 * 
	 * @param branch branch
	 * @return full name
	 */
	public static String getFullBranchNameFromBranch(GitBranch branch) {
		return Constants.R_HEADS + branch.getBranchName();
	}

	/**
	 * Retrieves a RefSpec correspondent to a Git branch model element.
	 * 
	 * @param branch Git branch model element
	 * @param force whether the ref spec should also be updated if a
	 *            non-fastforward-merge has to be done. This is similar to
	 *            prefixing the spec with '+'.
	 * @return corresponding RefSpec
	 */
	public static RefSpec getRefSpecFromGitBranch(GitBranch branch, boolean force) {
		String refSpec = getFullBranchNameFromBranch(branch);
		return new RefSpec((force ? "+" : "") + refSpec + ":" + refSpec);
	}

	/**
	 * Retrieves a RefSpec correspondent to a Git tag model element.
	 * 
	 * @param tag Git tag model element
	 * @param force whether the ref spec should also be updated if a
	 *            non-fastforward-merge has to be done. This is similar to
	 *            prefixing the spec with '+'.
	 * @return corresponding RefSpec
	 */
	public static RefSpec getRefSpecFromGitTag(GitRevision tag, boolean force) {
		String refSpec = Constants.R_TAGS + tag.getTagName();
		return new RefSpec((force ? "+" : "") + refSpec + ":" + refSpec);
	}
}
