/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.proxyclient.notifier.email;

/**
 * MailerInfo stores all information that are need to send an email.
 * 
 * @author staudta
 */
public class MailerInfo {
	
	private final String host;
	private final int port;
	private final String user;
	private final String password;
	private final boolean useSSL;
	private final String sender;
	
	/**
	 * Constructor.
	 * 
	 * @param host host name to the smtp service
	 * @param port port for accessing the smtp service
	 * @param user login user name to login
	 * @param password password for the user name
	 * @param useSSL should a SSL connection be used
	 * @param sender sender address that will be used for outgoing emails
	 */
	public MailerInfo(String host, int port, String user, String password, boolean useSSL, String sender) {
		this.host = host;
		this.port = port;
		this.user = user;
		this.password = password;
		this.useSSL = useSSL;
		this.sender = sender;
	}
	
	/**
	 * Get the login user name.
	 * 
	 * @return user name
	 */
	public String getUsername() {
		return user;
	}
	
	/**
	 * Get the password for the user name.
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Get the host to the smtp service.
	 * 
	 * @return host
	 */
	public String getHost() {
		return host;
	}
	
	/**
	 * Get the port to the smtp service.
	 * 
	 * @return port
	 */
	public int getPort() {
		return port;
	}
	
	/**
	 * Tells if a SSL connection should be used.
	 * 
	 * @return use ssl
	 */
	public boolean useSSL() {
		return useSSL;
	}
	
	/**
	 * Get the sender address.
	 * 
	 * @return sender
	 */
	public String getSender() {
		return sender;
	}
	
}
