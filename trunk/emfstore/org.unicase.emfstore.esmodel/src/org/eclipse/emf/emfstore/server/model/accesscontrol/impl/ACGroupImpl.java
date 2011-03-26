/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.model.accesscontrol.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACGroup;
import org.eclipse.emf.emfstore.server.model.accesscontrol.ACOrgUnit;
import org.eclipse.emf.emfstore.server.model.accesscontrol.AccesscontrolPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>AC Group</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.server.model.accesscontrol.impl.ACGroupImpl#getMembers <em>Members</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ACGroupImpl extends ACOrgUnitImpl implements ACGroup {
	/**
	 * The cached value of the '{@link #getMembers() <em>Members</em>}' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getMembers()
	 * @generated
	 * @ordered
	 */
	protected EList<ACOrgUnit> members;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ACGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AccesscontrolPackage.Literals.AC_GROUP;
	}

	// begin of custom code
	/**
	 * <!-- begin-user-doc --> Get the group members.
	 * 
	 * @return a list of org units <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("serial")
	public EList<ACOrgUnit> getMembers() {
		if (members == null) {
			// see comment in RoleImpl.getProjects()
			members = new EObjectResolvingEList<ACOrgUnit>(ACOrgUnit.class, this,
				AccesscontrolPackage.AC_GROUP__MEMBERS) {

				@Override
				protected boolean useEquals() {
					// TODO Auto-generated method stub
					return true;
				}

			};
		}
		return members;
	}

	// end of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case AccesscontrolPackage.AC_GROUP__MEMBERS:
			return getMembers();
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
		case AccesscontrolPackage.AC_GROUP__MEMBERS:
			getMembers().clear();
			getMembers().addAll((Collection<? extends ACOrgUnit>) newValue);
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
		case AccesscontrolPackage.AC_GROUP__MEMBERS:
			getMembers().clear();
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
		case AccesscontrolPackage.AC_GROUP__MEMBERS:
			return members != null && !members.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ACGroupImpl
