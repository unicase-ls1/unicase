/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.changeContainer.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.emfstore.esmodel.versioning.changeContainer.*;
import org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainer;
import org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainerFactory;
import org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainerPackage;
import org.unicase.emfstore.esmodel.versioning.changeContainer.CompositeChangeContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ChangeContainerFactoryImpl extends EFactoryImpl implements
		ChangeContainerFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ChangeContainerFactory init() {
		try {
			ChangeContainerFactory theChangeContainerFactory = (ChangeContainerFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://unicase.org/esmodel/versioning/changeContainer");
			if (theChangeContainerFactory != null) {
				return theChangeContainerFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ChangeContainerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeContainerFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case ChangeContainerPackage.CHANGE_CONTAINER:
			return createChangeContainer();
		case ChangeContainerPackage.COMPOSITE_CHANGE_CONTAINER:
			return createCompositeChangeContainer();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName()
					+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeContainer createChangeContainer() {
		ChangeContainerImpl changeContainer = new ChangeContainerImpl();
		return changeContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeChangeContainer createCompositeChangeContainer() {
		CompositeChangeContainerImpl compositeChangeContainer = new CompositeChangeContainerImpl();
		return compositeChangeContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeContainerPackage getChangeContainerPackage() {
		return (ChangeContainerPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ChangeContainerPackage getPackage() {
		return ChangeContainerPackage.eINSTANCE;
	}

} //ChangeContainerFactoryImpl
