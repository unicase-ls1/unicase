package org.unicase.emfstore;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;

/**
 * This cache maps modelelements on verions, where these modelelements where changed. This is needed for the getHistory
 * method. WARNING: Newly created projects will be added to cache as soon as the server is restarted. Fix this.
 * 
 * @author wesendon
 */
public class HistoryCache {

	private HashMap<ProjectId, HashMap<ModelElementId, HashSet<Version>>> historyCache;

	/**
	 * Default constructor.
	 */
	public HistoryCache() {
		historyCache = new HashMap<ProjectId, HashMap<ModelElementId, HashSet<Version>>>();
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
				HashMap<ModelElementId, HashSet<Version>> initialHashMap = buildInitialHashMap(projectVersions.get(0));
				for (Version version : projectVersions) {
					// System.out.println("Checking version: " + version.getPrimarySpec().getIdentifier());
					addChangePackageToCache(initialHashMap, version);
				}
				historyCache.put(project.getProjectId(), initialHashMap);
			}
		}
		printMap();
	}

	/**
	 * Adds the ME of a version to the cache.
	 * 
	 * @param projectId the projectId
	 * @param version the version
	 */
	public void addVersionToCache(ProjectId projectId, Version version) {
		HashMap<ModelElementId, HashSet<Version>> hashMap = historyCache.get(projectId);
		if (hashMap != null & version != null) {
			addChangePackageToCache(hashMap, version);
		}
	}

	private void addChangePackageToCache(HashMap<ModelElementId, HashSet<Version>> hashMap, Version version) {
		ChangePackage changes = version.getChanges();
		if (changes != null) {
			EList<AbstractOperation> operations = changes.getOperations();
			extractOperations(hashMap, version, operations);
		}
	}

	private void extractOperations(HashMap<ModelElementId, HashSet<Version>> hashMap, Version version,
		EList<AbstractOperation> operations) {
		for (AbstractOperation abstractOperation : operations) {
			if (abstractOperation instanceof CreateDeleteOperation) {
				ModelElement modelElement = ((CreateDeleteOperation) abstractOperation).getModelElement();
				addModelElement(hashMap, version, modelElement.getModelElementId());
			} else if (abstractOperation instanceof AttributeOperation) {
				addModelElement(hashMap, version, abstractOperation.getModelElementId());

			} else if (abstractOperation instanceof SingleReferenceOperation) {
				SingleReferenceOperation singleReferenceOperation = (SingleReferenceOperation) abstractOperation;
				ModelElementId newValue = singleReferenceOperation.getNewValue();
				ModelElementId oldValue = singleReferenceOperation.getOldValue();
				if (newValue != null) {
					addModelElement(hashMap, version, newValue);
				}
				if (oldValue != null) {
					addModelElement(hashMap, version, oldValue);
				}
			} else if (abstractOperation instanceof MultiReferenceOperation) {
				MultiReferenceOperation multiReferenceOperation = (MultiReferenceOperation) abstractOperation;
				addModelElement(hashMap, version, multiReferenceOperation.getModelElementId());
				for (ModelElementId elementId : multiReferenceOperation.getReferencedModelElements()) {
					addModelElement(hashMap, version, elementId);
				}
			} else if (abstractOperation instanceof MultiReferenceMoveOperation) {
				MultiReferenceMoveOperation multiReferenceMoveOperation = (MultiReferenceMoveOperation) abstractOperation;
				addModelElement(hashMap, version, multiReferenceMoveOperation.getModelElementId());
				addModelElement(hashMap, version, multiReferenceMoveOperation.getReferencedModelElementId());
			} else if (abstractOperation instanceof CompositeOperation) {
				extractOperations(hashMap, version, ((CompositeOperation) abstractOperation).getSubOperations());
			}
		}
	}

	private void addModelElement(HashMap<ModelElementId, HashSet<Version>> hashMap, Version version, ModelElementId id) {
		// System.out.println(id.getId() + " ---> " + version.getPrimarySpec().getIdentifier());
		HashSet<Version> set = hashMap.get(id);
		if (set == null) {
			set = new HashSet<Version>();
			hashMap.put(id, set);
		}
		set.add(version);
	}

	private HashMap<ModelElementId, HashSet<Version>> buildInitialHashMap(Version version) {
		EList<ModelElement> allModelElements = version.getProjectState().getAllModelElements();
		HashMap<ModelElementId, HashSet<Version>> hashMap = new HashMap<ModelElementId, HashSet<Version>>(
			(int) (allModelElements.size() * 1.15) + 1);
		for (ModelElement element : allModelElements) {
			hashMap.put(element.getModelElementId(), initVersionSet(version));
		}
		return hashMap;
	}

	private HashSet<Version> initVersionSet(Version version) {
		HashSet<Version> versionList = new HashSet<Version>();
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
	public HashSet<Version> getChangesForModelElement(ProjectId projectId, ModelElementId modelElementId) {
		HashMap<ModelElementId, HashSet<Version>> map = historyCache.get(projectId);
		if (map == null) {
			return new HashSet<Version>();
		}
		HashSet<Version> hashSet = map.get(modelElementId);
		if (hashSet == null) {
			return new HashSet<Version>();
		}
		return hashSet;
	}

	/**
	 * Debug method.
	 */
	public void printMap() {
		for (ProjectId projectId : historyCache.keySet()) {
			System.out.println("PROJECT: " + projectId.getId());
			HashMap<ModelElementId, HashSet<Version>> map = historyCache.get(projectId);
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
