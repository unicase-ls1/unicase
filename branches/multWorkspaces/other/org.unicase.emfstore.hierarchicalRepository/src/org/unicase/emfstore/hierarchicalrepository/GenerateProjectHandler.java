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
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommandWithParameterAndResult;

public class GenerateProjectHandler extends  AbstractHandler {

		public Object execute(ExecutionEvent event) throws ExecutionException {
		// show compare dialog
		ProjectSpace projSpace = WorkspaceManager.getInstance()
		.getCurrentWorkspace().getActiveProjectSpace();

		final Project project = projSpace.getProject();
		Library rootlibrary = LibraryFactory.eINSTANCE.createLibrary();
		
		
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		InputDialog inputDialog = new InputDialog(shell,
				"Model Site", "Enter the required total size:", "", null);
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
		
		InputDialog inputDialog2 = new InputDialog(shell,
				"Model Site", "Enter the required branching factor:", "", null);
		if (inputDialog2.open() != Window.OK) {
			return null;
		}
		int factor = 0;
		try {
			factor = Integer.parseInt(inputDialog2.getValue());
		} catch (NumberFormatException e) {
			MessageDialog.openError(shell, "Invalid input",
					"A numerical value was expected!");
			return null;
		}
		
		
		
		//create a struture with given branching factor and total size
		
		int remainder = size;
		while (remainder>factor) {
			remainder = remainder / factor;
			//increase existing instances by factor "factor"
			Library newRoot = LibraryFactory.eINSTANCE.createLibrary();
			
			for (int i=0; i<factor-1; i++) {
				newRoot.getIncludedLibraries().add(ModelUtil.copy(rootlibrary));
			}
			newRoot.getIncludedLibraries().add(rootlibrary);
			rootlibrary = newRoot;
		}
		
		//increase existing instance by remainder
		Library newRoot = LibraryFactory.eINSTANCE.createLibrary();
		
		for (int i=0; i<remainder-1; i++) {
			newRoot.getIncludedLibraries().add(ModelUtil.copy(rootlibrary));
		}
		newRoot.getIncludedLibraries().add(rootlibrary);
		rootlibrary = newRoot;
		
		new UnicaseCommandWithParameterAndResult<Project, Library>() {

			@Override
			protected Project doRun(Library parameter) {
				project.addModelElement(parameter);
				return project;
			}
		}.run(rootlibrary);
		
		
		int actualSize = project.getAllModelElements().size();
		
		MessageDialog.openInformation(null, "Generation completed.", "Generated " + actualSize + " model elements");
		return null;
		
	}

}
