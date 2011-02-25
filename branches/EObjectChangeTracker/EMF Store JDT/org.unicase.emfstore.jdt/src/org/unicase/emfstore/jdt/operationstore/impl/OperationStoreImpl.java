/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.jdt.operationstore.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.unicase.emfstore.jdt.operationstore.OperationSet;
import org.unicase.emfstore.jdt.operationstore.OperationStore;
import org.unicase.emfstore.jdt.operationstore.OperationstorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Store</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.jdt.operationstore.impl.OperationStoreImpl#getOperationSets <em>Operation Sets</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationStoreImpl extends EObjectImpl implements OperationStore {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationStoreImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationstorePackage.Literals.OPERATION_STORE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<OperationSet> getOperationSets() {
		return (EList<OperationSet>)eGet(OperationstorePackage.Literals.OPERATION_STORE__OPERATION_SETS, true);
	}

} //OperationStoreImpl
