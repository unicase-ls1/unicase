package org.unicase.ui.diagram.componentDiagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;

public class ComponentDiagramDragDropEditPolicy extends DiagramDragDropEditPolicy {

	@Override
	public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {
		return super.getDropObjectsCommand(dropRequest);

	}
}
