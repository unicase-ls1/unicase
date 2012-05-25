/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.meeting.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.unicase.model.meeting.MeetingPackage;
import org.unicase.model.meeting.WorkItemMeetingSection;
import org.unicase.model.task.WorkItem;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Work Item Meeting Section</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.model.meeting.impl.WorkItemMeetingSectionImpl#getIncludedWorkItems <em>Included Work Items
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class WorkItemMeetingSectionImpl extends MeetingSectionImpl implements WorkItemMeetingSection {
	/**
	 * The cached value of the '{@link #getIncludedWorkItems() <em>Included Work Items</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getIncludedWorkItems()
	 * @generated
	 * @ordered
	 */
	protected EList<WorkItem> includedWorkItems;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected WorkItemMeetingSectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MeetingPackage.Literals.WORK_ITEM_MEETING_SECTION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<WorkItem> getIncludedWorkItems() {
		if (includedWorkItems == null) {
			includedWorkItems = new EObjectResolvingEList<WorkItem>(WorkItem.class, this,
				MeetingPackage.WORK_ITEM_MEETING_SECTION__INCLUDED_WORK_ITEMS);
		}
		return includedWorkItems;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MeetingPackage.WORK_ITEM_MEETING_SECTION__INCLUDED_WORK_ITEMS:
			return getIncludedWorkItems();
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
		case MeetingPackage.WORK_ITEM_MEETING_SECTION__INCLUDED_WORK_ITEMS:
			getIncludedWorkItems().clear();
			getIncludedWorkItems().addAll((Collection<? extends WorkItem>) newValue);
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
		case MeetingPackage.WORK_ITEM_MEETING_SECTION__INCLUDED_WORK_ITEMS:
			getIncludedWorkItems().clear();
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
		case MeetingPackage.WORK_ITEM_MEETING_SECTION__INCLUDED_WORK_ITEMS:
			return includedWorkItems != null && !includedWorkItems.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // WorkItemMeetingSectionImpl
