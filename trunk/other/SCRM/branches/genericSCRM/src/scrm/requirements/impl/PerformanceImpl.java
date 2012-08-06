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
 *   <li>{@link scrm.requirements.impl.PerformanceImpl#getProblemSize <em>Problem Size</em>}</li>
 *   <li>{@link scrm.requirements.impl.PerformanceImpl#getDescribedMethod <em>Described Method</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PerformanceImpl extends RequirementImpl implements Performance {
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
	 * The cached value of the '{@link #getDescribedMethod() <em>Described Method</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescribedMethod()
	 * @generated
	 * @ordered
	 */
	protected NumericalMethod describedMethod;

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
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementsPackage.PERFORMANCE__PROBLEM_SIZE,
					oldProblemSize, problemSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericalMethod getDescribedMethod() {
		if (describedMethod != null && describedMethod.eIsProxy()) {
			InternalEObject oldDescribedMethod = (InternalEObject) describedMethod;
			describedMethod = (NumericalMethod) eResolveProxy(oldDescribedMethod);
			if (describedMethod != oldDescribedMethod) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							RequirementsPackage.PERFORMANCE__DESCRIBED_METHOD,
							oldDescribedMethod, describedMethod));
			}
		}
		return describedMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericalMethod basicGetDescribedMethod() {
		return describedMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescribedMethod(
			NumericalMethod newDescribedMethod, NotificationChain msgs) {
		NumericalMethod oldDescribedMethod = describedMethod;
		describedMethod = newDescribedMethod;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					RequirementsPackage.PERFORMANCE__DESCRIBED_METHOD,
					oldDescribedMethod, newDescribedMethod);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescribedMethod(NumericalMethod newDescribedMethod) {
		if (newDescribedMethod != describedMethod) {
			NotificationChain msgs = null;
			if (describedMethod != null)
				msgs = ((InternalEObject) describedMethod).eInverseRemove(this,
						KnowledgePackage.NUMERICAL_METHOD__PERFORMANCE,
						NumericalMethod.class, msgs);
			if (newDescribedMethod != null)
				msgs = ((InternalEObject) newDescribedMethod).eInverseAdd(this,
						KnowledgePackage.NUMERICAL_METHOD__PERFORMANCE,
						NumericalMethod.class, msgs);
			msgs = basicSetDescribedMethod(newDescribedMethod, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementsPackage.PERFORMANCE__DESCRIBED_METHOD,
					newDescribedMethod, newDescribedMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RequirementsPackage.PERFORMANCE__DESCRIBED_METHOD:
			if (describedMethod != null)
				msgs = ((InternalEObject) describedMethod).eInverseRemove(this,
						KnowledgePackage.NUMERICAL_METHOD__PERFORMANCE,
						NumericalMethod.class, msgs);
			return basicSetDescribedMethod((NumericalMethod) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RequirementsPackage.PERFORMANCE__DESCRIBED_METHOD:
			return basicSetDescribedMethod(null, msgs);
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
		case RequirementsPackage.PERFORMANCE__PROBLEM_SIZE:
			return getProblemSize();
		case RequirementsPackage.PERFORMANCE__DESCRIBED_METHOD:
			if (resolve)
				return getDescribedMethod();
			return basicGetDescribedMethod();
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
		case RequirementsPackage.PERFORMANCE__PROBLEM_SIZE:
			setProblemSize((String) newValue);
			return;
		case RequirementsPackage.PERFORMANCE__DESCRIBED_METHOD:
			setDescribedMethod((NumericalMethod) newValue);
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
		case RequirementsPackage.PERFORMANCE__PROBLEM_SIZE:
			setProblemSize(PROBLEM_SIZE_EDEFAULT);
			return;
		case RequirementsPackage.PERFORMANCE__DESCRIBED_METHOD:
			setDescribedMethod((NumericalMethod) null);
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
		case RequirementsPackage.PERFORMANCE__PROBLEM_SIZE:
			return PROBLEM_SIZE_EDEFAULT == null ? problemSize != null
					: !PROBLEM_SIZE_EDEFAULT.equals(problemSize);
		case RequirementsPackage.PERFORMANCE__DESCRIBED_METHOD:
			return describedMethod != null;
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
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (problemSize: ");
		result.append(problemSize);
		result.append(')');
		return result.toString();
	}

} //PerformanceImpl
