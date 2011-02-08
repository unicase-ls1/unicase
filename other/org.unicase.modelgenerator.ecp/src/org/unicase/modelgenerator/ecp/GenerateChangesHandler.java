package org.unicase.modelgenerator.ecp;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.modelchanger.ModelChanger;
import org.unicase.ui.common.commands.ECPCommand;
import org.unicase.workspace.ProjectSpace;

public class GenerateChangesHandler extends AbstractHandler {
	
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		final EObject rootObject = validateSelection(selection);
		
		new ECPCommand(rootObject) {

			@Override
			protected void doRun() {
				ModelChanger.generateChanges(rootObject);
			}
		}.run();

		return null;
	}
	
	/**
	 * Returns the selected EObject, or a project if a ProjectSpace was selected.
	 * If the selected element is no EObject or nothing is selected, this method 
	 * shouldn't be called, and therefore an IllegalArgumentException is thrown.
	 * 
	 * @param selection the current selection made
	 * @return the valid EObject made from the selection
	 * @throws IllegalArgumentException if selection failed or no EObject is selected
	 */
	private EObject validateSelection(ISelection selection) {
		if(selection != null && selection instanceof IStructuredSelection) {
			IStructuredSelection strucSel = (IStructuredSelection) selection;
			Object selectedElement = strucSel.getFirstElement();
			if(selectedElement instanceof ProjectSpace)
				return ((ProjectSpace) selectedElement).getProject();
			else if(selectedElement instanceof EObject)
				return (EObject) selectedElement;
			else throw new IllegalArgumentException("No EObject selected!");
		} else throw new IllegalArgumentException("Selection Error!");
	}

}
