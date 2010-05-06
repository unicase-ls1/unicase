/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.testspec.impl;

import java.util.Map;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.unicase.metamodel.MetamodelPackage;

import org.unicase.model.ModelPackage;

import org.unicase.model.requirement.RequirementPackage;

import org.unicase.model.testspec.EnumState;
import org.unicase.model.testspec.EnumType;
import org.unicase.model.testspec.TestCase;
import org.unicase.model.testspec.TestProtocol;
import org.unicase.model.testspec.TestStep;
import org.unicase.model.testspec.TestStepInput;
import org.unicase.model.testspec.TestStepOutput;
import org.unicase.model.testspec.TestspecFactory;
import org.unicase.model.testspec.TestspecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestspecPackageImpl extends EPackageImpl implements TestspecPackage {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass testProtocolEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass testCaseEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass testStepEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass testStepInputEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass testStepOutputEClass = null;

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass testProtocolToStringMapEClass = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EEnum enumStateEEnum = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EEnum enumTypeEEnum = null;

	/**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.unicase.model.testspec.TestspecPackage#eNS_URI
     * @see #init()
     * @generated
     */
	private TestspecPackageImpl() {
        super(eNS_URI, TestspecFactory.eINSTANCE);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static boolean isInited = false;

	/**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link TestspecPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
	public static TestspecPackage init() {
        if (isInited) return (TestspecPackage)EPackage.Registry.INSTANCE.getEPackage(TestspecPackage.eNS_URI);

        // Obtain or create and register package
        TestspecPackageImpl theTestspecPackage = (TestspecPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TestspecPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TestspecPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        ModelPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theTestspecPackage.createPackageContents();

        // Initialize created meta-data
        theTestspecPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theTestspecPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(TestspecPackage.eNS_URI, theTestspecPackage);
        return theTestspecPackage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTestProtocol() {
        return testProtocolEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getTestProtocol_TestReport() {
        return (EAttribute)testProtocolEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getTestProtocol_TestState() {
        return (EAttribute)testProtocolEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTestProtocol_TestCase() {
        return (EReference)testProtocolEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTestProtocol_TestSteps() {
        return (EReference)testProtocolEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTestCase() {
        return testCaseEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getTestCase_Type() {
        return (EAttribute)testCaseEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getTestCase_Precondition() {
        return (EAttribute)testCaseEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getTestCase_Postcondition() {
        return (EAttribute)testCaseEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getTestCase_Infrastructure() {
        return (EAttribute)testCaseEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTestCase_NonFunctionalRequirement() {
        return (EReference)testCaseEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTestCase_FunctionalRequirement() {
        return (EReference)testCaseEClass.getEStructuralFeatures().get(5);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTestCase_Step() {
        return (EReference)testCaseEClass.getEStructuralFeatures().get(6);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTestStep() {
        return testStepEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getTestStep_Exception() {
        return (EAttribute)testStepEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTestStep_Input() {
        return (EReference)testStepEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTestStep_Output() {
        return (EReference)testStepEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTestStepInput() {
        return testStepInputEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getTestStepInput_Type() {
        return (EAttribute)testStepInputEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getTestStepInput_Range() {
        return (EAttribute)testStepInputEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTestStepInput_TestStep() {
        return (EReference)testStepInputEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTestStepInput_Values() {
        return (EReference)testStepInputEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTestStepOutput() {
        return testStepOutputEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getTestStepOutput_Type() {
        return (EAttribute)testStepOutputEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getTestStepOutput_Range() {
        return (EAttribute)testStepOutputEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTestStepOutput_TestStep() {
        return (EReference)testStepOutputEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTestStepOutput_Values() {
        return (EReference)testStepOutputEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTestProtocolToStringMap() {
        return testProtocolToStringMapEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTestProtocolToStringMap_Value() {
        return (EAttribute)testProtocolToStringMapEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTestProtocolToStringMap_Key() {
        return (EReference)testProtocolToStringMapEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EEnum getEnumState() {
        return enumStateEEnum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EEnum getEnumType() {
        return enumTypeEEnum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TestspecFactory getTestspecFactory() {
        return (TestspecFactory)getEFactoryInstance();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private boolean isCreated = false;

	/**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        testProtocolEClass = createEClass(TEST_PROTOCOL);
        createEAttribute(testProtocolEClass, TEST_PROTOCOL__TEST_REPORT);
        createEAttribute(testProtocolEClass, TEST_PROTOCOL__TEST_STATE);
        createEReference(testProtocolEClass, TEST_PROTOCOL__TEST_CASE);
        createEReference(testProtocolEClass, TEST_PROTOCOL__TEST_STEPS);

        testCaseEClass = createEClass(TEST_CASE);
        createEAttribute(testCaseEClass, TEST_CASE__TYPE);
        createEAttribute(testCaseEClass, TEST_CASE__PRECONDITION);
        createEAttribute(testCaseEClass, TEST_CASE__POSTCONDITION);
        createEAttribute(testCaseEClass, TEST_CASE__INFRASTRUCTURE);
        createEReference(testCaseEClass, TEST_CASE__NON_FUNCTIONAL_REQUIREMENT);
        createEReference(testCaseEClass, TEST_CASE__FUNCTIONAL_REQUIREMENT);
        createEReference(testCaseEClass, TEST_CASE__STEP);

        testStepEClass = createEClass(TEST_STEP);
        createEAttribute(testStepEClass, TEST_STEP__EXCEPTION);
        createEReference(testStepEClass, TEST_STEP__INPUT);
        createEReference(testStepEClass, TEST_STEP__OUTPUT);

        testStepInputEClass = createEClass(TEST_STEP_INPUT);
        createEAttribute(testStepInputEClass, TEST_STEP_INPUT__TYPE);
        createEAttribute(testStepInputEClass, TEST_STEP_INPUT__RANGE);
        createEReference(testStepInputEClass, TEST_STEP_INPUT__TEST_STEP);
        createEReference(testStepInputEClass, TEST_STEP_INPUT__VALUES);

        testStepOutputEClass = createEClass(TEST_STEP_OUTPUT);
        createEAttribute(testStepOutputEClass, TEST_STEP_OUTPUT__TYPE);
        createEAttribute(testStepOutputEClass, TEST_STEP_OUTPUT__RANGE);
        createEReference(testStepOutputEClass, TEST_STEP_OUTPUT__TEST_STEP);
        createEReference(testStepOutputEClass, TEST_STEP_OUTPUT__VALUES);

        testProtocolToStringMapEClass = createEClass(TEST_PROTOCOL_TO_STRING_MAP);
        createEReference(testProtocolToStringMapEClass, TEST_PROTOCOL_TO_STRING_MAP__KEY);
        createEAttribute(testProtocolToStringMapEClass, TEST_PROTOCOL_TO_STRING_MAP__VALUE);

        // Create enums
        enumStateEEnum = createEEnum(ENUM_STATE);
        enumTypeEEnum = createEEnum(ENUM_TYPE);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private boolean isInitialized = false;

	/**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        ModelPackage theModelPackage = (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);
        MetamodelPackage theMetamodelPackage = (MetamodelPackage)EPackage.Registry.INSTANCE.getEPackage(MetamodelPackage.eNS_URI);
        RequirementPackage theRequirementPackage = (RequirementPackage)EPackage.Registry.INSTANCE.getEPackage(RequirementPackage.eNS_URI);
        EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        testProtocolEClass.getESuperTypes().add(theModelPackage.getUnicaseModelElement());
        testCaseEClass.getESuperTypes().add(theModelPackage.getUnicaseModelElement());
        testStepEClass.getESuperTypes().add(theModelPackage.getUnicaseModelElement());
        testStepInputEClass.getESuperTypes().add(theModelPackage.getUnicaseModelElement());
        testStepInputEClass.getESuperTypes().add(theMetamodelPackage.getNonDomainElement());
        testStepOutputEClass.getESuperTypes().add(theModelPackage.getUnicaseModelElement());
        testStepOutputEClass.getESuperTypes().add(theMetamodelPackage.getNonDomainElement());

        // Initialize classes and features; add operations and parameters
        initEClass(testProtocolEClass, TestProtocol.class, "TestProtocol", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTestProtocol_TestReport(), ecorePackage.getEString(), "testReport", null, 0, 1, TestProtocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTestProtocol_TestState(), this.getEnumState(), "testState", null, 0, 1, TestProtocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTestProtocol_TestCase(), this.getTestCase(), null, "testCase", null, 0, 1, TestProtocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        getTestProtocol_TestCase().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
        initEReference(getTestProtocol_TestSteps(), this.getTestStep(), null, "testSteps", null, 0, 1, TestProtocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        getTestProtocol_TestSteps().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());

        initEClass(testCaseEClass, TestCase.class, "TestCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTestCase_Type(), this.getEnumType(), "type", null, 0, 1, TestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTestCase_Precondition(), ecorePackage.getEString(), "precondition", null, 0, 1, TestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTestCase_Postcondition(), ecorePackage.getEString(), "postcondition", null, 0, 1, TestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTestCase_Infrastructure(), ecorePackage.getEString(), "infrastructure", null, 0, 1, TestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTestCase_NonFunctionalRequirement(), theRequirementPackage.getNonFunctionalRequirement(), null, "nonFunctionalRequirement", null, 0, 1, TestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTestCase_FunctionalRequirement(), theRequirementPackage.getFunctionalRequirement(), null, "functionalRequirement", null, 0, 1, TestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTestCase_Step(), this.getTestStep(), null, "step", null, 0, -1, TestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        getTestCase_Step().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());

        initEClass(testStepEClass, TestStep.class, "TestStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTestStep_Exception(), ecorePackage.getEString(), "exception", null, 0, 1, TestStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTestStep_Input(), this.getTestStepInput(), this.getTestStepInput_TestStep(), "input", null, 0, -1, TestStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        getTestStep_Input().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
        initEReference(getTestStep_Output(), this.getTestStepOutput(), this.getTestStepOutput_TestStep(), "output", null, 0, -1, TestStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        getTestStep_Output().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());

        initEClass(testStepInputEClass, TestStepInput.class, "TestStepInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTestStepInput_Type(), theEcorePackage.getEString(), "type", null, 0, 1, TestStepInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTestStepInput_Range(), theEcorePackage.getEString(), "range", null, 0, 1, TestStepInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTestStepInput_TestStep(), this.getTestStep(), this.getTestStep_Input(), "testStep", null, 0, 1, TestStepInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        getTestStepInput_TestStep().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
        initEReference(getTestStepInput_Values(), this.getTestProtocolToStringMap(), null, "values", null, 0, -1, TestStepInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(testStepOutputEClass, TestStepOutput.class, "TestStepOutput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTestStepOutput_Type(), theEcorePackage.getEString(), "type", null, 0, 1, TestStepOutput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTestStepOutput_Range(), theEcorePackage.getEString(), "range", null, 0, 1, TestStepOutput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTestStepOutput_TestStep(), this.getTestStep(), this.getTestStep_Output(), "testStep", null, 0, 1, TestStepOutput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        getTestStepOutput_TestStep().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
        initEReference(getTestStepOutput_Values(), this.getTestProtocolToStringMap(), null, "values", null, 0, -1, TestStepOutput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(testProtocolToStringMapEClass, Map.Entry.class, "TestProtocolToStringMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTestProtocolToStringMap_Key(), this.getTestProtocol(), null, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTestProtocolToStringMap_Value(), theEcorePackage.getEString(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(enumStateEEnum, EnumState.class, "EnumState");
        addEEnumLiteral(enumStateEEnum, EnumState.UNSET);
        addEEnumLiteral(enumStateEEnum, EnumState.PASSED);
        addEEnumLiteral(enumStateEEnum, EnumState.FAILED);

        initEEnum(enumTypeEEnum, EnumType.class, "EnumType");
        addEEnumLiteral(enumTypeEEnum, EnumType.UNIT);
        addEEnumLiteral(enumTypeEEnum, EnumType.SYSTEM);
        addEEnumLiteral(enumTypeEEnum, EnumType.INTEGRATION);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // org.unicase.ui.meeditor
        createOrgAnnotations();
    }

	/**
     * Initializes the annotations for <b>org.unicase.ui.meeditor</b>.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void createOrgAnnotations() {
        String source = "org.unicase.ui.meeditor";		
        addAnnotation
          (getTestProtocol_TestReport(), 
           source, 
           new String[] {
             "priority", "10.0",
             "position", "left"
           });		
        addAnnotation
          (getTestProtocol_TestState(), 
           source, 
           new String[] {
             "priority", "20.0",
             "position", "left"
           });		
        addAnnotation
          (getTestProtocol_TestCase(), 
           source, 
           new String[] {
             "priority", "30.0",
             "position", "left"
           });		
        addAnnotation
          (getTestProtocol_TestSteps(), 
           source, 
           new String[] {
             "priority", "1.0",
             "position", "bottom"
           });		
        addAnnotation
          (getTestCase_Type(), 
           source, 
           new String[] {
             "priority", "10.0",
             "position", "left"
           });		
        addAnnotation
          (getTestCase_Precondition(), 
           source, 
           new String[] {
             "priority", "20.0",
             "position", "left"
           });		
        addAnnotation
          (getTestCase_Postcondition(), 
           source, 
           new String[] {
             "priority", "30.0",
             "position", "left"
           });		
        addAnnotation
          (getTestCase_Infrastructure(), 
           source, 
           new String[] {
             "priority", "40.0",
             "position", "left"
           });		
        addAnnotation
          (getTestCase_NonFunctionalRequirement(), 
           source, 
           new String[] {
             "priority", "60.0",
             "position", "left"
           });		
        addAnnotation
          (getTestCase_FunctionalRequirement(), 
           source, 
           new String[] {
             "priority", "50.0",
             "position", "left"
           });		
        addAnnotation
          (getTestCase_Step(), 
           source, 
           new String[] {
             "priority", "70.0",
             "position", "left"
           });		
        addAnnotation
          (getTestStep_Exception(), 
           source, 
           new String[] {
             "priority", "10.0",
             "position", "left"
           });		
        addAnnotation
          (getTestStep_Input(), 
           source, 
           new String[] {
             "priority", "20.0",
             "position", "left"
           });		
        addAnnotation
          (getTestStep_Output(), 
           source, 
           new String[] {
             "priority", "30.0",
             "position", "left"
           });
    }

} //TestspecPackageImpl
