/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.activityDiagram;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.core.ECPProject;
import org.eclipse.emf.ecp.ui.util.ECPModelElementOpener;
import org.unicase.model.diagram.ActivityDiagram;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.unicasecommon.common.diagram.DiagramOpener;

/**
 * Opener for activity diagrams.
 * 
 * @author koegel
 */
public class ActivityDiagramOpener extends DiagramOpener implements
		ECPModelElementOpener {
	/**
	 * Convenient constructor.
	 */
	public ActivityDiagramOpener() {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.util.ModelElementOpener#canOpen(org.unicase.metamodel.ModelElement)
	 */
	public int canOpen(EObject me) {
		if (me instanceof ActivityDiagram) {
			return 5;
		}
		return 0;
	}

	@Override
	public void openModelElement(Object element, ECPProject ecpProject) {
		if (element instanceof ActivityDiagram) {
			MEDiagram diagram = (MEDiagram) element;
			super.openDiagram(diagram,
					"org.unicase.ui.diagram.activityDiagram.part.ModelDiagramEditorID");
		} else {
			throw new IllegalArgumentException(
					"Opener only applicable for MEDiagrams");
		}
	}

}
