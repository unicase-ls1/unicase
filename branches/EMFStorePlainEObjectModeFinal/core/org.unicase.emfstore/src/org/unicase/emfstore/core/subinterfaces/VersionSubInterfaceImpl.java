/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.core.subinterfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.EmfStoreController;
import org.unicase.emfstore.ServerConfiguration;
import org.unicase.emfstore.core.AbstractEmfstoreInterface;
import org.unicase.emfstore.core.AbstractSubEmfstoreInterface;
import org.unicase.emfstore.core.helper.HistoryCache;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.DateVersionSpec;
import org.unicase.emfstore.esmodel.versioning.HeadVersionSpec;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.TagVersionSpec;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.BaseVersionOutdatedException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.exceptions.InvalidVersionSpecException;
import org.unicase.emfstore.exceptions.StorageException;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.impl.ProjectImpl;
import org.unicase.metamodel.util.ModelUtil;

/**
 * This subinterfaces implements all version related functionality for the
 * {@link org.unicase.emfstore.core.EmfStoreImpl} interface.
 * 
 * @author wesendon
 */
public class VersionSubInterfaceImpl extends AbstractSubEmfstoreInterface {

	private HistoryCache historyCache;

	/**
	 * Default constructor.
	 * 
	 * @param parentInterface parent interface
	 * @throws FatalEmfStoreException in case of failure
	 */
	public VersionSubInterfaceImpl(AbstractEmfstoreInterface parentInterface) throws FatalEmfStoreException {
		super(parentInterface);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws FatalEmfStoreException in case of failure
	 * @see org.unicase.emfstore.core.AbstractSubEmfstoreInterface#initSubInterface()
	 */
	@Override
	public void initSubInterface() throws FatalEmfStoreException {
		super.initSubInterface();
		historyCache = EmfStoreController.getInstance().getHistoryCache();
	}

	/**
	 * Resolves a versionSpec and delivers the corresponding primary versionSpec.
	 * 
	 * @param projectId project id
	 * @param versionSpec versionSpec
	 * @return primary versionSpec
	 * @throws EmfStoreException if versionSpec can't be resolved or other failure
	 */
	public PrimaryVersionSpec resolveVersionSpec(ProjectId projectId, VersionSpec versionSpec) throws EmfStoreException {
		synchronized (getMonitor()) {
			ProjectHistory projectHistory = getSubInterface(ProjectSubInterfaceImpl.class).getProject(projectId);
			// PrimaryVersionSpec
			if (versionSpec instanceof PrimaryVersionSpec && 0 <= ((PrimaryVersionSpec) versionSpec).getIdentifier()
				&& ((PrimaryVersionSpec) versionSpec).getIdentifier() < projectHistory.getVersions().size()) {
				return ((PrimaryVersionSpec) versionSpec);
				// HeadVersionSpec
			} else if (versionSpec instanceof HeadVersionSpec) {
				return (PrimaryVersionSpec) EcoreUtil.copy(getSubInterface(ProjectSubInterfaceImpl.class).getProject(
					projectId).getLastVersion().getPrimarySpec());
				// DateVersionSpec
			} else if (versionSpec instanceof DateVersionSpec) {
				for (Version version : projectHistory.getVersions()) {
					LogMessage logMessage = version.getLogMessage();
					if (logMessage == null || logMessage.getDate() == null) {
						continue;
					}
					if (((DateVersionSpec) versionSpec).getDate().before(logMessage.getDate())) {
						Version previousVersion = version.getPreviousVersion();
						if (previousVersion == null) {
							return VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
						}
						return previousVersion.getPrimarySpec();
					}
				}
				return projectHistory.getLastVersion().getPrimarySpec();
				// TagVersionSpec
			} else if (versionSpec instanceof TagVersionSpec) {
				for (Version version : projectHistory.getVersions()) {
					for (TagVersionSpec tag : version.getTagSpecs()) {
						if (((TagVersionSpec) versionSpec).equals(tag)) {
							return (PrimaryVersionSpec) EcoreUtil.copy(version.getPrimarySpec());
						}
					}
				}
				throw new InvalidVersionSpecException();
			} else {
				throw new InvalidVersionSpecException();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public PrimaryVersionSpec createVersion(ProjectId projectId, PrimaryVersionSpec baseVersionSpec,
		ChangePackage changePackage, LogMessage logMessage) throws EmfStoreException {
		synchronized (getMonitor()) {

			long currentTimeMillis = System.currentTimeMillis();

			ProjectHistory projectHistory = getSubInterface(ProjectSubInterfaceImpl.class).getProject(projectId);
			List<Version> versions = projectHistory.getVersions();

			// OW: check here if base version is valid at all

			if (versions.size() - 1 != baseVersionSpec.getIdentifier()) {
				throw new BaseVersionOutdatedException();
			}

			PrimaryVersionSpec newVersionSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
			newVersionSpec.setIdentifier(baseVersionSpec.getIdentifier() + 1);

			Version newVersion = VersioningFactory.eINSTANCE.createVersion();

			Version previousHeadVersion = versions.get(versions.size() - 1);

			// TODO: EM rather use ModelUtil.clone than import of ProjectImpl?
			Project newProjectState = ((ProjectImpl) previousHeadVersion.getProjectState()).copy();
			// Project newProjectState = (Project) EcoreUtil.copy(previousHeadVersion.getProjectState());
			changePackage.apply(newProjectState);

			newVersion.setProjectState(newProjectState);
			newVersion.setChanges(changePackage);
			logMessage.setDate(new Date());
			newVersion.setLogMessage(logMessage);
			newVersion.setPrimarySpec(newVersionSpec);
			newVersion.setNextVersion(null);
			newVersion.setPreviousVersion(previousHeadVersion);

			versions.add(newVersion);

			// try to save
			try {
				try {
					getResourceHelper().createResourceForProject(newProjectState, newVersion.getPrimarySpec(),
						projectHistory.getProjectId());
					getResourceHelper().createResourceForChangePackage(changePackage, newVersion.getPrimarySpec(),
						projectId);
					getResourceHelper().createResourceForVersion(newVersion, projectHistory.getProjectId());
				} catch (FatalEmfStoreException e) {
					// try to roll back
					previousHeadVersion.setNextVersion(null);
					versions.remove(newVersion);
					// OW: why do we need to save here, can we remove? do test!!
					save(previousHeadVersion);
					save(projectHistory);
					throw new StorageException(StorageException.NOSAVE);
				}

				// delete projectstate from last revision depending on persistence
				// policy
				handleOldProjectState(projectId, previousHeadVersion);

				save(previousHeadVersion);
				save(projectHistory);

				// update history cache
				historyCache.addVersionToCache(projectId, newVersion);
			} catch (FatalEmfStoreException e) {
				// roll back failed
				EmfStoreController.getInstance().shutdown(e);
				throw new EmfStoreException("Shutting down server.");
			}

			ModelUtil.logInfo("Total time for commit: " + (System.currentTimeMillis() - currentTimeMillis));
			return newVersionSpec;
		}
	}

	public PrimaryVersionSpec createVersionForProject(ProjectId projectId, PrimaryVersionSpec baseVersionSpec,
		ChangePackage changePackage, LogMessage logMessage) throws EmfStoreException {
		synchronized (getMonitor()) {

			long currentTimeMillis = System.currentTimeMillis();

			ProjectHistory projectHistory = getSubInterface(ProjectSubInterfaceImpl.class).getProject(projectId);
			List<Version> versions = projectHistory.getVersions();

			// OW: check here if base version is valid at all

			if (versions.size() - 1 != baseVersionSpec.getIdentifier()) {
				throw new BaseVersionOutdatedException();
			}

			PrimaryVersionSpec newVersionSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
			newVersionSpec.setIdentifier(baseVersionSpec.getIdentifier() + 1);

			Version newVersion = VersioningFactory.eINSTANCE.createVersion();

			Version previousHeadVersion = versions.get(versions.size() - 1);

			// TODO: EM rather use ModelUtil.clone than import of ProjectImpl?
			Project newProjectState = ((ProjectImpl) previousHeadVersion.getProjectState()).copy(); // EcoreUtil.copy(previousHeadVersion.getProjectState());

			changePackage.apply(newProjectState);

			newVersion.setProjectState(newProjectState);
			newVersion.setChanges(changePackage);
			logMessage.setDate(new Date());
			newVersion.setLogMessage(logMessage);
			newVersion.setPrimarySpec(newVersionSpec);
			newVersion.setNextVersion(null);
			newVersion.setPreviousVersion(previousHeadVersion);

			versions.add(newVersion);

			// try to save
			try {
				try {
					getResourceHelper().createResourceForProject(newProjectState, newVersion.getPrimarySpec(),
						projectHistory.getProjectId());
					getResourceHelper().createResourceForChangePackage(changePackage, newVersion.getPrimarySpec(),
						projectId);
					getResourceHelper().createResourceForVersion(newVersion, projectHistory.getProjectId());
				} catch (FatalEmfStoreException e) {
					// try to roll back
					previousHeadVersion.setNextVersion(null);
					versions.remove(newVersion);
					// OW: why do we need to save here, can we remove? do test!!
					save(previousHeadVersion);
					save(projectHistory);
					throw new StorageException(StorageException.NOSAVE);
				}

				// delete projectstate from last revision depending on persistence
				// policy
				handleOldProjectState(projectId, previousHeadVersion);

				save(previousHeadVersion);
				save(projectHistory);

				// update history cache
				historyCache.addVersionToCache(projectId, newVersion);
			} catch (FatalEmfStoreException e) {
				// roll back failed
				EmfStoreController.getInstance().shutdown(e);
				throw new EmfStoreException("Shutting down server.");
			}

			ModelUtil.logInfo("Total time for commit: " + (System.currentTimeMillis() - currentTimeMillis));
			return newVersionSpec;
		}
	}

	/**
	 * Deletes projectstate from last revision depending on persistence policy.
	 * 
	 * @param projectId project id
	 * @param previousHeadVersion last head version
	 */
	private void handleOldProjectState(ProjectId projectId, Version previousHeadVersion) {
		String property = ServerConfiguration.getProperties().getProperty(
			ServerConfiguration.PROJECTSTATE_VERSION_PERSISTENCE,
			ServerConfiguration.PROJECTSPACE_VERSION_PERSISTENCE_DEFAULT);

		if (property.equals(ServerConfiguration.PROJECTSTATE_VERSION_PERSISTENCE_EVERYXVERSIONS)) {

			int x = getResourceHelper().getXFromPolicy(
				ServerConfiguration.PROJECTSTATE_VERSION_PERSISTENCE_EVERYXVERSIONS_X,
				ServerConfiguration.PROJECTSTATE_VERSION_PERSISTENCE_EVERYXVERSIONS_X_DEFAULT, false);

			// always save projecstate of first version
			int lastVersion = previousHeadVersion.getPrimarySpec().getIdentifier();
			if (lastVersion != 0 && lastVersion % x != 0) {
				previousHeadVersion.setProjectState(null);
				getResourceHelper().deleteProjectState(projectId, previousHeadVersion.getPrimarySpec().getIdentifier());
			}

		} else {
			previousHeadVersion.setProjectState(null);
			getResourceHelper().deleteProjectState(projectId, previousHeadVersion.getPrimarySpec().getIdentifier());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ChangePackage> getChanges(ProjectId projectId, VersionSpec source, VersionSpec target)
		throws EmfStoreException {
		synchronized (getMonitor()) {
			PrimaryVersionSpec resolvedSource = resolveVersionSpec(projectId, source);
			PrimaryVersionSpec resolvedTarget = resolveVersionSpec(projectId, target);

			// if target and source are equal return empty list
			if (resolvedSource.getIdentifier() == resolvedTarget.getIdentifier()) {
				return new ArrayList<ChangePackage>();
			}

			// Example: if you want the changes to get from version 5 to 7, you need the changes contained in version 6
			// and 7. The reason is that each version holds the changes which occurred from the predecessor to the
			// version itself. Version 5 holds the changes to get from version 4 to 5 and therefore is irrelevant.
			// So the lower bound (source and target can be inverse too) has to be counted up by one.
			if (resolvedSource.getIdentifier() < resolvedTarget.getIdentifier()) {
				resolvedSource.setIdentifier(resolvedSource.getIdentifier() + 1);
			} else {
				resolvedTarget.setIdentifier(resolvedTarget.getIdentifier() + 1);
			}

			List<ChangePackage> result = new ArrayList<ChangePackage>();
			for (Version version : getVersions(projectId, resolvedSource, resolvedTarget)) {
				ChangePackage changes = version.getChanges();
				changes.setLogMessage((LogMessage) EcoreUtil.copy(version.getLogMessage()));
				result.add(changes);
			}

			// if source is after target in time
			if (resolvedSource.compareTo(resolvedTarget) > 0) {
				// reverse list and change packages
				Collections.reverse(result);
			}

			return result;
		}
	}

	/**
	 * Returns the specified version of a project.
	 * 
	 * @param projectId project id
	 * @param versionSpec versionSpec
	 * @return the version
	 * @throws EmfStoreException if version couldn't be found
	 */
	protected Version getVersion(ProjectId projectId, PrimaryVersionSpec versionSpec) throws EmfStoreException {
		EList<Version> versions = getSubInterface(ProjectSubInterfaceImpl.class).getProject(projectId).getVersions();
		if (versionSpec.getIdentifier() < 0 || versionSpec.getIdentifier() > versions.size() - 1) {
			throw new InvalidVersionSpecException();
		}
		return versions.get(versionSpec.getIdentifier());
	}

	/**
	 * Returns a list of versions starting from source and ending with target. This method returns the version always in
	 * an ascanding order. So if you need it ordered differently you have to reverse the list.
	 * 
	 * @param projectId project id
	 * @param source source
	 * @param target target
	 * @return list of versions
	 * @throws EmfStoreException if source or target are out of range or any other problem occurs
	 */
	protected List<Version> getVersions(ProjectId projectId, PrimaryVersionSpec source, PrimaryVersionSpec target)
		throws EmfStoreException {
		if (source.compareTo(target) < 1) {
			EList<Version> versions = getSubInterface(ProjectSubInterfaceImpl.class).getProject(projectId)
				.getVersions();
			if (source.getIdentifier() < 0 || source.getIdentifier() > versions.size() - 1
				|| target.getIdentifier() < 0 || target.getIdentifier() > versions.size() - 1) {
				throw new InvalidVersionSpecException();
			}
			List<Version> result = new ArrayList<Version>();
			Iterator<Version> iter = versions.listIterator(source.getIdentifier());
			int steps = target.getIdentifier() - source.getIdentifier();
			while (iter.hasNext() && steps-- >= 0) {
				result.add(iter.next());
			}
			return result;
		} else {
			return getVersions(projectId, target, source);
		}
	}
}
