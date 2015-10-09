/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.document.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.DocumentPackage;
import org.unicase.model.document.LeafSection;
import org.unicase.model.impl.UnicaseModelElementImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Leaf Section</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.document.impl.LeafSectionImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.unicase.model.document.impl.LeafSectionImpl#getModelElements <em>Model Elements</em>}</li>
 *   <li>{@link org.unicase.model.document.impl.LeafSectionImpl#getReferencedModelElements <em>Referenced Model Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LeafSectionImpl extends UnicaseModelElementImpl implements
		LeafSection {
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
	 * The cached value of the '{@link #getReferencedModelElements() <em>Referenced Model Elements</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getReferencedModelElements()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> referencedModelElements;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected LeafSectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DocumentPackage.Literals.LEAF_SECTION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeSection getParent() {
		if (eContainerFeatureID() != DocumentPackage.LEAF_SECTION__PARENT)
			return null;
		return (CompositeSection) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeSection basicGetParent() {
		if (eContainerFeatureID() != DocumentPackage.LEAF_SECTION__PARENT)
			return null;
		return (CompositeSection) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(CompositeSection newParent,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParent,
				DocumentPackage.LEAF_SECTION__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(CompositeSection newParent) {
		if (newParent != eInternalContainer()
				|| (eContainerFeatureID() != DocumentPackage.LEAF_SECTION__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject) newParent).eInverseAdd(this,
						DocumentPackage.COMPOSITE_SECTION__SUBSECTIONS,
						CompositeSection.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DocumentPackage.LEAF_SECTION__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getModelElements() {
		if (modelElements == null) {
			modelElements = new EObjectContainmentEList.Resolving<EObject>(
					EObject.class, this,
					DocumentPackage.LEAF_SECTION__MODEL_ELEMENTS);
		}
		return modelElements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getReferencedModelElements() {
		if (referencedModelElements == null) {
			referencedModelElements = new EObjectResolvingEList<EObject>(
					EObject.class, this,
					DocumentPackage.LEAF_SECTION__REFERENCED_MODEL_ELEMENTS);
		}
		return referencedModelElements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DocumentPackage.LEAF_SECTION__PARENT:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParent((CompositeSection) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DocumentPackage.LEAF_SECTION__PARENT:
			return basicSetParent(null, msgs);
		case DocumentPackage.LEAF_SECTION__MODEL_ELEMENTS:
			return ((InternalEList<?>) getModelElements()).basicRemove(
					otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case DocumentPackage.LEAF_SECTION__PARENT:
			return eInternalContainer().eInverseRemove(this,
					DocumentPackage.COMPOSITE_SECTION__SUBSECTIONS,
					CompositeSection.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case DocumentPackage.LEAF_SECTION__PARENT:
			if (resolve)
				return getParent();
			return basicGetParent();
		case DocumentPackage.LEAF_SECTION__MODEL_ELEMENTS:
			return getModelElements();
		case DocumentPackage.LEAF_SECTION__REFERENCED_MODEL_ELEMENTS:
			return getReferencedModelElements();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case DocumentPackage.LEAF_SECTION__PARENT:
			setParent((CompositeSection) newValue);
			return;
		case DocumentPackage.LEAF_SECTION__MODEL_ELEMENTS:
			getModelElements().clear();
			getModelElements().addAll((Collection<? extends EObject>) newValue);
			return;
		case DocumentPackage.LEAF_SECTION__REFERENCED_MODEL_ELEMENTS:
			getReferencedModelElements().clear();
			getReferencedModelElements().addAll(
					(Collection<? extends EObject>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case DocumentPackage.LEAF_SECTION__PARENT:
			setParent((CompositeSection) null);
			return;
		case DocumentPackage.LEAF_SECTION__MODEL_ELEMENTS:
			getModelElements().clear();
			return;
		case DocumentPackage.LEAF_SECTION__REFERENCED_MODEL_ELEMENTS:
			getReferencedModelElements().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case DocumentPackage.LEAF_SECTION__PARENT:
			return basicGetParent() != null;
		case DocumentPackage.LEAF_SECTION__MODEL_ELEMENTS:
			return modelElements != null && !modelElements.isEmpty();
		case DocumentPackage.LEAF_SECTION__REFERENCED_MODEL_ELEMENTS:
			return referencedModelElements != null
					&& !referencedModelElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // LeafSectionImpl
