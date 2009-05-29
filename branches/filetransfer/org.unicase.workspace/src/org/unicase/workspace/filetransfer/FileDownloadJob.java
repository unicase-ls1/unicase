/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.filetransfer;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FileTransferException;
import org.unicase.emfstore.filetransfer.FileChunk;
import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.emfstore.filetransfer.FilePartitionerUtil;
import org.unicase.model.attachment.FileAttachment;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.util.FileTransferUtil;

/**
 * Job for the file download.
 * 
 * @author C
 */
public class FileDownloadJob extends Job {

	private ConnectionManager connectionManager;
	private FileAttachment fileAttachment;
	private SessionId sessionId;
	private ProjectId projectId;
	private FileInformation fileInformation;
	private Exception exception;

	/**
	 * @param fileAttachment file attachment for which the file is to be downloaded
	 * @param fileInformation file information
	 */
	public FileDownloadJob(FileAttachment fileAttachment, FileInformation fileInformation) {
		super("File Download Job for " + fileAttachment.getFileName());
		this.fileAttachment = fileAttachment;
		this.fileInformation = fileInformation;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		// read values from file attachment
		getAttributes();
		// only download if values in the file attachment are set
		if (fileAttachment.getFileName() != null && !fileAttachment.getFileName().equals("")
			&& fileAttachment.getFileID() != null && !fileAttachment.getFileID().equals("")) {
			// make sure that the local cache folder exists
			new File(FileTransferUtil.getCacheFolder(fileAttachment)).mkdirs();
			// retrieve the location of the cached file
			File file = new File(FileTransferUtil.getCachedFileLocation(fileAttachment));
			FileChunk fileChunk;
			// check if it is a resume, in which case file version is not -1
			if (fileInformation.getFileVersion() == -1) {
				fileInformation.setFileVersion(Integer.parseInt(fileAttachment.getFileID()));
			}
			try {
				do {
					fileChunk = connectionManager.downloadFileChunk(sessionId, projectId, fileInformation);
					FilePartitionerUtil.writeChunk(file, fileChunk);
					fileInformation.setChunkNumber(fileInformation.getChunkNumber() + 1);
				} while (!fileChunk.isLast());
			} catch (EmfStoreException e) {
				exception = e;
				return Status.CANCEL_STATUS;
			} catch (IOException e) {
				exception = e;
				return Status.CANCEL_STATUS;
			}
		} else {
			exception = new FileTransferException("There is no file attached to this file attachment!");
			return Status.CANCEL_STATUS;
		}
		return Status.OK_STATUS;
	}

	private void getAttributes() {
		// read values from file attachment
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				connectionManager = WorkspaceManager.getInstance().getConnectionManager();
				sessionId = WorkspaceManager.getProjectSpace(fileAttachment).getUsersession().getSessionId();
				projectId = WorkspaceManager.getProjectSpace(fileAttachment).getProjectId();
			}
		});
	}

	/**
	 * @return any caught exception, otherwise null
	 */
	public Exception getException() {
		return exception;
	}

	/**
	 * @return the downloaded file's name
	 */
	public String getDownloadedFileName() {
		return fileAttachment.getFileName();
	}
}