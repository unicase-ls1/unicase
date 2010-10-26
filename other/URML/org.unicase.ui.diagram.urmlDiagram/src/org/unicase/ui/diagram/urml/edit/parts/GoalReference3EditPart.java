package org.unicase.ui.diagram.urml.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.ui.diagram.urml.edit.policies.GoalReference3ItemSemanticEditPolicy;
import org.unicase.ui.diagram.urml.own.figures.ShortenedPolylineConnection;

/**
 * @generated
 */
public class GoalReference3EditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4024;

	/**
	 * @generated
	 */
	public GoalReference3EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new GoalReference3ItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof GoalReferenceWeight2EditPart) {
			((GoalReferenceWeight2EditPart) childEditPart).setLabel(getPrimaryShape()
				.getFigureGoalInfluenceGoalsFigure_weight());
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
		if (childEditPart instanceof GoalReferenceWeight2EditPart) {
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
		return new GoalInfluenceGoalsFigure();
	}

	/**
	 * @generated
	 */
	public GoalInfluenceGoalsFigure getPrimaryShape() {
		return (GoalInfluenceGoalsFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class GoalInfluenceGoalsFigure extends ShortenedPolylineConnection {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureGoalInfluenceGoalsFigure_weight;

		/**
		 * @generated
		 */
		public GoalInfluenceGoalsFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureGoalInfluenceGoalsFigure_weight = new WrappingLabel();
			fFigureGoalInfluenceGoalsFigure_weight.setText("null");

			this.add(fFigureGoalInfluenceGoalsFigure_weight);

		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		/**
		 * @generated
		 */
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureGoalInfluenceGoalsFigure_weight() {
			return fFigureGoalInfluenceGoalsFigure_weight;
		}

	}

}
