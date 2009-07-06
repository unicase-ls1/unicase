package org.unicase.ui.tom.commands;

import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

public interface CommandFactory {

	Command getCreateConnectionsCommand(
			IElementType connectionType, 
			List<EObject> existingSourceElements, 
			EObject existingTargetElement);
	
	Command getCreateNodeCommand(
			IElementType nodeType,
			Point point);
	
	Command getCreateNodesAndConnectionsCommand(
			IElementType nodeType,
			IElementType connectionType,
			List<Point> creationpoints,
			boolean source,
			List<EObject> existingTargetElements);
}
