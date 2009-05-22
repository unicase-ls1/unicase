/** 
* <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stateDiagram.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 * @extends org.unicase.ui.common.diagram.MEDiagramEditPart
 * @implements org.unicase.ui.common.diagram.MEDiagramEditPart public class MEDiagramEditPart extends
 *             org.unicase.ui.common.diagram.MEDiagramEditPart {
 */
public class MEDiagramEditPart extends DiagramEditPart implements org.unicase.ui.common.diagram.MEDiagramEditPart, public, class, MEDiagramEditPart, extends {

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "State"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 55;

	/**
	 * @generated
	 */
	public MEDiagramEditPart(View view) {
    super(view);
  }

	/**
	 * @generated
	 */
	@Override
	protected void createDefaultEditPolicies() {
      super.createDefaultEditPolicies();
    installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new org.unicase.ui.stateDiagram.edit.policies.MEDiagramItemSemanticEditPolicy());
      installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new org.unicase.ui.stateDiagram.edit.policies.MEDiagramCanonicalEditPolicy());
            // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
  }

}
