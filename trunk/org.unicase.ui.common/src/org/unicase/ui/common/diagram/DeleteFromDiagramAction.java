package org.unicase.ui.common.diagram;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.unicase.model.diagram.MEDiagram;

/**
 * @author denglerm This class implements the DeleteFromDiagram Action.
 * The action is required in the popupMenus extension point of the diagram's common.xml
 */
public class DeleteFromDiagramAction implements IObjectActionDelegate {

	/**
	 * The id of the action, referred in the popupMenus extension point of the diagram's common.xml.
	 */
	public final static String ID = "DeleteFromDiagramActionID";

	/**
	 * The selected diagram element to delete.
	 */
	private EditPart selectedElement;

	/**
	 * This method deletes the diagram element from the diagram's elements list.
	 * @param action the action proxy that handles the presentation portion of the
     *   action
     * @see org.eclipse.ui.IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		MEDiagramEditPart me = (MEDiagramEditPart) selectedElement.getParent();
		MEDiagram diag = (MEDiagram) ((View) me.getModel()).getElement();
		diag.getElements().remove(((View)selectedElement.getModel()).getElement());
	}
	/**
	 * This method sets the selectedElement field.
	 * @param action the action proxy that handles presentation portion of 
     * 		the action
     * @param selection the current selection, or <code>null</code> if there
     * 		is no selection.
     *
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
	 * @param action
	 *            the action proxy that handles presentation portion of the
	 *            action; must not be <code>null</code>.
	 * @param targetPart
	 *            the new part target; must not be <code>null</code>.
	 *
	 * @see org.eclipse.jface.action.IAction.IObjectActionDelegate#setActivePar(IAction action, IWorkbenchPart targetPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

}
