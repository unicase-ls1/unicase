package scrm.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;

import scrm.diagram.edit.policies.FeatureDetailedRequirementsItemSemanticEditPolicy;

/**
 * @generated
 */
public class FeatureDetailedRequirementsEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4027;

	/**
	 * @generated
	 */
	public FeatureDetailedRequirementsEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new FeatureDetailedRequirementsItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel16EditPart) {
			((WrappingLabel16EditPart) childEditPart).setLabel(getPrimaryShape()
				.getFigureFeature_DetailedRequirementsLabel());
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
		if (childEditPart instanceof WrappingLabel16EditPart) {
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
		return new Feature_DetailedRequirementsFigure();
	}

	/**
	 * @generated
	 */
	public Feature_DetailedRequirementsFigure getPrimaryShape() {
		return (Feature_DetailedRequirementsFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Feature_DetailedRequirementsFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureFeature_DetailedRequirementsLabel;

		/**
		 * @generated
		 */
		public Feature_DetailedRequirementsFigure() {
			this.setLineWidth(1);

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureFeature_DetailedRequirementsLabel = new WrappingLabel();
			fFigureFeature_DetailedRequirementsLabel.setText("details");

			this.add(fFigureFeature_DetailedRequirementsLabel);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFeature_DetailedRequirementsLabel() {
			return fFigureFeature_DetailedRequirementsLabel;
		}

	}

}
