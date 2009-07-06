package org.unicase.ui.componentDiagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;

public class ComponentDiagramDragDropEditPolicy extends DiagramDragDropEditPolicy {

	public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {
		return super.getDropObjectsCommand(dropRequest);

	}
}
