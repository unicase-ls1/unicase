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
public abstract class AbstractOperation implements Operation {

	private DiagramEditPart diagramEditPart;

	/**
	 * Default constructor.
	 * 
	 * @param diagramEditPart The {@link DiagramEditPart} on which this operation operates 
	 */
	public AbstractOperation(DiagramEditPart diagramEditPart) {
		this.diagramEditPart = diagramEditPart;
	}
	
	/**
	 * @param diagramEditPart
	 * The {@link DiagramEditPart} on which this operation operates
	 */
	public void setDiagramEditPart(DiagramEditPart diagramEditPart) {
		this.diagramEditPart = diagramEditPart;
	}

	/**
	 * @return The {@link DiagramEditPart} on which this operation operates
	 */
	public DiagramEditPart getDiagramEditPart() {
		return diagramEditPart;
	}

}
