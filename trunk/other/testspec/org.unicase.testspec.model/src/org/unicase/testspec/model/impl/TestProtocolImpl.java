/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.testspec.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.unicase.model.impl.ModelElementImpl;

import org.unicase.testspec.model.ConcreteParameter;
import org.unicase.testspec.model.EnumState;
import org.unicase.testspec.model.LogicalTestCase;
import org.unicase.testspec.model.ModelPackage;
import org.unicase.testspec.model.TestProtocol;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Protocol</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.testspec.model.impl.TestProtocolImpl#getTestReport <em>Test Report</em>}</li>
 *   <li>{@link org.unicase.testspec.model.impl.TestProtocolImpl#getTestDescription <em>Test Description</em>}</li>
 *   <li>{@link org.unicase.testspec.model.impl.TestProtocolImpl#getTestState <em>Test State</em>}</li>
 *   <li>{@link org.unicase.testspec.model.impl.TestProtocolImpl#getTestCase <em>Test Case</em>}</li>
 *   <li>{@link org.unicase.testspec.model.impl.TestProtocolImpl#getConcreteParamter <em>Concrete Paramter</em>}</li>
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
	 * The default value of the '{@link #getTestDescription() <em>Test Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String TEST_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTestDescription() <em>Test Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestDescription()
	 * @generated
	 * @ordered
	 */
	protected String testDescription = TEST_DESCRIPTION_EDEFAULT;

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
	 * The cached value of the '{@link #getTestCase() <em>Test Case</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestCase()
	 * @generated
	 * @ordered
	 */
	protected LogicalTestCase testCase;

	/**
	 * The cached value of the '{@link #getConcreteParamter() <em>Concrete Paramter</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcreteParamter()
	 * @generated
	 * @ordered
	 */
	protected EList<ConcreteParameter> concreteParamter;

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
		return ModelPackage.Literals.TEST_PROTOCOL;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_PROTOCOL__TEST_REPORT, oldTestReport, testReport));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTestDescription() {
		return testDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestDescription(String newTestDescription) {
		String oldTestDescription = testDescription;
		testDescription = newTestDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_PROTOCOL__TEST_DESCRIPTION, oldTestDescription, testDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalTestCase getTestCase() {
		return testCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTestCase(LogicalTestCase newTestCase, NotificationChain msgs) {
		LogicalTestCase oldTestCase = testCase;
		testCase = newTestCase;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_PROTOCOL__TEST_CASE, oldTestCase, newTestCase);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestCase(LogicalTestCase newTestCase) {
		if (newTestCase != testCase) {
			NotificationChain msgs = null;
			if (testCase != null)
				msgs = ((InternalEObject)testCase).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.TEST_PROTOCOL__TEST_CASE, null, msgs);
			if (newTestCase != null)
				msgs = ((InternalEObject)newTestCase).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.TEST_PROTOCOL__TEST_CASE, null, msgs);
			msgs = basicSetTestCase(newTestCase, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_PROTOCOL__TEST_CASE, newTestCase, newTestCase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConcreteParameter> getConcreteParamter() {
		if (concreteParamter == null) {
			concreteParamter = new EObjectResolvingEList<ConcreteParameter>(ConcreteParameter.class, this, ModelPackage.TEST_PROTOCOL__CONCRETE_PARAMTER);
		}
		return concreteParamter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.TEST_PROTOCOL__TEST_CASE:
				return basicSetTestCase(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_PROTOCOL__TEST_STATE, oldTestState, testState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.TEST_PROTOCOL__TEST_REPORT:
				return getTestReport();
			case ModelPackage.TEST_PROTOCOL__TEST_DESCRIPTION:
				return getTestDescription();
			case ModelPackage.TEST_PROTOCOL__TEST_STATE:
				return getTestState();
			case ModelPackage.TEST_PROTOCOL__TEST_CASE:
				return getTestCase();
			case ModelPackage.TEST_PROTOCOL__CONCRETE_PARAMTER:
				return getConcreteParamter();
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
			case ModelPackage.TEST_PROTOCOL__TEST_REPORT:
				setTestReport((String)newValue);
				return;
			case ModelPackage.TEST_PROTOCOL__TEST_DESCRIPTION:
				setTestDescription((String)newValue);
				return;
			case ModelPackage.TEST_PROTOCOL__TEST_STATE:
				setTestState((EnumState)newValue);
				return;
			case ModelPackage.TEST_PROTOCOL__TEST_CASE:
				setTestCase((LogicalTestCase)newValue);
				return;
			case ModelPackage.TEST_PROTOCOL__CONCRETE_PARAMTER:
				getConcreteParamter().clear();
				getConcreteParamter().addAll((Collection<? extends ConcreteParameter>)newValue);
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
			case ModelPackage.TEST_PROTOCOL__TEST_REPORT:
				setTestReport(TEST_REPORT_EDEFAULT);
				return;
			case ModelPackage.TEST_PROTOCOL__TEST_DESCRIPTION:
				setTestDescription(TEST_DESCRIPTION_EDEFAULT);
				return;
			case ModelPackage.TEST_PROTOCOL__TEST_STATE:
				setTestState(TEST_STATE_EDEFAULT);
				return;
			case ModelPackage.TEST_PROTOCOL__TEST_CASE:
				setTestCase((LogicalTestCase)null);
				return;
			case ModelPackage.TEST_PROTOCOL__CONCRETE_PARAMTER:
				getConcreteParamter().clear();
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
			case ModelPackage.TEST_PROTOCOL__TEST_REPORT:
				return TEST_REPORT_EDEFAULT == null ? testReport != null : !TEST_REPORT_EDEFAULT.equals(testReport);
			case ModelPackage.TEST_PROTOCOL__TEST_DESCRIPTION:
				return TEST_DESCRIPTION_EDEFAULT == null ? testDescription != null : !TEST_DESCRIPTION_EDEFAULT.equals(testDescription);
			case ModelPackage.TEST_PROTOCOL__TEST_STATE:
				return testState != TEST_STATE_EDEFAULT;
			case ModelPackage.TEST_PROTOCOL__TEST_CASE:
				return testCase != null;
			case ModelPackage.TEST_PROTOCOL__CONCRETE_PARAMTER:
				return concreteParamter != null && !concreteParamter.isEmpty();
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
		result.append(", testDescription: ");
		result.append(testDescription);
		result.append(", testState: ");
		result.append(testState);
		result.append(')');
		return result.toString();
	}

} //TestProtocolImpl
