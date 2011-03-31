/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.impl;

import java.io.Serializable;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.emfstore.common.model.impl.IdentifiableElementImpl;
import org.eclipse.emf.emfstore.server.model.FileIdentifier;
import org.eclipse.emf.emfstore.server.model.ModelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>File Identifier</b></em>'.
 * 
 * @implements Serializable <!-- end-user-doc -->
 *             <p>
 *             </p>
 * 
 * @generated
 */
public class FileIdentifierImpl extends IdentifiableElementImpl implements FileIdentifier, Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected FileIdentifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.FILE_IDENTIFIER;
	}

} // FileIdentifierImpl
