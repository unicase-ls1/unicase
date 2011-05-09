/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.classDiagram.providers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;

/**
 * @author schroech
 */
public class ClassModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider#getRelTypesForSREOnSource(org.eclipse.core.runtime.IAdaptable)
	 * @param source The source element for which related elements should be shown
	 * @return Class element types
	 */
	@Override
	public List getRelTypesForSREOnSource(IAdaptable source) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);

		if (editPart instanceof org.unicase.ui.diagram.classDiagram.edit.parts.ClassEditPart) {
			List types = new ArrayList();
			types.add(org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Class_2001);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider#getRelTypesForSREOnTarget(org.eclipse.core.runtime.IAdaptable)
	 * @param target The target element for which related elements should be shown
	 * @return Class element types
	 */
	@Override
	public List getRelTypesForSREOnTarget(IAdaptable target) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);

		if (editPart instanceof org.unicase.ui.diagram.classDiagram.edit.parts.ClassEditPart) {
			List types = new ArrayList();
			types.add(org.unicase.ui.diagram.classDiagram.providers.ModelElementTypes.Class_2001);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

}
