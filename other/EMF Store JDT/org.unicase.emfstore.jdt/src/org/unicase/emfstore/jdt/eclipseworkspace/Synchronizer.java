/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.eclipseworkspace;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.jdt.ITeamSynchronizer;
import org.unicase.emfstore.jdt.configuration.ConfigurationManager;
import org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration;
import org.unicase.emfstore.jdt.configuration.Entry;
import org.unicase.emfstore.jdt.configuration.HistoryVersionMapping;
import org.unicase.emfstore.jdt.configuration.HistoryVersionMappingEntry;
import org.unicase.emfstore.jdt.configuration.SimpleVersionMapping;
import org.unicase.emfstore.jdt.configuration.VersionMapping;
import org.unicase.emfstore.jdt.eclipseworkspace.emfstore.EMFStoreUtil;
import org.unicase.emfstore.jdt.eclipseworkspace.emfstore.ProjectSpaceUtil;
import org.unicase.emfstore.jdt.exception.CannotSyncFileException;
import org.unicase.emfstore.jdt.exception.EObjectNotFoundException;
import org.unicase.emfstore.jdt.exception.EntryNotFoundException;
import org.unicase.emfstore.jdt.exception.NoEMFStoreJDTConfigurationException;
import org.unicase.emfstore.jdt.exception.ProjectInfoNotFoundException;
import org.unicase.emfstore.jdt.exception.ProjectSpaceNotFoundException;
import org.unicase.emfstore.jdt.exception.TeamSynchronizerException;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;

/**
 * Synchronizer will take care that the file in the eclipse workspace will have the same state as the EObject in the EMF
 * Store.
 * 
 * @author Adrian Staudt
 */
public final class Synchronizer {

	private Synchronizer() {
	}

	/**
	 * Synchronizes a whole eclipse workspace project.
	 * 
	 * @param project An eclipse workspace project.
	 * @param teamSynchronizer A team synchronizer.
	 * @throws CannotSyncFileException Will be thrown if the synchronization fails.
	 */
	public static void sync(IProject project, ITeamSynchronizer teamSynchronizer) throws CannotSyncFileException {
		try {
			EMFStoreJDTConfiguration emfStoreJDTConfiguration = ConfigurationManager.getConfiguration(project);
			EList<Entry> entryList = emfStoreJDTConfiguration.getEntry();
			for (Entry entry : entryList) {
				IFile file = project.getFile(entry.getProjectRelativeLocation());
				sync(file, teamSynchronizer);
			}

		} catch (NoEMFStoreJDTConfigurationException e) {
			// can be ignored
		}

	}

	/**
	 * Synchronizes an eclipse workspace file.
	 * 
	 * @param file An eclipse workspace project.
	 * @param teamSynchronizer A team synchronizer.
	 * @throws CannotSyncFileException Will be thrown if the synchronization fails.
	 */
	public static void sync(final IFile file, final ITeamSynchronizer teamSynchronizer) throws CannotSyncFileException {
		sync(file, teamSynchronizer, false);
	}

	/**
	 * Synchronizes an eclipse workspace file but can also handle pure team provider changes.
	 * 
	 * @param file An eclipse workspace project.
	 * @param teamSynchronizer A team synchronizer.
	 * @param handlePureTeamProviderChanges True if pure team provider changes should be managed, or false otherwise.
	 * @throws CannotSyncFileException Will be thrown if the synchronization fails.
	 */
	public static void sync(final IFile file, final ITeamSynchronizer teamSynchronizer,
		boolean handlePureTeamProviderChanges) throws CannotSyncFileException {
		IProject project = file.getProject();
		try {
			// sync without shared files
			boolean isShared = teamSynchronizer.isFileShared(file);
			if (!isShared) {
				// file is not shared yet
				return;
			}

			// check if update of EMFStoreConfiguration file is needed
			IFile emfStoreConfFile = file.getProject().getFile(ConfigurationManager.EMFSTORECONF);
			if (emfStoreConfFile.exists()) {
				boolean emfStoreConfEnoughUpToDate = isEMFStoreConfEnoughUpToDate(teamSynchronizer, emfStoreConfFile,
					file);
				if (!emfStoreConfEnoughUpToDate) {
					updateEMFStoreConf(teamSynchronizer, emfStoreConfFile);
				}
			}

			EMFStoreJDTConfiguration emfStoreJDTConfiguration = ConfigurationManager.getConfiguration(project);
			Entry entry = ConfigurationManager.getEntry(emfStoreJDTConfiguration, file);
			StructuredEMFStoreURI structuredEMFStoreURI = ConfigurationManager.getEMFStoreURI(entry);

			Integer emfStoreRevision = null;
			VersionMapping versionMapping = entry.getVersionMapping();
			if (versionMapping instanceof SimpleVersionMapping) {
				SimpleVersionMapping simpleVersionMapping = (SimpleVersionMapping) versionMapping;
				emfStoreRevision = simpleVersionMapping.getEMFStoreRevision();

			} else if (versionMapping instanceof HistoryVersionMapping) {
				HistoryVersionMapping historyVersionMapping = (HistoryVersionMapping) versionMapping;
				String workingCopyTeamRevision = teamSynchronizer.getWorkingCopyRevision(file);
				HistoryVersionMappingEntry versionMapping4TeamRevision = historyVersionMapping
					.getVersionMapping4TeamRevision(workingCopyTeamRevision);
				if (versionMapping4TeamRevision == null) {
					HistoryVersionMappingEntry lowestTeamVersionMapping = historyVersionMapping
						.getLowestTeamVersionMapping(teamSynchronizer);
					if (lowestTeamVersionMapping == null) {
						// file has been pushed right now.
						throw new CannotSyncFileException(true);

					} else if (teamSynchronizer.compare(workingCopyTeamRevision, lowestTeamVersionMapping
						.getTeamProviderRevision()) == 1) {
						// the current file revision is smaller than the lowest from the VersionMapping history.
						throw new CannotSyncFileException(true);

					} else {
						if (handlePureTeamProviderChanges) {
							teamSynchronizer.handlePureTeamProviderChange(file);
							emfStoreRevision = historyVersionMapping.getVersionMapping4TeamRevisionBestMatch(
								teamSynchronizer, workingCopyTeamRevision).getEMFStoreRevision();

						} else {
							throw new CannotSyncFileException(true);
						}
					}
				}
			}

			ProjectInfo projectInfo = structuredEMFStoreURI.getProjectInfo();
			ServerInfo serverInfo = EMFStoreUtil.getServerInfo(structuredEMFStoreURI);
			Usersession usersession = serverInfo.getLastUsersession();

			updateEObject(structuredEMFStoreURI, emfStoreRevision, projectInfo, serverInfo, usersession);

		} catch (NoEMFStoreJDTConfigurationException e) {
			// can be ignored

		} catch (EntryNotFoundException e) {
			// can be ignored

		} catch (TeamSynchronizerException e) {
			ModelUtil.logException(e);
		}
	}

	private static void updateEObject(StructuredEMFStoreURI structuredEMFStoreURI, Integer emfStoreRevision,
		ProjectInfo projectInfo, ServerInfo serverInfo, Usersession usersession) throws CannotSyncFileException {
		try {
			if (emfStoreRevision != null) {
				ProjectSpace projectSpace = ProjectSpaceUtil.getProjectSpace(structuredEMFStoreURI.getProjectID());
				int currentProjectSpaceRevision = EMFStoreUtil.getLocalProjectSpaceRevision(projectSpace);
				if (emfStoreRevision != currentProjectSpaceRevision) {
					// update to required emfStoreRevision
					EMFStoreUtil.checkSanity(usersession);
					EMFStoreUtil.update(projectSpace, emfStoreRevision);
				}
			}

			ProjectSpaceUtil.getEObject(structuredEMFStoreURI);
			// if this point is reached, everything is fine
			return;

		} catch (ProjectSpaceNotFoundException e) {
			// project is not locally available, it must be checked out first
			try {
				EMFStoreUtil.checkSanity(usersession);
				EMFStoreUtil.checkout(serverInfo.getLastUsersession(), projectInfo, emfStoreRevision);
				// try now to open the EObject
				try {
					ProjectSpaceUtil.getEObject(structuredEMFStoreURI);
					// if this point is reached, everything is fine, now
					return;

				} catch (EObjectNotFoundException e1) {
					// eobject is not stored in project - push the local one to the project space
					// remove from JDTConfiguration
					throw new CannotSyncFileException();

				} catch (ProjectSpaceNotFoundException e1) {
					// a problem occurred that can not be solved
					throw new CannotSyncFileException();
				}

			} catch (ProjectInfoNotFoundException e1) {
				// project hasn't been found. Maybe set state to unpushed?
				throw new CannotSyncFileException();
			}

		} catch (EObjectNotFoundException e) {
			// EObject is not stored in project - push the local one to the project space
			// remove from JDTConfiguration
			throw new CannotSyncFileException();
		}
	}

	private static void updateEMFStoreConf(ITeamSynchronizer teamSynchronizer, IFile emfStoreConfFile) {
		teamSynchronizer.updateFile(emfStoreConfFile);
	}

	private static boolean isEMFStoreConfEnoughUpToDate(ITeamSynchronizer teamSynchronizer, IFile emfStoreConfFile,
		IFile file) {

		try {
			String fileWorkingCopyRevision = teamSynchronizer.getWorkingCopyRevision(file);
			String fileWorkingCopyEMFStoreConfRevision = teamSynchronizer.getWorkingCopyRevision(emfStoreConfFile);
			if (fileWorkingCopyEMFStoreConfRevision == null) {
				// an update is not possible, so assume emfstoreconf is update to date enough
				return true;
			}

			if (teamSynchronizer.compare(fileWorkingCopyRevision, fileWorkingCopyEMFStoreConfRevision) == -1) {
				return false;
			}
			return true;

		} catch (TeamSynchronizerException e) {
			ModelUtil.logException(e);
			return false;
		}
	}

}
