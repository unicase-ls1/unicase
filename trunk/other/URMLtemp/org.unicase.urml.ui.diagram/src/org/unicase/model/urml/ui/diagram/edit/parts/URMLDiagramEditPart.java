package org.unicase.model.urml.ui.diagram.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.urml.ui.diagram.edit.policies.URMLDiagramCanonicalEditPolicy;
import org.unicase.model.urml.ui.diagram.edit.policies.URMLDiagramItemSemanticEditPolicy;
import org.unicase.ui.unicasecommon.diagram.edit.parts.MEDiagramEditPart;

/**
 * @generated
 */
public class URMLDiagramEditPart extends MEDiagramEditPart {

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "Urml"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1000;

	/**
	 * @generated
	 */
	public URMLDiagramEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new URMLDiagramItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new URMLDiagramCanonicalEditPolicy());
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}

}
