/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.unicase.changetracking.commands.BuildReleaseCommand;

/**
 * The activator class controls the plug-in life cycle.
 */
public class Activator extends AbstractUIPlugin {

	/**
	 * The plug-in ID.
	 */
	public static final String PLUGIN_ID = "org.unicase.changetracking.ui";

	// The shared instance
	private static Activator plugin;

	private static BuildReleaseCommand lastConflictingCommand;

	/**
	 * Returns the latest conflicting build release command. This is used to
	 * continue the release building after the conflicts have been resolved.
	 * 
	 * @return latest conflicting command.
	 */
	public static BuildReleaseCommand getLastConflictingCommand() {
		return lastConflictingCommand;
	}

	/**
	 * Sets the latest conflicting release command.
	 * 
	 * @param lastConflictingCommand the command
	 */
	public static void setLastConflictingCommand(BuildReleaseCommand lastConflictingCommand) {
		Activator.lastConflictingCommand = lastConflictingCommand;
	}

	/**
	 * The constructor.
	 */
	public Activator() {}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */

	// BEGIN SUPRESS CATCH EXCEPTION
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
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
	 * .
	 * 
	 * @param path image path
	 * @return image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

}
