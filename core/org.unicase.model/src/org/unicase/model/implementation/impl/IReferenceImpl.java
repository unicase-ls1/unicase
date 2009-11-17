/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.implementation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.model.implementation.IClass;
import org.unicase.model.implementation.IReference;
import org.unicase.model.implementation.ImplementationPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>IReference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.model.implementation.impl.IReferenceImpl#getParentClass <em>Parent Class</em>}</li>
 * <li>{@link org.unicase.model.implementation.impl.IReferenceImpl#getType <em>Type</em>}</li>
 * <li>{@link org.unicase.model.implementation.impl.IReferenceImpl#isContainment <em>Containment</em>}</li>
 * <li>{@link org.unicase.model.implementation.impl.IReferenceImpl#getOppositeReference <em>Opposite Reference</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class IReferenceImpl extends IFeatureImpl implements IReference {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected IClass type;

	/**
	 * This is true if the Type reference has been set. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean typeESet;

	/**
	 * The default value of the '{@link #isContainment() <em>Containment</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isContainment()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONTAINMENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isContainment() <em>Containment</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isContainment()
	 * @generated
	 * @ordered
	 */
	protected boolean containment = CONTAINMENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOppositeReference() <em>Opposite Reference</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOppositeReference()
	 * @generated
	 * @ordered
	 */
	protected IReference oppositeReference;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImplementationPackage.Literals.IREFERENCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IClass getParentClass() {
		if (eContainerFeatureID() != ImplementationPackage.IREFERENCE__PARENT_CLASS)
			return null;
		return (IClass) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IClass basicGetParentClass() {
		if (eContainerFeatureID() != ImplementationPackage.IREFERENCE__PARENT_CLASS)
			return null;
		return (IClass) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetParentClass(IClass newParentClass, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParentClass, ImplementationPackage.IREFERENCE__PARENT_CLASS,
			msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParentClass(IClass newParentClass) {
		if (newParentClass != eInternalContainer()
			|| (eContainerFeatureID() != ImplementationPackage.IREFERENCE__PARENT_CLASS && newParentClass != null)) {
			if (EcoreUtil.isAncestor(this, newParentClass))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentClass != null)
				msgs = ((InternalEObject) newParentClass).eInverseAdd(this,
					ImplementationPackage.ICLASS__OUTGOING_REFERENCES, IClass.class, msgs);
			msgs = basicSetParentClass(newParentClass, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.IREFERENCE__PARENT_CLASS,
				newParentClass, newParentClass));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IClass getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject) type;
			type = (IClass) eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImplementationPackage.IREFERENCE__TYPE,
						oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IClass basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetType(IClass newType, NotificationChain msgs) {
		IClass oldType = type;
		type = newType;
		boolean oldTypeESet = typeESet;
		typeESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				ImplementationPackage.IREFERENCE__TYPE, oldType, newType, !oldTypeESet);
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
	public void setType(IClass newType) {
		if (newType != type) {
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject) type).eInverseRemove(this, ImplementationPackage.ICLASS__INCOMING_REFERENCES,
					IClass.class, msgs);
			if (newType != null)
				msgs = ((InternalEObject) newType).eInverseAdd(this, ImplementationPackage.ICLASS__INCOMING_REFERENCES,
					IClass.class, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else {
			boolean oldTypeESet = typeESet;
			typeESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.IREFERENCE__TYPE, newType,
					newType, !oldTypeESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicUnsetType(NotificationChain msgs) {
		IClass oldType = type;
		type = null;
		boolean oldTypeESet = typeESet;
		typeESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET,
				ImplementationPackage.IREFERENCE__TYPE, oldType, null, oldTypeESet);
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
	public void unsetType() {
		if (type != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject) type).eInverseRemove(this, ImplementationPackage.ICLASS__INCOMING_REFERENCES,
				IClass.class, msgs);
			msgs = basicUnsetType(msgs);
			if (msgs != null)
				msgs.dispatch();
		} else {
			boolean oldTypeESet = typeESet;
			typeESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, ImplementationPackage.IREFERENCE__TYPE, null,
					null, oldTypeESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetType() {
		return typeESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isContainment() {
		return containment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setContainment(boolean newContainment) {
		boolean oldContainment = containment;
		containment = newContainment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.IREFERENCE__CONTAINMENT,
				oldContainment, containment));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IReference getOppositeReference() {
		if (oppositeReference != null && oppositeReference.eIsProxy()) {
			InternalEObject oldOppositeReference = (InternalEObject) oppositeReference;
			oppositeReference = (IReference) eResolveProxy(oldOppositeReference);
			if (oppositeReference != oldOppositeReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						ImplementationPackage.IREFERENCE__OPPOSITE_REFERENCE, oldOppositeReference, oppositeReference));
			}
		}
		return oppositeReference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IReference basicGetOppositeReference() {
		return oppositeReference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setOppositeReference(IReference newOppositeReference) {
		IReference oldOppositeReference = oppositeReference;
		oppositeReference = newOppositeReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.IREFERENCE__OPPOSITE_REFERENCE,
				oldOppositeReference, oppositeReference));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ImplementationPackage.IREFERENCE__PARENT_CLASS:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParentClass((IClass) otherEnd, msgs);
		case ImplementationPackage.IREFERENCE__TYPE:
			if (type != null)
				msgs = ((InternalEObject) type).eInverseRemove(this, ImplementationPackage.ICLASS__INCOMING_REFERENCES,
					IClass.class, msgs);
			return basicSetType((IClass) otherEnd, msgs);
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
		case ImplementationPackage.IREFERENCE__PARENT_CLASS:
			return basicSetParentClass(null, msgs);
		case ImplementationPackage.IREFERENCE__TYPE:
			return basicUnsetType(msgs);
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
		case ImplementationPackage.IREFERENCE__PARENT_CLASS:
			return eInternalContainer().eInverseRemove(this, ImplementationPackage.ICLASS__OUTGOING_REFERENCES,
				IClass.class, msgs);
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
		case ImplementationPackage.IREFERENCE__PARENT_CLASS:
			if (resolve)
				return getParentClass();
			return basicGetParentClass();
		case ImplementationPackage.IREFERENCE__TYPE:
			if (resolve)
				return getType();
			return basicGetType();
		case ImplementationPackage.IREFERENCE__CONTAINMENT:
			return isContainment();
		case ImplementationPackage.IREFERENCE__OPPOSITE_REFERENCE:
			if (resolve)
				return getOppositeReference();
			return basicGetOppositeReference();
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
		case ImplementationPackage.IREFERENCE__PARENT_CLASS:
			setParentClass((IClass) newValue);
			return;
		case ImplementationPackage.IREFERENCE__TYPE:
			setType((IClass) newValue);
			return;
		case ImplementationPackage.IREFERENCE__CONTAINMENT:
			setContainment((Boolean) newValue);
			return;
		case ImplementationPackage.IREFERENCE__OPPOSITE_REFERENCE:
			setOppositeReference((IReference) newValue);
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
		case ImplementationPackage.IREFERENCE__PARENT_CLASS:
			setParentClass((IClass) null);
			return;
		case ImplementationPackage.IREFERENCE__TYPE:
			unsetType();
			return;
		case ImplementationPackage.IREFERENCE__CONTAINMENT:
			setContainment(CONTAINMENT_EDEFAULT);
			return;
		case ImplementationPackage.IREFERENCE__OPPOSITE_REFERENCE:
			setOppositeReference((IReference) null);
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
		case ImplementationPackage.IREFERENCE__PARENT_CLASS:
			return basicGetParentClass() != null;
		case ImplementationPackage.IREFERENCE__TYPE:
			return isSetType();
		case ImplementationPackage.IREFERENCE__CONTAINMENT:
			return containment != CONTAINMENT_EDEFAULT;
		case ImplementationPackage.IREFERENCE__OPPOSITE_REFERENCE:
			return oppositeReference != null;
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
		result.append(" (containment: ");
		result.append(containment);
		result.append(')');
		return result.toString();
	}

} // IReferenceImpl
