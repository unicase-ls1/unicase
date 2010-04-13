/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel.impl;

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
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.metamodel.MetamodelFactory;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementEObjectWrapper;
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
	 * The cached value of the '{@link #getModelElementWrappers() <em>Model Element Wrappers</em>}' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModelElementWrappers()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElementEObjectWrapper> modelElementWrappers;
	/**
	 * The cached value of the '{@link #getNewModelElementWrappers() <em>New Model Element Wrappers</em>}' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNewModelElementWrappers()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElementEObjectWrapper> newModelElementWrappers;
	private Map<ModelElementId, ModelElement> modelElementCache;
	private Map<EObject, ModelElementEObjectWrapper> modelElementEObjectWrapperCache;
	private List<ProjectChangeObserver> observers;
	private ProjectChangeNotifier projectChangeNotifier;
	private boolean isNotifiying;
	private Set<ProjectChangeObserver> exceptionThrowingObservers;
	private Set<ProjectChangeObserver> observersToRemove;
	private Set<ProjectChangeObserver> undetachableObservers;
	private Map<EObject, ModelElementEObjectWrapper> newModelElementEObjectWrapperCache;

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
	public EList<ModelElementEObjectWrapper> getModelElementWrappers() {
		if (modelElementWrappers == null) {
			modelElementWrappers = new EObjectContainmentEList.Resolving<ModelElementEObjectWrapper>(
				ModelElementEObjectWrapper.class, this, MetamodelPackage.PROJECT__MODEL_ELEMENT_WRAPPERS);
		}
		return modelElementWrappers;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ModelElementEObjectWrapper> getNewModelElementWrappers() {
		if (newModelElementWrappers == null) {
			newModelElementWrappers = new EObjectContainmentEList.Resolving<ModelElementEObjectWrapper>(
				ModelElementEObjectWrapper.class, this, MetamodelPackage.PROJECT__NEW_MODEL_ELEMENT_WRAPPERS);
		}
		return newModelElementWrappers;
	}

	// begin of custom code
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.Project#addModelElement(org.unicase.model.ModelElement)
	 * @generated NOT
	 */
	public void addModelElement(EObject modelElement) {
		this.getModelElements().add(modelElement);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.Project#getAllModelElements()
	 * @generated NOT
	 */
	public EList<ModelElement> getAllModelElements() {
		return this.getAllModelElementsbyClass(MetamodelPackage.eINSTANCE.getModelElement(),
			new BasicEList<ModelElement>());
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
				if (modelElement instanceof ModelElementEObjectWrapper) {
					modelElement = ((ModelElementEObjectWrapper) modelElement).getWrappedEObject();
				}
				if (modelElementClass.isInstance(modelElement)) {
					list.add((T) modelElement);
				}
			}
		} else {
			for (ModelElementId modelElementId : getModelElementsFromCache().keySet()) {
				EObject modelElement = this.getModelElement(modelElementId);
				if (modelElement instanceof ModelElementEObjectWrapper) {
					modelElement = ((ModelElementEObjectWrapper) modelElement).getWrappedEObject();
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
		case MetamodelPackage.PROJECT__MODEL_ELEMENT_WRAPPERS:
			return ((InternalEList<?>) getModelElementWrappers()).basicRemove(otherEnd, msgs);
		case MetamodelPackage.PROJECT__NEW_MODEL_ELEMENT_WRAPPERS:
			return ((InternalEList<?>) getNewModelElementWrappers()).basicRemove(otherEnd, msgs);
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
		case MetamodelPackage.PROJECT__MODEL_ELEMENT_WRAPPERS:
			return getModelElementWrappers();
		case MetamodelPackage.PROJECT__NEW_MODEL_ELEMENT_WRAPPERS:
			return getNewModelElementWrappers();
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
		case MetamodelPackage.PROJECT__MODEL_ELEMENT_WRAPPERS:
			getModelElementWrappers().clear();
			getModelElementWrappers().addAll((Collection<? extends ModelElementEObjectWrapper>) newValue);
			return;
		case MetamodelPackage.PROJECT__NEW_MODEL_ELEMENT_WRAPPERS:
			getNewModelElementWrappers().clear();
			getNewModelElementWrappers().addAll((Collection<? extends ModelElementEObjectWrapper>) newValue);
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
		case MetamodelPackage.PROJECT__MODEL_ELEMENT_WRAPPERS:
			getModelElementWrappers().clear();
			return;
		case MetamodelPackage.PROJECT__NEW_MODEL_ELEMENT_WRAPPERS:
			getNewModelElementWrappers().clear();
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
		case MetamodelPackage.PROJECT__MODEL_ELEMENT_WRAPPERS:
			return modelElementWrappers != null && !modelElementWrappers.isEmpty();
		case MetamodelPackage.PROJECT__NEW_MODEL_ELEMENT_WRAPPERS:
			return newModelElementWrappers != null && !newModelElementWrappers.isEmpty();
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
	public boolean contains(EObject modelElement) {
		if (modelElement instanceof ModelElement) {
			return contains(((ModelElement) modelElement).getModelElementId());
		} else {
			return getModelElementEObjectWrappersFromCache().keySet().contains(modelElement);
		}
	}

	/**
	 * Get the model element cache.
	 * 
	 * @return the cache map
	 */
	public Map<ModelElementId, ModelElement> getModelElementsFromCache() {
		initCacheAndNotifier();
		return modelElementCache;
	}

	/**
	 * Get the model element wrapper cache.
	 * 
	 * @return the cache map
	 */
	private Map<EObject, ModelElementEObjectWrapper> getModelElementEObjectWrappersFromCache() {
		initCacheAndNotifier();
		return modelElementEObjectWrapperCache;
	}
	
	private Map<EObject, ModelElementEObjectWrapper> getNewModelElementEObjectWrappersFromCache() {
		initCacheAndNotifier();
		return newModelElementEObjectWrapperCache;
	}

	private void initCacheAndNotifier() {
		if (modelElementCache == null) {
			// init cache
			modelElementCache = new HashMap<ModelElementId, ModelElement>();
			modelElementEObjectWrapperCache = new HashMap<EObject, ModelElementEObjectWrapper>();
			newModelElementEObjectWrapperCache = new HashMap<EObject, ModelElementEObjectWrapper>();
			projectChangeNotifier = new ProjectChangeNotifier(this, modelElementCache);
			for (ModelElementEObjectWrapper wrapper : getModelElementWrappers()) {
				EObject wrappedEObject = wrapper.getWrappedEObject();
				modelElementEObjectWrapperCache.put(wrappedEObject, wrapper);
				modelElementCache.put(wrapper.getModelElementId(), wrapper);
			}
		}
	}

	private void handleModelElementDeleted(ModelElement modelElement) {
		this.getModelElementsFromCache().remove(modelElement.getModelElementId());
		// MK: hack to remove adapter of project change observer
		if (this.projectChangeNotifier != null) {
			modelElement.eAdapters().remove(this.projectChangeNotifier);
		}
		for (EObject child : modelElement.getAllContainedModelElements(false)) {
			if (child instanceof ModelElementEObjectWrapper) {
				ModelElementEObjectWrapper wrapper = (ModelElementEObjectWrapper) child;
				this.getModelElementsFromCache().remove(wrapper);
				this.getModelElementEObjectWrappersFromCache().remove(wrapper.getWrappedEObject());
				// MK: hack to remove adapter of project change observer
				if (this.projectChangeNotifier != null) {
					child.eAdapters().remove(this.projectChangeNotifier);
				}
			} else {
				this.getModelElementsFromCache().remove(((ModelElement) child).getModelElementId());
				// MK: hack to remove adapter of project change observer
				if (this.projectChangeNotifier != null) {
					child.eAdapters().remove(this.projectChangeNotifier);
				}
			}

		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementAdded(org.unicase.metamodel.Project,
	 *      org.unicase.model.ModelElement)
	 */
	public void handleEMFModelElementAdded(final Project project, final EObject eObject) {
		if (contains(eObject)) {
			throw new IllegalStateException("ModelElement is already in the project!");
		}
		checkForCrossReferences(eObject);
		final ModelElement modelElement = addModelElementAndChildrenToCache(eObject);
		ProjectChangeObserverNotificationCommand command = new ProjectChangeObserverNotificationCommand() {
			public void run(ProjectChangeObserver projectChangeObserver) {
				projectChangeObserver.modelElementAdded(project, modelElement);
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

	private ModelElement addModelElementAndChildrenToCache(EObject eObject) {
		ModelElement modelElement;
		if (eObject instanceof ModelElement) {
			modelElement = (ModelElement) eObject;
			getModelElementsFromCache().put(modelElement.getModelElementId(), modelElement);
		} else {
			ModelElementEObjectWrapper wrapper = getNewModelElementEObjectWrappersFromCache().get(eObject);
			if (wrapper == null) {
				wrapper = MetamodelFactory.eINSTANCE.createModelElementEObjectWrapper();
				wrapper.setWrappedEObject(eObject);
			}
			getModelElementsFromCache().put(wrapper.getModelElementId(), wrapper);
			addWrapper(wrapper);
			modelElement = wrapper;
		}

		for (EObject child : ModelUtil.getAllContainedModelElements(eObject, false)) {
			addModelElementAndChildrenToCache(child);
		}
		return modelElement;
	}

	private void addWrapper(ModelElementEObjectWrapper wrapper) {
		this.getModelElementWrappers().add(wrapper);
		getModelElementEObjectWrappersFromCache().put(wrapper.getWrappedEObject(), wrapper);
		getNewModelElementEObjectWrappersFromCache().remove(wrapper.getWrappedEObject());
	}

	private void addNewWrapper(ModelElementEObjectWrapper wrapper) {
		this.getNewModelElementWrappers().add(wrapper);
		getNewModelElementEObjectWrappersFromCache().put(wrapper.getWrappedEObject(), wrapper);
	}

	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification,
	 *      org.unicase.metamodel.Project, org.unicase.model.ModelElement)
	 */
	public void handleEMFNotification(final Notification notification, final Project project,
		final ModelElement modelElement) {
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
	 * @see org.unicase.metamodel.Project#contains(org.unicase.metamodel.ModelElementId)
	 */
	public boolean contains(ModelElementId modelElementId) {
		return this.getModelElementsFromCache().containsKey(modelElementId);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.Project#getModelElement(org.unicase.metamodel.ModelElementId)
	 */
	public ModelElement getModelElement(ModelElementId modelElementId) {
		return this.getModelElementsFromCache().get(modelElementId);
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
	public boolean containsInstance(ModelElement modelElement) {
		ModelElementId modelElementId = modelElement.getModelElementId();
		if (!this.contains(modelElementId)) {
			return false;
		}
		ModelElement element = this.getModelElementsFromCache().get(modelElementId);
		return element == modelElement;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.Project#deleteModelElement(org.unicase.model.ModelElement)
	 */
	public void deleteModelElement(final ModelElement element) {
		if (!this.contains(element)) {
			throw new IllegalArgumentException("Cannot delete a model element that is not contained in this project.");
		}
		final Project project = this;
		ProjectChangeObserverNotificationCommand command = new ProjectChangeObserverNotificationCommand() {
			public void run(ProjectChangeObserver projectChangeObserver) {
				projectChangeObserver.modelElementDeleteStarted(project, element);
			}
		};
		notifyProjectChangeObservers(command);

		EObject eObject;
		if (element instanceof ModelElementEObjectWrapper) {
			eObject = ((ModelElementEObjectWrapper) element).getWrappedEObject();
			this.getModelElementWrappers().remove(element);
			this.getModelElementEObjectWrappersFromCache().remove(eObject);
			this.getModelElementsFromCache().remove(element.getModelElementId());
		} else {
			eObject = element;
		}
		deleteOutgoingCrossReferences(eObject);
		deleteIncomingCrossReferences(eObject);

		for (EObject child : element.getAllContainedModelElements(false)) {
			deleteOutgoingCrossReferences(child);
			deleteIncomingCrossReferences(child);
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

		handleModelElementDeleted(element);

		command = new ProjectChangeObserverNotificationCommand() {
			public void run(ProjectChangeObserver projectChangeObserver) {
				projectChangeObserver.modelElementDeleteCompleted(project, element);
			}
		};
		notifyProjectChangeObservers(command);

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
		for (ModelElement otherModelElement : this.getAllModelElements()) {
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
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.Project#getModelElement(org.eclipse.emf.ecore.EObject)
	 */
	public ModelElementEObjectWrapper getModelElement(EObject eObject) {
		return getModelElementEObjectWrappersFromCache().get(eObject);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.Project#addModelElement(org.eclipse.emf.ecore.EObject, java.util.Collection)
	 */
	public void addModelElement(EObject newModelELement, Collection<ModelElementEObjectWrapper> wrappers) {
		for (ModelElementEObjectWrapper wrapper: new ArrayList<ModelElementEObjectWrapper>(wrappers)) {
			addNewWrapper(wrapper);
		}
		getModelElements().add(newModelELement);
	}

}
