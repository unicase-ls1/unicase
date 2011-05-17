
package org.unicase.ui.toolbarbutton;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.unicase.ui.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.metamodel.Project;
import org.unicase.model.task.*;



/**
 * . This is the handler to add a new Document to a ProjectSpace
 * 
 * @author Engelmann
 */
public class CreateActionItemHandler extends AbstractHandler {

	/**
	 * . {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		EObject eObject = ActionHelper.getSelection(event);
		if (!(eObject instanceof ProjectSpace)) {
			return null;
		}
		final ProjectSpace projectSpace = (ProjectSpace) eObject;

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				ActionItem item = TaskFactory.eINSTANCE.createActionItem();
				Project project = projectSpace.getProject();
				project.addModelElement(item);
				
			}
		}.run(true);

		return null;
	}

}
