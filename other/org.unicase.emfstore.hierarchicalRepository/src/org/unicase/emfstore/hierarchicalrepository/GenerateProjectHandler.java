package org.unicase.emfstore.hierarchicalrepository;
import library.Library;
import library.LibraryFactory;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.metamodel.Project;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.ui.commands.ServerRequestCommandHandler;

public class GenerateProjectHandler extends  AbstractHandler {

		public Object execute(ExecutionEvent event) throws ExecutionException {
		// show compare dialog
		ProjectSpace projSpace = WorkspaceManager.getInstance()
		.getCurrentWorkspace().getActiveProjectSpace();

		Project project = projSpace.getProject();
		Library library = LibraryFactory.eINSTANCE.createLibrary();
		
		
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		InputDialog inputDialog = new InputDialog(shell,
				"Model Site", "Enter the required site:", "", null);
		if (inputDialog.open() != Window.OK) {
			return null;
		}
		int size = 0;
		try {
			size = Integer.parseInt(inputDialog.getValue());
		} catch (NumberFormatException e) {
			MessageDialog.openError(shell, "Invalid input",
					"A numerical value was expected!");
			return null;
		}
		
		for (int i = 0; i < size; i++) {
			library.getBooks().add((LibraryFactory.eINSTANCE.createBook()));
		}
		
		project.addModelElement(library);
		
		return null;
	}

}
