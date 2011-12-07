package scrm.diagram.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.utilities.ActionHelper;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

/**
 * Policy to enable double-click behavior for SCRMDiagram-EditParts other
 * than any Compartment- or Connection-EditPart. Upon double-clicking,
 * the MEEditor for the selected EObject is opened.
 * 
 * @author mharut
 * @generated NOT
 */
public class OpenMEEditorPolicy extends OpenEditPolicy {

	@Override
	protected Command getOpenCommand(Request request) {

		EditPart targetEditPart = getTargetEditPart(request);
		final EObject element = ((View) targetEditPart.getModel()).getElement();

		Command command = new Command() {

			@Override
			public void execute() {
				ActionHelper.openModelElement(element, "");
			}
			
		};

		return command;
	}
}
