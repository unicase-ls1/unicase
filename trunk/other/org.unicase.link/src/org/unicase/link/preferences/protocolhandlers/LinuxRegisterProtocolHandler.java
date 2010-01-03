package org.unicase.link.preferences.protocolhandlers;

import java.io.File;
import java.io.IOException;

/**
 * Protocol registration handler on Linux.
 * 
 * @author edgar
 */
public class LinuxRegisterProtocolHandler extends AbstractRegisterProtocolHandler {

	@Override
	public void registerProtocolHandler() {
		File shellScript = new File(getFeaturesDirectory() + File.separator + "registerUnicaseProtocolHandler.sh");

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
}
