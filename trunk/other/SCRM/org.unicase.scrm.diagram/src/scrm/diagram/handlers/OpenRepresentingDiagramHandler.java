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
 * This handler provides the possibility to open representing diagrams
 * from selecting the corresponding action from a SCRMSpace's context menu.
 * To do so, it uses a {@link OpenDiagramCommand}.
 * @author mharut
 */
public class OpenRepresentingDiagramHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		// obtain edit part from selection
		EditPart editPart = obtainEditPart(event);
		
		View view = (View) editPart.getModel();
		
		new ICommandProxy(
				new OpenDiagramCommand(getLink(view))).execute();
		
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
