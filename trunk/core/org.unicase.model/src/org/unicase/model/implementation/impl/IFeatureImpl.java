/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.implementation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.model.impl.UnicaseModelElementImpl;
import org.unicase.model.implementation.IFeature;
import org.unicase.model.implementation.ImplementationPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>IFeature</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.model.implementation.impl.IFeatureImpl#getMinimumMultiplicity <em>Minimum Multiplicity</em>}</li>
 * <li>{@link org.unicase.model.implementation.impl.IFeatureImpl#getMaximumMultiplicity <em>Maximum Multiplicity</em>}</li>
 * <li>{@link org.unicase.model.implementation.impl.IFeatureImpl#isTransient <em>Transient</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class IFeatureImpl extends UnicaseModelElementImpl implements IFeature {
	/**
	 * The default value of the '{@link #getMinimumMultiplicity() <em>Minimum Multiplicity</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMinimumMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected static final int MINIMUM_MULTIPLICITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMinimumMultiplicity() <em>Minimum Multiplicity</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMinimumMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected int minimumMultiplicity = MINIMUM_MULTIPLICITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumMultiplicity() <em>Maximum Multiplicity</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMaximumMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected static final int MAXIMUM_MULTIPLICITY_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getMaximumMultiplicity() <em>Maximum Multiplicity</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMaximumMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected int maximumMultiplicity = MAXIMUM_MULTIPLICITY_EDEFAULT;

	/**
	 * The default value of the '{@link #isTransient() <em>Transient</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isTransient()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRANSIENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTransient() <em>Transient</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isTransient()
	 * @generated
	 * @ordered
	 */
	protected boolean transient_ = TRANSIENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImplementationPackage.Literals.IFEATURE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getMinimumMultiplicity() {
		return minimumMultiplicity;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setMinimumMultiplicity(int newMinimumMultiplicity) {
		int oldMinimumMultiplicity = minimumMultiplicity;
		minimumMultiplicity = newMinimumMultiplicity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.IFEATURE__MINIMUM_MULTIPLICITY,
				oldMinimumMultiplicity, minimumMultiplicity));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getMaximumMultiplicity() {
		return maximumMultiplicity;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setMaximumMultiplicity(int newMaximumMultiplicity) {
		int oldMaximumMultiplicity = maximumMultiplicity;
		maximumMultiplicity = newMaximumMultiplicity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.IFEATURE__MAXIMUM_MULTIPLICITY,
				oldMaximumMultiplicity, maximumMultiplicity));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isTransient() {
		return transient_;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTransient(boolean newTransient) {
		boolean oldTransient = transient_;
		transient_ = newTransient;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.IFEATURE__TRANSIENT,
				oldTransient, transient_));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ImplementationPackage.IFEATURE__MINIMUM_MULTIPLICITY:
			return getMinimumMultiplicity();
		case ImplementationPackage.IFEATURE__MAXIMUM_MULTIPLICITY:
			return getMaximumMultiplicity();
		case ImplementationPackage.IFEATURE__TRANSIENT:
			return isTransient();
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
		case ImplementationPackage.IFEATURE__MINIMUM_MULTIPLICITY:
			setMinimumMultiplicity((Integer) newValue);
			return;
		case ImplementationPackage.IFEATURE__MAXIMUM_MULTIPLICITY:
			setMaximumMultiplicity((Integer) newValue);
			return;
		case ImplementationPackage.IFEATURE__TRANSIENT:
			setTransient((Boolean) newValue);
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
		case ImplementationPackage.IFEATURE__MINIMUM_MULTIPLICITY:
			setMinimumMultiplicity(MINIMUM_MULTIPLICITY_EDEFAULT);
			return;
		case ImplementationPackage.IFEATURE__MAXIMUM_MULTIPLICITY:
			setMaximumMultiplicity(MAXIMUM_MULTIPLICITY_EDEFAULT);
			return;
		case ImplementationPackage.IFEATURE__TRANSIENT:
			setTransient(TRANSIENT_EDEFAULT);
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
		case ImplementationPackage.IFEATURE__MINIMUM_MULTIPLICITY:
			return minimumMultiplicity != MINIMUM_MULTIPLICITY_EDEFAULT;
		case ImplementationPackage.IFEATURE__MAXIMUM_MULTIPLICITY:
			return maximumMultiplicity != MAXIMUM_MULTIPLICITY_EDEFAULT;
		case ImplementationPackage.IFEATURE__TRANSIENT:
			return transient_ != TRANSIENT_EDEFAULT;
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
		result.append(" (minimumMultiplicity: ");
		result.append(minimumMultiplicity);
		result.append(", maximumMultiplicity: ");
		result.append(maximumMultiplicity);
		result.append(", transient: ");
		result.append(transient_);
		result.append(')');
		return result.toString();
	}

} // IFeatureImpl
