/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.commands;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;

/**
 * @author schroech
 *
 */
public class CreateDefaultNodeAndConnectionCommand extends
CreateNodeAndConnectionCommand {

	/**
	 * @param diagramEditPart
	 * The {@link DiagramEditPart} for which the node an connection should be created
	 * @param sourceObject
	 * The source {@link EditPart}
	 * @param targetPoint
	 * The {@link Point} where the target node should be created
	 */
	public CreateDefaultNodeAndConnectionCommand(DiagramEditPart diagramEditPart,
			EditPart sourceObject, Point targetPoint) {
		super(diagramEditPart, sourceObject, targetPoint);
	}

	/**
	 * @param diagramEditPart
	 * The {@link DiagramEditPart} for which the node an connection should be created 
	 * @param sourcePoint
	 * The {@link Point} where the source node should be created
	 * @param targetObject
	 * The target {@link EditPart}
	 */
	public CreateDefaultNodeAndConnectionCommand(DiagramEditPart diagramEditPart,
			Point sourcePoint, EditPart targetObject) {
		super(diagramEditPart, sourcePoint, targetObject);
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.commands.CreateNodeAndConnectionCommand#getConnectionCreationCommand()
	*/
	@Override
	protected CreateConnectionCommand getConnectionCreationCommand() {
		if (super.getConnectionCreationCommand() == null) {
			setConnectionCreationCommand(new CreateDefaultConnectionCommand(
					getDiagramEditPart(),
					getSourceAdapter(), 
					getTargetAdapter()));
		}
		
		return super.getConnectionCreationCommand();
	}

}
