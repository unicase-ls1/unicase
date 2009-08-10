/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.testspec.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.model.impl.ModelElementImpl;
import org.unicase.model.testspec.EnumState;
import org.unicase.model.testspec.LogicalTestCase;
import org.unicase.model.testspec.TestProtocol;
import org.unicase.model.testspec.TestspecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Protocol</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.testspec.impl.TestProtocolImpl#getTestReport <em>Test Report</em>}</li>
 *   <li>{@link org.unicase.model.testspec.impl.TestProtocolImpl#getTestState <em>Test State</em>}</li>
 *   <li>{@link org.unicase.model.testspec.impl.TestProtocolImpl#getTestCase <em>Test Case</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestProtocolImpl extends ModelElementImpl implements TestProtocol {
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
	 * The default value of the '{@link #getTestState() <em>Test State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestState()
	 * @generated
	 * @ordered
	 */
	protected static final EnumState TEST_STATE_EDEFAULT = EnumState.PASSED;

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
	protected LogicalTestCase testCase;

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
	public LogicalTestCase getTestCase() {
		if (testCase != null && testCase.eIsProxy()) {
			InternalEObject oldTestCase = (InternalEObject)testCase;
			testCase = (LogicalTestCase)eResolveProxy(oldTestCase);
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
	public LogicalTestCase basicGetTestCase() {
		return testCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestCase(LogicalTestCase newTestCase) {
		LogicalTestCase oldTestCase = testCase;
		testCase = newTestCase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestspecPackage.TEST_PROTOCOL__TEST_CASE, oldTestCase, testCase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestspecPackage.TEST_PROTOCOL__TEST_REPORT:
				return getTestReport();
			case TestspecPackage.TEST_PROTOCOL__TEST_STATE:
				return getTestState();
			case TestspecPackage.TEST_PROTOCOL__TEST_CASE:
				if (resolve) return getTestCase();
				return basicGetTestCase();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestspecPackage.TEST_PROTOCOL__TEST_REPORT:
				setTestReport((String)newValue);
				return;
			case TestspecPackage.TEST_PROTOCOL__TEST_STATE:
				setTestState((EnumState)newValue);
				return;
			case TestspecPackage.TEST_PROTOCOL__TEST_CASE:
				setTestCase((LogicalTestCase)newValue);
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
			case TestspecPackage.TEST_PROTOCOL__TEST_REPORT:
				setTestReport(TEST_REPORT_EDEFAULT);
				return;
			case TestspecPackage.TEST_PROTOCOL__TEST_STATE:
				setTestState(TEST_STATE_EDEFAULT);
				return;
			case TestspecPackage.TEST_PROTOCOL__TEST_CASE:
				setTestCase((LogicalTestCase)null);
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
			case TestspecPackage.TEST_PROTOCOL__TEST_REPORT:
				return TEST_REPORT_EDEFAULT == null ? testReport != null : !TEST_REPORT_EDEFAULT.equals(testReport);
			case TestspecPackage.TEST_PROTOCOL__TEST_STATE:
				return testState != TEST_STATE_EDEFAULT;
			case TestspecPackage.TEST_PROTOCOL__TEST_CASE:
				return testCase != null;
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
		result.append(" (testReport: ");
		result.append(testReport);
		result.append(", testState: ");
		result.append(testState);
		result.append(')');
		return result.toString();
	}

} //TestProtocolImpl
