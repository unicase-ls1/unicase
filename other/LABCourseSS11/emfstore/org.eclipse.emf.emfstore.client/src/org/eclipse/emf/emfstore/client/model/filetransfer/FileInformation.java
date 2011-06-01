/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.model.filetransfer;

import org.eclipse.emf.emfstore.server.model.FileIdentifier;

/**
 * This is a facade class to execute different actions and queries on files that a project space has. An instance of
 * this class is retrieved by calling ProjectSpace.getFileInfo( FileIdentifier ). It can be used to access or alter
 * different aspects of the file wih the given identifier. If the file API is to be extended in the future, do this by
 * adding methods to this class instead of adding them to the project space directly. This way the (already huge)
 * interface of the ProjectSpace is kept slim.
 * 
 * @author jfinis
 */
public class FileInformation {

	/**
	 * The id of the file for which this information was created.
	 */
	private FileIdentifier fileId;

	/**
	 * The transfer manager associated to the file (and thus also the project space to which the file belongs).
	 */
	private FileTransferManager transferManager;

	/**
	 * Default constructor. Only to be called by a transfer manager.
	 * 
	 * @param fileId the file id for which to create information
	 * @param transferManager the administering transfer manager
	 */
	FileInformation(FileIdentifier fileId, FileTransferManager transferManager) {
		this.fileId = fileId;
		this.transferManager = transferManager;
	}

	/**
	 * Returns true if the file is cached locally. If this method returns true, the getFile method will succeed even if
	 * no connection to the server exists.
	 * 
	 * @return true, iff the file is cached locally
	 */
	public boolean isCached() {
		return transferManager.getCache().hasCachedFile(fileId);
	}

	/**
	 * Returns true if this file was recently added but not yet commited. This means that it is a "pending upload", i.e.
	 * a file that waits in the cache for being uploaded to the EMF Store. The specialty about such a file is that it
	 * can be removed, since it is not saved at the server yet. You can use the cancelPendingUpload() method to remove
	 * such a file.
	 * 
	 * @return iff this file is a pending upload
	 */
	public boolean isPendingUpload() {
		return transferManager.hasWaitingUpload(fileId);
	}

	/**
	 * Cancels a pending upload. This means that the pending upload is removed from the upload queue and deleted from
	 * cache. If the upload is not pending, then this method does nothing.
	 */
	public void cancelPendingUpload() {
		if (!isPendingUpload()) {
			return;
		}
		transferManager.cancelPendingUpload(fileId);
	}
}
