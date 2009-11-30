package org.unicase.ui.diagram.activityDiagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.unicase.ui.common.diagram.commands.DeleteFromModelCommand;

/**
 * @generated
 */
public class TransitionItemSemanticEditPolicy
		extends
		org.unicase.ui.diagram.activityDiagram.edit.policies.ModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DeleteFromModelCommand(req));
	}

}
