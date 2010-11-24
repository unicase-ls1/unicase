/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.filetransfer;

import java.io.File;
import java.io.FileNotFoundException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FileTransferException;
import org.unicase.emfstore.filetransfer.FileChunk;
import org.unicase.emfstore.filetransfer.FilePartitionerUtil;
import org.unicase.workspace.PendingFileTransfer;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * File Upload Job class is responsible for uploading files to the server in the Eclipse Worker thread.
 * 
 * @author pfeifferc
 */
public class FileUploadJob extends FileTransferJob {

	/**
	 * @param transfer the pending file transfer object
	 * @param projectSpace project space
	 * @param transferVisibleToUser progress bar yes/no
	 */
	public FileUploadJob(PendingFileTransfer transfer, ProjectSpace projectSpace, boolean transferVisibleToUser) {
		super("File Upload Job for: " + transfer.getFileName());
		setProjectSpace(projectSpace);
		setTransfer(transfer);
		setFileInformation();
		setUser(transferVisibleToUser);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		try {
			// get values for the required fields
			getConnectionAttributes();
			getVersionFromServer();
			getCachedFileLocation();
			// executes the file transfer (loop)
			executeTransfer(monitor);
			// set file attachment values
			extensionPointAction();
		} catch (EmfStoreException e) {
			setException(e);
			return Status.CANCEL_STATUS;
		}
		return Status.OK_STATUS;
	}

	/**
	 * Request version from server if the version has not been requested already.
	 * 
	 * @throws EmfStoreException if any error occurs requesting the version
	 */
	private void getVersionFromServer() throws EmfStoreException {
		// if fileVersion is set to -1, request file version
		if (getTransfer().getFileVersion() == -1) {
			int version = getConnectionManager().uploadFileChunk(getSessionId(), getProjectId(),
				new FileChunk(getFileInformation(), false, null)).getFileVersion();
			updateVersion(version);
		}
	}

	/**
	 * Finds the location of the cached file, preliminary or not.
	 * 
	 * @throws FileTransferException if any error occurs retrieving the file
	 */
	private void getCachedFileLocation() throws FileTransferException {
		String errorMessage = "The file " + getTransfer().getFileName() + " in version "
			+ getTransfer().getFileVersion() + " could not be located!";
		File versionedCachedFile = FileTransferUtil.constructCachedFile(getFileInformation(), getProjectId());
		// if the file transfer has a non-null preliminary file name, then the file has not been versioned yet. thus,
		// request a new file version from the server and rename the unversioned cached file
		if (getTransfer().getPreliminaryFileName() != null) {
			File unversionedCachedFile;
			try {
				unversionedCachedFile = FileTransferUtil.findUnversionedCachedFile(getTransfer(), getProjectId());
			} catch (FileNotFoundException e) {
				throw new FileTransferException(errorMessage, e);
			}
			unversionedCachedFile.renameTo(versionedCachedFile);
			removePendingFileTransferPreliminaryFileName();
		}
		// if the versioned cached file does not exist, throw an exception, as the upload can not be continued
		if (!versionedCachedFile.exists()) {
			throw new FileTransferException(errorMessage);
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
	 */
	private void executeTransfer(IProgressMonitor monitor) throws EmfStoreException {
		FileChunk fileChunk;
		initializeMonitor(monitor);
		do {
			fileChunk = FilePartitionerUtil.readChunk(getFile(), getFileInformation());
			getConnectionManager().uploadFileChunk(getSessionId(), getProjectId(), fileChunk);
			monitor.worked(1);
			incrementChunkNumber();
			setNewPendingFileTransferChunkNumber();
			checkCancelled();
		} while (!fileChunk.isLast());
		removePendingFileTransfer();
	}

	private void extensionPointAction() throws FileTransferException {
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(getExtensionId());
		for (IConfigurationElement e : config) {
			try {
				final Object o = e.createExecutableExtension("listener");
				ISafeRunnable runnable = new ISafeRunnable() {

					/**
					 * @see org.eclipse.core.runtime.ISafeRunnable#run()
					 */
					public void run() {
						FileTransferOnDone onDone = (FileTransferOnDone) o;
						onDone.setProjectSpace(getProjectSpace());
						onDone.setFileInformation(getFileInformation());
					}

					/**
					 * @see org.eclipse.core.runtime.ISafeRunnable#handleException(java.lang.Throwable)
					 */
					public void handleException(Throwable exception) {
						WorkspaceUtil.logException("Exception on ModelElementId: "
							+ getFileInformation().getFileIdentifier(), new FileTransferException(exception
							.getMessage(), exception));
					}

				};
				SafeRunner.run(runnable);
			} catch (CoreException e1) {
				throw new FileTransferException("Could not set file attachment attributes!", e1);
			}
		}

	}
}
