package org.unicase.ui.web;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.unicase.web.updater.UpdateProjectHandler;
import org.unicase.web.updater.handlers.LoginHandler;
import org.unicase.web.util.Configuration;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.unicase.ui.web";

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		init();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
	
	private static void init() {
		 //Object obj = RWT.getRequest().getParameterMap().get("project");
		
		//if (obj != null) {
			String projectName = "unicase"; // (((String[]) obj)[0]);

			if (projectName != null) {
//				Configuration.initialize();
//				LoginHandler login = new LoginHandler(Configuration
//						.getProperties().getProperty("hostname"));
//				login.run();
//				Thread updaterThread = new Thread(new UpdateProjectHandler(projectName));
//				updaterThread.start();
			}
		//}
	}
	
}
