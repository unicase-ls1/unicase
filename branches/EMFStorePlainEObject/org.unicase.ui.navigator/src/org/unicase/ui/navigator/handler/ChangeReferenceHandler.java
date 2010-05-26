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

public class ChangeReferenceHandler extends AbstractHandler {

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
					if (models.size() > 1) {
						Library lib = (Library) models.get(0);
						Library newLib = null;

						if (lib.getBooks().size() > 0) {
							newLib = (Library) models.get(1);
							newLib.getBooks().addAll(lib.getBooks());
							newLib.getBooks().get(0).eContainer();
							// Book b1 = LibraryFactory.eINSTANCE.createBook();
							// b1.setTitle("a");
							// Book b2 = LibraryFactory.eINSTANCE.createBook();
							// b2.setTitle("b");
							// newLib.getBooks().add(b1);
							// newLib.getBooks().add(b2);
						}

						/*
						 * library.Library library = LibraryFactory.eINSTANCE.createLibrary();
						 * projectSpace.getProject().addModelElement(library); library.setName("hans"); Book book =
						 * LibraryFactory.eINSTANCE.createBook(); book.setTitle("mofut"); library.getBooks().add(book);
						 */
					}
				}
			}.run();
		}

		return null;
	}

}
