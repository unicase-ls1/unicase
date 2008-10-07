package org.unicase.ui.common.diagram;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.unicase.model.diagram.MEDiagram;

public class DeleteFromDiagramAction implements IObjectActionDelegate {

	public final static String ID = "DeleteFromDiagramActionID";

	private EditPart selectedElement;

	public void run(IAction action) {
		MEDiagramEditPart me = (MEDiagramEditPart) selectedElement.getParent();
		MEDiagram diag = (MEDiagram) ((View) me.getModel()).getElement();
		diag.getElements().remove(((View)selectedElement.getModel()).getElement());
	}

	public void selectionChanged(IAction action, ISelection selection) {
		selectedElement = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.getFirstElement() instanceof EditPart) {
				selectedElement = (EditPart) structuredSelection.getFirstElement();
			}
		}
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

}
