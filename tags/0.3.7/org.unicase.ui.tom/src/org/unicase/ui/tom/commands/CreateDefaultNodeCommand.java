package org.unicase.ui.tom.commands;

import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantService;

public class CreateDefaultNodeCommand extends CreateNodeCommand {

	@SuppressWarnings("unchecked")
	public CreateDefaultNodeCommand(DiagramEditPart diagramEditPart, Point point) {
		super(diagramEditPart, point);
		
		ModelingAssistantService service = ModelingAssistantService.getInstance();
		List relatedNodeTypes = null;
		IElementType defaultElementType = null;

		relatedNodeTypes = service.getTypesForPopupBar(diagramEditPart);

		for (Object object : relatedNodeTypes) {
			if (object instanceof IElementType) {
				defaultElementType = (IElementType) object;
				break;
			}			
		}
		
		if (defaultElementType == null) {
			throw new IllegalArgumentException("No ElementType registered for DiagramEditPart");
		}
		
		setElementType(defaultElementType);
	}
	
}
