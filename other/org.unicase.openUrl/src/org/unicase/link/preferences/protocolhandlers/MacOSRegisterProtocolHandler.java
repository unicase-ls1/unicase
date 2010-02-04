/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.link.preferences.protocolhandlers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.unicase.link.util.FileLocations;

/**
 * Protocol registration handler for Mac OS. To avoid the use of JNI an application bundle archived as a zip file is
 * packaged with the link feature. This application bundle associates itself with the UNICASE protocol without further
 * ado. When clicking a UNICASE link, the application bundle will send the received link to the startup jar which will
 * then open the model element requested.
 * 
 * @author emueller
 */
public class MacOSRegisterProtocolHandler extends AbstractRegisterProtocolHandler {

	@Override
	public void registerProtocolHandler() {
		String startUpJar;

		try {
			startUpJar = getStartUpJar();
			String libDir = startUpJar.substring(0, startUpJar.lastIndexOf(File.separatorChar));
			File zipFile = new File(libDir + File.separator + "UnicaseURLHandler.zip");

			if (!zipFile.exists()) {
				showError("Zip file UnicaseURLHandler.zip not found.");
			}

			unzip(zipFile);
			// set execute permission
			Runtime.getRuntime().exec(
				"chmod +x " + libDir + File.separator + "UnicaseURLHandler.app" + File.separator + "Contents"
					+ File.separator + "MacOS" + File.separator + "UnicaseURLHandler");
		} catch (IOException e) {
			showError(e.getMessage());
		}
	}

	/**
	 * Unzip the given file.
	 * 
	 * @param zip The zip file to be unarchived
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	private void unzip(File zip) throws IOException {
		Enumeration entries;
		ZipFile zipFile = new ZipFile(zip);
		entries = zipFile.entries();

		while (entries.hasMoreElements()) {
			ZipEntry entry = (ZipEntry) entries.nextElement();
			String extractDir = zip.getAbsolutePath().substring(0, zip.getAbsolutePath().lastIndexOf(File.separator));

			if (entry.isDirectory()) {
				// Assume directories are stored parents first then children.
				System.err.println("UNICASE Link: Extracting directory: " + entry.getName());
				File newDir = new File(extractDir + File.separator + entry.getName());
				newDir.mkdir();
				continue;
			}

			System.err.println("UNICASE Link: Extracting file: " + entry.getName());

			copyInputStream(zipFile.getInputStream(entry), new BufferedOutputStream(new FileOutputStream(extractDir
				+ File.separator + entry.getName())));
		}

		zipFile.close();
	}

	/**
	 * Helper method for copying an input stream.
	 * 
	 * @param in the input stream to be copied
	 * @param out the output stream to write to
	 * @throws IOException
	 */
	private final void copyInputStream(InputStream in, OutputStream out) throws IOException {
		byte[] buffer = new byte[1024];
		int len;

		while ((len = in.read(buffer)) >= 0) {
			out.write(buffer, 0, len);
		}

		in.close();
		out.close();
	}

	@Override
	public boolean isProtocolHandlerRegistered() {
		File executable = new File(FileLocations.getPluginFeaturesDirectory() + File.separator
			+ "UnicaseURLHandler.app");

		// TODO: if possible, also check whether the execute bit has been set
		if (executable.exists()) {
			return true;
		}

		return false;
	}
}
