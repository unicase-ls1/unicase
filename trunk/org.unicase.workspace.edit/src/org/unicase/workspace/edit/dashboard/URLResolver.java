/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.dashboard;

/**
 * Class for resolving the URLs for the unified models.
 * 
 * @author Shterev
 */
public class URLResolver {

	/**
	 * The prefix for all unicase URLs.
	 */
	public static final String PREFIX = "unicase://";

	private String url;

	private String server;
	private String project;
	private String mid;
	private String revision;

	/**
	 * Default constructor.
	 * 
	 * @param url the url.
	 */
	public URLResolver(String url) {
		this.url = url;
		resolve();
	}

	private void resolve() {
		if (url.startsWith(PREFIX)) {
			String text = url.substring(PREFIX.length(), url.length() - 1);
			String[] elements = text.split("/");
			if (elements.length == 4) {
				server = elements[0];
				project = elements[1];
				mid = elements[2];
				revision = elements[3];
				return;
			} else if (elements.length == 3) {
				server = elements[0];
				project = elements[1];
				mid = elements[2];
				revision = "head";
				return;
			}
		}
		throw new IllegalArgumentException("Invalid unicase URL!");
	}

	/**
	 * @return the revision.
	 */
	public String getRevision() {
		return revision;
	}

	/**
	 * @return the mid.
	 */
	public String getMID() {
		return mid;
	}

	/**
	 * @return the project.
	 */
	public String getProject() {
		return project;
	}

	/**
	 * @return the server.
	 */
	public String getServer() {
		return server;
	}

}
