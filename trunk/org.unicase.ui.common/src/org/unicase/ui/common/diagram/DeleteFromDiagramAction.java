/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.diagram;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.EdgeImpl;
import org.eclipse.jface.action.Action;
import org.unicase.ui.common.diagram.commands.CommandFactory;
import org.unicase.ui.common.diagram.commands.DeleteFromDiagramCommand;
import org.unicase.ui.common.diagram.edit.parts.MEDiagramEditPart;
import org.unicase.ui.common.diagram.util.EditPartUtility;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.WorkspaceManager;

/**
 * @author denglerm This class implements the DeleteFromDiagram Action.
 */
public class DeleteFromDiagramAction extends Action {

	/**
	 * This method deletes the diagram element from the diagram's elements list.
	 * 
	 * @see org.eclipse.jface.action#run()
	 */
	@Override
	public void run() {
		EditPart selectedElement = (EditPart) ActionHelper.getSelection();
		CompoundCommand ccommand = new CompoundCommand("delete existing view");
		View view = EditPartUtility.getView(selectedElement);
		DiagramEditPart rootEditPart = null;
		if (view instanceof Node){
			DestroyElementRequest request = new DestroyElementRequest(WorkspaceManager.getInstance()
				.getCurrentWorkspace().getEditingDomain(), EditPartUtility.getElement(selectedElement), false);
			IElementType type = ElementTypeRegistry.getInstance().getElementType(request.getEditHelperContext());
			if(type!=null){
				ccommand.add(new ICommandProxy(new DeleteFromDiagramCommand(request, selectedElement)));
			}
			ccommand.add(CommandFactory.createDeleteFromViewCommand(selectedElement));
			rootEditPart= (DiagramEditPart)selectedElement.getParent();
		} else if (view instanceof Edge) {

			DestroyReferenceRequest req = new DestroyReferenceRequest(((Edge) view).getSource().getElement(), null,
				((Edge) view).getTarget().getElement(), false);
			ccommand.add(new ICommandProxy(new DestroyReferenceCommand(req)));
			rootEditPart= (DiagramEditPart) ((DiagramRootEditPart) selectedElement.getParent()).getContents();
 		}
		rootEditPart.getDiagramEditDomain().getDiagramCommandStack().execute(ccommand);
	
		/// Until I find out, while the Editpart is not notified in this case, the following serves as a workaround
		if (view instanceof EdgeImpl) {
			((MEDiagramEditPart)rootEditPart).updateView();
		}
	}
}
