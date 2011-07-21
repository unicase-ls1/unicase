package scrm.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableCompartmentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.notation.View;

import scrm.diagram.edit.policies.DataProcessSpaceDataProcessSpaceCompartmentCanonicalEditPolicy;
import scrm.diagram.edit.policies.DataProcessSpaceDataProcessSpaceCompartmentItemSemanticEditPolicy;
import scrm.diagram.edit.policies.OpenSCRMSpaceEditPolicy;
import scrm.diagram.edit.policies.SCRMSpaceChildCreationEditPolicy;
import scrm.diagram.edit.policies.SCRMSpaceDragDropEditPolicy;
import scrm.diagram.part.Messages;

/**
 * @generated
 */
public class DataProcessSpaceDataProcessSpaceCompartmentEditPart extends
		ShapeCompartmentEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 7005;

	/**
	 * @generated
	 */
	public DataProcessSpaceDataProcessSpaceCompartmentEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	public String getCompartmentName() {
		return Messages.DataProcessSpaceDataProcessSpaceCompartmentEditPart_title;
	}

	/**
	 * @generated NOT: removed border
	 */
	public IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure) super
				.createFigure();
		result.setTitleVisibility(false);
		result.setBorder(null);
		return result;
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
				new ResizableCompartmentEditPolicy());
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new DataProcessSpaceDataProcessSpaceCompartmentItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new SCRMSpaceChildCreationEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new SCRMSpaceDragDropEditPolicy());
		installEditPolicy(
				EditPolicyRoles.CANONICAL_ROLE,
				new DataProcessSpaceDataProcessSpaceCompartmentCanonicalEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE,
				new OpenSCRMSpaceEditPolicy());
	}

	/**
	 * @generated
	 */
	protected void setRatio(Double ratio) {
		if (getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
			super.setRatio(ratio);
		}
	}

}
