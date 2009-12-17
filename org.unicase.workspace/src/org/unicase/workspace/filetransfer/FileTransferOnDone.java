/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.filetransfer;

import org.unicase.emfstore.filetransfer.FileInformation;
import org.unicase.workspace.ProjectSpace;

/**
 * @author pfeifferc
 */
public interface FileTransferOnDone {

	/**
	 * @param projectSpace project space
	 */
	void setProjectSpace(ProjectSpace projectSpace);

	/**
	 * @param fileInformation file information
	 */
	void setFileInformation(FileInformation fileInformation);

}
