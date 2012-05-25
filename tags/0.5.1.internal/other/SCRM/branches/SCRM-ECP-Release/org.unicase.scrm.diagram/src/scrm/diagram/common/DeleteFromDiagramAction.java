/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package scrm.diagram.common;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;

import scrm.diagram.commands.CommandFactory;
import scrm.diagram.edit.parts.SCRMDiagramEditPart;
import scrm.diagram.util.EditPartUtility;

// dengler: clarify if deleted reference if case is necessary.
/**
 * @author denglerm This class implements the DeleteFromDiagram Action.
 */
public class DeleteFromDiagramAction extends Action {

	/**
	 * In case of a diagram node to be deleted: This method deletes the model
	 * element behind the node from the diagram's elements (done by
	 * DeleteFromDiagramCommand) list, but not from the project. In case of a
	 * diagram link to be deleted: The reference is deleted from the view _and_
	 * from the model.
	 * 
	 * @see org.eclipse.jface.action#run()
	 */
	@Override
	public void run() {
		EditPart selectedElement = (EditPart) getSelectedEditPart();
		CompoundCommand ccommand = new CompoundCommand("delete from diagram");
		View view = EditPartUtility.getView(selectedElement);
		DiagramEditPart rootEditPart = EditPartUtility
				.getDiagramEditPart(selectedElement);
		// if no element of the diagram has been selected
		if (rootEditPart == null) {
			return;
		}
		if (view instanceof Node) {
			ccommand.add(CommandFactory
					.createDeleteFromDiagramCommand(selectedElement));
			ccommand.add(CommandFactory
					.createDeleteFromViewCommand(selectedElement));

		} else if (view instanceof Edge) {
			Edge edge = (Edge) view;
			EObject source = edge.getSource().getElement();
			EObject target = edge.getTarget().getElement();
			DestroyReferenceRequest req = new DestroyReferenceRequest(source,
					null, target, false);
			ccommand.add(new ICommandProxy(new DestroyReferenceCommand(req)));
			if (view.getElement() != null) {
				ccommand.add(CommandFactory
						.createDeleteFromModelCommand(selectedElement));
			}
		}
		rootEditPart.getDiagramEditDomain().getDiagramCommandStack()
				.execute(ccommand);

		// update containment references and diagram view
		if (view instanceof Edge) {
			Edge edge = (Edge) view;
			final EObject source = edge.getSource().getElement();
			final EObject target = edge.getTarget().getElement();
			
			// if the edge represented a containment reference, either source or
			// target may lack a container after the edge was deleted
			if (source.eContainer() == null) {
				new ECPCommand(target) {

					@Override
					protected void doRun() {
						// source is an orphan -> target still has a container
						Project project = ModelUtil.getProject(target);
						project.addModelElement(source);
						
					}
				}.run(true);
			} else if (target.eContainer() == null) {
				new ECPCommand(source) {

					@Override
					protected void doRun() {
						// target is an orphan -> source still has a container
						Project project = ModelUtil.getProject(source);
						project.addModelElement(target);
						
					}
				}.run(true);
				
			}
			
			((SCRMDiagramEditPart) rootEditPart).updateView();
		}
	}

	private EditPart getSelectedEditPart() {
		ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();

		ISelection sel = selectionService.getSelection();
		if (!(sel instanceof IStructuredSelection)) {
			return null;
		}

		IStructuredSelection ssel = (IStructuredSelection) sel;
		if (ssel.isEmpty()) {
			return null;
		}

		Object o = ssel.getFirstElement();
		
		if(!(o instanceof EditPart)) {
			return null;
		}
		
		return (EditPart) o;
	}
}
