/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.teamprovider.svn;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.model.ModifiedModelElementsCache;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.teamprovider.ITeamSynchronizer;
import org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationFactory;
import org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationManager;
import org.eclipse.emf.emfstore.teamprovider.configuration.HistoryVersionMappingEntry;
import org.eclipse.emf.emfstore.teamprovider.eclipseworkspace.IFileEntryTuple;
import org.eclipse.emf.emfstore.teamprovider.eclipseworkspace.StructuredEMFStoreURI;
import org.eclipse.emf.emfstore.teamprovider.eclipseworkspace.emfstore.EMFStoreUtil;
import org.eclipse.emf.emfstore.teamprovider.eclipseworkspace.emfstore.ProjectSpaceUtil;
import org.eclipse.emf.emfstore.teamprovider.exception.CommitCannotCompleteException;
import org.eclipse.emf.emfstore.teamprovider.exception.EObjectNotFoundException;
import org.eclipse.emf.emfstore.teamprovider.exception.ProjectSpaceNotFoundException;
import org.eclipse.emf.emfstore.teamprovider.exception.TeamSynchronizerException;

/**
 * Creates a VersionMapping for the new committed file. For SVN the next version is predictable, so a
 * HistoryVersionMapping will be created.
 * 
 * @author Adrian Staudt
 */
public class SVNVersionMappingCreator {

	private final IFileEntryTuple feTuple;
	private final ITeamSynchronizer teamSynchronizer;

	private boolean isFileDirty;
	private boolean isEObjectDirty;

	private HistoryVersionMappingEntry expectedVersionMapping;

	/**
	 * Constructor.
	 * 
	 * @param feTuple An tuple that holds the information for the file and the entry.
	 * @param teamSynchronizer A team synchronizer.
	 * @throws CommitCannotCompleteException Will be thrown if the commit cannot be completed.
	 */
	public SVNVersionMappingCreator(IFileEntryTuple feTuple, ITeamSynchronizer teamSynchronizer)
		throws CommitCannotCompleteException {

		this.feTuple = feTuple;
		this.teamSynchronizer = teamSynchronizer;

		try {
			isFileDirty = teamSynchronizer.isFileDirty(feTuple.getFile());
			StructuredEMFStoreURI structuredEMFStoreURI = ConfigurationManager.getEMFStoreURI(feTuple.getEntry());
			ProjectSpace projectSpace = ProjectSpaceUtil.getProjectSpace(structuredEMFStoreURI.getProjectID());
			try {
				EObject eObject = ProjectSpaceUtil.getEObject(structuredEMFStoreURI);
				ModelElementId modelElementId = projectSpace.getProject().getModelElementId(eObject);

				ModifiedModelElementsCache modifiedModelElementsCache = projectSpace.getModifiedModelElementsCache();
				isEObjectDirty = modifiedModelElementsCache.isModelElementDirty(modelElementId);

			} catch (EObjectNotFoundException e) {
				// EObject has been probably rejected
				// EMF Store version will only increase if projectSpace is dirty
				isEObjectDirty = projectSpace.isDirty();
			}

			this.expectedVersionMapping = createHP(projectSpace);

		} catch (TeamSynchronizerException e) {
			throw new CommitCannotCompleteException(e);
		} catch (ProjectSpaceNotFoundException e) {
			throw new CommitCannotCompleteException(e);
		}

	}

	private HistoryVersionMappingEntry createHP(ProjectSpace projectSpace) throws CommitCannotCompleteException {
		try {
			HistoryVersionMappingEntry historyVersionMappingEntry = ConfigurationFactory.eINSTANCE
				.createHistoryVersionMappingEntry();
			// set new expected team revision
			if (!isFileDirty) {
				String workingCopyRevision = teamSynchronizer.getWorkingCopyRevision(feTuple.getFile());
				if (workingCopyRevision == null) {
					// this is the first commit for that file
					workingCopyRevision = "1";
				}
				historyVersionMappingEntry.setTeamProviderRevision(workingCopyRevision);

			} else {
				String sHeadRevision = teamSynchronizer.getHeadRevision(feTuple.getFile());
				long lHeadRevision = Long.valueOf(sHeadRevision);
				long lHeadRevisionNext = lHeadRevision + 1;
				String sHeadRevisionNext = String.valueOf(lHeadRevisionNext);

				historyVersionMappingEntry.setTeamProviderRevision(sHeadRevisionNext);
			}

			// set new EMFStore revision
			if (!isEObjectDirty) {
				int currentProjectSpaceRevision = EMFStoreUtil.getLocalProjectSpaceRevision(projectSpace);
				historyVersionMappingEntry.setEMFStoreRevision(currentProjectSpaceRevision);

			} else {
				// don't need to get head version, because ProjectSpace has been already executed for commit preparation
				// and this means that the local ProjectSpace is up to date
				int currentProjectSpaceRevision = EMFStoreUtil.getLocalProjectSpaceRevision(projectSpace);
				historyVersionMappingEntry.setEMFStoreRevision(currentProjectSpaceRevision + 1);
			}

			return historyVersionMappingEntry;

		} catch (TeamSynchronizerException e) {
			throw new CommitCannotCompleteException(e);
		}
	}

	/**
	 * Returns the next expected version mapping.
	 * 
	 * @return The next expected version mapping.
	 */
	public HistoryVersionMappingEntry getExpected() {
		return expectedVersionMapping;
	}

}
