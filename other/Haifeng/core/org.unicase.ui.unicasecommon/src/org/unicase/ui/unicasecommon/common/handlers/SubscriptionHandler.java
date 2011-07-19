/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.unicasecommon.common.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.common.util.CannotMatchUserInProjectException;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.preferences.DashboardKey;
import org.unicase.workspace.preferences.PreferenceManager;
import org.unicase.workspace.util.NoCurrentUserException;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * This is handler to subscribe the current user to a ModelElement.
 * 
 * @author Shterev
 */
public class SubscriptionHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		UnicaseModelElement modelElement = UnicaseActionHelper.getModelElement(event);

		if (modelElement == null) {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Invalid model element",
				"Could not determine the active model element!");
			return null;
		}

		final ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(modelElement);
		if (projectSpace == null) {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Invalid active project",
				"Could not determine the active project!");
			return null;
		}

		try {
			OrgUnitHelper.getUser(projectSpace);
		} catch (NoCurrentUserException e) {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Invalid user",
				"Could not determine the active user!");
			return null;
		} catch (CannotMatchUserInProjectException e) {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Invalid user",
				"Could not match your user in the project!");
			return null;
		}

		OrgUnitProperty property = PreferenceManager.INSTANCE.getProperty(projectSpace, DashboardKey.SUBSCRIPTIONS);

		final List<EObject> properties = property.getEObjectListProperty(new ArrayList<EObject>());

		String feedback;
		ModelElementId modelElementId = ModelUtil.getProject(modelElement).getModelElementId(modelElement);
		if (properties.contains(modelElementId)) {
			properties.remove(modelElementId);
			feedback = " removed from ";
		} else {
			properties.add(modelElementId);
			feedback = " added to ";
		}

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				PreferenceManager.INSTANCE.setProperty(projectSpace, DashboardKey.SUBSCRIPTIONS, properties
					.toArray(new EObject[0]));
			}
		}.run();

		// TODO fix label provider
		MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Subscription", modelElement.getName()
			+ " was successfully" + feedback + "your subscriptions");
		return null;
	}
}
