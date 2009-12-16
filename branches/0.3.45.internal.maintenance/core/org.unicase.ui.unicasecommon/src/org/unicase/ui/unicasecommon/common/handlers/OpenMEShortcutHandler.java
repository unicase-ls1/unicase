/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.handlers;

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
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.NonDomainElement;
import org.unicase.metamodel.Project;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * This is the (ShortcutCommand)-Handler to select model elements out of a list of elements.
 * 
 * @author Hamid
 */

public class OpenMEShortcutHandler extends AbstractHandler implements IHandler {

	private Project project;

	private static final String DIALOG_MESSAGE = "Enter model element name prefix or pattern (e.g. *Trun?)";

	/**
	 * Default constructor.
	 */
	public OpenMEShortcutHandler() {

	}

	/**
	 * Opens a element selection dialog. {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		ProjectSpace projectSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace();

		if (projectSpace == null) {
			MessageDialog.openInformation(shell, "Information", "You must select the Project");
		} else {

			project = projectSpace.getProject();
			List<ModelElement> modelElements = new ArrayList<ModelElement>();
			modelElements.addAll(project.getAllModelElements());
			// Remove Non Domain Elements
			List<ModelElement> filteredModelElements = new ArrayList<ModelElement>();
			for (ModelElement me : modelElements) {
				if (!(me instanceof NonDomainElement)) {
					filteredModelElements.add(me);
				}
			}
			showShortcutDialog(shell, filteredModelElements, "Search Model Element", DIALOG_MESSAGE);
		}

		return null;
	}

	/**
	 * This shows a standard dialog with some given initial contents to select model elements.
	 * 
	 * @param shell The parent shell
	 * @param initialContent The list of model elements to select from
	 * @param title The title of the dialog
	 * @param message the message of the dialog
	 * @return The selected elements
	 */
	public Object[] showShortcutDialog(Shell shell, Collection<?> initialContent, String title, String message) {

		// adapterFactory an adapter factory that yield adapters that
		// implement the various item label provider interfaces.

		ILabelProvider renderer = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(shell.getShell(), renderer);
		Object[] items = initialContent.toArray(new Object[initialContent.size()]);
		dialog.setElements(items);

		dialog.setTitle(title);
		dialog.setBlockOnOpen(true);
		dialog.setMultipleSelection(false);
		dialog.setMessage(message);
		Object[] result = new Object[0];
		if (dialog.open() == Window.OK) {
			result = dialog.getResult();
		}

		ModelElement mod = (ModelElement) dialog.getFirstResult();
		if (mod != null) {
			ActionHelper.openModelElement(mod, "org.unicase.ui.OpenMEShortcut");
		}
		return result;
	}

}
