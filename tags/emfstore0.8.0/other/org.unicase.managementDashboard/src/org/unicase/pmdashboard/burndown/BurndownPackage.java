/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.pmdashboard.burndown;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.pmdashboard.burndown.BurndownFactory
 * @model kind="package"
 * @generated
 */
public interface BurndownPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "burndown";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/pmdashboard/burndown";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.pmdashboard.burndown";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BurndownPackage eINSTANCE = org.unicase.pmdashboard.burndown.impl.BurndownPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.pmdashboard.burndown.impl.BurndownDataImpl <em>Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.pmdashboard.burndown.impl.BurndownDataImpl
	 * @see org.unicase.pmdashboard.burndown.impl.BurndownPackageImpl#getBurndownData()
	 * @generated
	 */
	int BURNDOWN_DATA = 0;

	/**
	 * The feature id for the '<em><b>Parent Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BURNDOWN_DATA__PARENT_ELEMENT_ID = 0;

	/**
	 * The feature id for the '<em><b>Days</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BURNDOWN_DATA__DAYS = 1;

	/**
	 * The number of structural features of the '<em>Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BURNDOWN_DATA_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.unicase.pmdashboard.burndown.impl.BurndownDayImpl <em>Day</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.pmdashboard.burndown.impl.BurndownDayImpl
	 * @see org.unicase.pmdashboard.burndown.impl.BurndownPackageImpl#getBurndownDay()
	 * @generated
	 */
	int BURNDOWN_DAY = 1;

	/**
	 * The feature id for the '<em><b>Open Task Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BURNDOWN_DAY__OPEN_TASK_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Remaining Estimate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BURNDOWN_DAY__REMAINING_ESTIMATE = 1;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BURNDOWN_DAY__DATE = 2;

	/**
	 * The number of structural features of the '<em>Day</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BURNDOWN_DAY_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link org.unicase.pmdashboard.burndown.BurndownData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data</em>'.
	 * @see org.unicase.pmdashboard.burndown.BurndownData
	 * @generated
	 */
	EClass getBurndownData();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.pmdashboard.burndown.BurndownData#getParentElementId <em>Parent Element Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parent Element Id</em>'.
	 * @see org.unicase.pmdashboard.burndown.BurndownData#getParentElementId()
	 * @see #getBurndownData()
	 * @generated
	 */
	EReference getBurndownData_ParentElementId();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.pmdashboard.burndown.BurndownData#getDays <em>Days</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Days</em>'.
	 * @see org.unicase.pmdashboard.burndown.BurndownData#getDays()
	 * @see #getBurndownData()
	 * @generated
	 */
	EReference getBurndownData_Days();

	/**
	 * Returns the meta object for class '{@link org.unicase.pmdashboard.burndown.BurndownDay <em>Day</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Day</em>'.
	 * @see org.unicase.pmdashboard.burndown.BurndownDay
	 * @generated
	 */
	EClass getBurndownDay();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.pmdashboard.burndown.BurndownDay#getOpenTaskCount <em>Open Task Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Open Task Count</em>'.
	 * @see org.unicase.pmdashboard.burndown.BurndownDay#getOpenTaskCount()
	 * @see #getBurndownDay()
	 * @generated
	 */
	EAttribute getBurndownDay_OpenTaskCount();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.pmdashboard.burndown.BurndownDay#getRemainingEstimate <em>Remaining Estimate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remaining Estimate</em>'.
	 * @see org.unicase.pmdashboard.burndown.BurndownDay#getRemainingEstimate()
	 * @see #getBurndownDay()
	 * @generated
	 */
	EAttribute getBurndownDay_RemainingEstimate();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.pmdashboard.burndown.BurndownDay#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.unicase.pmdashboard.burndown.BurndownDay#getDate()
	 * @see #getBurndownDay()
	 * @generated
	 */
	EAttribute getBurndownDay_Date();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BurndownFactory getBurndownFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.pmdashboard.burndown.impl.BurndownDataImpl <em>Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.pmdashboard.burndown.impl.BurndownDataImpl
		 * @see org.unicase.pmdashboard.burndown.impl.BurndownPackageImpl#getBurndownData()
		 * @generated
		 */
		EClass BURNDOWN_DATA = eINSTANCE.getBurndownData();

		/**
		 * The meta object literal for the '<em><b>Parent Element Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BURNDOWN_DATA__PARENT_ELEMENT_ID = eINSTANCE.getBurndownData_ParentElementId();

		/**
		 * The meta object literal for the '<em><b>Days</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BURNDOWN_DATA__DAYS = eINSTANCE.getBurndownData_Days();

		/**
		 * The meta object literal for the '{@link org.unicase.pmdashboard.burndown.impl.BurndownDayImpl <em>Day</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.pmdashboard.burndown.impl.BurndownDayImpl
		 * @see org.unicase.pmdashboard.burndown.impl.BurndownPackageImpl#getBurndownDay()
		 * @generated
		 */
		EClass BURNDOWN_DAY = eINSTANCE.getBurndownDay();

		/**
		 * The meta object literal for the '<em><b>Open Task Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BURNDOWN_DAY__OPEN_TASK_COUNT = eINSTANCE.getBurndownDay_OpenTaskCount();

		/**
		 * The meta object literal for the '<em><b>Remaining Estimate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BURNDOWN_DAY__REMAINING_ESTIMATE = eINSTANCE.getBurndownDay_RemainingEstimate();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BURNDOWN_DAY__DATE = eINSTANCE.getBurndownDay_Date();

	}

} //BurndownPackage
