/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.filetransfer;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.filetransfer.FileChunk;
import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.emfstore.filetransfer.FilePartitionerUtil;
import org.unicase.model.attachment.FileAttachment;
import org.unicase.workspace.util.FileTransferUtil;

/**
 * @author pfeifferc
 */
public class FileUploadJob extends FileTransferJob {

	private int size;

	/**
	 * If the selectedFile is null, this means that the file transfer is to be resumed from cache.
	 * 
	 * @param selectedFile the file selected for upload
	 * @param fileAttachment the file attachment which shall refer to the uploaded file (if upload succeeds)
	 * @param fileInformation file information
	 */
	public FileUploadJob(File selectedFile, FileAttachment fileAttachment, FileInformation fileInformation) {
		super("File Download Job for " + selectedFile.getName());
		setFile(selectedFile);
		setFileAttachment(fileAttachment);
		setFileInformation(fileInformation);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		// get values for the required fields
		getAttributes();
		// upload file chunks
		try {
			// if fileVersion is set to -1, request file version
			if (getFileInformation().getFileVersion() == -1) {
				getFileInformation().setFileVersion(
					getConnectionManager().uploadFileChunk(getSessionId(), getProjectId(),
						new FileChunk(getFileInformation(), false, null)).getFileVersion());
			}
			if (getFile() != null) {
				// copy file to cache, so that it can be resumed from cache (consistency)
				setFile(FileTransferUtil.copyFileToCache(getFile(), getFileAttachment(), getFileInformation()));
			} else {
				setFile(new File(FileTransferUtil.getCachedFileLocation(getFileAttachment())));
			}
			size = FilePartitionerUtil.getFileSize(getFile());
			// set the upload monitor
			monitor.beginTask("Uploading "
				+ FileTransferUtil.getFileName(getFile(), getFileInformation().getFileAttachmentId()),
				FilePartitionerUtil.getNumberOfChunks(getFile()));
			// executes the file transfer (loop)
			executeTransfer(monitor);
			// set file attachment values
		} catch (EmfStoreException e) {
			setException(e);
			return Status.CANCEL_STATUS;
		} catch (IOException e) {
			setException(e);
			return Status.CANCEL_STATUS;
		}
		return Status.OK_STATUS;
	}

	/**
	 * Retrieves and writes the file chunks until the end flag is set in a file chunk.
	 * 
	 * @param fileChunk file chunk
	 * @param monitor showing the progress of the transfer.
	 * @throws EmfStoreException if any error occurs in the emf store
	 * @throws RemoteException if any remote error occurs
	 */
	private void executeTransfer(IProgressMonitor monitor) throws EmfStoreException, RemoteException {
		FileChunk fileChunk;
		addPendingFileTransfer(true);
		do {
			fileChunk = FilePartitionerUtil.readChunk(getFile(), getFileInformation());
			getConnectionManager().uploadFileChunk(getSessionId(), getProjectId(), fileChunk);
			monitor.worked(1);
			getFileInformation().setChunkNumber(getFileInformation().getChunkNumber() + 1);
			setPendingFileTransfer(true);
		} while (!fileChunk.isLast());
		removePendingFileTransfer(true);
	}

	/**
	 * @return the original file name of the uploaded file
	 */
	public String getUploadedFileName() {
		return FileTransferUtil.getFileName(getFile(), getFileAttachment().getIdentifier());
	}

	/**
	 * @return size
	 */
	public int getSize() {
		return size;
	}
}