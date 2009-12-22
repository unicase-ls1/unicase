package org.unicase.link.preferences.protocolhandlers;

import java.io.IOException;

public class WindowsRegisterProtocolHandler implements IRegisterProtocolHandler {

	/**
	 * On Windows eclipseInfo is the path where eclipse has been installed.
	 */
	public void registerProtocolHandler(String eclipseInfo) {
		try {
			Runtime.getRuntime().exec("reg add HKCR\\unicase /ve /d \"URL:unicase Protocol\"");
			Runtime.getRuntime().exec("reg add HKCR\\unicase /v \"URL Protocol\"");
			Runtime.getRuntime().exec("reg add HKCR\\unicase\\Shell\\Open\\Command /ve /d " + eclipseInfo + " %%1");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
