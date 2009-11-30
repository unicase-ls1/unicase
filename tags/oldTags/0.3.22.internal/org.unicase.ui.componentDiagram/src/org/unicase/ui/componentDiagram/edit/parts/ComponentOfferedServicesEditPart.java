package org.unicase.ui.componentDiagram.edit.parts;

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ComponentOfferedServicesEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3001;

	/**
	 * @generated
	 */
	public ComponentOfferedServicesEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
			new org.unicase.ui.componentDiagram.edit.policies.ComponentOfferedServicesItemSemanticEditPolicy());
	}

	/**
	 * Creates figure for this edit part. Body of this method does not depend on settings in generation model so you may
	 * safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected Connection createConnectionFigure() {
		return new ProvidedInterfaceConnectionFigure();
	}

	/**
	 * @generated
	 */
	public ProvidedInterfaceConnectionFigure getPrimaryShape() {
		return (ProvidedInterfaceConnectionFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class ProvidedInterfaceConnectionFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public ProvidedInterfaceConnectionFigure() {
			this.setForegroundColor(ColorConstants.black);

		}

	}

	protected void handleNotificationEvent(Notification event) {

		List editPolicies = CanonicalEditPolicy.getRegisteredEditPolicies(((View) getModel()).getElement());
		for (Iterator it = editPolicies.iterator(); it.hasNext();) {
			CanonicalEditPolicy nextEditPolicy = (CanonicalEditPolicy) it.next();
			nextEditPolicy.refresh();
		}

		super.handleNotificationEvent(event);
	}

}
