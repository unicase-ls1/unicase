/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.filetransfer;

import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.model.attachment.FileAttachment;

/**
 * Empty implementation.
 * 
 * @author pfeifferc
 */
public class FileTransferObserverImpl implements FileTransferObserver {

	/**
	 * {@inheritDoc}
	 */
	public void downloadFinished(Exception exception, FileAttachment fileAttachment) {
		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 */
	public void uploadFinished(Exception exception, FileAttachment fileAttachment, FileInformation fileInformation,
		int size) {
		// nothing to do
	}
}
