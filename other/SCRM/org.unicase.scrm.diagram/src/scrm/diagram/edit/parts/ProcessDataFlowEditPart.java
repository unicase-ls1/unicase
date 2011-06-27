package scrm.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;

import scrm.diagram.edit.policies.ProcessDataFlowItemSemanticEditPolicy;

/**
 * @generated
 */
public class ProcessDataFlowEditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4045;

	/**
	 * @generated
	 */
	public ProcessDataFlowEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ProcessDataFlowItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel20EditPart) {
			((WrappingLabel20EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureProcess_DataFlowLabel());
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
		if (childEditPart instanceof WrappingLabel20EditPart) {
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
		return new Process_DataFlowFigure();
	}

	/**
	 * @generated
	 */
	public Process_DataFlowFigure getPrimaryShape() {
		return (Process_DataFlowFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Process_DataFlowFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureProcess_DataFlowLabel;

		/**
		 * @generated
		 */
		public Process_DataFlowFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureProcess_DataFlowLabel = new WrappingLabel();
			fFigureProcess_DataFlowLabel.setText("specifies");

			this.add(fFigureProcess_DataFlowLabel);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureProcess_DataFlowLabel() {
			return fFigureProcess_DataFlowLabel;
		}

	}

}
