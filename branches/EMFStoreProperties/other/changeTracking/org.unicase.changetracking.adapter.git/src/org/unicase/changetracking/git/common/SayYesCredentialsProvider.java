/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.common;

import java.util.Arrays;

import org.eclipse.jgit.errors.UnsupportedCredentialItem;
import org.eclipse.jgit.transport.CredentialItem;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.URIish;

/**
 * Simple {@link CredentialsProvider} that always uses the same information and
 * always answers any Yes/No questions with Yes.
 * 
 * @author jfinis
 */
public class SayYesCredentialsProvider extends CredentialsProvider {

	private String username;

	private char[] password;

	/**
	 * Initialize the provider with a single username and password.
	 * 
	 * @param username username
	 * @param password password
	 */
	public SayYesCredentialsProvider(String username, String password) {
		this(username, password.toCharArray());
	}

	/**
	 * Initialize the provider with a single username and password.
	 * 
	 * @param username username
	 * @param password password
	 */
	public SayYesCredentialsProvider(String username, char[] password) {
		this.username = username;
		this.password = password;
	}

	@Override
	public boolean isInteractive() {
		return false;
	}

	@Override
	public boolean supports(CredentialItem... items) {
		for (CredentialItem i : items) {
			if (i instanceof CredentialItem.Username) {
				continue;
			} else if (i instanceof CredentialItem.Password) {
				continue;
			} else if (i instanceof CredentialItem.YesNoType) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean get(URIish uri, CredentialItem... items) throws UnsupportedCredentialItem {
		for (CredentialItem i : items) {
			if (i instanceof CredentialItem.Username) {
				((CredentialItem.Username) i).setValue(username);
			} else if (i instanceof CredentialItem.Password) {
				((CredentialItem.Password) i).setValue(password);
			} else if (i instanceof CredentialItem.YesNoType) {
				((CredentialItem.YesNoType) i).setValue(true);
			} else {
				throw new UnsupportedCredentialItem(uri, i.getPromptText());
			}
		}
		return true;
	}

	/** Destroy the saved username and password.. */
	public void clear() {
		username = null;

		if (password != null) {
			Arrays.fill(password, (char) 0);
			password = null;
		}
	}
}