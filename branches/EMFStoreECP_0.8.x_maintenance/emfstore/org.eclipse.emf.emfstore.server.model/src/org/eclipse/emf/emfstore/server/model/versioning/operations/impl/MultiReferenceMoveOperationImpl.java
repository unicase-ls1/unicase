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
package org.eclipse.emf.emfstore.server.model.versioning.operations.impl;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.emfstore.common.model.IdEObjectCollection;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.MultiReferenceMoveOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsFactory;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage;
import org.eclipse.emf.emfstore.server.model.versioning.operations.UnkownFeatureException;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Multi Reference Move Operation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiReferenceMoveOperationImpl#getOldIndex
 * <em>Old Index</em>}</li>
 * <li>
 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiReferenceMoveOperationImpl#getNewIndex
 * <em>New Index</em>}</li>
 * <li>
 * {@link org.eclipse.emf.emfstore.server.model.versioning.operations.impl.MultiReferenceMoveOperationImpl#getReferencedModelElementId
 * <em>Referenced Model Element Id</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MultiReferenceMoveOperationImpl extends FeatureOperationImpl implements MultiReferenceMoveOperation {
	/**
	 * The default value of the '{@link #getOldIndex() <em>Old Index</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOldIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int OLD_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOldIndex() <em>Old Index</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOldIndex()
	 * @generated
	 * @ordered
	 */
	protected int oldIndex = OLD_INDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getNewIndex() <em>New Index</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNewIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int NEW_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNewIndex() <em>New Index</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNewIndex()
	 * @generated
	 * @ordered
	 */
	protected int newIndex = NEW_INDEX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferencedModelElementId()
	 * <em>Referenced Model Element Id</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getReferencedModelElementId()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId referencedModelElementId;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MultiReferenceMoveOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.MULTI_REFERENCE_MOVE_OPERATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getOldIndex() {
		return oldIndex;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setOldIndex(int newOldIndex) {
		int oldOldIndex = oldIndex;
		oldIndex = newOldIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OperationsPackage.MULTI_REFERENCE_MOVE_OPERATION__OLD_INDEX, oldOldIndex, oldIndex));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getNewIndex() {
		return newIndex;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setNewIndex(int newNewIndex) {
		int oldNewIndex = newIndex;
		newIndex = newNewIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OperationsPackage.MULTI_REFERENCE_MOVE_OPERATION__NEW_INDEX, oldNewIndex, newIndex));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId getReferencedModelElementId() {
		if (referencedModelElementId != null && referencedModelElementId.eIsProxy()) {
			InternalEObject oldReferencedModelElementId = (InternalEObject) referencedModelElementId;
			referencedModelElementId = (ModelElementId) eResolveProxy(oldReferencedModelElementId);
			if (referencedModelElementId != oldReferencedModelElementId) {
				InternalEObject newReferencedModelElementId = (InternalEObject) referencedModelElementId;
				NotificationChain msgs = oldReferencedModelElementId.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- OperationsPackage.MULTI_REFERENCE_MOVE_OPERATION__REFERENCED_MODEL_ELEMENT_ID, null, null);
				if (newReferencedModelElementId.eInternalContainer() == null) {
					msgs = newReferencedModelElementId.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- OperationsPackage.MULTI_REFERENCE_MOVE_OPERATION__REFERENCED_MODEL_ELEMENT_ID, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						OperationsPackage.MULTI_REFERENCE_MOVE_OPERATION__REFERENCED_MODEL_ELEMENT_ID,
						oldReferencedModelElementId, referencedModelElementId));
			}
		}
		return referencedModelElementId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId basicGetReferencedModelElementId() {
		return referencedModelElementId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetReferencedModelElementId(ModelElementId newReferencedModelElementId,
		NotificationChain msgs) {
		ModelElementId oldReferencedModelElementId = referencedModelElementId;
		referencedModelElementId = newReferencedModelElementId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				OperationsPackage.MULTI_REFERENCE_MOVE_OPERATION__REFERENCED_MODEL_ELEMENT_ID,
				oldReferencedModelElementId, newReferencedModelElementId);
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
	public void setReferencedModelElementId(ModelElementId newReferencedModelElementId) {
		if (newReferencedModelElementId != referencedModelElementId) {
			NotificationChain msgs = null;
			if (referencedModelElementId != null)
				msgs = ((InternalEObject) referencedModelElementId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- OperationsPackage.MULTI_REFERENCE_MOVE_OPERATION__REFERENCED_MODEL_ELEMENT_ID, null, msgs);
			if (newReferencedModelElementId != null)
				msgs = ((InternalEObject) newReferencedModelElementId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- OperationsPackage.MULTI_REFERENCE_MOVE_OPERATION__REFERENCED_MODEL_ELEMENT_ID, null, msgs);
			msgs = basicSetReferencedModelElementId(newReferencedModelElementId, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OperationsPackage.MULTI_REFERENCE_MOVE_OPERATION__REFERENCED_MODEL_ELEMENT_ID,
				newReferencedModelElementId, newReferencedModelElementId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case OperationsPackage.MULTI_REFERENCE_MOVE_OPERATION__REFERENCED_MODEL_ELEMENT_ID:
			return basicSetReferencedModelElementId(null, msgs);
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
		case OperationsPackage.MULTI_REFERENCE_MOVE_OPERATION__OLD_INDEX:
			return getOldIndex();
		case OperationsPackage.MULTI_REFERENCE_MOVE_OPERATION__NEW_INDEX:
			return getNewIndex();
		case OperationsPackage.MULTI_REFERENCE_MOVE_OPERATION__REFERENCED_MODEL_ELEMENT_ID:
			if (resolve)
				return getReferencedModelElementId();
			return basicGetReferencedModelElementId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case OperationsPackage.MULTI_REFERENCE_MOVE_OPERATION__OLD_INDEX:
			setOldIndex((Integer) newValue);
			return;
		case OperationsPackage.MULTI_REFERENCE_MOVE_OPERATION__NEW_INDEX:
			setNewIndex((Integer) newValue);
			return;
		case OperationsPackage.MULTI_REFERENCE_MOVE_OPERATION__REFERENCED_MODEL_ELEMENT_ID:
			setReferencedModelElementId((ModelElementId) newValue);
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
		case OperationsPackage.MULTI_REFERENCE_MOVE_OPERATION__OLD_INDEX:
			setOldIndex(OLD_INDEX_EDEFAULT);
			return;
		case OperationsPackage.MULTI_REFERENCE_MOVE_OPERATION__NEW_INDEX:
			setNewIndex(NEW_INDEX_EDEFAULT);
			return;
		case OperationsPackage.MULTI_REFERENCE_MOVE_OPERATION__REFERENCED_MODEL_ELEMENT_ID:
			setReferencedModelElementId((ModelElementId) null);
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
		case OperationsPackage.MULTI_REFERENCE_MOVE_OPERATION__OLD_INDEX:
			return oldIndex != OLD_INDEX_EDEFAULT;
		case OperationsPackage.MULTI_REFERENCE_MOVE_OPERATION__NEW_INDEX:
			return newIndex != NEW_INDEX_EDEFAULT;
		case OperationsPackage.MULTI_REFERENCE_MOVE_OPERATION__REFERENCED_MODEL_ELEMENT_ID:
			return referencedModelElementId != null;
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
		result.append(" (oldIndex: ");
		result.append(oldIndex);
		result.append(", newIndex: ");
		result.append(newIndex);
		result.append(')');
		return result.toString();
	}

	public void apply(IdEObjectCollection project) {
		EObject modelElement = project.getModelElement(getModelElementId());
		EObject referencedModelElement = project.getModelElement(getReferencedModelElementId());
		if (modelElement == null) {
			// fail silently
			return;
		}
		EReference reference;
		try {
			reference = (EReference) this.getFeature(modelElement);
		} catch (UnkownFeatureException e) {
			// fail silently
			return;
		}
		Object object = modelElement.eGet(reference);
		@SuppressWarnings("unchecked")
		EList<EObject> list = (EList<EObject>) object;
		if (getNewIndex() >= list.size() || getNewIndex() < 0 || referencedModelElement == null
			|| !list.contains(referencedModelElement)) {
			// do nothing if index out of bound or element not in list.
			return;
		}
		list.move(getNewIndex(), referencedModelElement);
	}

	/**
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.FeatureOperationImpl#canApply(org.eclipse.emf.emfstore.common.model.Project)
	 */
	@Override
	public boolean canApply(Project project) {
		if (!super.canApply(project)) {
			return false;
		}
		EObject modelElement = project.getModelElement(getModelElementId());
		if (modelElement == null) {
			return false;
		}
		EReference reference;
		try {
			reference = (EReference) this.getFeature(modelElement);
		} catch (UnkownFeatureException e) {
			// fail silently
			return false;
		}
		Object object = modelElement.eGet(reference);
		@SuppressWarnings("unchecked")
		EList<EObject> list = (EList<EObject>) object;
		if (getNewIndex() >= list.size() || getNewIndex() < 0) {
			return false;
		}
		return true;
	}

	@Override
	public String getDescription() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Moved ");
		stringBuilder.append(getFeatureName().substring(0, getFeatureName().length() - 1));
		stringBuilder.append(" from position ");
		stringBuilder.append(getOldIndex() + 1);
		stringBuilder.append(" to ");
		stringBuilder.append(getNewIndex() + 1);
		stringBuilder.append(".");
		return stringBuilder.toString();
	}

	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Changed order of ");
		stringBuilder.append(getFeatureName());
		return stringBuilder.toString();
	}

	@Override
	public AbstractOperation reverse() {
		MultiReferenceMoveOperation multiReferenceMoveOperation = OperationsFactory.eINSTANCE
			.createMultiReferenceMoveOperation();
		reverse(multiReferenceMoveOperation);
		multiReferenceMoveOperation.setNewIndex(getOldIndex());
		multiReferenceMoveOperation.setOldIndex(getNewIndex());
		multiReferenceMoveOperation.setReferencedModelElementId(ModelUtil.clone(getReferencedModelElementId()));
		return multiReferenceMoveOperation;
	}

	/**
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.impl.AbstractOperationImpl#getOtherInvolvedModelElements()
	 */
	@Override
	public Set<ModelElementId> getOtherInvolvedModelElements() {
		Set<ModelElementId> result = new HashSet<ModelElementId>();
		if (getReferencedModelElementId() != null) {
			result.add(getReferencedModelElementId());
		}
		return result;
	}

} // MultiReferenceMoveOperationImpl
