/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.iterator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.analyzer.iterator.IteratorFactory
 * @model kind="package"
 * @generated
 */
public interface IteratorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "iterator";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/analyzer/iterator";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.analyzer.iterator";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	IteratorPackage eINSTANCE = org.unicase.analyzer.iterator.impl.IteratorPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.analyzer.iterator.impl.VersionIteratorImpl <em>Version Iterator</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.analyzer.iterator.impl.VersionIteratorImpl
	 * @see org.unicase.analyzer.iterator.impl.IteratorPackageImpl#getVersionIterator()
	 * @generated
	 */
	int VERSION_ITERATOR = 0;

	/**
	 * The feature id for the '<em><b>Step Length</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_ITERATOR__STEP_LENGTH = 0;

	/**
	 * The feature id for the '<em><b>Project Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_ITERATOR__PROJECT_ID = 1;

	/**
	 * The feature id for the '<em><b>Forward</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_ITERATOR__FORWARD = 2;

	/**
	 * The feature id for the '<em><b>Return Project Data Copy</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_ITERATOR__RETURN_PROJECT_DATA_COPY = 3;

	/**
	 * The feature id for the '<em><b>Version Spec Query</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_ITERATOR__VERSION_SPEC_QUERY = 4;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_ITERATOR__DEFAULT = 5;

	/**
	 * The number of structural features of the '<em>Version Iterator</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_ITERATOR_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.unicase.analyzer.iterator.impl.TimeIteratorImpl <em>Time Iterator</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.analyzer.iterator.impl.TimeIteratorImpl
	 * @see org.unicase.analyzer.iterator.impl.IteratorPackageImpl#getTimeIterator()
	 * @generated
	 */
	int TIME_ITERATOR = 1;

	/**
	 * The feature id for the '<em><b>Step Length</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_ITERATOR__STEP_LENGTH = VERSION_ITERATOR__STEP_LENGTH;

	/**
	 * The feature id for the '<em><b>Project Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_ITERATOR__PROJECT_ID = VERSION_ITERATOR__PROJECT_ID;

	/**
	 * The feature id for the '<em><b>Forward</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_ITERATOR__FORWARD = VERSION_ITERATOR__FORWARD;

	/**
	 * The feature id for the '<em><b>Return Project Data Copy</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_ITERATOR__RETURN_PROJECT_DATA_COPY = VERSION_ITERATOR__RETURN_PROJECT_DATA_COPY;

	/**
	 * The feature id for the '<em><b>Version Spec Query</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_ITERATOR__VERSION_SPEC_QUERY = VERSION_ITERATOR__VERSION_SPEC_QUERY;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_ITERATOR__DEFAULT = VERSION_ITERATOR__DEFAULT;

	/**
	 * The feature id for the '<em><b>Start Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_ITERATOR__START_DATE = VERSION_ITERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_ITERATOR__END_DATE = VERSION_ITERATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Step Length Unit</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TIME_ITERATOR__STEP_LENGTH_UNIT = VERSION_ITERATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Time Iterator</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_ITERATOR_FEATURE_COUNT = VERSION_ITERATOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.analyzer.iterator.impl.VersionSpecQueryImpl <em>Version Spec Query</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.analyzer.iterator.impl.VersionSpecQueryImpl
	 * @see org.unicase.analyzer.iterator.impl.IteratorPackageImpl#getVersionSpecQuery()
	 * @generated
	 */
	int VERSION_SPEC_QUERY = 2;

	/**
	 * The feature id for the '<em><b>End Version</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_SPEC_QUERY__END_VERSION = 0;

	/**
	 * The feature id for the '<em><b>Start Version</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_SPEC_QUERY__START_VERSION = 1;

	/**
	 * The number of structural features of the '<em>Version Spec Query</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_SPEC_QUERY_FEATURE_COUNT = 2;

	/**
	 * Returns the meta object for class '{@link org.unicase.analyzer.iterator.VersionIterator <em>Version Iterator</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version Iterator</em>'.
	 * @see org.unicase.analyzer.iterator.VersionIterator
	 * @generated
	 */
	EClass getVersionIterator();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.analyzer.iterator.VersionIterator#getStepLength <em>Step Length</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step Length</em>'.
	 * @see org.unicase.analyzer.iterator.VersionIterator#getStepLength()
	 * @see #getVersionIterator()
	 * @generated
	 */
	EAttribute getVersionIterator_StepLength();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.analyzer.iterator.VersionIterator#getProjectId <em>Project Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Project Id</em>'.
	 * @see org.unicase.analyzer.iterator.VersionIterator#getProjectId()
	 * @see #getVersionIterator()
	 * @generated
	 */
	EReference getVersionIterator_ProjectId();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.analyzer.iterator.VersionIterator#isForward <em>Forward</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Forward</em>'.
	 * @see org.unicase.analyzer.iterator.VersionIterator#isForward()
	 * @see #getVersionIterator()
	 * @generated
	 */
	EAttribute getVersionIterator_Forward();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.analyzer.iterator.VersionIterator#isReturnProjectDataCopy <em>Return Project Data Copy</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Return Project Data Copy</em>'.
	 * @see org.unicase.analyzer.iterator.VersionIterator#isReturnProjectDataCopy()
	 * @see #getVersionIterator()
	 * @generated
	 */
	EAttribute getVersionIterator_ReturnProjectDataCopy();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.analyzer.iterator.VersionIterator#getVersionSpecQuery <em>Version Spec Query</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Version Spec Query</em>'.
	 * @see org.unicase.analyzer.iterator.VersionIterator#getVersionSpecQuery()
	 * @see #getVersionIterator()
	 * @generated
	 */
	EReference getVersionIterator_VersionSpecQuery();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.analyzer.iterator.VersionIterator#isDefault <em>Default</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see org.unicase.analyzer.iterator.VersionIterator#isDefault()
	 * @see #getVersionIterator()
	 * @generated
	 */
	EAttribute getVersionIterator_Default();

	/**
	 * Returns the meta object for class '{@link org.unicase.analyzer.iterator.TimeIterator <em>Time Iterator</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Iterator</em>'.
	 * @see org.unicase.analyzer.iterator.TimeIterator
	 * @generated
	 */
	EClass getTimeIterator();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.analyzer.iterator.TimeIterator#getStartDate <em>Start Date</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Date</em>'.
	 * @see org.unicase.analyzer.iterator.TimeIterator#getStartDate()
	 * @see #getTimeIterator()
	 * @generated
	 */
	EAttribute getTimeIterator_StartDate();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.analyzer.iterator.TimeIterator#getEndDate <em>End Date</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Date</em>'.
	 * @see org.unicase.analyzer.iterator.TimeIterator#getEndDate()
	 * @see #getTimeIterator()
	 * @generated
	 */
	EAttribute getTimeIterator_EndDate();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.analyzer.iterator.TimeIterator#getStepLengthUnit <em>Step Length Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step Length Unit</em>'.
	 * @see org.unicase.analyzer.iterator.TimeIterator#getStepLengthUnit()
	 * @see #getTimeIterator()
	 * @generated
	 */
	EAttribute getTimeIterator_StepLengthUnit();

	/**
	 * Returns the meta object for class '{@link org.unicase.analyzer.iterator.VersionSpecQuery <em>Version Spec Query</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version Spec Query</em>'.
	 * @see org.unicase.analyzer.iterator.VersionSpecQuery
	 * @generated
	 */
	EClass getVersionSpecQuery();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.analyzer.iterator.VersionSpecQuery#getEndVersion <em>End Version</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>End Version</em>'.
	 * @see org.unicase.analyzer.iterator.VersionSpecQuery#getEndVersion()
	 * @see #getVersionSpecQuery()
	 * @generated
	 */
	EReference getVersionSpecQuery_EndVersion();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.analyzer.iterator.VersionSpecQuery#getStartVersion <em>Start Version</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Start Version</em>'.
	 * @see org.unicase.analyzer.iterator.VersionSpecQuery#getStartVersion()
	 * @see #getVersionSpecQuery()
	 * @generated
	 */
	EReference getVersionSpecQuery_StartVersion();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	IteratorFactory getIteratorFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.analyzer.iterator.impl.VersionIteratorImpl <em>Version Iterator</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.analyzer.iterator.impl.VersionIteratorImpl
		 * @see org.unicase.analyzer.iterator.impl.IteratorPackageImpl#getVersionIterator()
		 * @generated
		 */
		EClass VERSION_ITERATOR = eINSTANCE.getVersionIterator();

		/**
		 * The meta object literal for the '<em><b>Step Length</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION_ITERATOR__STEP_LENGTH = eINSTANCE.getVersionIterator_StepLength();

		/**
		 * The meta object literal for the '<em><b>Project Id</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VERSION_ITERATOR__PROJECT_ID = eINSTANCE.getVersionIterator_ProjectId();

		/**
		 * The meta object literal for the '<em><b>Forward</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION_ITERATOR__FORWARD = eINSTANCE.getVersionIterator_Forward();

		/**
		 * The meta object literal for the '<em><b>Return Project Data Copy</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VERSION_ITERATOR__RETURN_PROJECT_DATA_COPY = eINSTANCE.getVersionIterator_ReturnProjectDataCopy();

		/**
		 * The meta object literal for the '<em><b>Version Spec Query</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VERSION_ITERATOR__VERSION_SPEC_QUERY = eINSTANCE.getVersionIterator_VersionSpecQuery();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION_ITERATOR__DEFAULT = eINSTANCE.getVersionIterator_Default();

		/**
		 * The meta object literal for the '{@link org.unicase.analyzer.iterator.impl.TimeIteratorImpl <em>Time Iterator</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.analyzer.iterator.impl.TimeIteratorImpl
		 * @see org.unicase.analyzer.iterator.impl.IteratorPackageImpl#getTimeIterator()
		 * @generated
		 */
		EClass TIME_ITERATOR = eINSTANCE.getTimeIterator();

		/**
		 * The meta object literal for the '<em><b>Start Date</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_ITERATOR__START_DATE = eINSTANCE.getTimeIterator_StartDate();

		/**
		 * The meta object literal for the '<em><b>End Date</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_ITERATOR__END_DATE = eINSTANCE.getTimeIterator_EndDate();

		/**
		 * The meta object literal for the '<em><b>Step Length Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_ITERATOR__STEP_LENGTH_UNIT = eINSTANCE.getTimeIterator_StepLengthUnit();

		/**
		 * The meta object literal for the '{@link org.unicase.analyzer.iterator.impl.VersionSpecQueryImpl <em>Version Spec Query</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.analyzer.iterator.impl.VersionSpecQueryImpl
		 * @see org.unicase.analyzer.iterator.impl.IteratorPackageImpl#getVersionSpecQuery()
		 * @generated
		 */
		EClass VERSION_SPEC_QUERY = eINSTANCE.getVersionSpecQuery();

		/**
		 * The meta object literal for the '<em><b>End Version</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VERSION_SPEC_QUERY__END_VERSION = eINSTANCE.getVersionSpecQuery_EndVersion();

		/**
		 * The meta object literal for the '<em><b>Start Version</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VERSION_SPEC_QUERY__START_VERSION = eINSTANCE.getVersionSpecQuery_StartVersion();

	}

} // IteratorPackage
