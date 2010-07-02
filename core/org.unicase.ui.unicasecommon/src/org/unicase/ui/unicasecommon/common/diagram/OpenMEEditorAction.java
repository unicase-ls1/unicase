/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.diagram;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.unicase.ui.unicasecommon.UnicaseActionHelper;

/**
 * @author denglerm This class implements the Open ModelElement with MEEditor Action. The action is required in the
 *         popupMenus extension point of the diagram's common.xml
 */
public class OpenMEEditorAction implements IObjectActionDelegate {

	/**
	 * The selected diagram element to open with MEEditor.
	 */
	private EditPart selectedElement;

	/**
	 * This method opens the selected ModelElement with the MEEditor.
	 * 
	 * @param action the action proxy that handles the presentation portion of the action
	 * @see org.eclipse.ui.IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		if (this.selectedElement != null) {
			EObject me = ((View) selectedElement.getModel()).getElement();
			UnicaseActionHelper.openModelElement(me, this.getClass().getName());
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
		// TODO Auto-generated method stub

	}
}