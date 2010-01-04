/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.link.preferences.protocolhandlers;

import java.io.IOException;

/**
 * @author emueller
 * @author tobi
 */
public class WindowsRegisterProtocolHandler extends AbstractRegisterProtocolHandler {

	@Override
	public void registerProtocolHandler() {
		try {
			Runtime.getRuntime().exec("reg add HKCR\\unicase /ve /d \"URL:unicase Protocol\"");
			Runtime.getRuntime().exec("reg add HKCR\\unicase /v \"URL Protocol\"");
			Runtime.getRuntime().exec(
				"reg add HKCR\\unicase\\Shell\\Open\\Command /ve /d \"" + getJavaExecutionCmd() + " %1\"");
		} catch (IOException e) {
			showError(e.getMessage());
		}
	}
}
