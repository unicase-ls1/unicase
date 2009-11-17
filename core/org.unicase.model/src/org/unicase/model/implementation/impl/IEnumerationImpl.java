/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.implementation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.impl.UnicaseModelElementImpl;
import org.unicase.model.implementation.IAttribute;
import org.unicase.model.implementation.IEnumeration;
import org.unicase.model.implementation.ILiteral;
import org.unicase.model.implementation.IPackage;
import org.unicase.model.implementation.ImplementationPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>IEnumeration</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.model.implementation.impl.IEnumerationImpl#getParentPackage <em>Parent Package</em>}</li>
 * <li>{@link org.unicase.model.implementation.impl.IEnumerationImpl#getLiterals <em>Literals</em>}</li>
 * <li>{@link org.unicase.model.implementation.impl.IEnumerationImpl#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class IEnumerationImpl extends UnicaseModelElementImpl implements IEnumeration {
	/**
	 * The cached value of the '{@link #getLiterals() <em>Literals</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLiterals()
	 * @generated
	 * @ordered
	 */
	protected EList<ILiteral> literals;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<IAttribute> attributes;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IEnumerationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImplementationPackage.Literals.IENUMERATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IPackage getParentPackage() {
		if (eContainerFeatureID() != ImplementationPackage.IENUMERATION__PARENT_PACKAGE)
			return null;
		return (IPackage) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IPackage basicGetParentPackage() {
		if (eContainerFeatureID() != ImplementationPackage.IENUMERATION__PARENT_PACKAGE)
			return null;
		return (IPackage) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetParentPackage(IPackage newParentPackage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParentPackage,
			ImplementationPackage.IENUMERATION__PARENT_PACKAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParentPackage(IPackage newParentPackage) {
		if (newParentPackage != eInternalContainer()
			|| (eContainerFeatureID() != ImplementationPackage.IENUMERATION__PARENT_PACKAGE && newParentPackage != null)) {
			if (EcoreUtil.isAncestor(this, newParentPackage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentPackage != null)
				msgs = ((InternalEObject) newParentPackage).eInverseAdd(this,
					ImplementationPackage.IPACKAGE__ENUMERATIONS, IPackage.class, msgs);
			msgs = basicSetParentPackage(newParentPackage, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.IENUMERATION__PARENT_PACKAGE,
				newParentPackage, newParentPackage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ILiteral> getLiterals() {
		if (literals == null) {
			literals = new EObjectContainmentWithInverseEList<ILiteral>(ILiteral.class, this,
				ImplementationPackage.IENUMERATION__LITERALS, ImplementationPackage.ILITERAL__PARENT_ENUMERATION);
		}
		return literals;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<IAttribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectWithInverseResolvingEList<IAttribute>(IAttribute.class, this,
				ImplementationPackage.IENUMERATION__ATTRIBUTES, ImplementationPackage.IATTRIBUTE__ENUMERATION);
		}
		return attributes;
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
		case ImplementationPackage.IENUMERATION__PARENT_PACKAGE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParentPackage((IPackage) otherEnd, msgs);
		case ImplementationPackage.IENUMERATION__LITERALS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getLiterals()).basicAdd(otherEnd, msgs);
		case ImplementationPackage.IENUMERATION__ATTRIBUTES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getAttributes()).basicAdd(otherEnd, msgs);
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
		case ImplementationPackage.IENUMERATION__PARENT_PACKAGE:
			return basicSetParentPackage(null, msgs);
		case ImplementationPackage.IENUMERATION__LITERALS:
			return ((InternalEList<?>) getLiterals()).basicRemove(otherEnd, msgs);
		case ImplementationPackage.IENUMERATION__ATTRIBUTES:
			return ((InternalEList<?>) getAttributes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case ImplementationPackage.IENUMERATION__PARENT_PACKAGE:
			return eInternalContainer().eInverseRemove(this, ImplementationPackage.IPACKAGE__ENUMERATIONS,
				IPackage.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ImplementationPackage.IENUMERATION__PARENT_PACKAGE:
			if (resolve)
				return getParentPackage();
			return basicGetParentPackage();
		case ImplementationPackage.IENUMERATION__LITERALS:
			return getLiterals();
		case ImplementationPackage.IENUMERATION__ATTRIBUTES:
			return getAttributes();
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
		case ImplementationPackage.IENUMERATION__PARENT_PACKAGE:
			setParentPackage((IPackage) newValue);
			return;
		case ImplementationPackage.IENUMERATION__LITERALS:
			getLiterals().clear();
			getLiterals().addAll((Collection<? extends ILiteral>) newValue);
			return;
		case ImplementationPackage.IENUMERATION__ATTRIBUTES:
			getAttributes().clear();
			getAttributes().addAll((Collection<? extends IAttribute>) newValue);
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
		case ImplementationPackage.IENUMERATION__PARENT_PACKAGE:
			setParentPackage((IPackage) null);
			return;
		case ImplementationPackage.IENUMERATION__LITERALS:
			getLiterals().clear();
			return;
		case ImplementationPackage.IENUMERATION__ATTRIBUTES:
			getAttributes().clear();
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
		case ImplementationPackage.IENUMERATION__PARENT_PACKAGE:
			return basicGetParentPackage() != null;
		case ImplementationPackage.IENUMERATION__LITERALS:
			return literals != null && !literals.isEmpty();
		case ImplementationPackage.IENUMERATION__ATTRIBUTES:
			return attributes != null && !attributes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // IEnumerationImpl
