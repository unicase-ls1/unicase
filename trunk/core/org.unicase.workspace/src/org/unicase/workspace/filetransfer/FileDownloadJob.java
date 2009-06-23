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
import org.unicase.emfstore.filetransfer.FilePartitionerUtil;
import org.unicase.model.attachment.FileAttachment;
import org.unicase.workspace.PendingFileTransfer;
import org.unicase.workspace.util.FileTransferUtil;

/**
 * @author pfeifferc
 */
public class FileDownloadJob extends FileTransferJob {

	/**
	 * @param transfer transfer
	 * @param fileAttachment file attachment for which the file is to be downloaded
	 */
	public FileDownloadJob(PendingFileTransfer transfer, FileAttachment fileAttachment) {
		super("File Download Job " + transfer.getFileName());
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
			// read values from file attachment
			getAttributes();
			// make sure that the local cache folder exists
			createCacheFolder();
			executeTransfer(monitor);
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
	 * {@inheritDoc}
	 * 
	 * @throws EmfStoreException
	 * @throws RemoteException
	 */
	private void executeTransfer(IProgressMonitor monitor) throws RemoteException, EmfStoreException {
		FileChunk fileChunk = getConnectionManager().downloadFileChunk(getSessionId(), getProjectId(),
			getFileInformation());
		getFileInformation().setFileSize(fileChunk.getFileSize());
		setTotalWork(monitor);
		monitor.worked(getFileInformation().getChunkNumber());
		setFile(new File(FileTransferUtil.getCacheFolder(getProjectId()) + File.separator + fileChunk.getFileName()));
		do {
			fileChunk = getConnectionManager().downloadFileChunk(getSessionId(), getProjectId(), getFileInformation());
			FilePartitionerUtil.writeChunk(getFile(), fileChunk);
			monitor.worked(1);
			getFileInformation().setChunkNumber(getFileInformation().getChunkNumber() + 1);
			setPendingFileTransfer();
		} while (!fileChunk.isLast());
		removePendingFileTransfer();
	}

	private void createCacheFolder() {
		new File(FileTransferUtil.getCacheFolder(getProjectId())).mkdirs();
	}
}