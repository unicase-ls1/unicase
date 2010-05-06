/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.UnkownFeatureException;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.impl.EObjectToModelElementIdMapImpl;
import org.unicase.metamodel.util.ModelUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Create Delete Operation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.CreateDeleteOperationImpl#isDelete <em>Delete
 * </em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.CreateDeleteOperationImpl#getModelElement <em>
 * Model Element</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.CreateDeleteOperationImpl#getSubOperations <em>Sub
 * Operations</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.CreateDeleteOperationImpl#getEobjectsIdMap <em>
 * Eobjects Id Map</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CreateDeleteOperationImpl extends AbstractOperationImpl implements CreateDeleteOperation {

	public void apply(Project project) {
		if (isDelete()) {
			if (!project.contains(getModelElementId())) {
				// silently fail
				return;
			}
			EObject localModelElement = project.getModelElement(getModelElementId());
			project.deleteModelElement(localModelElement);
		} else {
			// TODO
			if (project.contains(getModelElementId())) {
				// silently fail
				return;
			}
			CreateDeleteOperationImpl clone = ModelUtil.clone(this);
			project.addModelElement(clone.getModelElement(), clone.getEobjectsIdMap().map());
			for (ReferenceOperation operation : getSubOperations()) {
				operation.apply(project);
			}
		}
	}

	@Override
	public AbstractOperation reverse() {
		CreateDeleteOperation createDeleteOperation = OperationsFactory.eINSTANCE.createCreateDeleteOperation();
		super.reverse(createDeleteOperation);
		createDeleteOperation.setDelete(!this.isDelete());
		createDeleteOperation.setModelElement(ModelUtil.clone(this.getModelElement()));
		EList<ReferenceOperation> clonedSubOperations = createDeleteOperation.getSubOperations();
		for (ReferenceOperation operation : getSubOperations()) {
			clonedSubOperations.add(0, (ReferenceOperation) operation.reverse());
		}
		return createDeleteOperation;
	}

	/**
	 * The default value of the '{@link #isDelete() <em>Delete</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isDelete()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DELETE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDelete() <em>Delete</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isDelete()
	 * @generated
	 * @ordered
	 */
	protected boolean delete = DELETE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModelElement() <em>Model Element</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModelElement()
	 * @generated
	 * @ordered
	 */
	protected EObject modelElement;

	/**
	 * The cached value of the '{@link #getSubOperations() <em>Sub Operations</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSubOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<ReferenceOperation> subOperations;

	/**
	 * The cached value of the '{@link #getEobjectsIdMap() <em>Eobjects Id Map</em>}' map. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getEobjectsIdMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<EObject, ModelElementId> eobjectsIdMap;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CreateDeleteOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.CREATE_DELETE_OPERATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isDelete() {
		return delete;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDelete(boolean newDelete) {
		boolean oldDelete = delete;
		delete = newDelete;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.CREATE_DELETE_OPERATION__DELETE,
				oldDelete, delete));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EObject getModelElement() {
		if (modelElement != null && modelElement.eIsProxy()) {
			InternalEObject oldModelElement = (InternalEObject) modelElement;
			modelElement = eResolveProxy(oldModelElement);
			if (modelElement != oldModelElement) {
				InternalEObject newModelElement = (InternalEObject) modelElement;
				NotificationChain msgs = oldModelElement.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT, null, null);
				if (newModelElement.eInternalContainer() == null) {
					msgs = newModelElement.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT, oldModelElement, modelElement));
			}
		}
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EObject basicGetModelElement() {
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetModelElement(EObject newModelElement, NotificationChain msgs) {
		EObject oldModelElement = modelElement;
		modelElement = newModelElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT, oldModelElement, newModelElement);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setModelElement(EObject newModelElement) {
		if (newModelElement != modelElement) {
			NotificationChain msgs = null;
			if (modelElement != null)
				msgs = ((InternalEObject) modelElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT, null, msgs);
			if (newModelElement != null)
				msgs = ((InternalEObject) newModelElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT, null, msgs);
			msgs = basicSetModelElement(newModelElement, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT, newModelElement, newModelElement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ReferenceOperation> getSubOperations() {
		if (subOperations == null) {
			subOperations = new EObjectContainmentEList.Resolving<ReferenceOperation>(ReferenceOperation.class, this,
				OperationsPackage.CREATE_DELETE_OPERATION__SUB_OPERATIONS);
		}
		return subOperations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EMap<EObject, ModelElementId> getEobjectsIdMap() {
		if (eobjectsIdMap == null) {
			eobjectsIdMap = new EcoreEMap<EObject, ModelElementId>(
				MetamodelPackage.Literals.EOBJECT_TO_MODEL_ELEMENT_ID_MAP, EObjectToModelElementIdMapImpl.class, this,
				OperationsPackage.CREATE_DELETE_OPERATION__EOBJECTS_ID_MAP);
		}
		return eobjectsIdMap;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	// public EMap<ModelElementId, EObject> getModelElementIdToEObject() {
	// if (modelElementIdToEObject == null) {
	// modelElementIdToEObject = new EcoreEMap<ModelElementId, EObject>(
	// MetamodelPackage.Literals.MODEL_ELEMENT_ID_TO_EOBJECT_MAP, ModelElementIdToEObjectMapImpl.class, this,
	// OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT_ID_TO_EOBJECT);
	// }
	// return modelElementIdToEObject;
	// }

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT:
			return basicSetModelElement(null, msgs);
		case OperationsPackage.CREATE_DELETE_OPERATION__SUB_OPERATIONS:
			return ((InternalEList<?>) getSubOperations()).basicRemove(otherEnd, msgs);
		case OperationsPackage.CREATE_DELETE_OPERATION__EOBJECTS_ID_MAP:
			return ((InternalEList<?>) getEobjectsIdMap()).basicRemove(otherEnd, msgs);
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
		case OperationsPackage.CREATE_DELETE_OPERATION__DELETE:
			return isDelete();
		case OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT:
			if (resolve)
				return getModelElement();
			return basicGetModelElement();
		case OperationsPackage.CREATE_DELETE_OPERATION__SUB_OPERATIONS:
			return getSubOperations();
		case OperationsPackage.CREATE_DELETE_OPERATION__EOBJECTS_ID_MAP:
			if (coreType)
				return getEobjectsIdMap();
			else
				return getEobjectsIdMap().map();
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
		case OperationsPackage.CREATE_DELETE_OPERATION__DELETE:
			setDelete((Boolean) newValue);
			return;
		case OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT:
			setModelElement((EObject) newValue);
			return;
		case OperationsPackage.CREATE_DELETE_OPERATION__SUB_OPERATIONS:
			getSubOperations().clear();
			getSubOperations().addAll((Collection<? extends ReferenceOperation>) newValue);
			return;
		case OperationsPackage.CREATE_DELETE_OPERATION__EOBJECTS_ID_MAP:
			((EStructuralFeature.Setting) getEobjectsIdMap()).set(newValue);
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
		case OperationsPackage.CREATE_DELETE_OPERATION__DELETE:
			setDelete(DELETE_EDEFAULT);
			return;
		case OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT:
			setModelElement((EObject) null);
			return;
		case OperationsPackage.CREATE_DELETE_OPERATION__SUB_OPERATIONS:
			getSubOperations().clear();
			return;
		case OperationsPackage.CREATE_DELETE_OPERATION__EOBJECTS_ID_MAP:
			getEobjectsIdMap().clear();
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
		case OperationsPackage.CREATE_DELETE_OPERATION__DELETE:
			return delete != DELETE_EDEFAULT;
		case OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT:
			return modelElement != null;
		case OperationsPackage.CREATE_DELETE_OPERATION__SUB_OPERATIONS:
			return subOperations != null && !subOperations.isEmpty();
		case OperationsPackage.CREATE_DELETE_OPERATION__EOBJECTS_ID_MAP:
			return eobjectsIdMap != null && !eobjectsIdMap.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (delete: ");
		result.append(delete);
		result.append(')');
		return result.toString();
	}

	@Override
	public String getDescription() {
		StringBuilder stringBuilder = new StringBuilder();
		if (isDelete()) {
			stringBuilder.append("Deleted  ");
		} else {
			stringBuilder.append("Created ");
		}
		stringBuilder.append(getModelElement().eClass().getName());
		stringBuilder.append(" ");
		stringBuilder.append(getModelElementId().getId());
		// stringBuilder.append(".");
		return stringBuilder.toString();
	}

	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		if (isDelete()) {
			stringBuilder.append("Deleted  ");
			stringBuilder.append(getModelElement().eClass().getName());
			stringBuilder.append(" \"");
			stringBuilder.append(getModelElementId().getId());
			stringBuilder.append("\"");
		} else {
			stringBuilder.append("Created ");
			stringBuilder.append(getModelElement().eClass().getName());
		}
		return stringBuilder.toString();
	}

	/**
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.AbstractOperationImpl#getOtherInvolvedModelElements()
	 */
	@Override
	public Set<ModelElementId> getOtherInvolvedModelElements() {
		Set<ModelElementId> result = getAllDeletedModelElements();
		for (ReferenceOperation operation : getSubOperations()) {
			result.addAll(operation.getAllInvolvedModelElements());
		}
		return result;
	}

	public Set<ModelElementId> getAllDeletedModelElements() {
		Set<ModelElementId> result = new HashSet<ModelElementId>();
		for (EObject modelElement : ModelUtil.getAllContainedModelElements(getModelElement(), false)) {
			// if (modelElement instanceof ModelElement) {
			Project p = ModelUtil.getProject(modelElement);
			if (p != null) {
				result.add(p.getModelElementId(modelElement));
			}
			// }
		}
		for (ModelElementId id : getEobjectsIdMap().values()) {
			result.add(id);
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#getLeafOperations()
	 */
	public List<AbstractOperation> getLeafOperations() {
		List<AbstractOperation> result = new ArrayList<AbstractOperation>(getSubOperations().size() + 1);
		CreateDeleteOperation createDeleteClone = ModelUtil.clone(this);
		createDeleteClone.getSubOperations().clear();
		result.add(createDeleteClone);
		result.addAll(getSubOperations());
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 * @see org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation#getParentElement(org.unicase.metamodel.Project)
	 */
	public ModelElementId getParentofDeletedElement(Project project) {

		EList<ReferenceOperation> referenceOperations = getSubOperations();
		if (referenceOperations.size() == 0) {
			return null;
		}

		ReferenceOperation lastReferenceOperation = referenceOperations.get(referenceOperations.size() - 1);

		try {
			EStructuralFeature feature = lastReferenceOperation.getFeature(project);
			if (!(feature instanceof EReference)) {
				return null;
			}
			EReference reference = (EReference) feature;
			// reference is from parent side, so parent is the element that is changed by the last ref op
			if (reference.isContainment()) {
				if (lastReferenceOperation.getOtherInvolvedModelElements().contains(getModelElementId())) {
					return lastReferenceOperation.getModelElementId();
				}
				return null;
				// reference is from child side, so parent is the only element in other involved of the ref op
			} else if (reference.isContainer()) {
				if (lastReferenceOperation.getModelElementId().equals(getModelElementId())) {
					Set<ModelElementId> otherInvolvedModelElements = lastReferenceOperation
						.getOtherInvolvedModelElements();
					if (otherInvolvedModelElements.size() > 0) {
						return otherInvolvedModelElements.iterator().next();
					}
				}
			}
			return null;

		} catch (UnkownFeatureException e) {
			// parent does not exist any more or feature does not exist
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation#getModelElement(org.unicase.metamodel.ModelElementId)
	 */
	public EObject getModelElement(ModelElementId modelElementId) {
		for (ModelElementId id : getEobjectsIdMap().values()) {
			if (id.equals(modelElementId)) {
				return id;
			}
		}
		for (EObject deletedElement : ModelUtil.getAllContainedModelElements(getModelElement(), false)) {
			if (ModelUtil.getProject(deletedElement).getModelElementId(deletedElement).equals(modelElementId)) {
				return deletedElement;
			}
		}
		return null;
	}
} // CreateDeleteOperationImpl
