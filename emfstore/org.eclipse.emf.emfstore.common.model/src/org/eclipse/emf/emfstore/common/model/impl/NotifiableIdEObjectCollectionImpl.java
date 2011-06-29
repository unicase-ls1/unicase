package org.eclipse.emf.emfstore.common.model.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.emfstore.common.model.IdEObjectCollection;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.ModelFactory;
import org.eclipse.emf.emfstore.common.model.NotifiableIdEObjectCollection;
import org.eclipse.emf.emfstore.common.model.util.EObjectChangeNotifier;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.common.model.util.ProjectChangeObserver;

/**
 * @author koegel
 * @author naughton
 * @author emueller
 */
public class NotifiableIdEObjectCollectionImpl extends EObjectImpl implements
		NotifiableIdEObjectCollection {

	// observer related attributes
	private boolean isNotifiying;
	private List<ProjectChangeObserver> observers;
	private Set<ProjectChangeObserver> exceptionThrowingObservers;
	private Set<ProjectChangeObserver> observersToRemove;
	private Set<ProjectChangeObserver> undetachableObservers;

	protected EList<EObject> modelElements;

	// Caches
	protected EMap<ModelElementId, EObject> modelElementIdToEObjectsCache;
	private Set<EObject> eObjectsCache;
	private Map<EObject, ModelElementId> eObjectToIdCache;
	private Map<ModelElementId, EObject> idToEObjectCache;
	private boolean cachesInitialized;

	private Map<EObject, ModelElementId> deletedEObjectToIdMap;
	private Map<EObject, ModelElementId> newEObjectToIdMap;

	/**
	 * Will be used to cache all model elements of a project in order to avoid
	 * fetching those multiple times when trying to retrieve a model element ID.
	 * 
	 * @see NotifiableIdEObjectCollectionImpl#getModelElementId(EObject)
	 */
	private Set<EObject> containedModelElements;

	private EObjectChangeNotifier changeNotifier;
	private XMIResource xmiResource;

	protected NotifiableIdEObjectCollectionImpl() {
		super();
		modelElements = new BasicEList<EObject>();
		eObjectToIdCache = new HashMap<EObject, ModelElementId>();
		deletedEObjectToIdMap = new HashMap<EObject, ModelElementId>();
		newEObjectToIdMap = new HashMap<EObject, ModelElementId>();
		eObjectsCache = new HashSet<EObject>();
		idToEObjectCache = new HashMap<ModelElementId, EObject>();
		observers = new ArrayList<ProjectChangeObserver>();
		observersToRemove = new HashSet<ProjectChangeObserver>();
		exceptionThrowingObservers = new HashSet<ProjectChangeObserver>();
		undetachableObservers = new HashSet<ProjectChangeObserver>();
	}

	public NotifiableIdEObjectCollectionImpl(XMIResource xmiResource) {
		this();
		this.xmiResource = xmiResource;
		try {
			xmiResource.load(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// Do NOT catch all Exceptions ("catch (Exception e)")
			// Log AND handle Exceptions if possible
			//
			// You can just uncomment one of the lines below to log an
			// exception:
			// logException will show the logged excpetion to the user
			// ModelUtil.logException(e);
			// ModelUtil.logException("YOUR MESSAGE HERE", e);
			// logWarning will only add the message to the error log
			// ModelUtil.logWarning("YOUR MESSAGE HERE", e);
			// ModelUtil.logWarning("YOUR MESSAGE HERE");
			//
			// If handling is not possible declare and rethrow Exception
		}
		changeNotifier = new EObjectChangeNotifier(this, xmiResource);
		TreeIterator<EObject> it = xmiResource.getAllContents();
		while (it.hasNext()) {
			EObject eObject = it.next();

			if (ModelUtil.isIgnoredDatatype(eObject)) {
				continue;
			}

			String id = xmiResource.getID(eObject);
			ModelElementId eObjectId = ModelFactory.eINSTANCE
					.createModelElementId();

			if (id != null) {
				eObjectId.setId(id);
			} else {
				xmiResource.setID(eObject, eObjectId.getId());
			}

			putIntoCaches(eObject, eObjectId);
		}
	}

	public EList<EObject> getModelElements() {
		return modelElements;
	}

	public void addModelElement(EObject me) {
		getModelElements().add(me);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.Project#getAllModelElements()
	 * @generated NOT
	 */
	public Set<EObject> getAllModelElements() {
		if (!isCacheInitialized()) {
			initCaches();
		}

		return eObjectsCache;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.Project#getAllModelElementIds()
	 */
	public Set<ModelElementId> getAllModelElementIds() {
		if (!isCacheInitialized()) {
			initCaches();
		}

		return idToEObjectCache.keySet();
	}

	private boolean isCacheInitialized() {
		return cachesInitialized;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 * @see org.eclipse.emf.emfstore.common.model.Project#contains(org.eclipse.emf.ecore.EObject)
	 */
	public boolean contains(ModelElementId id) {
		if (!isCacheInitialized()) {
			initCaches();
		}
		return getIdToEObjectCache().containsKey(id);
	}

	private Map<ModelElementId, EObject> getIdToEObjectCache() {
		if (!isCacheInitialized()) {
			initCaches();
		}

		return idToEObjectCache;
	}

	private Set<EObject> getEObjectsCache() {
		if (!isCacheInitialized()) {
			initCaches();
		}

		return eObjectsCache;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.Project#initCaches()
	 */
	public void initCaches() {

		if (isCacheInitialized()) {
			return;
		}

		for (EObject modelElement : getModelElements()) {
			// put model element into cache
			ModelElementId modelElementId = getIdForModelElement(modelElement);
			putIntoCaches(modelElement, modelElementId);

			// put children of model element into cache
			TreeIterator<EObject> it = modelElement.eAllContents();
			while (it.hasNext()) {
				EObject obj = it.next();
				ModelElementId id = getIdForModelElement(obj);
				putIntoCaches(obj, id);
			}
		}

		if (changeNotifier == null) {
			changeNotifier = new EObjectChangeNotifier(this, this);
		}

		cachesInitialized = true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.Project#initCaches(java.util.Map,
	 *      java.util.Map)
	 */
	public void initCaches(Map<EObject, ModelElementId> eObjectToIdMap,
			Map<ModelElementId, EObject> idToEObjectMap) {
		// 1. maps setzen
		// 2. cacheinit auf true
		// 3. notifier erzeugen
		cachesInitialized = true;
		eObjectToIdCache = eObjectToIdMap;
		idToEObjectCache = idToEObjectMap;
		eObjectsCache = eObjectToIdMap.keySet();
		changeNotifier = new EObjectChangeNotifier(this, this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.util.ProjectChangeObserver#modelElementAdded(org.eclipse.emf.emfstore.common.model.Project,
	 *      org.eclipse.emf.ecore.EObject)
	 */
	public void modelElementAdded(final IdEObjectCollection project,
			final EObject eObject) {
		addModelElementAndChildrenToCache(eObject);

		ProjectChangeObserverNotificationCommand command = new ProjectChangeObserverNotificationCommand() {
			public void run(ProjectChangeObserver projectChangeObserver) {
				projectChangeObserver.modelElementAdded(project, eObject);
			}
		};
		notifyProjectChangeObservers(command);
	}

	private void notifyProjectChangeObservers(
			ProjectChangeObserverNotificationCommand command) {
		isNotifiying = true;
		for (ProjectChangeObserver projectChangeObserver : this.observers) {
			try {
				command.run(projectChangeObserver);
				// BEGIN SUPRESS CATCH EXCEPTION
			} catch (RuntimeException ex) {
				// END SUPRESS CATCH EXCEPTION
				if (exceptionThrowingObservers.contains(projectChangeObserver)) {
					if (!undetachableObservers.contains(projectChangeObserver)) {
						observersToRemove.add(projectChangeObserver);
						ModelUtil
								.logException(
										"Project Change Observer threw an exception again, it has been detached, UI may not update now: "
												+ projectChangeObserver
														.getClass().getName(),
										ex);
					} else {
						ModelUtil
								.logException(
										"Project Change Observer threw an exception again, but it will not be detached."
												+ projectChangeObserver
														.getClass().getName(),
										ex);
					}
				} else {
					exceptionThrowingObservers.add(projectChangeObserver);
					ModelUtil.logWarning(
							"Project Change Observer threw an exception: "
									+ projectChangeObserver.getClass()
											.getName(), ex);
				}
			}
		}
		isNotifiying = false;
		for (ProjectChangeObserver observer : this.observersToRemove) {
			removeProjectChangeObserver(observer);
		}
		this.observersToRemove.clear();
	}

	private void addModelElementAndChildrenToCache(EObject eObject) {

		List<ModelElementId> removableIds = new ArrayList<ModelElementId>();

		// first check whether ID should be reassigned
		ModelElementId id = newEObjectToIdMap.get(eObject);

		if (id == null) {
			// if not, create a new ID
			id = ModelFactory.eINSTANCE.createModelElementId();
		} else {
			removableIds.add(id);
		}

		if (isCacheInitialized()) {
			putIntoCaches(eObject, id);
		}

		for (EObject child : ModelUtil.getAllContainedModelElements(eObject,
				false)) {
			// first check whether ID should be reassigned
			ModelElementId childId = newEObjectToIdMap.get(child);

			if (childId == null) {
				// if not, create a new ID
				childId = ModelFactory.eINSTANCE.createModelElementId();
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

	private void putIntoCaches(EObject modelElement,
			ModelElementId modelElementId) {
		eObjectToIdCache.put(modelElement, modelElementId);
		idToEObjectCache.put(modelElementId, modelElement);
		if (!eObjectsCache.contains(modelElement)) {
			eObjectsCache.add(modelElement);
		}
	}

	private void removeModelElementAndChildrenFromCache(EObject modelElement) {

		ModelElementId id = getModelElementId(modelElement);
		deletedEObjectToIdMap.put(modelElement, id);
		newEObjectToIdMap.put(modelElement, id);

		removeFromCaches(modelElement);
		eObjectToIdCache.remove(modelElement);

		for (EObject child : ModelUtil.getAllContainedModelElements(
				modelElement, false)) {
			ModelElementId childId = getModelElementId(child);
			deletedEObjectToIdMap.put(child, childId);
			newEObjectToIdMap.put(child, childId);
			removeFromCaches(child);
			eObjectToIdCache.remove(child);
		}
	}

	/**
	 * Removes the given model element from the EObject cache and the
	 * idToEObject cache in case the caches have been initialized.
	 * 
	 * @param modelElement
	 *            the model element to be removed from the caches
	 */
	private void removeFromCaches(EObject modelElement) {
		if (isCacheInitialized()) {
			ModelElementId id = this.getModelElementId(modelElement);
			getEObjectsCache().remove(modelElement);
			getIdToEObjectCache().remove(id);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification,
	 *      org.eclipse.emf.emfstore.common.model.Project,
	 *      org.eclipse.emf.ecore.EObject)
	 */
	public void notify(final Notification notification,
			final IdEObjectCollection project, final EObject modelElement) {
		ProjectChangeObserverNotificationCommand command = new ProjectChangeObserverNotificationCommand() {
			public void run(ProjectChangeObserver projectChangeObserver) {
				projectChangeObserver.notify(notification, project,
						modelElement);
			}
		};
		notifyProjectChangeObservers(command);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.Project#getModelElement(org.eclipse.emf.emfstore.common.model.ModelElementId)
	 */
	public EObject getModelElement(ModelElementId modelElementId) {

		if (!isCacheInitialized()) {
			initCaches();
		}

		EObject eObject = getIdToEObjectCache().get(modelElementId);

		return eObject != null ? eObject : ModelUtil
				.getSingleton(modelElementId);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.Project#addProjectChangeObserver(org.eclipse.emf.emfstore.common.model.util.ProjectChangeObserver)
	 */
	public void addProjectChangeObserver(
			ProjectChangeObserver projectChangeObserver) {
		initCaches();
		this.observers.add(projectChangeObserver);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.Project#removeProjectChangeObserver(org.eclipse.emf.emfstore.common.model.util.ProjectChangeObserver)
	 */
	public void removeProjectChangeObserver(
			ProjectChangeObserver projectChangeObserver) {
		if (isNotifiying) {
			observersToRemove.add(projectChangeObserver);
			return;
		}
		this.observers.remove(projectChangeObserver);
		exceptionThrowingObservers.remove(projectChangeObserver);
		undetachableObservers.remove(projectChangeObserver);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.Project#containsInstance(org.eclipse.emf.ecore.EObject)
	 */
	public boolean containsInstance(EObject modelElement) {
		return getEObjectsCache().contains(modelElement);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.Project#deleteModelElement(org.eclipse.emf.ecore.EObject)
	 */
	public void deleteModelElement(final EObject modelElement) {
		if (!this.containsInstance(modelElement)) {
			throw new IllegalArgumentException(
					"Cannot delete a model element that is not contained in this project.");
		}

		// remove cross references
		ModelUtil.deleteOutgoingCrossReferences(modelElement, true, false);
		ModelUtil.deleteIncomingCrossReferencesFromParent(modelElement, this,
				true, false);

		// remove containment
		EObject containerModelElement = ModelUtil
				.getContainerModelElement(modelElement);
		if (containerModelElement == null) {
			// removeModelElementAndChildrenFromCache(modelElement);
			// getEobjectsIdMap().remove(modelElement);
			this.getModelElements().remove(modelElement);
		} else {
			XMIResource res = (XMIResource) modelElement.eResource();
			EReference containmentFeature = modelElement.eContainmentFeature();
			if (containmentFeature.isMany()) {
				EList<?> containmentList = (EList<?>) containerModelElement
						.eGet(containmentFeature);
				containmentList.remove(modelElement);
			} else {
				containerModelElement.eSet(containmentFeature, null);
			}
			ModelUtil.removeModelElementAndChildrenFromResource(res,
					modelElement);
		}
	}

	/**
	 * Make a project change observer undetachable.
	 * 
	 * @param observer
	 *            the observer
	 */
	public void setUndetachable(ProjectChangeObserver observer) {
		undetachableObservers.add(observer);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.Project#delete()
	 */
	public void delete() {
		final NotifiableIdEObjectCollection collection = this;
		ProjectChangeObserverNotificationCommand command = new ProjectChangeObserverNotificationCommand() {
			public void run(ProjectChangeObserver projectChangeObserver) {
				projectChangeObserver.projectDeleted(collection);
			}
		};
		notifyProjectChangeObservers(command);
	}

	/**
	 * Handle the removal of an element from the containment hierachy.
	 * 
	 * @param projectImpl
	 *            the project
	 * @param modelElement
	 *            the model element
	 */
	public void modelElementRemoved(final IdEObjectCollection projectImpl,
			final EObject modelElement) {
		removeModelElementAndChildrenFromCache(modelElement);
		ProjectChangeObserverNotificationCommand command = new ProjectChangeObserverNotificationCommand() {
			public void run(ProjectChangeObserver projectChangeObserver) {
				projectChangeObserver.modelElementRemoved(projectImpl,
						modelElement);
			}
		};
		notifyProjectChangeObservers(command);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.Project#getModelElementId(org.eclipse.emf.ecore.EObject)
	 */
	public ModelElementId getModelElementId(EObject eObject) {

		if (!eObjectToIdCache.containsKey(eObject) && !isCacheInitialized()) {

			if (containedModelElements == null) {
				containedModelElements = ModelUtil
						.getAllContainedModelElements(this, false);
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
				ModelElementId modelElementId = ModelFactory.eINSTANCE
						.createModelElementId();

				String id = xmiResource.getID(eObject);
				if (id != null) {
					// change ID
					modelElementId.setId(id);
					eObjectToIdCache.put(eObject, modelElementId);
					return ModelUtil.clone(modelElementId);
				}

				// return new ID
				eObjectToIdCache.put(eObject, modelElementId);
				return ModelUtil.clone(modelElementId);

			} catch (IOException e) {
				throw new RuntimeException(
						"Couldn't load resource for model element " + eObject);
			}
		}

		ModelElementId id = eObjectToIdCache.get(eObject);

		return id != null ? ModelUtil.clone(id) : ModelUtil
				.getSingletonModelElementId(eObject);
	}

	/**
	 * Retrieve the {@link ModelElementId} for an EObject.
	 * 
	 * @param deletedModelElement
	 *            the deleted EObject
	 * @return the {@link ModelElementId}
	 */
	public ModelElementId getDeletedModelElementId(EObject deletedModelElement) {

		ModelElementId id = deletedEObjectToIdMap.get(deletedModelElement);

		return id != null ? ModelUtil.clone(id) : ModelUtil
				.getSingletonModelElementId(deletedModelElement);
	}

	/**
	 * Get the deleted model element with the given id from the project.
	 * 
	 * @param modelElementId
	 *            the model element id
	 * @return the deleted model element or null if it is not in the project
	 */
	public EObject getDeletedModelElement(ModelElementId modelElementId) {
		for (Map.Entry<EObject, ModelElementId> entry : deletedEObjectToIdMap
				.entrySet()) {
			if (entry.getValue().equals(modelElementId)) {
				return entry.getKey();
			}
		}

		return ModelUtil.getSingleton(modelElementId);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.Project#addModelElement(org.eclipse.emf.ecore.EObject,
	 *      java.util.Collection)
	 */
	public void addModelElement(EObject newModelElement,
			Map<EObject, ModelElementId> map) {

		// since id is contained in map, all IDs should be cloned
		ModelElementId newModelElementId = ModelUtil.clone(map
				.get(newModelElement));

		// check whether the model element is already contained in the project
		if (contains(newModelElementId)) {
			throw new IllegalStateException("Model element ID "
					+ newModelElementId + " already contained in project.");
		}

		for (Map.Entry<EObject, ModelElementId> entry : map.entrySet()) {
			EObject modelElement = entry.getKey();
			ModelElementId modelElementId = entry.getValue();
			newEObjectToIdMap.put(modelElement, modelElementId);
		}

		getModelElements().add(newModelElement);
	}

	/**
	 * Returns the ModelElementId for the given model element. If no such ID
	 * exists, a new one will be created.
	 * 
	 * @param modelElement
	 * @return the ModelElementId for the given modelelement
	 */
	private ModelElementId getIdForModelElement(EObject modelElement) {

		Resource resource = modelElement.eResource();

		if (resource != null && resource instanceof XMIResource) {
			// resource available, read ID
			XMIResource xmiResource = (XMIResource) resource;
			try {
				xmiResource.load(null);
			} catch (IOException e) {
				throw new RuntimeException("Resource of model element "
						+ modelElement + " couldn't be loaded");
			}
			String id = xmiResource.getID(modelElement);
			if (id != null) {
				ModelElementId objId = ModelFactory.eINSTANCE
						.createModelElementId();
				objId.setId(id);
				return objId;
			}
		}

		// create new ID
		return ModelFactory.eINSTANCE.createModelElementId();
	}

	/**
	 * Copies the current project.
	 * 
	 * @return the copied project
	 */
	public NotifiableIdEObjectCollection copy() {

		if (this.changeNotifier != null) {
			this.changeNotifier.disableNotifications(true);
		}

		// rename copier
		Copier copier = new ProjectCopier();
		NotifiableIdEObjectCollectionImpl result = (NotifiableIdEObjectCollectionImpl) copier
				.copy(this);
		result.cachesInitialized = true;
		copier.copyReferences();

		if (changeNotifier != null) {
			changeNotifier.disableNotifications(false);
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.util.ProjectChangeObserver#projectDeleted(org.eclipse.emf.emfstore.common.model.Project)
	 */
	public void projectDeleted(NotifiableIdEObjectCollection project) {

	}

	public EObjectChangeNotifier getChangeNotifier() {
		return changeNotifier;
	}
}
