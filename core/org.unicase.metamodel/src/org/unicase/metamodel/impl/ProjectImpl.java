/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
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

	/**
	 * The cached value of the '{@link #getEobjectsIdMap() <em>Eobjects Id Map</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEobjectsIdMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<EObject, ModelElementId> eobjectsIdMap;
	/**
	 * The cached value of the '{@link #getDeletedEObjectsIdMap() <em>Deleted EObjects Id Map</em>}' map. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDeletedEObjectsIdMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<EObject, ModelElementId> deletedEObjectsIdMap;

	/**
	 * The cached value of the '{@link #getNewEObjectsIdMap() <em>New EObjects Id Map</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNewEObjectsIdMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<EObject, ModelElementId> newEObjectsIdMap;

	/**
	 * The cached value of the '{@link #getDeletedModelElements() <em>Deleted Model Elements</em>}' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDeletedModelElements()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> deletedModelElements;

	protected EMap<ModelElementId, EObject> modelElementIdToEObjectsCache;

	private List<ProjectChangeObserver> observers;
	private boolean isNotifiying;
	private Set<ProjectChangeObserver> exceptionThrowingObservers;
	private Set<ProjectChangeObserver> observersToRemove;
	private Set<ProjectChangeObserver> undetachableObservers;

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

	// begin of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EMap<EObject, ModelElementId> getEobjectsIdMap() {
		if (eobjectsIdMap == null) {
			eobjectsIdMap = new EcoreEMap<EObject, ModelElementId>(
				MetamodelPackage.Literals.EOBJECT_TO_MODEL_ELEMENT_ID_MAP, EObjectToModelElementIdMapImpl.class, this,
				MetamodelPackage.PROJECT__EOBJECTS_ID_MAP);
		}
		return eobjectsIdMap;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EMap<EObject, ModelElementId> getDeletedEObjectsIdMap() {
		if (deletedEObjectsIdMap == null) {
			deletedEObjectsIdMap = new EcoreEMap<EObject, ModelElementId>(
				MetamodelPackage.Literals.EOBJECT_TO_MODEL_ELEMENT_ID_MAP, EObjectToModelElementIdMapImpl.class, this,
				MetamodelPackage.PROJECT__DELETED_EOBJECTS_ID_MAP);
		}
		return deletedEObjectsIdMap;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EMap<EObject, ModelElementId> getNewEObjectsIdMap() {
		if (newEObjectsIdMap == null) {
			newEObjectsIdMap = new EcoreEMap<EObject, ModelElementId>(
				MetamodelPackage.Literals.EOBJECT_TO_MODEL_ELEMENT_ID_MAP, EObjectToModelElementIdMapImpl.class, this,
				MetamodelPackage.PROJECT__NEW_EOBJECTS_ID_MAP);
		}
		return newEObjectsIdMap;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<EObject> getDeletedModelElements() {
		if (deletedModelElements == null) {
			deletedModelElements = new EObjectContainmentEList.Resolving<EObject>(EObject.class, this,
				MetamodelPackage.PROJECT__DELETED_MODEL_ELEMENTS);
		}
		return deletedModelElements;
	}

	// begin of custom code
	public void addModelElement(EObject me) {
		if (me instanceof EObjectToModelElementIdMapImpl) {
			return;
		} else {
			getModelElements().add(me);
		}
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

		if (subclasses) {
			for (ModelElementId modelElementId : getModelElementsFromCache().keySet()) {
				EObject modelElement = this.getModelElement(modelElementId);
				if (modelElement instanceof ModelElementId) {
					modelElement = eobjectsIdMap.get(modelElement);
				}
				if (modelElementClass.isInstance(modelElement)) {
					list.add((T) modelElement);
				}
			}
		} else {
			for (ModelElementId modelElementId : getModelElementsFromCache().keySet()) {
				EObject modelElement = this.getModelElement(modelElementId);
				if (modelElement instanceof ModelElementId) {
					modelElement = getModelElementsFromCache().get(modelElement);
				}
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
		case MetamodelPackage.PROJECT__EOBJECTS_ID_MAP:
			return ((InternalEList<?>) getEobjectsIdMap()).basicRemove(otherEnd, msgs);
		case MetamodelPackage.PROJECT__DELETED_EOBJECTS_ID_MAP:
			return ((InternalEList<?>) getDeletedEObjectsIdMap()).basicRemove(otherEnd, msgs);
		case MetamodelPackage.PROJECT__NEW_EOBJECTS_ID_MAP:
			return ((InternalEList<?>) getNewEObjectsIdMap()).basicRemove(otherEnd, msgs);
		case MetamodelPackage.PROJECT__DELETED_MODEL_ELEMENTS:
			return ((InternalEList<?>) getDeletedModelElements()).basicRemove(otherEnd, msgs);
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
		case MetamodelPackage.PROJECT__EOBJECTS_ID_MAP:
			if (coreType)
				return getEobjectsIdMap();
			else
				return getEobjectsIdMap().map();
		case MetamodelPackage.PROJECT__DELETED_EOBJECTS_ID_MAP:
			if (coreType)
				return getDeletedEObjectsIdMap();
			else
				return getDeletedEObjectsIdMap().map();
		case MetamodelPackage.PROJECT__NEW_EOBJECTS_ID_MAP:
			if (coreType)
				return getNewEObjectsIdMap();
			else
				return getNewEObjectsIdMap().map();
		case MetamodelPackage.PROJECT__DELETED_MODEL_ELEMENTS:
			return getDeletedModelElements();
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
		case MetamodelPackage.PROJECT__EOBJECTS_ID_MAP:
			((EStructuralFeature.Setting) getEobjectsIdMap()).set(newValue);
			return;
		case MetamodelPackage.PROJECT__DELETED_EOBJECTS_ID_MAP:
			((EStructuralFeature.Setting) getDeletedEObjectsIdMap()).set(newValue);
			return;
		case MetamodelPackage.PROJECT__NEW_EOBJECTS_ID_MAP:
			((EStructuralFeature.Setting) getNewEObjectsIdMap()).set(newValue);
			return;
		case MetamodelPackage.PROJECT__DELETED_MODEL_ELEMENTS:
			getDeletedModelElements().clear();
			getDeletedModelElements().addAll((Collection<? extends EObject>) newValue);
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
		case MetamodelPackage.PROJECT__EOBJECTS_ID_MAP:
			getEobjectsIdMap().clear();
			return;
		case MetamodelPackage.PROJECT__DELETED_EOBJECTS_ID_MAP:
			getDeletedEObjectsIdMap().clear();
			return;
		case MetamodelPackage.PROJECT__NEW_EOBJECTS_ID_MAP:
			getNewEObjectsIdMap().clear();
			return;
		case MetamodelPackage.PROJECT__DELETED_MODEL_ELEMENTS:
			getDeletedModelElements().clear();
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
		case MetamodelPackage.PROJECT__EOBJECTS_ID_MAP:
			return eobjectsIdMap != null && !eobjectsIdMap.isEmpty();
		case MetamodelPackage.PROJECT__DELETED_EOBJECTS_ID_MAP:
			return deletedEObjectsIdMap != null && !deletedEObjectsIdMap.isEmpty();
		case MetamodelPackage.PROJECT__NEW_EOBJECTS_ID_MAP:
			return newEObjectsIdMap != null && !newEObjectsIdMap.isEmpty();
		case MetamodelPackage.PROJECT__DELETED_MODEL_ELEMENTS:
			return deletedModelElements != null && !deletedModelElements.isEmpty();
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
		return getModelElementsFromCache().keySet().contains(id);
	}

	public boolean contains(EObject obj) {
		return getModelElementsFromCache().containsValue(obj);
	}

	/**
	 * Get the model element cache.
	 * 
	 * @return the cache map
	 */
	public Map<ModelElementId, EObject> getModelElementsFromCache() {
		initCacheAndNotifier();
		return modelElementIdToEObjectsCache.map();
	}

	// private Map<EObject, ModelElementId> getNewModelElementEObjectFromCache() {
	// initCacheAndNotifier();
	// return eobjectsIdMap;
	// // return newModelElementIdToEObjects.map();
	// }

	private void initCacheAndNotifier() {
		if (modelElementIdToEObjectsCache == null) {
			// init cache
			modelElementIdToEObjectsCache = new BasicEMap<ModelElementId, EObject>();
			TreeIterator<EObject> allContents = this.eAllContents();
			while (allContents.hasNext()) {
				EObject next = allContents.next();
				// TODO: EMFStore: instance check for model element
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
		if (project != null) {
			// TODO: EMFStore: is project alone not already sufficient to check for?
			ModelElementId id = project.getModelElementId(eObject);
			if (modelElementIdToEObjectsCache.containsKey(id) && id != null) {
				throw new IllegalStateException("ModelElement is already in the project!");
			}
		} else if (eObject instanceof EObjectToModelElementIdMapImpl) {
			return;
		}
		// checkForCrossReferences(modelElement);
		addModelElementAndChildrenToCache(eObject);

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

			}
		}
		isNotifiying = false;
		for (ProjectChangeObserver observer : this.observersToRemove) {
			removeProjectChangeObserver(observer);
		}
		this.observersToRemove.clear();
	}

	private void checkForCrossReferences(EObject modelElement) {
		if (!ModelUtil.isSelfContained(modelElement, true)) {
			String message = "ModelElements may not contain cross references to other model elements when added to project!";
			IllegalStateException exception = new IllegalStateException(message);
			ModelUtil.logException(message, exception);
			throw exception;
		}
	}

	private void addModelElementAndChildrenToCache(EObject eObject) {

		ModelElementId id = ModelUtil.getProject(eObject).getModelElementId(eObject);

		if (id == null) {
			id = MetamodelFactory.eINSTANCE.createModelElementId();
		}

		getModelElementsFromCache().put(id, eObject);
		getEobjectsIdMap().put(eObject, id);

		for (EObject child : ModelUtil.getAllContainedModelElements(eObject, false)) {
			// ModelElementId childId = ModelUtil.getProject(child).getModelElementId(child);
			//
			// if (childId == null) {
			// childId = MetamodelFactory.eINSTANCE.createModelElementId();
			// }
			//
			// getModelElementsFromCache().put(childId, child);
			// getEobjectsIdMap().put(child, childId);
			addModelElementAndChildrenToCache(child);
		}

		// TODO: EMFStore
		// if (!contains(eObject)) {
		// ModelElementId id = getNewEObjectsIdMap().get(eObject);
		// if (id == null) {
		// id = MetamodelFactory.eINSTANCE.createModelElementId();
		// }
		// getModelElementsFromCache().put(id, eObject);
		// getEobjectsIdMap().put(eObject, id);
		//
		// for (EObject child : ModelUtil.getAllContainedModelElements(eObject, false)) {
		// addModelElementAndChildrenToCache(child);
		// }
		// }
	}

	private void removeModelElementAndChildrenFromCache(EObject modelElement) {
		ModelElementId id = this.getModelElementId(modelElement);
		this.modelElementIdToEObjectsCache.remove(id);

		for (EObject child : ModelUtil.getAllContainedModelElements(modelElement, false)) {
			ModelElementId childId = getModelElementId(child);
			this.modelElementIdToEObjectsCache.remove(childId);
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
		EObject obj = this.getModelElementsFromCache().get(modelElementId);

		if (obj == null) {
			// look up deleted elements
			for (Map.Entry<EObject, ModelElementId> entry : getDeletedEObjectsIdMap()) {
				if (entry.getValue().equals(modelElementId)) {
					return entry.getKey();
				}
			}
		} else {
			return obj;
		}

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
		// TODO: EMFPlainEObjectTransition
		return getEobjectsIdMap().containsKey(modelElement);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.Project#deleteModelElement(org.unicase.model.ModelElement)
	 */
	public void deleteModelElement(final EObject element) {
		if (!this.contains(element)) {
			throw new IllegalArgumentException("Cannot delete a model element that is not contained in this project.");
		}

		deleteOutgoingCrossReferences(element);
		deleteIncomingCrossReferences(element);

		for (EObject child : ModelUtil.getAllContainedModelElements(element, false)) {
			deleteOutgoingCrossReferences(child);
			deleteIncomingCrossReferences(child);
		}

		EObject eObject;
		if (element instanceof ModelElementId) {
			eObject = getModelElementsFromCache().get(element);
		} else {
			eObject = element;
		}

		ModelElementId objectId = getModelElementId(eObject);

		if (element instanceof ModelElementId) {
			EObject o = getModelElement((ModelElementId) element);
			for (EObject me : ModelUtil.getAllContainedModelElementsAsList(o, false)) {
				ModelElementId id = getEobjectsIdMap().get(me);
				getDeletedEObjectsIdMap().put(me, id);
			}
		} else {
			for (EObject me : ModelUtil.getAllContainedModelElementsAsList(element, false)) {
				ModelElementId id = getEobjectsIdMap().get(me);
				getDeletedEObjectsIdMap().put(me, id);
			}
		}

		// remove containment
		EObject containerModelElement = eObject.eContainer();
		if (containerModelElement == this) {
			this.getModelElements().remove(eObject);
		} else {
			EReference containmentFeature = eObject.eContainmentFeature();
			if (containmentFeature.isMany()) {
				EList<?> containmentList = (EList<?>) containerModelElement.eGet(containmentFeature);
				containmentList.remove(eObject);
			} else {
				containerModelElement.eSet(containmentFeature, null);
			}
		}

		// ////////

		if (element instanceof ModelElementId) {
			EObject o = getModelElement((ModelElementId) element);

			for (EObject me : ModelUtil.getAllContainedModelElementsAsList(o, false)) {
				// getDeletedModelElements().add(me);
				eobjectsIdMap.values().remove(me);
				// getModelElementsFromCache().values().remove(me);
			}

			// getDeletedModelElements().add(o);
			// eobjectsIdMap.values().remove(element);
			// getModelElementsFromCache().keySet().remove(element);
			// getDeletedEObjectsIdMap().put(o, (ModelElementId) element);

			// TODO: EMFPlainEObjectTransition: NEW, zusammenfassen
			// getNewEObjectsIdMap().put(ModelUtil.clone(eObject), (ModelElementId) element);
			// getDeletedModelElements().add(eObject);
		} else {

			for (EObject me : ModelUtil.getAllContainedModelElementsAsList(eObject, false)) {
				// getDeletedModelElements().add(me);
				eobjectsIdMap.values().remove(me);
				// getModelElementsFromCache().values().remove(me);
			}

			// getDeletedModelElements().add(element);
			eobjectsIdMap.values().remove(objectId);
			getModelElementsFromCache().keySet().remove(objectId);
			getDeletedEObjectsIdMap().put(element, objectId);

			// getNewEObjectsIdMap().put(ModelUtil.clone(eObject), id);
			// getDeletedModelElements().add(eObject);
		}

		// TODO: EMFPlainEObjectTransition : unset durch deleteIncomingcrossreferences
		// sind nicht containted, element wird dadurch geloescht?
		// delete all unsetted elements
		List<ModelElementId> unsettedIds = new BasicEList<ModelElementId>();

		for (Map.Entry<EObject, ModelElementId> e : getEobjectsIdMap().entrySet()) {
			if (e.getKey() == null) {
				unsettedIds.add(e.getValue());
			}
		}

		for (ModelElementId key : unsettedIds) {
			getEobjectsIdMap().values().remove(key);
			getModelElementsFromCache().remove(key);
		}
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

		ModelElementId deletedModelElementId = getModelElementId(modelElement);
		removeModelElementAndChildrenFromCache(modelElement);
		getDeletedModelElements().add(modelElement);
		getDeletedEObjectsIdMap().put(modelElement, deletedModelElementId);
		getEobjectsIdMap().remove(modelElement);

		notifyProjectChangeObservers(command);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.Project#getModelElement(org.eclipse.emf.ecore.EObject)
	 */
	public ModelElementId getModelElementId(EObject eObject) {
		for (Map.Entry<ModelElementId, EObject> entry : getModelElementsFromCache().entrySet()) {
			if (entry.getValue() != null) {
				if (entry.getValue().equals(eObject)) {
					return ModelUtil.clone(entry.getKey());
				}
			}
		}

		// also check newEObjects cache, as it contains IDs of already deleted EObjects
		ModelElementId id = getDeletedEObjectsIdMap().get(eObject);

		if (id != null) {
			return ModelUtil.clone(id);
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.Project#addModelElement(org.eclipse.emf.ecore.EObject, java.util.Collection)
	 */
	public void addModelElement(EObject newModelElement, Map<EObject, ModelElementId> map) {

		if (newModelElement instanceof EObjectToModelElementIdMapImpl) {
			// ignore
			return;
		}

		// since id is contained in map, all ids should be cloned
		ModelElementId newModelElementId = ModelUtil.clone(map.get(newModelElement));

		// check whether the model element is already contained in the project
		if (getModelElementsFromCache().containsKey(newModelElementId)) {
			// update: first remove it and then add the updated model element again
			getModelElementsFromCache().remove(newModelElementId);
			// is EObjectsIdMap updated automatically?

		}
		// check whether the model element previously has been deleted
		else if (getDeletedEObjectsIdMap().containsValue(newModelElementId)) {
			// add possibly updated model element and removed it from the deleted map

			EObject m = null;
			for (Map.Entry<EObject, ModelElementId> e : getDeletedEObjectsIdMap().entrySet()) {
				if (e.getValue().equals(newModelElementId)) {
					m = e.getKey();
				}
			}
			getDeletedModelElements().remove(m);
			getDeletedEObjectsIdMap().values().remove(newModelElementId);
			for (EObject child : ModelUtil.getAllContainedModelElements(newModelElement, false)) {
				// id is contained
				ModelElementId childId = ModelUtil.clone(map.get(child));
				getDeletedEObjectsIdMap().values().remove(childId);
			}
		}

		getModelElements().add(newModelElement);
		getModelElementsFromCache().put(newModelElementId, newModelElement);

		// correct ids
		getEobjectsIdMap().put(newModelElement, newModelElementId);
		for (EObject child : ModelUtil.getAllContainedModelElements(newModelElement, false)) {
			ModelElementId childId = ModelUtil.clone(map.get(child));
			getEobjectsIdMap().put(child, childId);
			getModelElementsFromCache().put(childId, child);
		}

	}
}
