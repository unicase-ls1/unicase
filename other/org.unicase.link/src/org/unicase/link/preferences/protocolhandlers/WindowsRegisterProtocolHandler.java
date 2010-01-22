/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.link.preferences.protocolhandlers;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.unicase.workspace.util.WorkspaceUtil;

/**
 * @author emueller
 * @author tobi
 */
public class WindowsRegisterProtocolHandler extends AbstractRegisterProtocolHandler {

	private static final String PROTOCOL_NAME = "reg add HKCR\\unicase /v \"URL Protocol\"";
	private static final String PROTOCOL_PREFIX = "reg add HKCR\\unicase /ve /d \"URL:unicase Protocol\"";
	private static final String REGSTR_TOKEN = "REG_SZ";

	@Override
	public void registerProtocolHandler() {
		try {
			Runtime.getRuntime().exec(PROTOCOL_PREFIX);
			Runtime.getRuntime().exec(PROTOCOL_NAME);
			Runtime.getRuntime().exec(
				"reg add HKCR\\unicase\\Shell\\Open\\Command /ve /d \"" + getJavaExecutionCmd() + " %1 \"");
		} catch (IOException e) {
			showError(e.getMessage());
		}
	}

	public static String getRegistryEntry(String key) {
		try {
			Process process = Runtime.getRuntime().exec(key);
			StreamReader reader = new StreamReader(process.getInputStream());

			reader.start();
			process.waitFor();
			reader.join();

			String result = reader.getResult();
			int p = result.indexOf(REGSTR_TOKEN);

			if (p == -1)
				return null;

			return result.substring(p + REGSTR_TOKEN.length()).trim();
		} catch (Exception e) {
			WorkspaceUtil.logException(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public boolean isProtocolHandlerRegistered() {
		return true;
	}

	// http://www.rgagnon.com/javadetails/java-0480.html
	static class StreamReader extends Thread {
		private final InputStream is;
		private final StringWriter sw;

		StreamReader(InputStream is) {
			this.is = is;
			sw = new StringWriter();
		}

		@Override
		public void run() {
			try {
				int c;
				while ((c = is.read()) != -1)
					sw.write(c);
			} catch (IOException e) {
				;
			}
		}

		String getResult() {
			return sw.toString();
		}
	}

}
