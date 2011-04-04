/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package scrm.diagram.commands;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.EdgeImpl;
import org.eclipse.jface.action.Action;
import org.unicase.ui.common.util.ActionHelper;

import scrm.diagram.commands.CommandFactory;
import scrm.diagram.edit.parts.SCRMDiagramEditPart;
import scrm.diagram.util.EditPartUtility;

// dengler: clarify if deleted reference if case is necessary.
/**
 * @author denglerm This class implements the DeleteFromDiagram Action.
 */
public class DeleteFromDiagramAction extends Action {

	/**
	 * In case of a diagram node to be deleted: This method deletes the model element behind the node from the diagram's
	 * elements (done by DeleteFromDiagramCommand) list, but not from the project. In case of a diagram link to be
	 * deleted: The reference is deleted from the view _and_ from the model.
	 * 
	 * @see org.eclipse.jface.action#run()
	 */
	@Override
	public void run() {
		EditPart selectedElement = (EditPart) ActionHelper.getSelection();
		CompoundCommand ccommand = new CompoundCommand("delete from diagram");
		View view = EditPartUtility.getView(selectedElement);
		DiagramEditPart rootEditPart = EditPartUtility.getDiagramEditPart(selectedElement);
		// if no element of the diagram has been selected
		if (rootEditPart == null) {
			return;
		}
		if (view instanceof Node) {
			ccommand.add(CommandFactory.createDeleteFromDiagramCommand(selectedElement));
			ccommand.add(CommandFactory.createDeleteFromViewCommand(selectedElement));

		} else if (view instanceof Edge) {

			DestroyReferenceRequest req = new DestroyReferenceRequest(((Edge) view).getSource().getElement(), null,
				((Edge) view).getTarget().getElement(), false);
			ccommand.add(new ICommandProxy(new DestroyReferenceCommand(req)));
			// in case of a transition in state or activity diagram
			if (view.getElement() != null) {
				ccommand.add(CommandFactory.createDeleteFromModelCommand(selectedElement));
			}

		}
		rootEditPart.getDiagramEditDomain().getDiagramCommandStack().execute(ccommand);

		// / Until I find out, while the Editpart is not notified in this case, the following serves as a workaround
		if (view instanceof EdgeImpl) {
			((SCRMDiagramEditPart) rootEditPart).updateView();
		}
	}
}
