/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.common;

import java.io.IOException;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Repository;

public final class GitNameUtil {

	private GitNameUtil(){
	}

	
	public static String isNewBranchNameValid(String name, Repository repo){
		return isNewRefNameValid(Constants.R_HEADS, "branch", name, repo, true);
	}
	
	public static String isNewTagNameValid(String name, Repository repo){
		return isNewRefNameValid(Constants.R_TAGS, "tag", name, repo, true);
	}
	
	
	
	private static String isNewRefNameValid(String prefix, String refType, String name, Repository repo, boolean errorOnEmpty){
		if (name.length() == 0) {
			if(errorOnEmpty){
				return "The " + refType + " name may not be empty";
			} else {
				return null;
			}
		}
		String testFor = prefix + name;
		try {
			if (repo.resolve(testFor) != null)
				return "A " + refType + " with this name already exists";
		} catch (IOException e1) {
			return e1.getMessage();
		}
		if (!Repository.isValidRefName(testFor))
			return "This is not a valid " + refType + " name";
		return null;
		
	}
	
	public static IInputValidator getRefNameInputValidator(
			final Repository repo, final String refType, final String refPrefix, final boolean errorOnEmptyName) {
		return new IInputValidator() {
			public String isValid(String newText) {
				return isNewRefNameValid(refPrefix, refType, newText, repo, errorOnEmptyName);
			}
		};
	}


	public static String cleanName(String name) {
		name = name.trim();
		StringBuilder sb = new StringBuilder(name.length());
		for(int i=0;i<name.length();i++){
			char c = name.charAt(i);
			switch(c){
			case ' ': case '\n': case '\t':	case '\r':
				sb.append('_');
				break;
			case '/': case '\\': case '{': case '@':
			case '~': case '^': case ':':
			case '?': case '[': case '*':
				break;
			default:
				sb.append(c);
				break;
			}
		}
		return sb.toString();
	}
}
