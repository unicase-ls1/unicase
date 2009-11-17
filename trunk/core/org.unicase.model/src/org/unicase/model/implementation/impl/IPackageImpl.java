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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.impl.UnicaseModelElementImpl;
import org.unicase.model.implementation.IClass;
import org.unicase.model.implementation.IEnumeration;
import org.unicase.model.implementation.IPackage;
import org.unicase.model.implementation.ImplementationPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>IPackage</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.model.implementation.impl.IPackageImpl#getNamespace <em>Namespace</em>}</li>
 * <li>{@link org.unicase.model.implementation.impl.IPackageImpl#getParentPackage <em>Parent Package</em>}</li>
 * <li>{@link org.unicase.model.implementation.impl.IPackageImpl#getSubPackages <em>Sub Packages</em>}</li>
 * <li>{@link org.unicase.model.implementation.impl.IPackageImpl#getClasses <em>Classes</em>}</li>
 * <li>{@link org.unicase.model.implementation.impl.IPackageImpl#getEnumerations <em>Enumerations</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class IPackageImpl extends UnicaseModelElementImpl implements IPackage {
	/**
	 * The default value of the '{@link #getNamespace() <em>Namespace</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected static final String NAMESPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNamespace() <em>Namespace</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected String namespace = NAMESPACE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSubPackages() <em>Sub Packages</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSubPackages()
	 * @generated
	 * @ordered
	 */
	protected EList<IPackage> subPackages;

	/**
	 * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<IClass> classes;

	/**
	 * The cached value of the '{@link #getEnumerations() <em>Enumerations</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEnumerations()
	 * @generated
	 * @ordered
	 */
	protected EList<IEnumeration> enumerations;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IPackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImplementationPackage.Literals.IPACKAGE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setNamespace(String newNamespace) {
		String oldNamespace = namespace;
		namespace = newNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.IPACKAGE__NAMESPACE,
				oldNamespace, namespace));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IPackage getParentPackage() {
		if (eContainerFeatureID() != ImplementationPackage.IPACKAGE__PARENT_PACKAGE)
			return null;
		return (IPackage) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IPackage basicGetParentPackage() {
		if (eContainerFeatureID() != ImplementationPackage.IPACKAGE__PARENT_PACKAGE)
			return null;
		return (IPackage) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetParentPackage(IPackage newParentPackage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParentPackage, ImplementationPackage.IPACKAGE__PARENT_PACKAGE,
			msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParentPackage(IPackage newParentPackage) {
		if (newParentPackage != eInternalContainer()
			|| (eContainerFeatureID() != ImplementationPackage.IPACKAGE__PARENT_PACKAGE && newParentPackage != null)) {
			if (EcoreUtil.isAncestor(this, newParentPackage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentPackage != null)
				msgs = ((InternalEObject) newParentPackage).eInverseAdd(this,
					ImplementationPackage.IPACKAGE__SUB_PACKAGES, IPackage.class, msgs);
			msgs = basicSetParentPackage(newParentPackage, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.IPACKAGE__PARENT_PACKAGE,
				newParentPackage, newParentPackage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<IPackage> getSubPackages() {
		if (subPackages == null) {
			subPackages = new EObjectContainmentWithInverseEList.Resolving<IPackage>(IPackage.class, this,
				ImplementationPackage.IPACKAGE__SUB_PACKAGES, ImplementationPackage.IPACKAGE__PARENT_PACKAGE);
		}
		return subPackages;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<IClass> getClasses() {
		if (classes == null) {
			classes = new EObjectContainmentWithInverseEList.Resolving<IClass>(IClass.class, this,
				ImplementationPackage.IPACKAGE__CLASSES, ImplementationPackage.ICLASS__PARENT_PACKAGE);
		}
		return classes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<IEnumeration> getEnumerations() {
		if (enumerations == null) {
			enumerations = new EObjectContainmentWithInverseEList.Resolving<IEnumeration>(IEnumeration.class, this,
				ImplementationPackage.IPACKAGE__ENUMERATIONS, ImplementationPackage.IENUMERATION__PARENT_PACKAGE);
		}
		return enumerations;
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
		case ImplementationPackage.IPACKAGE__PARENT_PACKAGE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParentPackage((IPackage) otherEnd, msgs);
		case ImplementationPackage.IPACKAGE__SUB_PACKAGES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSubPackages()).basicAdd(otherEnd, msgs);
		case ImplementationPackage.IPACKAGE__CLASSES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getClasses()).basicAdd(otherEnd, msgs);
		case ImplementationPackage.IPACKAGE__ENUMERATIONS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getEnumerations()).basicAdd(otherEnd, msgs);
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
		case ImplementationPackage.IPACKAGE__PARENT_PACKAGE:
			return basicSetParentPackage(null, msgs);
		case ImplementationPackage.IPACKAGE__SUB_PACKAGES:
			return ((InternalEList<?>) getSubPackages()).basicRemove(otherEnd, msgs);
		case ImplementationPackage.IPACKAGE__CLASSES:
			return ((InternalEList<?>) getClasses()).basicRemove(otherEnd, msgs);
		case ImplementationPackage.IPACKAGE__ENUMERATIONS:
			return ((InternalEList<?>) getEnumerations()).basicRemove(otherEnd, msgs);
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
		case ImplementationPackage.IPACKAGE__PARENT_PACKAGE:
			return eInternalContainer().eInverseRemove(this, ImplementationPackage.IPACKAGE__SUB_PACKAGES,
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
		case ImplementationPackage.IPACKAGE__NAMESPACE:
			return getNamespace();
		case ImplementationPackage.IPACKAGE__PARENT_PACKAGE:
			if (resolve)
				return getParentPackage();
			return basicGetParentPackage();
		case ImplementationPackage.IPACKAGE__SUB_PACKAGES:
			return getSubPackages();
		case ImplementationPackage.IPACKAGE__CLASSES:
			return getClasses();
		case ImplementationPackage.IPACKAGE__ENUMERATIONS:
			return getEnumerations();
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
		case ImplementationPackage.IPACKAGE__NAMESPACE:
			setNamespace((String) newValue);
			return;
		case ImplementationPackage.IPACKAGE__PARENT_PACKAGE:
			setParentPackage((IPackage) newValue);
			return;
		case ImplementationPackage.IPACKAGE__SUB_PACKAGES:
			getSubPackages().clear();
			getSubPackages().addAll((Collection<? extends IPackage>) newValue);
			return;
		case ImplementationPackage.IPACKAGE__CLASSES:
			getClasses().clear();
			getClasses().addAll((Collection<? extends IClass>) newValue);
			return;
		case ImplementationPackage.IPACKAGE__ENUMERATIONS:
			getEnumerations().clear();
			getEnumerations().addAll((Collection<? extends IEnumeration>) newValue);
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
		case ImplementationPackage.IPACKAGE__NAMESPACE:
			setNamespace(NAMESPACE_EDEFAULT);
			return;
		case ImplementationPackage.IPACKAGE__PARENT_PACKAGE:
			setParentPackage((IPackage) null);
			return;
		case ImplementationPackage.IPACKAGE__SUB_PACKAGES:
			getSubPackages().clear();
			return;
		case ImplementationPackage.IPACKAGE__CLASSES:
			getClasses().clear();
			return;
		case ImplementationPackage.IPACKAGE__ENUMERATIONS:
			getEnumerations().clear();
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
		case ImplementationPackage.IPACKAGE__NAMESPACE:
			return NAMESPACE_EDEFAULT == null ? namespace != null : !NAMESPACE_EDEFAULT.equals(namespace);
		case ImplementationPackage.IPACKAGE__PARENT_PACKAGE:
			return basicGetParentPackage() != null;
		case ImplementationPackage.IPACKAGE__SUB_PACKAGES:
			return subPackages != null && !subPackages.isEmpty();
		case ImplementationPackage.IPACKAGE__CLASSES:
			return classes != null && !classes.isEmpty();
		case ImplementationPackage.IPACKAGE__ENUMERATIONS:
			return enumerations != null && !enumerations.isEmpty();
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
		result.append(" (namespace: ");
		result.append(namespace);
		result.append(')');
		return result.toString();
	}

} // IPackageImpl
