package org.unicase.emfstore.jdt.emf.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.unicase.metamodel.IdProvider;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.SingletonIdResolver;
import org.unicase.metamodel.impl.ProjectImpl;
import org.unicase.metamodel.util.ModelUtil;

public class JDTIdProvider implements IdProvider {

	private Set<SingletonIdResolver> singletonIdResolvers;

	private Set<EObject> eObjectsCache;
	private Map<EObject, ModelElementId> eObjectToIdCache;
	private Map<EObject, ModelElementId> deletedEObjectToIdMap;
	private Map<EObject, ModelElementId> newEObjectToIdMap;
	private Map<ModelElementId, EObject> idToEObjectCache;
	private boolean cachesInitialized;

	/**
	 * Will be used to cache all model elements of a project in order to avoid fetching those multiple times when trying
	 * to retrieve a model element ID.
	 * 
	 * @see ProjectImpl#getModelElementId(EObject)
	 */
	private Set<EObject> containedModelElements;

	private final EObject workbench;

	public JDTIdProvider(EObject workbench) {
		this.workbench = workbench;

		eObjectsCache = new HashSet<EObject>();
		eObjectToIdCache = new HashMap<EObject, ModelElementId>();
		deletedEObjectToIdMap = new HashMap<EObject, ModelElementId>();
		newEObjectToIdMap = new HashMap<EObject, ModelElementId>();
		idToEObjectCache = new HashMap<ModelElementId, EObject>();

		// collect singleton ID resolvers
		singletonIdResolvers = new HashSet<SingletonIdResolver>();
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.metamodel.singletonidresolver");
		for (IConfigurationElement extension : config) {
			SingletonIdResolver resolver;
			try {
				resolver = (SingletonIdResolver) extension.createExecutableExtension("class");
				singletonIdResolvers.add(resolver);
			} catch (CoreException e) {
				ModelUtil.logWarning("Couldn't instantiate Singleton ID resolver:" + e.getMessage());
			}
		}

		// original implementation does't it do it that way
		initCaches();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 * @see org.unicase.metamodel.Project#contains(org.unicase.model.ModelElement)
	 */
	public boolean contains(ModelElementId id) {
		if (!isCacheInitialized()) {
			initCaches();
		}
		return getIdToEObjectCache().containsKey(id);
	}

	private boolean isCacheInitialized() {
		return cachesInitialized;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.Project#initCaches()
	 */
	public void initCaches() {
		if (isCacheInitialized()) {
			return;
		}

		for (EObject modelElement : workbench.eContents()) {
			// put model element into cache
			ModelElementId modelElementId = getModelElementId(modelElement);
			putIntoCaches(modelElement, modelElementId);

			// put children of model element into cache
			TreeIterator<EObject> it = modelElement.eAllContents();
			while (it.hasNext()) {
				EObject obj = it.next();
				ModelElementId id = getModelElementId(obj);
				putIntoCaches(obj, id);
				// TODO:PlainEObjectMode, these 2 lines are needed for migration, currently the IDs is thus setted
				// twice
				// when adding a new model element
			}
		}

		cachesInitialized = true;
	}

	private void putIntoCaches(EObject modelElement, ModelElementId modelElementId) {
		eObjectToIdCache.put(modelElement, modelElementId);
		idToEObjectCache.put(modelElementId, modelElement);
		// TODO: PlainEObjectMode, why is cache filled automatically?
		if (!eObjectsCache.contains(modelElement)) {
			eObjectsCache.add(modelElement);
		}
	}

	private Map<ModelElementId, EObject> getIdToEObjectCache() {
		if (!isCacheInitialized()) {
			initCaches();
		}

		return idToEObjectCache;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.Project#getAllModelElementIds()
	 */
	public Set<ModelElementId> getAllModelElementIds() {
		if (!isCacheInitialized()) {
			initCaches();
		}

		return idToEObjectCache.keySet();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.Project#getModelElementId(org.eclipse.emf.ecore.EObject)
	 */
	public ModelElementId getModelElementId(EObject eObject) {

		if (!eObjectToIdCache.containsKey(eObject) && !isCacheInitialized()) {

			if (containedModelElements == null) {
				containedModelElements = ModelUtil.getAllContainedModelElements(workbench, false);
			}

			if (!containedModelElements.contains(eObject)) {
				return null;
			}

			// EObject contained in project, load ID from resource
			try {
				Resource resource = eObject.eResource();

				// EM: is this a potential error case we have to consider?
				if (!(resource instanceof XMIResource)) {
					return null;
				}

				XMIResource xmiResource = (XMIResource) resource;
				xmiResource.load(null);
				// TODO: Das ist so falsch
				xmiResource.getEObjectToIDMap();
				ModelElementId modelElementId = MetamodelFactory.eINSTANCE.createModelElementId();

				String id = xmiResource.getID(eObject);
				if (id != null) {
					// change ID
					modelElementId.setId(id);
					eObjectToIdCache.put(eObject, modelElementId);
					return ModelUtil.clone(modelElementId);
				} else {
					xmiResource.setID(eObject, id);
				}

				// return new ID
				eObjectToIdCache.put(eObject, modelElementId);
				return ModelUtil.clone(modelElementId);

			} catch (IOException e) {
				throw new RuntimeException("Couldn't load resource for model element " + eObject);
			}
		}

		ModelElementId id = eObjectToIdCache.get(eObject);

		if (id != null) {
			return ModelUtil.clone(id);
		}

		for (SingletonIdResolver resolver : singletonIdResolvers) {
			ModelElementId singletonId = resolver.getSingletonModelElementId(eObject);
			if (singletonId != null) {
				return ModelUtil.clone(singletonId);
			}
		}

		return null;
	}

	public ModelElementId getDeletedModelElementId(EObject deletedModelElement) {
		ModelElementId id = deletedEObjectToIdMap.get(deletedModelElement);

		if (id != null) {
			return ModelUtil.clone(id);
		}

		for (SingletonIdResolver resolver : singletonIdResolvers) {
			id = resolver.getSingletonModelElementId(deletedModelElement);
			if (id != null) {
				return ModelUtil.clone(id);
			}
		}

		return null;
	}

	public void addModelElementAndChildrenToCache(EObject eObject) {
		List<ModelElementId> removableIds = new ArrayList<ModelElementId>();

		// first check whether ID should be reassigned
		ModelElementId id = newEObjectToIdMap.get(eObject);

		if (id == null) {
			// if not, create a new ID
			id = MetamodelFactory.eINSTANCE.createModelElementId();
		} else {
			removableIds.add(id);
		}

		if (isCacheInitialized()) {
			putIntoCaches(eObject, id);
		}

		for (EObject child : ModelUtil.getAllContainedModelElements(eObject, false)) {
			// first check whether ID should be reassigned
			ModelElementId childId = newEObjectToIdMap.get(child);

			if (childId == null) {
				// if not, create a new ID
				childId = MetamodelFactory.eINSTANCE.createModelElementId();
			} else {
				removableIds.add(childId);
			}

			if (isCacheInitialized()) {
				putIntoCaches(child, childId);
			}
		}

		// remove all IDs that are in use now
		newEObjectToIdMap.values().removeAll(removableIds);
	}

}
