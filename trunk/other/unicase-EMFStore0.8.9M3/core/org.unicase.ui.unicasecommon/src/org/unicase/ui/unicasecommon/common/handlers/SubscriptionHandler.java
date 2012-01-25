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
import org.eclipse.emf.compare.util.AdapterUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.utilities.CannotMatchUserInProjectException;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.exceptions.NoCurrentUserException;
import org.eclipse.emf.emfstore.client.model.preferences.DashboardKey;
import org.eclipse.emf.emfstore.client.model.preferences.PreferenceManager;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.model.accesscontrol.OrgUnitProperty;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;

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

		EObject eObject = UnicaseActionHelper.getEObject(event);

		if (eObject == null) {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Invalid model element",
				"Could not determine the active model element!");
			return null;
		}

		final ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(eObject);
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
		ModelElementId modelElementId = ModelUtil.getProject(eObject).getModelElementId(eObject);
		if (properties.contains(modelElementId)) {
			properties.remove(modelElementId);
			feedback = " removed from ";
		} else {
			properties.add(modelElementId);
			feedback = " added to ";
		}

		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				PreferenceManager.INSTANCE.setProperty(projectSpace, DashboardKey.SUBSCRIPTIONS,
					properties.toArray(new EObject[0]));
			}
		}.run();

		// TODO fix label provider
		MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Subscription",
			AdapterUtils.getItemProviderText(eObject) + " was successfully" + feedback + "your subscriptions");
		return null;
	}
}
