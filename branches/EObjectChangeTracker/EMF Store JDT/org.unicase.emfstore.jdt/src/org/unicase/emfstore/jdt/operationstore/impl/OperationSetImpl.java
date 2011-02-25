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

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

import org.unicase.emfstore.jdt.operationstore.OperationSet;
import org.unicase.emfstore.jdt.operationstore.OperationstorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.jdt.operationstore.impl.OperationSetImpl#getBaseVersion <em>Base Version</em>}</li>
 *   <li>{@link org.unicase.emfstore.jdt.operationstore.impl.OperationSetImpl#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationSetImpl extends EObjectImpl implements OperationSet {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationstorePackage.Literals.OPERATION_SET;
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
	public String getBaseVersion() {
		return (String)eGet(OperationstorePackage.Literals.OPERATION_SET__BASE_VERSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseVersion(String newBaseVersion) {
		eSet(OperationstorePackage.Literals.OPERATION_SET__BASE_VERSION, newBaseVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<AbstractOperation> getOperations() {
		return (EList<AbstractOperation>)eGet(OperationstorePackage.Literals.OPERATION_SET__OPERATIONS, true);
	}

} //OperationSetImpl
