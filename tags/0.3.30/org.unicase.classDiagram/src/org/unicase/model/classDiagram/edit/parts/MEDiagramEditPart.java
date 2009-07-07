/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classDiagram.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.classDiagram.edit.policies.MEDiagramShowElementsEditPolicy;

/**
 * @generated
 * @extends org.unicase.ui.common.diagram.MEDiagramEditPart
 * @implements org.unicase.ui.common.diagram.MEDiagramEditPart
 * @ilovegmf public class MEDiagramEditPart extends org.unicase.ui.common.diagram.MEDiagramEditPart {
 */
public class MEDiagramEditPart extends org.unicase.ui.common.diagram.edit.parts.MEDiagramEditPart {

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "Model"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 88;

	/**
	 * @generated
	 */
	public MEDiagramEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SHOW_ELEMENTS_ROLE,
				new MEDiagramShowElementsEditPolicy());
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new org.unicase.model.classDiagram.edit.policies.MEDiagramItemSemanticEditPolicy());
		installEditPolicy(
				EditPolicyRoles.CANONICAL_ROLE,
				new org.unicase.model.classDiagram.edit.policies.MEDiagramCanonicalEditPolicy());
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}

}
