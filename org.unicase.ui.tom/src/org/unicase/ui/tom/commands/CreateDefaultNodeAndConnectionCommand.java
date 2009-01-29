package org.unicase.ui.tom.commands;

import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantService;

public class CreateDefaultNodeAndConnectionCommand extends
		CreateNodeAndConnectionCommand {

	@SuppressWarnings("unchecked")
	protected CreateDefaultNodeAndConnectionCommand(DiagramEditPart editor,
			Point sourcePoint, Point targetPoint, EditPart sourceEditPart,
			EditPart targetEditPart) {
		super(editor, sourcePoint, targetPoint, sourceEditPart, targetEditPart);

		ModelingAssistantService service = ModelingAssistantService.getInstance();
		List relatedConnectionTypes = null;
		IElementType defaultConnectionElementType = null;
		
		if (sourceEditPart != null
				&& targetEditPart != null) {
			relatedConnectionTypes = service.getRelTypesOnSourceAndTarget(sourceEditPart, targetEditPart);
		}else if(sourceEditPart != null) {
			relatedConnectionTypes = service.getRelTypesOnSource(sourceEditPart);
		}else if (targetEditPart != null) {
			relatedConnectionTypes = service.getRelTypesOnTarget(targetEditPart);
		}

		for (Object object : relatedConnectionTypes) {
			if (object instanceof IElementType) {
				defaultConnectionElementType = (IElementType) object;
				break;
			}
		}
		
		if (defaultConnectionElementType == null) {
			throw new IllegalArgumentException("No ElementType registered for connection between input arguments sourceEditPart and targetEditPart");
		}
		
		setConnectionElementType(defaultConnectionElementType);
	}

}
