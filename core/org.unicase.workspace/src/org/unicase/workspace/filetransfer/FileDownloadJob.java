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
import org.unicase.emfstore.exceptions.FileTransferException;
import org.unicase.emfstore.filetransfer.FileChunk;
import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.emfstore.filetransfer.FilePartitionerUtil;
import org.unicase.model.attachment.FileAttachment;
import org.unicase.workspace.util.FileTransferUtil;

/**
 * @author pfeifferc
 */
public class FileDownloadJob extends FileTransferJob {

	/**
	 * @param fileAttachment file attachment for which the file is to be downloaded
	 * @param fileInformation file information
	 */
	public FileDownloadJob(FileAttachment fileAttachment, FileInformation fileInformation) {
		super("File Download Job");
		setFileAttachment(fileAttachment);
		setFileInformation(fileInformation);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		// read values from file attachment
		getAttributes();
		// only download if values in the file attachment are set
		if (getFileAttachment().getFileName() != null && !getFileAttachment().getFileName().equals("")
			&& getFileAttachment().getFileID() != null && !getFileAttachment().getFileID().equals("")) {
			// make sure that the local cache folder exists
			createCacheFolder();
			try {
				executeTransfer(monitor);
			} catch (EmfStoreException e) {
				setException(e);
				return Status.CANCEL_STATUS;
			} catch (IOException e) {
				setException(e);
				return Status.CANCEL_STATUS;
			}
		} else {
			setException(new FileTransferException("There is no file attached to this file attachment!"));
			return Status.CANCEL_STATUS;
		}
		return Status.OK_STATUS;
	}

	private void createCacheFolder() {
		new File(FileTransferUtil.getCacheFolder(getFileAttachment())).mkdirs();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws EmfStoreException
	 * @throws RemoteException
	 */
	protected void executeTransfer(IProgressMonitor monitor) throws RemoteException, EmfStoreException {
		FileChunk fileChunk = getConnectionManager().downloadFileChunk(getSessionId(), getProjectId(),
			getFileInformation());
		setTotalWork(monitor, fileChunk.getFileSize());
		setFile(new File(FileTransferUtil.getCacheFolder(getFileAttachment()) + File.separator
			+ fileChunk.getFileName()));
		addPendingFileTransfer(false);
		do {
			fileChunk = getConnectionManager().downloadFileChunk(getSessionId(), getProjectId(), getFileInformation());
			FilePartitionerUtil.writeChunk(getFile(), fileChunk);
			monitor.worked(1);
			getFileInformation().setChunkNumber(getFileInformation().getChunkNumber() + 1);
			setPendingFileTransfer(false);
		} while (!fileChunk.isLast());
		removePendingFileTransfer(false);
	}

	private void setTotalWork(IProgressMonitor monitor, int fileSize) {
		monitor.beginTask("Downloading ", (int) Math.ceil(fileSize / (float) FilePartitionerUtil.getChunkSize()));
	}

	/**
	 * @return the downloaded file's name
	 */
	public String getDownloadedFileName() {
		return getFileAttachment().getFileName();
	}

}