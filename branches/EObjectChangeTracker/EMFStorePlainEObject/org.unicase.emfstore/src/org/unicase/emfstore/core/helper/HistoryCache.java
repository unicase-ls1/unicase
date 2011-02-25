/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.core.helper;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.metamodel.ModelElementId;

/**
 * This cache maps modelelements on verions, where these modelelements where changed. This is needed for the getHistory
 * method. WARNING: Newly created projects will be added to cache as soon as the server is restarted. Fix this.
 * 
 * @author wesendon
 */
public class HistoryCache {

	private HashMap<ProjectId, HashMap<ModelElementId, TreeSet<Version>>> historyCache;

	/**
	 * Default constructor.
	 */
	public HistoryCache() {
		historyCache = new HashMap<ProjectId, HashMap<ModelElementId, TreeSet<Version>>>();
	}

	/**
	 * Initializes the cache.
	 * 
	 * @param projects the projects
	 */
	public void initCache(List<ProjectHistory> projects) {
		for (ProjectHistory project : projects) {
			EList<Version> projectVersions = project.getVersions();
			if (projectVersions.size() > 0) {
				HashMap<ModelElementId, TreeSet<Version>> initialHashMap = buildInitialHashMap(projectVersions.get(0));
				for (Version version : projectVersions) {
					// System.out.println("Checking version: " + version.getPrimarySpec().getIdentifier());
					addChangePackageToCache(initialHashMap, version);
				}
				historyCache.put(project.getProjectId(), initialHashMap);
			}
		}
		// printMap();
	}

	/**
	 * Adds the ME of a version to the cache.
	 * 
	 * @param projectId the projectId
	 * @param version the version
	 */
	public void addVersionToCache(ProjectId projectId, Version version) {
		HashMap<ModelElementId, TreeSet<Version>> hashMap = historyCache.get(projectId);
		if (hashMap != null & version != null) {
			addChangePackageToCache(hashMap, version);
		}
	}

	private void addChangePackageToCache(HashMap<ModelElementId, TreeSet<Version>> hashMap, Version version) {
		ChangePackage changes = version.getChanges();
		if (changes != null) {
			EList<AbstractOperation> operations = changes.getOperations();
			extractOperations(hashMap, version, operations);
		}
	}

	private void extractOperations(HashMap<ModelElementId, TreeSet<Version>> hashMap, Version version,
		EList<AbstractOperation> operations) {
		for (AbstractOperation abstractOperation : operations) {
			for (ModelElementId elementId : abstractOperation.getAllInvolvedModelElements()) {
				addModelElement(hashMap, version, elementId);
			}
		}
	}

	private void addModelElement(HashMap<ModelElementId, TreeSet<Version>> hashMap, Version version, ModelElementId id) {
		// System.out.println(id.getId() + " ---> " + version.getPrimarySpec().getIdentifier());
		TreeSet<Version> set = hashMap.get(id);
		if (set == null) {
			set = getTreeSet();
			hashMap.put(id, set);
		}
		set.add(version);
	}

	private HashMap<ModelElementId, TreeSet<Version>> buildInitialHashMap(Version version) {
		EList<EObject> allModelElements = version.getProjectState().getAllModelElements();
		HashMap<ModelElementId, TreeSet<Version>> hashMap = new HashMap<ModelElementId, TreeSet<Version>>(
			(int) (allModelElements.size() * 1.15) + 1);
		for (EObject element : allModelElements) {
			hashMap.put(version.getProjectState().getModelElementId(element), initVersionSet(version));
		}
		return hashMap;
	}

	private TreeSet<Version> initVersionSet(Version version) {
		TreeSet<Version> versionList = getTreeSet();
		versionList.add(version);
		return versionList;
	}

	/**
	 * Returns versions where the specified ME was touched in the specified project.
	 * 
	 * @param projectId project id
	 * @param modelElementId modelelement id
	 * @return set of versions
	 */
	public TreeSet<Version> getChangesForModelElement(ProjectId projectId, ModelElementId modelElementId) {
		HashMap<ModelElementId, TreeSet<Version>> map = historyCache.get(projectId);
		if (map == null) {
			return getTreeSet();
		}
		TreeSet<Version> hashSet = map.get(modelElementId);
		if (hashSet == null) {
			return getTreeSet();
		}
		return hashSet;
	}

	private TreeSet<Version> getTreeSet() {
		return new TreeSet<Version>(new Comparator<Version>() {
			public int compare(Version o1, Version o2) {
				if (o1.getPrimarySpec().getIdentifier() == o2.getPrimarySpec().getIdentifier()) {
					return 0;
				}
				if (o1.getPrimarySpec().getIdentifier() < o2.getPrimarySpec().getIdentifier()) {
					return 1;
				} else {
					return -1;
				}
			}

		});
	}

	/**
	 * Debug method.
	 */
	public void printMap() {
		for (ProjectId projectId : historyCache.keySet()) {
			System.out.println("PROJECT: " + projectId.getId());
			HashMap<ModelElementId, TreeSet<Version>> map = historyCache.get(projectId);
			for (ModelElementId meId : map.keySet()) {
				System.out.print("\tME: " + meId.getId() + " ");
				for (Version version : map.get(meId)) {
					System.out.print(version.getPrimarySpec().getIdentifier() + ", ");
				}
				System.out.println("");
			}
		}
	}
}
