/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.testspec;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.unicase.model.testspec.TestspecFactory
 * @model kind="package"
 * @generated
 */
public interface TestspecPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "testspec";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/testspec";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.testspec";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestspecPackage eINSTANCE = org.unicase.model.testspec.impl.TestspecPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.testspec.impl.TestProtocolImpl <em>Test Protocol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.testspec.impl.TestProtocolImpl
	 * @see org.unicase.model.testspec.impl.TestspecPackageImpl#getTestProtocol()
	 * @generated
	 */
	int TEST_PROTOCOL = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__IDENTIFIER = ModelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__NAME = ModelPackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__DESCRIPTION = ModelPackage.MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__CREATOR = ModelPackage.MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__CREATION_DATE = ModelPackage.MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__ANNOTATIONS = ModelPackage.MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__ATTACHMENTS = ModelPackage.MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__INCOMING_DOCUMENT_REFERENCES = ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__LEAF_SECTION = ModelPackage.MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__STATE = ModelPackage.MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__APPLIED_STEREOTYPE_INSTANCES = ModelPackage.MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__COMMENTS = ModelPackage.MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Test Report</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__TEST_REPORT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Test State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__TEST_STATE = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Test Case</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__TEST_CASE = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Test Protocol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL_FEATURE_COUNT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.model.testspec.impl.LogicalTestCaseImpl <em>Logical Test Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.testspec.impl.LogicalTestCaseImpl
	 * @see org.unicase.model.testspec.impl.TestspecPackageImpl#getLogicalTestCase()
	 * @generated
	 */
	int LOGICAL_TEST_CASE = 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__IDENTIFIER = ModelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__NAME = ModelPackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__DESCRIPTION = ModelPackage.MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__CREATOR = ModelPackage.MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__CREATION_DATE = ModelPackage.MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__ANNOTATIONS = ModelPackage.MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__ATTACHMENTS = ModelPackage.MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__INCOMING_DOCUMENT_REFERENCES = ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__LEAF_SECTION = ModelPackage.MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__STATE = ModelPackage.MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__APPLIED_STEREOTYPE_INSTANCES = ModelPackage.MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__COMMENTS = ModelPackage.MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__TYPE = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Precondition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__PRECONDITION = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Postcondition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__POSTCONDITION = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Infrastructure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__INFRASTRUCTURE = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Non Functional Requirement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__NON_FUNCTIONAL_REQUIREMENT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Functional Requirement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__FUNCTIONAL_REQUIREMENT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Step</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__STEP = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Logical Test Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE_FEATURE_COUNT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.unicase.model.testspec.impl.TestStepImpl <em>Test Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.testspec.impl.TestStepImpl
	 * @see org.unicase.model.testspec.impl.TestspecPackageImpl#getTestStep()
	 * @generated
	 */
	int TEST_STEP = 2;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP__IDENTIFIER = ModelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP__NAME = ModelPackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP__DESCRIPTION = ModelPackage.MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP__CREATOR = ModelPackage.MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP__CREATION_DATE = ModelPackage.MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP__ANNOTATIONS = ModelPackage.MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP__ATTACHMENTS = ModelPackage.MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP__INCOMING_DOCUMENT_REFERENCES = ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP__LEAF_SECTION = ModelPackage.MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP__STATE = ModelPackage.MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP__APPLIED_STEREOTYPE_INSTANCES = ModelPackage.MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP__COMMENTS = ModelPackage.MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Exception</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP__EXCEPTION = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Input Paramter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP__INPUT_PARAMTER = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Output Parameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP__OUTPUT_PARAMETER = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Test Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP_FEATURE_COUNT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.model.testspec.EnumState <em>Enum State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.testspec.EnumState
	 * @see org.unicase.model.testspec.impl.TestspecPackageImpl#getEnumState()
	 * @generated
	 */
	int ENUM_STATE = 3;

	/**
	 * The meta object id for the '{@link org.unicase.model.testspec.EnumType <em>Enum Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.testspec.EnumType
	 * @see org.unicase.model.testspec.impl.TestspecPackageImpl#getEnumType()
	 * @generated
	 */
	int ENUM_TYPE = 4;


	/**
	 * Returns the meta object for class '{@link org.unicase.model.testspec.TestProtocol <em>Test Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Protocol</em>'.
	 * @see org.unicase.model.testspec.TestProtocol
	 * @generated
	 */
	EClass getTestProtocol();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.testspec.TestProtocol#getTestReport <em>Test Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Report</em>'.
	 * @see org.unicase.model.testspec.TestProtocol#getTestReport()
	 * @see #getTestProtocol()
	 * @generated
	 */
	EAttribute getTestProtocol_TestReport();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.testspec.TestProtocol#getTestState <em>Test State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test State</em>'.
	 * @see org.unicase.model.testspec.TestProtocol#getTestState()
	 * @see #getTestProtocol()
	 * @generated
	 */
	EAttribute getTestProtocol_TestState();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.model.testspec.TestProtocol#getTestCase <em>Test Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Test Case</em>'.
	 * @see org.unicase.model.testspec.TestProtocol#getTestCase()
	 * @see #getTestProtocol()
	 * @generated
	 */
	EReference getTestProtocol_TestCase();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.testspec.LogicalTestCase <em>Logical Test Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logical Test Case</em>'.
	 * @see org.unicase.model.testspec.LogicalTestCase
	 * @generated
	 */
	EClass getLogicalTestCase();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.testspec.LogicalTestCase#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.unicase.model.testspec.LogicalTestCase#getType()
	 * @see #getLogicalTestCase()
	 * @generated
	 */
	EAttribute getLogicalTestCase_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.testspec.LogicalTestCase#getPrecondition <em>Precondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Precondition</em>'.
	 * @see org.unicase.model.testspec.LogicalTestCase#getPrecondition()
	 * @see #getLogicalTestCase()
	 * @generated
	 */
	EAttribute getLogicalTestCase_Precondition();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.testspec.LogicalTestCase#getPostcondition <em>Postcondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Postcondition</em>'.
	 * @see org.unicase.model.testspec.LogicalTestCase#getPostcondition()
	 * @see #getLogicalTestCase()
	 * @generated
	 */
	EAttribute getLogicalTestCase_Postcondition();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.testspec.LogicalTestCase#getInfrastructure <em>Infrastructure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Infrastructure</em>'.
	 * @see org.unicase.model.testspec.LogicalTestCase#getInfrastructure()
	 * @see #getLogicalTestCase()
	 * @generated
	 */
	EAttribute getLogicalTestCase_Infrastructure();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.model.testspec.LogicalTestCase#getNonFunctionalRequirement <em>Non Functional Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Non Functional Requirement</em>'.
	 * @see org.unicase.model.testspec.LogicalTestCase#getNonFunctionalRequirement()
	 * @see #getLogicalTestCase()
	 * @generated
	 */
	EReference getLogicalTestCase_NonFunctionalRequirement();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.model.testspec.LogicalTestCase#getFunctionalRequirement <em>Functional Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Functional Requirement</em>'.
	 * @see org.unicase.model.testspec.LogicalTestCase#getFunctionalRequirement()
	 * @see #getLogicalTestCase()
	 * @generated
	 */
	EReference getLogicalTestCase_FunctionalRequirement();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.testspec.LogicalTestCase#getStep <em>Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Step</em>'.
	 * @see org.unicase.model.testspec.LogicalTestCase#getStep()
	 * @see #getLogicalTestCase()
	 * @generated
	 */
	EReference getLogicalTestCase_Step();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.testspec.TestStep <em>Test Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Step</em>'.
	 * @see org.unicase.model.testspec.TestStep
	 * @generated
	 */
	EClass getTestStep();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.testspec.TestStep#getException <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exception</em>'.
	 * @see org.unicase.model.testspec.TestStep#getException()
	 * @see #getTestStep()
	 * @generated
	 */
	EAttribute getTestStep_Exception();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.testspec.TestStep#getInputParamter <em>Input Paramter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input Paramter</em>'.
	 * @see org.unicase.model.testspec.TestStep#getInputParamter()
	 * @see #getTestStep()
	 * @generated
	 */
	EAttribute getTestStep_InputParamter();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.testspec.TestStep#getOutputParameter <em>Output Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output Parameter</em>'.
	 * @see org.unicase.model.testspec.TestStep#getOutputParameter()
	 * @see #getTestStep()
	 * @generated
	 */
	EAttribute getTestStep_OutputParameter();

	/**
	 * Returns the meta object for enum '{@link org.unicase.model.testspec.EnumState <em>Enum State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Enum State</em>'.
	 * @see org.unicase.model.testspec.EnumState
	 * @generated
	 */
	EEnum getEnumState();

	/**
	 * Returns the meta object for enum '{@link org.unicase.model.testspec.EnumType <em>Enum Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Enum Type</em>'.
	 * @see org.unicase.model.testspec.EnumType
	 * @generated
	 */
	EEnum getEnumType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TestspecFactory getTestspecFactory();

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
		 * The meta object literal for the '{@link org.unicase.model.testspec.impl.TestProtocolImpl <em>Test Protocol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.testspec.impl.TestProtocolImpl
		 * @see org.unicase.model.testspec.impl.TestspecPackageImpl#getTestProtocol()
		 * @generated
		 */
		EClass TEST_PROTOCOL = eINSTANCE.getTestProtocol();

		/**
		 * The meta object literal for the '<em><b>Test Report</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_PROTOCOL__TEST_REPORT = eINSTANCE.getTestProtocol_TestReport();

		/**
		 * The meta object literal for the '<em><b>Test State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_PROTOCOL__TEST_STATE = eINSTANCE.getTestProtocol_TestState();

		/**
		 * The meta object literal for the '<em><b>Test Case</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_PROTOCOL__TEST_CASE = eINSTANCE.getTestProtocol_TestCase();

		/**
		 * The meta object literal for the '{@link org.unicase.model.testspec.impl.LogicalTestCaseImpl <em>Logical Test Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.testspec.impl.LogicalTestCaseImpl
		 * @see org.unicase.model.testspec.impl.TestspecPackageImpl#getLogicalTestCase()
		 * @generated
		 */
		EClass LOGICAL_TEST_CASE = eINSTANCE.getLogicalTestCase();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOGICAL_TEST_CASE__TYPE = eINSTANCE.getLogicalTestCase_Type();

		/**
		 * The meta object literal for the '<em><b>Precondition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOGICAL_TEST_CASE__PRECONDITION = eINSTANCE.getLogicalTestCase_Precondition();

		/**
		 * The meta object literal for the '<em><b>Postcondition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOGICAL_TEST_CASE__POSTCONDITION = eINSTANCE.getLogicalTestCase_Postcondition();

		/**
		 * The meta object literal for the '<em><b>Infrastructure</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOGICAL_TEST_CASE__INFRASTRUCTURE = eINSTANCE.getLogicalTestCase_Infrastructure();

		/**
		 * The meta object literal for the '<em><b>Non Functional Requirement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOGICAL_TEST_CASE__NON_FUNCTIONAL_REQUIREMENT = eINSTANCE.getLogicalTestCase_NonFunctionalRequirement();

		/**
		 * The meta object literal for the '<em><b>Functional Requirement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOGICAL_TEST_CASE__FUNCTIONAL_REQUIREMENT = eINSTANCE.getLogicalTestCase_FunctionalRequirement();

		/**
		 * The meta object literal for the '<em><b>Step</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOGICAL_TEST_CASE__STEP = eINSTANCE.getLogicalTestCase_Step();

		/**
		 * The meta object literal for the '{@link org.unicase.model.testspec.impl.TestStepImpl <em>Test Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.testspec.impl.TestStepImpl
		 * @see org.unicase.model.testspec.impl.TestspecPackageImpl#getTestStep()
		 * @generated
		 */
		EClass TEST_STEP = eINSTANCE.getTestStep();

		/**
		 * The meta object literal for the '<em><b>Exception</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_STEP__EXCEPTION = eINSTANCE.getTestStep_Exception();

		/**
		 * The meta object literal for the '<em><b>Input Paramter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_STEP__INPUT_PARAMTER = eINSTANCE.getTestStep_InputParamter();

		/**
		 * The meta object literal for the '<em><b>Output Parameter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_STEP__OUTPUT_PARAMETER = eINSTANCE.getTestStep_OutputParameter();

		/**
		 * The meta object literal for the '{@link org.unicase.model.testspec.EnumState <em>Enum State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.testspec.EnumState
		 * @see org.unicase.model.testspec.impl.TestspecPackageImpl#getEnumState()
		 * @generated
		 */
		EEnum ENUM_STATE = eINSTANCE.getEnumState();

		/**
		 * The meta object literal for the '{@link org.unicase.model.testspec.EnumType <em>Enum Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.testspec.EnumType
		 * @see org.unicase.model.testspec.impl.TestspecPackageImpl#getEnumType()
		 * @generated
		 */
		EEnum ENUM_TYPE = eINSTANCE.getEnumType();

	}

} //TestspecPackage
