/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.NumericalMethod;

import scrm.requirements.Performance;
import scrm.requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Performance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.requirements.impl.PerformanceImpl#getNumericalMethod <em>Numerical Method</em>}</li>
 *   <li>{@link scrm.requirements.impl.PerformanceImpl#getProblemSize <em>Problem Size</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PerformanceImpl extends RequirementImpl implements Performance {
	/**
	 * The cached value of the '{@link #getNumericalMethod() <em>Numerical Method</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumericalMethod()
	 * @generated
	 * @ordered
	 */
	protected NumericalMethod numericalMethod;

	/**
	 * The default value of the '{@link #getProblemSize() <em>Problem Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProblemSize()
	 * @generated
	 * @ordered
	 */
	protected static final String PROBLEM_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProblemSize() <em>Problem Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProblemSize()
	 * @generated
	 * @ordered
	 */
	protected String problemSize = PROBLEM_SIZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PerformanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.PERFORMANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericalMethod getNumericalMethod() {
		if (numericalMethod != null && numericalMethod.eIsProxy()) {
			InternalEObject oldNumericalMethod = (InternalEObject)numericalMethod;
			numericalMethod = (NumericalMethod)eResolveProxy(oldNumericalMethod);
			if (numericalMethod != oldNumericalMethod) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequirementsPackage.PERFORMANCE__NUMERICAL_METHOD, oldNumericalMethod, numericalMethod));
			}
		}
		return numericalMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericalMethod basicGetNumericalMethod() {
		return numericalMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNumericalMethod(NumericalMethod newNumericalMethod, NotificationChain msgs) {
		NumericalMethod oldNumericalMethod = numericalMethod;
		numericalMethod = newNumericalMethod;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RequirementsPackage.PERFORMANCE__NUMERICAL_METHOD, oldNumericalMethod, newNumericalMethod);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumericalMethod(NumericalMethod newNumericalMethod) {
		if (newNumericalMethod != numericalMethod) {
			NotificationChain msgs = null;
			if (numericalMethod != null)
				msgs = ((InternalEObject)numericalMethod).eInverseRemove(this, KnowledgePackage.NUMERICAL_METHOD__PERFORMANCE, NumericalMethod.class, msgs);
			if (newNumericalMethod != null)
				msgs = ((InternalEObject)newNumericalMethod).eInverseAdd(this, KnowledgePackage.NUMERICAL_METHOD__PERFORMANCE, NumericalMethod.class, msgs);
			msgs = basicSetNumericalMethod(newNumericalMethod, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.PERFORMANCE__NUMERICAL_METHOD, newNumericalMethod, newNumericalMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProblemSize() {
		return problemSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProblemSize(String newProblemSize) {
		String oldProblemSize = problemSize;
		problemSize = newProblemSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.PERFORMANCE__PROBLEM_SIZE, oldProblemSize, problemSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RequirementsPackage.PERFORMANCE__NUMERICAL_METHOD:
				if (numericalMethod != null)
					msgs = ((InternalEObject)numericalMethod).eInverseRemove(this, KnowledgePackage.NUMERICAL_METHOD__PERFORMANCE, NumericalMethod.class, msgs);
				return basicSetNumericalMethod((NumericalMethod)otherEnd, msgs);
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
			case RequirementsPackage.PERFORMANCE__NUMERICAL_METHOD:
				return basicSetNumericalMethod(null, msgs);
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
			case RequirementsPackage.PERFORMANCE__NUMERICAL_METHOD:
				if (resolve) return getNumericalMethod();
				return basicGetNumericalMethod();
			case RequirementsPackage.PERFORMANCE__PROBLEM_SIZE:
				return getProblemSize();
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
			case RequirementsPackage.PERFORMANCE__NUMERICAL_METHOD:
				setNumericalMethod((NumericalMethod)newValue);
				return;
			case RequirementsPackage.PERFORMANCE__PROBLEM_SIZE:
				setProblemSize((String)newValue);
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
			case RequirementsPackage.PERFORMANCE__NUMERICAL_METHOD:
				setNumericalMethod((NumericalMethod)null);
				return;
			case RequirementsPackage.PERFORMANCE__PROBLEM_SIZE:
				setProblemSize(PROBLEM_SIZE_EDEFAULT);
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
			case RequirementsPackage.PERFORMANCE__NUMERICAL_METHOD:
				return numericalMethod != null;
			case RequirementsPackage.PERFORMANCE__PROBLEM_SIZE:
				return PROBLEM_SIZE_EDEFAULT == null ? problemSize != null : !PROBLEM_SIZE_EDEFAULT.equals(problemSize);
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
		result.append(" (problemSize: ");
		result.append(problemSize);
		result.append(')');
		return result.toString();
	}

} //PerformanceImpl
