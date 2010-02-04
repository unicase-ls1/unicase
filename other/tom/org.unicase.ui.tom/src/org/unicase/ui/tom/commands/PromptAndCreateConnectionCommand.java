/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.commands;

import java.util.List;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantService;

/**
 * @author schroech
 *
 */
public class PromptAndCreateConnectionCommand extends AbstractCommand {

	private final GraphicalEditPart sourceEditPart;
	private final GraphicalEditPart targetEditPart;

	/**
	 * Default constructor.
	 * 
	 * @param diagramEditPart The diagram edit part
	 * @param sourceEditPart The connection source
	 * @param targetEditPart The connection target
	 */
	PromptAndCreateConnectionCommand(DiagramEditPart diagramEditPart, 
			GraphicalEditPart sourceEditPart,
			GraphicalEditPart targetEditPart) {
		super(diagramEditPart);
		// TODO Auto-generated constructor stub
		this.sourceEditPart = sourceEditPart;
		this.targetEditPart = targetEditPart;
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.commands.AbstractCommand#createRequest()
	*/
	@Override
	public Request createRequest() {
		List relTypesOnSourceAndTarget = ModelingAssistantService.getInstance()
			.getRelTypesOnSourceAndTarget(sourceEditPart, targetEditPart);
		
		CreateUnspecifiedTypeConnectionRequest connectionRequest 
		= new CreateUnspecifiedTypeConnectionRequest(relTypesOnSourceAndTarget, 
				false, 
				getDiagramEditPart().getDiagramPreferencesHint());
		
		return connectionRequest;
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
