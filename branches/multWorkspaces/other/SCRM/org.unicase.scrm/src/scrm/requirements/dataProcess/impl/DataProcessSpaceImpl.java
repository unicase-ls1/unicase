/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataProcess.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import scrm.requirements.dataProcess.DataProcessPackage;
import scrm.requirements.dataProcess.DataProcessSpace;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Space</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.requirements.dataProcess.impl.DataProcessSpaceImpl#getContainedDataProcessSteps <em>Contained Data Process Steps</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataProcessSpaceImpl extends ProcessImpl implements
		DataProcessSpace {
	/**
	 * The cached value of the '{@link #getContainedDataProcessSteps() <em>Contained Data Process Steps</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedDataProcessSteps()
	 * @generated
	 * @ordered
	 */
	protected EList<scrm.requirements.dataProcess.Process> containedDataProcessSteps;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataProcessSpaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataProcessPackage.Literals.DATA_PROCESS_SPACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<scrm.requirements.dataProcess.Process> getContainedDataProcessSteps() {
		if (containedDataProcessSteps == null) {
			containedDataProcessSteps = new EObjectContainmentWithInverseEList.Resolving<scrm.requirements.dataProcess.Process>(
					scrm.requirements.dataProcess.Process.class,
					this,
					DataProcessPackage.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS,
					DataProcessPackage.PROCESS__CONTAINING_DATA_PROCESS_SPACE);
		}
		return containedDataProcessSteps;
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
		case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getContainedDataProcessSteps())
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
		case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS:
			return ((InternalEList<?>) getContainedDataProcessSteps())
					.basicRemove(otherEnd, msgs);
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
		case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS:
			return getContainedDataProcessSteps();
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
		case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS:
			getContainedDataProcessSteps().clear();
			getContainedDataProcessSteps()
					.addAll((Collection<? extends scrm.requirements.dataProcess.Process>) newValue);
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
		case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS:
			getContainedDataProcessSteps().clear();
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
		case DataProcessPackage.DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS:
			return containedDataProcessSteps != null
					&& !containedDataProcessSteps.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DataProcessSpaceImpl
