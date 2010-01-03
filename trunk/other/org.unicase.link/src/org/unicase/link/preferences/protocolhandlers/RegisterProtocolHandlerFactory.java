package org.unicase.link.preferences.protocolhandlers;

public class RegisterProtocolHandlerFactory {

	public AbstractRegisterProtocolHandler getRegisterProtocolHandler(String osName) {
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
