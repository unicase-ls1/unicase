/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.teamprovider;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.emfstore.teamprovider.exception.TeamSynchronizerException;
import org.eclipse.team.core.history.IFileRevision;

/**
 * Each supported team provider has to implement this interface. This class will be used to help to synchronize the
 * state with the team provider.
 * 
 * @author Adrian Staudt
 */
public interface ITeamSynchronizer {

	/**
	 * This id will identify the team provider nature id that is supported by this ITeamSynchronizer.
	 * 
	 * @return The nature id.
	 */
	String getSupportedNatureID();

	/**
	 * Tells if the file is shared with the team provider. A project does not only contain shared files.
	 * 
	 * @param file A eclipse workspace file.
	 * @return True if the file is shared, false otherwise.
	 */
	boolean isFileShared(IFile file);

	/**
	 * Finds out the revision in the current working copy of a file.
	 * 
	 * @param file A eclipse workspace file.
	 * @return The working copy revision.
	 * @throws TeamSynchronizerException Will be thrown if the revision cannot be resolved.
	 */
	String getWorkingCopyRevision(IFile file) throws TeamSynchronizerException;

	/**
	 * Returns the latest revision of a file. The remote part will be therefore connected.
	 * 
	 * @param file An eclipse workspace file.
	 * @return The head revision.
	 * @throws TeamSynchronizerException Will be thrown if the revision cannot be resolved.
	 */
	String getHeadRevision(IFile file) throws TeamSynchronizerException;

	/**
	 * Tells if the content of the file has been changed from the latest checked out revision.
	 * 
	 * @param file An eclipse workspace file.
	 * @return True if the file is dirty, false otherwise.
	 * @throws TeamSynchronizerException Will be thrown if it cannot be figured out if the file is dirty.
	 */
	boolean isFileDirty(IFile file) throws TeamSynchronizerException;

	/**
	 * Compares two team revisions and returns which one is a predecessor of each other.
	 * 
	 * @param revision1 The first team revision.
	 * @param revision2 The second team revision.
	 * @return 0: if revision1 == revision2, 1: if revision1 comes before revision2, -1: if revision1 comes after
	 *         revision2
	 * @throws TeamSynchronizerException Will thrown if an error occurs during execution.
	 */
	int compare(String revision1, String revision2) throws TeamSynchronizerException;

	/**
	 * Returns the history for an file that has been created by a team provider.
	 * 
	 * @param file An eclipse workspace file.
	 * @return The file history.
	 */
	IFileRevision[] getHistory(IFile file);

	/**
	 * Updates the local file with the latest one from the remote repository.
	 * 
	 * @param file An eclipse workspace file.
	 */
	void updateFile(IFile file);

	/**
	 * A TeamSynchronizer provides functionality how pure team provider changes should be handles. Usually the user
	 * should get a message that there are some changes that could not be tracked and the reason why this happened.
	 * 
	 * @param file An eclipse workspace file.
	 * @throws TeamSynchronizerException Will thrown if an error occurs during execution.
	 */
	void handlePureTeamProviderChange(IFile file) throws TeamSynchronizerException;
}
