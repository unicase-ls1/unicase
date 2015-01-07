/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.Attachment;
import org.unicase.model.ModelPackage;
import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Attachment</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.model.impl.AttachmentImpl#getReferringModelElements <em>Referring Model Elements</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class AttachmentImpl extends UnicaseModelElementImpl implements Attachment {
	/**
	 * The cached value of the '{@link #getReferringModelElements() <em>Referring Model Elements</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getReferringModelElements()
	 * @generated
	 * @ordered
	 */
	protected EList<UnicaseModelElement> referringModelElements;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AttachmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ATTACHMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<UnicaseModelElement> getReferringModelElements() {
		if (referringModelElements == null) {
			referringModelElements = new EObjectWithInverseResolvingEList.ManyInverse<UnicaseModelElement>(
				UnicaseModelElement.class, this, ModelPackage.ATTACHMENT__REFERRING_MODEL_ELEMENTS,
				ModelPackage.UNICASE_MODEL_ELEMENT__ATTACHMENTS);
		}
		return referringModelElements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ModelPackage.ATTACHMENT__REFERRING_MODEL_ELEMENTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getReferringModelElements()).basicAdd(otherEnd,
				msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ModelPackage.ATTACHMENT__REFERRING_MODEL_ELEMENTS:
			return ((InternalEList<?>) getReferringModelElements()).basicRemove(otherEnd, msgs);
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
		case ModelPackage.ATTACHMENT__REFERRING_MODEL_ELEMENTS:
			return getReferringModelElements();
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
		case ModelPackage.ATTACHMENT__REFERRING_MODEL_ELEMENTS:
			getReferringModelElements().clear();
			getReferringModelElements().addAll((Collection<? extends UnicaseModelElement>) newValue);
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
		case ModelPackage.ATTACHMENT__REFERRING_MODEL_ELEMENTS:
			getReferringModelElements().clear();
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
		case ModelPackage.ATTACHMENT__REFERRING_MODEL_ELEMENTS:
			return referringModelElements != null && !referringModelElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // AttachmentImpl
