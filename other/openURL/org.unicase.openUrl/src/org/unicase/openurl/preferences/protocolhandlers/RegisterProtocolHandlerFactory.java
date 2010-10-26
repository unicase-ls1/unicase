/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.openurl.preferences.protocolhandlers;

/**
 * Factory for protocol registration handlers.
 * 
 * @author emueller
 */
public class RegisterProtocolHandlerFactory {

	private static RegisterProtocolHandlerFactory instance;

	/**
	 * Gets an instance of the factory.
	 * 
	 * @return an instance of the factory
	 */
	public static RegisterProtocolHandlerFactory getInstance() {
		if (instance == null) {
			instance = new RegisterProtocolHandlerFactory();
		}

		return instance;
	}

	/**
	 * @param osName the
	 * @return
	 */
	public AbstractRegisterProtocolHandler getRegisterProtocolHandler() {
		String osName = System.getProperty("os.name").toLowerCase();
		if (isWindows(osName)) {
			return new WindowsRegisterProtocolHandler();
		} else if (isMac(osName)) {
			return new MacOSRegisterProtocolHandler();
		} else if (isLinux(osName)) {
			return new LinuxRegisterProtocolHandler();
		}

		return null;
	}

	private static boolean isWindows(String osName) {
		return (osName.toLowerCase().indexOf("win") >= 0);
	}

	private static boolean isMac(String osName) {
		return (osName.toLowerCase().indexOf("mac") >= 0);
	}

	private static boolean isLinux(String osName) {
		osName = osName.toLowerCase();
		return (osName.indexOf("nix") >= 0 || osName.indexOf("nux") >= 0);
	}
}
