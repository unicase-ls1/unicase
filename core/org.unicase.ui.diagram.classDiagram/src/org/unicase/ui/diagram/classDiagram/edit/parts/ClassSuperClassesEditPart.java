/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.classDiagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ClassSuperClassesEditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4007;

	/**
	 * @generated
	 */
	public ClassSuperClassesEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new org.unicase.ui.diagram.classDiagram.edit.policies.ClassSuperClassesItemSemanticEditPolicy());
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */

	@Override
	protected Connection createConnectionFigure() {
		return new GeneralizationFigure();
	}

	/**
	 * @generated
	 */
	public GeneralizationFigure getPrimaryShape() {
		return (GeneralizationFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class GeneralizationFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public GeneralizationFigure() {

			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private RotatableDecoration createTargetDecoration() {
			org.unicase.ui.diagram.classDiagram.unicase.GeneralizationDecoration df = new org.unicase.ui.diagram.classDiagram.unicase.GeneralizationDecoration();

			return df;
		}

	}

}
