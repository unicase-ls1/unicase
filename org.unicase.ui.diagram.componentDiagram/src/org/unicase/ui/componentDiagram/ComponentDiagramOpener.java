/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.componentDiagram;

import org.unicase.metamodel.ModelElement;
import org.unicase.model.diagram.ComponentDiagram;
import org.unicase.model.diagram.DiagramType;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.common.ModelElementOpener;
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
	 * @see org.unicase.ui.common.ModelElementOpener#canOpen(org.unicase.metamodel.ModelElement)
	 */
	public int canOpen(ModelElement me) {
		if (me instanceof ComponentDiagram) {
//			MEDiagram diagram = (MEDiagram) me;
//			if (diagram.getType().equals(DiagramType.COMPONENT_DIAGRAM)) {
				return 1;
//			}
		}
		return 0;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.ModelElementOpener#openModelElement(org.unicase.metamodel.ModelElement)
	 */
	public void openModelElement(ModelElement modelElement) {
		if (modelElement instanceof MEDiagram) {
			MEDiagram diagram = (MEDiagram) modelElement;
			super.openDiagram(diagram, "org.unicase.ui.diagram.componentDiagram.part.ModelDiagramEditorID");
		} else {
			throw new IllegalArgumentException("Opener only applicable for MEDiagrams");
		}

	}

}
