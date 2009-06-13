/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.util;

import java.io.File;
import java.io.IOException;

import org.unicase.emfstore.exceptions.FileTransferException;
import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.model.attachment.FileAttachment;
import org.unicase.model.util.FileUtil;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

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
	 * @param file file to be copied to cache
	 * @param fileAttachment file attachment
	 * @param fileInformation file information containing
	 * @return the cached file
	 * @throws IOException if any error occurs copying the file
	 */
	public static File copyFileToCache(File file, FileAttachment fileAttachment, FileInformation fileInformation)
		throws IOException {
		new File(getCacheFolder(fileAttachment)).mkdirs();
		File destination = new File(getCacheFolder(fileAttachment) + File.separator + fileAttachment.getIdentifier()
			+ FILE_NAME_DELIMITER + fileInformation.getFileVersion() + FILE_NAME_DELIMITER + file.getName());

		FileUtil.copyFile(file, destination);
		return destination;
	}

	/**
	 * @param projectSpace file attachment
	 * @param fileVersionString file version
	 * @return file name of the cached file
	 */
	public static String getFileNameOfCachedFile(ProjectSpace projectSpace, String fileVersionString) {
		if (fileVersionString == null) {
			return null;
		}
		int fileVersion = Integer.parseInt(fileVersionString);
		for (File f : new File(getCacheFolder(projectSpace)).listFiles()) {
			if (f.getName().startsWith(
				projectSpace.getIdentifier() + FILE_NAME_DELIMITER + fileVersion + FILE_NAME_DELIMITER)) {
				return f.getName();
			}
		}
		return null;
	}

	/**
	 * @param fileAttachment file attachment for which to get the cache folder
	 * @return the location of the cache folder
	 */
	public static String getCacheFolder(FileAttachment fileAttachment) {
		return Configuration.getWorkspaceDirectory() + ATTACHMENT_FOLDER + File.separator + PROJECT_FOLDER_PREFIX
			+ WorkspaceManager.getProjectSpace(fileAttachment).getProjectId().getId();
	}

	/**
	 * @param projectSpace project space
	 * @return the location of the cache folder
	 */
	public static String getCacheFolder(ProjectSpace projectSpace) {
		return Configuration.getWorkspaceDirectory() + ATTACHMENT_FOLDER + File.separator + PROJECT_FOLDER_PREFIX
			+ projectSpace.getProjectId().getId();
	}

	/**
	 * @param file file
	 * @param fileAttachmentId file attachment id
	 * @return the file name. Removes fileAttachmendId and fileVersion strings from the file name.
	 */
	public static String getFileName(File file, String fileAttachmentId) {
		String tmp = file.getName();
		if (tmp.startsWith(fileAttachmentId)) {
			tmp = tmp.substring(fileAttachmentId.length() + 1);
			tmp = tmp.substring(tmp.indexOf(FILE_NAME_DELIMITER) + 1);
		}
		return tmp;
	}

	/**
	 * Attempts to open the file linked to by the file attachment according to the operating system.
	 * 
	 * @param fileAttachment file attachment
	 * @exception FileTransferException if any error occurs opening the file
	 */
	public static void openFile(FileAttachment fileAttachment) throws FileTransferException {
		String os = System.getProperty("os.name");
		int version = Integer.parseInt(fileAttachment.getFileID());
		try {
			if (os.toLowerCase().contains("windows")) {
				Runtime.getRuntime().exec(
					"rundll32 SHELL32.DLL,ShellExec_RunDLL "
						+ FileTransferUtil.getCachedFileLocation(fileAttachment, version));
			} else if (os.toLowerCase().contains("mac os")) {
				Runtime.getRuntime().exec("open " + FileTransferUtil.getCachedFileLocation(fileAttachment, version));
			} else {
				throw new FileTransferException("Opening files is not yet supported for " + os + ". Please go to "
					+ FileTransferUtil.getCachedFileLocation(fileAttachment, version) + " and open the file manually.");
			}
		} catch (IOException e) {
			throw new FileTransferException("Could not open the specified file!");
		}
	}

	/**
	 * @param fileAttachment file attachment for which to get the cached file location
	 * @param fileVersion and for the specific version
	 * @return the location of the cached file
	 */
	public static String getCachedFileLocation(FileAttachment fileAttachment, int fileVersion) {
		String f = findFile(new File(getCacheFolder(fileAttachment)), fileAttachment.getIdentifier(), fileVersion);
		if (f == null) {
			return null;
		}
		return getCacheFolder(fileAttachment) + File.separator + f;
	}

	private static String findFile(File folder, String fileAttachmentId, int fileVersion) {
		if (folder.exists()) {
			for (File f : folder.listFiles()) {
				if (f.getName().startsWith(fileAttachmentId + FILE_NAME_DELIMITER + fileVersion + FILE_NAME_DELIMITER)) {
					return f.getName();
				}
			}
		}
		return null;
	}

	/**
	 * @param fileName name of the file
	 * @param fileAttachmentId file attachment id
	 * @return the file name. Removes fileAttachmendId and fileVersion strings from the file name.
	 */
	public static String getFileName(String fileName, String fileAttachmentId) {
		String tmp = fileName;
		if (tmp.startsWith(fileAttachmentId)) {
			tmp = tmp.substring(fileAttachmentId.length() + 1);
			tmp = tmp.substring(tmp.indexOf(FILE_NAME_DELIMITER) + 1);
		}
		return tmp;
	}
}
