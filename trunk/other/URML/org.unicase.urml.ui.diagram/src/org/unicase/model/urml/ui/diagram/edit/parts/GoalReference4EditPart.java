package org.unicase.model.urml.ui.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.urml.ui.diagram.edit.policies.GoalReference4ItemSemanticEditPolicy;
import org.unicase.ui.diagrams.urml.figures.ShortenedPolylineConnection;

/**
 * @generated
 */
public class GoalReference4EditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4025;

	/**
	 * @generated
	 */
	public GoalReference4EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new GoalReference4ItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof GoalReferenceWeight3EditPart) {
			((GoalReferenceWeight3EditPart) childEditPart).setLabel(getPrimaryShape()
				.getFigureGoalInfluenceGoalsFigure_name());
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
		if (childEditPart instanceof GoalReferenceWeight3EditPart) {
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
	 * Creates figure for this edit part. Body of this method does not depend on settings in generation model so you may
	 * safely remove <i>generated</i> tag and modify it.
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
		private WrappingLabel fFigureGoalInfluenceGoalsFigure_name;

		/**
		 * @generated
		 */
		public GoalInfluenceGoalsFigure() {

			FlowLayout layoutThis = new FlowLayout();
			layoutThis.setStretchMinorAxis(false);
			layoutThis.setMinorAlignment(FlowLayout.ALIGN_LEFTTOP);

			layoutThis.setMajorAlignment(FlowLayout.ALIGN_LEFTTOP);
			layoutThis.setMajorSpacing(5);
			layoutThis.setMinorSpacing(5);
			layoutThis.setHorizontal(true);

			this.setLayoutManager(layoutThis);

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureGoalInfluenceGoalsFigure_name = new WrappingLabel();
			fFigureGoalInfluenceGoalsFigure_name.setText("null");

			this.add(fFigureGoalInfluenceGoalsFigure_name);

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
		public WrappingLabel getFigureGoalInfluenceGoalsFigure_name() {
			return fFigureGoalInfluenceGoalsFigure_name;
		}

	}

}
