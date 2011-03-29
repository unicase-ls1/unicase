package scrm.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;

import scrm.diagram.edit.policies.RequirementDefiningDataItemSemanticEditPolicy;

/**
 * @generated
 */
public class RequirementDefiningDataEditPart extends ConnectionNodeEditPart
		implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4038;

	/**
	 * @generated
	 */
	public RequirementDefiningDataEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new RequirementDefiningDataItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel21EditPart) {
			((WrappingLabel21EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureRequirements_DefiningDataLabel());
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
		if (childEditPart instanceof WrappingLabel21EditPart) {
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
		return new Requirements_DefiningDataFigure();
	}

	/**
	 * @generated
	 */
	public Requirements_DefiningDataFigure getPrimaryShape() {
		return (Requirements_DefiningDataFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Requirements_DefiningDataFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureRequirements_DefiningDataLabel;

		/**
		 * @generated
		 */
		public Requirements_DefiningDataFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureRequirements_DefiningDataLabel = new WrappingLabel();
			fFigureRequirements_DefiningDataLabel.setText("defines");

			this.add(fFigureRequirements_DefiningDataLabel);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureRequirements_DefiningDataLabel() {
			return fFigureRequirements_DefiningDataLabel;
		}

	}

}
