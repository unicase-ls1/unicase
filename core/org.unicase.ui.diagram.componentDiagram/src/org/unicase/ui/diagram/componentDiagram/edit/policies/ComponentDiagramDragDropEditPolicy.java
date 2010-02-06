/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.componentDiagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;

/**
 * Drop policy for component diagrams.
 * 
 * @author koegel
 */
public class ComponentDiagramDragDropEditPolicy extends DiagramDragDropEditPolicy {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy#getDropObjectsCommand(org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest)
	 */
	@Override
	public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {
		return super.getDropObjectsCommand(dropRequest);

	}
}
