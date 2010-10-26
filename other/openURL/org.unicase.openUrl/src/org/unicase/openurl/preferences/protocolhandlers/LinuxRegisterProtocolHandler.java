/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.openurl.preferences.protocolhandlers;

import java.io.File;
import java.io.IOException;

import org.unicase.openurl.util.FileLocations;

/**
 * Protocol registration handler for Linux.
 * 
 * @author edgar
 * @author svetlana
 */
// TODO: refactor code
public class LinuxRegisterProtocolHandler extends AbstractRegisterProtocolHandler {

	@Override
	public void registerProtocolHandler() {
		File shellScript = new File(FileLocations.getPluginFeaturesDirectory() + File.separator
			+ "registerUnicaseProtocolHandler.sh");

		if (!shellScript.exists()) {
			showError("Missing shellscript.\nPlease try reinstalling the UNICASE OpenURL feature.");
		}

		// make script executable and execute it
		try {
			Runtime.getRuntime().exec("chmod +x " + shellScript.getAbsolutePath());
			// the command to be executed when a UNICASE URL has been clicked is passed as the
			// first argument
			Runtime.getRuntime().exec(
				new String[] {
					"/bin/sh",
					"-c",
					shellScript.getAbsolutePath() + " \"register\" \"java -jar " + getStartUpJar() + "\" " + "\""
						+ FileLocations.getPluginFeaturesDirectory() + "\"" });
		} catch (IOException e) {
			showError(e.getMessage());
		}
	}

	@Override
	public boolean isProtocolHandlerRegistered() {

		File shellScript = new File(FileLocations.getPluginFeaturesDirectory() + File.separator
			+ "registerUnicaseProtocolHandler.sh");

		if (!shellScript.exists()) {
			showError("Missing shellscript.\nPlease try reinstalling the UNICASE OpenURL feature.");
		}

		try {
			Process p = Runtime.getRuntime().exec(
				new String[] { "/bin/sh", "-c", shellScript.getAbsolutePath() + " check" });
			int retCode = p.waitFor();

			if (retCode != 0) {
				// not registered
				return false;
			}

			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
}
