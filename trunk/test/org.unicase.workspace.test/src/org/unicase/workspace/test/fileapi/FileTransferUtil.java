/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.test.fileapi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.exceptions.FileTransferException;
import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.metamodel.util.FileUtil;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.attachment.FileAttachment;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.PendingFileTransfer;
import org.unicase.workspace.impl.WorkspaceFactoryImpl;

/**
 * Utility methods for the file transfer interface. Important notice regarding the terminology used: construct means
 * that the file or folder location is put together from different strings, i.e. the file or folder does not have to
 * exists. find means that the method tries to localize the file. Failing in retrieving the file will throw an
 * exception.
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
	 * Copies a file from cache to a new location.
	 * 
	 * @param source the file to be copied
	 * @param destination the destination
	 * @param monitor monitor
	 * @throws IOException copy problem
	 */
	public static void copyFileFromCacheToNewLocation(File source, File destination, IProgressMonitor monitor)
		throws IOException {
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

	/**
	 * Copies the unversioned file to the clientside cache.
	 * 
	 * @param selectedFile file to copy
	 * @param uUID unversioned file name
	 * @param projectId project id
	 * @throws IOException if any error occurs copying the file
	 */
	public static void copyUnversionedFileToCache(File selectedFile, String uUID, ProjectId projectId)
		throws IOException {
		FileTransferUtil.mkdirs(projectId);
		File destination = new File(constructCacheFolder(projectId) + File.separator + uUID);
		FileUtil.copyFile(selectedFile, destination);
	}

	/**
	 * Copies the file to the clientside cache.
	 * 
	 * @param file file to be copied to cache
	 * @param fileInformation file information containing
	 * @param projectId project id
	 * @return the cached file
	 * @throws IOException if any error occurs copying the file
	 */
	public static File copyFileToCache(File file, FileInformation fileInformation, ProjectId projectId)
		throws IOException {
		FileTransferUtil.mkdirs(projectId);
		File destination = new File(constructCacheFolder(projectId) + File.separator
			+ constructFileName(fileInformation));
		FileUtil.copyFile(file, destination);
		return destination;
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
						+ FileTransferUtil.findCachedFile(constructFileNameBasedOnAttachmentIdAndVersion(fileInfo),
							new File(constructCacheFolder(projectId))));
			} else if (os.toLowerCase().contains("mac os")) {
				Runtime.getRuntime().exec(
					"open "
						+ FileTransferUtil.findCachedFile(constructFileNameBasedOnAttachmentIdAndVersion(fileInfo),
							new File(constructCacheFolder(projectId))));
			} else {
				throw new FileTransferException("Opening files is not yet supported for "
					+ os
					+ ". Please go to "
					+ FileTransferUtil.findCachedFile(constructFileNameBasedOnAttachmentIdAndVersion(fileInfo),
						new File(constructCacheFolder(projectId))).getAbsolutePath() + " and open the file manually.");
			}
		} catch (IOException e) {
			throw new FileTransferException("Could not open the specified file!");
		}
	}

	private static String constructFileName(FileInformation fileInfo) {
		return fileInfo.getFileIdentifier() + FILE_NAME_DELIMITER + fileInfo.getFileVersion() + FILE_NAME_DELIMITER
			+ fileInfo.getFileName();
	}

	/**
	 * Tries to find the file that starts with the specified string in the specified directory.
	 * 
	 * @param startsWith the string the file should start with
	 * @param folderToLookIn the folder to look in
	 * @return the cached file
	 * @throws FileNotFoundException if the file could not be found
	 */
	public static File findCachedFile(String startsWith, File folderToLookIn) throws FileNotFoundException {
		if (folderToLookIn.exists() && folderToLookIn.isDirectory()) {
			for (File file : folderToLookIn.listFiles()) {
				if (file.getName().startsWith(startsWith)) {
					return file;
				}
			}
		}
		throw new FileNotFoundException("Could not locate the file!");
	}

	/**
	 * Tries to find the file that is denoted by the transfer and the project identifier.
	 * 
	 * @param transfer transfer
	 * @param projectId project id
	 * @return the location of the unversioned cached file
	 * @throws FileNotFoundException if the file could not be found
	 */
	public static File findUnversionedCachedFile(PendingFileTransfer transfer, ProjectId projectId)
		throws FileNotFoundException {
		return findCachedFile(transfer.getPreliminaryFileName(), new File(constructCacheFolder(projectId)));
	}

	/**
	 * Returns null if the file could not be found.
	 * 
	 * @param fileInformation file Information
	 * @param projectId project id
	 * @return the cached file
	 * @throws FileNotFoundException if the file could not be found
	 */
	public static File findCachedFile(FileInformation fileInformation, ProjectId projectId)
		throws FileNotFoundException {
		return findCachedFile(constructFileNameBasedOnAttachmentIdAndVersion(fileInformation), new File(
			constructCacheFolder(projectId)));
	}

	/**
	 * @param fileAttachment the file Attachment
	 * @param projectId project id
	 * @return the cached file
	 * @throws FileNotFoundException if the file could not be found
	 */
	public static File findCachedFile(FileAttachment fileAttachment, ProjectId projectId) throws FileNotFoundException {
		FileInformation fileInformation = new FileInformation();
		fileInformation.setFileAttachmentId(ModelUtil.getProject(fileAttachment).getModelElementId(fileAttachment)
			.getId());
		if (fileAttachment.getFileID() == null || fileAttachment.getFileID().equals("")) {
			throw new FileNotFoundException("File does not exist!");
		}
		fileInformation.setFileVersion(Integer.parseInt(fileAttachment.getFileID()));
		fileInformation.setFileName(fileAttachment.getFileName());
		return findCachedFile(constructFileNameBasedOnAttachmentIdAndVersion(fileInformation), new File(
			constructCacheFolder(projectId)));
	}

	/**
	 * Gets the cached folder location string.
	 * 
	 * @param projectId project id
	 * @return the location of the cache folder
	 */
	public static String constructCacheFolder(ProjectId projectId) {
		return Configuration.getWorkspaceDirectory() + ATTACHMENT_FOLDER + File.separator + PROJECT_FOLDER_PREFIX
			+ projectId.getId();
	}

	/**
	 * @param fileAttachment file attachment
	 * @return file information containing the information related to the specified file attachment
	 * @throws FileTransferException if there is no file attached to the file attachment
	 */
	public static FileInformation createFileInformationFromFileAttachment(FileAttachment fileAttachment)
		throws FileTransferException {
		// set information needed for transfer
		FileInformation fileInfo = new FileInformation();
		fileInfo.setFileAttachmentId(ModelUtil.getProject(fileAttachment).getModelElementId(fileAttachment).getId());
		// check if the file attachment attributes are set, otherwise return error dialog
		if (fileAttachment.getFileID() == null) {
			fileInfo.setFileVersion(-1);
		} else {
			fileInfo.setFileVersion(Integer.parseInt(fileAttachment.getFileID()));
		}
		fileInfo.setFileName(fileAttachment.getFileName());
		return fileInfo;
	}

	/**
	 * @param fileInformation {@link FileInformation}
	 * @param isUpload true if upload, false if not
	 * @return {@link PendingFileTransfer}
	 */
	public static PendingFileTransfer createPendingFileTransferFromFileInformation(FileInformation fileInformation,
		boolean isUpload) {
		PendingFileTransfer tmpTransfer = WorkspaceFactoryImpl.eINSTANCE.createPendingFileTransfer();
		tmpTransfer.setAttachmentId(ModelUtil.createModelElementId(fileInformation.getFileIdentifier()));
		tmpTransfer.setChunkNumber(fileInformation.getChunkNumber());
		tmpTransfer.setFileVersion(fileInformation.getFileVersion());
		tmpTransfer.setFileName(fileInformation.getFileName());
		tmpTransfer.setUpload(isUpload);
		return tmpTransfer;
	}

	/**
	 * @param pendingFileTransfer pending file transfer
	 * @return file information
	 */
	public static FileInformation createFileInformationFromPendingFileTransfer(PendingFileTransfer pendingFileTransfer) {
		FileInformation fileInformation = new FileInformation();
		fileInformation.setChunkNumber(pendingFileTransfer.getChunkNumber());
		fileInformation.setFileAttachmentId(pendingFileTransfer.getAttachmentId().getId());
		fileInformation.setFileName(pendingFileTransfer.getFileName());
		fileInformation.setFileVersion(pendingFileTransfer.getFileVersion());
		return fileInformation;
	}

	/**
	 * Gets the cached file location string.
	 * 
	 * @param fileInformation file information
	 * @param projectId project id
	 * @return the cached file
	 */
	public static File constructCachedFile(FileInformation fileInformation, ProjectId projectId) {
		return new File(constructCacheFolder(projectId) + File.separator + constructFileName(fileInformation));
	}

	private static String constructFileNameBasedOnAttachmentIdAndVersion(FileInformation fileInfo) {
		return fileInfo.getFileIdentifier() + FILE_NAME_DELIMITER + fileInfo.getFileVersion() + FILE_NAME_DELIMITER;
	}

	private static void mkdirs(ProjectId projectId) {
		new File(constructCacheFolder(projectId)).mkdirs();
	}
}
