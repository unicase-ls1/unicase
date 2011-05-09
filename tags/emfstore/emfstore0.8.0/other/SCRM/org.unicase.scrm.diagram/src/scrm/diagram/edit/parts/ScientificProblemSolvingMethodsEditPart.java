package scrm.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;

import scrm.diagram.edit.policies.ScientificProblemSolvingMethodsItemSemanticEditPolicy;

/**
 * @generated
 */
public class ScientificProblemSolvingMethodsEditPart extends
		ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4041;

	/**
	 * @generated
	 */
	public ScientificProblemSolvingMethodsEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ScientificProblemSolvingMethodsItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel2EditPart) {
			((WrappingLabel2EditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureScientificProblem_SolvingMethodsLabel());
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
		super.addChildVisual(childEditPart, index);
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel2EditPart) {
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
		return new ScientificProblem_SolvingMethodsFigure();
	}

	/**
	 * @generated
	 */
	public ScientificProblem_SolvingMethodsFigure getPrimaryShape() {
		return (ScientificProblem_SolvingMethodsFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class ScientificProblem_SolvingMethodsFigure extends
			PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureScientificProblem_SolvingMethodsLabel;

		/**
		 * @generated
		 */
		public ScientificProblem_SolvingMethodsFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureScientificProblem_SolvingMethodsLabel = new WrappingLabel();
			fFigureScientificProblem_SolvingMethodsLabel.setText("solves");

			this.add(fFigureScientificProblem_SolvingMethodsLabel);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureScientificProblem_SolvingMethodsLabel() {
			return fFigureScientificProblem_SolvingMethodsLabel;
		}

	}

}
