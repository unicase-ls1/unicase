/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.commands;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;

/**
 * @author schroech
 *
 */
public class PromptAndCreateNodeCommand extends AbstractCommand {

	@SuppressWarnings("unused")
	private final Point point;

	/**
	 * @param diagramEditPart The {@link DiagramEditPart} on which this operation operates
	 * @param point The point where the new node will be created
	 */
	public PromptAndCreateNodeCommand(DiagramEditPart diagramEditPart, Point point) {
		super(diagramEditPart);
		this.point = point;
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.commands.AbstractCommand#createRequest()
	*/
	@Override
	public Request createRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.commands.AbstractCommand#getCommand()
	*/
	@Override
	public Command getCommand() {
		// TODO Auto-generated method stub
		return null;
	}

}
