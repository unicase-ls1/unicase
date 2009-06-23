/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.filetransfer;

import java.io.File;
import java.rmi.RemoteException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FileTransferException;
import org.unicase.emfstore.filetransfer.FileChunk;
import org.unicase.emfstore.filetransfer.FilePartitionerUtil;
import org.unicase.model.attachment.FileAttachment;
import org.unicase.workspace.PendingFileTransfer;
import org.unicase.workspace.util.FileTransferUtil;

/**
 * @author pfeifferc
 */
public class FileUploadJob extends FileTransferJob {

	/**
	 * If the selectedFile is null, this means that the file transfer is to be resumed from cache.
	 * 
	 * @param transfer the pending file transfer object
	 * @param fileAttachment the file attachment which shall refer to the uploaded file (if upload succeeds)
	 */
	public FileUploadJob(PendingFileTransfer transfer, FileAttachment fileAttachment) {
		super("File Upload Job " + transfer.getFileName());
		setTransfer(transfer);
		setFileAttachment(fileAttachment);
		setFileInformation();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		try {
			// get values for the required fields
			getAttributes();
			versionFileUpload();
			getCachedFileLocation();
			// executes the file transfer (loop)
			removePendingFileTransfer();
			executeTransfer(monitor);
			// set file attachment values
		} catch (EmfStoreException e) {
			setException(e);
			System.out.println(e.getMessage());
			return Status.CANCEL_STATUS;
		} catch (RemoteException e) {
			setException(e);
			System.out.println(e.getMessage());
			return Status.CANCEL_STATUS;
		}
		setAttributes();
		return Status.OK_STATUS;
	}

	private void versionFileUpload() throws EmfStoreException, RemoteException {
		// if fileVersion is set to -1, request file version
		if (getTransfer().getFileVersion() == -1) {
			int version = getConnectionManager().uploadFileChunk(getSessionId(), getProjectId(),
				new FileChunk(getFileInformation(), false, null)).getFileVersion();
			setPendingFileTransferVersion(true, version);
			getFileInformation().setFileVersion(version);
		}
	}

	private void getCachedFileLocation() throws FileTransferException {
		File versionedCachedFile = FileTransferUtil.getCachedFile(getFileInformation(), getProjectId());
		if (getTransfer().getPreliminaryFileName() != null) {
			File unversionedCachedFile = FileTransferUtil.getUnversionedCachedFile(getTransfer(), getProjectId());
			if (unversionedCachedFile == null) {
				throw new FileTransferException("The cached file could not be found!");
			}
			unversionedCachedFile.renameTo(versionedCachedFile);
		} else if (!versionedCachedFile.exists()) {
			throw new FileTransferException("The cached file could not be found!");
		}
		setFile(versionedCachedFile);
		getFileInformation().setFileSize(FilePartitionerUtil.getFileSize(getFile()));
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
		setTotalWork(monitor);
		monitor.worked(getFileInformation().getChunkNumber());
		do {
			fileChunk = FilePartitionerUtil.readChunk(getFile(), getFileInformation());
			getConnectionManager().uploadFileChunk(getSessionId(), getProjectId(), fileChunk);
			monitor.worked(1);
			getFileInformation().setChunkNumber(getFileInformation().getChunkNumber() + 1);
			setPendingFileTransfer();
		} while (!fileChunk.isLast());
		removePendingFileTransfer();
	}
}