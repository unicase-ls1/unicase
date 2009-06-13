/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.filetransfer;

import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.model.attachment.FileAttachment;

/**
 * Observer for file transfers.
 * 
 * @author pfeifferc
 */
public interface FileTransferObserver {

	/**
	 * @param exception that might have been thrown
	 * @param fileAttachment for which the upload was finished
	 */
	void downloadFinished(final Exception exception, final FileAttachment fileAttachment);

	/**
	 * @param exception that might have been thrown
	 * @param fileAttachment for which the download was finished
	 * @param fileInformation file information
	 * @param size size
	 */
	void uploadFinished(final Exception exception, final FileAttachment fileAttachment,
		final FileInformation fileInformation, final int size);
}
