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


import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.NonFunctionalRequirement;
import org.unicase.testspec.model.LogicalTestCase;
import org.unicase.testspec.model.ModelPackage;
import org.unicase.testspec.model.TestProtocol;
import org.unicase.testspec.model.TestStep;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Logical Test Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.testspec.model.impl.LogicalTestCaseImpl#getTcDescription <em>Tc Description</em>}</li>
 *   <li>{@link org.unicase.testspec.model.impl.LogicalTestCaseImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.unicase.testspec.model.impl.LogicalTestCaseImpl#getPrecondition <em>Precondition</em>}</li>
 *   <li>{@link org.unicase.testspec.model.impl.LogicalTestCaseImpl#getPostcondition <em>Postcondition</em>}</li>
 *   <li>{@link org.unicase.testspec.model.impl.LogicalTestCaseImpl#getInfrastructure <em>Infrastructure</em>}</li>
 *   <li>{@link org.unicase.testspec.model.impl.LogicalTestCaseImpl#getTestProtocol <em>Test Protocol</em>}</li>
 *   <li>{@link org.unicase.testspec.model.impl.LogicalTestCaseImpl#getTestStep <em>Test Step</em>}</li>
 *   <li>{@link org.unicase.testspec.model.impl.LogicalTestCaseImpl#getNonFunctionalRequirement <em>Non Functional Requirement</em>}</li>
 *   <li>{@link org.unicase.testspec.model.impl.LogicalTestCaseImpl#getFunctionalRequirement <em>Functional Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LogicalTestCaseImpl extends EObjectImpl implements LogicalTestCase {
	/**
	 * The default value of the '{@link #getTcDescription() <em>Tc Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTcDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String TC_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTcDescription() <em>Tc Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTcDescription()
	 * @generated
	 * @ordered
	 */
	protected String tcDescription = TC_DESCRIPTION_EDEFAULT;

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
	 * The default value of the '{@link #getPrecondition() <em>Precondition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrecondition()
	 * @generated
	 * @ordered
	 */
	protected static final String PRECONDITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrecondition() <em>Precondition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrecondition()
	 * @generated
	 * @ordered
	 */
	protected String precondition = PRECONDITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getPostcondition() <em>Postcondition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostcondition()
	 * @generated
	 * @ordered
	 */
	protected static final String POSTCONDITION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getPostcondition() <em>Postcondition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostcondition()
	 * @generated
	 * @ordered
	 */
	protected String postcondition = POSTCONDITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getInfrastructure() <em>Infrastructure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfrastructure()
	 * @generated
	 * @ordered
	 */
	protected static final String INFRASTRUCTURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInfrastructure() <em>Infrastructure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfrastructure()
	 * @generated
	 * @ordered
	 */
	protected String infrastructure = INFRASTRUCTURE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTestProtocol() <em>Test Protocol</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestProtocol()
	 * @generated
	 * @ordered
	 */
	protected EList<TestProtocol> testProtocol;

	/**
	 * The cached value of the '{@link #getTestStep() <em>Test Step</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestStep()
	 * @generated
	 * @ordered
	 */
	protected EList<TestStep> testStep;

	/**
	 * The cached value of the '{@link #getNonFunctionalRequirement() <em>Non Functional Requirement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNonFunctionalRequirement()
	 * @generated
	 * @ordered
	 */
	protected NonFunctionalRequirement nonFunctionalRequirement;

	/**
	 * The cached value of the '{@link #getFunctionalRequirement() <em>Functional Requirement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionalRequirement()
	 * @generated
	 * @ordered
	 */
	protected FunctionalRequirement functionalRequirement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LogicalTestCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.LOGICAL_TEST_CASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTcDescription() {
		return tcDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTcDescription(String newTcDescription) {
		String oldTcDescription = tcDescription;
		tcDescription = newTcDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.LOGICAL_TEST_CASE__TC_DESCRIPTION, oldTcDescription, tcDescription));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.LOGICAL_TEST_CASE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrecondition() {
		return precondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrecondition(String newPrecondition) {
		String oldPrecondition = precondition;
		precondition = newPrecondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.LOGICAL_TEST_CASE__PRECONDITION, oldPrecondition, precondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPostcondition() {
		return postcondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostcondition(String newPostcondition) {
		String oldPostcondition = postcondition;
		postcondition = newPostcondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.LOGICAL_TEST_CASE__POSTCONDITION, oldPostcondition, postcondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInfrastructure() {
		return infrastructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInfrastructure(String newInfrastructure) {
		String oldInfrastructure = infrastructure;
		infrastructure = newInfrastructure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.LOGICAL_TEST_CASE__INFRASTRUCTURE, oldInfrastructure, infrastructure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestProtocol> getTestProtocol() {
		if (testProtocol == null) {
			testProtocol = new EObjectResolvingEList<TestProtocol>(TestProtocol.class, this, ModelPackage.LOGICAL_TEST_CASE__TEST_PROTOCOL);
		}
		return testProtocol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestStep> getTestStep() {
		if (testStep == null) {
			testStep = new EObjectContainmentEList<TestStep>(TestStep.class, this, ModelPackage.LOGICAL_TEST_CASE__TEST_STEP);
		}
		return testStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NonFunctionalRequirement getNonFunctionalRequirement() {
		if (nonFunctionalRequirement != null && nonFunctionalRequirement.eIsProxy()) {
			InternalEObject oldNonFunctionalRequirement = (InternalEObject)nonFunctionalRequirement;
			nonFunctionalRequirement = (NonFunctionalRequirement)eResolveProxy(oldNonFunctionalRequirement);
			if (nonFunctionalRequirement != oldNonFunctionalRequirement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.LOGICAL_TEST_CASE__NON_FUNCTIONAL_REQUIREMENT, oldNonFunctionalRequirement, nonFunctionalRequirement));
			}
		}
		return nonFunctionalRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NonFunctionalRequirement basicGetNonFunctionalRequirement() {
		return nonFunctionalRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNonFunctionalRequirement(NonFunctionalRequirement newNonFunctionalRequirement) {
		NonFunctionalRequirement oldNonFunctionalRequirement = nonFunctionalRequirement;
		nonFunctionalRequirement = newNonFunctionalRequirement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.LOGICAL_TEST_CASE__NON_FUNCTIONAL_REQUIREMENT, oldNonFunctionalRequirement, nonFunctionalRequirement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionalRequirement getFunctionalRequirement() {
		if (functionalRequirement != null && functionalRequirement.eIsProxy()) {
			InternalEObject oldFunctionalRequirement = (InternalEObject)functionalRequirement;
			functionalRequirement = (FunctionalRequirement)eResolveProxy(oldFunctionalRequirement);
			if (functionalRequirement != oldFunctionalRequirement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.LOGICAL_TEST_CASE__FUNCTIONAL_REQUIREMENT, oldFunctionalRequirement, functionalRequirement));
			}
		}
		return functionalRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionalRequirement basicGetFunctionalRequirement() {
		return functionalRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunctionalRequirement(FunctionalRequirement newFunctionalRequirement) {
		FunctionalRequirement oldFunctionalRequirement = functionalRequirement;
		functionalRequirement = newFunctionalRequirement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.LOGICAL_TEST_CASE__FUNCTIONAL_REQUIREMENT, oldFunctionalRequirement, functionalRequirement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.LOGICAL_TEST_CASE__TEST_STEP:
				return ((InternalEList<?>)getTestStep()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.LOGICAL_TEST_CASE__TC_DESCRIPTION:
				return getTcDescription();
			case ModelPackage.LOGICAL_TEST_CASE__TYPE:
				return getType();
			case ModelPackage.LOGICAL_TEST_CASE__PRECONDITION:
				return getPrecondition();
			case ModelPackage.LOGICAL_TEST_CASE__POSTCONDITION:
				return getPostcondition();
			case ModelPackage.LOGICAL_TEST_CASE__INFRASTRUCTURE:
				return getInfrastructure();
			case ModelPackage.LOGICAL_TEST_CASE__TEST_PROTOCOL:
				return getTestProtocol();
			case ModelPackage.LOGICAL_TEST_CASE__TEST_STEP:
				return getTestStep();
			case ModelPackage.LOGICAL_TEST_CASE__NON_FUNCTIONAL_REQUIREMENT:
				if (resolve) return getNonFunctionalRequirement();
				return basicGetNonFunctionalRequirement();
			case ModelPackage.LOGICAL_TEST_CASE__FUNCTIONAL_REQUIREMENT:
				if (resolve) return getFunctionalRequirement();
				return basicGetFunctionalRequirement();
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
			case ModelPackage.LOGICAL_TEST_CASE__TC_DESCRIPTION:
				setTcDescription((String)newValue);
				return;
			case ModelPackage.LOGICAL_TEST_CASE__TYPE:
				setType((String)newValue);
				return;
			case ModelPackage.LOGICAL_TEST_CASE__PRECONDITION:
				setPrecondition((String)newValue);
				return;
			case ModelPackage.LOGICAL_TEST_CASE__POSTCONDITION:
				setPostcondition((String)newValue);
				return;
			case ModelPackage.LOGICAL_TEST_CASE__INFRASTRUCTURE:
				setInfrastructure((String)newValue);
				return;
			case ModelPackage.LOGICAL_TEST_CASE__TEST_PROTOCOL:
				getTestProtocol().clear();
				getTestProtocol().addAll((Collection<? extends TestProtocol>)newValue);
				return;
			case ModelPackage.LOGICAL_TEST_CASE__TEST_STEP:
				getTestStep().clear();
				getTestStep().addAll((Collection<? extends TestStep>)newValue);
				return;
			case ModelPackage.LOGICAL_TEST_CASE__NON_FUNCTIONAL_REQUIREMENT:
				setNonFunctionalRequirement((NonFunctionalRequirement)newValue);
				return;
			case ModelPackage.LOGICAL_TEST_CASE__FUNCTIONAL_REQUIREMENT:
				setFunctionalRequirement((FunctionalRequirement)newValue);
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
			case ModelPackage.LOGICAL_TEST_CASE__TC_DESCRIPTION:
				setTcDescription(TC_DESCRIPTION_EDEFAULT);
				return;
			case ModelPackage.LOGICAL_TEST_CASE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ModelPackage.LOGICAL_TEST_CASE__PRECONDITION:
				setPrecondition(PRECONDITION_EDEFAULT);
				return;
			case ModelPackage.LOGICAL_TEST_CASE__POSTCONDITION:
				setPostcondition(POSTCONDITION_EDEFAULT);
				return;
			case ModelPackage.LOGICAL_TEST_CASE__INFRASTRUCTURE:
				setInfrastructure(INFRASTRUCTURE_EDEFAULT);
				return;
			case ModelPackage.LOGICAL_TEST_CASE__TEST_PROTOCOL:
				getTestProtocol().clear();
				return;
			case ModelPackage.LOGICAL_TEST_CASE__TEST_STEP:
				getTestStep().clear();
				return;
			case ModelPackage.LOGICAL_TEST_CASE__NON_FUNCTIONAL_REQUIREMENT:
				setNonFunctionalRequirement((NonFunctionalRequirement)null);
				return;
			case ModelPackage.LOGICAL_TEST_CASE__FUNCTIONAL_REQUIREMENT:
				setFunctionalRequirement((FunctionalRequirement)null);
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
			case ModelPackage.LOGICAL_TEST_CASE__TC_DESCRIPTION:
				return TC_DESCRIPTION_EDEFAULT == null ? tcDescription != null : !TC_DESCRIPTION_EDEFAULT.equals(tcDescription);
			case ModelPackage.LOGICAL_TEST_CASE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case ModelPackage.LOGICAL_TEST_CASE__PRECONDITION:
				return PRECONDITION_EDEFAULT == null ? precondition != null : !PRECONDITION_EDEFAULT.equals(precondition);
			case ModelPackage.LOGICAL_TEST_CASE__POSTCONDITION:
				return POSTCONDITION_EDEFAULT == null ? postcondition != null : !POSTCONDITION_EDEFAULT.equals(postcondition);
			case ModelPackage.LOGICAL_TEST_CASE__INFRASTRUCTURE:
				return INFRASTRUCTURE_EDEFAULT == null ? infrastructure != null : !INFRASTRUCTURE_EDEFAULT.equals(infrastructure);
			case ModelPackage.LOGICAL_TEST_CASE__TEST_PROTOCOL:
				return testProtocol != null && !testProtocol.isEmpty();
			case ModelPackage.LOGICAL_TEST_CASE__TEST_STEP:
				return testStep != null && !testStep.isEmpty();
			case ModelPackage.LOGICAL_TEST_CASE__NON_FUNCTIONAL_REQUIREMENT:
				return nonFunctionalRequirement != null;
			case ModelPackage.LOGICAL_TEST_CASE__FUNCTIONAL_REQUIREMENT:
				return functionalRequirement != null;
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
		result.append(" (tcDescription: ");
		result.append(tcDescription);
		result.append(", type: ");
		result.append(type);
		result.append(", precondition: ");
		result.append(precondition);
		result.append(", postcondition: ");
		result.append(postcondition);
		result.append(", infrastructure: ");
		result.append(infrastructure);
		result.append(')');
		return result.toString();
	}

} //LogicalTestCaseImpl
