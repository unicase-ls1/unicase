/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.operations.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.emfstore.server.model.versioning.operations.DiagramLayoutOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Diagram Layout Operation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DiagramLayoutOperationImpl extends AttributeOperationImpl implements DiagramLayoutOperation {
	@Override
	public String getDescription() {
		return "Changed Diagram Layout.";
	}

	@Override
	public String getName() {
		return "Changed Diagram Layout";
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramLayoutOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.DIAGRAM_LAYOUT_OPERATION;
	}

} // DiagramLayoutOperationImpl
