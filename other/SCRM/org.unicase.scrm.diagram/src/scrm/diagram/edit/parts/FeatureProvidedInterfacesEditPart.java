package scrm.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;

import scrm.diagram.edit.policies.FeatureProvidedInterfacesItemSemanticEditPolicy;

/**
 * @generated
 */
public class FeatureProvidedInterfacesEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4024;

	/**
	 * @generated
	 */
	public FeatureProvidedInterfacesEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new FeatureProvidedInterfacesItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel13EditPart) {
			((WrappingLabel13EditPart) childEditPart).setLabel(getPrimaryShape()
				.getFigureFeature_ProvidedInterfacesLabel());
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
		if (childEditPart instanceof WrappingLabel13EditPart) {
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
		return new Feature_ProvidedInterfacesFigure();
	}

	/**
	 * @generated
	 */
	public Feature_ProvidedInterfacesFigure getPrimaryShape() {
		return (Feature_ProvidedInterfacesFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Feature_ProvidedInterfacesFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureFeature_ProvidedInterfacesLabel;

		/**
		 * @generated
		 */
		public Feature_ProvidedInterfacesFigure() {
			this.setLineWidth(1);

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureFeature_ProvidedInterfacesLabel = new WrappingLabel();
			fFigureFeature_ProvidedInterfacesLabel.setText("provides");

			this.add(fFigureFeature_ProvidedInterfacesLabel);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureFeature_ProvidedInterfacesLabel() {
			return fFigureFeature_ProvidedInterfacesLabel;
		}

	}

}
