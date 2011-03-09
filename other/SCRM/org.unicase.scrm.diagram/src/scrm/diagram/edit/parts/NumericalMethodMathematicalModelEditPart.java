package scrm.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;

import scrm.diagram.edit.policies.NumericalMethodMathematicalModelItemSemanticEditPolicy;

/**
 * @generated
 */
public class NumericalMethodMathematicalModelEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4003;

	/**
	 * @generated
	 */
	public NumericalMethodMathematicalModelEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new NumericalMethodMathematicalModelItemSemanticEditPolicy());
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */

	protected Connection createConnectionFigure() {
		return new ConnectionDescriptor();
	}

	/**
	 * @generated
	 */
	public ConnectionDescriptor getPrimaryShape() {
		return (ConnectionDescriptor) getFigure();
	}

	/**
	 * @generated
	 */
	public class ConnectionDescriptor extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public ConnectionDescriptor() {
			this.setLineWidth(2);

		}

	}

}
