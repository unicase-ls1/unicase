/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.release.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.impl.UnicaseModelElementImpl;
import org.unicase.model.release.AbstractRelease;
import org.unicase.model.release.ReleasePackage;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Release</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.release.impl.AbstractReleaseImpl#getIncludedWorkItems <em>Included Work Items</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractReleaseImpl extends UnicaseModelElementImpl implements AbstractRelease {
	/**
	 * The cached value of the '{@link #getIncludedWorkItems() <em>Included Work Items</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncludedWorkItems()
	 * @generated
	 * @ordered
	 */
	protected EList<WorkItem> includedWorkItems;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractReleaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ReleasePackage.Literals.ABSTRACT_RELEASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WorkItem> getIncludedWorkItems() {
		if (includedWorkItems == null) {
			includedWorkItems = new EObjectWithInverseResolvingEList.ManyInverse<WorkItem>(WorkItem.class, this,
				ReleasePackage.ABSTRACT_RELEASE__INCLUDED_WORK_ITEMS, TaskPackage.WORK_ITEM__INCLUDING_RELEASES);
		}
		return includedWorkItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ReleasePackage.ABSTRACT_RELEASE__INCLUDED_WORK_ITEMS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getIncludedWorkItems())
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ReleasePackage.ABSTRACT_RELEASE__INCLUDED_WORK_ITEMS:
			return ((InternalEList<?>) getIncludedWorkItems()).basicRemove(otherEnd, msgs);
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
		case ReleasePackage.ABSTRACT_RELEASE__INCLUDED_WORK_ITEMS:
			return getIncludedWorkItems();
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
		case ReleasePackage.ABSTRACT_RELEASE__INCLUDED_WORK_ITEMS:
			getIncludedWorkItems().clear();
			getIncludedWorkItems().addAll((Collection<? extends WorkItem>) newValue);
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
		case ReleasePackage.ABSTRACT_RELEASE__INCLUDED_WORK_ITEMS:
			getIncludedWorkItems().clear();
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
		case ReleasePackage.ABSTRACT_RELEASE__INCLUDED_WORK_ITEMS:
			return includedWorkItems != null && !includedWorkItems.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AbstractReleaseImpl
