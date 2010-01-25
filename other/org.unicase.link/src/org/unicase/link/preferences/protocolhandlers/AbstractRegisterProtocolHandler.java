/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.link.preferences.protocolhandlers;

import java.io.File;
import java.io.IOException;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.unicase.link.util.FileLocations;

/**
 * Class for registering the UNICASE protocol handler on an operating system. Also provides some helper methods for
 * getting information about the eclipse instance used.
 * 
 * @author emueller
 */
public abstract class AbstractRegisterProtocolHandler {

	/**
	 * Register the protocol handler on an operating system.
	 */
	public abstract void registerProtocolHandler();

	/**
	 * Determines whether the protocol handler has been registered successfully.
	 */
	public abstract boolean isProtocolHandlerRegistered();

	/**
	 * Opens up a error dialog showing the user the given text.
	 * 
	 * @param msgText The text to be shown within the message dialog
	 */
	protected void showError(final String msgText) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				MessageDialog.openError(Display.getDefault().getActiveShell(), "Error", msgText);
			}
		});
	}

	/**
	 * Gets the absolute path of the startup jar.
	 * 
	 * @return the absolute path of the startup jar
	 * @throws IOException if the startup jar doesn't exist
	 */
	public String getStartUpJar() throws IOException {
		return FileLocations.getPluginFeaturesDirectory() + File.separator + "org.unicase.link.startup.jar";
	}

	/**
	 * The java command that will be executed when clicking a UNICASE link. This command is responsible for passing the
	 * actual link to the startup jar
	 * 
	 * @return the command to be executed
	 * @throws IOException
	 */
	public String getJavaExecutionCmd() throws IOException {
		return "java -jar " + getStartUpJar();
	}

	/**
	 * Gets the absolute path of the eclipse executable. Note that on Mac OS this is not the application bundle.
	 * 
	 * @return
	 */
	public String getEclipseExecutable() {
		String osName = System.getProperty("os.name").toLowerCase();
		String eclipseDir = FileLocations.getEclipseFilePath();
		String executable;

		if (osName.contains("win")) {
			executable = "eclipse.exe";
		} else if (osName.contains("mac")) {
			executable = "eclipse.app" + File.separator + "Contents" + File.separator + "MacOS" + File.separator
				+ "eclipse";
		} else {
			executable = "eclipse";
		}

		return eclipseDir + executable;
	}
}
