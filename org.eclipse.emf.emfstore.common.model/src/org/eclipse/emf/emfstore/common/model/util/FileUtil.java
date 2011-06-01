/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.common.model.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Helperclass for file system operations.
 * 
 * @author wesendonk
 */
// TODO: ChainSaw Move this to util package
public final class FileUtil {

	/**
	 * Private constructor.
	 */
	private FileUtil() {
		// for my beloved checkstyle
	}

	/**
	 * This method deletes a folder including all subfolders and files.
	 * 
	 * @param folder the folder
	 * @throws IOException if can't delete
	 */
	public static void deleteFolder(File folder) throws IOException {
		if (folder.exists()) {
			for (File child : folder.listFiles()) {
				if (child.isDirectory()) {
					deleteFolder(child);
				} else {
					if (!child.delete()) {
						throw new IOException("Deletion of file: " + child.getAbsolutePath() + " failed.");
					}
				}
			}
			if (!folder.delete()) {
				throw new IOException("Deletion of folder: " + folder.getAbsolutePath() + " failed.");
			}
		}
	}

	/**
	 * This method copies a single file.
	 * 
	 * @param source the source
	 * @param destination the destination
	 * @throws IOException copy problem
	 */
	public static void copyFile(File source, File destination) throws IOException {
		copyFile(new FileInputStream(source), destination);
	}

	/**
	 * This method copies a single file.
	 * 
	 * @param source the source input stream
	 * @param destination the destination
	 * @throws IOException copy problem
	 */
	public static void copyFile(InputStream source, File destination) throws IOException {
		if (source == null || destination == null) {
			throw new IOException("Source or destination is null.");
		}

		if (destination.getParentFile() != null) {
			destination.getParentFile().mkdirs();
		}
		FileOutputStream outputStream = new FileOutputStream(destination);

		byte[] buffer = new byte[4096];
		int read;
		while ((read = source.read(buffer)) != -1) {
			outputStream.write(buffer, 0, read);
		}

		source.close();
		outputStream.close();
	}

	/**
	 * Copy a directory from source to target including its contained files and directories.
	 * 
	 * @param source directory
	 * @param destination directory
	 * @throws IOException on a IO problem during copy
	 */
	public static void copyDirectory(File source, File destination) throws IOException {

		destination.mkdirs();
		for (File file : source.listFiles()) {
			if (file.isDirectory()) {
				copyDirectory(file, new File(destination.getAbsolutePath() + File.separatorChar + file.getName()));
			} else {
				copyFile(file, new File(destination.getAbsolutePath() + File.separatorChar + file.getName()));
			}
		}
	}

	/**
	 * This method allows you to zip a folder. *UNDER CONSTRUCTION*
	 * 
	 * @param source folder to zip
	 * @param destination target zip file
	 * @throws IOException in case of failure
	 */
	public static void zipFolder(File source, File destination) throws IOException {
		if (!source.isDirectory()) {
			throw new IOException("Source must be folder.");
		}
		if (destination.exists()) {
			throw new IOException("Destination already exists.");
		}
		ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(
			new FileOutputStream(destination)));
		String path = source.getPath();
		path += (path.endsWith(File.separator) ? "" : File.separatorChar);
		zip(source, path, zipOutputStream, new byte[8192]);
		zipOutputStream.close();
	}

	private static void zip(File current, String rootPath, ZipOutputStream zipStream, byte[] buffer) throws IOException {
		if (current.isDirectory()) {
			for (File file : current.listFiles()) {
				if (!".".equals(file.getName()) && !"..".equals(file.getName())) {
					zip(file, rootPath, zipStream, buffer);
				}
			}
		} else if (current.isFile()) {
			zipStream.putNextEntry(new ZipEntry(current.getPath().replace(rootPath, "")));
			FileInputStream file = new FileInputStream(current);
			int read;
			while ((read = file.read(buffer)) != -1) {
				zipStream.write(buffer, 0, read);
			}
			zipStream.closeEntry();
		} else {
			throw new IllegalStateException();
		}
	}
}
