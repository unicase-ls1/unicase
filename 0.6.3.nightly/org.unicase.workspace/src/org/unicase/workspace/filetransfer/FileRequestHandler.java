/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.filetransfer;

import java.io.File;
import java.io.FileNotFoundException;

import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.workspace.ProjectSpace;

/**
 * @author pfeifferc
 */
public class FileRequestHandler {

	private FileInformation fileInformation;
	private ProjectSpace projectSpace;

	/**
	 * @param fileInformation pending file transfer
	 * @param projectSpace project space
	 */
	public FileRequestHandler(FileInformation fileInformation, ProjectSpace projectSpace) {
		this.fileInformation = fileInformation;
		this.projectSpace = projectSpace;
	}

	/**
	 * @return true if finished, false if not
	 */
	public boolean isDownloadFinished() {
		if (projectSpace.hasFileTransfer(fileInformation, false)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the file
	 * @throws FileNotFoundException if the download has not yet been finished or in case of other aberrances
	 */
	public File getLocation() throws FileNotFoundException {
		return FileTransferUtil.findCachedFile(fileInformation, projectSpace.getProjectId());
	}
}