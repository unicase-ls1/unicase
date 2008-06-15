package org.unicase.model.diagram.edit.parts;

import java.util.List;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.diagram.edit.policies.MEDiagramCanonicalEditPolicy;
import org.unicase.model.diagram.edit.policies.MEDiagramItemSemanticEditPolicy;

/**
 * @generated
 */
public class MEDiagramEditPart extends DiagramEditPart {

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "Model"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 79;

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
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new MEDiagramItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new MEDiagramCanonicalEditPolicy());
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.
		// EditPolicyRoles.POPUPBAR_ROLE);
	}

	@Override
	protected List getModelChildren() {
		// Object object = getModel();
		// if (object instanceof Diagram) {
		// Diagram diagram = (Diagram) object;
		// object = diagram.getElement();
		// if (object instanceof MEDiagram) {
		// MEDiagram meDiagram = (MEDiagram) object;
		// return meDiagram.getElements();
		// }
		// }

		return super.getModelChildren();
	}

}
