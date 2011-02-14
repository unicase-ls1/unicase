/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.orga.diagram;

import org.eclipse.emf.ecore.EObject;
import org.unicase.model.diagram.ClassDiagram;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.orga.OrgDiagram;
import org.unicase.ui.common.ModelElementOpener;
import org.unicase.ui.unicasecommon.common.diagram.DiagramOpener;

/**
 * Opener for class diagrams.
 * 
 * @author koegel
 */
public class OrgChartDiagramOpener extends DiagramOpener implements ModelElementOpener {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.ModelElementOpener#canOpen(org.unicase.metamodel.ModelElement)
	 */
	public int canOpen(EObject me) {
		if (me instanceof OrgDiagram) {
			// MEDiagram diagram = (MEDiagram) me;
			// if (diagram.getType().equals(DiagramType.CLASS_DIAGRAM)){
			return 1;
			// }
		}
		return DONOTOPEN;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.ModelElementOpener#openModelElement(org.unicase.metamodel.ModelElement)
	 */
	public void openModelElement(EObject modelElement) {
		if (modelElement instanceof MEDiagram) {
			MEDiagram diagram = (MEDiagram) modelElement;
			super.openDiagram(diagram, "org.unicase.model.orga.diagram.part.OrgaDiagramEditorID");
		} else {
			throw new IllegalArgumentException("Opener only applicable for MEDiagrams");
		}

	}

}
