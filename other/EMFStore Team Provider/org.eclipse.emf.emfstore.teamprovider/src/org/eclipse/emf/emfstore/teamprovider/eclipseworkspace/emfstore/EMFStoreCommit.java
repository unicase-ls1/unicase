/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen. All rights
 * reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public
 * License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.teamprovider.eclipseworkspace.emfstore;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.exceptions.CommitCanceledException;
import org.eclipse.emf.emfstore.client.model.exceptions.NoLocalChangesException;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommandWithResult;
import org.eclipse.emf.emfstore.client.ui.commands.CommitProjectHandler;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationManager;
import org.eclipse.emf.emfstore.teamprovider.configuration.EMFStoreJDTConfiguration;
import org.eclipse.emf.emfstore.teamprovider.configuration.Entry;
import org.eclipse.emf.emfstore.teamprovider.eclipseworkspace.ResourceCommitHolder;
import org.eclipse.emf.emfstore.teamprovider.exception.CannotOpenEObjectException;
import org.eclipse.emf.emfstore.teamprovider.exception.EMFStoreURIMalformedException;
import org.eclipse.emf.emfstore.teamprovider.exception.EObjectNotFoundException;
import org.eclipse.emf.emfstore.teamprovider.exception.EntryNotFoundException;
import org.eclipse.emf.emfstore.teamprovider.exception.NoEMFStoreJDTConfigurationException;
import org.eclipse.emf.emfstore.teamprovider.exception.ProjectSpaceNotFoundException;

/**
 * Helper to be able to commit the involved ProjectSpaces dependent from the selected resources.
 * 
 * @author Adrian Staudt
 */
public class EMFStoreCommit {

	private final ResourceCommitHolder resourceCommitHolder;
	private final String commitMessage;
	private final List<FinalizeCommitTriple> preparedCommitTripleList = new ArrayList<FinalizeCommitTriple>();

	/**
	 * Constructor.
	 * 
	 * @param resourceCommitHolder Holds the resources that have to be commited.
	 * @param commitMessage The commit message.
	 */
	public EMFStoreCommit(ResourceCommitHolder resourceCommitHolder, String commitMessage) {
		this.resourceCommitHolder = resourceCommitHolder;
		this.commitMessage = commitMessage;
	}

	/**
	 * Prepares all involved ProjectSpaces for commit.
	 * 
	 * @return True if all project spaces were successfully prepared for commit, false on aboard.
	 */
	public boolean prepareCommit() {
		// get ProjectSpaces from CommitFiles
		Collection<ProjectSpace> projectSpacesToCommit = resourceCommitHolder.getProjectSpacesToCommit();

		// commit each ProjectSpace
		boolean overallPreparedCommit = true;
		Iterator<ProjectSpace> projectSpaceIterator = projectSpacesToCommit.iterator();
		while (overallPreparedCommit && projectSpaceIterator.hasNext()) {
			final ProjectSpace projectSpace = projectSpaceIterator.next();
			if (projectSpace.getOperations().isEmpty()) {
				continue;
			}

			final CommitProjectHandler commitProjectHandler = new CommitProjectHandler();
			commitProjectHandler.setPredefinedCommitMessage(commitMessage);

			boolean preparedCommit = new PrepareCommit(commitProjectHandler, projectSpace).run(true);
			overallPreparedCommit = overallPreparedCommit & preparedCommit;
		}

		return overallPreparedCommit;
	};

	/**
	 * Performs the real commit, where the changes are written to the server.
	 */
	public void finaliceCommit() {
		for (final FinalizeCommitTriple commitTriple : preparedCommitTripleList) {

			new EMFStoreCommand() {
				@Override
				protected void doRun() {
					try {
						CommitProjectHandler commitProjectHandler = commitTriple.getCommitProjectHandler();
						ProjectSpace projectSpace = commitTriple.getProjectSpace();
						ChangePackage changePackage = commitTriple.getChangePackage();

						commitProjectHandler.handleFinalizeCommit(projectSpace, changePackage);
					} catch (EmfStoreException e) {
						// TODO Auto-generated catch block
					}
				}
			}.run(true);
		}
	}

	/**
	 * Loads the content from the EMF Store and writs the changes to the local file. This is needed, if a merge dialog
	 * has been displayed, then the changes need to be written back to the file in the workspace.
	 * 
	 * @param files A set of files, where their content should be updated.
	 */
	public static void updateLocalContent(Set<IFile> files) {
		for (IFile file : files) {
			try {
				EMFStoreJDTConfiguration emfStoreJDTConfiguration = ConfigurationManager.getConfiguration(file
					.getProject());
				Entry entry = ConfigurationManager.getEntry(emfStoreJDTConfiguration, file);
				URI emfStoreURI = ConfigurationManager.getEMFStoreURI(entry).getEMFURI();
				EObject eObject = ProjectSpaceUtil.getEObject(emfStoreURI);
				InputStream eObjectInputStream = ProjectSpaceUtil.eObjectAsInputStream(eObject);

				file.setContents(eObjectInputStream, true, true, new NullProgressMonitor());

			} catch (NoEMFStoreJDTConfigurationException e) {
				ModelUtil.logException(e);
			} catch (EMFStoreURIMalformedException e) {
				ModelUtil.logException(e);
			} catch (EntryNotFoundException e) {
				ModelUtil.logException(e);
			} catch (CannotOpenEObjectException e) {
				ModelUtil.logException(e);
			} catch (CoreException e) {
				ModelUtil.logException(e);
			} catch (ProjectSpaceNotFoundException e) {
				ModelUtil.logException(e);
			} catch (EObjectNotFoundException e) {
				// EObject has been probably rejected, so the local file don't has to be updated.
			}
		}
	}

	/**
	 * Shows the uses the changes and asks if the changes should be accepted.
	 */
	private class PrepareCommit extends EMFStoreCommandWithResult<Boolean> {

		private final CommitProjectHandler commitProjectHandler;
		private final ProjectSpace projectSpace;

		PrepareCommit(CommitProjectHandler commitProjectHandler, ProjectSpace projectSpace) {
			this.commitProjectHandler = commitProjectHandler;
			this.projectSpace = projectSpace;
		}

		@Override
		protected Boolean doRun() {
			Boolean preparedCommit = null;
			try {
				EMFStoreUtil.checkSanity(projectSpace.getUsersession());
				ChangePackage changePackage = commitProjectHandler.handlePrepareCommit(projectSpace);
				FinalizeCommitTriple commitTriple = new FinalizeCommitTriple(commitProjectHandler, projectSpace,
					changePackage);
				preparedCommitTripleList.add(commitTriple);
				preparedCommit = true;

			} catch (NoLocalChangesException e) {
				// the ProjectSpace was dirty and it had conflicts. These conflicts were merged
				// but the result was that all changes have been rejected, so that the ProjectSpace
				// is not no longer dirty and it does not need to be committed.
				preparedCommit = true;

			} catch (CommitCanceledException e) {
				preparedCommit = false;

			} catch (EmfStoreException e) {
				preparedCommit = false;
			}
			return preparedCommit;
		}
	}
}
