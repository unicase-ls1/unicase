/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.LoggedException;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.metamodel.util.ProjectChangeNotifier;
import org.unicase.metamodel.util.ProjectChangeObserver;

/**
 * @author koegel, naughton
 * @generated
 */
public class ProjectImpl extends EObjectImpl implements Project {

	/**
	 * The cached value of the '{@link #getModelElements() <em>Model Elements</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModelElements()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> modelElements;

	/**
	 * The cached value of the '{@link #getCutElements() <em>Cut Elements</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCutElements()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> cutElements;

	protected EMap<ModelElementId, EObject> modelElementIdToEObjectsCache;

	private List<ProjectChangeObserver> observers;
	private boolean isNotifiying;
	private Set<ProjectChangeObserver> exceptionThrowingObservers;
	private Set<ProjectChangeObserver> observersToRemove;
	private Set<ProjectChangeObserver> undetachableObservers;

	private Set<EObject> eObjectsCache;

	private Map<EObject, ModelElementId> eObjectToIdCache;

	private Map<EObject, ModelElementId> deletedEObjectToIdMap;

	private Map<EObject, ModelElementId> newEObjectToIdMap;

	private Map<ModelElementId, EObject> idToEObjectCache;

	private boolean cachesInitialized;

	// begin of custom code
	/**
	 * Constructor. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected ProjectImpl() {
		super();
		observers = new ArrayList<ProjectChangeObserver>();
		isNotifiying = false;
		exceptionThrowingObservers = new HashSet<ProjectChangeObserver>();
		observersToRemove = new HashSet<ProjectChangeObserver>();
		undetachableObservers = new HashSet<ProjectChangeObserver>();
		eObjectToIdCache = new HashMap<EObject, ModelElementId>();
		deletedEObjectToIdMap = new HashMap<EObject, ModelElementId>();
		newEObjectToIdMap = new HashMap<EObject, ModelElementId>();
	}

	// end of custom code

	/**
	 * <!-- begin-user-doc --> .<!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.PROJECT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<EObject> getModelElements() {
		if (modelElements == null) {
			modelElements = new EObjectContainmentEList.Resolving<EObject>(EObject.class, this,
				MetamodelPackage.PROJECT__MODEL_ELEMENTS);
		}
		return modelElements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<EObject> getCutElements() {
		if (cutElements == null) {
			cutElements = new EObjectContainmentEList.Resolving<EObject>(EObject.class, this,
				MetamodelPackage.PROJECT__CUT_ELEMENTS);
		}
		return cutElements;
	}

	public void addModelElement(EObject me) {
		getModelElements().add(me);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.Project#getAllModelElements()
	 * @generated NOT
	 */
	public EList<EObject> getAllModelElements() {
		return getModelElements();
		// return this.getAllModelElementsbyClass(EcoreFactory.eINSTANCE.getEcorePackage().getEObject(), new
		// BasicEList<EObject>());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.Project#getAllModelElementsbyClass(org.eclipse.emf.ecore.EClass)
	 * @generated NOT
	 */
	public <T extends EObject> EList<T> getAllModelElementsbyClass(EClass modelElementClass, EList<T> list) {
		return getAllModelElementsbyClass(modelElementClass, list, true);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.Project#getAllModelElementsbyClass(org.eclipse.emf.ecore.EClass)
	 * @generated NOT
	 */
	// two casts below are guarded by initial sanity check and if statement
	@SuppressWarnings("unchecked")
	public <T extends EObject> EList<T> getAllModelElementsbyClass(EClass modelElementClass, EList<T> list,
		Boolean subclasses) {

		// sanity check
		if (!MetamodelPackage.eINSTANCE.getModelElement().isSuperTypeOf(modelElementClass)) {
			return list;
		}

		if (subclasses) {
			for (ModelElementId modelElementId : getIdToEObjectCache().keySet()) {
				EObject modelElement = this.getModelElement(modelElementId);
				if (modelElementClass.isInstance(modelElement)) {
					list.add((T) modelElement);
				}
			}
		} else {
			for (ModelElementId modelElementId : getIdToEObjectCache().keySet()) {
				EObject modelElement = this.getModelElement(modelElementId);
				if (modelElement.eClass() == modelElementClass) {
					list.add((T) modelElement);
				}
			}
		}

		return list;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.Project#getModelElementsByClass(org.eclipse.emf.ecore.EClass)
	 * @generated NOT
	 */
	// cast below is guarded by sanity check
	@SuppressWarnings("unchecked")
	public <T extends EObject> EList<T> getModelElementsByClass(EClass modelElementClass, EList<T> list) {

		for (EObject modelElement : this.getModelElements()) {
			if (modelElementClass.isInstance(modelElement)) {
				list.add((T) modelElement);
			}
		}
		return list;
	}

	// end of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MetamodelPackage.PROJECT__MODEL_ELEMENTS:
			return ((InternalEList<?>) getModelElements()).basicRemove(otherEnd, msgs);
		case MetamodelPackage.PROJECT__CUT_ELEMENTS:
			return ((InternalEList<?>) getCutElements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MetamodelPackage.PROJECT__MODEL_ELEMENTS:
			return getModelElements();
		case MetamodelPackage.PROJECT__CUT_ELEMENTS:
			return getCutElements();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MetamodelPackage.PROJECT__MODEL_ELEMENTS:
			getModelElements().clear();
			getModelElements().addAll((Collection<? extends EObject>) newValue);
			return;
		case MetamodelPackage.PROJECT__CUT_ELEMENTS:
			getCutElements().clear();
			getCutElements().addAll((Collection<? extends EObject>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case MetamodelPackage.PROJECT__MODEL_ELEMENTS:
			getModelElements().clear();
			return;
		case MetamodelPackage.PROJECT__CUT_ELEMENTS:
			getCutElements().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MetamodelPackage.PROJECT__MODEL_ELEMENTS:
			return modelElements != null && !modelElements.isEmpty();
		case MetamodelPackage.PROJECT__CUT_ELEMENTS:
			return cutElements != null && !cutElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	// begin of custom code

	/**
	 * this methods implements the adapter interface which is needed by the navigator.
	 * 
	 * @param adapter the adapter class
	 * @return the adapter
	 * @author shterev
	 */
	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
		return Platform.getAdapterManager().getAdapter(this, adapter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 * @see org.unicase.metamodel.Project#contains(org.unicase.model.ModelElement)
	 */
	public boolean contains(ModelElementId id) {
		return getIdToEObjectCache().containsKey(id);
		// return getModelElementsFromCache().keySet().contains(id);
		// return getEobjectsIdMap().containsValue(id);
	}

	private Map<ModelElementId, EObject> getIdToEObjectCache() {
		if (idToEObjectCache == null) {
			initCaches();
		}

		return idToEObjectCache;
	}

	private Set<EObject> getEObjectsCache() {
		if (eObjectsCache == null) {
			initCaches();
		}

		return eObjectsCache;
	}

	private void initCaches() {
		eObjectsCache = new HashSet<EObject>();
		idToEObjectCache = new HashMap<ModelElementId, EObject>();
		for (EObject modelElement : modelElements) {
			TreeIterator<EObject> it = modelElement.eAllContents();
			while (it.hasNext()) {
				EObject obj = it.next();
				Resource resource = obj.eResource();
				if (resource instanceof XMIResource) {
					XMIResource xmiResource = (XMIResource) resource;
					try {
						xmiResource.load(null);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						// Do NOT catch all Exceptions ("catch (Exception e)")
						// Log AND handle Exceptions if possible
						//
						// You can just uncomment one of the lines below to log an exception:
						// logException will show the logged excpetion to the user
						// ModelUtil.logException(e);
						// ModelUtil.logException("YOUR MESSAGE HERE", e);
						// logWarning will only add the message to the error log
						// ModelUtil.logWarning("YOUR MESSAGE HERE", e);
						// ModelUtil.logWarning("YOUR MESSAGE HERE");
						//			
						// If handling is not possible declare and rethrow Exception
					}
					String id = xmiResource.getID(obj);
					if (id != null) {
						// TODO
						// what now?
						ModelElementId objId = MetamodelFactory.eINSTANCE.createModelElementId();
						objId.setId(id);
						eObjectsCache.add(obj);
						eObjectToIdCache.put(obj, objId);
						idToEObjectCache.put(objId, obj);
					}
				}
			}
		}
		cachesInitialized = true;
	}

	/**
	 * Get the model element cache.
	 * 
	 * @return the cache map
	 */
	// TODO: We'll put this back afterwards
	// public Map<ModelElementId, EObject> getModelElementsFromCache() {
	// initCacheAndNotifier();
	// // TODO: HACK, consistency between cache and map currently not fixed
	// for (Map.Entry<EObject, ModelElementId> e : getEobjectsIdMap()) {
	// modelElementIdToEObjectsCache.put(ModelUtil.clone(e.getValue()), e.getKey());
	// }
	// return modelElementIdToEObjectsCache.map();
	// }

	private void initCacheAndNotifier() {
		if (modelElementIdToEObjectsCache == null) {
			// init cache
			modelElementIdToEObjectsCache = new BasicEMap<ModelElementId, EObject>();
			TreeIterator<EObject> allContents = this.eAllContents();
			while (allContents.hasNext()) {
				EObject next = allContents.next();
				// TODO: do we need an replacement for the instanceof check?
				// if (MetamodelPackage.eINSTANCE.getModelElement().isInstance(next)) {
				ModelElementId id = ModelUtil.getProject(next).getModelElementId(next);
				modelElementIdToEObjectsCache.put(id, next);
				// }
			}
			new ProjectChangeNotifier(this);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementAdded(org.unicase.metamodel.Project,
	 *      org.unicase.model.ModelElement)
	 */
	public void handleEMFModelElementAdded(final Project project, final EObject eObject) {
		addModelElementAndChildrenToCache(eObject);

		// remove from deleted map, if entry exists
		ModelElementId id = getDeletedModelElementId(eObject);
		if (id != null) {
			deletedEObjectToIdMap.remove(eObject);
		}

		ProjectChangeObserverNotificationCommand command = new ProjectChangeObserverNotificationCommand() {
			public void run(ProjectChangeObserver projectChangeObserver) {
				projectChangeObserver.modelElementAdded(project, eObject);
			}
		};
		notifyProjectChangeObservers(command);
	}

	private void notifyProjectChangeObservers(ProjectChangeObserverNotificationCommand command) {
		isNotifiying = true;
		for (ProjectChangeObserver projectChangeObserver : this.observers) {
			try {
				command.run(projectChangeObserver);
				// BEGIN SUPRESS CATCH EXCEPTION
			} catch (RuntimeException ex) {
				// END SUPRESS CATCH EXCEPTION
				try {
					if (exceptionThrowingObservers.contains(projectChangeObserver)) {
						if (undetachableObservers.contains(projectChangeObserver)) {
							observersToRemove.add(projectChangeObserver);
							ModelUtil.logException(
								"Project Change Observer threw an exception again, it has been detached, UI may not update now: "
									+ projectChangeObserver.getClass().getName(), ex);
						} else {
							ModelUtil.logException(
								"Project Change Observer threw an exception again, but it will not be detached."
									+ projectChangeObserver.getClass().getName(), ex);
						}
					} else {
						exceptionThrowingObservers.add(projectChangeObserver);
						ModelUtil.logWarning("Project Change Observer threw an exception: "
							+ projectChangeObserver.getClass().getName(), ex);
					}
				} catch (LoggedException loggedException) {
					// do nothing
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

		// first check whether ID should be reassigned
		ModelElementId id = newEObjectToIdMap.get(eObject);

		if (id == null) {
			id = getDeletedModelElementId(eObject);
			// remove happens in caller
		}

		// if not, create a new ID
		if (id == null) {
			id = MetamodelFactory.eINSTANCE.createModelElementId();
		}

		if (cachesInitialized) {
			getEObjectToIdCache().put(eObject, id);
			getEObjectsCache().add(eObject);
			getIdToEObjectCache().put(id, eObject);
		}

		for (EObject child : ModelUtil.getAllContainedModelElements(eObject, false)) {
			addModelElementAndChildrenToCache(child);
		}
	}

	/**
	 * @return
	 */
	public Map<EObject, ModelElementId> getEObjectToIdCache() {
		return eObjectToIdCache;
	}

	private void updateModelElementAndChildrenFromCache(EObject modelElement) {

		ModelElementId id = getModelElementId(modelElement);
		deletedEObjectToIdMap.put(modelElement, id);

		removeFromCaches(modelElement);
		getEObjectToIdCache().remove(modelElement);

		for (EObject child : ModelUtil.getAllContainedModelElements(modelElement, false)) {
			ModelElementId childId = getModelElementId(child);
			deletedEObjectToIdMap.put(child, childId);
			removeFromCaches(child);
			getEObjectToIdCache().remove(child);
		}
	}

	/**
	 * @param child
	 */
	private void removeFromCaches(EObject modelElement) {
		if (cachesInitialized) {
			ModelElementId id = this.getModelElementId(modelElement);
			getEObjectsCache().remove(modelElement);
			getIdToEObjectCache().remove(id);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification,
	 *      org.unicase.metamodel.Project, org.unicase.model.ModelElement)
	 */
	public void handleEMFNotification(final Notification notification, final Project project, final EObject modelElement) {
		ProjectChangeObserverNotificationCommand command = new ProjectChangeObserverNotificationCommand() {
			public void run(ProjectChangeObserver projectChangeObserver) {
				projectChangeObserver.notify(notification, project, modelElement);
			}
		};
		notifyProjectChangeObservers(command);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.Project#getModelElement(org.unicase.metamodel.ModelElementId)
	 */
	public EObject getModelElement(ModelElementId modelElementId) {

		if (getIdToEObjectCache().containsKey(modelElementId)) {
			return getIdToEObjectCache().get(modelElementId);
		}

		// EObject obj = this.getModelElementsFromCache().get(modelElementId);

		// for (Map.Entry<EObject, ModelElementId> entry : getEobjectsIdMap()) {
		// if (entry.getValue().equals(modelElementId)) {
		// return entry.getKey();
		// }
		// }

		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.Project#addProjectChangeObserver(org.unicase.model.util.ProjectChangeObserver)
	 */
	public void addProjectChangeObserver(ProjectChangeObserver projectChangeObserver) {
		initCacheAndNotifier();
		this.observers.add(projectChangeObserver);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.Project#removeProjectChangeObserver(org.unicase.model.util.ProjectChangeObserver)
	 */
	public void removeProjectChangeObserver(ProjectChangeObserver projectChangeObserver) {
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
	 * @see org.unicase.metamodel.Project#containsInstance(org.unicase.model.ModelElement)
	 */
	public boolean containsInstance(EObject modelElement) {
		return getEObjectsCache().contains(modelElement);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.Project#deleteModelElement(org.unicase.model.ModelElement)
	 */
	public void deleteModelElement(final EObject modelElement) {
		if (!this.containsInstance(modelElement)) {
			throw new IllegalArgumentException("Cannot delete a model element that is not contained in this project.");
		}
		//
		// ModelElementId deletedModelElementId = getModelElementId(modelElement);
		// removeModelElementAndChildrenFromCache(modelElement);
		// getDeletedEObjectsIdMap().put(modelElement, deletedModelElementId);
		// getEobjectsIdMap().remove(modelElement);

		deleteOutgoingCrossReferences(modelElement);
		deleteIncomingCrossReferences(modelElement);

		for (EObject child : ModelUtil.getAllContainedModelElements(modelElement, false)) {
			deleteOutgoingCrossReferences(child);
			deleteIncomingCrossReferences(child);
		}

		// remove containment
		EObject containerModelElement = ModelUtil.getContainerModelElement(modelElement);
		if (containerModelElement == null) {
			// removeModelElementAndChildrenFromCache(modelElement);
			// getEobjectsIdMap().remove(modelElement);
			this.getModelElements().remove(modelElement);
		} else {
			EReference containmentFeature = modelElement.eContainmentFeature();
			if (containmentFeature.isMany()) {
				EList<?> containmentList = (EList<?>) containerModelElement.eGet(containmentFeature);
				containmentList.remove(modelElement);
			} else {
				containerModelElement.eSet(containmentFeature, null);
			}
		}
		// if (!this.containsInstance(element)) {
		// throw new IllegalArgumentException("Cannot delete a model element that is not contained in this project.");
		// }
		//
		// EObject eObject;
		// if (element instanceof ModelElementId) {
		// eObject = getModelElementId(element); // getModelElementsFromCache().get(element);
		// } else {
		// eObject = element;
		// }
		//
		// ModelElementId objectId = getModelElementId(eObject);
		//
		// deleteOutgoingCrossReferences(element);
		// deleteIncomingCrossReferences(element);
		//
		// for (EObject child : ModelUtil.getAllContainedModelElements(element, false)) {
		// deleteOutgoingCrossReferences(child);
		// deleteIncomingCrossReferences(child);
		// }
		//
		// if (element instanceof ModelElementId) {
		// EObject o = getModelElement((ModelElementId) element);
		// for (EObject me : ModelUtil.getAllContainedModelElementsAsList(o, false)) {
		// ModelElementId id = getEobjectsIdMap().get(me);
		// getDeletedEObjectsIdMap().put(me, id);
		// }
		// } else {
		// for (EObject me : ModelUtil.getAllContainedModelElementsAsList(element, false)) {
		// ModelElementId id = getEobjectsIdMap().get(me);
		// getDeletedEObjectsIdMap().put(me, id);
		// }
		// }
		//
		// if (element instanceof ModelElementId) {
		// EObject o = getModelElement((ModelElementId) element);
		//
		// for (EObject me : ModelUtil.getAllContainedModelElementsAsList(o, false)) {
		// eobjectsIdMap.values().remove(me);
		// }
		// } else {
		//
		// for (EObject me : ModelUtil.getAllContainedModelElementsAsList(eObject, false)) {
		// eobjectsIdMap.values().remove(me);
		// }
		//
		// getEobjectsIdMap().values().remove(objectId);
		// // getModelElementsFromCache().keySet().remove(objectId);
		// getDeletedEObjectsIdMap().put(eObject, objectId);
		// }
		//
		// // remove containment
		// EObject containerModelElement = eObject.eContainer();
		// if (containerModelElement == this) {
		// this.getModelElements().remove(eObject);
		// } else {
		// EReference containmentFeature = eObject.eContainmentFeature();
		// if (containmentFeature.isMany()) {
		// EList<?> containmentList = (EList<?>) containerModelElement.eGet(containmentFeature);
		// containmentList.remove(eObject);
		// } else {
		// containerModelElement.eSet(containmentFeature, null);
		// }
		// }
		//
		// // TODO: unsure if this is still needed
		// List<ModelElementId> unsettedIds = new BasicEList<ModelElementId>();
		//
		// for (Map.Entry<EObject, ModelElementId> e : getEobjectsIdMap().entrySet()) {
		// if (e.getKey() == null) {
		// unsettedIds.add(e.getValue());
		// }
		// }
		//
		// for (ModelElementId key : unsettedIds) {
		// getEobjectsIdMap().values().remove(key);
		// removeModelElementAndChildrenFromCache(containerModelElement)
		// }
	}

	private void deleteOutgoingCrossReferences(EObject modelElement) {
		// delete all non containment cross references to other elments
		for (EReference reference : modelElement.eClass().getEAllReferences()) {
			EClassifier eType = reference.getEType();
			if (reference.isContainer() || reference.isContainment() || !reference.isChangeable()) {
				continue;
			}
			if (eType instanceof EClass) {
				modelElement.eUnset(reference);
			}
		}
	}

	private void deleteIncomingCrossReferences(EObject modelElement) {
		// delete all non containment cross references from other elements in the project
		for (EObject otherModelElement : ModelUtil.getAllContainedModelElements(this, false)) {
			for (EObject otherElementOpposite : otherModelElement.eCrossReferences()) {
				if (otherElementOpposite == modelElement) {
					EList<EReference> references = otherModelElement.eClass().getEAllReferences();
					for (EReference reference : references) {
						if (!reference.isContainment() && !reference.isContainer()
							&& isCorrespondingReference(modelElement, otherModelElement, reference)) {
							if (reference.isMany()) {
								((EList<?>) otherModelElement.eGet(reference)).remove(modelElement);
							} else {
								otherModelElement.eUnset(reference);
							}
						}
					}
				}
			}
		}
	}

	private boolean isCorrespondingReference(EObject modelElement, EObject otherModelElement, EReference reference) {
		if (reference.isMany()) {
			if (otherModelElement.eGet(reference) == null) {
				return false;
			}
			return ((List<?>) otherModelElement.eGet(reference)).contains(modelElement);
		} else {
			return modelElement.equals(otherModelElement.eGet(reference));
		}
	}

	/**
	 * Make a project change observer undetachable.
	 * 
	 * @param observer the observer
	 */
	public void setUndetachable(ProjectChangeObserver observer) {
		undetachableObservers.add(observer);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.Project#delete()
	 */
	public void delete() {
		final Project project = this;
		ProjectChangeObserverNotificationCommand command = new ProjectChangeObserverNotificationCommand() {
			public void run(ProjectChangeObserver projectChangeObserver) {
				projectChangeObserver.projectDeleted(project);
			}
		};
		notifyProjectChangeObservers(command);
	}

	/**
	 * Handle the removal of an element from the containment hierachy.
	 * 
	 * @param projectImpl the project
	 * @param modelElement the model element
	 */
	public void handleEMFModelElementRemoved(final ProjectImpl projectImpl, final EObject modelElement) {

		ProjectChangeObserverNotificationCommand command = new ProjectChangeObserverNotificationCommand() {
			public void run(ProjectChangeObserver projectChangeObserver) {
				projectChangeObserver.modelElementRemoved(projectImpl, modelElement);
			}
		};

		updateModelElementAndChildrenFromCache(modelElement);
		// getEobjectsIdMap().remove(modelElement);

		notifyProjectChangeObservers(command);

	}

	// public void updateCaches() {
	// for (Map.Entry<EObject, ModelElementId> entry : getEobjectsIdMap()) {
	// getEObjectsCache().add(entry.getKey());
	// getIdToEObjectCache().put(entry.getValue(), entry.getKey());
	// getEObjectToIdCache().put(entry.getKey(), entry.getValue());
	// }
	// }

	public ModelElementId getModelElementId(EObject eObject) {

		if (!eObjectToIdCache.containsKey(eObject) && !cachesInitialized) {
			// id not yet loaded
			if (getAllModelElements().contains(eObject)) {
				// eobject contained in project, load resource
				try {
					Resource resource = eObject.eResource();
					if (resource instanceof XMIResource) {
						XMIResource xmiResource = (XMIResource) resource;
						xmiResource.load(null);
						String id = xmiResource.getID(eObject);
						if (id != null) {
							ModelElementId modelElementId = MetamodelFactory.eINSTANCE.createModelElementId();
							modelElementId.setId(id);
							getEObjectToIdCache().put(eObject, modelElementId);
							return modelElementId;
						}

						return null;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					// Do NOT catch all Exceptions ("catch (Exception e)")
					// Log AND handle Exceptions if possible
					//
					// You can just uncomment one of the lines below to log an exception:
					// logException will show the logged excpetion to the user
					// ModelUtil.logException(e);
					// ModelUtil.logException("", e);
					// logWarning will only add the message to the error log
					// ModelUtil.logWarning("YOUR MESSAGE HERE", e);
					// ModelUtil.logWarning("YOUR MESSAGE HERE");
					//			
					// If handling is not possible declare and rethrow Exception
				}

			}
		}

		ModelElementId id = eObjectToIdCache.get(eObject);

		return id != null ? ModelUtil.clone(id) : null;
	}

	public ModelElementId getDeletedModelElementId(EObject deletedModelElement) {
		return ModelUtil.clone(deletedEObjectToIdMap.get(deletedModelElement));
	}

	public EObject getDeletedModelElement(ModelElementId modelElementId) {
		for (Map.Entry<EObject, ModelElementId> entry : deletedEObjectToIdMap.entrySet()) {
			if (entry.getValue().equals(modelElementId)) {
				return entry.getKey();
			}
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.Project#addModelElement(org.eclipse.emf.ecore.EObject, java.util.Collection)
	 */
	public void addModelElement(EObject newModelElement, Map<EObject, ModelElementId> map) {

		// since id is contained in map, all ids should be cloned
		ModelElementId newModelElementId = ModelUtil.clone(map.get(newModelElement));

		// check whether the model element is already contained in the project
		if (getEObjectToIdCache().containsValue(newModelElementId)) {
			// update: first remove it and then add the updated model element again
			// getModelElementsFromCache().remove(newModelElementId);
			// is EObjectsIdMap updated automatically?
			EObject o = getEObjectToIdCache().get(newModelElementId);
			getIdToEObjectCache().remove(newModelElementId);
			getEObjectToIdCache().keySet().remove(newModelElementId);
			getEObjectsCache().remove(o);
		}
		// check whether the model element previously has been deleted
		else if (deletedEObjectToIdMap.containsValue(newModelElementId)) {
			// add possibly updated model element and removed it from the deleted map

			EObject m = null;
			for (Map.Entry<EObject, ModelElementId> e : deletedEObjectToIdMap.entrySet()) {
				if (e.getValue().equals(newModelElementId)) {
					m = e.getKey();
				}
			}
			// getDeletedModelElements().remove(m);
			// remove added object from map that contains the already deleted
			// eobjects
			deletedEObjectToIdMap.values().remove(newModelElementId);
			for (EObject child : ModelUtil.getAllContainedModelElements(newModelElement, false)) {
				// id is contained
				ModelElementId childId = ModelUtil.clone(map.get(child));
				deletedEObjectToIdMap.values().remove(childId);
			}
		}

		getModelElements().add(newModelElement);

		// correct ids
		getIdToEObjectCache().put(newModelElementId, newModelElement);
		getEObjectToIdCache().put(newModelElement, newModelElementId);
		getEObjectsCache().add(newModelElement);

		for (EObject child : ModelUtil.getAllContainedModelElements(newModelElement, false)) {
			ModelElementId childId = ModelUtil.clone(map.get(child));
			getIdToEObjectCache().put(childId, child);
			getEObjectToIdCache().put(child, childId);
			getEObjectsCache().add(child);
		}
	}
}
