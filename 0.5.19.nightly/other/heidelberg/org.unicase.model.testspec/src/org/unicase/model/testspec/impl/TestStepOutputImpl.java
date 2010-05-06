/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.testspec.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.impl.UnicaseModelElementImpl;

import org.unicase.model.testspec.TestProtocol;
import org.unicase.model.testspec.TestStep;
import org.unicase.model.testspec.TestStepOutput;
import org.unicase.model.testspec.TestspecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Step Output</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.testspec.impl.TestStepOutputImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.unicase.model.testspec.impl.TestStepOutputImpl#getRange <em>Range</em>}</li>
 *   <li>{@link org.unicase.model.testspec.impl.TestStepOutputImpl#getTestStep <em>Test Step</em>}</li>
 *   <li>{@link org.unicase.model.testspec.impl.TestStepOutputImpl#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestStepOutputImpl extends UnicaseModelElementImpl implements TestStepOutput {
	/**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
	protected static final String TYPE_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
	protected String type = TYPE_EDEFAULT;

	/**
     * The default value of the '{@link #getRange() <em>Range</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getRange()
     * @generated
     * @ordered
     */
	protected static final String RANGE_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getRange() <em>Range</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getRange()
     * @generated
     * @ordered
     */
	protected String range = RANGE_EDEFAULT;

	/**
     * The cached value of the '{@link #getValues() <em>Values</em>}' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValues()
     * @generated
     * @ordered
     */
    protected EMap<TestProtocol, String> values;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected TestStepOutputImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return TestspecPackage.Literals.TEST_STEP_OUTPUT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getType() {
        return type;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setType(String newType) {
        String oldType = type;
        type = newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TestspecPackage.TEST_STEP_OUTPUT__TYPE, oldType, type));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getRange() {
        return range;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setRange(String newRange) {
        String oldRange = range;
        range = newRange;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TestspecPackage.TEST_STEP_OUTPUT__RANGE, oldRange, range));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TestStep getTestStep() {
        if (eContainerFeatureID() != TestspecPackage.TEST_STEP_OUTPUT__TEST_STEP) return null;
        return (TestStep)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TestStep basicGetTestStep() {
        if (eContainerFeatureID() != TestspecPackage.TEST_STEP_OUTPUT__TEST_STEP) return null;
        return (TestStep)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetTestStep(TestStep newTestStep, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newTestStep, TestspecPackage.TEST_STEP_OUTPUT__TEST_STEP, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTestStep(TestStep newTestStep) {
        if (newTestStep != eInternalContainer() || (eContainerFeatureID() != TestspecPackage.TEST_STEP_OUTPUT__TEST_STEP && newTestStep != null)) {
            if (EcoreUtil.isAncestor(this, newTestStep))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newTestStep != null)
                msgs = ((InternalEObject)newTestStep).eInverseAdd(this, TestspecPackage.TEST_STEP__OUTPUT, TestStep.class, msgs);
            msgs = basicSetTestStep(newTestStep, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TestspecPackage.TEST_STEP_OUTPUT__TEST_STEP, newTestStep, newTestStep));
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EMap<TestProtocol, String> getValues() {
        if (values == null) {
            values = new EcoreEMap<TestProtocol,String>(TestspecPackage.Literals.TEST_PROTOCOL_TO_STRING_MAP, TestProtocolToStringMapImpl.class, this, TestspecPackage.TEST_STEP_OUTPUT__VALUES);
        }
        return values;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TestspecPackage.TEST_STEP_OUTPUT__TEST_STEP:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetTestStep((TestStep)otherEnd, msgs);
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
            case TestspecPackage.TEST_STEP_OUTPUT__TEST_STEP:
                return basicSetTestStep(null, msgs);
            case TestspecPackage.TEST_STEP_OUTPUT__VALUES:
                return ((InternalEList<?>)getValues()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case TestspecPackage.TEST_STEP_OUTPUT__TEST_STEP:
                return eInternalContainer().eInverseRemove(this, TestspecPackage.TEST_STEP__OUTPUT, TestStep.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case TestspecPackage.TEST_STEP_OUTPUT__TYPE:
                return getType();
            case TestspecPackage.TEST_STEP_OUTPUT__RANGE:
                return getRange();
            case TestspecPackage.TEST_STEP_OUTPUT__TEST_STEP:
                if (resolve) return getTestStep();
                return basicGetTestStep();
            case TestspecPackage.TEST_STEP_OUTPUT__VALUES:
                if (coreType) return getValues();
                else return getValues().map();
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
            case TestspecPackage.TEST_STEP_OUTPUT__TYPE:
                setType((String)newValue);
                return;
            case TestspecPackage.TEST_STEP_OUTPUT__RANGE:
                setRange((String)newValue);
                return;
            case TestspecPackage.TEST_STEP_OUTPUT__TEST_STEP:
                setTestStep((TestStep)newValue);
                return;
            case TestspecPackage.TEST_STEP_OUTPUT__VALUES:
                ((EStructuralFeature.Setting)getValues()).set(newValue);
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
            case TestspecPackage.TEST_STEP_OUTPUT__TYPE:
                setType(TYPE_EDEFAULT);
                return;
            case TestspecPackage.TEST_STEP_OUTPUT__RANGE:
                setRange(RANGE_EDEFAULT);
                return;
            case TestspecPackage.TEST_STEP_OUTPUT__TEST_STEP:
                setTestStep((TestStep)null);
                return;
            case TestspecPackage.TEST_STEP_OUTPUT__VALUES:
                getValues().clear();
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
            case TestspecPackage.TEST_STEP_OUTPUT__TYPE:
                return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
            case TestspecPackage.TEST_STEP_OUTPUT__RANGE:
                return RANGE_EDEFAULT == null ? range != null : !RANGE_EDEFAULT.equals(range);
            case TestspecPackage.TEST_STEP_OUTPUT__TEST_STEP:
                return basicGetTestStep() != null;
            case TestspecPackage.TEST_STEP_OUTPUT__VALUES:
                return values != null && !values.isEmpty();
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
        result.append(" (type: ");
        result.append(type);
        result.append(", range: ");
        result.append(range);
        result.append(')');
        return result.toString();
    }

} //TestStepOutputImpl
