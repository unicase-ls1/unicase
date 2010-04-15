package org.unicase.ui.navigator.handler;

import library.Library;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.util.UnicaseCommand;

/*
 * Changes name of first library to 'foo'
 */
public class ChangeAttributeHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final ProjectSpace projectSpace = ActionHelper.getProjectSpace(event);
		if (projectSpace == null) {
			return null;
		}
		if (true) {
			new UnicaseCommand() {

				@Override
				protected void doRun() {
					EList<EObject> models = projectSpace.getProject().getModelElements();
					if (models.size() > 0) {
						Library lib = (Library) models.get(0);
						lib.setName("foo " + System.currentTimeMillis());
					}
				}
			}.run();
		}

		return null;
	}

}
