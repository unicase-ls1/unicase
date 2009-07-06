/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.commands;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.ui.dialogs.ExpansionType;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.ShowRelatedElementsRequest;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.unicase.ui.common.diagram.util.EditPartUtility;

/**
 * @author schroech
 *
 */
public class DiscoveryModeActivationCommand extends AbstractCommand {

	private final GraphicalEditPart touchedEditPart;

	/**
	 * @param diagramEditPart The {@link DiagramEditPart} on which this operation operates
	 * @param touchedEditPart The {@link GraphicalEditPart} whose related elements will be shown 
	 */
	public DiscoveryModeActivationCommand(DiagramEditPart diagramEditPart, GraphicalEditPart touchedEditPart) {
		super(diagramEditPart);
		this.touchedEditPart = touchedEditPart;
	}
	
	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.commands.AbstractCommand#createRequest()
	*/
	@Override
	public Request createRequest() {
		EObject element = EditPartUtility.getElement(getTouchedEditPart());
		
		ShowRelatedElementsRequest showRelatedElementsRequest = new ShowRelatedElementsRequest(
				Collections.singletonList(getTouchedEditPart()),
				Collections.singletonList(ElementTypeRegistry.getInstance().getElementType(element)),
				false,
				1,
				ExpansionType.OUTGOING);
		
		return showRelatedElementsRequest;
	}

	/**
	 * @return The {@link GraphicalEditPart} whose related elements will be shown 
	 */
	public GraphicalEditPart getTouchedEditPart() {
		return touchedEditPart;
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.commands.AbstractCommand#getCommand()
	*/
	@Override
	public Command getCommand() {
		Command command = touchedEditPart.getCommand(getRequest());
		return command;
	}

}
