/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package config.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.common.notify.NotificationChain;

import config.ConfigEntity;
import config.ConfigPackage;
import org.unicase.metamodel.impl.ModelElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link config.impl.ConfigEntityImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link config.impl.ConfigEntityImpl#getAssociatedProjectIdentifier <em>Associated Project Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigEntityImpl extends ModelElementImpl implements ConfigEntity {
	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Object> properties;

	/**
	 * The default value of the '{@link #getAssociatedProjectIdentifier() <em>Associated Project Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedProjectIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String ASSOCIATED_PROJECT_IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAssociatedProjectIdentifier() <em>Associated Project Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedProjectIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String associatedProjectIdentifier = ASSOCIATED_PROJECT_IDENTIFIER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigEntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigPackage.Literals.CONFIG_ENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, Object> getProperties() {
		if (properties == null) {
			properties = new EcoreEMap<String,Object>(ConfigPackage.Literals.STRING_TO_OBJECT, StringToObjectImpl.class, this, ConfigPackage.CONFIG_ENTITY__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAssociatedProjectIdentifier() {
		return associatedProjectIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociatedProjectIdentifier(String newAssociatedProjectIdentifier) {
		String oldAssociatedProjectIdentifier = associatedProjectIdentifier;
		associatedProjectIdentifier = newAssociatedProjectIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.CONFIG_ENTITY__ASSOCIATED_PROJECT_IDENTIFIER, oldAssociatedProjectIdentifier, associatedProjectIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConfigFilename() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->.
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigPackage.CONFIG_ENTITY__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigPackage.CONFIG_ENTITY__PROPERTIES:
				if (coreType) return getProperties();
				else return getProperties().map();
			case ConfigPackage.CONFIG_ENTITY__ASSOCIATED_PROJECT_IDENTIFIER:
				return getAssociatedProjectIdentifier();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConfigPackage.CONFIG_ENTITY__PROPERTIES:
				((EStructuralFeature.Setting)getProperties()).set(newValue);
				return;
			case ConfigPackage.CONFIG_ENTITY__ASSOCIATED_PROJECT_IDENTIFIER:
				setAssociatedProjectIdentifier((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConfigPackage.CONFIG_ENTITY__PROPERTIES:
				getProperties().clear();
				return;
			case ConfigPackage.CONFIG_ENTITY__ASSOCIATED_PROJECT_IDENTIFIER:
				setAssociatedProjectIdentifier(ASSOCIATED_PROJECT_IDENTIFIER_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConfigPackage.CONFIG_ENTITY__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case ConfigPackage.CONFIG_ENTITY__ASSOCIATED_PROJECT_IDENTIFIER:
				return ASSOCIATED_PROJECT_IDENTIFIER_EDEFAULT == null ? associatedProjectIdentifier != null : !ASSOCIATED_PROJECT_IDENTIFIER_EDEFAULT.equals(associatedProjectIdentifier);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (associatedProjectIdentifier: ");
		result.append(associatedProjectIdentifier);
		result.append(')');
		return result.toString();
	}

} //ConfigEntityImpl
