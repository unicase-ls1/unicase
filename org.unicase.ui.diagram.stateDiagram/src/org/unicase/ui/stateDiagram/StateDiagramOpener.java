/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stateDiagram;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.core.ECPProject;
import org.eclipse.emf.ecp.ui.util.ECPModelElementOpener;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.diagram.StateDiagram;
import org.unicase.ui.unicasecommon.common.diagram.DiagramOpener;

/**
 * Opener for state diagrams.
 * 
 * @author koegel
 */
public class StateDiagramOpener extends DiagramOpener implements
		ECPModelElementOpener {

	@Override
	public void openModelElement(Object element, ECPProject ecpProject) {
		if (element instanceof StateDiagram) {
			MEDiagram diagram = (MEDiagram) element;
			super.openDiagram(diagram,
					"org.unicase.ui.diagram.stateDiagram.part.ModelDiagramEditorID");
		} else {
			throw new IllegalArgumentException(
					"Opener only applicable for MEDiagrams");
		}

	}

	/**
	 * Convenient constructor.
	 */
	public StateDiagramOpener() {
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
		if (modelElement instanceof StateDiagram) {
			return 1;
		}
		return 0;
	}
}
