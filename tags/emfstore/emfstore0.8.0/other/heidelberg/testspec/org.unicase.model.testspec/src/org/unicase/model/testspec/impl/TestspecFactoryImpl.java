/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.testspec.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.model.testspec.*;
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
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestspecFactoryImpl extends EFactoryImpl implements TestspecFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TestspecFactory init() {
		try {
			TestspecFactory theTestspecFactory = (TestspecFactory)EPackage.Registry.INSTANCE.getEFactory("http://unicase.org/model/testspec"); 
			if (theTestspecFactory != null) {
				return theTestspecFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TestspecFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestspecFactoryImpl() {
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
			case TestspecPackage.TEST_PROTOCOL: return createTestProtocol();
			case TestspecPackage.TEST_CASE: return createTestCase();
			case TestspecPackage.TEST_STEP: return createTestStep();
			case TestspecPackage.TEST_STEP_INPUT: return createTestStepInput();
			case TestspecPackage.TEST_STEP_OUTPUT: return createTestStepOutput();
			case TestspecPackage.TEST_PROTOCOL_TO_STRING_MAP: return (EObject)createTestProtocolToStringMap();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case TestspecPackage.ENUM_STATE:
				return createEnumStateFromString(eDataType, initialValue);
			case TestspecPackage.ENUM_TYPE:
				return createEnumTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case TestspecPackage.ENUM_STATE:
				return convertEnumStateToString(eDataType, instanceValue);
			case TestspecPackage.ENUM_TYPE:
				return convertEnumTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestProtocol createTestProtocol() {
		TestProtocolImpl testProtocol = new TestProtocolImpl();
		return testProtocol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestCase createTestCase() {
		TestCaseImpl testCase = new TestCaseImpl();
		return testCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestStep createTestStep() {
		TestStepImpl testStep = new TestStepImpl();
		return testStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestStepInput createTestStepInput() {
		TestStepInputImpl testStepInput = new TestStepInputImpl();
		return testStepInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestStepOutput createTestStepOutput() {
		TestStepOutputImpl testStepOutput = new TestStepOutputImpl();
		return testStepOutput;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Map.Entry<TestProtocol, String> createTestProtocolToStringMap() {
		TestProtocolToStringMapImpl testProtocolToStringMap = new TestProtocolToStringMapImpl();
		return testProtocolToStringMap;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumState createEnumStateFromString(EDataType eDataType, String initialValue) {
		EnumState result = EnumState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEnumStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumType createEnumTypeFromString(EDataType eDataType, String initialValue) {
		EnumType result = EnumType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEnumTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestspecPackage getTestspecPackage() {
		return (TestspecPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TestspecPackage getPackage() {
		return TestspecPackage.eINSTANCE;
	}

} //TestspecFactoryImpl
