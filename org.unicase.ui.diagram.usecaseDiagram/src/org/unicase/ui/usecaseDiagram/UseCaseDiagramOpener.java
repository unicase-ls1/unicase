/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.usecaseDiagram;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.util.ModelElementOpener;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.diagram.UseCaseDiagram;
import org.unicase.ui.unicasecommon.common.diagram.DiagramOpener;

/**
 * Opener for use case diagrams.
 * 
 * @author koegel
 */
public class UseCaseDiagramOpener extends DiagramOpener implements ModelElementOpener {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.util.ModelElementOpener#canOpen(org.unicase.metamodel.ModelElement)
	 */
	public int canOpen(EObject me) {
		if (me instanceof UseCaseDiagram) {
			// MEDiagram diagram = (MEDiagram) me;
			// if (diagram.getGmfdiagram().equals(DiagramType.USECASE_DIAGRAM)){
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
			super.openDiagram(diagram, "org.unicase.ui.diagram.usecaseDiagram.part.ModelDiagramEditorID");
		} else {
			throw new IllegalArgumentException("Opener only applicable for MEDiagrams");
		}

	}

}
