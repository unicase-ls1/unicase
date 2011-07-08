/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.activity.impl;

import org.eclipse.emf.ecore.EClass;
import org.unicase.model.activity.Activity;
import org.unicase.model.activity.ActivityPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Activity</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ActivityImpl extends ActivityObjectImpl implements Activity {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActivityPackage.Literals.ACTIVITY;
	}

	@Override
	public String getDescriptionPlainText() {
		// TODO Auto-generated method stub
		return null;
	}

} // ActivityImpl
