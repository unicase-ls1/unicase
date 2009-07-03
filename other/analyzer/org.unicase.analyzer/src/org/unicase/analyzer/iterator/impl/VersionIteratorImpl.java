/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.analyzer.iterator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.unicase.analyzer.iterator.IteratorPackage;
import org.unicase.analyzer.iterator.VersionIterator;
import org.unicase.analyzer.iterator.VersionSpecQuery;

import org.unicase.emfstore.esmodel.ProjectId;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Version Iterator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.analyzer.iterator.impl.VersionIteratorImpl#getStepLength <em>Step Length</em>}</li>
 *   <li>{@link org.unicase.analyzer.iterator.impl.VersionIteratorImpl#getProjectId <em>Project Id</em>}</li>
 *   <li>{@link org.unicase.analyzer.iterator.impl.VersionIteratorImpl#isForward <em>Forward</em>}</li>
 *   <li>{@link org.unicase.analyzer.iterator.impl.VersionIteratorImpl#isReturnProjectDataCopy <em>Return Project Data Copy</em>}</li>
 *   <li>{@link org.unicase.analyzer.iterator.impl.VersionIteratorImpl#getVersionSpecQuery <em>Version Spec Query</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VersionIteratorImpl extends EObjectImpl implements VersionIterator {
	/**
	 * The default value of the '{@link #getStepLength() <em>Step Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepLength()
	 * @generated
	 * @ordered
	 */
	protected static final int STEP_LENGTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStepLength() <em>Step Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepLength()
	 * @generated
	 * @ordered
	 */
	protected int stepLength = STEP_LENGTH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProjectId() <em>Project Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectId()
	 * @generated
	 * @ordered
	 */
	protected ProjectId projectId;

	/**
	 * The default value of the '{@link #isForward() <em>Forward</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isForward()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FORWARD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isForward() <em>Forward</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isForward()
	 * @generated
	 * @ordered
	 */
	protected boolean forward = FORWARD_EDEFAULT;

	/**
	 * The default value of the '{@link #isReturnProjectDataCopy() <em>Return Project Data Copy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReturnProjectDataCopy()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RETURN_PROJECT_DATA_COPY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReturnProjectDataCopy() <em>Return Project Data Copy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReturnProjectDataCopy()
	 * @generated
	 * @ordered
	 */
	protected boolean returnProjectDataCopy = RETURN_PROJECT_DATA_COPY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVersionSpecQuery() <em>Version Spec Query</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionSpecQuery()
	 * @generated
	 * @ordered
	 */
	protected VersionSpecQuery versionSpecQuery;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VersionIteratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IteratorPackage.Literals.VERSION_ITERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStepLength() {
		return stepLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStepLength(int newStepLength) {
		int oldStepLength = stepLength;
		stepLength = newStepLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.VERSION_ITERATOR__STEP_LENGTH, oldStepLength, stepLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectId getProjectId() {
		return projectId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProjectId(ProjectId newProjectId, NotificationChain msgs) {
		ProjectId oldProjectId = projectId;
		projectId = newProjectId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IteratorPackage.VERSION_ITERATOR__PROJECT_ID, oldProjectId, newProjectId);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectId(ProjectId newProjectId) {
		if (newProjectId != projectId) {
			NotificationChain msgs = null;
			if (projectId != null)
				msgs = ((InternalEObject)projectId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IteratorPackage.VERSION_ITERATOR__PROJECT_ID, null, msgs);
			if (newProjectId != null)
				msgs = ((InternalEObject)newProjectId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IteratorPackage.VERSION_ITERATOR__PROJECT_ID, null, msgs);
			msgs = basicSetProjectId(newProjectId, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.VERSION_ITERATOR__PROJECT_ID, newProjectId, newProjectId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isForward() {
		return forward;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForward(boolean newForward) {
		boolean oldForward = forward;
		forward = newForward;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.VERSION_ITERATOR__FORWARD, oldForward, forward));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReturnProjectDataCopy() {
		return returnProjectDataCopy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturnProjectDataCopy(boolean newReturnProjectDataCopy) {
		boolean oldReturnProjectDataCopy = returnProjectDataCopy;
		returnProjectDataCopy = newReturnProjectDataCopy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.VERSION_ITERATOR__RETURN_PROJECT_DATA_COPY, oldReturnProjectDataCopy, returnProjectDataCopy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VersionSpecQuery getVersionSpecQuery() {
		return versionSpecQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVersionSpecQuery(VersionSpecQuery newVersionSpecQuery, NotificationChain msgs) {
		VersionSpecQuery oldVersionSpecQuery = versionSpecQuery;
		versionSpecQuery = newVersionSpecQuery;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IteratorPackage.VERSION_ITERATOR__VERSION_SPEC_QUERY, oldVersionSpecQuery, newVersionSpecQuery);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersionSpecQuery(VersionSpecQuery newVersionSpecQuery) {
		if (newVersionSpecQuery != versionSpecQuery) {
			NotificationChain msgs = null;
			if (versionSpecQuery != null)
				msgs = ((InternalEObject)versionSpecQuery).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IteratorPackage.VERSION_ITERATOR__VERSION_SPEC_QUERY, null, msgs);
			if (newVersionSpecQuery != null)
				msgs = ((InternalEObject)newVersionSpecQuery).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IteratorPackage.VERSION_ITERATOR__VERSION_SPEC_QUERY, null, msgs);
			msgs = basicSetVersionSpecQuery(newVersionSpecQuery, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.VERSION_ITERATOR__VERSION_SPEC_QUERY, newVersionSpecQuery, newVersionSpecQuery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IteratorPackage.VERSION_ITERATOR__PROJECT_ID:
				return basicSetProjectId(null, msgs);
			case IteratorPackage.VERSION_ITERATOR__VERSION_SPEC_QUERY:
				return basicSetVersionSpecQuery(null, msgs);
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
			case IteratorPackage.VERSION_ITERATOR__STEP_LENGTH:
				return new Integer(getStepLength());
			case IteratorPackage.VERSION_ITERATOR__PROJECT_ID:
				return getProjectId();
			case IteratorPackage.VERSION_ITERATOR__FORWARD:
				return isForward() ? Boolean.TRUE : Boolean.FALSE;
			case IteratorPackage.VERSION_ITERATOR__RETURN_PROJECT_DATA_COPY:
				return isReturnProjectDataCopy() ? Boolean.TRUE : Boolean.FALSE;
			case IteratorPackage.VERSION_ITERATOR__VERSION_SPEC_QUERY:
				return getVersionSpecQuery();
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
			case IteratorPackage.VERSION_ITERATOR__STEP_LENGTH:
				setStepLength(((Integer)newValue).intValue());
				return;
			case IteratorPackage.VERSION_ITERATOR__PROJECT_ID:
				setProjectId((ProjectId)newValue);
				return;
			case IteratorPackage.VERSION_ITERATOR__FORWARD:
				setForward(((Boolean)newValue).booleanValue());
				return;
			case IteratorPackage.VERSION_ITERATOR__RETURN_PROJECT_DATA_COPY:
				setReturnProjectDataCopy(((Boolean)newValue).booleanValue());
				return;
			case IteratorPackage.VERSION_ITERATOR__VERSION_SPEC_QUERY:
				setVersionSpecQuery((VersionSpecQuery)newValue);
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
			case IteratorPackage.VERSION_ITERATOR__STEP_LENGTH:
				setStepLength(STEP_LENGTH_EDEFAULT);
				return;
			case IteratorPackage.VERSION_ITERATOR__PROJECT_ID:
				setProjectId((ProjectId)null);
				return;
			case IteratorPackage.VERSION_ITERATOR__FORWARD:
				setForward(FORWARD_EDEFAULT);
				return;
			case IteratorPackage.VERSION_ITERATOR__RETURN_PROJECT_DATA_COPY:
				setReturnProjectDataCopy(RETURN_PROJECT_DATA_COPY_EDEFAULT);
				return;
			case IteratorPackage.VERSION_ITERATOR__VERSION_SPEC_QUERY:
				setVersionSpecQuery((VersionSpecQuery)null);
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
			case IteratorPackage.VERSION_ITERATOR__STEP_LENGTH:
				return stepLength != STEP_LENGTH_EDEFAULT;
			case IteratorPackage.VERSION_ITERATOR__PROJECT_ID:
				return projectId != null;
			case IteratorPackage.VERSION_ITERATOR__FORWARD:
				return forward != FORWARD_EDEFAULT;
			case IteratorPackage.VERSION_ITERATOR__RETURN_PROJECT_DATA_COPY:
				return returnProjectDataCopy != RETURN_PROJECT_DATA_COPY_EDEFAULT;
			case IteratorPackage.VERSION_ITERATOR__VERSION_SPEC_QUERY:
				return versionSpecQuery != null;
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
		result.append(" (stepLength: ");
		result.append(stepLength);
		result.append(", forward: ");
		result.append(forward);
		result.append(", returnProjectDataCopy: ");
		result.append(returnProjectDataCopy);
		result.append(')');
		return result.toString();
	}

} //VersionIteratorImpl
