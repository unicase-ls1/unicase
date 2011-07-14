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
		if (childEditPart instanceof WrappingLabel19EditPart) {
			((WrappingLabel19EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureRequirement_DefiningDataLabel());
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
		if (childEditPart instanceof WrappingLabel19EditPart) {
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
		return new Requirement_DefiningDataFigure();
	}

	/**
	 * @generated
	 */
	public Requirement_DefiningDataFigure getPrimaryShape() {
		return (Requirement_DefiningDataFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Requirement_DefiningDataFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureRequirement_DefiningDataLabel;

		/**
		 * @generated
		 */
		public Requirement_DefiningDataFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureRequirement_DefiningDataLabel = new WrappingLabel();
			fFigureRequirement_DefiningDataLabel.setText("defines");

			this.add(fFigureRequirement_DefiningDataLabel);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureRequirement_DefiningDataLabel() {
			return fFigureRequirement_DefiningDataLabel;
		}

	}

}
