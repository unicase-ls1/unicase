package scrm.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;

import scrm.diagram.edit.policies.ScientificProblemInfluencedFeatureItemSemanticEditPolicy;

/**
 * @generated
 */
public class ScientificProblemInfluencedFeatureEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4008;

	/**
	 * @generated
	 */
	public ScientificProblemInfluencedFeatureEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ScientificProblemInfluencedFeatureItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel4EditPart) {
			((WrappingLabel4EditPart) childEditPart).setLabel(getPrimaryShape()
				.getFigureScientificProblem_InfluencedFeatureLabel());
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
		if (childEditPart instanceof WrappingLabel4EditPart) {
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
		return new ScientificProblem_InfluencedFeatureFigure();
	}

	/**
	 * @generated
	 */
	public ScientificProblem_InfluencedFeatureFigure getPrimaryShape() {
		return (ScientificProblem_InfluencedFeatureFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class ScientificProblem_InfluencedFeatureFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureScientificProblem_InfluencedFeatureLabel;

		/**
		 * @generated
		 */
		public ScientificProblem_InfluencedFeatureFigure() {
			this.setLineWidth(1);

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureScientificProblem_InfluencedFeatureLabel = new WrappingLabel();
			fFigureScientificProblem_InfluencedFeatureLabel.setText("influences");

			this.add(fFigureScientificProblem_InfluencedFeatureLabel);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureScientificProblem_InfluencedFeatureLabel() {
			return fFigureScientificProblem_InfluencedFeatureLabel;
		}

	}

}
