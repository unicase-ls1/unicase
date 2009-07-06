package org.unicase.ui.tom.commands;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;

public class ChangeAssociationTypeCommand extends AbstractCommand {

	public ChangeAssociationTypeCommand(DiagramEditPart diagramEditPart,
			GraphicalEditPart targetEditPart) {
		super(diagramEditPart);
		
		Object model = targetEditPart.getModel();
		if (!(model instanceof View)) {
			return;
		}
		
		EObject element = ((View)model).getElement();
		
		EList<EAttribute> allAttributes = element.eClass().getEAllAttributes();
		for (EAttribute attribute : allAttributes) {
			EClassifier type = attribute.getEType();
			type.getName();
		}
	}

	@Override
	protected Request createRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Command getCommand() {
		// TODO Auto-generated method stub
		return null;
	}

}
