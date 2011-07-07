package scrm.diagram.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import scrm.SCRMDiagram;
import scrm.diagram.edit.policies.OpenSCRMSpaceEditPolicy.OpenDiagramCommand;

/**
 * @author mharut
 * 
 * Handler for the Save Template command. This handler obtains a SCRM Diagram from
 * the context the command was called in and lets the user choose a file to save the
 * diagram as a template to. This template can be used by calling the Load Template
 * command.
 */
public class OpenRepresentingDiagramHandler extends AbstractHandler {

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// obtain edit part from selection
		EditPart editPart = obtainEditPart(event);
		
		View view = (View) editPart.getModel();
		
		// obtain the default directory to save files to
		SCRMDiagram scrmDiagram = (SCRMDiagram) ((Diagram) editPart.getRoot().getContents().getModel()).eContainer();
		
		new ICommandProxy(new OpenDiagramCommand(getLink(view), scrmDiagram)).execute();
		
		return null;
	}

	/**
	 * Obtains a SCRMDiagram by checking if one was selected. If no SCRMDiagram was
	 * selected, checks if the active editor is actually a diagram editor.
	 * If so, the Diagrams container, which is a SCRMDiagram, is returned.
	 * If none of the above holds, throws an IllegalArgumentException, as this
	 * Handler was falsely called. 
	 * 
	 * @param event an event containing all the information about the current 
	 * state of the application
	 * @return the properly obtained SCRMDiagram
	 * @throws ExecutionException if an exception occurred during the execution
	 */
	private EditPart obtainEditPart(ExecutionEvent event) throws ExecutionException {
		
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		// check if a SCRMDiagram was selected		
		IStructuredSelection ssel;
		if (selection != null && selection instanceof IStructuredSelection) {
			ssel = (IStructuredSelection) selection;
			if (!ssel.isEmpty() && ssel.getFirstElement() instanceof EditPart) {
				return (EditPart) ssel.getFirstElement();
			} else {
				throw new IllegalArgumentException();
			}
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	private HintedDiagramLinkStyle getLink(View view) {
		Style link = view.getStyle(NotationPackage.eINSTANCE
				.getHintedDiagramLinkStyle());
		while (!(link instanceof HintedDiagramLinkStyle)) {
			Object container = view.eContainer();
			if (container instanceof View) {
				view = (View) container;
				link = view.getStyle(NotationPackage.eINSTANCE
						.getHintedDiagramLinkStyle());
			} else {
				return null;
			}
		}
		return (HintedDiagramLinkStyle) link;
	}

}
