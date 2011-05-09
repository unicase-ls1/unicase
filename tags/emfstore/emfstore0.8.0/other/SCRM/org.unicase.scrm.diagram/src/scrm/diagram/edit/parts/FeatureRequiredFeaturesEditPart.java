package scrm.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;

import scrm.diagram.edit.policies.FeatureRequiredFeaturesItemSemanticEditPolicy;

/**
 * @generated
 */
public class FeatureRequiredFeaturesEditPart extends ConnectionNodeEditPart
		implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4030;

	/**
	 * @generated
	 */
	public FeatureRequiredFeaturesEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new FeatureRequiredFeaturesItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel16EditPart) {
			((WrappingLabel16EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureFeature_RequiredFeaturesLabel());
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
		return new Feature_RequiredFeaturesFigure();
	}

	/**
	 * @generated
	 */
	public Feature_RequiredFeaturesFigure getPrimaryShape() {
		return (Feature_RequiredFeaturesFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Feature_RequiredFeaturesFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureFeature_RequiredFeaturesLabel;

		/**
		 * @generated
		 */
		public Feature_RequiredFeaturesFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureFeature_RequiredFeaturesLabel = new WrappingLabel();
			fFigureFeature_RequiredFeaturesLabel.setText("requires");

			this.add(fFigureFeature_RequiredFeaturesLabel);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFeature_RequiredFeaturesLabel() {
			return fFigureFeature_RequiredFeaturesLabel;
		}

	}

}
