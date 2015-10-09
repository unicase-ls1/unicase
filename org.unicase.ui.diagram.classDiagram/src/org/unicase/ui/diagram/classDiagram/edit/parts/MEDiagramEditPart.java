/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.classDiagram.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.ui.diagram.classDiagram.edit.policies.MEDiagramShowElementsEditPolicy;

/**
 * @generated
 */
public class MEDiagramEditPart extends
		org.unicase.ui.unicasecommon.diagram.edit.parts.MEDiagramEditPart {

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "Class"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 99;

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
		installEditPolicy(EditPolicyRoles.SHOW_ELEMENTS_ROLE, new MEDiagramShowElementsEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
			new org.unicase.ui.diagram.classDiagram.edit.policies.MEDiagramItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
			new org.unicase.ui.diagram.classDiagram.edit.policies.MEDiagramCanonicalEditPolicy());
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}

}
