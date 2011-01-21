package org.unicase.unicase.modelgenerator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.modelchanger.ModelChanger;
import org.unicase.modelgenerator.common.ModelGeneratorConfiguration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Handler for the "Generate Changes" context menu command.
 * The command is only available if an EObject is selected.
 * If the selected EObject is a ProjectSpace, the contained
 * Project is used as the root, otherwise the EObject itself
 * will be the root.
 */
public class GenerateChangesHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		final EObject rootObject = validateSelection(selection);
		
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				ModelGeneratorConfiguration config = new ModelGeneratorConfiguration(null, rootObject);
				ModelChanger.generateChanges(config);
			}
		}.run(false);

		return null;
	}
	
	/**
	 * Validates selection in terms of checking what's selected:<br>
	 * - throws IllegalArgumentException if no EObject is selected
	 * - if a ProjectSpace is selected, returns the contained Project
	 * - if any other EObject is selected, returns this EObject
	 * 
	 * @param selection the selection made in the navigator
	 * @return the valid EObject
	 */
	private EObject validateSelection(ISelection selection) {
		if(selection != null && selection instanceof IStructuredSelection) {
			IStructuredSelection strucSel = (IStructuredSelection) selection;
			Object selectedElement = strucSel.getFirstElement();
			if(selectedElement instanceof ProjectSpace)
				return ((ProjectSpace) selectedElement).getProject();
			else if(selectedElement instanceof EObject)
				return (EObject) selectedElement;
			else throw new IllegalArgumentException("Selected Element is no EObject!");
		} else throw new IllegalArgumentException("Nothing is selected!");
	}
}
