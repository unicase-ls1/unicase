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

public class DiscoveryCommand extends AbstractCommand {

	private final GraphicalEditPart touchedEditPart;

	public DiscoveryCommand(DiagramEditPart diagramEditPart, GraphicalEditPart touchedEditPart) {
		super(diagramEditPart);
		this.touchedEditPart = touchedEditPart;
	}
	
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

	public void execute() {
		Command command = touchedEditPart.getCommand(getRequest());
		
		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().execute(command);
	}

	public GraphicalEditPart getTouchedEditPart() {
		return touchedEditPart;
	}

}
