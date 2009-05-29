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
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.filetransfer.FileChunk;
import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.emfstore.filetransfer.FilePartitionerUtil;
import org.unicase.model.attachment.FileAttachment;
import org.unicase.workspace.PendingFileTransfer;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.impl.WorkspaceFactoryImpl;
import org.unicase.workspace.util.FileTransferUtil;

/**
 * Job for the file upload.
 * 
 * @author C
 */
public class FileUploadJob extends Job {

	private ConnectionManager connectionManager;
	private File file;
	private FileAttachment fileAttachment;
	private SessionId sessionId;
	private ProjectId projectId;
	private FileInformation fileInformation;
	private Exception exception;
	private TransactionalEditingDomain domain;

	/**
	 * If the selectedFile is null, this means that the file transfer is to be resumed from cache.
	 * 
	 * @param selectedFile the file selected for upload
	 * @param fileAttachment the file attachment which shall refer to the uploaded file (if upload succeeds)
	 * @param fileInformation file information
	 */
	public FileUploadJob(File selectedFile, FileAttachment fileAttachment, FileInformation fileInformation) {
		super("File Download Job for " + selectedFile.getName());
		this.file = selectedFile;
		this.fileAttachment = fileAttachment;
		this.fileInformation = fileInformation;
		domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");
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
			if (fileInformation.getFileVersion() == -1) {
				fileInformation.setFileVersion(connectionManager.uploadFileChunk(sessionId, projectId,
					new FileChunk(fileInformation, false, null)).getFileVersion());
			}
			if (file != null) {
				// copy file to cache, so that it can be resumed from cache (consistency)
				file = FileTransferUtil.copyFileToCache(file, fileAttachment, fileInformation);
			} else {
				file = new File(FileTransferUtil.getCachedFileLocation(fileAttachment));
			}
			final int size = FilePartitionerUtil.getFileSize(file);
			// set the upload monitor
			monitor.beginTask("Uploading " + FileTransferUtil.getFileName(file, fileInformation.getFileAttachmentId()),
				FilePartitionerUtil.getNumberOfChunks(file));
			// executes the file transfer (loop)
			executeTransfer(monitor);
			// set file attachment values
			setAttributes(size);
		} catch (EmfStoreException e) {
			exception = e;
			return Status.CANCEL_STATUS;
		} catch (IOException e) {
			exception = e;
			return Status.CANCEL_STATUS;
		}
		return Status.OK_STATUS;
	}

	private void setAttributes(final int size) {
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				fileAttachment.setFileName(FileTransferUtil.getFileName(file, fileAttachment.getIdentifier()));
				fileAttachment.setFileID("" + fileInformation.getFileVersion());
				fileAttachment.setFileSize(size);
			}
		});
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
		// addPendingFileTransfer();
		do {
			System.out.println(WorkspaceManager.getProjectSpace(fileAttachment).getPendingFileTransfers());
			fileChunk = FilePartitionerUtil.readChunk(file, fileInformation);
			connectionManager.uploadFileChunk(sessionId, projectId, fileChunk);
			monitor.worked(1);
			fileInformation.setChunkNumber(fileInformation.getChunkNumber() + 1);
			// setPendingFileTransfer();
		} while (!fileChunk.isLast());
		// removePendingFileTransfer();
	}

	/**
	 * Gets the attributes required for the file transfer.
	 */
	private void getAttributes() {
		// read values from file attachment
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				connectionManager = WorkspaceManager.getInstance().getConnectionManager();
				sessionId = WorkspaceManager.getProjectSpace(fileAttachment).getUsersession().getSessionId();
				projectId = WorkspaceManager.getProjectSpace(fileAttachment).getProjectId();
			}
		});
	}

	private void addPendingFileTransfer() {
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				PendingFileTransfer transfer = WorkspaceFactoryImpl.eINSTANCE.createPendingFileTransfer();
				transfer.setAttachmentId(fileAttachment.getModelElementId());
				transfer.setChunkNumber(0);
				transfer.setFileVersion("" + fileInformation.getFileVersion());
				transfer.setUpload(true);
				WorkspaceManager.getProjectSpace(fileAttachment).getPendingFileTransfers().add(transfer);
			}
		});
	}

	private void setPendingFileTransfer() {
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				for (PendingFileTransfer transfer : WorkspaceManager.getProjectSpace(fileAttachment)
					.getPendingFileTransfers()) {
					if (transfer.getAttachmentId() != null && transfer.getFileVersion() != null
						&& transfer.getAttachmentId().getId().equals(fileAttachment.getIdentifier())
						&& transfer.isUpload()
						&& Integer.parseInt(transfer.getFileVersion()) == fileInformation.getFileVersion()) {
						transfer.setChunkNumber(fileInformation.getChunkNumber());
						break;
					}
				}
			}
		});
	}

	private void removePendingFileTransfer() {
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				for (PendingFileTransfer transfer : WorkspaceManager.getProjectSpace(fileAttachment)
					.getPendingFileTransfers()) {
					if (transfer.getAttachmentId() != null && transfer.getFileVersion() != null
						&& transfer.getAttachmentId().getId().equals(fileAttachment.getIdentifier())
						&& transfer.isUpload()
						&& Integer.parseInt(transfer.getFileVersion()) == fileInformation.getFileVersion()) {
						WorkspaceManager.getProjectSpace(fileAttachment).getPendingFileTransfers().remove(transfer);
						break;
					}
				}
			}
		});
	}

	/**
	 * @return the exception, if there has been any. Null otherwise.
	 */
	public Exception getException() {
		return exception;
	}

	/**
	 * @return the original file name of the uploaded file
	 */
	public String getUploadedFileName() {
		return FileTransferUtil.getFileName(file, fileAttachment.getIdentifier());
	}
}