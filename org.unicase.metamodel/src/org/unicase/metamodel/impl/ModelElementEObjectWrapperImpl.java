/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel.impl;

import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.ModelElementEObjectWrapper;
import org.unicase.metamodel.util.ModelUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Model Element EObject Wrapper</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.metamodel.impl.ModelElementEObjectWrapperImpl#getWrappedEObject <em>Wrapped EObject</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ModelElementEObjectWrapperImpl extends ModelElementImpl implements ModelElementEObjectWrapper {
	// @Override
	// public void eSet(EStructuralFeature eFeature, Object newValue) {
	// try {
	// getWrappedEObject().eSet(eFeature, newValue);
	// } catch (IllegalArgumentException e) {
	// // feature was not found, probably it is a feature of this object's class and not of the wrapped object's
	// // class
	// super.eSet(eFeature, newValue);
	// }
	// }
	//
	// @Override
	// public Object eGet(EStructuralFeature eFeature, boolean resolve) {
	// try {
	// return getWrappedEObject().eGet(eFeature, resolve);
	// } catch (IllegalArgumentException e) {
	// // feature was not found, probably it is a feature of this object's class and not of the wrapped object's
	// // class
	// return super.eGet(eFeature, resolve);
	// }
	// }

	/**
	 * The cached value of the '{@link #getWrappedEObject() <em>Wrapped EObject</em>}' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getWrappedEObject()
	 * @generated
	 * @ordered
	 */
	protected EObject wrappedEObject;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ModelElementEObjectWrapperImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetamodelPackage.Literals.MODEL_ELEMENT_EOBJECT_WRAPPER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EObject getWrappedEObject() {
		if (wrappedEObject != null && wrappedEObject.eIsProxy()) {
			InternalEObject oldWrappedEObject = (InternalEObject) wrappedEObject;
			wrappedEObject = eResolveProxy(oldWrappedEObject);
			if (wrappedEObject != oldWrappedEObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						MetamodelPackage.MODEL_ELEMENT_EOBJECT_WRAPPER__WRAPPED_EOBJECT, oldWrappedEObject,
						wrappedEObject));
			}
		}
		return wrappedEObject;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EObject basicGetWrappedEObject() {
		return wrappedEObject;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setWrappedEObject(EObject newWrappedEObject) {
		EObject oldWrappedEObject = wrappedEObject;
		wrappedEObject = newWrappedEObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				MetamodelPackage.MODEL_ELEMENT_EOBJECT_WRAPPER__WRAPPED_EOBJECT, oldWrappedEObject, wrappedEObject));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MetamodelPackage.MODEL_ELEMENT_EOBJECT_WRAPPER__WRAPPED_EOBJECT:
			if (resolve)
				return getWrappedEObject();
			return basicGetWrappedEObject();
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
		case MetamodelPackage.MODEL_ELEMENT_EOBJECT_WRAPPER__WRAPPED_EOBJECT:
			setWrappedEObject((EObject) newValue);
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
		case MetamodelPackage.MODEL_ELEMENT_EOBJECT_WRAPPER__WRAPPED_EOBJECT:
			setWrappedEObject((EObject) null);
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
		case MetamodelPackage.MODEL_ELEMENT_EOBJECT_WRAPPER__WRAPPED_EOBJECT:
			return wrappedEObject != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.UnicaseModelElement#getAllContainedModelElements()
	 */
	@Override
	public Set<EObject> getAllContainedModelElements(boolean includeTransientContainments) {
		return ModelUtil.getAllContainedModelElements(this.getWrappedEObject(), includeTransientContainments);
	}

} // ModelElementEObjectWrapperImpl
