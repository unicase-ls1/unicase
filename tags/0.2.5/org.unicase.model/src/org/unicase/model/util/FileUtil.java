/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Helperclass for file system operations.
 * 
 * @author wesendonk
 */
public final class FileUtil {

	/**
	 * Private constructor.
	 */
	private FileUtil() {
		//for my beloved checkstyle
	}
	
	/**
	 * This method deletes a folder including all subfolders and files.
	 * 
	 * @param folder
	 *            the folder
	 * @throws IOException
	 *             if can't delete
	 */
	public static void deleteFolder(File folder) throws IOException {
		if (folder.exists()) {
			for (File child : folder.listFiles()) {
				if (child.isDirectory()) {
					deleteFolder(child);
				} else {
					if (!child.delete()) {
						throw new IOException("Deletion of file: "
								+ child.getAbsolutePath() + " failed.");
					}
				}
			}
			if (!folder.delete()) {
				throw new IOException("Deletion of folder: "
						+ folder.getAbsolutePath() + " failed.");
			}
		}
	}

	/**
	 * This method copies a single file.
	 * 
	 * @param source
	 *            the source
	 * @param destination
	 *            the destination
	 * @throws IOException
	 *             copy problem
	 */
	public static void copyFile(File source, File destination)
			throws IOException {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		fis = new FileInputStream(source);
		fos = new FileOutputStream(destination);

		byte[] buffer = new byte[4096];
		int read;
		while ((read = fis.read(buffer)) != -1) {
			fos.write(buffer, 0, read);
		}

		fis.close();
		fos.close();
	}
}
