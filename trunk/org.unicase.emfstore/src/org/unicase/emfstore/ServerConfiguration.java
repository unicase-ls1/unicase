/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore;

import java.io.File;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;

/**
 * Represents the current server configuration.
 * @author koegel
 *
 */
public final class ServerConfiguration {

	/**
	 * Constant for the name of the Resource Storage Property.
	 */
	public static final String RESOURCE_STORAGE = "ResourceStorage";

	/**
	 * Constant for the Default Resource Storage.
	 */
//	public static final String DEFAULT_RESOURCE_STORAGE = "org.unicase.emfstore.storage.TeneoStorage";
	public final static String DEFAULT_RESOURCE_STORAGE = "org.unicase.emfstore.storage.XMLStorage";

	
	private ServerConfiguration() {
		//nothing to do
	}
	
	/**
	 * Return the configuration directory location.
	 * @return the dir path string
	 */
	public static String getConfDirectory() {
		StringBuffer sb = new StringBuffer(getServerHome());
		sb.append(".");
		sb.append(File.separatorChar);
		sb.append("conf");
		sb.append(File.separatorChar);
		return sb.toString();
	}

	/**
	 * Return the configuration file location.
	 * @return the file path string
	 */
	public static String getConfFile() {
		return getConfDirectory() + "es.properties";
	}

	/**
	 * Return the server home directory location.
	 * @return the dir path string
	 */
	public static String getServerHome() {
		StringBuffer sb = new StringBuffer(getUserHome());
		sb.append(".unicase");
		sb.append(File.separatorChar);
		sb.append("emfstore");
		sb.append(File.separatorChar);
		return sb.toString();
	}

	/**
	 * Return the user home directory location.
	 * @return the dir path string
	 */
	public static String getUserHome() {
		StringBuffer sb = new StringBuffer();
		sb.append(System.getProperty("user.home"));
		sb.append(File.separatorChar);
		return sb.toString();
	}
}
