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
		super("File Download Job for " + fileAttachment.getFileName());
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
			new File(FileTransferUtil.getCacheFolder(getFileAttachment())).mkdirs();
			// retrieve the location of the cached file
			setFile(new File(FileTransferUtil.getCachedFileLocation(getFileAttachment())));
			// check if it is a resume, in which case file version is not -1
			if (getFileInformation().getFileVersion() == -1) {
				getFileInformation().setFileVersion(Integer.parseInt(getFileAttachment().getFileID()));
			}
			try {
				monitor.beginTask("Downloading ", (int) Math.ceil(getFileAttachment().getFileSize()
					/ (float) FilePartitionerUtil.getChunkSize()));
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

	/**
	 * {@inheritDoc}
	 * 
	 * @throws EmfStoreException
	 * @throws RemoteException
	 */
	protected void executeTransfer(IProgressMonitor monitor) throws RemoteException, EmfStoreException {
		FileChunk fileChunk;
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

	/**
	 * @return the downloaded file's name
	 */
	public String getDownloadedFileName() {
		return getFileAttachment().getFileName();
	}

}