/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.svn;

import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.team.core.diff.IDiff;
import org.eclipse.team.core.history.IFileHistory;
import org.eclipse.team.core.history.IFileRevision;
import org.eclipse.team.svn.core.connector.SVNConnectorException;
import org.eclipse.team.svn.core.connector.SVNEntryInfo;
import org.eclipse.team.svn.core.history.SVNFileHistoryProvider;
import org.eclipse.team.svn.core.operation.local.InfoOperation;
import org.eclipse.team.svn.core.resource.IRepositoryResource;
import org.eclipse.team.svn.core.svnstorage.SVNRemoteStorage;
import org.unicase.emfstore.jdt.ITeamSynchronizer;
import org.unicase.emfstore.jdt.configuration.ConfigurationManager;
import org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration;
import org.unicase.emfstore.jdt.configuration.Entry;
import org.unicase.emfstore.jdt.eclipseworkspace.StructuredEMFStoreURI;
import org.unicase.emfstore.jdt.eclipseworkspace.emfstore.ProjectSpaceUtil;
import org.unicase.emfstore.jdt.exception.CannotOpenEObjectException;
import org.unicase.emfstore.jdt.exception.EObjectNotFoundException;
import org.unicase.emfstore.jdt.exception.EntryNotFoundException;
import org.unicase.emfstore.jdt.exception.NoEMFStoreJDTConfigurationException;
import org.unicase.emfstore.jdt.exception.ProjectSpaceNotFoundException;
import org.unicase.emfstore.jdt.exception.TeamSynchronizerException;

/**
 * Provides information to be able to synchronize a file against SVN.
 * 
 * @author Adrian Staudt
 */
public class SVNTeamSynchronizer implements ITeamSynchronizer {

	private static final String NATURE_ID = "org.eclipse.team.svn.core.svnnature";

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
		InfoOperation infoOperation = new InfoOperation(file);
		infoOperation.run(new NullProgressMonitor());
		SVNEntryInfo info = infoOperation.getInfo();

		if (info == null) {
			return false;
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.jdt.ITeamSynchronizer#getWorkingCopyRevision(org.eclipse.core.resources.IFile)
	 */
	public String getWorkingCopyRevision(IFile file) {
		InfoOperation infoOperation = new InfoOperation(file);
		infoOperation.run(new NullProgressMonitor());
		SVNEntryInfo info = infoOperation.getInfo();
		if (info == null) {
			return null;
		}

		return String.valueOf(info.lastChangedRevision);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.jdt.ITeamSynchronizer#getHeadRevision(org.eclipse.core.resources.IFile)
	 */
	public String getHeadRevision(IFile file) throws TeamSynchronizerException {
		try {
			IRepositoryResource remote = SVNRemoteStorage.instance().asRepositoryResource(file);
			long revision = remote.getRoot().getRevision();
			return String.valueOf(revision);

		} catch (SVNConnectorException e) {
			throw new TeamSynchronizerException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.jdt.ITeamSynchronizer#isFileDirty(org.eclipse.core.resources.IFile)
	 */
	public boolean isFileDirty(IFile file) throws TeamSynchronizerException {
		try {
			org.eclipse.team.ui.mapping.SynchronizationStateTester tester = new org.eclipse.team.ui.mapping.SynchronizationStateTester();
			int stateFlags = tester.getState(file, IDiff.CHANGE, new NullProgressMonitor());
			if (stateFlags == 0) {
				return false;
			}
			return true;

		} catch (CoreException e) {
			throw new TeamSynchronizerException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.jdt.ITeamSynchronizer#getHistory(org.eclipse.core.resources.IFile)
	 */
	public IFileRevision[] getHistory(IFile file) {
		SVNFileHistoryProvider history = new SVNFileHistoryProvider();
		IFileHistory fileHistoryFor = history.getFileHistoryFor(file, 0, new NullProgressMonitor());

		IFileRevision[] fileRevisions = fileHistoryFor.getFileRevisions();
		return fileRevisions;
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
		org.eclipse.team.svn.core.operation.local.UpdateOperation updateOperation = new org.eclipse.team.svn.core.operation.local.UpdateOperation(
			new IFile[] { file }, true);
		updateOperation.run(new NullProgressMonitor());

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.jdt.ITeamSynchronizer#handlePureTeamProviderChange(org.eclipse.core.resources.IFile)
	 */
	public void handlePureTeamProviderChange(final IFile file) throws TeamSynchronizerException {
		// get destination where the SVN file should be placed
		IPath filePath = file.getProjectRelativePath();
		String fileExtension = filePath.getFileExtension();
		IPath svnFilePath = filePath.removeFileExtension().addFileExtension("svncopy." + fileExtension);

		try {
			// copy SVN content to a new location
			final IFile svnFile = file.getProject().getFile(svnFilePath);
			if (svnFile.exists()) {
				return;
			}

			svnFile.create(file.getContents(true), true, new NullProgressMonitor());

			// load content from EMF Store and write it to the original file
			try {
				EMFStoreJDTConfiguration emfStoreJDTConfiguration = ConfigurationManager.getConfiguration(file
					.getProject());
				Entry entry = ConfigurationManager.getEntry(emfStoreJDTConfiguration, file);
				StructuredEMFStoreURI structuredEMFStoreURI = ConfigurationManager.getEMFStoreURI(entry);
				EObject eObject = ProjectSpaceUtil.getEObject(structuredEMFStoreURI);
				InputStream eObjectInputStream = ProjectSpaceUtil.eObjectAsInputStream(eObject);
				file.setContents(eObjectInputStream, true, true, new NullProgressMonitor());

				// show warning message and give information how to handle this issue
				Display.getDefault().syncExec(new Runnable() {
					public void run() {
						Shell shell = Display.getDefault().getActiveShell();
						String lastCommitter = getLastCommitter(file);
						StringBuffer dialogBody = new StringBuffer();
						dialogBody
							.append("A change has been detected, that has been done without EMF Store support. A copy of this file is available under the name "
								+ svnFile.getName()
								+ ".\nYou will continue working with the content from the EMF Store. Please compare therefore the changes manually.");
						if (lastCommitter != null) {
							dialogBody.append("\nThe last change has been committed by " + lastCommitter + ".");
						}

						MessageDialog.openInformation(shell, "Pure SVN Change", dialogBody.toString());
					}
				});

			} catch (NoEMFStoreJDTConfigurationException e) {
				throw new TeamSynchronizerException(e);
			} catch (EntryNotFoundException e) {
				throw new TeamSynchronizerException(e);
			} catch (EObjectNotFoundException e) {
				throw new TeamSynchronizerException(e);
			} catch (ProjectSpaceNotFoundException e) {
				throw new TeamSynchronizerException(e);
			} catch (CannotOpenEObjectException e) {
				throw new TeamSynchronizerException(e);
			}

		} catch (CoreException e) {
			throw new TeamSynchronizerException(e);
		}
	}

	private String getLastCommitter(IFile file) {
		org.eclipse.team.svn.core.operation.local.InfoOperation infoOperation = new org.eclipse.team.svn.core.operation.local.InfoOperation(
			file);
		infoOperation.run(new NullProgressMonitor());

		return infoOperation.getInfo().lastChangedAuthor;
	}
}
