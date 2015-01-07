/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.diagram.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.gmf.runtime.notation.impl.RelativeBendpointsImpl;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.MERelativeBendpoints;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>ME Relative Bendpoints</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class MERelativeBendpointsImpl extends RelativeBendpointsImpl implements
		MERelativeBendpoints {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MERelativeBendpointsImpl() {
		super();
	}

	@SuppressWarnings("rawtypes")
	public void setPoints(List points) {
		List<MERelativeBendpoint> actualPoints = new ArrayList<MERelativeBendpoint>(
				points.size());
		for (Object point : points) {
			if (point instanceof MERelativeBendpoint) {
				MERelativeBendpoint mePoint = (MERelativeBendpoint) point;
				actualPoints.add(mePoint);
			} else if (point instanceof RelativeBendpoint) {
				RelativeBendpoint relativePoint = (RelativeBendpoint) point;
				MERelativeBendpoint mePoint = copyPoint(relativePoint);
				actualPoints.add(mePoint);
			}
		}
		super.setPoints(actualPoints);
	}

	private MERelativeBendpoint copyPoint(RelativeBendpoint relativePoint) {
		MERelativeBendpoint copy = new MERelativeBendpoint(
				relativePoint.getSourceX(), relativePoint.getSourceY(),
				relativePoint.getTargetX(), relativePoint.getTargetY());

		return copy;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramPackage.Literals.ME_RELATIVE_BENDPOINTS;
	}

} // MERelativeBendpointsImpl
