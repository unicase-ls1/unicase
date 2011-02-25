/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.diagram.impl;

import org.eclipse.emf.ecore.EClass;
import org.unicase.model.diagram.ActivityDiagram;
import org.unicase.model.diagram.DiagramPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Activity Diagram</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class ActivityDiagramImpl extends MEDiagramImpl implements ActivityDiagram {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivityDiagramImpl() {
		super();
	}

	public String getType() {
		return "Activity";
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramPackage.Literals.ACTIVITY_DIAGRAM;
	}

} // ActivityDiagramImpl
