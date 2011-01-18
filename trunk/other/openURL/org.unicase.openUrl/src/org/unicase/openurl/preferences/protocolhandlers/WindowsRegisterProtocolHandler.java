/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.openurl.preferences.protocolhandlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.unicase.openurl.util.FileLocations;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * @author emueller
 * @author tobi
 */
public class WindowsRegisterProtocolHandler extends AbstractRegisterProtocolHandler {

	private static final String ADD_PROTOCOL_NAME_COMMAND = "reg add HKCR\\unicase /v \"URL Protocol\"";
	private static final String ADD_PROTOCOL_PREFIX_COMMAND = "reg add HKCR\\unicase /ve /d \"URL:unicase Protocol\"";
	private static final String REGSTR_TOKEN = "REG_SZ";

	@Override
	public void registerHandler() {
		try {
			String add_run_handler_command = "reg add HKCR\\unicase\\Shell\\Open\\Command /ve /d \"java -jar \\\""
				+ getStartUpJar() + "\\\" %1 " + "\\\"" + FileLocations.getPluginFeaturesDirectory() + "\\\"";
			Process process = Runtime.getRuntime().exec(ADD_PROTOCOL_PREFIX_COMMAND);
			if (!canRegisterProtocol(process)) {
				// write file, prompt user to run it manually;
				writeFile(ADD_PROTOCOL_PREFIX_COMMAND, ADD_PROTOCOL_NAME_COMMAND, add_run_handler_command);
				return;
			}

			Runtime.getRuntime().exec(ADD_PROTOCOL_NAME_COMMAND);
			// quotes must be written into registry entry in order that a path with spaces will
			// not get split up
			Runtime.getRuntime().exec(add_run_handler_command);
		} catch (IOException e) {
			showError(e.getMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void writeFile(String addProtocolPrefixCommand, String addProtocolNameCommand, String addRunHandlerCommand) {
		String desktopPath = System.getProperty("user.home") + File.separator + "Desktop";
		try {
			File registerProtocolFile = new File(desktopPath + File.separator + "register_unicase_protocol.bat");
			FileWriter fileWriter = new FileWriter(registerProtocolFile);
			fileWriter.write(addProtocolPrefixCommand + "\n" + addProtocolNameCommand + "\n" + addRunHandlerCommand
				+ "\n");

			showError("The unicase does not have enough rights to register its protocol. The commands needed to register the protocol are written in "
				+ registerProtocolFile.getAbsolutePath()
				+ " file. Please execute this file manually with administrator rights.");
			fileWriter.flush();
			fileWriter.close();

			// MessageDialog
			// .openInformation(
			// PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
			// "Unicase Protocol Registertion",
			// "The unicase does not have enough rights to register its protocol. The commands needed to register the protocol are written in "
			// + registerProtocolFile.getAbsolutePath()
			// + " file. Please execute this file manually with administrator rights.");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean canRegisterProtocol(Process process) throws InterruptedException {
		StreamReader reader = new StreamReader(process.getErrorStream());
		reader.start();
		process.waitFor();
		reader.join();
		String result = reader.getResult();
		return result.equals("");
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

			return result.substring(p).trim();

		} catch (Exception e) {
			WorkspaceUtil.logException(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public boolean isHandlerRegistered() {

		boolean regcheck = false;
		try {
			regcheck = getRegistryEntry("reg query HKCR\\unicase /v \"URL Protocol\"").equals(REGSTR_TOKEN);
			return regcheck;
		} catch (Exception e) {
			return false;
		}
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
