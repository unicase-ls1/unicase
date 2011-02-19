/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigatormeeditorbridge;

import org.osgi.framework.BundleContext;
import org.unicase.ui.util.AbstractUnicaseUIPlugin;

/**
 * The activator class controls the plug-in life cycle.
 */
public class Activator extends AbstractUnicaseUIPlugin {

	/**
	 * Plugin ID.
	 */
	public static final String PLUGIN_ID = "org.unicase.ui.navigatormeeditorbridge";

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor.
	 */
	public Activator() {
	}
	// BEGIN SUPRESS CATCH EXCEPTION
	/**
	 * {@inheritDoc}
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/**
	 * {@inheritDoc}
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

}