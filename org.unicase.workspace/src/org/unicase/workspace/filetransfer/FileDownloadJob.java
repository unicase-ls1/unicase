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
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.filetransfer.FileChunk;
import org.unicase.emfstore.filetransfer.FilePartitionerUtil;
import org.unicase.workspace.PendingFileTransfer;
import org.unicase.workspace.ProjectSpace;

/**
 * File Download Job class is responsible for downloading files from the server in the Eclipse Worker thread.
 * 
 * @author pfeifferc
 */
public class FileDownloadJob extends FileTransferJob {

	/**
	 * @param transfer the transfer
	 * @param projectSpace project space
	 * @param transferVisibleToUser progress bar yes/no
	 */
	public FileDownloadJob(PendingFileTransfer transfer, ProjectSpace projectSpace, boolean transferVisibleToUser) {
		super("File Download Job for: " + transfer.getFileName() + " version: " + transfer.getFileVersion());
		setTransfer(transfer);
		setProjectSpace(projectSpace);
		setFileInformation();
		setUser(false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		try {
			// read values from file attachment
			getConnectionAttributes();
			// make sure that the local cache folder exists
			createCacheFolder();
			// set file that is to be written to
			setFile(FileTransferUtil.constructCachedFile(getFileInformation(), getProjectId()));
			// receive file chunks from server
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
		// download file chunk to retrieve filesize (file chunk is discarded)
		FileChunk fileChunk = getConnectionManager().downloadFileChunk(getSessionId(), getProjectId(),
			getFileInformation());
		getFileInformation().setFileSize(fileChunk.getFileSize());
		initializeMonitor(monitor);
		do {
			fileChunk = getConnectionManager().downloadFileChunk(getSessionId(), getProjectId(), getFileInformation());
			FilePartitionerUtil.writeChunk(getFile(), fileChunk);
			monitor.worked(1);
			incrementChunkNumber();
			setNewPendingFileTransferChunkNumber();
			checkCancelled();
		} while (!fileChunk.isLast());
		removePendingFileTransfer();
	}

	/**
	 * Creates the clientside cache folder.
	 */
	private void createCacheFolder() {
		new File(FileTransferUtil.constructCacheFolder(getProjectId())).mkdirs();
	}
}