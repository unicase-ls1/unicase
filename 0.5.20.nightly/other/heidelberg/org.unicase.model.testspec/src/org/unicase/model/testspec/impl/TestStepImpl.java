/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.testspec.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.unicase.model.impl.UnicaseModelElementImpl;

import org.unicase.model.testspec.TestStep;
import org.unicase.model.testspec.TestStepInput;
import org.unicase.model.testspec.TestStepOutput;
import org.unicase.model.testspec.TestspecPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Test Step</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.testspec.impl.TestStepImpl#getException <em>Exception</em>}</li>
 *   <li>{@link org.unicase.model.testspec.impl.TestStepImpl#getInput <em>Input</em>}</li>
 *   <li>{@link org.unicase.model.testspec.impl.TestStepImpl#getOutput <em>Output</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestStepImpl extends UnicaseModelElementImpl implements TestStep {
    /**
     * The default value of the '{@link #getException() <em>Exception</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #getException()
     * @generated
     * @ordered
     */
    protected static final String EXCEPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getException() <em>Exception</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #getException()
     * @generated
     * @ordered
     */
    protected String exception = EXCEPTION_EDEFAULT;

    /**
     * The cached value of the '{@link #getInput() <em>Input</em>}' containment reference list.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #getInput()
     * @generated
     * @ordered
     */
    protected EList<TestStepInput> input;

    /**
     * The cached value of the '{@link #getOutput() <em>Output</em>}' containment reference list.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #getOutput()
     * @generated
     * @ordered
     */
    protected EList<TestStepOutput> output;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected TestStepImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TestspecPackage.Literals.TEST_STEP;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public String getException() {
        return exception;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setException(String newException) {
        String oldException = exception;
        exception = newException;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TestspecPackage.TEST_STEP__EXCEPTION, oldException, exception));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<TestStepInput> getInput() {
        if (input == null) {
            input = new EObjectContainmentWithInverseEList.Resolving<TestStepInput>(TestStepInput.class, this, TestspecPackage.TEST_STEP__INPUT, TestspecPackage.TEST_STEP_INPUT__TEST_STEP);
        }
        return input;
    }

    /**
     * Get an input parameter of a test step with a specific ID.
     * 
     * @author Sharon Friedrich
     * @param identifier
     *            - ID of the input parameter
     * @return test step input
     */
    public TestStepInput getInputByIdentifier(String identifier) {
        TestStepInput[] listInput = (TestStepInput[]) this.getInput().toArray();
        for (int i = 0; i < listInput.length; i++) {
            if (listInput[i].getIdentifier().equals(identifier)) {
                return listInput[i];
            }
        }
        return null;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<TestStepOutput> getOutput() {
        if (output == null) {
            output = new EObjectContainmentWithInverseEList.Resolving<TestStepOutput>(TestStepOutput.class, this, TestspecPackage.TEST_STEP__OUTPUT, TestspecPackage.TEST_STEP_OUTPUT__TEST_STEP);
        }
        return output;
    }

    /**
     * Get an output parameter of a test step with a specific ID.
     * 
     * @author Sharon Friedrich
     * @param identifier
     *            - ID of the output parameter
     * @return test step output
     */
    public TestStepOutput getOutputByIdentifier(String identifier) {
        TestStepOutput[] listOutput = (TestStepOutput[]) this.getOutput()
                .toArray();
        for (int i = 0; i < listOutput.length; i++) {
            if (listOutput[i].getIdentifier().equals(identifier)) {
                return listOutput[i];
            }
        }
        return null;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd,
            int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TestspecPackage.TEST_STEP__INPUT:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getInput()).basicAdd(otherEnd, msgs);
            case TestspecPackage.TEST_STEP__OUTPUT:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutput()).basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd,
            int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TestspecPackage.TEST_STEP__INPUT:
                return ((InternalEList<?>)getInput()).basicRemove(otherEnd, msgs);
            case TestspecPackage.TEST_STEP__OUTPUT:
                return ((InternalEList<?>)getOutput()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case TestspecPackage.TEST_STEP__EXCEPTION:
                return getException();
            case TestspecPackage.TEST_STEP__INPUT:
                return getInput();
            case TestspecPackage.TEST_STEP__OUTPUT:
                return getOutput();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case TestspecPackage.TEST_STEP__EXCEPTION:
                setException((String)newValue);
                return;
            case TestspecPackage.TEST_STEP__INPUT:
                getInput().clear();
                getInput().addAll((Collection<? extends TestStepInput>)newValue);
                return;
            case TestspecPackage.TEST_STEP__OUTPUT:
                getOutput().clear();
                getOutput().addAll((Collection<? extends TestStepOutput>)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case TestspecPackage.TEST_STEP__EXCEPTION:
                setException(EXCEPTION_EDEFAULT);
                return;
            case TestspecPackage.TEST_STEP__INPUT:
                getInput().clear();
                return;
            case TestspecPackage.TEST_STEP__OUTPUT:
                getOutput().clear();
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case TestspecPackage.TEST_STEP__EXCEPTION:
                return EXCEPTION_EDEFAULT == null ? exception != null : !EXCEPTION_EDEFAULT.equals(exception);
            case TestspecPackage.TEST_STEP__INPUT:
                return input != null && !input.isEmpty();
            case TestspecPackage.TEST_STEP__OUTPUT:
                return output != null && !output.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (exception: ");
        result.append(exception);
        result.append(')');
        return result.toString();
    }

} // TestStepImpl
