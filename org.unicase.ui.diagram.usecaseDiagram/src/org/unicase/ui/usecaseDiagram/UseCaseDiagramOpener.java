/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.usecaseDiagram;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.core.ECPProject;
import org.eclipse.emf.ecp.ui.util.ECPModelElementOpener;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.diagram.UseCaseDiagram;
import org.unicase.ui.unicasecommon.common.diagram.DiagramOpener;

/**
 * Opener for use case diagrams.
 * 
 * @author koegel
 */
public class UseCaseDiagramOpener extends DiagramOpener implements
		ECPModelElementOpener {

	/**
	 * Convenient constructor.
	 */
	public UseCaseDiagramOpener() {
	}

	/**
	 * The default editor can open every {@link EObject}, but has the lowest
	 * value.
	 *
	 * @param modelElement
	 *            {@link EObject} to test
	 * @return 0
	 */
	public int canOpen(EObject modelElement) {
		if (modelElement instanceof UseCaseDiagram) {
			return 5;
		}
		return 0;
	}

	@Override
	public void openModelElement(Object element, ECPProject ecpProject) {
		if (element instanceof UseCaseDiagram) {
			MEDiagram diagram = (MEDiagram) element;
			super.openDiagram(diagram,
					"org.unicase.ui.diagram.usecaseDiagram.part.ModelDiagramEditorID");
		} else {
			throw new IllegalArgumentException(
					"Opener only applicable for MEDiagrams");
		}

	}

}
