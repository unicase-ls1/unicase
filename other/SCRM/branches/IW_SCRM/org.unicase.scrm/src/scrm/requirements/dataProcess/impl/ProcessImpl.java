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
import scrm.requirements.impl.RequirementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.requirements.dataProcess.impl.ProcessImpl#getPredecessor <em>Predecessor</em>}</li>
 *   <li>{@link scrm.requirements.dataProcess.impl.ProcessImpl#getSuccessor <em>Successor</em>}</li>
 *   <li>{@link scrm.requirements.dataProcess.impl.ProcessImpl#getErrorHandling <em>Error Handling</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessImpl extends RequirementImpl implements
		scrm.requirements.dataProcess.Process {
	/**
	 * The cached value of the '{@link #getPredecessor() <em>Predecessor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredecessor()
	 * @generated
	 * @ordered
	 */
	protected scrm.requirements.dataProcess.Process predecessor;

	/**
	 * The cached value of the '{@link #getSuccessor() <em>Successor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccessor()
	 * @generated
	 * @ordered
	 */
	protected scrm.requirements.dataProcess.Process successor;

	/**
	 * The cached value of the '{@link #getErrorHandling() <em>Error Handling</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorHandling()
	 * @generated
	 * @ordered
	 */
	protected ErrorHandling errorHandling;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ProcessImpl() {
		super();
		description = "Specify how the given data will be processed. Specify the algorithm will be used or link to the realized method.";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataProcessPackage.Literals.PROCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public scrm.requirements.dataProcess.Process getPredecessor() {
		if (predecessor != null && predecessor.eIsProxy()) {
			InternalEObject oldPredecessor = (InternalEObject) predecessor;
			predecessor = (scrm.requirements.dataProcess.Process) eResolveProxy(oldPredecessor);
			if (predecessor != oldPredecessor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							DataProcessPackage.PROCESS__PREDECESSOR,
							oldPredecessor, predecessor));
			}
		}
		return predecessor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public scrm.requirements.dataProcess.Process basicGetPredecessor() {
		return predecessor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPredecessor(
			scrm.requirements.dataProcess.Process newPredecessor,
			NotificationChain msgs) {
		scrm.requirements.dataProcess.Process oldPredecessor = predecessor;
		predecessor = newPredecessor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, DataProcessPackage.PROCESS__PREDECESSOR,
					oldPredecessor, newPredecessor);
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
	public void setPredecessor(
			scrm.requirements.dataProcess.Process newPredecessor) {
		if (newPredecessor != predecessor) {
			NotificationChain msgs = null;
			if (predecessor != null)
				msgs = ((InternalEObject) predecessor).eInverseRemove(this,
						DataProcessPackage.PROCESS__SUCCESSOR,
						scrm.requirements.dataProcess.Process.class, msgs);
			if (newPredecessor != null)
				msgs = ((InternalEObject) newPredecessor).eInverseAdd(this,
						DataProcessPackage.PROCESS__SUCCESSOR,
						scrm.requirements.dataProcess.Process.class, msgs);
			msgs = basicSetPredecessor(newPredecessor, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DataProcessPackage.PROCESS__PREDECESSOR, newPredecessor,
					newPredecessor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public scrm.requirements.dataProcess.Process getSuccessor() {
		if (successor != null && successor.eIsProxy()) {
			InternalEObject oldSuccessor = (InternalEObject) successor;
			successor = (scrm.requirements.dataProcess.Process) eResolveProxy(oldSuccessor);
			if (successor != oldSuccessor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							DataProcessPackage.PROCESS__SUCCESSOR,
							oldSuccessor, successor));
			}
		}
		return successor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public scrm.requirements.dataProcess.Process basicGetSuccessor() {
		return successor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuccessor(
			scrm.requirements.dataProcess.Process newSuccessor,
			NotificationChain msgs) {
		scrm.requirements.dataProcess.Process oldSuccessor = successor;
		successor = newSuccessor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, DataProcessPackage.PROCESS__SUCCESSOR,
					oldSuccessor, newSuccessor);
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
	public void setSuccessor(scrm.requirements.dataProcess.Process newSuccessor) {
		if (newSuccessor != successor) {
			NotificationChain msgs = null;
			if (successor != null)
				msgs = ((InternalEObject) successor).eInverseRemove(this,
						DataProcessPackage.PROCESS__PREDECESSOR,
						scrm.requirements.dataProcess.Process.class, msgs);
			if (newSuccessor != null)
				msgs = ((InternalEObject) newSuccessor).eInverseAdd(this,
						DataProcessPackage.PROCESS__PREDECESSOR,
						scrm.requirements.dataProcess.Process.class, msgs);
			msgs = basicSetSuccessor(newSuccessor, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DataProcessPackage.PROCESS__SUCCESSOR, newSuccessor,
					newSuccessor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorHandling getErrorHandling() {
		if (errorHandling != null && errorHandling.eIsProxy()) {
			InternalEObject oldErrorHandling = (InternalEObject) errorHandling;
			errorHandling = (ErrorHandling) eResolveProxy(oldErrorHandling);
			if (errorHandling != oldErrorHandling) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							DataProcessPackage.PROCESS__ERROR_HANDLING,
							oldErrorHandling, errorHandling));
			}
		}
		return errorHandling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorHandling basicGetErrorHandling() {
		return errorHandling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetErrorHandling(
			ErrorHandling newErrorHandling, NotificationChain msgs) {
		ErrorHandling oldErrorHandling = errorHandling;
		errorHandling = newErrorHandling;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					DataProcessPackage.PROCESS__ERROR_HANDLING,
					oldErrorHandling, newErrorHandling);
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
	public void setErrorHandling(ErrorHandling newErrorHandling) {
		if (newErrorHandling != errorHandling) {
			NotificationChain msgs = null;
			if (errorHandling != null)
				msgs = ((InternalEObject) errorHandling).eInverseRemove(this,
						DataProcessPackage.ERROR_HANDLING__HANDLED_PROCESS,
						ErrorHandling.class, msgs);
			if (newErrorHandling != null)
				msgs = ((InternalEObject) newErrorHandling).eInverseAdd(this,
						DataProcessPackage.ERROR_HANDLING__HANDLED_PROCESS,
						ErrorHandling.class, msgs);
			msgs = basicSetErrorHandling(newErrorHandling, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DataProcessPackage.PROCESS__ERROR_HANDLING,
					newErrorHandling, newErrorHandling));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DataProcessPackage.PROCESS__PREDECESSOR:
			if (predecessor != null)
				msgs = ((InternalEObject) predecessor).eInverseRemove(this,
						DataProcessPackage.PROCESS__SUCCESSOR,
						scrm.requirements.dataProcess.Process.class, msgs);
			return basicSetPredecessor(
					(scrm.requirements.dataProcess.Process) otherEnd, msgs);
		case DataProcessPackage.PROCESS__SUCCESSOR:
			if (successor != null)
				msgs = ((InternalEObject) successor).eInverseRemove(this,
						DataProcessPackage.PROCESS__PREDECESSOR,
						scrm.requirements.dataProcess.Process.class, msgs);
			return basicSetSuccessor(
					(scrm.requirements.dataProcess.Process) otherEnd, msgs);
		case DataProcessPackage.PROCESS__ERROR_HANDLING:
			if (errorHandling != null)
				msgs = ((InternalEObject) errorHandling).eInverseRemove(this,
						DataProcessPackage.ERROR_HANDLING__HANDLED_PROCESS,
						ErrorHandling.class, msgs);
			return basicSetErrorHandling((ErrorHandling) otherEnd, msgs);
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
		case DataProcessPackage.PROCESS__PREDECESSOR:
			return basicSetPredecessor(null, msgs);
		case DataProcessPackage.PROCESS__SUCCESSOR:
			return basicSetSuccessor(null, msgs);
		case DataProcessPackage.PROCESS__ERROR_HANDLING:
			return basicSetErrorHandling(null, msgs);
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
		case DataProcessPackage.PROCESS__PREDECESSOR:
			if (resolve)
				return getPredecessor();
			return basicGetPredecessor();
		case DataProcessPackage.PROCESS__SUCCESSOR:
			if (resolve)
				return getSuccessor();
			return basicGetSuccessor();
		case DataProcessPackage.PROCESS__ERROR_HANDLING:
			if (resolve)
				return getErrorHandling();
			return basicGetErrorHandling();
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
		case DataProcessPackage.PROCESS__PREDECESSOR:
			setPredecessor((scrm.requirements.dataProcess.Process) newValue);
			return;
		case DataProcessPackage.PROCESS__SUCCESSOR:
			setSuccessor((scrm.requirements.dataProcess.Process) newValue);
			return;
		case DataProcessPackage.PROCESS__ERROR_HANDLING:
			setErrorHandling((ErrorHandling) newValue);
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
		case DataProcessPackage.PROCESS__PREDECESSOR:
			setPredecessor((scrm.requirements.dataProcess.Process) null);
			return;
		case DataProcessPackage.PROCESS__SUCCESSOR:
			setSuccessor((scrm.requirements.dataProcess.Process) null);
			return;
		case DataProcessPackage.PROCESS__ERROR_HANDLING:
			setErrorHandling((ErrorHandling) null);
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
		case DataProcessPackage.PROCESS__PREDECESSOR:
			return predecessor != null;
		case DataProcessPackage.PROCESS__SUCCESSOR:
			return successor != null;
		case DataProcessPackage.PROCESS__ERROR_HANDLING:
			return errorHandling != null;
		}
		return super.eIsSet(featureID);
	}

} //ProcessImpl
