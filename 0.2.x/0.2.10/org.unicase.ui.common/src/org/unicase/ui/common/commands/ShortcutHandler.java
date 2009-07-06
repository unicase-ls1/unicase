package org.unicase.ui.common.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * This is the (ShortcutCommand)-Handler to select Modelelements out of a list
 * of elements..
 * 
 * @author Hamid
 */

public class ShortcutHandler extends AbstractHandler implements IHandler {

	private Project project;
	private Shell shell;

	/**
	 * Default constructor.
	 */
	public ShortcutHandler() {
		shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		// HB: Check this on bigger screens.
		shell.setLocation(220, 135);
	}

	/**
	 * Opens a element selection dialog.
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ProjectSpace workspace = WorkspaceManager.getInstance()
				.getCurrentWorkspace().getActiveProjectSpace();
		project = workspace.getProject();
		if (project == null) {
			MessageDialog.openInformation(shell, "Info", "Select the Project");

		} else{
			List<ModelElement> modelElements = new ArrayList<ModelElement>();
			modelElements.addAll(project.getAllModelElements());
			showShortcutDialog(shell, modelElements, "select model element",
					"   Enter type name prefix or pattern   ( * , ? , or camel case )  ");
		}

		return null;
	}

	/**
	 * This shows a standard dialog with some given initial contents to select
	 * model elements.
	 * 
	 * @param shell The parent shell
	 * @param initialContent The list of model elements to select from
	 * @param title The title of the dialog
	 * @param message the message of the dialog
	 * @return The selected elements 
	 */
	public Object[] showShortcutDialog(Shell shell,
			Collection<?> initialContent, String title, String message) {

		// adapterFactory an adapter factory that yield adapters that
		// implement the various item label provider interfaces.

		ILabelProvider renderer = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		/**
		 * Creates a list selection dialog..
		 * 
		 * @param parent
		 *            the parent widget.
		 * @param renderer
		 *            the label renderer.
		 */

		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				shell.getShell(), renderer);
		Object[] items = initialContent.toArray(new Object[initialContent
				.size()]);
		dialog.setElements(items);

		dialog.setTitle(title);
		dialog.setBlockOnOpen(true);
		dialog.setMultipleSelection(false);
		dialog.setMessage(message);
		Object[] result = new Object[0];
		if (dialog.open() == Window.OK) {
			result = dialog.getResult();
		}
		/**
		 * modelelemnt to open
		 */
		ModelElement mod = (ModelElement) dialog.getFirstResult();
		ActionHelper.openModelElement(mod);
		return result;
	}

}
