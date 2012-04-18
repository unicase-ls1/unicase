/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.classDiagram.part;

import java.util.Collections;

import org.eclipse.gmf.runtime.common.ui.dialogs.ExpansionType;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.ShowRelatedElementsRequest;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.unicase.ui.diagram.classDiagram.edit.commands.ShowRelatedElementsCommand;
import org.unicase.ui.diagram.classDiagram.edit.parts.ClassEditPart;
import org.unicase.ui.unicasecommon.diagram.util.EditPartUtility;

/**
 * @author schroech
 */
public class ShowRelatedElementsAction implements IObjectActionDelegate {

	private ClassEditPart selectedClassEditPart;

	/**
	 * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction,
	 *      org.eclipse.ui.IWorkbenchPart)
	 * @param action Ignored
	 * @param targetPart Ignored
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// do nothing
	}

	/**
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 * @param action Ignored
	 */
	public void run(IAction action) {
		if (getSelectedClassEditPart() == null) {
			throw new IllegalStateException();
		}

		ShowRelatedElementsRequest request = new ShowRelatedElementsRequest(Collections
			.singletonList(getSelectedClassEditPart()), null, false, 0, ExpansionType.BOTH);
		ShowRelatedElementsCommand command = new ShowRelatedElementsCommand(request);

		DiagramEditPart diagramEditPart = EditPartUtility.getDiagramEditPart(getSelectedClassEditPart());
		diagramEditPart.getDiagramEditDomain().getDiagramCommandStack().execute(command);
	}

	/**
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 * @param action Ignored
	 * @param selection The current selection, or <code>null</code> if there is no selection.
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		setSelectedClassEditPart(null);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.getFirstElement() instanceof ClassEditPart) {
				setSelectedClassEditPart((ClassEditPart) structuredSelection.getFirstElement());
			}
		}
	}

	private void setSelectedClassEditPart(ClassEditPart selectedClassEditPart) {
		this.selectedClassEditPart = selectedClassEditPart;
	}

	private ClassEditPart getSelectedClassEditPart() {
		return selectedClassEditPart;
	}

}
