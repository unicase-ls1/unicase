/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.filetransfer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.unicase.emfstore.exceptions.FileTransferException;

/**
 * Utility methods for the file transfer interface. Important notice regarding the terminology used: construct means
 * that the file or folder location is put together from different strings, i.e. the file or folder does not have to
 * exists. find means that the method tries to localize the file. Failing in retrieving the file will throw an
 * exception.
 * 
 * @author pfeifferc, jfinis
 */
public final class FileTransferUtil {

	private FileTransferUtil() {

	}

	/**
	 * Attempts to open the file linked to by the file attachment according to the operating system.
	 * 
	 * @param file the file to be opened
	 * @exception FileTransferException if any error occurs opening the file
	 */
	public static void openFile(File file) throws FileTransferException {
		String os = System.getProperty("os.name");
		try {
			if (os.toLowerCase().contains("windows")) {
				Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + file.getAbsolutePath());
			} else if (os.toLowerCase().contains("mac os")) {
				Runtime.getRuntime().exec("open " + file.getAbsolutePath());
			} else {
				throw new FileTransferException("Opening files is not yet supported for " + os + ". Please go to "
					+ file);
			}
		} catch (IOException e) {
			throw new FileTransferException("Could not open the specified file!");
		}
	}

	/**
	 * Copies a file from cache to a new location.
	 * 
	 * @param source the file to be copied
	 * @param destination the destination
	 * @param monitor monitor
	 * @throws IOException copy problem
	 */
	public static void copyFileWithProgress(File source, File destination, IProgressMonitor monitor) throws IOException {
		FileInputStream inputStream = new FileInputStream(source);
		FileOutputStream outputStream = new FileOutputStream(destination);

		monitor.beginTask("Copying file...", inputStream.available());
		byte[] buffer = new byte[4096];
		int read;
		while ((read = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, read);
			monitor.worked(4096);
		}
		inputStream.close();
		outputStream.close();
	}

}