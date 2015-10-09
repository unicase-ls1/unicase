/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon;

import org.eclipse.emf.emfstore.internal.common.LogAdapter;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 */
public class Activator extends AbstractUIPlugin {
	private LogAdapter logAdapter;

	/**
	 * The plug-in ID.
	 */
	public static final String PLUGIN_ID = "org.unicase.ui.unicasecommon";

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor.
	 */
	public Activator() {
		logAdapter = new LogAdapter();
	}

	// BEGIN SUPRESS CATCH EXCEPTION

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	// END SUPRESS CATCH EXCEPTION

	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given. plug-in
	 * relative path
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	/**
	 * Logs the given exception with the given message and an additional status
	 * code to the error log.
	 * 
	 * @param message
	 *            the message to log
	 * @param exception
	 *            the exception to log
	 * @param statusInt
	 *            a status code
	 */
	public void log(String message, Exception exception, int statusInt) {
		logAdapter.log(message, exception, statusInt);
	}

	/**
	 * Logs an exception to the error log.
	 * 
	 * @param message
	 *            the message
	 * @param e
	 *            the exception
	 */
	public void logException(String message, Exception e) {
		logAdapter.logException(message, e);
	}

	/**
	 * Logs a warning to the error log.
	 * 
	 * @param message
	 *            the message
	 * @param e
	 *            the exception
	 */
	public void logWarning(String message, Exception e) {
		logAdapter.logWarning(message, e);
	}
}
