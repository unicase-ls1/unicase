/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.esmodel.versionspec;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.unicase.esmodel.versionspec.VersionspecFactory
 * @model kind="package"
 * @generated
 */
public interface VersionspecPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "versionspec";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/esmodel/versionspec";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.esmodel.versionspec";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VersionspecPackage eINSTANCE = org.unicase.esmodel.versionspec.impl.VersionspecPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.esmodel.versionspec.impl.TagVersionSpecImpl <em>Tag Version Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.esmodel.versionspec.impl.TagVersionSpecImpl
	 * @see org.unicase.esmodel.versionspec.impl.VersionspecPackageImpl#getTagVersionSpec()
	 * @generated
	 */
	int TAG_VERSION_SPEC = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_VERSION_SPEC__NAME = 0;

	/**
	 * The number of structural features of the '<em>Tag Version Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_VERSION_SPEC_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.unicase.esmodel.versionspec.impl.DateVersionSpecImpl <em>Date Version Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.esmodel.versionspec.impl.DateVersionSpecImpl
	 * @see org.unicase.esmodel.versionspec.impl.VersionspecPackageImpl#getDateVersionSpec()
	 * @generated
	 */
	int DATE_VERSION_SPEC = 1;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_VERSION_SPEC__DATE = 0;

	/**
	 * The number of structural features of the '<em>Date Version Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_VERSION_SPEC_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.unicase.esmodel.versionspec.impl.PrimaryVersionSpecImpl <em>Primary Version Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.esmodel.versionspec.impl.PrimaryVersionSpecImpl
	 * @see org.unicase.esmodel.versionspec.impl.VersionspecPackageImpl#getPrimaryVersionSpec()
	 * @generated
	 */
	int PRIMARY_VERSION_SPEC = 2;

	/**
	 * The number of structural features of the '<em>Primary Version Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_VERSION_SPEC_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.unicase.esmodel.versionspec.VersionSpec <em>Version Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.esmodel.versionspec.VersionSpec
	 * @see org.unicase.esmodel.versionspec.impl.VersionspecPackageImpl#getVersionSpec()
	 * @generated
	 */
	int VERSION_SPEC = 3;

	/**
	 * The number of structural features of the '<em>Version Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_SPEC_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.unicase.esmodel.versionspec.TagVersionSpec <em>Tag Version Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag Version Spec</em>'.
	 * @see org.unicase.esmodel.versionspec.TagVersionSpec
	 * @generated
	 */
	EClass getTagVersionSpec();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.esmodel.versionspec.TagVersionSpec#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.unicase.esmodel.versionspec.TagVersionSpec#getName()
	 * @see #getTagVersionSpec()
	 * @generated
	 */
	EAttribute getTagVersionSpec_Name();

	/**
	 * Returns the meta object for class '{@link org.unicase.esmodel.versionspec.DateVersionSpec <em>Date Version Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Date Version Spec</em>'.
	 * @see org.unicase.esmodel.versionspec.DateVersionSpec
	 * @generated
	 */
	EClass getDateVersionSpec();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.esmodel.versionspec.DateVersionSpec#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.unicase.esmodel.versionspec.DateVersionSpec#getDate()
	 * @see #getDateVersionSpec()
	 * @generated
	 */
	EAttribute getDateVersionSpec_Date();

	/**
	 * Returns the meta object for class '{@link org.unicase.esmodel.versionspec.PrimaryVersionSpec <em>Primary Version Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primary Version Spec</em>'.
	 * @see org.unicase.esmodel.versionspec.PrimaryVersionSpec
	 * @generated
	 */
	EClass getPrimaryVersionSpec();

	/**
	 * Returns the meta object for class '{@link org.unicase.esmodel.versionspec.VersionSpec <em>Version Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version Spec</em>'.
	 * @see org.unicase.esmodel.versionspec.VersionSpec
	 * @generated
	 */
	EClass getVersionSpec();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VersionspecFactory getVersionspecFactory();

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
		 * The meta object literal for the '{@link org.unicase.esmodel.versionspec.impl.TagVersionSpecImpl <em>Tag Version Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.esmodel.versionspec.impl.TagVersionSpecImpl
		 * @see org.unicase.esmodel.versionspec.impl.VersionspecPackageImpl#getTagVersionSpec()
		 * @generated
		 */
		EClass TAG_VERSION_SPEC = eINSTANCE.getTagVersionSpec();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG_VERSION_SPEC__NAME = eINSTANCE.getTagVersionSpec_Name();

		/**
		 * The meta object literal for the '{@link org.unicase.esmodel.versionspec.impl.DateVersionSpecImpl <em>Date Version Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.esmodel.versionspec.impl.DateVersionSpecImpl
		 * @see org.unicase.esmodel.versionspec.impl.VersionspecPackageImpl#getDateVersionSpec()
		 * @generated
		 */
		EClass DATE_VERSION_SPEC = eINSTANCE.getDateVersionSpec();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATE_VERSION_SPEC__DATE = eINSTANCE.getDateVersionSpec_Date();

		/**
		 * The meta object literal for the '{@link org.unicase.esmodel.versionspec.impl.PrimaryVersionSpecImpl <em>Primary Version Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.esmodel.versionspec.impl.PrimaryVersionSpecImpl
		 * @see org.unicase.esmodel.versionspec.impl.VersionspecPackageImpl#getPrimaryVersionSpec()
		 * @generated
		 */
		EClass PRIMARY_VERSION_SPEC = eINSTANCE.getPrimaryVersionSpec();

		/**
		 * The meta object literal for the '{@link org.unicase.esmodel.versionspec.VersionSpec <em>Version Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.esmodel.versionspec.VersionSpec
		 * @see org.unicase.esmodel.versionspec.impl.VersionspecPackageImpl#getVersionSpec()
		 * @generated
		 */
		EClass VERSION_SPEC = eINSTANCE.getVersionSpec();

	}

} //VersionspecPackage
