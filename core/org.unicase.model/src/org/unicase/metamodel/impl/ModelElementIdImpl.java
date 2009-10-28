/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.unicase.metamodel.ModelElementId;
import org.unicase.model.ModelPackage;
import org.unicase.model.impl.UniqueIdentifierImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Element Id</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class ModelElementIdImpl extends UniqueIdentifierImpl implements ModelElementId {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementIdImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.MODEL_ELEMENT_ID;
	}

} // ModelElementIdImpl
