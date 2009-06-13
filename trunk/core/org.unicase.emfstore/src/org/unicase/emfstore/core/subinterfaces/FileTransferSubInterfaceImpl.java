/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.core.subinterfaces;

import java.io.File;
import java.io.IOException;

import org.unicase.emfstore.ServerConfiguration;
import org.unicase.emfstore.core.AbstractEmfstoreInterface;
import org.unicase.emfstore.core.AbstractSubEmfstoreInterface;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.exceptions.FileTransferException;
import org.unicase.emfstore.filetransfer.FileChunk;
import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.emfstore.filetransfer.FilePartitionerUtil;
import org.unicase.model.util.FileUtil;

// REFACTORING STATUS: INCOMPLETE
/**
 * The file transfer subinterface.
 * 
 * @author pfeifferc
 */
public class FileTransferSubInterfaceImpl extends AbstractSubEmfstoreInterface {

	/**
	 * tmp folder for file uploads to server.
	 */
	public static final String TEMP_FOLDER = "tmp";

	/**
	 * Attachment folder for uploads and downloads.
	 */
	public static final String ATTACHMENT_FOLDER = "attachment";

	/**
	 * The delimiter that separates file attachment id, file version and file name in an uploaded file.
	 */
	public static final String FILE_NAME_DELIMITER = "_";

	/**
	 * @param parentInterface the parent interface
	 * @throws FatalEmfStoreException if any fatal error occurs
	 */
	public FileTransferSubInterfaceImpl(AbstractEmfstoreInterface parentInterface) throws FatalEmfStoreException {
		super(parentInterface);
	}

	/**
	 * Reads a chunk from the file linked to the fileInformation.
	 * 
	 * @param projectId project attachment folder
	 * @param fileInformation file information object
	 * @return FileChunk
	 * @throws FileTransferException if any error occurs reading the file
	 */
	public FileChunk readChunk(ProjectId projectId, FileInformation fileInformation) throws FileTransferException {
		// check if folders exist, otherwise create
		createDirectories(projectId);
		// try to localize file that is to be downloaded
		File file = new File(getProjectAttachmentFolder(projectId)
			+ File.separator
			+ findFileInTemp(new File(getProjectAttachmentFolder(projectId)), fileInformation.getFileAttachmentId(),
				fileInformation.getFileVersion()));
		if (!file.exists() || file.isDirectory()) {
			throw new FileTransferException("File can not be retrieved.");
		}
		return FilePartitionerUtil.readChunk(file, fileInformation);
	}

	/**
	 * Writes a chunk to the file linked to the fileInformation in the fileChunk. If the data in the file chunk is null,
	 * this is treated as a request for a file version.
	 * 
	 * @param fileChunk contains data and information about the file attachment, file version and chunk number
	 * @param projectId project id
	 * @return fileInformation containing the (new) file version
	 * @throws FileTransferException if any error occurs writing to the file
	 */
	public FileInformation writeChunk(FileChunk fileChunk, ProjectId projectId) throws FileTransferException {
		// check if folders exist, otherwise create
		createDirectories(projectId);
		// folder for completed file uploads
		File attachmentFolder = new File(getProjectAttachmentFolder(projectId));
		// temp folder for storing incomplete file uploads
		File attachmentTempFolder = new File(getProjectAttachmentTempFolder(projectId));
		// if the data is null, this is treated as a request for assigning a file version
		FileInformation fileInformation = fileChunk.getFileInformation();
		if (fileChunk.getData() == null) {
			fileInformation.setFileVersion(getVersion(attachmentFolder, attachmentTempFolder, fileInformation
				.getFileAttachmentId()));
			try {
				new File(getProjectAttachmentTempFileLocation(fileInformation.getFileAttachmentId(), fileInformation
					.getFileVersion(), fileInformation.getFileName(), projectId)).createNewFile();
			} catch (IOException e) {
				throw new FileTransferException("Could not create the file on the server!", e);
			}
			return fileInformation;
		}
		// retrieve file version from file chunk
		int version = fileInformation.getFileVersion();
		// retrieve location for the temp file
		File attachmentTempFile = new File(getProjectAttachmentTempFileLocation(fileInformation.getFileAttachmentId(),
			version, projectId));
		// retrieve final location for file
		File attachmentFile = new File(getProjectAttachmentFileLocation(fileInformation.getFileAttachmentId(), version,
			attachmentTempFile.getName(), projectId));
		// file reslicer for reslicing temp file
		FilePartitionerUtil.writeChunk(attachmentTempFile, fileChunk);
		// move file from temp folder to attachment folder if last file chunk is received
		if (fileChunk.isLast()) {
			try {
				FileUtil.copyFile(attachmentTempFile, attachmentFile);
				attachmentTempFile.delete();
			} catch (IOException e) {
				throw new FileTransferException("Could not move file to final destination!", e);
			}
		}
		return fileInformation;
	}

	private String getProjectAttachmentTempFileLocation(String fileAttachmentId, int version, ProjectId projectId) {
		return getProjectAttachmentTempFolder(projectId) + File.separator
			+ findProjectAttachmentTempFileName(fileAttachmentId, version, projectId);
	}

	private String findProjectAttachmentTempFileName(String fileAttachmentId, int fileVersion, ProjectId projectId) {
		return findFileInTempAndStorage(fileAttachmentId, fileVersion, projectId);
	}

	/**
	 * Returns the latest version for the file attachment id.
	 */
	private int getVersion(File attachmentFolder, File attachmentTempFolder, String fileAttachmentId) {
		return Math.max(getLatestVersion(attachmentTempFolder, fileAttachmentId), getLatestVersion(attachmentFolder,
			fileAttachmentId)) + 1;
	}

	private String getProjectAttachmentFolder(ProjectId projectId) {
		return ServerConfiguration.getServerHome() + ServerConfiguration.FILE_PREFIX_PROJECTFOLDER + projectId.getId()
			+ File.separatorChar + File.separator + ATTACHMENT_FOLDER;
	}

	private String getProjectAttachmentTempFolder(ProjectId projectId) {
		return getProjectAttachmentFolder(projectId) + File.separator + TEMP_FOLDER;
	}

	private String getProjectAttachmentFileLocation(String attachmentId, int version, String fileName,
		ProjectId projectId) {
		return getProjectAttachmentFolder(projectId) + File.separator
			+ getProjectAttachmentFileName(attachmentId, version, fileName);
	}

	private String getProjectAttachmentTempFileLocation(String attachmentId, int version, String fileName,
		ProjectId projectId) {
		return getProjectAttachmentTempFolder(projectId) + File.separator
			+ getProjectAttachmentFileName(attachmentId, version, fileName);
	}

	private String getProjectAttachmentFileName(String attachmentId, int version, String fileName) {
		return attachmentId + FILE_NAME_DELIMITER + version + FILE_NAME_DELIMITER + fileName;
	}

	private int getLatestVersion(File folder, String id) {
		File[] files = folder.listFiles();
		String temp = null;
		int version = -1;
		for (File file : files) {
			if (file.isFile()) {
				if (file.getName().startsWith(id)) {
					temp = extractFileVersion(file.getName(), id.length());
					if (Integer.parseInt(temp) > version) {
						version = Integer.parseInt(temp);
					}
				}
			}
		}
		return version;
	}

	private String extractFileVersion(String temp, int idLength) {
		temp = temp.substring(idLength + 1);
		return temp.substring(0, temp.indexOf(FILE_NAME_DELIMITER));
	}

	private String findFileInTempAndStorage(String fileAttachmentId, int fileVersion, ProjectId projectId) {
		File tempFolder = new File(getProjectAttachmentTempFolder(projectId));
		File folder = new File(getProjectAttachmentFolder(projectId));
		for (File f : tempFolder.listFiles()) {
			if (f.getName().startsWith(fileAttachmentId + FILE_NAME_DELIMITER + fileVersion + FILE_NAME_DELIMITER)) {
				return f.getName();
			}
		}
		for (File f : folder.listFiles()) {
			if (f.getName().startsWith(fileAttachmentId + FILE_NAME_DELIMITER + fileVersion + FILE_NAME_DELIMITER)) {
				return f.getName();
			}
		}
		return fileAttachmentId + FILE_NAME_DELIMITER + fileVersion + FILE_NAME_DELIMITER
			+ "filenameinformationlost.unknown";
	}

	private String findFileInTemp(File folder, String fileAttachmentId, int fileVersion) {
		for (File f : folder.listFiles()) {
			if (f.getName().startsWith(fileAttachmentId + FILE_NAME_DELIMITER + fileVersion + FILE_NAME_DELIMITER)) {
				return f.getName();
			}
		}
		return "";
	}

	/**
	 * Creates the file attachment and temporary file attachment folders.
	 */
	private void createDirectories(ProjectId projectId) {
		File createFolders = new File(getProjectAttachmentTempFolder(projectId));
		if (!createFolders.exists()) {
			createFolders.mkdirs();
		}
	}
}
