/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.change.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.unicase.model.change.ChangePackage;
import org.unicase.model.change.MergingSolution;
import org.unicase.model.change.ModelChangePackage;
import org.unicase.model.rationale.impl.SolutionImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Merging Solution</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.model.change.impl.MergingSolutionImpl#getAppliedChanges <em>Applied Changes</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MergingSolutionImpl extends SolutionImpl implements MergingSolution {
	/**
	 * The cached value of the '{@link #getAppliedChanges() <em>Applied Changes</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAppliedChanges()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelChangePackage> appliedChanges;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MergingSolutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ChangePackage.Literals.MERGING_SOLUTION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ModelChangePackage> getAppliedChanges() {
		if (appliedChanges == null) {
			appliedChanges = new EObjectResolvingEList<ModelChangePackage>(ModelChangePackage.class, this,
				ChangePackage.MERGING_SOLUTION__APPLIED_CHANGES);
		}
		return appliedChanges;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ChangePackage.MERGING_SOLUTION__APPLIED_CHANGES:
			return getAppliedChanges();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ChangePackage.MERGING_SOLUTION__APPLIED_CHANGES:
			getAppliedChanges().clear();
			getAppliedChanges().addAll((Collection<? extends ModelChangePackage>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ChangePackage.MERGING_SOLUTION__APPLIED_CHANGES:
			getAppliedChanges().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ChangePackage.MERGING_SOLUTION__APPLIED_CHANGES:
			return appliedChanges != null && !appliedChanges.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // MergingSolutionImpl
