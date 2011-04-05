/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.actions;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.swt.widgets.Display;

/**
 * @author schroech
 *
 */
public class SelectAction extends SelectionAction{

	/**
	 * Default constructor.
	 * 
	 * @param diagramEditPart The {@link DiagramEditPart} on which this operation operates
	 * @param targetEditPart The {@link GraphicalEditPart} being selected / deselected
	 */
	public SelectAction(DiagramEditPart diagramEditPart, org.eclipse.gef.GraphicalEditPart targetEditPart) {
		super(diagramEditPart, targetEditPart);
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.operations.Operation#finish()
	*/
	public void execute() {
		Runnable runnable = new Runnable(){
			public void run(){
				getDiagramEditPart().getViewer().select(getTargetEditPart());
			}
		};
		
		Display.getDefault().asyncExec(runnable);
	}
}
