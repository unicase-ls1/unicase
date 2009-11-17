/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations.semantic.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.ExtractToSuperclassOperation;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticPackage;
import org.unicase.metamodel.ModelElementId;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Extract To Superclass Operation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.unicase.emfstore.esmodel.versioning.operations.semantic.impl.ExtractToSuperclassOperationImpl#getSuperClassName
 * <em>Super Class Name</em>}</li>
 * <li>
 * {@link org.unicase.emfstore.esmodel.versioning.operations.semantic.impl.ExtractToSuperclassOperationImpl#getSubClasses
 * <em>Sub Classes</em>}</li>
 * <li>
 * {@link org.unicase.emfstore.esmodel.versioning.operations.semantic.impl.ExtractToSuperclassOperationImpl#getFeatures
 * <em>Features</em>}</li>
 * <li>
 * {@link org.unicase.emfstore.esmodel.versioning.operations.semantic.impl.ExtractToSuperclassOperationImpl#getTargetPackage
 * <em>Target Package</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ExtractToSuperclassOperationImpl extends SemanticCompositeOperationImpl implements
	ExtractToSuperclassOperation {
	/**
	 * The default value of the '{@link #getSuperClassName() <em>Super Class Name</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getSuperClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String SUPER_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuperClassName() <em>Super Class Name</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getSuperClassName()
	 * @generated
	 * @ordered
	 */
	protected String superClassName = SUPER_CLASS_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSubClasses() <em>Sub Classes</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSubClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElementId> subClasses;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElementId> features;

	/**
	 * The cached value of the '{@link #getTargetPackage() <em>Target Package</em>}' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTargetPackage()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId targetPackage;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ExtractToSuperclassOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticPackage.Literals.EXTRACT_TO_SUPERCLASS_OPERATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getSuperClassName() {
		return superClassName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSuperClassName(String newSuperClassName) {
		String oldSuperClassName = superClassName;
		superClassName = newSuperClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				SemanticPackage.EXTRACT_TO_SUPERCLASS_OPERATION__SUPER_CLASS_NAME, oldSuperClassName, superClassName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ModelElementId> getSubClasses() {
		if (subClasses == null) {
			subClasses = new EObjectContainmentEList.Resolving<ModelElementId>(ModelElementId.class, this,
				SemanticPackage.EXTRACT_TO_SUPERCLASS_OPERATION__SUB_CLASSES);
		}
		return subClasses;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ModelElementId> getFeatures() {
		if (features == null) {
			features = new EObjectResolvingEList<ModelElementId>(ModelElementId.class, this,
				SemanticPackage.EXTRACT_TO_SUPERCLASS_OPERATION__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId getTargetPackage() {
		if (targetPackage != null && targetPackage.eIsProxy()) {
			InternalEObject oldTargetPackage = (InternalEObject) targetPackage;
			targetPackage = (ModelElementId) eResolveProxy(oldTargetPackage);
			if (targetPackage != oldTargetPackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						SemanticPackage.EXTRACT_TO_SUPERCLASS_OPERATION__TARGET_PACKAGE, oldTargetPackage,
						targetPackage));
			}
		}
		return targetPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId basicGetTargetPackage() {
		return targetPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTargetPackage(ModelElementId newTargetPackage) {
		ModelElementId oldTargetPackage = targetPackage;
		targetPackage = newTargetPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				SemanticPackage.EXTRACT_TO_SUPERCLASS_OPERATION__TARGET_PACKAGE, oldTargetPackage, targetPackage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SemanticPackage.EXTRACT_TO_SUPERCLASS_OPERATION__SUB_CLASSES:
			return ((InternalEList<?>) getSubClasses()).basicRemove(otherEnd, msgs);
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
		case SemanticPackage.EXTRACT_TO_SUPERCLASS_OPERATION__SUPER_CLASS_NAME:
			return getSuperClassName();
		case SemanticPackage.EXTRACT_TO_SUPERCLASS_OPERATION__SUB_CLASSES:
			return getSubClasses();
		case SemanticPackage.EXTRACT_TO_SUPERCLASS_OPERATION__FEATURES:
			return getFeatures();
		case SemanticPackage.EXTRACT_TO_SUPERCLASS_OPERATION__TARGET_PACKAGE:
			if (resolve)
				return getTargetPackage();
			return basicGetTargetPackage();
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
		case SemanticPackage.EXTRACT_TO_SUPERCLASS_OPERATION__SUPER_CLASS_NAME:
			setSuperClassName((String) newValue);
			return;
		case SemanticPackage.EXTRACT_TO_SUPERCLASS_OPERATION__SUB_CLASSES:
			getSubClasses().clear();
			getSubClasses().addAll((Collection<? extends ModelElementId>) newValue);
			return;
		case SemanticPackage.EXTRACT_TO_SUPERCLASS_OPERATION__FEATURES:
			getFeatures().clear();
			getFeatures().addAll((Collection<? extends ModelElementId>) newValue);
			return;
		case SemanticPackage.EXTRACT_TO_SUPERCLASS_OPERATION__TARGET_PACKAGE:
			setTargetPackage((ModelElementId) newValue);
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
		case SemanticPackage.EXTRACT_TO_SUPERCLASS_OPERATION__SUPER_CLASS_NAME:
			setSuperClassName(SUPER_CLASS_NAME_EDEFAULT);
			return;
		case SemanticPackage.EXTRACT_TO_SUPERCLASS_OPERATION__SUB_CLASSES:
			getSubClasses().clear();
			return;
		case SemanticPackage.EXTRACT_TO_SUPERCLASS_OPERATION__FEATURES:
			getFeatures().clear();
			return;
		case SemanticPackage.EXTRACT_TO_SUPERCLASS_OPERATION__TARGET_PACKAGE:
			setTargetPackage((ModelElementId) null);
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
		case SemanticPackage.EXTRACT_TO_SUPERCLASS_OPERATION__SUPER_CLASS_NAME:
			return SUPER_CLASS_NAME_EDEFAULT == null ? superClassName != null : !SUPER_CLASS_NAME_EDEFAULT
				.equals(superClassName);
		case SemanticPackage.EXTRACT_TO_SUPERCLASS_OPERATION__SUB_CLASSES:
			return subClasses != null && !subClasses.isEmpty();
		case SemanticPackage.EXTRACT_TO_SUPERCLASS_OPERATION__FEATURES:
			return features != null && !features.isEmpty();
		case SemanticPackage.EXTRACT_TO_SUPERCLASS_OPERATION__TARGET_PACKAGE:
			return targetPackage != null;
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
		result.append(" (superClassName: ");
		result.append(superClassName);
		result.append(')');
		return result.toString();
	}

} // ExtractToSuperclassOperationImpl
