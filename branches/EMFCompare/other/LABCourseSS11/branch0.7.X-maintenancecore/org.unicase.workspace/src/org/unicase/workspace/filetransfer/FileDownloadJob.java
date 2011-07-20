/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
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
import org.unicase.emfstore.esmodel.FileIdentifier;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.filetransfer.FileChunk;
import org.unicase.emfstore.filetransfer.FilePartitionerUtil;
import org.unicase.emfstore.filetransfer.FileTransferInformation;

/**
 * File Download Job class is responsible for downloading files from the server in the Eclipse Worker thread.
 * 
 * @author pfeifferc, jfinis
 */
public class FileDownloadJob extends FileTransferJob {

	private FileDownloadStatus status;

	/**
	 * Default constructor. Only used internally; only the FileTransferManager may create such jobs.
	 * 
	 * @param status the status to which this download job will report its progress
	 * @param transferManager the transfer manager administering the download.
	 * @param fileId the id of the file to be transferred
	 * @param transferVisibleToUser progress bar yes/no
	 */
	FileDownloadJob(FileDownloadStatus status, FileTransferManager transferManager, FileIdentifier fileId,
		boolean transferVisibleToUser) {
		super(transferManager, new FileTransferInformation(fileId, FileTransferInformation.UNKOWN_SIZE),
			"File Download");
		setUser(transferVisibleToUser);
		this.status = status;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		try {
			// read values from file attachment
			getConnectionAttributes();
			// set file that is to be written to
			setFile(getCache().createTempFile(getFileId()));
			// receive file chunks from server
			if (!executeTransfer(monitor)) {
				return Status.CANCEL_STATUS;
			}
		} catch (EmfStoreException e) {
			return registerException(e);
		} catch (IOException e) {
			return registerException(e);
			// BEGIN SUPRESS CATCH EXCEPTION
		} catch (RuntimeException e) {
			// END SUPRESS CATCH EXCEPTION
			return registerException(e);
		}
		return Status.OK_STATUS;
	}

	/**
	 * Registers an exception.
	 * 
	 * @param e the exception to register
	 * @return CANCEL_STATUS
	 */
	private IStatus registerException(Exception e) {
		status.transferFailed(e);
		setException(e);
		return Status.CANCEL_STATUS;
	}

	/**
	 * . {@inheritDoc}
	 * 
	 * @throws EmfStoreException
	 * @throws RemoteException
	 */
	private boolean executeTransfer(IProgressMonitor monitor) throws RemoteException, EmfStoreException {

		// download file chunk to retrieve filesize (file chunk is discarded)
		FileChunk fileChunk = null;
		fileChunk = getConnectionManager().downloadFileChunk(getSessionId(), getProjectId(), getFileInformation());

		getFileInformation().setFileSize(fileChunk.getFileSize());
		initializeMonitor(monitor);
		status.transferStarted(fileChunk.getFileSize());
		do {
			fileChunk = getConnectionManager().downloadFileChunk(getSessionId(), getProjectId(), getFileInformation());
			FilePartitionerUtil.writeChunk(getFile(), fileChunk);
			monitor.worked(1);
			incrementChunkNumber();
			if (isCanceled()) {
				status.transferCancelled();
				return false;
			}
		} while (!fileChunk.isLast());

		// Once the file is downloaded, it can be moved from the tmp folder to the cache
		File result = getCache().moveTempFileToCache(getFileId());
		status.transferFinished(result);
		return true;
	}

}