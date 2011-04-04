package scrm.diagram.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

import scrm.diagram.opener.MEEditorOpenerPolicy;

public abstract class SCRMModelElementLabelEditPart extends CompartmentEditPart{

	public SCRMModelElementLabelEditPart(View view) {
		super(view);
	}
	
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new MEEditorOpenerPolicy());
	}

}
