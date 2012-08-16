package scrm.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;

import scrm.diagram.edit.policies.InterfaceDetailsOfProvidingFunctionsAndPropertiesItemSemanticEditPolicy;

/**
 * @generated
 */
public class InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart extends
		ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4070;

	/**
	 * @generated
	 */
	public InterfaceDetailsOfProvidingFunctionsAndPropertiesEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new InterfaceDetailsOfProvidingFunctionsAndPropertiesItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel20EditPart) {
			((WrappingLabel20EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureInterface_DetailsOfProvidingFunctionsAndPropertiesLabel());
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
		return new Interface_DetailsOfProvidingFunctionsAndPropertiesFigure();
	}

	/**
	 * @generated
	 */
	public Interface_DetailsOfProvidingFunctionsAndPropertiesFigure getPrimaryShape() {
		return (Interface_DetailsOfProvidingFunctionsAndPropertiesFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class Interface_DetailsOfProvidingFunctionsAndPropertiesFigure
			extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureInterface_DetailsOfProvidingFunctionsAndPropertiesLabel;

		/**
		 * @generated
		 */
		public Interface_DetailsOfProvidingFunctionsAndPropertiesFigure() {

			createContents();
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureInterface_DetailsOfProvidingFunctionsAndPropertiesLabel = new WrappingLabel();
			fFigureInterface_DetailsOfProvidingFunctionsAndPropertiesLabel
					.setText("providing details");

			this.add(fFigureInterface_DetailsOfProvidingFunctionsAndPropertiesLabel);

		}

		/**
		 * @generated
		 */
		private RotatableDecoration createTargetDecoration() {
			PolylineDecoration df = new PolylineDecoration();
			return df;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureInterface_DetailsOfProvidingFunctionsAndPropertiesLabel() {
			return fFigureInterface_DetailsOfProvidingFunctionsAndPropertiesLabel;
		}

	}

}
