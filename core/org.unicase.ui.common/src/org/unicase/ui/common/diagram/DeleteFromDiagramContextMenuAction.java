/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.diagram;

import org.eclipse.gef.EditPart;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
//dengler: document setActivePart
/**
 * @author denglerm This class is a wrapper class to make the DeleteFromDiagram action available in a
 * diagram's context menu.
 * of a diagram.
 */
public class DeleteFromDiagramContextMenuAction implements IObjectActionDelegate {

	/**
	 * The selected diagram element to delete.
	 */
	private EditPart selectedElement;
	/**
	 * The embedded action.
	 */
	private Action embeddedAction;

	/**
	 * . The constructor
	 */
	public DeleteFromDiagramContextMenuAction() {
		this.embeddedAction = new DeleteFromDiagramAction();
	}

	/**
	 * This method calls the embedded action's run method, which deletes the diagram element from the diagram's elements
	 * list.
	 * 
	 * @param action the action proxy that handles the presentation portion of the action
	 * @see org.eclipse.ui.IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		if (this.selectedElement != null) {
			this.embeddedAction.run();
		}
	}

	/**
	 * This method sets the selectedElement field.
	 * 
	 * @param action the action proxy that handles presentation portion of the action
	 * @param selection the current selection, or <code>null</code> if there is no selection.
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(IAction action, ISelection selection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		selectedElement = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.getFirstElement() instanceof EditPart) {
				selectedElement = (EditPart) structuredSelection.getFirstElement();
			}
		}
	}

	/**
	 * . {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.action.IAction.IObjectActionDelegate#setActivePar(IAction action, IWorkbenchPart
	 *      targetPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

}
