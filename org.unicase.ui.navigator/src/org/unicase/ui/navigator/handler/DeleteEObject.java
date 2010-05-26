package org.unicase.ui.navigator.handler;

import library.Book;
import library.Library;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.util.UnicaseCommand;

public class DeleteEObject extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final ProjectSpace projectSpace = ActionHelper.getProjectSpace(event);
		if (projectSpace == null) {
			return null;
		}

		EList<EObject> models = projectSpace.getProject().getAllModelElements();

		if (true) {
			new UnicaseCommand() {

				@Override
				protected void doRun() {
					EList<EObject> models = projectSpace.getProject().getAllModelElementsAsList();

					if (models.size() > 0) {

						for (EObject o : models) {

							if (o instanceof Library) {
								Library library = (Library) o;
								if (library.getBooks().size() > 0) {
									Book b = library.getBooks().get(0);
									projectSpace.getProject().deleteModelElement(b);
								}
							}
						}

					}
				}
			}.run();

		}

		return null;
	}
}
