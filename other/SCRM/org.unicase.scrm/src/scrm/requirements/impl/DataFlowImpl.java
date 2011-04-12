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

import org.eclipse.emf.ecore.util.EcoreUtil;

import scrm.impl.SCRMModelElementImpl;
import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.ScientificKnowledge;
import scrm.requirements.DataFlow;
import scrm.requirements.RequirementSpace;
import scrm.requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.requirements.impl.DataFlowImpl#getContainingRequirementSpace <em>Containing Requirement Space</em>}</li>
 *   <li>{@link scrm.requirements.impl.DataFlowImpl#getSpecifiedProcess <em>Specified Process</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataFlowImpl extends SCRMModelElementImpl implements DataFlow {
	/**
	 * The cached value of the '{@link #getSpecifiedProcess() <em>Specified Process</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecifiedProcess()
	 * @generated
	 * @ordered
	 */
	protected scrm.requirements.Process specifiedProcess;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataFlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.DATA_FLOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementSpace getContainingRequirementSpace() {
		if (eContainerFeatureID() != RequirementsPackage.DATA_FLOW__CONTAINING_REQUIREMENT_SPACE)
			return null;
		return (RequirementSpace) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementSpace basicGetContainingRequirementSpace() {
		if (eContainerFeatureID() != RequirementsPackage.DATA_FLOW__CONTAINING_REQUIREMENT_SPACE)
			return null;
		return (RequirementSpace) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainingRequirementSpace(
			RequirementSpace newContainingRequirementSpace,
			NotificationChain msgs) {
		msgs = eBasicSetContainer(
				(InternalEObject) newContainingRequirementSpace,
				RequirementsPackage.DATA_FLOW__CONTAINING_REQUIREMENT_SPACE,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingRequirementSpace(
			RequirementSpace newContainingRequirementSpace) {
		if (newContainingRequirementSpace != eInternalContainer()
				|| (eContainerFeatureID() != RequirementsPackage.DATA_FLOW__CONTAINING_REQUIREMENT_SPACE && newContainingRequirementSpace != null)) {
			if (EcoreUtil.isAncestor(this, newContainingRequirementSpace))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainingRequirementSpace != null)
				msgs = ((InternalEObject) newContainingRequirementSpace)
						.eInverseAdd(
								this,
								RequirementsPackage.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS,
								RequirementSpace.class, msgs);
			msgs = basicSetContainingRequirementSpace(
					newContainingRequirementSpace, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					RequirementsPackage.DATA_FLOW__CONTAINING_REQUIREMENT_SPACE,
					newContainingRequirementSpace,
					newContainingRequirementSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public scrm.requirements.Process getSpecifiedProcess() {
		if (specifiedProcess != null && specifiedProcess.eIsProxy()) {
			InternalEObject oldSpecifiedProcess = (InternalEObject) specifiedProcess;
			specifiedProcess = (scrm.requirements.Process) eResolveProxy(oldSpecifiedProcess);
			if (specifiedProcess != oldSpecifiedProcess) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							RequirementsPackage.DATA_FLOW__SPECIFIED_PROCESS,
							oldSpecifiedProcess, specifiedProcess));
			}
		}
		return specifiedProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public scrm.requirements.Process basicGetSpecifiedProcess() {
		return specifiedProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecifiedProcess(
			scrm.requirements.Process newSpecifiedProcess,
			NotificationChain msgs) {
		scrm.requirements.Process oldSpecifiedProcess = specifiedProcess;
		specifiedProcess = newSpecifiedProcess;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					RequirementsPackage.DATA_FLOW__SPECIFIED_PROCESS,
					oldSpecifiedProcess, newSpecifiedProcess);
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
	public void setSpecifiedProcess(
			scrm.requirements.Process newSpecifiedProcess) {
		if (newSpecifiedProcess != specifiedProcess) {
			NotificationChain msgs = null;
			if (specifiedProcess != null)
				msgs = ((InternalEObject) specifiedProcess).eInverseRemove(
						this, RequirementsPackage.PROCESS__DATA_FLOW,
						scrm.requirements.Process.class, msgs);
			if (newSpecifiedProcess != null)
				msgs = ((InternalEObject) newSpecifiedProcess).eInverseAdd(
						this, RequirementsPackage.PROCESS__DATA_FLOW,
						scrm.requirements.Process.class, msgs);
			msgs = basicSetSpecifiedProcess(newSpecifiedProcess, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementsPackage.DATA_FLOW__SPECIFIED_PROCESS,
					newSpecifiedProcess, newSpecifiedProcess));
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
		case RequirementsPackage.DATA_FLOW__CONTAINING_REQUIREMENT_SPACE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetContainingRequirementSpace(
					(RequirementSpace) otherEnd, msgs);
		case RequirementsPackage.DATA_FLOW__SPECIFIED_PROCESS:
			if (specifiedProcess != null)
				msgs = ((InternalEObject) specifiedProcess).eInverseRemove(
						this, RequirementsPackage.PROCESS__DATA_FLOW,
						scrm.requirements.Process.class, msgs);
			return basicSetSpecifiedProcess(
					(scrm.requirements.Process) otherEnd, msgs);
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
		case RequirementsPackage.DATA_FLOW__CONTAINING_REQUIREMENT_SPACE:
			return basicSetContainingRequirementSpace(null, msgs);
		case RequirementsPackage.DATA_FLOW__SPECIFIED_PROCESS:
			return basicSetSpecifiedProcess(null, msgs);
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
		case RequirementsPackage.DATA_FLOW__CONTAINING_REQUIREMENT_SPACE:
			return eInternalContainer()
					.eInverseRemove(
							this,
							RequirementsPackage.REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS,
							RequirementSpace.class, msgs);
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
		case RequirementsPackage.DATA_FLOW__CONTAINING_REQUIREMENT_SPACE:
			if (resolve)
				return getContainingRequirementSpace();
			return basicGetContainingRequirementSpace();
		case RequirementsPackage.DATA_FLOW__SPECIFIED_PROCESS:
			if (resolve)
				return getSpecifiedProcess();
			return basicGetSpecifiedProcess();
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
		case RequirementsPackage.DATA_FLOW__CONTAINING_REQUIREMENT_SPACE:
			setContainingRequirementSpace((RequirementSpace) newValue);
			return;
		case RequirementsPackage.DATA_FLOW__SPECIFIED_PROCESS:
			setSpecifiedProcess((scrm.requirements.Process) newValue);
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
		case RequirementsPackage.DATA_FLOW__CONTAINING_REQUIREMENT_SPACE:
			setContainingRequirementSpace((RequirementSpace) null);
			return;
		case RequirementsPackage.DATA_FLOW__SPECIFIED_PROCESS:
			setSpecifiedProcess((scrm.requirements.Process) null);
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
		case RequirementsPackage.DATA_FLOW__CONTAINING_REQUIREMENT_SPACE:
			return basicGetContainingRequirementSpace() != null;
		case RequirementsPackage.DATA_FLOW__SPECIFIED_PROCESS:
			return specifiedProcess != null;
		}
		return super.eIsSet(featureID);
	}

} //DataFlowImpl
