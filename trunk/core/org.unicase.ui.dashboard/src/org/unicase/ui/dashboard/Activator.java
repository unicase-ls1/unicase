/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.dashboard;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 */
public class Activator extends AbstractUIPlugin {

	/**
	 * The plug-in ID.
	 */
	public static final String PLUGIN_ID = "org.unicase.ui.dashboard";

	// The shared instance
	private static Activator plugin;

	private boolean shouldFixHeightForCocoa;

	/**
	 * The constructor.
	 */
	public Activator() {
		Bundle bundle = Platform.getBundle("org.eclipse.swt.cocoa.macosx");
		if(bundle!=null &&
			bundle.getVersion().getMajor() == 3 &&
			bundle.getVersion().getMinor() == 5){
				shouldFixHeightForCocoa = true;
		}
	}
	
	/**
	 * Fixes a bug in the Cocoa implementation of the SWT Link control (version 3.5). 
	 * Note that this is a rather <b>quick</b> workaround since this issue is supposed to be fixed in 3.6.
	 * It may not apply for all use cases of the Link control!
	 * @param height
	 * @return
	 */
	public int fixHeightForCocoa(int height){
		if(!shouldFixHeightForCocoa){
			return height;
		}
		double fix = 1.5;
		if(height<=15){
			// two liners need a different fix 
			fix = 2.0;
		}
		int ret = (int) (fix*height);
		return ret;
	}

	// BEGIN SUPRESS CATCH EXCEPTION
	
	/**
	 * {@inheritDoc}
	 * @throws Exception if any error occurs
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/**
	 * {@inheritDoc}
	 * @throws Exception if any error occurs
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
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path.
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
