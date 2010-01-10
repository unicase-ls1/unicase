package org.unicase.ui.tom.commands;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.ui.dialogs.ExpansionType;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.ShowRelatedElementsRequest;
import org.unicase.ui.diagram.classDiagram.edit.commands.ShowRelatedElementsCommand;
import org.unicase.ui.diagram.classDiagram.part.ShowRelatedElementsController;
import org.unicase.ui.unicasecommon.diagram.requests.ShowRelatedElementsModeRequest;
import org.unicase.ui.unicasecommon.diagram.util.EditPartUtility;

public class DiscoveryModeDeactivationCommand extends AbstractCommand {

	private final GraphicalEditPart touchedEditPart;

	/**
	 * @param diagramEditPart The {@link DiagramEditPart} on which this operation operates
	 * @param touchedEditPart The {@link GraphicalEditPart} whose related elements will be shown 
	 */
	public DiscoveryModeDeactivationCommand(DiagramEditPart diagramEditPart, GraphicalEditPart touchedEditPart) {
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
		

		ShowRelatedElementsRequest showRelatedElementsRequest = new ShowRelatedElementsModeRequest(
				Collections.singletonList(getTouchedEditPart()),
				null,
				false,
				0,
				ExpansionType.BOTH, 
				false);
		
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
		ShowRelatedElementsCommand command;
		ShowRelatedElementsController instance = ShowRelatedElementsController.getInstance(getDiagramEditPart().getViewer());
		Set<EditPart> relatedEditParts = instance.getRelatedEditParts();
		command = new ShowRelatedElementsCommand((ShowRelatedElementsRequest) getRequest());
		
		return command;
	}

}
