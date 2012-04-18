/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.diagram.impl;

import org.eclipse.emf.ecore.EClass;
import org.unicase.model.diagram.ComponentDiagram;
import org.unicase.model.diagram.DiagramPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Component Diagram</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class ComponentDiagramImpl extends MEDiagramImpl implements ComponentDiagram {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ComponentDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramPackage.Literals.COMPONENT_DIAGRAM;
	}

	@Override
	public String getType() {
		return "Component";
	}

} // ComponentDiagramImpl
