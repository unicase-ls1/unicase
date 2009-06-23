/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.util;

import java.io.File;
import java.io.IOException;

import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.exceptions.FileTransferException;
import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.model.util.FileUtil;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.PendingFileTransfer;

/**
 * Utility methods for the file transfer interface.
 * 
 * @author pfeifferc
 */
public final class FileTransferUtil {

	/**
	 * tmp folder for file uploads to server.
	 */
	public static final String TEMP_FOLDER = "tmp";

	/**
	 * project folder prefix.
	 */
	public static final String PROJECT_FOLDER_PREFIX = "project-";

	/**
	 * Attachment folder for uploads and downloads.
	 */
	public static final String ATTACHMENT_FOLDER = "attachment";

	/**
	 * The delimiter that separates file attachment id, file version and file name in an uploaded file.
	 */
	public static final String FILE_NAME_DELIMITER = "_";

	private FileTransferUtil() {

	}

	/**
	 * @param selectedFile file to copy
	 * @param uUID unversioned file name
	 * @param projectId project id
	 * @throws IOException if any error occurs copying the file
	 */
	public static void copyUnversionedFileToCache(File selectedFile, String uUID, ProjectId projectId)
		throws IOException {
		FileTransferUtil.mkdirs(projectId);
		File destination = new File(getCacheFolder(projectId) + File.separator + uUID);
		FileUtil.copyFile(selectedFile, destination);
	}

	private static void mkdirs(ProjectId projectId) {
		new File(getCacheFolder(projectId)).mkdirs();
	}

	/**
	 * @param file file to be copied to cache
	 * @param fileInformation file information containing
	 * @param projectId project id
	 * @return the cached file
	 * @throws IOException if any error occurs copying the file
	 */
	public static File copyFileToCache(File file, FileInformation fileInformation, ProjectId projectId)
		throws IOException {
		FileTransferUtil.mkdirs(projectId);
		File destination = new File(getCacheFolder(projectId) + File.separator + constructFileName(fileInformation));
		FileUtil.copyFile(file, destination);
		return destination;
	}

	/**
	 * @param projectId project id
	 * @return the location of the cache folder
	 */
	public static String getCacheFolder(ProjectId projectId) {
		return Configuration.getWorkspaceDirectory() + ATTACHMENT_FOLDER + File.separator + PROJECT_FOLDER_PREFIX
			+ projectId.getId();
	}

	/**
	 * Attempts to open the file linked to by the file attachment according to the operating system.
	 * 
	 * @param fileInfo file information data object
	 * @param projectId project id
	 * @exception FileTransferException if any error occurs opening the file
	 */
	public static void openFile(FileInformation fileInfo, ProjectId projectId) throws FileTransferException {
		String os = System.getProperty("os.name");
		try {
			if (os.toLowerCase().contains("windows")) {
				Runtime.getRuntime().exec(
					"rundll32 SHELL32.DLL,ShellExec_RunDLL "
						+ FileTransferUtil.findCachedFile(constructFileNameWithOutFileName(fileInfo), new File(
							getCacheFolder(projectId))));
			} else if (os.toLowerCase().contains("mac os")) {
				Runtime.getRuntime().exec(
					"open "
						+ FileTransferUtil.findCachedFile(constructFileNameWithOutFileName(fileInfo), new File(
							getCacheFolder(projectId))));
			} else {
				throw new FileTransferException("Opening files is not yet supported for "
					+ os
					+ ". Please go to "
					+ FileTransferUtil.findCachedFile(constructFileNameWithOutFileName(fileInfo),
						new File(getCacheFolder(projectId))).getAbsolutePath() + " and open the file manually.");
			}
		} catch (IOException e) {
			throw new FileTransferException("Could not open the specified file!");
		}
	}

	private static String constructFileName(FileInformation fileInfo) {
		return fileInfo.getFileAttachmentId() + FILE_NAME_DELIMITER + fileInfo.getFileVersion() + FILE_NAME_DELIMITER
			+ fileInfo.getFileName();
	}

	/**
	 * Returns null if the file could not be found.
	 * 
	 * @param startsWith the string the file should start with
	 * @param folderToLookIn the folder to look in
	 * @return the cached file
	 */
	public static File findCachedFile(String startsWith, File folderToLookIn) {
		if (folderToLookIn.exists()) {
			for (File file : folderToLookIn.listFiles()) {
				if (file.getName().startsWith(startsWith)) {
					return file;
				}
			}
		}
		return null;
	}

	/**
	 * Returns the hypothetical location of the unversioned cached file.
	 * 
	 * @param transfer transfer
	 * @param projectId project id
	 * @return the location of the unversioned cached file
	 */
	public static File getUnversionedCachedFile(PendingFileTransfer transfer, ProjectId projectId) {
		return findCachedFile(transfer.getPreliminaryFileName(), new File(getCacheFolder(projectId)));
	}

	/**
	 * @param fileInformation file information
	 * @param projectId project id
	 * @return the cached file
	 */
	public static File getCachedFile(FileInformation fileInformation, ProjectId projectId) {
		return new File(getCacheFolder(projectId) + File.separator + constructFileName(fileInformation));
	}

	/**
	 * Returns null if the file could not be found.
	 * 
	 * @param fileInformation file Information
	 * @param projectId project id
	 * @return the cached file
	 */
	public static File findCachedFile(FileInformation fileInformation, ProjectId projectId) {
		return findCachedFile(constructFileNameWithOutFileName(fileInformation), new File(getCacheFolder(projectId)));
	}

	private static String constructFileNameWithOutFileName(FileInformation fileInfo) {
		return fileInfo.getFileAttachmentId() + FILE_NAME_DELIMITER + fileInfo.getFileVersion() + FILE_NAME_DELIMITER;
	}
}
