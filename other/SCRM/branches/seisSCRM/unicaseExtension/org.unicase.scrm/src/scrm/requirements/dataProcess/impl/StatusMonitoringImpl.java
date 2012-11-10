/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataProcess.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import scrm.requirements.dataProcess.DataProcessPackage;
import scrm.requirements.dataProcess.StatusMonitoring;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Status Monitoring</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.requirements.dataProcess.impl.StatusMonitoringImpl#getMonitoredProcess <em>Monitored Process</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StatusMonitoringImpl extends ProcessImpl implements
		StatusMonitoring {
	/**
	 * The cached value of the '{@link #getMonitoredProcess() <em>Monitored Process</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonitoredProcess()
	 * @generated
	 * @ordered
	 */
	protected scrm.requirements.dataProcess.Process monitoredProcess;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatusMonitoringImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataProcessPackage.Literals.STATUS_MONITORING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public scrm.requirements.dataProcess.Process getMonitoredProcess() {
		if (monitoredProcess != null && monitoredProcess.eIsProxy()) {
			InternalEObject oldMonitoredProcess = (InternalEObject) monitoredProcess;
			monitoredProcess = (scrm.requirements.dataProcess.Process) eResolveProxy(oldMonitoredProcess);
			if (monitoredProcess != oldMonitoredProcess) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							DataProcessPackage.STATUS_MONITORING__MONITORED_PROCESS,
							oldMonitoredProcess, monitoredProcess));
			}
		}
		return monitoredProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public scrm.requirements.dataProcess.Process basicGetMonitoredProcess() {
		return monitoredProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMonitoredProcess(
			scrm.requirements.dataProcess.Process newMonitoredProcess,
			NotificationChain msgs) {
		scrm.requirements.dataProcess.Process oldMonitoredProcess = monitoredProcess;
		monitoredProcess = newMonitoredProcess;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					DataProcessPackage.STATUS_MONITORING__MONITORED_PROCESS,
					oldMonitoredProcess, newMonitoredProcess);
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
	public void setMonitoredProcess(
			scrm.requirements.dataProcess.Process newMonitoredProcess) {
		if (newMonitoredProcess != monitoredProcess) {
			NotificationChain msgs = null;
			if (monitoredProcess != null)
				msgs = ((InternalEObject) monitoredProcess).eInverseRemove(
						this, DataProcessPackage.PROCESS__STATUS_MONITORING,
						scrm.requirements.dataProcess.Process.class, msgs);
			if (newMonitoredProcess != null)
				msgs = ((InternalEObject) newMonitoredProcess).eInverseAdd(
						this, DataProcessPackage.PROCESS__STATUS_MONITORING,
						scrm.requirements.dataProcess.Process.class, msgs);
			msgs = basicSetMonitoredProcess(newMonitoredProcess, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DataProcessPackage.STATUS_MONITORING__MONITORED_PROCESS,
					newMonitoredProcess, newMonitoredProcess));
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
		case DataProcessPackage.STATUS_MONITORING__MONITORED_PROCESS:
			if (monitoredProcess != null)
				msgs = ((InternalEObject) monitoredProcess).eInverseRemove(
						this, DataProcessPackage.PROCESS__STATUS_MONITORING,
						scrm.requirements.dataProcess.Process.class, msgs);
			return basicSetMonitoredProcess(
					(scrm.requirements.dataProcess.Process) otherEnd, msgs);
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
		case DataProcessPackage.STATUS_MONITORING__MONITORED_PROCESS:
			return basicSetMonitoredProcess(null, msgs);
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
		case DataProcessPackage.STATUS_MONITORING__MONITORED_PROCESS:
			if (resolve)
				return getMonitoredProcess();
			return basicGetMonitoredProcess();
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
		case DataProcessPackage.STATUS_MONITORING__MONITORED_PROCESS:
			setMonitoredProcess((scrm.requirements.dataProcess.Process) newValue);
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
		case DataProcessPackage.STATUS_MONITORING__MONITORED_PROCESS:
			setMonitoredProcess((scrm.requirements.dataProcess.Process) null);
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
		case DataProcessPackage.STATUS_MONITORING__MONITORED_PROCESS:
			return monitoredProcess != null;
		}
		return super.eIsSet(featureID);
	}

} //StatusMonitoringImpl
