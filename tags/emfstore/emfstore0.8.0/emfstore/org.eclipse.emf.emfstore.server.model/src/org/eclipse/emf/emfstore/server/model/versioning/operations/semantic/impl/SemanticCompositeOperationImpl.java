/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.emfstore.server.model.versioning.operations.impl.CompositeOperationImpl;
import org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.SemanticCompositeOperation;
import org.eclipse.emf.emfstore.server.model.versioning.operations.semantic.SemanticPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Composite Operation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class SemanticCompositeOperationImpl extends CompositeOperationImpl implements
	SemanticCompositeOperation {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SemanticCompositeOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SemanticPackage.Literals.SEMANTIC_COMPOSITE_OPERATION;
	}

} // SemanticCompositeOperationImpl
