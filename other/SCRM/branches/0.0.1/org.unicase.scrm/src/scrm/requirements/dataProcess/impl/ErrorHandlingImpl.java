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
import scrm.requirements.dataProcess.ErrorHandling;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Handling</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.requirements.dataProcess.impl.ErrorHandlingImpl#getHandledProcess <em>Handled Process</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ErrorHandlingImpl extends ProcessImpl implements ErrorHandling {
	/**
	 * The cached value of the '{@link #getHandledProcess() <em>Handled Process</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHandledProcess()
	 * @generated
	 * @ordered
	 */
	protected scrm.requirements.dataProcess.Process handledProcess;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ErrorHandlingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataProcessPackage.Literals.ERROR_HANDLING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public scrm.requirements.dataProcess.Process getHandledProcess() {
		if (handledProcess != null && handledProcess.eIsProxy()) {
			InternalEObject oldHandledProcess = (InternalEObject) handledProcess;
			handledProcess = (scrm.requirements.dataProcess.Process) eResolveProxy(oldHandledProcess);
			if (handledProcess != oldHandledProcess) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							DataProcessPackage.ERROR_HANDLING__HANDLED_PROCESS,
							oldHandledProcess, handledProcess));
			}
		}
		return handledProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public scrm.requirements.dataProcess.Process basicGetHandledProcess() {
		return handledProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHandledProcess(
			scrm.requirements.dataProcess.Process newHandledProcess,
			NotificationChain msgs) {
		scrm.requirements.dataProcess.Process oldHandledProcess = handledProcess;
		handledProcess = newHandledProcess;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					DataProcessPackage.ERROR_HANDLING__HANDLED_PROCESS,
					oldHandledProcess, newHandledProcess);
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
	public void setHandledProcess(
			scrm.requirements.dataProcess.Process newHandledProcess) {
		if (newHandledProcess != handledProcess) {
			NotificationChain msgs = null;
			if (handledProcess != null)
				msgs = ((InternalEObject) handledProcess).eInverseRemove(this,
						DataProcessPackage.PROCESS__ERROR_HANDLING,
						scrm.requirements.dataProcess.Process.class, msgs);
			if (newHandledProcess != null)
				msgs = ((InternalEObject) newHandledProcess).eInverseAdd(this,
						DataProcessPackage.PROCESS__ERROR_HANDLING,
						scrm.requirements.dataProcess.Process.class, msgs);
			msgs = basicSetHandledProcess(newHandledProcess, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DataProcessPackage.ERROR_HANDLING__HANDLED_PROCESS,
					newHandledProcess, newHandledProcess));
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
		case DataProcessPackage.ERROR_HANDLING__HANDLED_PROCESS:
			if (handledProcess != null)
				msgs = ((InternalEObject) handledProcess).eInverseRemove(this,
						DataProcessPackage.PROCESS__ERROR_HANDLING,
						scrm.requirements.dataProcess.Process.class, msgs);
			return basicSetHandledProcess(
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
		case DataProcessPackage.ERROR_HANDLING__HANDLED_PROCESS:
			return basicSetHandledProcess(null, msgs);
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
		case DataProcessPackage.ERROR_HANDLING__HANDLED_PROCESS:
			if (resolve)
				return getHandledProcess();
			return basicGetHandledProcess();
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
		case DataProcessPackage.ERROR_HANDLING__HANDLED_PROCESS:
			setHandledProcess((scrm.requirements.dataProcess.Process) newValue);
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
		case DataProcessPackage.ERROR_HANDLING__HANDLED_PROCESS:
			setHandledProcess((scrm.requirements.dataProcess.Process) null);
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
		case DataProcessPackage.ERROR_HANDLING__HANDLED_PROCESS:
			return handledProcess != null;
		}
		return super.eIsSet(featureID);
	}

} //ErrorHandlingImpl
