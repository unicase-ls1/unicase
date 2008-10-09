/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.util;

import java.io.File;
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

}
