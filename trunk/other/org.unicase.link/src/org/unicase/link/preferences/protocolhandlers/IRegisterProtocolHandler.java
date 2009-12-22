package org.unicase.link.preferences.protocolhandlers;

public interface IRegisterProtocolHandler {

	/**
	 * @param eclipseId an String representing the information needed to register the protocol handler
	 */
	void registerProtocolHandler(String startUpJarPath);
}
