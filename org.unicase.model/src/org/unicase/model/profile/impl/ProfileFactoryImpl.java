/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.profile.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.model.profile.Profile;
import org.unicase.model.profile.ProfileFactory;
import org.unicase.model.profile.ProfilePackage;
import org.unicase.model.profile.Stereotype;
import org.unicase.model.profile.StereotypeAttributeInstanceString;
import org.unicase.model.profile.StereotypeAttributeSimple;
import org.unicase.model.profile.StereotypeInstance;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class ProfileFactoryImpl extends EFactoryImpl implements ProfileFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ProfileFactory init() {
		try {
			ProfileFactory theProfileFactory = (ProfileFactory) EPackage.Registry.INSTANCE
					.getEFactory(ProfilePackage.eNS_URI);
			if (theProfileFactory != null) {
				return theProfileFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ProfileFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProfileFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case ProfilePackage.PROFILE:
			return createProfile();
		case ProfilePackage.STEREOTYPE:
			return createStereotype();
		case ProfilePackage.STEREOTYPE_INSTANCE:
			return createStereotypeInstance();
		case ProfilePackage.STEREOTYPE_ATTRIBUTE_SIMPLE:
			return createStereotypeAttributeSimple();
		case ProfilePackage.STEREOTYPE_ATTRIBUTE_INSTANCE_STRING:
			return createStereotypeAttributeInstanceString();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName()
					+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Profile createProfile() {
		ProfileImpl profile = new ProfileImpl();
		return profile;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Stereotype createStereotype() {
		StereotypeImpl stereotype = new StereotypeImpl();
		return stereotype;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public StereotypeInstance createStereotypeInstance() {
		StereotypeInstanceImpl stereotypeInstance = new StereotypeInstanceImpl();
		return stereotypeInstance;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public StereotypeAttributeSimple createStereotypeAttributeSimple() {
		StereotypeAttributeSimpleImpl stereotypeAttributeSimple = new StereotypeAttributeSimpleImpl();
		return stereotypeAttributeSimple;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public StereotypeAttributeInstanceString createStereotypeAttributeInstanceString() {
		StereotypeAttributeInstanceStringImpl stereotypeAttributeInstanceString = new StereotypeAttributeInstanceStringImpl();
		return stereotypeAttributeInstanceString;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProfilePackage getProfilePackage() {
		return (ProfilePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ProfilePackage getPackage() {
		return ProfilePackage.eINSTANCE;
	}

} // ProfileFactoryImpl
