/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.util.ProjectChangeNotifier;
import org.unicase.model.util.ProjectChangeObserver;

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
	protected EList<ModelElement> modelElements;
	private Map<ModelElementId, ModelElement> modelElementCache;
	private List<ProjectChangeObserver> observers;
	private ProjectChangeNotifier projectChangeNotifier;

	// begin of custom code
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected ProjectImpl() {
		super();
		observers = new ArrayList<ProjectChangeObserver>();
	}

	// end of custom code

	/**
	 * <!-- begin-user-doc --> .<!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PROJECT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ModelElement> getModelElements() {
		if (modelElements == null) {
			modelElements = new EObjectContainmentEList.Resolving<ModelElement>(ModelElement.class, this,
				ModelPackage.PROJECT__MODEL_ELEMENTS);
		}
		return modelElements;
	}

	// begin of custom code
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.Project#addModelElement(org.unicase.model.ModelElement)
	 * @generated NOT
	 */
	public void addModelElement(ModelElement modelElement) {
		this.getModelElements().add(modelElement);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.Project#getAllModelElements()
	 * @generated NOT
	 */
	public EList<ModelElement> getAllModelElements() {
		return this
			.getAllModelElementsbyClass(ModelPackage.eINSTANCE.getModelElement(), new BasicEList<ModelElement>());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.Project#getAllModelElementsbyClass(org.eclipse.emf.ecore.EClass)
	 * @generated NOT
	 */
	public <T extends ModelElement> EList<T> getAllModelElementsbyClass(EClass modelElementClass, EList<T> list) {
		return getAllModelElementsbyClass(modelElementClass, list, true);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.Project#getAllModelElementsbyClass(org.eclipse.emf.ecore.EClass)
	 * @generated NOT
	 */
	// two casts below are guarded by initial sanity check and if statement
	@SuppressWarnings("unchecked")
	public <T extends ModelElement> EList<T> getAllModelElementsbyClass(EClass modelElementClass, EList<T> list,
		Boolean subclasses) {

		// sanity check
		if (!ModelPackage.eINSTANCE.getModelElement().isSuperTypeOf(modelElementClass)) {
			return list;
		}

		if (subclasses) {
			for (ModelElementId modelElementId : getModelElementsFromCache().keySet()) {
				ModelElement modelElement = this.getModelElement(modelElementId);
				if (modelElementClass.isInstance(modelElement)) {
					list.add((T) modelElement);
				}
			}
		} else {
			for (ModelElementId modelElementId : getModelElementsFromCache().keySet()) {
				ModelElement modelElement = this.getModelElement(modelElementId);
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
	 * @see org.unicase.model.Project#getModelElementsByClass(org.eclipse.emf.ecore.EClass)
	 * @generated NOT
	 */
	// cast below is guarded by sanity check
	@SuppressWarnings("unchecked")
	public <T extends ModelElement> EList<T> getModelElementsByClass(EClass modelElementClass, EList<T> list) {

		if (!ModelPackage.eINSTANCE.getModelElement().isSuperTypeOf(modelElementClass)) {
			return list;
		}
		for (ModelElement modelElement : this.getModelElements()) {
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
		case ModelPackage.PROJECT__MODEL_ELEMENTS:
			return ((InternalEList<?>) getModelElements()).basicRemove(otherEnd, msgs);
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
		case ModelPackage.PROJECT__MODEL_ELEMENTS:
			return getModelElements();
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
		case ModelPackage.PROJECT__MODEL_ELEMENTS:
			getModelElements().clear();
			getModelElements().addAll((Collection<? extends ModelElement>) newValue);
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
		case ModelPackage.PROJECT__MODEL_ELEMENTS:
			getModelElements().clear();
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
		case ModelPackage.PROJECT__MODEL_ELEMENTS:
			return modelElements != null && !modelElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * this methods implements the adapter interface which is needed by the navigator
	 * 
	 * @author helming
	 */
	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT {@inheritDoc}
	 * @see org.unicase.model.Project#contains(org.unicase.model.ModelElement)
	 */
	public boolean contains(ModelElement modelElement) {
		return contains(modelElement.getModelElementId());
	}

	/**
	 * Get the model element cache.
	 * 
	 * @return the cache map
	 */
	private Map<ModelElementId, ModelElement> getModelElementsFromCache() {
		initCacheAndNotifier();
		return modelElementCache;
	}

	private void initCacheAndNotifier() {
		if (modelElementCache == null) {
			// init cache
			modelElementCache = new HashMap<ModelElementId, ModelElement>();
			TreeIterator<EObject> allContents = this.eAllContents();
			while (allContents.hasNext()) {
				EObject next = allContents.next();
				if (ModelPackage.eINSTANCE.getModelElement().isInstance(next)) {
					ModelElement modelElement = (ModelElement) next;
					modelElementCache.put(modelElement.getModelElementId(), modelElement);
				}
			}
			projectChangeNotifier = new ProjectChangeNotifier(this);
		}
	}

	private void handleModelElementDeleted(ModelElement modelElement) {
		this.getModelElementsFromCache().remove(modelElement.getModelElementId());
		// MK: hack to remove adapter of project change observer
		if (this.projectChangeNotifier != null) {
			modelElement.eAdapters().remove(this.projectChangeNotifier);
		}
		for (ModelElement child : modelElement.getAllContainedModelElements()) {
			this.getModelElementsFromCache().remove(child.getModelElementId());
			// MK: hack to remove adapter of project change observer
			if (this.projectChangeNotifier != null) {
				child.eAdapters().remove(this.projectChangeNotifier);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementAdded(org.unicase.model.Project,
	 *      org.unicase.model.ModelElement)
	 */
	public void handleEMFModelElementAdded(Project project, ModelElement modelElement) {
		if (this.modelElementCache.containsKey(modelElement.getModelElementId())) {
			throw new IllegalStateException("ModelElement is already in the project!");
		}
		addModelElementAndChildrenToCache(modelElement);
		for (ProjectChangeObserver projectChangeObserver : this.observers) {
			projectChangeObserver.modelElementAdded(project, modelElement);
		}
	}

	private void addModelElementAndChildrenToCache(ModelElement modelElement) {
		this.modelElementCache.put(modelElement.getModelElementId(), modelElement);
		for (ModelElement child : modelElement.getAllContainedModelElements()) {
			this.modelElementCache.put(child.getModelElementId(), child);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification,
	 *      org.unicase.model.Project, org.unicase.model.ModelElement)
	 */
	public void handleEMFNotification(Notification notification, Project project, ModelElement modelElement) {
		for (ProjectChangeObserver projectChangeObserver : this.observers) {
			projectChangeObserver.notify(notification, project, modelElement);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.Project#contains(org.unicase.model.ModelElementId)
	 */
	public boolean contains(ModelElementId modelElementId) {
		return this.getModelElementsFromCache().containsKey(modelElementId);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.Project#getModelElement(org.unicase.model.ModelElementId)
	 */
	public ModelElement getModelElement(ModelElementId modelElementId) {
		return this.getModelElementsFromCache().get(modelElementId);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.Project#addProjectChangeObserver(org.unicase.model.util.ProjectChangeObserver)
	 */
	public void addProjectChangeObserver(ProjectChangeObserver projectChangeObserver) {
		initCacheAndNotifier();
		this.observers.add(projectChangeObserver);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.Project#removeProjectChangeObserver(org.unicase.model.util.ProjectChangeObserver)
	 */
	public void removeProjectChangeObserver(ProjectChangeObserver projectChangeObserver) {
		this.observers.remove(projectChangeObserver);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.Project#containsInstance(org.unicase.model.ModelElement)
	 */
	public boolean containsInstance(ModelElement modelElement) {
		ModelElementId modelElementId = modelElement.getModelElementId();
		if (!this.contains(modelElementId)) {
			return false;
		}
		ModelElement element = this.getModelElementsFromCache().get(modelElementId);
		return element == modelElement;
	}

	public void deleteModelElement(ModelElement modelElement) {
		if (!this.contains(modelElement)) {
			throw new IllegalArgumentException("Cannot delete a model element that is not contained in this project.");
		}
		for (ProjectChangeObserver projectChangeObserver : this.observers) {
			projectChangeObserver.modelElementDeleteStarted(this, modelElement);
		}

		deleteOutgoingCrossReferences(modelElement);
		deleteIncomingCrossReferences(modelElement);

		for (ModelElement child : modelElement.getAllContainedModelElements()) {
			deleteOutgoingCrossReferences(child);
			deleteIncomingCrossReferences(child);
		}

		// remove containment
		ModelElement containerModelElement = modelElement.getContainerModelElement();
		if (containerModelElement == null) {
			this.getModelElements().remove(modelElement);
		} else {
			EList<?> containmentList = (EList<?>) containerModelElement.eGet(modelElement.eContainmentFeature());
			containmentList.remove(modelElement);
		}

		handleModelElementDeleted(modelElement);

		for (ProjectChangeObserver projectChangeObserver : this.observers) {
			projectChangeObserver.modelElementDeleteCompleted(this, modelElement);
		}

	}

	private void deleteOutgoingCrossReferences(ModelElement modelElement) {
		// delete all non containment cross references to other elments
		for (EReference reference : modelElement.eClass().getEAllReferences()) {
			if (!reference.isContainer() && !reference.isContainment()) {
				modelElement.eUnset(reference);
			}
		}
	}

	private void deleteIncomingCrossReferences(ModelElement modelElement) {
		// delete all non containment cross references from other elements in the project
		for (ModelElement otherModelElement : this.getAllModelElements()) {
			for (ModelElement otherElementOpposite : otherModelElement.getLinkedModelElements()) {
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

	private boolean isCorrespondingReference(ModelElement modelElement, ModelElement otherModelElement,
		EReference reference) {
		if (reference.isMany()) {
			if (otherModelElement.eGet(reference) == null) {
				return false;
			}
			return ((List<?>) otherModelElement.eGet(reference)).contains(modelElement);
		} else {
			return modelElement.equals(otherModelElement.eGet(reference));
		}
	}

}
