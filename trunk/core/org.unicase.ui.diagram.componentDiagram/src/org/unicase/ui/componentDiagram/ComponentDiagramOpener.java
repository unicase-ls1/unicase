/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.componentDiagram;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.util.ModelElementOpener;
import org.unicase.model.diagram.ComponentDiagram;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.unicasecommon.common.diagram.DiagramOpener;

/**
 * Opener for component diagrams.
 * 
 * @author koegel
 */
public class ComponentDiagramOpener extends DiagramOpener implements ModelElementOpener {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.util.ModelElementOpener#canOpen(org.unicase.metamodel.ModelElement)
	 */
	public int canOpen(EObject me) {
		if (me instanceof ComponentDiagram) {
			// MEDiagram diagram = (MEDiagram) me;
			// if (diagram.getType().equals(DiagramType.COMPONENT_DIAGRAM)) {
			return 1;
			// }
		}
		return DONOTOPEN;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.util.ModelElementOpener#openModelElement(org.unicase.metamodel.ModelElement)
	 */
	public void openModelElement(EObject modelElement) {
		if (modelElement instanceof MEDiagram) {
			MEDiagram diagram = (MEDiagram) modelElement;
			super.openDiagram(diagram, "org.unicase.ui.diagram.componentDiagram.part.ModelDiagramEditorID");
		} else {
			throw new IllegalArgumentException("Opener only applicable for MEDiagrams");
		}

	}

}
