/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.filetransfer;

import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.model.attachment.FileAttachment;

/**
 * Observer for file transfers.
 * 
 * @author pfeifferc
 */
public interface FileTransferObserver {

	/**
	 * @param fileInfo file information
	 * @param exception exception that might be thrown
	 * @param projectId project id
	 */
	void downloadFinished(final FileInformation fileInfo, final Exception exception, final ProjectId projectId);

	/**
	 * @param exception that might have been thrown
	 * @param fileAttachment for which the download was finished
	 * @param fileInformation file information
	 */
	void uploadFinished(final Exception exception, final FileAttachment fileAttachment,
		final FileInformation fileInformation);
}
