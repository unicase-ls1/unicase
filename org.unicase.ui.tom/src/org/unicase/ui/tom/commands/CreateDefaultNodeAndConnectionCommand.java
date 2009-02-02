package org.unicase.ui.tom.commands;

import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantService;

public class CreateDefaultNodeAndConnectionCommand extends
		CreateNodeAndConnectionCommand {

	public CreateDefaultNodeAndConnectionCommand(DiagramEditPart editor,
			Point sourcePoint, Point targetPoint) {
		super(editor, sourcePoint, targetPoint);
	}
	
	public CreateDefaultNodeAndConnectionCommand(DiagramEditPart editor,
			EditPart sourceObject, EditPart targetObject) {
		super(editor, sourceObject, targetObject);
	}

	public CreateDefaultNodeAndConnectionCommand(DiagramEditPart editor,
			EditPart sourceObject, Point targetPoint) {
		super(editor, sourceObject, targetPoint);
	}

	public CreateDefaultNodeAndConnectionCommand(DiagramEditPart editor,
			Point sourcePoint, EditPart targetObject) {
		super(editor, sourcePoint, targetObject);
	}

	@SuppressWarnings("unchecked")
	@Override
	public IElementType getConnectionElementType() {
		ModelingAssistantService service = ModelingAssistantService.getInstance();
		List relatedConnectionTypes = null;
		IElementType defaultConnectionElementType = null;
		
		if (getSourceEditPart() != null
				&& getTargetEditPart() != null) {
			relatedConnectionTypes = service.getRelTypesOnSourceAndTarget(getSourceEditPart(), getTargetEditPart());
		}else if(getSourceEditPart() != null) {
			relatedConnectionTypes = service.getRelTypesOnSource(getSourceEditPart());
		}else if (getTargetEditPart() != null) {
			relatedConnectionTypes = service.getRelTypesOnTarget(getTargetEditPart());
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
		
		// TODO Auto-generated method stub
		return super.getConnectionElementType();
	}
}
