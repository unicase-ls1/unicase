package org.unicase.rap.login;

/*
 * A class that represents the user credential model for this app
 */
public class UserCredential {

	private String serverURL;
	private String username;
	private String password;

	public UserCredential(String serverURL, String username, String password) {
		this.serverURL = serverURL;
		this.username = username;
		this.password = password;
	}

	public String getServerURL() {
		return serverURL;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
