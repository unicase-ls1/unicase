/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataProcess.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import scrm.requirements.dataObject.ControlParameter;
import scrm.requirements.dataObject.DataObjectPackage;
import scrm.requirements.dataProcess.DataProcessPackage;
import scrm.requirements.dataProcess.DataProcessSpace;
import scrm.requirements.dataProcess.ErrorHandling;
import scrm.requirements.dataProcess.StatusMonitoring;
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
 *   <li>{@link scrm.requirements.dataProcess.impl.ProcessImpl#getContainingDataProcessSpace <em>Containing Data Process Space</em>}</li>
 *   <li>{@link scrm.requirements.dataProcess.impl.ProcessImpl#getErrorHandling <em>Error Handling</em>}</li>
 *   <li>{@link scrm.requirements.dataProcess.impl.ProcessImpl#getStatusMonitoring <em>Status Monitoring</em>}</li>
 *   <li>{@link scrm.requirements.dataProcess.impl.ProcessImpl#getControlParameters <em>Control Parameters</em>}</li>
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
	 * The cached value of the '{@link #getStatusMonitoring() <em>Status Monitoring</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatusMonitoring()
	 * @generated
	 * @ordered
	 */
	protected StatusMonitoring statusMonitoring;

	/**
	 * The cached value of the '{@link #getControlParameters() <em>Control Parameters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<ControlParameter> controlParameters;

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
	public DataProcessSpace getContainingDataProcessSpace() {
		if (eContainerFeatureID() != DataProcessPackage.PROCESS__CONTAINING_DATA_PROCESS_SPACE)
			return null;
		return (DataProcessSpace) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataProcessSpace basicGetContainingDataProcessSpace() {
		if (eContainerFeatureID() != DataProcessPackage.PROCESS__CONTAINING_DATA_PROCESS_SPACE)
			return null;
		return (DataProcessSpace) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainingDataProcessSpace(
			DataProcessSpace newContainingDataProcessSpace,
			NotificationChain msgs) {
		msgs = eBasicSetContainer(
				(InternalEObject) newContainingDataProcessSpace,
				DataProcessPackage.PROCESS__CONTAINING_DATA_PROCESS_SPACE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingDataProcessSpace(
			DataProcessSpace newContainingDataProcessSpace) {
		if (newContainingDataProcessSpace != eInternalContainer()
				|| (eContainerFeatureID() != DataProcessPackage.PROCESS__CONTAINING_DATA_PROCESS_SPACE && newContainingDataProcessSpace != null)) {
			if (EcoreUtil.isAncestor(this, newContainingDataProcessSpace))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainingDataProcessSpace != null)
				msgs = ((InternalEObject) newContainingDataProcessSpace)
						.eInverseAdd(
								this,
								DataProcessPackage.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS,
								DataProcessSpace.class, msgs);
			msgs = basicSetContainingDataProcessSpace(
					newContainingDataProcessSpace, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DataProcessPackage.PROCESS__CONTAINING_DATA_PROCESS_SPACE,
					newContainingDataProcessSpace,
					newContainingDataProcessSpace));
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
	public StatusMonitoring getStatusMonitoring() {
		if (statusMonitoring != null && statusMonitoring.eIsProxy()) {
			InternalEObject oldStatusMonitoring = (InternalEObject) statusMonitoring;
			statusMonitoring = (StatusMonitoring) eResolveProxy(oldStatusMonitoring);
			if (statusMonitoring != oldStatusMonitoring) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							DataProcessPackage.PROCESS__STATUS_MONITORING,
							oldStatusMonitoring, statusMonitoring));
			}
		}
		return statusMonitoring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatusMonitoring basicGetStatusMonitoring() {
		return statusMonitoring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStatusMonitoring(
			StatusMonitoring newStatusMonitoring, NotificationChain msgs) {
		StatusMonitoring oldStatusMonitoring = statusMonitoring;
		statusMonitoring = newStatusMonitoring;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					DataProcessPackage.PROCESS__STATUS_MONITORING,
					oldStatusMonitoring, newStatusMonitoring);
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
	public void setStatusMonitoring(StatusMonitoring newStatusMonitoring) {
		if (newStatusMonitoring != statusMonitoring) {
			NotificationChain msgs = null;
			if (statusMonitoring != null)
				msgs = ((InternalEObject) statusMonitoring)
						.eInverseRemove(
								this,
								DataProcessPackage.STATUS_MONITORING__MONITORED_PROCESS,
								StatusMonitoring.class, msgs);
			if (newStatusMonitoring != null)
				msgs = ((InternalEObject) newStatusMonitoring)
						.eInverseAdd(
								this,
								DataProcessPackage.STATUS_MONITORING__MONITORED_PROCESS,
								StatusMonitoring.class, msgs);
			msgs = basicSetStatusMonitoring(newStatusMonitoring, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DataProcessPackage.PROCESS__STATUS_MONITORING,
					newStatusMonitoring, newStatusMonitoring));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ControlParameter> getControlParameters() {
		if (controlParameters == null) {
			controlParameters = new EObjectWithInverseResolvingEList<ControlParameter>(
					ControlParameter.class, this,
					DataProcessPackage.PROCESS__CONTROL_PARAMETERS,
					DataObjectPackage.CONTROL_PARAMETER__CONTROLLED_PROCESS);
		}
		return controlParameters;
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
		case DataProcessPackage.PROCESS__CONTAINING_DATA_PROCESS_SPACE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetContainingDataProcessSpace(
					(DataProcessSpace) otherEnd, msgs);
		case DataProcessPackage.PROCESS__ERROR_HANDLING:
			if (errorHandling != null)
				msgs = ((InternalEObject) errorHandling).eInverseRemove(this,
						DataProcessPackage.ERROR_HANDLING__HANDLED_PROCESS,
						ErrorHandling.class, msgs);
			return basicSetErrorHandling((ErrorHandling) otherEnd, msgs);
		case DataProcessPackage.PROCESS__STATUS_MONITORING:
			if (statusMonitoring != null)
				msgs = ((InternalEObject) statusMonitoring)
						.eInverseRemove(
								this,
								DataProcessPackage.STATUS_MONITORING__MONITORED_PROCESS,
								StatusMonitoring.class, msgs);
			return basicSetStatusMonitoring((StatusMonitoring) otherEnd, msgs);
		case DataProcessPackage.PROCESS__CONTROL_PARAMETERS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getControlParameters())
					.basicAdd(otherEnd, msgs);
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
		case DataProcessPackage.PROCESS__CONTAINING_DATA_PROCESS_SPACE:
			return basicSetContainingDataProcessSpace(null, msgs);
		case DataProcessPackage.PROCESS__ERROR_HANDLING:
			return basicSetErrorHandling(null, msgs);
		case DataProcessPackage.PROCESS__STATUS_MONITORING:
			return basicSetStatusMonitoring(null, msgs);
		case DataProcessPackage.PROCESS__CONTROL_PARAMETERS:
			return ((InternalEList<?>) getControlParameters()).basicRemove(
					otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case DataProcessPackage.PROCESS__CONTAINING_DATA_PROCESS_SPACE:
			return eInternalContainer()
					.eInverseRemove(
							this,
							DataProcessPackage.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS,
							DataProcessSpace.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
		case DataProcessPackage.PROCESS__CONTAINING_DATA_PROCESS_SPACE:
			if (resolve)
				return getContainingDataProcessSpace();
			return basicGetContainingDataProcessSpace();
		case DataProcessPackage.PROCESS__ERROR_HANDLING:
			if (resolve)
				return getErrorHandling();
			return basicGetErrorHandling();
		case DataProcessPackage.PROCESS__STATUS_MONITORING:
			if (resolve)
				return getStatusMonitoring();
			return basicGetStatusMonitoring();
		case DataProcessPackage.PROCESS__CONTROL_PARAMETERS:
			return getControlParameters();
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
		case DataProcessPackage.PROCESS__CONTAINING_DATA_PROCESS_SPACE:
			setContainingDataProcessSpace((DataProcessSpace) newValue);
			return;
		case DataProcessPackage.PROCESS__ERROR_HANDLING:
			setErrorHandling((ErrorHandling) newValue);
			return;
		case DataProcessPackage.PROCESS__STATUS_MONITORING:
			setStatusMonitoring((StatusMonitoring) newValue);
			return;
		case DataProcessPackage.PROCESS__CONTROL_PARAMETERS:
			getControlParameters().clear();
			getControlParameters().addAll(
					(Collection<? extends ControlParameter>) newValue);
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
		case DataProcessPackage.PROCESS__CONTAINING_DATA_PROCESS_SPACE:
			setContainingDataProcessSpace((DataProcessSpace) null);
			return;
		case DataProcessPackage.PROCESS__ERROR_HANDLING:
			setErrorHandling((ErrorHandling) null);
			return;
		case DataProcessPackage.PROCESS__STATUS_MONITORING:
			setStatusMonitoring((StatusMonitoring) null);
			return;
		case DataProcessPackage.PROCESS__CONTROL_PARAMETERS:
			getControlParameters().clear();
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
		case DataProcessPackage.PROCESS__CONTAINING_DATA_PROCESS_SPACE:
			return basicGetContainingDataProcessSpace() != null;
		case DataProcessPackage.PROCESS__ERROR_HANDLING:
			return errorHandling != null;
		case DataProcessPackage.PROCESS__STATUS_MONITORING:
			return statusMonitoring != null;
		case DataProcessPackage.PROCESS__CONTROL_PARAMETERS:
			return controlParameters != null && !controlParameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ProcessImpl
