/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.emailnotifier;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 * 
 * @author staudta
 */
public class Activator extends Plugin {

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
	public void start(BundleContext context) {
		try {
			super.start(context);
		
		} catch (Exception e) {
			logException(e);
		}
		plugin = this;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) {
		plugin = null;
		try {
			super.stop(context);

		} catch(Exception e) {
			logException(e);
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
	 *Logs exception.
	 * 
	 * @param e exception
	 */
	public static void logException(Exception e) {
		getDefault().getLog().log(new Status(Status.ERROR, Activator.getDefault().getBundle().getSymbolicName(), e.getMessage(), e));
		
		// print error also to output
		e.printStackTrace(System.err);
	}
	
	/**
	 * Logs information.
	 * 
	 * @param status The status value should be a constant of e.g Status.INFO, Status.ERROR ... Don't pass the int value by itself.
	 * @param message info message to log
	 */
	public static void log(int status, String message) {
		getDefault().getLog().log(new Status(status, Activator.getDefault().getBundle().getSymbolicName(), message));
		
		if( status == Status.INFO ) {
			System.out.println( "Info: "+ message );
		} else if( status == Status.WARNING ) {
			System.out.println( "Warning: "+ message );
		} else if( status == Status.ERROR ) {
			System.out.println( "Error: "+ message );
		} else if( status == Status.CANCEL ) {
			System.out.println( "Cancel: "+ message );
		} else if( status == Status.OK ) {
			System.out.println( "OK: "+ message );
		}
	}
}
