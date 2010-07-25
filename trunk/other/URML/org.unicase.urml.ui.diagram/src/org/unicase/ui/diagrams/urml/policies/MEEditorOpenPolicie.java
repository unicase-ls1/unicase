package org.unicase.ui.diagrams.urml.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.ui.common.util.ActionHelper;

public class MEEditorOpenPolicie extends OpenEditPolicy {

	@Override
	protected Command getOpenCommand(Request request) {
		EditPart targetEditPart = getTargetEditPart(request);
		final EObject element = ((View) targetEditPart.getModel()).getElement();

		Command command = new Command() {
			@Override
			public void execute() {
				super.execute();
				ActionHelper.openModelElement(element, "");
			}
		};
		return command;
	}
}
