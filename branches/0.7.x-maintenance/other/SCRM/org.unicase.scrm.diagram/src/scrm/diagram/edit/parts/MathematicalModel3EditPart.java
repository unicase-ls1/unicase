package scrm.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;

import scrm.diagram.edit.policies.MathematicalModel3ItemSemanticEditPolicy;

/**
 * @generated
 */
public class MathematicalModel3EditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4010;

	/**
	 * @generated
	 */
	public MathematicalModel3EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new MathematicalModel3ItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel6EditPart) {
			((WrappingLabel6EditPart) childEditPart).setLabel(getPrimaryShape()
				.getFigureMathematicalModel_SubMathematicalModelsLabel());
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
		if (childEditPart instanceof WrappingLabel6EditPart) {
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
		return new MathematicalModel_SubMathematicalModelsFigure();
	}

	/**
	 * @generated
	 */
	public MathematicalModel_SubMathematicalModelsFigure getPrimaryShape() {
		return (MathematicalModel_SubMathematicalModelsFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class MathematicalModel_SubMathematicalModelsFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureMathematicalModel_SubMathematicalModelsLabel;

		/**
		 * @generated
		 */
		public MathematicalModel_SubMathematicalModelsFigure() {
			this.setLineWidth(1);

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureMathematicalModel_SubMathematicalModelsLabel = new WrappingLabel();
			fFigureMathematicalModel_SubMathematicalModelsLabel.setText("extends");

			this.add(fFigureMathematicalModel_SubMathematicalModelsLabel);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureMathematicalModel_SubMathematicalModelsLabel() {
			return fFigureMathematicalModel_SubMathematicalModelsLabel;
		}

	}

}
