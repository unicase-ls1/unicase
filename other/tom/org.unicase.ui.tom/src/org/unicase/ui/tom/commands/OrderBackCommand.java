/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.commands;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.internal.commands.SendToBackCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author schroech
 *
 */
@SuppressWarnings("restriction")
public class OrderBackCommand extends AbstractCommand {

	private final GraphicalEditPart targetEditPart;

	/**
	 * @param diagramEditPart The diagram edit part
	 * @param targetEditPart The target edit part
	 */
	public OrderBackCommand(DiagramEditPart diagramEditPart,
			GraphicalEditPart targetEditPart) {
		super(diagramEditPart);
		this.targetEditPart = targetEditPart;
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.commands.AbstractCommand#createRequest()
	*/
	@Override
	protected Request createRequest() {
		return null;
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.commands.AbstractCommand#getCommand()
	*/
	@Override
	public Command getCommand() {
		Object model = targetEditPart.getModel();
		if (!(model instanceof View)) {
			return null;
		}
		SendToBackCommand command = new SendToBackCommand(
				getDiagramEditPart().getEditingDomain(),
				(View)model);
		
		return new ICommandProxy(command);
	}

}
