/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataObject.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import scrm.impl.SCRMModelElementImpl;
import scrm.requirements.RequirementSpace;
import scrm.requirements.RequirementsPackage;
import scrm.requirements.dataObject.ControlParameter;
import scrm.requirements.dataObject.DataObjectPackage;
import scrm.requirements.dataProcess.DataProcessPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Control Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.requirements.dataObject.impl.ControlParameterImpl#getControlledProcess <em>Controlled Process</em>}</li>
 *   <li>{@link scrm.requirements.dataObject.impl.ControlParameterImpl#getFormat <em>Format</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ControlParameterImpl extends SCRMModelElementImpl implements
		ControlParameter {
	/**
	 * The cached value of the '{@link #getControlledProcess() <em>Controlled Process</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlledProcess()
	 * @generated
	 * @ordered
	 */
	protected scrm.requirements.dataProcess.Process controlledProcess;

	/**
	 * The default value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String FORMAT_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected String format = FORMAT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ControlParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataObjectPackage.Literals.CONTROL_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public scrm.requirements.dataProcess.Process getControlledProcess() {
		if (controlledProcess != null && controlledProcess.eIsProxy()) {
			InternalEObject oldControlledProcess = (InternalEObject) controlledProcess;
			controlledProcess = (scrm.requirements.dataProcess.Process) eResolveProxy(oldControlledProcess);
			if (controlledProcess != oldControlledProcess) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							DataObjectPackage.CONTROL_PARAMETER__CONTROLLED_PROCESS,
							oldControlledProcess, controlledProcess));
			}
		}
		return controlledProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public scrm.requirements.dataProcess.Process basicGetControlledProcess() {
		return controlledProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetControlledProcess(
			scrm.requirements.dataProcess.Process newControlledProcess,
			NotificationChain msgs) {
		scrm.requirements.dataProcess.Process oldControlledProcess = controlledProcess;
		controlledProcess = newControlledProcess;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					DataObjectPackage.CONTROL_PARAMETER__CONTROLLED_PROCESS,
					oldControlledProcess, newControlledProcess);
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
	public void setControlledProcess(
			scrm.requirements.dataProcess.Process newControlledProcess) {
		if (newControlledProcess != controlledProcess) {
			NotificationChain msgs = null;
			if (controlledProcess != null)
				msgs = ((InternalEObject) controlledProcess).eInverseRemove(
						this, DataProcessPackage.PROCESS__CONTROL_PARAMETERS,
						scrm.requirements.dataProcess.Process.class, msgs);
			if (newControlledProcess != null)
				msgs = ((InternalEObject) newControlledProcess).eInverseAdd(
						this, DataProcessPackage.PROCESS__CONTROL_PARAMETERS,
						scrm.requirements.dataProcess.Process.class, msgs);
			msgs = basicSetControlledProcess(newControlledProcess, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DataObjectPackage.CONTROL_PARAMETER__CONTROLLED_PROCESS,
					newControlledProcess, newControlledProcess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormat(String newFormat) {
		String oldFormat = format;
		format = newFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DataObjectPackage.CONTROL_PARAMETER__FORMAT, oldFormat,
					format));
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
		case DataObjectPackage.CONTROL_PARAMETER__CONTROLLED_PROCESS:
			if (controlledProcess != null)
				msgs = ((InternalEObject) controlledProcess).eInverseRemove(
						this, DataProcessPackage.PROCESS__CONTROL_PARAMETERS,
						scrm.requirements.dataProcess.Process.class, msgs);
			return basicSetControlledProcess(
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
		case DataObjectPackage.CONTROL_PARAMETER__CONTROLLED_PROCESS:
			return basicSetControlledProcess(null, msgs);
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
		case DataObjectPackage.CONTROL_PARAMETER__CONTROLLED_PROCESS:
			if (resolve)
				return getControlledProcess();
			return basicGetControlledProcess();
		case DataObjectPackage.CONTROL_PARAMETER__FORMAT:
			return getFormat();
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
		case DataObjectPackage.CONTROL_PARAMETER__CONTROLLED_PROCESS:
			setControlledProcess((scrm.requirements.dataProcess.Process) newValue);
			return;
		case DataObjectPackage.CONTROL_PARAMETER__FORMAT:
			setFormat((String) newValue);
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
		case DataObjectPackage.CONTROL_PARAMETER__CONTROLLED_PROCESS:
			setControlledProcess((scrm.requirements.dataProcess.Process) null);
			return;
		case DataObjectPackage.CONTROL_PARAMETER__FORMAT:
			setFormat(FORMAT_EDEFAULT);
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
		case DataObjectPackage.CONTROL_PARAMETER__CONTROLLED_PROCESS:
			return controlledProcess != null;
		case DataObjectPackage.CONTROL_PARAMETER__FORMAT:
			return FORMAT_EDEFAULT == null ? format != null : !FORMAT_EDEFAULT
					.equals(format);
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
		result.append(" (format: ");
		result.append(format);
		result.append(')');
		return result.toString();
	}

} //ControlParameterImpl
