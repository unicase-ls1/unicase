/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.diagram.impl;

import org.eclipse.emf.ecore.EClass;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.UseCaseDiagram;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Use Case Diagram</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class UseCaseDiagramImpl extends MEDiagramImpl implements UseCaseDiagram {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected UseCaseDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramPackage.Literals.USE_CASE_DIAGRAM;
	}

	@Override
	public String getType() {
		return "UnicaseUseCase";
	}

} // UseCaseDiagramImpl