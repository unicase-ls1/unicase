package org.unicase.proxyclient.notifier.email;

/**
 * Mail Service Info.
 * 
 * @author Adrian Staudt <staudta@in.tum.de>
 */
public class MailerInfo {
	
	private final String host;
	private final int port;
	private final String user;
	private final String password;
	private final boolean useSSL;
	private final String sender;
	
	public MailerInfo(String host, int port, String user, String password, boolean useSSL, String sender) {
		this.host = host;
		this.port = port;
		this.user = user;
		this.password = password;
		this.useSSL = useSSL;
		this.sender = sender;
	}

	public String getUsername() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public boolean useSSL() {
		return useSSL;
	}
	
	public String getSender() {
		return sender;
	}
	
}
