package org.unicase.ui.urmlDiagram.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class MEDiagramEditPart extends
		org.unicase.ui.common.diagram.edit.parts.MEDiagramEditPart {

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "Model"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 66;

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
				new org.unicase.ui.urmlDiagram.edit.policies.MEDiagramItemSemanticEditPolicy());
		installEditPolicy(
				EditPolicyRoles.CANONICAL_ROLE,
				new org.unicase.ui.urmlDiagram.edit.policies.MEDiagramCanonicalEditPolicy());
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}

}
