package org.unicase.ui.common.diagram;

import org.eclipse.gef.EditPart;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

/**
 * @author denglerm This class is a wrapper class to make the DeleteFromDiagram action available in the context menu.
 */
public class DeleteFromDiagramContextMenuAction implements IObjectActionDelegate {

	/**
	 * The selected diagram element to delete.
	 */
	private EditPart selectedElement;
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
	 * @param action the action proxy that handles presentation portion of the action; must not be <code>null</code>.
	 * @param targetPart the new part target; must not be <code>null</code>.
	 * @see org.eclipse.jface.action.IAction.IObjectActionDelegate#setActivePar(IAction action, IWorkbenchPart
	 *      targetPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

}
