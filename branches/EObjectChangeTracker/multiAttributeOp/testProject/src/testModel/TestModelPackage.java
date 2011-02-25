/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package testModel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.unicase.metamodel.MetamodelPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see testModel.TestModelFactory
 * @model kind="package"
 * @generated
 */
public interface TestModelPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "testModel";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://test.model/";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "test.model";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	TestModelPackage eINSTANCE = testModel.impl.TestModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link testModel.impl.TestElementImpl
	 * <em>Test Element</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see testModel.impl.TestElementImpl
	 * @see testModel.impl.TestModelPackageImpl#getTestElement()
	 * @generated
	 */
	int TEST_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEST_ELEMENT__IDENTIFIER = MetamodelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEST_ELEMENT__CREATOR = MetamodelPackage.MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEST_ELEMENT__CREATION_DATE = MetamodelPackage.MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEST_ELEMENT__VALUES = MetamodelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Test Element</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEST_ELEMENT_FEATURE_COUNT = MetamodelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link testModel.TestElement
	 * <em>Test Element</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Test Element</em>'.
	 * @see testModel.TestElement
	 * @generated
	 */
	EClass getTestElement();

	/**
	 * Returns the meta object for the attribute list '
	 * {@link testModel.TestElement#getValues <em>Values</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see testModel.TestElement#getValues()
	 * @see #getTestElement()
	 * @generated
	 */
	EAttribute getTestElement_Values();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TestModelFactory getTestModelFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that
	 * represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '
		 * {@link testModel.impl.TestElementImpl <em>Test Element</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see testModel.impl.TestElementImpl
		 * @see testModel.impl.TestModelPackageImpl#getTestElement()
		 * @generated
		 */
		EClass TEST_ELEMENT = eINSTANCE.getTestElement();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute
		 * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TEST_ELEMENT__VALUES = eINSTANCE.getTestElement_Values();

	}

} // TestModelPackage
