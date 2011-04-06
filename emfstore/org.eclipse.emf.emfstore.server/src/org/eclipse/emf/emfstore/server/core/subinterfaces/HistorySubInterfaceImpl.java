/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.core.subinterfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.server.EmfStoreController;
import org.eclipse.emf.emfstore.server.core.AbstractEmfstoreInterface;
import org.eclipse.emf.emfstore.server.core.AbstractSubEmfstoreInterface;
import org.eclipse.emf.emfstore.server.core.helper.HistoryCache;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.FatalEmfStoreException;
import org.eclipse.emf.emfstore.server.exceptions.InvalidInputException;
import org.eclipse.emf.emfstore.server.exceptions.StorageException;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery;
import org.eclipse.emf.emfstore.server.model.versioning.LogMessage;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.TagVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.Version;
import org.eclipse.emf.emfstore.server.model.versioning.VersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.VersioningFactory;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;

/**
 * This subinterfaces implements all history related functionality for the EmfStoreImpl interface.
 * 
 * @author wesendon
 */
public class HistorySubInterfaceImpl extends AbstractSubEmfstoreInterface {

	/**
	 * Default constructor.
	 * 
	 * @param parentInterface parent interface
	 * @throws FatalEmfStoreException in case of failure
	 */
	public HistorySubInterfaceImpl(AbstractEmfstoreInterface parentInterface) throws FatalEmfStoreException {
		super(parentInterface);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<HistoryInfo> getHistoryInfo(ProjectId projectId, HistoryQuery historyQuery) throws EmfStoreException {
		synchronized (getMonitor()) {
			// if modelelements are added to the query, only history infos which are related to these modelelements will
			// be returned.
			if (historyQuery.getModelElements().size() > 0) {
				return getHistoryInfo(projectId, historyQuery.getModelElements(), historyQuery.isIncludeChangePackage());
			} else {
				List<HistoryInfo> result = getHistoryInfo(projectId, historyQuery.getSource(),
					historyQuery.getTarget(), historyQuery.isIncludeChangePackage());
				if (historyQuery.getSource().compareTo(historyQuery.getTarget()) < 0) {
					Collections.reverse(result);
				}
				return result;
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void addTag(ProjectId projectId, PrimaryVersionSpec versionSpec, TagVersionSpec tag)
		throws EmfStoreException {
		synchronized (getMonitor()) {
			Version version = getSubInterface(VersionSubInterfaceImpl.class).getVersion(projectId, versionSpec);
			version.getTagSpecs().add(tag);
			try {
				save(version);
			} catch (FatalEmfStoreException e) {
				throw new StorageException(StorageException.NOSAVE);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeTag(ProjectId projectId, PrimaryVersionSpec versionSpec, TagVersionSpec tag)
		throws EmfStoreException {
		synchronized (getMonitor()) {
			Version version = getSubInterface(VersionSubInterfaceImpl.class).getVersion(projectId, versionSpec);
			Iterator<TagVersionSpec> iterator = version.getTagSpecs().iterator();
			while (iterator.hasNext()) {
				if (iterator.next().getName().equals(tag.getName())) {
					iterator.remove();
				}
			}
			try {
				save(version);
			} catch (FatalEmfStoreException e) {
				throw new StorageException(StorageException.NOSAVE);
			}
		}
	}

	private List<HistoryInfo> getHistoryInfo(ProjectId projectId, List<ModelElementId> moList,
		boolean includeChangePackage) throws EmfStoreException {
		HistoryCache historyCache = EmfStoreController.getInstance().getHistoryCache();
		// TODO only the first modelelement is included in the request.
		ModelElementId modelElementId = moList.get(0);
		TreeSet<Version> elements = historyCache.getChangesForModelElement(projectId, modelElementId);
		ArrayList<Version> versions = new ArrayList<Version>(elements);
		if (versions.size() == 0) {
			return new ArrayList<HistoryInfo>();
		}
		// only the last 20 or less versions are considered
		int historyCount = Math.min(versions.size(), 20);
		List<HistoryInfo> historyInfos = getHistoryInfo(versions.subList(0, historyCount), projectId,
			includeChangePackage);
		// filter operations to selected model element

		for (HistoryInfo historyInfo : historyInfos) {
			filterOperationsForSelectedME(modelElementId, historyInfo);
		}
		return historyInfos;
	}

	private void filterOperationsForSelectedME(ModelElementId modelElementId, HistoryInfo historyInfo) {
		if (historyInfo.getChangePackage() == null || historyInfo.getChangePackage().getOperations() == null) {
			return;
		}
		Set<AbstractOperation> operationsToRemove = new HashSet<AbstractOperation>();
		EList<AbstractOperation> operations = historyInfo.getChangePackage().getOperations();
		for (AbstractOperation operation : operations) {
			if (!operation.getAllInvolvedModelElements().contains(modelElementId)) {
				operationsToRemove.add(operation);
			}
		}
		operations.removeAll(operationsToRemove);
	}

	private List<HistoryInfo> getHistoryInfo(ProjectId projectId, PrimaryVersionSpec source, PrimaryVersionSpec target,
		boolean includeChangePackage) throws EmfStoreException {
		if (source == null || target == null) {
			throw new InvalidInputException();
		}
		return getHistoryInfo(getSubInterface(VersionSubInterfaceImpl.class).getVersions(projectId, source, target),
			projectId, includeChangePackage);
	}

	private List<HistoryInfo> getHistoryInfo(List<Version> versions, ProjectId projectId, boolean includeChangePackage)
		throws EmfStoreException {
		List<HistoryInfo> result = new ArrayList<HistoryInfo>();
		PrimaryVersionSpec headRevision = getSubInterface(ProjectSubInterfaceImpl.class).getProject(projectId)
			.getLastVersion().getPrimarySpec();
		for (Version version : versions) {
			HistoryInfo history = createHistoryInfo(headRevision, version, includeChangePackage);
			result.add(history);
		}
		return result;
	}

	/**
	 * Generates a history info from a version. If needed also adds the HEAD tag, which isn't persistent.
	 * 
	 * @param headRevision head revision
	 * @param version version
	 * @param includeChangePackage
	 * @return history info
	 */
	private HistoryInfo createHistoryInfo(PrimaryVersionSpec headRevision, Version version, boolean includeChangePackage) {
		HistoryInfo history = VersioningFactory.eINSTANCE.createHistoryInfo();
		if (includeChangePackage && version.getChanges() != null) {
			history.setChangePackage((ChangePackage) EcoreUtil.copy(version.getChanges()));
		}
		history.setLogMessage((LogMessage) EcoreUtil.copy(version.getLogMessage()));
		history.setPrimerySpec((PrimaryVersionSpec) EcoreUtil.copy(version.getPrimarySpec()));
		for (TagVersionSpec tagSpec : version.getTagSpecs()) {
			history.getTagSpecs().add((TagVersionSpec) EcoreUtil.copy(tagSpec));
		}
		// add HEAD tag to history info
		if (version.getPrimarySpec().equals(headRevision)) {
			TagVersionSpec spec = VersioningFactory.eINSTANCE.createTagVersionSpec();
			spec.setName(VersionSpec.HEAD);
			history.getTagSpecs().add(spec);
		}
		return history;
	}
}
