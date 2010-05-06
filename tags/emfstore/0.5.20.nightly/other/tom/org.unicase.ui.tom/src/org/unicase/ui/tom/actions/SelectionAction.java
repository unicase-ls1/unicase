/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.actions;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;

/**
 * @author schroech
 *
 */
public abstract class SelectionAction extends AbstractAction {

	private org.eclipse.gef.GraphicalEditPart targetEditPart;

	/**
	 * Default constructor.
	 * 
	 * @param diagramEditPart The {@link DiagramEditPart} on which this operation operates
	 * @param targetEditPart The {@link GraphicalEditPart} being selected / deselected
	 */
	public SelectionAction(DiagramEditPart diagramEditPart, org.eclipse.gef.GraphicalEditPart targetEditPart) {
		super(diagramEditPart);
		setTargetEditPart(targetEditPart);
	}

	/**
	 * @return The {@link GraphicalEditPart} being selected / deselected
	 */
	public org.eclipse.gef.GraphicalEditPart getTargetEditPart() {
		return targetEditPart;
	}

	/**
	 * @param targetEditPart The {@link GraphicalEditPart} being selected / deselected
	 */
	public void setTargetEditPart(org.eclipse.gef.GraphicalEditPart targetEditPart) {
		this.targetEditPart = targetEditPart;
	}

}