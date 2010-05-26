package org.unicase.ui.navigator.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.util.UnicaseCommand;

public class DeleteLibraryHandler extends AbstractHandler {

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
					EList<EObject> models = projectSpace.getProject().getAllModelElements();

					if (models.size() > 0) {
						Project project = projectSpace.getProject();
						ModelElementId wrapper = project.getModelElementId(models.get(0));
						project.deleteModelElement(wrapper);
					}
				}
			}.run();
			return null;
		}

		return null;
	}

}
