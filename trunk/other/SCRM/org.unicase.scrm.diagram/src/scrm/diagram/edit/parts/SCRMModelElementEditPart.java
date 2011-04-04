package scrm.diagram.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

import scrm.diagram.opener.MEEditorOpenerPolicy;

public abstract class SCRMModelElementEditPart extends ShapeNodeEditPart {
	
	public SCRMModelElementEditPart(View view) {
		super(view);
	}
	
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new MEEditorOpenerPolicy());
	}

}
