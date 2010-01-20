/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.link.preferences.protocolhandlers;

import java.io.File;
import java.io.IOException;

import org.unicase.link.util.FileLocations;

/**
 * Protocol registration handler for Linux.
 * 
 * @author edgar
 * @author svetlana
 */
public class LinuxRegisterProtocolHandler extends AbstractRegisterProtocolHandler {

	@Override
	public void registerProtocolHandler() {
		File shellScript = new File(FileLocations.getPluginFeaturesDirectory() + File.separator
			+ "registerUnicaseProtocolHandler.sh");

		// make script executable and execute it
		try {
			Runtime.getRuntime().exec("chmod +x " + shellScript.getAbsolutePath());
			// the command to be executed when a UNICASE link has been clicked is passed as the
			// first argument
			Runtime.getRuntime().exec(
				new String[] { "/bin/sh", "-c", shellScript.getAbsolutePath() + " \"" + getJavaExecutionCmd() + "\"" });
		} catch (IOException e) {
			showError(e.getMessage());
		}
	}

	@Override
	public boolean isProtocolHandlerRegistered() {
		return true;
	}
}
