package scrm.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;

import scrm.diagram.edit.policies.ScientificProblemSolvingMethodItemSemanticEditPolicy;

/**
 * @generated
 */
public class ScientificProblemSolvingMethodEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4007;

	/**
	 * @generated
	 */
	public ScientificProblemSolvingMethodEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ScientificProblemSolvingMethodItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel3EditPart) {
			((WrappingLabel3EditPart) childEditPart).setLabel(getPrimaryShape()
				.getFigureScientificProblem_SolvingMethodLabel());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel3EditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
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
		return new ScientificProblem_SolvingMethodFigure();
	}

	/**
	 * @generated
	 */
	public ScientificProblem_SolvingMethodFigure getPrimaryShape() {
		return (ScientificProblem_SolvingMethodFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class ScientificProblem_SolvingMethodFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureScientificProblem_SolvingMethodLabel;

		/**
		 * @generated
		 */
		public ScientificProblem_SolvingMethodFigure() {
			this.setLineWidth(1);

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureScientificProblem_SolvingMethodLabel = new WrappingLabel();
			fFigureScientificProblem_SolvingMethodLabel.setText("solves");

			this.add(fFigureScientificProblem_SolvingMethodLabel);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureScientificProblem_SolvingMethodLabel() {
			return fFigureScientificProblem_SolvingMethodLabel;
		}

	}

}
