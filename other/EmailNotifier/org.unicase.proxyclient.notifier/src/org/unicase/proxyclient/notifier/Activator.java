/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.proxyclient.notifier;

import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.unicase.proxyclient.notifier.client.NotificationProxyClientException;

/**
 * The activator class controls the plug-in life cycle.
 * 
 * @author staudta
 */
public class Activator extends AbstractUIPlugin {

	/**
	 * The plug-in ID.
	 */
	public static final String PLUGIN_ID = "org.unicase.proxyclient.notifier";

	/**
	 * The shared instance.
	 */
	private static Activator plugin;
	
	/**
	 * The constructor.
	 */
	public Activator() {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws NotificationProxyClientException {
		try {
			super.start(context);
		} catch (Exception e) {
			throw new NotificationProxyClientException("Plugin Bundle start failed!", e);
		}
		plugin = this;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws NotificationProxyClientException {
		plugin = null;
		try {
			super.stop(context);
		// BEGIN SUPRESS CATCH EXCEPTION
		} catch(Exception e) {
		// END SUPRESS CATCH EXCEPTION
			throw new NotificationProxyClientException("Plugin Bundle stop failed!", e);
		}
	}

	/**
	 * Returns the shared instance.
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in relative path.
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
	
	/**
	 *Logs exception.
	 * 
	 * @param e exception
	 */
	public static void logException(Exception e) {
		getDefault().getLog().log(new Status(Status.ERROR, Activator.getDefault().getBundle().getSymbolicName(), e.getMessage(), e));
	}
	
	/**
	 * Logs information.
	 * 
	 * @param int The int value should be a constant of e.g Status.INFO, Status.ERROR ... Don't pass the int value by itself.
	 * @param message info message to log
	 */
	public static void log(int status, String message) {
		getDefault().getLog().log(new Status(status, Activator.getDefault().getBundle().getSymbolicName(), message));
	}
}
