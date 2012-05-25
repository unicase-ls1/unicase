/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.testspec.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.model.impl.UnicaseModelElementImpl;
import org.unicase.model.testspec.EnumState;
import org.unicase.model.testspec.TestCase;
import org.unicase.model.testspec.TestProtocol;
import org.unicase.model.testspec.TestStep;
import org.unicase.model.testspec.TestspecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Protocol</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.testspec.impl.TestProtocolImpl#getTestState <em>Test State</em>}</li>
 *   <li>{@link org.unicase.model.testspec.impl.TestProtocolImpl#getTestCase <em>Test Case</em>}</li>
 *   <li>{@link org.unicase.model.testspec.impl.TestProtocolImpl#getTestSteps <em>Test Steps</em>}</li>
 *   <li>{@link org.unicase.model.testspec.impl.TestProtocolImpl#getTestReport <em>Test Report</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestProtocolImpl extends UnicaseModelElementImpl implements TestProtocol {
	/**
	 * The default value of the '{@link #getTestState() <em>Test State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestState()
	 * @generated
	 * @ordered
	 */
	protected static final EnumState TEST_STATE_EDEFAULT = EnumState.UNSET;

	/**
	 * The cached value of the '{@link #getTestState() <em>Test State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestState()
	 * @generated
	 * @ordered
	 */
	protected EnumState testState = TEST_STATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTestCase() <em>Test Case</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestCase()
	 * @generated
	 * @ordered
	 */
	protected TestCase testCase;

	/**
	 * The cached value of the '{@link #getTestSteps() <em>Test Steps</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestSteps()
	 * @generated
	 * @ordered
	 */
	protected TestStep testSteps;

	/**
	 * The default value of the '{@link #getTestReport() <em>Test Report</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestReport()
	 * @generated
	 * @ordered
	 */
	protected static final String TEST_REPORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTestReport() <em>Test Report</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestReport()
	 * @generated
	 * @ordered
	 */
	protected String testReport = TEST_REPORT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestProtocolImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestspecPackage.Literals.TEST_PROTOCOL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumState getTestState() {
		return testState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestState(EnumState newTestState) {
		EnumState oldTestState = testState;
		testState = newTestState == null ? TEST_STATE_EDEFAULT : newTestState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestspecPackage.TEST_PROTOCOL__TEST_STATE, oldTestState, testState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestCase getTestCase() {
		if (testCase != null && testCase.eIsProxy()) {
			InternalEObject oldTestCase = (InternalEObject)testCase;
			testCase = (TestCase)eResolveProxy(oldTestCase);
			if (testCase != oldTestCase) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestspecPackage.TEST_PROTOCOL__TEST_CASE, oldTestCase, testCase));
			}
		}
		return testCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestCase basicGetTestCase() {
		return testCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTestCase(TestCase newTestCase, NotificationChain msgs) {
		TestCase oldTestCase = testCase;
		testCase = newTestCase;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestspecPackage.TEST_PROTOCOL__TEST_CASE, oldTestCase, newTestCase);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestCase(TestCase newTestCase) {
		if (newTestCase != testCase) {
			NotificationChain msgs = null;
			if (testCase != null)
				msgs = ((InternalEObject)testCase).eInverseRemove(this, TestspecPackage.TEST_CASE__TEST_PROTOCOL, TestCase.class, msgs);
			if (newTestCase != null)
				msgs = ((InternalEObject)newTestCase).eInverseAdd(this, TestspecPackage.TEST_CASE__TEST_PROTOCOL, TestCase.class, msgs);
			msgs = basicSetTestCase(newTestCase, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestspecPackage.TEST_PROTOCOL__TEST_CASE, newTestCase, newTestCase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestStep getTestSteps() {
		if (testSteps != null && testSteps.eIsProxy()) {
			InternalEObject oldTestSteps = (InternalEObject)testSteps;
			testSteps = (TestStep)eResolveProxy(oldTestSteps);
			if (testSteps != oldTestSteps) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestspecPackage.TEST_PROTOCOL__TEST_STEPS, oldTestSteps, testSteps));
			}
		}
		return testSteps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestStep basicGetTestSteps() {
		return testSteps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestSteps(TestStep newTestSteps) {
		TestStep oldTestSteps = testSteps;
		testSteps = newTestSteps;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestspecPackage.TEST_PROTOCOL__TEST_STEPS, oldTestSteps, testSteps));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTestReport() {
		return testReport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestReport(String newTestReport) {
		String oldTestReport = testReport;
		testReport = newTestReport;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestspecPackage.TEST_PROTOCOL__TEST_REPORT, oldTestReport, testReport));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestspecPackage.TEST_PROTOCOL__TEST_CASE:
				if (testCase != null)
					msgs = ((InternalEObject)testCase).eInverseRemove(this, TestspecPackage.TEST_CASE__TEST_PROTOCOL, TestCase.class, msgs);
				return basicSetTestCase((TestCase)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestspecPackage.TEST_PROTOCOL__TEST_CASE:
				return basicSetTestCase(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestspecPackage.TEST_PROTOCOL__TEST_STATE:
				return getTestState();
			case TestspecPackage.TEST_PROTOCOL__TEST_CASE:
				if (resolve) return getTestCase();
				return basicGetTestCase();
			case TestspecPackage.TEST_PROTOCOL__TEST_STEPS:
				if (resolve) return getTestSteps();
				return basicGetTestSteps();
			case TestspecPackage.TEST_PROTOCOL__TEST_REPORT:
				return getTestReport();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestspecPackage.TEST_PROTOCOL__TEST_STATE:
				setTestState((EnumState)newValue);
				return;
			case TestspecPackage.TEST_PROTOCOL__TEST_CASE:
				setTestCase((TestCase)newValue);
				return;
			case TestspecPackage.TEST_PROTOCOL__TEST_STEPS:
				setTestSteps((TestStep)newValue);
				return;
			case TestspecPackage.TEST_PROTOCOL__TEST_REPORT:
				setTestReport((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestspecPackage.TEST_PROTOCOL__TEST_STATE:
				setTestState(TEST_STATE_EDEFAULT);
				return;
			case TestspecPackage.TEST_PROTOCOL__TEST_CASE:
				setTestCase((TestCase)null);
				return;
			case TestspecPackage.TEST_PROTOCOL__TEST_STEPS:
				setTestSteps((TestStep)null);
				return;
			case TestspecPackage.TEST_PROTOCOL__TEST_REPORT:
				setTestReport(TEST_REPORT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestspecPackage.TEST_PROTOCOL__TEST_STATE:
				return testState != TEST_STATE_EDEFAULT;
			case TestspecPackage.TEST_PROTOCOL__TEST_CASE:
				return testCase != null;
			case TestspecPackage.TEST_PROTOCOL__TEST_STEPS:
				return testSteps != null;
			case TestspecPackage.TEST_PROTOCOL__TEST_REPORT:
				return TEST_REPORT_EDEFAULT == null ? testReport != null : !TEST_REPORT_EDEFAULT.equals(testReport);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (testState: ");
		result.append(testState);
		result.append(", testReport: ");
		result.append(testReport);
		result.append(')');
		return result.toString();
	}

} //TestProtocolImpl
