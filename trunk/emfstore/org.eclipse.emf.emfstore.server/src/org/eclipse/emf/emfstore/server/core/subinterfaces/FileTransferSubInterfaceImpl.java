/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.core.subinterfaces;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.emf.emfstore.common.model.util.FileUtil;
import org.eclipse.emf.emfstore.server.ServerConfiguration;
import org.eclipse.emf.emfstore.server.core.AbstractEmfstoreInterface;
import org.eclipse.emf.emfstore.server.core.AbstractSubEmfstoreInterface;
import org.eclipse.emf.emfstore.server.core.MonitorProvider;
import org.eclipse.emf.emfstore.server.exceptions.FatalEmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.FileNotOnServerException;
import org.eclipse.emf.emfstore.server.exceptions.FileTransferException;
import org.eclipse.emf.emfstore.server.filetransfer.FileChunk;
import org.eclipse.emf.emfstore.server.filetransfer.FilePartitionerUtil;
import org.eclipse.emf.emfstore.server.filetransfer.FileTransferInformation;
import org.eclipse.emf.emfstore.server.model.ProjectId;

/**
 * The file transfer subinterface.
 * 
 * @author pfeifferc
 */
public class FileTransferSubInterfaceImpl extends AbstractSubEmfstoreInterface {

	private static final String FILELOAD = "filetransfer";

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
	public FileChunk readChunk(ProjectId projectId, FileTransferInformation fileInformation)
		throws FileTransferException {
		synchronized (MonitorProvider.getInstance().getMonitor(FILELOAD)) {
			// check if folders exist, otherwise create
			createDirectories(projectId);
			// try to localize file that is to be downloaded
			File file;
			try {
				file = findFile(fileInformation, projectId);
			} catch (FileNotFoundException e) {
				throw new FileNotOnServerException(projectId, fileInformation.getFileIdentifier());
			}
			return FilePartitionerUtil.readChunk(file, fileInformation);
		}
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
	public FileTransferInformation writeChunk(FileChunk fileChunk, ProjectId projectId) throws FileTransferException {
		synchronized (MonitorProvider.getInstance().getMonitor(FILELOAD)) {
			// check if folders exist, otherwise create
			createDirectories(projectId);
			FileTransferInformation fileInfo = fileChunk.getFileInformation();

			// retrieve location for the temp file
			File tmpFile;
			try {
				if (fileChunk.getChunkNumber() == 0) {
					tmpFile = getTempFile(fileInfo, projectId);
				} else {
					tmpFile = findFileInTemp(fileInfo, projectId);
				}
			} catch (FileNotFoundException e) {
				throw new FileTransferException(
					"The file has either been removed from the server or is not accessible!", e);
			}
			// file reslicer for reslicing temp file
			FilePartitionerUtil.writeChunk(tmpFile, fileChunk);
			// move file from temp folder to attachment folder if last file chunk is received
			if (fileChunk.isLast()) {
				try {
					// retrieve final location for file
					File attachmentFile = getCachedFile(fileInfo, projectId);

					FileUtil.copyFile(tmpFile, attachmentFile);
					tmpFile.delete();
				} catch (IOException e) {
					throw new FileTransferException("Could not move file to final destination!", e);
				}
			}
			return fileInfo;
		}
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

	private File findFileInTemp(FileTransferInformation fileInfo, ProjectId projectId) throws FileNotFoundException {
		File file = getTempFile(fileInfo, projectId);
		if (file.exists()) {
			return file;
		}
		throw new FileNotFoundException("Could not locate the specified file (" + fileInfo.getFileIdentifier()
			+ ") in the temp folder.");
	}

	private File findFile(FileTransferInformation fileInfo, ProjectId projectId) throws FileNotFoundException {
		File file = getCachedFile(fileInfo, projectId);
		if (file.exists()) {
			return file;
		}
		throw new FileNotFoundException("File " + fileInfo.getFileIdentifier()
			+ " could not be located in the cache folder.");
	}

	private File getTempFile(FileTransferInformation fileInfo, ProjectId projectId) {
		return new File(getProjectAttachmentTempFolder(projectId) + File.separator + constructFileName(fileInfo));
	}

	private File getCachedFile(FileTransferInformation fileInfo, ProjectId projectId) {
		return new File(getProjectAttachmentFolder(projectId) + File.separator + constructFileName(fileInfo));
	}

	private String constructFileName(FileTransferInformation fileInfo) {
		return fileInfo.getFileIdentifier().getIdentifier();
	}

	private String getProjectAttachmentFolder(ProjectId projectId) {
		return ServerConfiguration.getServerHome() + ServerConfiguration.FILE_PREFIX_PROJECTFOLDER + projectId.getId()
			+ File.separator + ATTACHMENT_FOLDER;
	}

	private String getProjectAttachmentTempFolder(ProjectId projectId) {
		return getProjectAttachmentFolder(projectId) + File.separator + TEMP_FOLDER;
	}
}
