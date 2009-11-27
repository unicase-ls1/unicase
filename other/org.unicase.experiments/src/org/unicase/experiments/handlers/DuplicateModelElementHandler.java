package org.unicase.experiments.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.experiments.commands.DuplicateModelElementCommand;

/**
 * Handler to duplicate model elements. It handles button clicks on top
 * right side of the MEEditor.The button has a tool-tip "Duplicate Action Item".
 * 
 * @author fxulusoy
 */
public class DuplicateModelElementHandler extends AbstractHandler {


	public Object execute(ExecutionEvent event) throws ExecutionException {
		ModelElement me = ActionHelper.getModelElement(event);
		if (me == null) {
			return null;
		}

		duplicateModelElement(me);

		return null;
	}
	
	/**
	 * Duplicates the given model element. It delegates the job 
	 * to duplicate model element command.
	 * 
	 * @param me model element to be duplicated
	 */
	private void duplicateModelElement(final ModelElement me) {
		new DuplicateModelElementCommand(me).run();
	}

}
