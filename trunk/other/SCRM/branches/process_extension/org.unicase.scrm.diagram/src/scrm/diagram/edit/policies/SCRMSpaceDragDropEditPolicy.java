package scrm.diagram.edit.policies;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.ui.common.commands.ECPCommand;

import scrm.SCRMDiagram;
import scrm.diagram.util.EditPartUtility;

/**
 * This edit policy extends the original {@link DragDropEditPolicy}, in
 * that it also removes elements from the original diagram (instead of
 * having them in both, dropped compartment and diagram).
 * @author mharut
 */
public class SCRMSpaceDragDropEditPolicy extends DragDropEditPolicy {
	
	/**
	 * {@inheritDoc}
	 * @generated NOT: in addition to the actual command, also return a command
	 * to remove the dropped elements from the original diagram
	 */
	protected Command getDropCommand(ChangeBoundsRequest request) {
		CompoundCommand cc = new CompoundCommand("Drop SCRMDiagram Edit Parts");
		
		@SuppressWarnings("unchecked")
		final List<EditPart> editParts = request.getEditParts();
		
		if(editParts.isEmpty()) {
			// nothing to do
			return null;
		}
		
		final SCRMDiagram scrmDiagram = (SCRMDiagram) EditPartUtility.getDiagramEditPart(
				editParts.get(0)).getDiagramView().getElement();
		
		Command dropCommand = super.getDropCommand(request);
		
		if(dropCommand != null) {
			// add the actual drop command
			cc.add(dropCommand);
			
			// add command to remove elements from the original diagram
			cc.add(new Command() {
				public void execute() {
					
					new ECPCommand(scrmDiagram) {
						
						@Override
						protected void doRun() {
							for(EditPart editPart : editParts) {
								View view = (View) editPart.getAdapter(View.class);
								EObject element = ViewUtil.resolveSemanticElement(view);
								handleDrop(scrmDiagram, element);
								Iterator<EObject> it = element.eAllContents();
								while(it.hasNext()) {
									handleDrop(scrmDiagram, it.next());
								}
							}
						}
					}.run(true);
					
				}
			});
			
			return cc;
		}
		return UnexecutableCommand.INSTANCE;
	}
	
	private static void handleDrop(SCRMDiagram scrmDiagram, EObject eObject) {
		if(scrmDiagram.getElements().contains(eObject)) {
			scrmDiagram.getElements().remove(eObject);
		}
	}

}
