/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.openurl;

import it.sauronsoftware.junique.AlreadyLockedException;
import it.sauronsoftware.junique.JUnique;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.unicase.openurl.handlers.URLMessageHandler;
import org.unicase.openurl.preferences.protocolhandlers.AbstractRegisterProtocolHandler;
import org.unicase.openurl.preferences.protocolhandlers.RegisterProtocolHandlerFactory;
import org.unicase.openurl.util.FileLocations;
import org.unicase.openurl.util.ui.OpenURL;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Activator class for link plugin.
 * 
 * @author Kameliya Terzieva, Fatih Ulusoy, Jan Finis
 */
public class Activator extends AbstractUIPlugin implements IStartup {

	/**
	 * The Plugin ID.
	 */
	public static final String PLUGIN_ID = "org.unicase.openurl";

	// The shared instance
	private static Activator plugin;

	private boolean yes;

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
	@Override
	// BEGIN SUPRESS CATCH EXCEPTION
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/**
	 * Plugin stop.
	 * 
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

	public void earlyStartup() {

		RegisterProtocolHandlerFactory fac = new RegisterProtocolHandlerFactory();
		AbstractRegisterProtocolHandler protocolHandler = fac.getRegisterProtocolHandler();
		if (protocolHandler == null) {
			// write an entry in error log
			WorkspaceUtil.logException("Could not find protocol handler.", new NullPointerException());
		}

		if (!protocolHandler.isHandlerRegistered() /* && !dialogSetting.dontShowAgin() */) {
			Display.getDefault().syncExec(new Runnable() {
				public void run() {
					yes = MessageDialog.openQuestion(PlatformUI.getWorkbench().getDisplay().getActiveShell(),
						"Unicase Protocol Registraion", "Protocol is not registered. Do you want to register it?");

				}
			});

			if (yes) {
				protocolHandler.registerHandler();
			}
		}

		try {
			JUnique.acquireLock(PLUGIN_ID, new URLMessageHandler());
			WorkspaceUtil.log("UNICASE URL plugin initialized.", null, 0);

			File lockFile = new File(FileLocations.LOCK_FILE);

			if (lockFile.exists()) {
				String link = readLockFile(lockFile);

				if (link == null) {
					// TODO: should we show a dialog to the user?
				} else {
					OpenURL.openURL(link);
					lockFile.delete();
				}
			}
		} catch (AlreadyLockedException e) {
			// Another instance of eclipse is already running, do nothing.
			return;
		} catch (IOException e) {
			return;
		}

	}

	private String readLockFile(File lockFile) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader(lockFile));
		String link = b.readLine();
		b.close();

		if (link == null) {
			// if the file is empty for some reason, get rid of it
			lockFile.delete();
			return null;
		}

		return link;
	}
}
