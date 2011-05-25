/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.git.ui;

import java.io.IOException;

import org.eclipse.equinox.security.storage.ISecurePreferences;
import org.eclipse.equinox.security.storage.SecurePreferencesFactory;
import org.eclipse.equinox.security.storage.StorageException;
import org.eclipse.jface.window.Window;
import org.eclipse.jgit.errors.UnsupportedCredentialItem;
import org.eclipse.jgit.transport.CredentialItem;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.swt.widgets.Display;
import org.unicase.changetracking.exceptions.CancelledByUserException;
import org.unicase.changetracking.git.exceptions.UnexpectedGitException;
import org.unicase.changetracking.ui.UIUtil;

/**
 * Credentials provider which first tries to get the username and password
 * from the secure storage. If the user name and password are not there,
 * a dialog is displayed where the user can choose user name and password
 * and can select to save these values in the secure store.
 * 
 * @author jfinis
 *
 */
public class UICredentialsProvider extends CredentialsProvider{

	private static ISecurePreferences secureStorage = SecurePreferencesFactory.getDefault();

	private boolean showDialogIfDataPresent;
	
	/**
	 * User password combination.
	 * 
	 * @author jfinis
	 *
	 */
	private static class UsrPass{
		private String username;
		private String password;
		public UsrPass(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}
		
		public UsrPass(UsernamePasswordDialog dialog){
			this.username = dialog.getUsername();
			this.password = dialog.getPassword();
		}
		
		public String getUsername() {
			return username;
		}
		public String getPassword() {
			return password;
		}

	}

	/**
	 * Default constructor.
	 * @param showDialogIfDataPresent if true, the choose dialog will
	 * be shown even if user name and password are present in the
	 * secure storage. 
	 */
	public UICredentialsProvider(boolean showDialogIfDataPresent) {
		this.showDialogIfDataPresent = showDialogIfDataPresent;
	}
	
	
	private ISecurePreferences getNode(URIish uri){
		return secureStorage.node("/GitPrevs/" + uri.getHost());
	}
	/**
	 * Tries to retrieve the username and password
	 * from the secure store. Returns null
	 * if no values are found in the secure store
	 * 
	 * @param uri uri for which to retrieve username and password
	 * @return username and password or null if not found in the secure store
	 */
	private UsrPass getFromSecure(URIish uri){
		ISecurePreferences node = getNode(uri);
		try {
			String pwd = node.get("password", null);
			String user = node.get("user", null);
			if(user == null){
				return null;
			}
			return new UsrPass(user, pwd);
		} catch (StorageException e) {
			throw new UnexpectedGitException("Unable to load username and password from secure storage",e);
		}
	}
	
	@Override
	public boolean isInteractive() {
		return true;
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
		UsrPass up = getFromSecure(uri);
		boolean promted = false;
		for (CredentialItem i : items) {
			if (i instanceof CredentialItem.Username) {
				if(!promted){
					up = promptUser(uri,up);
					promted = true;
				}
				((CredentialItem.Username) i).setValue(up.getUsername());
			} else if (i instanceof CredentialItem.Password) {
				if(!promted){
					up = promptUser(uri,up);
					promted = true;
				}
				((CredentialItem.Password) i).setValue(up.getPassword().toCharArray());
			} else if (i instanceof CredentialItem.YesNoType) {
				((CredentialItem.YesNoType) i).setValue(true);
			} else {
				throw new UnsupportedCredentialItem(uri, i.getPromptText());
			}
		}
		return true;
	}

	private UsrPass promptUser(URIish uri, UsrPass up) {
		if(up == null){
			return openPrompt(uri,"","");
		} else if(up.getPassword() == null) {
			return openPrompt(uri,up.getUsername(),"");
		} else {
			//Credentials are already provided
			if(showDialogIfDataPresent){
				return openPrompt(uri, up.getUsername(), up.getPassword());
			}
			return up;
		}
	}

	private UsrPass openPrompt(final URIish uri, final String usr, final String pwd) {
		final UsrPass[] result = new UsrPass[1];
		final boolean[] save = new boolean[1];
		Display.getDefault().syncExec(new Runnable() {
			
			public void run() {
				UsernamePasswordDialog dia = new UsernamePasswordDialog(UIUtil.getActiveShell(), usr, pwd, uri.toString());
				if(dia.open() == Window.OK){
					result[0] = new UsrPass(dia);
					save[0] = dia.wantSave();
				}
			}
		});
		if(result[0] == null){
			throw new CancelledByUserException();
		}
		if(save[0]){
			saveToStorage(uri, result[0]);
		}
		return result[0];
	}

	private void saveToStorage(URIish uri, UsrPass usrPass) {
		ISecurePreferences node = getNode(uri);
		try {
			node.put("user", usrPass.getUsername(), false);
			node.put("password", usrPass.getPassword(), true);
			node.flush();
		} catch (StorageException e) {
		} catch (IOException e) {
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void clear() {
	}
}
