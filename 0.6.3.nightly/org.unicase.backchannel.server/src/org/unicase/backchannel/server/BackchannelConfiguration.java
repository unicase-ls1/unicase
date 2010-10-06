/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.backchannel.server;

import java.util.Properties;

import org.unicase.emfstore.ServerConfiguration;

/**
 * Configuration file for the backchannel.
 * 
 * @author wesendon
 */
public final class BackchannelConfiguration {

	private BackchannelConfiguration(){
	}

	/**
	 * RMI port property.
	 */
	public static final String BACKCHANNEL_RMI_PORT = "emfstore.backchannel.rmi.port";

	/**
	 * Default value for rmi port property.
	 */
	public static final String BACKCHANNEL_RMI_PORT_DEFAULT = "3000";

	/**
	 * Returns the properties, using {@link ServerConfiguration}.
	 * @return java properties
	 */
	public static Properties getProperties() {
		return ServerConfiguration.getProperties();
	}

	/**
	 * Gets a integer property. 
	 *
	 * @param propertyName propertyname
	 * @param defaultProperty default property
	 * @return property value
	 */
	public static int getNumberProperty(String propertyName,
			String defaultProperty) {
		String property = getProperties().getProperty(propertyName);
		try {
			if (property != null) {
				return Integer.parseInt(property);
			}
		} catch (NumberFormatException e) {
		}
		return Integer.parseInt(defaultProperty);
	}

}
