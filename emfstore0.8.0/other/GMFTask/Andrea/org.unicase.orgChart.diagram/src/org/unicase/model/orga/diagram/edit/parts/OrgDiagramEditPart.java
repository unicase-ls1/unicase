package org.unicase.model.orga.diagram.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.orga.diagram.edit.policies.OrgDiagramCanonicalEditPolicy;
import org.unicase.model.orga.diagram.edit.policies.OrgDiagramItemSemanticEditPolicy;
import org.unicase.ui.unicasecommon.diagram.edit.parts.MEDiagramEditPart;

/**
 * @generated
 */
public class OrgDiagramEditPart extends MEDiagramEditPart {

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "Orga"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1000;

	/**
	 * @generated
	 */
	public OrgDiagramEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new OrgDiagramItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new OrgDiagramCanonicalEditPolicy());
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}

}
