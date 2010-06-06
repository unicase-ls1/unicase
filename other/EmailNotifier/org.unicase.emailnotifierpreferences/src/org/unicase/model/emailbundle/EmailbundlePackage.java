/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 *
 * $Id$
 */
package org.unicase.model.emailbundle;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.unicase.model.ModelPackage;

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
 * @see org.unicase.model.emailbundle.EmailbundleFactory
 * @model kind="package"
 * @generated
 */
public interface EmailbundlePackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "<copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the\naccompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this\ndistribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>\n";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "emailbundle";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/emailbundle";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.emailbundle";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EmailbundlePackage eINSTANCE = org.unicase.model.emailbundle.impl.EmailbundlePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.emailbundle.impl.BundleImpl <em>Bundle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.emailbundle.impl.BundleImpl
	 * @see org.unicase.model.emailbundle.impl.EmailbundlePackageImpl#getBundle()
	 * @generated
	 */
	int BUNDLE = 0;

	/**
	 * The feature id for the '<em><b>Bundle Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__BUNDLE_NAME = 0;

	/**
	 * The feature id for the '<em><b>Send Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__SEND_OPTION = 1;

	/**
	 * The feature id for the '<em><b>Days</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__DAYS = 2;

	/**
	 * The feature id for the '<em><b>Days Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__DAYS_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Weekday</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__WEEKDAY = 4;

	/**
	 * The feature id for the '<em><b>Weekday Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__WEEKDAY_OPTION = 5;

	/**
	 * The feature id for the '<em><b>Providers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__PROVIDERS = 6;

	/**
	 * The number of structural features of the '<em>Bundle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_FEATURE_COUNT = 7;


	/**
	 * The meta object id for the '{@link org.unicase.model.emailbundle.SendSettings <em>Send Settings</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.emailbundle.SendSettings
	 * @see org.unicase.model.emailbundle.impl.EmailbundlePackageImpl#getSendSettings()
	 * @generated
	 */
	int SEND_SETTINGS = 1;

	/**
	 * The meta object id for the '{@link org.unicase.model.emailbundle.Weekdays <em>Weekdays</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.emailbundle.Weekdays
	 * @see org.unicase.model.emailbundle.impl.EmailbundlePackageImpl#getWeekdays()
	 * @generated
	 */
	int WEEKDAYS = 2;


	/**
	 * Returns the meta object for class '{@link org.unicase.model.emailbundle.Bundle <em>Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bundle</em>'.
	 * @see org.unicase.model.emailbundle.Bundle
	 * @generated
	 */
	EClass getBundle();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.emailbundle.Bundle#getBundleName <em>Bundle Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bundle Name</em>'.
	 * @see org.unicase.model.emailbundle.Bundle#getBundleName()
	 * @see #getBundle()
	 * @generated
	 */
	EAttribute getBundle_BundleName();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.emailbundle.Bundle#getSendOption <em>Send Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Send Option</em>'.
	 * @see org.unicase.model.emailbundle.Bundle#getSendOption()
	 * @see #getBundle()
	 * @generated
	 */
	EAttribute getBundle_SendOption();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.emailbundle.Bundle#isDays <em>Days</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Days</em>'.
	 * @see org.unicase.model.emailbundle.Bundle#isDays()
	 * @see #getBundle()
	 * @generated
	 */
	EAttribute getBundle_Days();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.emailbundle.Bundle#getDaysCount <em>Days Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Days Count</em>'.
	 * @see org.unicase.model.emailbundle.Bundle#getDaysCount()
	 * @see #getBundle()
	 * @generated
	 */
	EAttribute getBundle_DaysCount();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.emailbundle.Bundle#isWeekday <em>Weekday</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weekday</em>'.
	 * @see org.unicase.model.emailbundle.Bundle#isWeekday()
	 * @see #getBundle()
	 * @generated
	 */
	EAttribute getBundle_Weekday();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.emailbundle.Bundle#getWeekdayOption <em>Weekday Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weekday Option</em>'.
	 * @see org.unicase.model.emailbundle.Bundle#getWeekdayOption()
	 * @see #getBundle()
	 * @generated
	 */
	EAttribute getBundle_WeekdayOption();

	/**
	 * Returns the meta object for the attribute list '{@link org.unicase.model.emailbundle.Bundle#getProviders <em>Providers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Providers</em>'.
	 * @see org.unicase.model.emailbundle.Bundle#getProviders()
	 * @see #getBundle()
	 * @generated
	 */
	EAttribute getBundle_Providers();

	/**
	 * Returns the meta object for enum '{@link org.unicase.model.emailbundle.SendSettings <em>Send Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Send Settings</em>'.
	 * @see org.unicase.model.emailbundle.SendSettings
	 * @generated
	 */
	EEnum getSendSettings();

	/**
	 * Returns the meta object for enum '{@link org.unicase.model.emailbundle.Weekdays <em>Weekdays</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Weekdays</em>'.
	 * @see org.unicase.model.emailbundle.Weekdays
	 * @generated
	 */
	EEnum getWeekdays();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EmailbundleFactory getEmailbundleFactory();

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
		 * The meta object literal for the '{@link org.unicase.model.emailbundle.impl.BundleImpl <em>Bundle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.emailbundle.impl.BundleImpl
		 * @see org.unicase.model.emailbundle.impl.EmailbundlePackageImpl#getBundle()
		 * @generated
		 */
		EClass BUNDLE = eINSTANCE.getBundle();

		/**
		 * The meta object literal for the '<em><b>Bundle Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE__BUNDLE_NAME = eINSTANCE.getBundle_BundleName();

		/**
		 * The meta object literal for the '<em><b>Send Option</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE__SEND_OPTION = eINSTANCE.getBundle_SendOption();

		/**
		 * The meta object literal for the '<em><b>Days</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE__DAYS = eINSTANCE.getBundle_Days();

		/**
		 * The meta object literal for the '<em><b>Days Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE__DAYS_COUNT = eINSTANCE.getBundle_DaysCount();

		/**
		 * The meta object literal for the '<em><b>Weekday</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE__WEEKDAY = eINSTANCE.getBundle_Weekday();

		/**
		 * The meta object literal for the '<em><b>Weekday Option</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE__WEEKDAY_OPTION = eINSTANCE.getBundle_WeekdayOption();

		/**
		 * The meta object literal for the '<em><b>Providers</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE__PROVIDERS = eINSTANCE.getBundle_Providers();

		/**
		 * The meta object literal for the '{@link org.unicase.model.emailbundle.SendSettings <em>Send Settings</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.emailbundle.SendSettings
		 * @see org.unicase.model.emailbundle.impl.EmailbundlePackageImpl#getSendSettings()
		 * @generated
		 */
		EEnum SEND_SETTINGS = eINSTANCE.getSendSettings();

		/**
		 * The meta object literal for the '{@link org.unicase.model.emailbundle.Weekdays <em>Weekdays</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.emailbundle.Weekdays
		 * @see org.unicase.model.emailbundle.impl.EmailbundlePackageImpl#getWeekdays()
		 * @generated
		 */
		EEnum WEEKDAYS = eINSTANCE.getWeekdays();

	}

} //EmailbundlePackage
