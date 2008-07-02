/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Kšgel
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.changemanagment.changepackage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.unicase.emfstore.esmodel.changemanagment.changepackage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ChangepackageFactoryImpl extends EFactoryImpl implements
		ChangepackageFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ChangepackageFactory init() {
		try {
			ChangepackageFactory theChangepackageFactory = (ChangepackageFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://unicase.org/esmodel/changemanagment/changepackage");
			if (theChangepackageFactory != null) {
				return theChangepackageFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ChangepackageFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangepackageFactoryImpl() {
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
		case ChangepackagePackage.CHANGEPACKAGE:
			return createChangepackage();
		case ChangepackagePackage.ES_OPERATION:
			return createESOperation();
		case ChangepackagePackage.ESE_ATTRIBUTE_EVENT:
			return createESeAttributeEvent();
		case ChangepackagePackage.ES_LIST_EVENT:
			return createESListEvent();
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
	public Changepackage createChangepackage() {
		ChangepackageImpl changepackage = new ChangepackageImpl();
		return changepackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESOperation createESOperation() {
		ESOperationImpl esOperation = new ESOperationImpl();
		return esOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESeAttributeEvent createESeAttributeEvent() {
		ESeAttributeEventImpl eSeAttributeEvent = new ESeAttributeEventImpl();
		return eSeAttributeEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ESListEvent createESListEvent() {
		ESListEventImpl esListEvent = new ESListEventImpl();
		return esListEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangepackagePackage getChangepackagePackage() {
		return (ChangepackagePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ChangepackagePackage getPackage() {
		return ChangepackagePackage.eINSTANCE;
	}

	public Changepackage convertToChangepackage(
			ChangeDescription changeDescription) {
		createChangepackage();
		
		return null;
	}

} //ChangepackageFactoryImpl
