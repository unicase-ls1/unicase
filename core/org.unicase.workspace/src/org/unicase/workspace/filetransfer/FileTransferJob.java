/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.filetransfer;

import java.io.File;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.model.attachment.FileAttachment;
import org.unicase.workspace.PendingFileTransfer;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.impl.ProjectSpaceImpl;
import org.unicase.workspace.impl.WorkspaceFactoryImpl;

/**
 * Job for the file download.
 * 
 * @author pfeifferc
 */
public abstract class FileTransferJob extends Job {

	private ConnectionManager connectionManager;
	private SessionId sessionId;
	private ProjectId projectId;
	private FileInformation fileInformation;
	private FileAttachment fileAttachment;
	private Exception exception;
	private File file;

	/**
	 * @param name of the job
	 */
	public FileTransferJob(String name) {
		super(name);
	}

	/**
	 * Adds a pending file transfer to the pending file transfers.
	 * 
	 * @param upload true if pending file transfer is upload
	 */
	protected void addPendingFileTransfer(final boolean upload) {
		removePendingFileTransfer(upload);
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				PendingFileTransfer transfer = WorkspaceFactoryImpl.eINSTANCE.createPendingFileTransfer();
				transfer.setAttachmentId(fileAttachment.getModelElementId());
				transfer.setChunkNumber(fileInformation.getChunkNumber());
				transfer.setFileVersion(fileInformation.getFileVersion());
				transfer.setUpload(upload);
				WorkspaceManager.getProjectSpace(fileAttachment).getPendingFileTransfers().add(transfer);
				((ProjectSpaceImpl) WorkspaceManager.getProjectSpace(fileAttachment)).saveProjectSpaceOnly();
			}
		});
	}

	/**
	 * Sets a pending file transfer from the pending file transfers.
	 * 
	 * @param upload true if pending file transfer is upload
	 */
	protected void setPendingFileTransfer(final boolean upload) {
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				for (PendingFileTransfer transfer : WorkspaceManager.getProjectSpace(fileAttachment)
					.getPendingFileTransfers()) {
					if (transfer.getAttachmentId() != null
						&& transfer.getAttachmentId().getId().equals(fileAttachment.getIdentifier())
						&& transfer.isUpload() == upload
						&& transfer.getFileVersion() == fileInformation.getFileVersion()) {
						transfer.setChunkNumber(fileInformation.getChunkNumber());
						break;
					}
				}
				((ProjectSpaceImpl) WorkspaceManager.getProjectSpace(fileAttachment)).saveProjectSpaceOnly();
			}
		});
	}

	/**
	 * Removes a pending file transfer from the pending file transfers. *
	 * 
	 * @param upload true if pending file transfer is upload
	 */
	protected void removePendingFileTransfer(final boolean upload) {
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				for (PendingFileTransfer transfer : WorkspaceManager.getProjectSpace(fileAttachment)
					.getPendingFileTransfers()) {
					if (transfer.getAttachmentId() != null
						&& transfer.getAttachmentId().getId().equals(fileAttachment.getIdentifier())
						&& transfer.isUpload() == upload
						&& transfer.getFileVersion() == fileInformation.getFileVersion()) {
						WorkspaceManager.getProjectSpace(fileAttachment).getPendingFileTransfers().remove(transfer);
						break;
					}
				}
				((ProjectSpaceImpl) WorkspaceManager.getProjectSpace(fileAttachment)).saveProjectSpaceOnly();
			}
		});
	}

	/**
	 * Gets the attributes required for the file transfer.
	 */
	protected void getAttributes() {
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
	 * @return the exception, if there has been any. Null otherwise.
	 */
	public Exception getException() {
		return exception;
	}

	/**
	 * @param e exception thrown
	 */
	protected void setException(Exception e) {
		this.exception = e;
	}

	/**
	 * @return the connection manager.
	 */
	protected ConnectionManager getConnectionManager() {
		return connectionManager;
	}

	/**
	 * Sets the connection manager.
	 * 
	 * @param connectionManager connection manager
	 */
	protected void setConnectionManager(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	/**
	 * @return the session id
	 */
	protected SessionId getSessionId() {
		return sessionId;
	}

	/**
	 * Sets the session id.
	 * 
	 * @param sessionId session id
	 */
	protected void setSessionId(SessionId sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return project id
	 */
	protected ProjectId getProjectId() {
		return projectId;
	}

	/**
	 * Sets the project id.
	 * 
	 * @param projectId project id
	 */
	protected void setProjectId(ProjectId projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the file information data object
	 */
	public FileInformation getFileInformation() {
		return fileInformation;
	}

	/**
	 * @param fileInformation file information data object
	 */
	protected void setFileInformation(FileInformation fileInformation) {
		this.fileInformation = fileInformation;
	}

	/**
	 * @return file attachment
	 */
	protected FileAttachment getFileAttachment() {
		return fileAttachment;
	}

	/**
	 * @param fileAttachment file attachment
	 */
	protected void setFileAttachment(FileAttachment fileAttachment) {
		this.fileAttachment = fileAttachment;
	}

	/**
	 * @return file
	 */
	protected File getFile() {
		return file;
	}

	/**
	 * @param file file
	 */
	protected void setFile(File file) {
		this.file = file;
	}
}
