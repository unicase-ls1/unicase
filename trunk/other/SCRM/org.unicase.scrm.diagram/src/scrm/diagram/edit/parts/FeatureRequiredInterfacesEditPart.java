package scrm.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;

import scrm.diagram.edit.policies.FeatureRequiredInterfacesItemSemanticEditPolicy;

/**
 * @generated
 */
public class FeatureRequiredInterfacesEditPart extends ConnectionNodeEditPart
		implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4023;

	/**
	 * @generated
	 */
	public FeatureRequiredInterfacesEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new FeatureRequiredInterfacesItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel12EditPart) {
			((WrappingLabel12EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureFeature_RequiredInterfacesLabel());
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
		if (childEditPart instanceof WrappingLabel12EditPart) {
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
		return new Feature_RequiredInterfacesFigure();
	}

	/**
	 * @generated
	 */
	public Feature_RequiredInterfacesFigure getPrimaryShape() {
		return (Feature_RequiredInterfacesFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Feature_RequiredInterfacesFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureFeature_RequiredInterfacesLabel;

		/**
		 * @generated
		 */
		public Feature_RequiredInterfacesFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureFeature_RequiredInterfacesLabel = new WrappingLabel();
			fFigureFeature_RequiredInterfacesLabel.setText("requires");

			this.add(fFigureFeature_RequiredInterfacesLabel);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFeature_RequiredInterfacesLabel() {
			return fFigureFeature_RequiredInterfacesLabel;
		}

	}

}
