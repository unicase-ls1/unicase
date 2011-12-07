package scrm.diagram.edit.policies;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import scrm.SCRMDiagram;
import scrm.SCRMModelElement;
import scrm.SCRMSpace;
import scrm.diagram.util.EditPartUtility;

/**
 * This edit policy extends the original {@link DragDropEditPolicy}, in
 * that it adds elements from the original compartment to the elements
 * of the diagram.
 * @author mharut
 */
public class SCRMDiagramDragDropEditPolicy extends DragDropEditPolicy {
	
	/**
	 * {@inheritDoc}
	 * @generated NOT: in addition to the actual command, also return a command
	 * to remove the dropped elements from the original diagram
	 */
	protected Command getDropCommand(ChangeBoundsRequest request) {
		@SuppressWarnings("unchecked")
		final List<EditPart> editParts = request.getEditParts();
		
		if(editParts.isEmpty()) {
			// nothing to do
			return null;
		}
		
		final DiagramEditPart diagramEP = EditPartUtility.getDiagramEditPart(editParts.get(0));
		final SCRMDiagram scrmDiagram = (SCRMDiagram) diagramEP.getDiagramView().getElement();
		
		// return command to add elements from the original compartment
		return new Command() {
			public void execute() {
				
				new ECPCommand(scrmDiagram) {
					
					@Override
					protected void doRun() {
						for(EditPart editPart : editParts) {
							View view = (View) editPart.getAdapter(View.class);
							EObject element = ViewUtil.resolveSemanticElement(view);
							if(!(element.eContainer() instanceof Project)) {
								ModelUtil.getProject(scrmDiagram).addModelElement(element);
							}
							List<EObject> elementsToAdd = gatherElementsToAdd(element);
							elementsToAdd.add(element);
							handleDrop(scrmDiagram, elementsToAdd);
						}
					}

				}.run(true);
				
			}
		};
		
	}
	
	private static void handleDrop(SCRMDiagram scrmDiagram, List<EObject> elementsToAdd) {
		for(EObject eObject : elementsToAdd) {
			if(!scrmDiagram.getElements().contains(eObject) &&
					eObject instanceof SCRMModelElement) {
				scrmDiagram.getElements().add((SCRMModelElement) eObject);
			}
		}
		
	}
	
	private static List<EObject> gatherElementsToAdd(EObject eObject) {
		List<EObject> result = new LinkedList<EObject>();
		result.add(eObject);
		if(!(eObject instanceof SCRMSpace)) {
			for(EObject child : eObject.eContents()) {
				result.addAll(gatherElementsToAdd(child));
			}
		}
		return result;
	}
		
}
