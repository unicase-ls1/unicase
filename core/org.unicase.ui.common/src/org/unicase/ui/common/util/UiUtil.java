/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.common.util;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.roles.Role;
import org.unicase.metamodel.Project;
import org.unicase.ui.common.dialogs.ErrorReportDialog;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;

/**
 * Utility class for the unicase project.
 * 
 * @author shterev
 * @author hodaie
 * @author denglerm
 */
public final class UiUtil {

	private UiUtil() {
		// do nothing
	}

	/**
	 * . This shows a standard dialog with some given initial contents to select model elements.
	 * 
	 * @param shell shell
	 * @param initialContent initilaContents
	 * @param title title
	 * @param multiSelection if multiSelection is allowed
	 * @return The selected objects
	 */
	// ZH Why does this return Objects?:
	public static Object[] showMESelectionDialog(Shell shell, Collection<?> initialContent, String title,
		boolean multiSelection) {

		ElementListSelectionDialog dlg = new ElementListSelectionDialog(shell.getShell(),
			new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));

		dlg.setElements(initialContent.toArray(new Object[initialContent.size()]));
		dlg.setTitle(title);
		dlg.setBlockOnOpen(true);
		dlg.setMultipleSelection(multiSelection);
		Object[] result = new Object[0];
		if (dlg.open() == Window.OK) {
			result = dlg.getResult();
		}
		return result;
	}

	/**
	 * Shows a list of all MEs of meType in project.
	 * 
	 * @param shell shell
	 * @param meType model element type
	 * @param project project
	 * @param multiSelection if multiple elements can be selected
	 * @return selected elements
	 */
	public static Object[] showMESelectionDialog(Shell shell, EClass meType, Project project, boolean multiSelection) {
		List<? extends EObject> elements = project.getAllModelElementsbyClass(meType, new BasicEList<EObject>());
		return showMESelectionDialog(shell, elements, "Select " + meType.getName(), multiSelection);
	}

	/**
	 * This checks a user session for project administrator rights. If there is no session, the user is project admin.
	 * 
	 * @param session User session to check
	 * @param projectSpace ProjectSpace
	 * @return true if user has project administrator rights
	 */
	public static boolean isProjectAdmin(Usersession session, ProjectSpace projectSpace) {
		if (session == null) {
			return true;
		}
		ACUser user = session.getACUser();
		List<Role> roles = user.getRoles();
		for (Role role : roles) {
			if (role.canAdministrate(projectSpace.getProjectId())) {
				return true;
			}
		}

		return false;
	}

	/**
	 * @param status status
	 */
	public static void showReportErrorDialog(IStatus status) {
		ErrorReportDialog dialog = new ErrorReportDialog(Display.getCurrent().getActiveShell(), status);
		dialog.open();

	}

	private static AdapterFactoryLabelProvider labelProvider;

	/**
	 * Get the name of a model element.
	 * 
	 * @param modelElement the model element
	 * @return the name for the model element
	 */
	public static String getNameForModelElement(EObject modelElement) {
		if (labelProvider == null) {
			labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		}
		return labelProvider.getText(modelElement);
	}

}
