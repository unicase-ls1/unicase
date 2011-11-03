/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.unicase.ui.urml.stakeholders.config.UrmlSettingsManager;
import org.unicase.ui.urml.stakeholders.navigation.ReviewCountPublisher;

/**
 * The activator class controls the plug-in life cycle.
 */

public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	/**
	 * The plug-in ID.
	 */
	public static final String PLUGIN_ID = "org.unicase.ui.urml.stakeholders";

	// The shared instance
	private static Activator plugin;

	private final static Publisher roleChangedPublisher = new Publisher();
	private final static Publisher phaseChangedPublisher = new Publisher();
	/**
	 * The constructor.
	 */
	
	public Activator() {

	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	
	// BEGIN SUPRESS CATCH EXCEPTION

	@Override
	
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		Display.getDefault().asyncExec(new Runnable() {
			
			@Override
			public void run() {
				try{
					UrmlSettingsManager.INSTANCE.initFromProject(StakeholderUtil.getActiveProjectSpace());
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
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
	 * Returns an image descriptor for the image file at the given plug-in relative path.
	 * 
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}


	
	public static Publisher getRoleChangedPublisher() {
		return roleChangedPublisher;
	}
	
	public static Publisher getPhaseChangedPublisher() {
		return phaseChangedPublisher;
	}

}
