/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.git;

import java.util.Collection;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egit.ui.CommitObserver;
import org.unicase.emfstore.jdt.CommitHelper;
import org.unicase.emfstore.jdt.configuration.Entry;
import org.unicase.emfstore.jdt.configuration.SimpleVersionMapping;
import org.unicase.emfstore.jdt.eclipseworkspace.IFileEntryTuple;
import org.unicase.emfstore.jdt.eclipseworkspace.ResourceCommitHolder;
import org.unicase.emfstore.jdt.eclipseworkspace.emfstore.EMFStoreCommit;
import org.unicase.emfstore.jdt.exception.CommitCannotCompleteException;
import org.unicase.emfstore.jdt.ui.decorator.EMFStoreJDTEntryDecorator;
import org.unicase.metamodel.util.ModelUtil;

/**
 * An implementation for the EGit commit observer in order to be able to hook into the commit process.
 * 
 * @author Adrian Staudt
 */
public class GitCommitObserver implements CommitObserver {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.egit.ui.CommitObserver#finaliceCommit(org.eclipse.egit.core.op.CommitOperation)
	 */
	public boolean finalizeCommit(org.eclipse.egit.core.op.CommitOperation commitOperation) {
		String commitMessage = commitOperation.getMessage();

		// GitTeamSynchronizer gitTeamSynchronizer = new GitTeamSynchronizer();

		IFile[] filesToCommit = commitOperation.getFilesToCommit();
		ResourceCommitHolder resourceCommitHolder = new ResourceCommitHolder(filesToCommit);

		Set<IProject> releatedProjects = resourceCommitHolder.getReleatedProjects();
		if (!CommitHelper.isEMFStoreJDTInvolved(releatedProjects)) {
			// this commit is independent from the EMFStoreJDT commit
			return true;
		}

		// ensure that .emfstoreconf will be a part of the committed resources. Even if the file
		// is currently unmodified, a VersionMapping will be created and at least then the .emfstoreconf file
		// will be dirty and a commit is needed.
		Set<IFile> allFiles = resourceCommitHolder.getAllFiles();
		// TODO .emfstoreconf is index, is tracked ??
		Collection<IFile> notIndexedFiles = commitOperation.getNotIndexedFiles();
		Collection<IFile> notTrackedFiles = commitOperation.getNotTrackedFiles();
		commitOperation.setNewFilesToCommit(allFiles.toArray(new IFile[0]), notIndexedFiles, notTrackedFiles);
		// for (IProject project : resourceCommitHolder.getReleatedProjects()) {
		// IFile confFile = project.getFile(ConfigurationManager.EMFSTORECONF);
		// notIndexedFiles.add(confFile);
		// notTrackedFiles.add(confFile);
		// }
		// commitOperation.setNewFilesToCommit(allFiles.toArray(new IFile[0]), notIndexedFiles, notTrackedFiles);

		// TODO, get outdated files
		Set<IFileEntryTuple> emfStoreManagedFETuples = resourceCommitHolder.getEMFStoreManagedFETuples();

		EMFStoreCommit emfStoreCommit = new EMFStoreCommit(resourceCommitHolder, commitMessage);
		boolean overallPreparedCommit = emfStoreCommit.prepareCommit();
		if (overallPreparedCommit) {
			// at this point it is expected that the commit will not fail.
			// well this is in fact not true. intermediate commits can happen.

			// Create VersionMapping
			for (IFileEntryTuple emfStoreManagedFETuple : emfStoreManagedFETuples) {
				try {
					SimpleVersionMapping simpleVersionMapping = GitVersionMappingCreator.getVM(emfStoreManagedFETuple);

					Entry entry = emfStoreManagedFETuple.getEntry();
					entry.setVersionMapping(simpleVersionMapping);
					entry.getConfiguration().save();

				} catch (CommitCannotCompleteException e) {
					ModelUtil.logException(e);

					// cancel commit
					return false;
				}
			}

			// remove unpushed entries
			resourceCommitHolder.removeEntriesThatAreMarkedForDeletion();

			// remove committed forced files
			resourceCommitHolder.cleanForcedEMFStoresToCommit();

			try {
				// Commit Git Commit
				commitOperation.execute(new NullProgressMonitor());

				// Finalice commit for EMFStore
				emfStoreCommit.finaliceCommit();

			} catch (CoreException e) {
				// Git commit has thrown an exception, anyway false will be returned

			} finally {
				// refresh UI
				EMFStoreJDTEntryDecorator.refreshDecorator();
			}
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.egit.ui.CommitObserver#getRefuseReason()
	 */
	public String getRefuseReason() {
		return null;
	}

}
