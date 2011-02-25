/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.commands;

import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantService;

/**
 * @author schroech
 *
 */
public class CreateDefaultNodeCommand extends CreateNodeCommand {

	/**
	 * @param diagramEditPart The {@link DiagramEditPart} on which this operation operates
	 * @param point The position where the new editPart is created
	 */
	@SuppressWarnings("unchecked")
	public CreateDefaultNodeCommand(DiagramEditPart diagramEditPart, Point point) {
		super(diagramEditPart, point, null);
		
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
