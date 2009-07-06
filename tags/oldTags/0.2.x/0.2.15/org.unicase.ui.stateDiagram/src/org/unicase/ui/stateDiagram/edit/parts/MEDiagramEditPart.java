package org.unicase.ui.stateDiagram.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 * @extends org.unicase.ui.common.diagram.MEDiagramEditPart
 * @implements org.unicase.ui.common.diagram.MEDiagramEditPart
 */
public class MEDiagramEditPart extends org.unicase.ui.common.diagram.MEDiagramEditPart  {

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "Model"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1000;

	/**
	 * @generated
	 */
	public MEDiagramEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new org.unicase.ui.stateDiagram.edit.policies.MEDiagramItemSemanticEditPolicy());
		installEditPolicy(
				EditPolicyRoles.CANONICAL_ROLE,
				new org.unicase.ui.stateDiagram.edit.policies.MEDiagramCanonicalEditPolicy());
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}

}
