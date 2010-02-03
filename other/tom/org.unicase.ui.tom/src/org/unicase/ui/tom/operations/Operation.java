/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.operations;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;

/**
 * @author schroech
 *
 */
public interface Operation {
	
	/**
	 * @param diagramEditPart
	 * The {@link DiagramEditPart} on which this operation operates
	 */
	void setDiagramEditPart(DiagramEditPart diagramEditPart);

	/**
	 * @return The {@link DiagramEditPart} on which this operation operates
	 */
	DiagramEditPart getDiagramEditPart();
}
