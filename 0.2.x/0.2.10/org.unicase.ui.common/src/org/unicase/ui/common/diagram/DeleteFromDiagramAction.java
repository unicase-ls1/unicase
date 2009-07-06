package org.unicase.ui.common.diagram;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.unicase.ui.common.commands.DeleteFromViewCommand;
import org.unicase.workspace.WorkspaceManager;

/**
 * @author denglerm This class implements the DeleteFromDiagram Action.
 * The action is required in the popupMenus extension point of the diagram's common.xml
 */
public class DeleteFromDiagramAction implements IObjectActionDelegate {

	/**
	 * The selected diagram element to delete.
	 */
	private EditPart selectedElement;
	
	/**
	 * The id of the action, referred in the popupMenus extension point of the diagram's common.xml.
	 */
	public static final String ID = "DeleteFromDiagramActionID";

	/**
	 * This method deletes the diagram element from the diagram's elements list.
	 * @param action the action proxy that handles the presentation portion of the
     *   action
     * @see org.eclipse.ui.IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		DestroyElementRequest destroy = new 
		DestroyElementRequest(WorkspaceManager.getInstance()
				.getCurrentWorkspace().getEditingDomain(),((View)selectedElement.getModel()).getElement(),false);
		IElementType type = 
		ElementTypeRegistry.getInstance().getElementType(destroy.getEditHelperContext());
		ICommand command = (type != null) ? new DeleteFromViewCommand(destroy, selectedElement) : null;
		try {
		        OperationHistoryFactory.getOperationHistory().execute(command, new 
		NullProgressMonitor(), null);
		}
		catch(ExecutionException e)
		{
		    e.printStackTrace();
		}

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
