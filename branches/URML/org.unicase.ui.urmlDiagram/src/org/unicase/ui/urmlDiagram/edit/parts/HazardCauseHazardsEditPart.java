package org.unicase.ui.urmlDiagram.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class HazardCauseHazardsEditPart extends ConnectionNodeEditPart
		implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4016;

	/**
	 * @generated
	 */
	public HazardCauseHazardsEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new org.unicase.ui.urmlDiagram.edit.policies.HazardCauseHazardsItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
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
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */

	protected Connection createConnectionFigure() {
		return new CauseLinkFigure();
	}

	/**
	 * @generated
	 */
	public CauseLinkFigure getPrimaryShape() {
		return (CauseLinkFigure) getFigure();
	}

	/**
	 * @generated NOT
	 */
	private static final PointList RHOMB = new PointList(new int[] { //
			//
					-1, 1, //
					0, 0, //
					-1, -1, //
					-2, 0, //
					-1, 1, //
			});

	/**
	 * @generated
	 */
	public class CauseLinkFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public CauseLinkFigure() {

			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated NOT
		 */
		private org.unicase.ui.urmlDiagram.unicase.ComposablePolygonDecoration createTargetDecoration() {
			org.unicase.ui.urmlDiagram.unicase.ComposablePolygonDecoration mySharedAggrecationDecoration = new org.unicase.ui.urmlDiagram.unicase.ComposablePolygonDecoration();
			mySharedAggrecationDecoration.setTemplate(RHOMB.getCopy());
			mySharedAggrecationDecoration.setBoundPoint(new Point(-2, 0));
			mySharedAggrecationDecoration.setFill(true);
			mySharedAggrecationDecoration
					.setBackgroundColor(ColorConstants.white);
			return mySharedAggrecationDecoration;
		}

	}

}
