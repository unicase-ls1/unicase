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

import scrm.diagram.edit.policies.DataDefinitionProvidedInterfaceItemSemanticEditPolicy;

/**
 * @generated
 */
public class DataDefinitionProvidedInterfaceEditPart extends
		ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4076;

	/**
	 * @generated
	 */
	public DataDefinitionProvidedInterfaceEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new DataDefinitionProvidedInterfaceItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel29EditPart) {
			((WrappingLabel29EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureDataDefinition_ProvidedInterfaceLabel());
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
		if (childEditPart instanceof WrappingLabel29EditPart) {
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
		return new DataDefinition_ProvidedInterfaceFigure();
	}

	/**
	 * @generated
	 */
	public DataDefinition_ProvidedInterfaceFigure getPrimaryShape() {
		return (DataDefinition_ProvidedInterfaceFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class DataDefinition_ProvidedInterfaceFigure extends
			PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureDataDefinition_ProvidedInterfaceLabel;

		/**
		 * @generated
		 */
		public DataDefinition_ProvidedInterfaceFigure() {

			createContents();
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureDataDefinition_ProvidedInterfaceLabel = new WrappingLabel();
			fFigureDataDefinition_ProvidedInterfaceLabel.setText("provides");

			this.add(fFigureDataDefinition_ProvidedInterfaceLabel);

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
		public WrappingLabel getFigureDataDefinition_ProvidedInterfaceLabel() {
			return fFigureDataDefinition_ProvidedInterfaceLabel;
		}

	}

}
