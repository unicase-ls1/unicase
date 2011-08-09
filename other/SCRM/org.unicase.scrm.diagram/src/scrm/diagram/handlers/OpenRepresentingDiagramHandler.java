package scrm.diagram.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import scrm.SCRMDiagram;
import scrm.SCRMSpace;
import scrm.diagram.edit.policies.OpenSCRMSpaceEditPolicy.OpenDiagramCommand;

/**
 * This handler provides the possibility to open representing diagrams
 * from selecting the corresponding action from a SCRMSpace's context menu.
 * To do so, it uses a {@link OpenDiagramCommand}.
 * @author mharut
 */
public class OpenRepresentingDiagramHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		// obtain edit part from selection
		Object selectedElement = validateSelection(event);
		if(selectedElement instanceof EditPart) {
			EditPart editPart = (EditPart) selectedElement;
			View view = (View) editPart.getModel();
			SCRMSpace representedSpace = (SCRMSpace) view.getElement();
			SCRMDiagram containingDiagram = (SCRMDiagram) view
					.getDiagram().eContainer();
			new ICommandProxy(
					new OpenDiagramCommand(representedSpace,
							containingDiagram)).execute();
		} else if (selectedElement instanceof SCRMSpace) {
			SCRMSpace representedSpace = (SCRMSpace) selectedElement;
			new ICommandProxy(
					new OpenDiagramCommand(representedSpace,
							null)).execute();
		} else {
			throw new IllegalArgumentException();
		}
		
		
		
		
		
		return null;
	}

	/**
	 * Obtains the <code>EditPart</code> from the <code>event</code>'s
	 * current selection.
	 * 
	 * @param event an event containing all the information about the current 
	 * state of the application
	 * @return the properly obtained <code>EditPart</code>
	 * @throws ExecutionException if an exception occurred during the execution
	 */
	private Object validateSelection(ExecutionEvent event) throws ExecutionException {
		
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		IStructuredSelection ssel;
		if (selection != null && selection instanceof IStructuredSelection) {
			ssel = (IStructuredSelection) selection;
			if (!ssel.isEmpty()) {
				return  ssel.getFirstElement();
			} else {
				throw new IllegalArgumentException("Selection mustn't be empty!");
			}
		} else {
			throw new IllegalArgumentException();
		}
	}
	
}
