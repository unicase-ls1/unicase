/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.pmdashboard.burndown.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.pmdashboard.burndown.BurndownData;
import org.unicase.pmdashboard.burndown.BurndownDay;
import org.unicase.pmdashboard.burndown.BurndownFactory;
import org.unicase.pmdashboard.burndown.BurndownPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BurndownFactoryImpl extends EFactoryImpl implements BurndownFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BurndownFactory init() {
		try {
			BurndownFactory theBurndownFactory = (BurndownFactory)EPackage.Registry.INSTANCE.getEFactory("http://unicase.org/pmdashboard/burndown"); 
			if (theBurndownFactory != null) {
				return theBurndownFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BurndownFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BurndownFactoryImpl() {
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
			case BurndownPackage.BURNDOWN_DATA: return createBurndownData();
			case BurndownPackage.BURNDOWN_DAY: return createBurndownDay();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BurndownData createBurndownData() {
		BurndownDataImpl burndownData = new BurndownDataImpl();
		return burndownData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BurndownDay createBurndownDay() {
		BurndownDayImpl burndownDay = new BurndownDayImpl();
		return burndownDay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BurndownPackage getBurndownPackage() {
		return (BurndownPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BurndownPackage getPackage() {
		return BurndownPackage.eINSTANCE;
	}

} //BurndownFactoryImpl
