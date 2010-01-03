package org.unicase.link.preferences.protocolhandlers;

import java.io.IOException;

public class WindowsRegisterProtocolHandler extends AbstractRegisterProtocolHandler {

	/**
	 * On Windows eclipseInfo is the path where eclipse has been installed.
	 */
	@Override
	public void registerProtocolHandler() {
		try {
			Runtime.getRuntime().exec("reg add HKCR\\unicase /ve /d \"URL:unicase Protocol\"");
			Runtime.getRuntime().exec("reg add HKCR\\unicase /v \"URL Protocol\"");
			Runtime.getRuntime().exec(
				"reg add HKCR\\unicase\\Shell\\Open\\Command /ve /d " + getJavaExecutionCmd() + " %%1");
		} catch (IOException e) {
			showError(e.getMessage());
		}
	}
}
