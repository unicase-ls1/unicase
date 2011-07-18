/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.git;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.egit.core.project.RepositoryMapping;
import org.eclipse.jgit.dircache.DirCache;
import org.eclipse.jgit.dircache.DirCacheEntry;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.errors.NoWorkTreeException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevSort;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.storage.file.FileRepository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.treewalk.filter.PathFilter;
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
	 * Reads from the git index the git entry representation for the given file.
	 * 
	 * @param file A eclipse workspace file.
	 * @return A git entry.
	 * @throws TeamSynchronizerException Will be thrown if no git entry can be found.
	 */
	public DirCacheEntry getGitEntry(IFile file) throws TeamSynchronizerException {
		IProject project = file.getProject();
		RepositoryMapping repositoryMapping = RepositoryMapping.getMapping(project);
		Repository repository = repositoryMapping.getRepository();
		String gitEntryPath = repositoryMapping.getRepoRelativePath(file);

		try {
			File gitDirectory = repository.getDirectory();
			FileRepository fileRepository = new FileRepositoryBuilder().setGitDir(gitDirectory).build();
			DirCache dirCache = fileRepository.readDirCache();

			// String gitEntryPath = file.getFullPath().makeRelative().toPortableString();
			DirCacheEntry dirCacheEntry = dirCache.getEntry(gitEntryPath);
			if (dirCacheEntry == null) {
				throw new TeamSynchronizerException("Git entry not found.");
			}
			return dirCacheEntry;

		} catch (NoWorkTreeException e) {
			throw new TeamSynchronizerException(e);

		} catch (IOException e) {
			throw new TeamSynchronizerException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.jdt.ITeamSynchronizer#isFileShared(org.eclipse.core.resources.IFile)
	 */
	public boolean isFileShared(IFile file) {
		try {
			getGitEntry(file);
			return true;

		} catch (TeamSynchronizerException e) {
			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.jdt.ITeamSynchronizer#getWorkingCopyRevision(org.eclipse.core.resources.IFile)
	 */
	public String getWorkingCopyRevision(IFile file) throws TeamSynchronizerException {
		IProject project = file.getProject();
		RepositoryMapping repositoryMapping = RepositoryMapping.getMapping(project);
		Repository repository = repositoryMapping.getRepository();

		DirCacheEntry gitEntry = getGitEntry(file);

		try {
			final RevWalk walk = new RevWalk(repository);
			walk.sort(RevSort.TOPO, true);
			walk.sort(RevSort.COMMIT_TIME_DESC, true);

			walk.setTreeFilter(PathFilter.create(gitEntry.getPathString()));

			final ObjectId start = repository.resolve(Constants.HEAD);
			walk.markStart(walk.parseCommit(start));

			RevCommit commit = walk.next();
			if (commit != null) {
				return commit.getId().getName();
			}

			throw new TeamSynchronizerException("Revision cannot be found.");

		} catch (MissingObjectException e) {
			throw new TeamSynchronizerException(e);
		} catch (IncorrectObjectTypeException e) {
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
		DirCacheEntry gitEntry = getGitEntry(file);
		return gitEntry.isUpdateNeeded();
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
		// this operation is not needed for git synchronization
		if (revision1.equals(revision2)) {
			return 0;
		}
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.jdt.ITeamSynchronizer#updateFile(org.eclipse.core.resources.IFile)
	 */
	public void updateFile(IFile file) {
		// this operation is not needed for git synchronization
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.jdt.ITeamSynchronizer#handlePureTeamProviderChange(org.eclipse.core.resources.IFile)
	 */
	public void handlePureTeamProviderChange(final IFile file) throws TeamSynchronizerException {
		// this operation is not yet applicable for git
		throw new UnsupportedOperationException();
	}
}
