/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap;

import org.osgi.framework.BundleContext;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.jface.resource.ImageDescriptor;

import config.ConfigEntity;
import org.unicase.rap.config.ConfigEntityStore;
import org.unicase.rap.updater.ProjectUpdaterManager;
import org.unicase.rap.config.EMFServerSettingsConfigEntity;

/**
 * The activator class controls the plug-in life cycle.
 */
public class Activator extends AbstractUIPlugin {

	/** The plug-in ID. */
	public static final String PLUGIN_ID = "org.unicase.rap";

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor.
	 */
	public Activator() {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		init();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
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
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path.
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
	
	/**
	 * Initializes project updater thread.
	 */
	private static void init() {
		EMFServerSettingsConfigEntity configEntity = new EMFServerSettingsConfigEntity();
		ConfigEntity entity = ConfigEntityStore.loadConfigEntity(configEntity, configEntity.eClass());	
		
		if(entity != null) {
			String emfServerUrl = configEntity.getEmfServerUrl();	
			String emfServerUsername = configEntity.getEmfServerUserName();
			String emfServerPassword = configEntity.getEmfServerUserPassword();
			if(emfServerUrl != null && !emfServerUrl.equals("") 
				&& emfServerUsername != null && !emfServerUsername.equals("")
				&& emfServerPassword != null && !emfServerPassword.equals("")) {
				ProjectUpdaterManager mng = ProjectUpdaterManager.getInstance();
				mng.sychronizeProjectLists();
				Thread updaterThread = new Thread(mng);
				updaterThread.start();
				System.out.println("main thread");
			}
		}
		
	}
	
}
