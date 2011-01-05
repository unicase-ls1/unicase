/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.git;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.eclipse.core.resources.IFile;
import org.eclipse.egit.core.project.RepositoryMapping;
import org.eclipse.jgit.errors.NoWorkTreeException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.team.core.history.IFileRevision;
import org.unicase.emfstore.jdt.ITeamSynchronizer;
import org.unicase.emfstore.jdt.exception.TeamSynchronizerException;

/**
 * Provides information to be able to synchronize a file against SVN.
 * 
 * @author Adrian Staudt
 */
public class GitTeamSynchronizer implements ITeamSynchronizer {

	private static final String NATURE_ID = "org.eclipse.egit.core.GitProvider";

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.jdt.ITeamSynchronizer#getSupportedNatureID()
	 */
	public String getSupportedNatureID() {
		return NATURE_ID;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.jdt.ITeamSynchronizer#isFileShared(org.eclipse.core.resources.IFile)
	 */
	public boolean isFileShared(IFile file) {
		RepositoryMapping repositoryMapping = RepositoryMapping.getMapping(file);
		Repository repository = repositoryMapping.getRepository();
		try {
			@SuppressWarnings("deprecation")
			org.eclipse.jgit.lib.GitIndex.Entry entry = repository.getIndex().getEntry(
				file.getProjectRelativePath().toString());
			if (entry != null) {
				return true;
			}

		} catch (NoWorkTreeException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.jdt.ITeamSynchronizer#getWorkingCopyRevision(org.eclipse.core.resources.IFile)
	 */
	public String getWorkingCopyRevision(IFile file) throws TeamSynchronizerException {
		RepositoryMapping repositoryMapping = RepositoryMapping.getMapping(file);
		String filePath = file.getProjectRelativePath().toString();

		org.eclipse.jgit.lib.Repository repository = repositoryMapping.getRepository();
		try {
			@SuppressWarnings("deprecation")
			org.eclipse.jgit.lib.GitIndex.Entry entry = repository.getIndex().getEntry(filePath);
			if (entry == null) {
				return null;
			}
			@SuppressWarnings("deprecation")
			ObjectId objectId = entry.getObjectId();
			return objectId.getName();

		} catch (NoWorkTreeException e) {
			throw new TeamSynchronizerException(e);
		} catch (UnsupportedEncodingException e) {
			throw new TeamSynchronizerException(e);
		} catch (IOException e) {
			throw new TeamSynchronizerException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.jdt.ITeamSynchronizer#getHeadRevision(org.eclipse.core.resources.IFile)
	 */
	public String getHeadRevision(IFile file) throws TeamSynchronizerException {
		// try {
		// IRepositoryResource remote = SVNRemoteStorage.instance().asRepositoryResource(file);
		// return remote.getRoot().getRevision();
		//
		// } catch (SVNConnectorException e) {
		// throw new TeamSynchronizerException(e);
		// }
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.jdt.ITeamSynchronizer#isFileDirty(org.eclipse.core.resources.IFile)
	 */
	public boolean isFileDirty(IFile file) throws TeamSynchronizerException {
		// try {
		// org.eclipse.team.ui.mapping.SynchronizationStateTester tester = new
		// org.eclipse.team.ui.mapping.SynchronizationStateTester();
		// int stateFlags = tester.getState(file, IDiff.CHANGE, new NullProgressMonitor());
		// if (stateFlags == 0) {
		// return false;
		// } else {
		// return true;
		// }
		//
		// } catch (CoreException e) {
		// throw new TeamSynchronizerException(e);
		// }

		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.jdt.ITeamSynchronizer#getHistory(org.eclipse.core.resources.IFile)
	 */
	public IFileRevision[] getHistory(IFile file) {
		// SVNFileHistoryProvider history = new SVNFileHistoryProvider();
		// IFileHistory fileHistoryFor = history.getFileHistoryFor(file, 0, new NullProgressMonitor());
		//
		// IFileRevision[] fileRevisions = fileHistoryFor.getFileRevisions();
		// return fileRevisions;

		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.jdt.ITeamSynchronizer#compare(java.lang.String, java.lang.String)
	 */
	public int compare(String revision1, String revision2) throws TeamSynchronizerException {
		try {
			long lRevision1 = Long.valueOf(revision1);
			long lRevision2 = Long.valueOf(revision2);

			if (lRevision1 == lRevision2) {
				return 0;
			} else if (lRevision1 < lRevision2) {
				return 1;
			} else {
				return -1;
			}

		} catch (NumberFormatException e) {
			throw new TeamSynchronizerException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.jdt.ITeamSynchronizer#updateFile(org.eclipse.core.resources.IFile)
	 */
	public void updateFile(IFile file) {
		// org.eclipse.team.svn.core.operation.local.UpdateOperation updateOperation = new
		// org.eclipse.team.svn.core.operation.local.UpdateOperation(
		// new IFile[] { file }, true);
		// updateOperation.run(new NullProgressMonitor());

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.jdt.ITeamSynchronizer#handlePureTeamProviderChange(org.eclipse.core.resources.IFile)
	 */
	public void handlePureTeamProviderChange(final IFile file) throws TeamSynchronizerException {
		throw new UnsupportedOperationException();
	}
}
