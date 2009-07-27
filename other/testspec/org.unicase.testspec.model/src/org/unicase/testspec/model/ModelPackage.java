/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.testspec.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.unicase.testspec.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/testspecmodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.testspec.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = org.unicase.testspec.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.testspec.model.impl.TestProtocolImpl <em>Test Protocol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.testspec.model.impl.TestProtocolImpl
	 * @see org.unicase.testspec.model.impl.ModelPackageImpl#getTestProtocol()
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
	int TEST_PROTOCOL__IDENTIFIER = org.unicase.model.ModelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__NAME = org.unicase.model.ModelPackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__DESCRIPTION = org.unicase.model.ModelPackage.MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__CREATOR = org.unicase.model.ModelPackage.MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__CREATION_DATE = org.unicase.model.ModelPackage.MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__ANNOTATIONS = org.unicase.model.ModelPackage.MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__ATTACHMENTS = org.unicase.model.ModelPackage.MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__INCOMING_DOCUMENT_REFERENCES = org.unicase.model.ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__LEAF_SECTION = org.unicase.model.ModelPackage.MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__STATE = org.unicase.model.ModelPackage.MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__APPLIED_STEREOTYPE_INSTANCES = org.unicase.model.ModelPackage.MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__COMMENTS = org.unicase.model.ModelPackage.MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Test Report</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__TEST_REPORT = org.unicase.model.ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Test Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__TEST_DESCRIPTION = org.unicase.model.ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Local Test Cases</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__LOCAL_TEST_CASES = org.unicase.model.ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Concrete Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__CONCRETE_PARAMETER = org.unicase.model.ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Test State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL__TEST_STATE = org.unicase.model.ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Test Protocol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_PROTOCOL_FEATURE_COUNT = org.unicase.model.ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.unicase.testspec.model.impl.LogicalTestCaseImpl <em>Logical Test Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.testspec.model.impl.LogicalTestCaseImpl
	 * @see org.unicase.testspec.model.impl.ModelPackageImpl#getLogicalTestCase()
	 * @generated
	 */
	int LOGICAL_TEST_CASE = 1;

	/**
	 * The feature id for the '<em><b>Tc Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__TC_DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Precondition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__PRECONDITION = 2;

	/**
	 * The feature id for the '<em><b>Postcondition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__POSTCONDITION = 3;

	/**
	 * The feature id for the '<em><b>Infrastructure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__INFRASTRUCTURE = 4;

	/**
	 * The feature id for the '<em><b>Test Protocol</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__TEST_PROTOCOL = 5;

	/**
	 * The feature id for the '<em><b>Test Step</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__TEST_STEP = 6;

	/**
	 * The feature id for the '<em><b>Non Functional Requirement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__NON_FUNCTIONAL_REQUIREMENT = 7;

	/**
	 * The feature id for the '<em><b>Functional Requirement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE__FUNCTIONAL_REQUIREMENT = 8;

	/**
	 * The number of structural features of the '<em>Logical Test Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_TEST_CASE_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link org.unicase.testspec.model.impl.ConcreteParameterImpl <em>Concrete Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.testspec.model.impl.ConcreteParameterImpl
	 * @see org.unicase.testspec.model.impl.ModelPackageImpl#getConcreteParameter()
	 * @generated
	 */
	int CONCRETE_PARAMETER = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_PARAMETER__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_PARAMETER__PARAMETER = 1;

	/**
	 * The number of structural features of the '<em>Concrete Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_PARAMETER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.unicase.testspec.model.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.testspec.model.impl.ParameterImpl
	 * @see org.unicase.testspec.model.impl.ModelPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__RANGE = 2;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.unicase.testspec.model.impl.TestStepImpl <em>Test Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.testspec.model.impl.TestStepImpl
	 * @see org.unicase.testspec.model.impl.ModelPackageImpl#getTestStep()
	 * @generated
	 */
	int TEST_STEP = 4;

	/**
	 * The feature id for the '<em><b>Exception</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP__EXCEPTION = 0;

	/**
	 * The feature id for the '<em><b>Output Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP__OUTPUT_PARAMETER = 1;

	/**
	 * The feature id for the '<em><b>Inputparameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP__INPUTPARAMETER = 2;

	/**
	 * The number of structural features of the '<em>Test Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.unicase.testspec.model.impl.InputParameterImpl <em>Input Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.testspec.model.impl.InputParameterImpl
	 * @see org.unicase.testspec.model.impl.ModelPackageImpl#getInputParameter()
	 * @generated
	 */
	int INPUT_PARAMETER = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PARAMETER__NAME = PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PARAMETER__TYPE = PARAMETER__TYPE;

	/**
	 * The feature id for the '<em><b>Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PARAMETER__RANGE = PARAMETER__RANGE;

	/**
	 * The number of structural features of the '<em>Input Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.testspec.model.impl.OutputParameterImpl <em>Output Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.testspec.model.impl.OutputParameterImpl
	 * @see org.unicase.testspec.model.impl.ModelPackageImpl#getOutputParameter()
	 * @generated
	 */
	int OUTPUT_PARAMETER = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PARAMETER__NAME = PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PARAMETER__TYPE = PARAMETER__TYPE;

	/**
	 * The feature id for the '<em><b>Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PARAMETER__RANGE = PARAMETER__RANGE;

	/**
	 * The number of structural features of the '<em>Output Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.testspec.model.EnumState <em>Enum State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.testspec.model.EnumState
	 * @see org.unicase.testspec.model.impl.ModelPackageImpl#getEnumState()
	 * @generated
	 */
	int ENUM_STATE = 7;

	/**
	 * The meta object id for the '{@link org.unicase.testspec.model.EnumType <em>Enum Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.testspec.model.EnumType
	 * @see org.unicase.testspec.model.impl.ModelPackageImpl#getEnumType()
	 * @generated
	 */
	int ENUM_TYPE = 8;


	/**
	 * Returns the meta object for class '{@link org.unicase.testspec.model.TestProtocol <em>Test Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Protocol</em>'.
	 * @see org.unicase.testspec.model.TestProtocol
	 * @generated
	 */
	EClass getTestProtocol();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.testspec.model.TestProtocol#getTestReport <em>Test Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Report</em>'.
	 * @see org.unicase.testspec.model.TestProtocol#getTestReport()
	 * @see #getTestProtocol()
	 * @generated
	 */
	EAttribute getTestProtocol_TestReport();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.testspec.model.TestProtocol#getTestDescription <em>Test Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Description</em>'.
	 * @see org.unicase.testspec.model.TestProtocol#getTestDescription()
	 * @see #getTestProtocol()
	 * @generated
	 */
	EAttribute getTestProtocol_TestDescription();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.testspec.model.TestProtocol#getLocalTestCases <em>Local Test Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Local Test Cases</em>'.
	 * @see org.unicase.testspec.model.TestProtocol#getLocalTestCases()
	 * @see #getTestProtocol()
	 * @generated
	 */
	EReference getTestProtocol_LocalTestCases();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.testspec.model.TestProtocol#getConcreteParameter <em>Concrete Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Concrete Parameter</em>'.
	 * @see org.unicase.testspec.model.TestProtocol#getConcreteParameter()
	 * @see #getTestProtocol()
	 * @generated
	 */
	EReference getTestProtocol_ConcreteParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.testspec.model.TestProtocol#getTestState <em>Test State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test State</em>'.
	 * @see org.unicase.testspec.model.TestProtocol#getTestState()
	 * @see #getTestProtocol()
	 * @generated
	 */
	EAttribute getTestProtocol_TestState();

	/**
	 * Returns the meta object for class '{@link org.unicase.testspec.model.LogicalTestCase <em>Logical Test Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logical Test Case</em>'.
	 * @see org.unicase.testspec.model.LogicalTestCase
	 * @generated
	 */
	EClass getLogicalTestCase();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.testspec.model.LogicalTestCase#getTcDescription <em>Tc Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tc Description</em>'.
	 * @see org.unicase.testspec.model.LogicalTestCase#getTcDescription()
	 * @see #getLogicalTestCase()
	 * @generated
	 */
	EAttribute getLogicalTestCase_TcDescription();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.testspec.model.LogicalTestCase#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.unicase.testspec.model.LogicalTestCase#getType()
	 * @see #getLogicalTestCase()
	 * @generated
	 */
	EAttribute getLogicalTestCase_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.testspec.model.LogicalTestCase#getPrecondition <em>Precondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Precondition</em>'.
	 * @see org.unicase.testspec.model.LogicalTestCase#getPrecondition()
	 * @see #getLogicalTestCase()
	 * @generated
	 */
	EAttribute getLogicalTestCase_Precondition();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.testspec.model.LogicalTestCase#getPostcondition <em>Postcondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Postcondition</em>'.
	 * @see org.unicase.testspec.model.LogicalTestCase#getPostcondition()
	 * @see #getLogicalTestCase()
	 * @generated
	 */
	EAttribute getLogicalTestCase_Postcondition();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.testspec.model.LogicalTestCase#getInfrastructure <em>Infrastructure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Infrastructure</em>'.
	 * @see org.unicase.testspec.model.LogicalTestCase#getInfrastructure()
	 * @see #getLogicalTestCase()
	 * @generated
	 */
	EAttribute getLogicalTestCase_Infrastructure();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.testspec.model.LogicalTestCase#getTestProtocol <em>Test Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Test Protocol</em>'.
	 * @see org.unicase.testspec.model.LogicalTestCase#getTestProtocol()
	 * @see #getLogicalTestCase()
	 * @generated
	 */
	EReference getLogicalTestCase_TestProtocol();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.testspec.model.LogicalTestCase#getTestStep <em>Test Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Test Step</em>'.
	 * @see org.unicase.testspec.model.LogicalTestCase#getTestStep()
	 * @see #getLogicalTestCase()
	 * @generated
	 */
	EReference getLogicalTestCase_TestStep();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.testspec.model.LogicalTestCase#getNonFunctionalRequirement <em>Non Functional Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Non Functional Requirement</em>'.
	 * @see org.unicase.testspec.model.LogicalTestCase#getNonFunctionalRequirement()
	 * @see #getLogicalTestCase()
	 * @generated
	 */
	EReference getLogicalTestCase_NonFunctionalRequirement();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.testspec.model.LogicalTestCase#getFunctionalRequirement <em>Functional Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Functional Requirement</em>'.
	 * @see org.unicase.testspec.model.LogicalTestCase#getFunctionalRequirement()
	 * @see #getLogicalTestCase()
	 * @generated
	 */
	EReference getLogicalTestCase_FunctionalRequirement();

	/**
	 * Returns the meta object for class '{@link org.unicase.testspec.model.ConcreteParameter <em>Concrete Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concrete Parameter</em>'.
	 * @see org.unicase.testspec.model.ConcreteParameter
	 * @generated
	 */
	EClass getConcreteParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.testspec.model.ConcreteParameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.unicase.testspec.model.ConcreteParameter#getValue()
	 * @see #getConcreteParameter()
	 * @generated
	 */
	EAttribute getConcreteParameter_Value();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.testspec.model.ConcreteParameter#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter</em>'.
	 * @see org.unicase.testspec.model.ConcreteParameter#getParameter()
	 * @see #getConcreteParameter()
	 * @generated
	 */
	EReference getConcreteParameter_Parameter();

	/**
	 * Returns the meta object for class '{@link org.unicase.testspec.model.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.unicase.testspec.model.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.testspec.model.Parameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.unicase.testspec.model.Parameter#getName()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.testspec.model.Parameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.unicase.testspec.model.Parameter#getType()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.testspec.model.Parameter#getRange <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Range</em>'.
	 * @see org.unicase.testspec.model.Parameter#getRange()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Range();

	/**
	 * Returns the meta object for class '{@link org.unicase.testspec.model.TestStep <em>Test Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Step</em>'.
	 * @see org.unicase.testspec.model.TestStep
	 * @generated
	 */
	EClass getTestStep();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.testspec.model.TestStep#getException <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exception</em>'.
	 * @see org.unicase.testspec.model.TestStep#getException()
	 * @see #getTestStep()
	 * @generated
	 */
	EAttribute getTestStep_Exception();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.testspec.model.TestStep#getOutputParameter <em>Output Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Parameter</em>'.
	 * @see org.unicase.testspec.model.TestStep#getOutputParameter()
	 * @see #getTestStep()
	 * @generated
	 */
	EReference getTestStep_OutputParameter();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.testspec.model.TestStep#getInputparameter <em>Inputparameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputparameter</em>'.
	 * @see org.unicase.testspec.model.TestStep#getInputparameter()
	 * @see #getTestStep()
	 * @generated
	 */
	EReference getTestStep_Inputparameter();

	/**
	 * Returns the meta object for class '{@link org.unicase.testspec.model.InputParameter <em>Input Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Parameter</em>'.
	 * @see org.unicase.testspec.model.InputParameter
	 * @generated
	 */
	EClass getInputParameter();

	/**
	 * Returns the meta object for class '{@link org.unicase.testspec.model.OutputParameter <em>Output Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Parameter</em>'.
	 * @see org.unicase.testspec.model.OutputParameter
	 * @generated
	 */
	EClass getOutputParameter();

	/**
	 * Returns the meta object for enum '{@link org.unicase.testspec.model.EnumState <em>Enum State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Enum State</em>'.
	 * @see org.unicase.testspec.model.EnumState
	 * @generated
	 */
	EEnum getEnumState();

	/**
	 * Returns the meta object for enum '{@link org.unicase.testspec.model.EnumType <em>Enum Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Enum Type</em>'.
	 * @see org.unicase.testspec.model.EnumType
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
	ModelFactory getModelFactory();

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
		 * The meta object literal for the '{@link org.unicase.testspec.model.impl.TestProtocolImpl <em>Test Protocol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.testspec.model.impl.TestProtocolImpl
		 * @see org.unicase.testspec.model.impl.ModelPackageImpl#getTestProtocol()
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
		 * The meta object literal for the '<em><b>Test Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_PROTOCOL__TEST_DESCRIPTION = eINSTANCE.getTestProtocol_TestDescription();

		/**
		 * The meta object literal for the '<em><b>Local Test Cases</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_PROTOCOL__LOCAL_TEST_CASES = eINSTANCE.getTestProtocol_LocalTestCases();

		/**
		 * The meta object literal for the '<em><b>Concrete Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_PROTOCOL__CONCRETE_PARAMETER = eINSTANCE.getTestProtocol_ConcreteParameter();

		/**
		 * The meta object literal for the '<em><b>Test State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_PROTOCOL__TEST_STATE = eINSTANCE.getTestProtocol_TestState();

		/**
		 * The meta object literal for the '{@link org.unicase.testspec.model.impl.LogicalTestCaseImpl <em>Logical Test Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.testspec.model.impl.LogicalTestCaseImpl
		 * @see org.unicase.testspec.model.impl.ModelPackageImpl#getLogicalTestCase()
		 * @generated
		 */
		EClass LOGICAL_TEST_CASE = eINSTANCE.getLogicalTestCase();

		/**
		 * The meta object literal for the '<em><b>Tc Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOGICAL_TEST_CASE__TC_DESCRIPTION = eINSTANCE.getLogicalTestCase_TcDescription();

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
		 * The meta object literal for the '<em><b>Test Protocol</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOGICAL_TEST_CASE__TEST_PROTOCOL = eINSTANCE.getLogicalTestCase_TestProtocol();

		/**
		 * The meta object literal for the '<em><b>Test Step</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOGICAL_TEST_CASE__TEST_STEP = eINSTANCE.getLogicalTestCase_TestStep();

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
		 * The meta object literal for the '{@link org.unicase.testspec.model.impl.ConcreteParameterImpl <em>Concrete Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.testspec.model.impl.ConcreteParameterImpl
		 * @see org.unicase.testspec.model.impl.ModelPackageImpl#getConcreteParameter()
		 * @generated
		 */
		EClass CONCRETE_PARAMETER = eINSTANCE.getConcreteParameter();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONCRETE_PARAMETER__VALUE = eINSTANCE.getConcreteParameter_Value();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_PARAMETER__PARAMETER = eINSTANCE.getConcreteParameter_Parameter();

		/**
		 * The meta object literal for the '{@link org.unicase.testspec.model.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.testspec.model.impl.ParameterImpl
		 * @see org.unicase.testspec.model.impl.ModelPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__TYPE = eINSTANCE.getParameter_Type();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__RANGE = eINSTANCE.getParameter_Range();

		/**
		 * The meta object literal for the '{@link org.unicase.testspec.model.impl.TestStepImpl <em>Test Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.testspec.model.impl.TestStepImpl
		 * @see org.unicase.testspec.model.impl.ModelPackageImpl#getTestStep()
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
		 * The meta object literal for the '<em><b>Output Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_STEP__OUTPUT_PARAMETER = eINSTANCE.getTestStep_OutputParameter();

		/**
		 * The meta object literal for the '<em><b>Inputparameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_STEP__INPUTPARAMETER = eINSTANCE.getTestStep_Inputparameter();

		/**
		 * The meta object literal for the '{@link org.unicase.testspec.model.impl.InputParameterImpl <em>Input Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.testspec.model.impl.InputParameterImpl
		 * @see org.unicase.testspec.model.impl.ModelPackageImpl#getInputParameter()
		 * @generated
		 */
		EClass INPUT_PARAMETER = eINSTANCE.getInputParameter();

		/**
		 * The meta object literal for the '{@link org.unicase.testspec.model.impl.OutputParameterImpl <em>Output Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.testspec.model.impl.OutputParameterImpl
		 * @see org.unicase.testspec.model.impl.ModelPackageImpl#getOutputParameter()
		 * @generated
		 */
		EClass OUTPUT_PARAMETER = eINSTANCE.getOutputParameter();

		/**
		 * The meta object literal for the '{@link org.unicase.testspec.model.EnumState <em>Enum State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.testspec.model.EnumState
		 * @see org.unicase.testspec.model.impl.ModelPackageImpl#getEnumState()
		 * @generated
		 */
		EEnum ENUM_STATE = eINSTANCE.getEnumState();

		/**
		 * The meta object literal for the '{@link org.unicase.testspec.model.EnumType <em>Enum Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.testspec.model.EnumType
		 * @see org.unicase.testspec.model.impl.ModelPackageImpl#getEnumType()
		 * @generated
		 */
		EEnum ENUM_TYPE = eINSTANCE.getEnumType();

	}

} //ModelPackage
