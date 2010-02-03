/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.commands;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;

/**
 * @author schroech
 *
 */
public class PromptAndCreateNodeAndConnectionCommand extends AbstractCommand {

	/**
	 * @param diagramEditPart The {@link DiagramEditPart} on which this operation operates
	 */
	public PromptAndCreateNodeAndConnectionCommand(DiagramEditPart diagramEditPart) {
		super(diagramEditPart);
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
