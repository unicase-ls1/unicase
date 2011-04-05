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

import scrm.requirements.DataFlow;
import scrm.requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.requirements.impl.ProcessImpl#getDataFlow <em>Data Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessImpl extends RequirementImpl implements scrm.requirements.Process {
	/**
	 * The cached value of the '{@link #getDataFlow() <em>Data Flow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataFlow()
	 * @generated
	 * @ordered
	 */
	protected DataFlow dataFlow;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.PROCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlow getDataFlow() {
		return dataFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataFlow(DataFlow newDataFlow, NotificationChain msgs) {
		DataFlow oldDataFlow = dataFlow;
		dataFlow = newDataFlow;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RequirementsPackage.PROCESS__DATA_FLOW, oldDataFlow, newDataFlow);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataFlow(DataFlow newDataFlow) {
		if (newDataFlow != dataFlow) {
			NotificationChain msgs = null;
			if (dataFlow != null)
				msgs = ((InternalEObject)dataFlow).eInverseRemove(this, RequirementsPackage.DATA_FLOW__SPECIFIED_PROCESS, DataFlow.class, msgs);
			if (newDataFlow != null)
				msgs = ((InternalEObject)newDataFlow).eInverseAdd(this, RequirementsPackage.DATA_FLOW__SPECIFIED_PROCESS, DataFlow.class, msgs);
			msgs = basicSetDataFlow(newDataFlow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.PROCESS__DATA_FLOW, newDataFlow, newDataFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RequirementsPackage.PROCESS__DATA_FLOW:
				if (dataFlow != null)
					msgs = ((InternalEObject)dataFlow).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RequirementsPackage.PROCESS__DATA_FLOW, null, msgs);
				return basicSetDataFlow((DataFlow)otherEnd, msgs);
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
			case RequirementsPackage.PROCESS__DATA_FLOW:
				return basicSetDataFlow(null, msgs);
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
			case RequirementsPackage.PROCESS__DATA_FLOW:
				return getDataFlow();
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
			case RequirementsPackage.PROCESS__DATA_FLOW:
				setDataFlow((DataFlow)newValue);
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
			case RequirementsPackage.PROCESS__DATA_FLOW:
				setDataFlow((DataFlow)null);
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
			case RequirementsPackage.PROCESS__DATA_FLOW:
				return dataFlow != null;
		}
		return super.eIsSet(featureID);
	}

} //ProcessImpl
