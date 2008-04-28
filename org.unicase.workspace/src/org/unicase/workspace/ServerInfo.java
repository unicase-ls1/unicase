package org.unicase.workspace;

public class ServerInfo {
	
	private String url;
	private String name;
	private String port;
	
	public ServerInfo(String url, String name, String port) {
		this.url=url;
		this.port=port;
		this.name=name;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}
	
}
