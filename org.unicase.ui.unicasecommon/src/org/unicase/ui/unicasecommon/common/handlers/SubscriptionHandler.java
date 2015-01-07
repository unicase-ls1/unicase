/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.internal.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.internal.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.internal.client.properties.PropertyManager;
import org.eclipse.emf.emfstore.internal.common.model.EMFStoreProperty;
import org.eclipse.emf.emfstore.internal.common.model.ModelElementId;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.unicase.dashboard.DashboardFactory;
import org.unicase.dashboard.SubscriptionComposite;
import org.unicase.dashboard.util.DashboardPropertyKeys;
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

		final PropertyManager propertyManager = projectSpace.getPropertyManager();
		EMFStoreProperty property = propertyManager.getLocalProperty(DashboardPropertyKeys.SUBSCRIPTIONS);

		boolean contains;
		final SubscriptionComposite subscriptionComposite;
		final ModelElementId modelElementId = projectSpace.getProject().getModelElementId(eObject);
		if (property != null) {
			subscriptionComposite = (SubscriptionComposite) property.getValue();
			contains = subscriptionComposite.getSubscriptions().contains(modelElementId);
		} else {
			subscriptionComposite = DashboardFactory.eINSTANCE.createSubscriptionComposite();
			contains = false;
		}
		String feedback;
		EMFStoreCommand command;
		if (contains) {
			command = new EMFStoreCommand() {

				@Override
				protected void doRun() {
					subscriptionComposite.getSubscriptions().remove(modelElementId);
					propertyManager.setLocalProperty(DashboardPropertyKeys.SUBSCRIPTIONS, subscriptionComposite);
				}

			};

			feedback = " removed from ";
		} else {
			command = new EMFStoreCommand() {

				@Override
				protected void doRun() {
					subscriptionComposite.getSubscriptions().add(modelElementId);
					propertyManager.setLocalProperty(DashboardPropertyKeys.SUBSCRIPTIONS, subscriptionComposite);
				}

			};

			feedback = " added to ";
		}

		command.run(true);

		// TODO fix label provider
		MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Subscription",
			AdapterUtils.getItemProviderText(eObject) + " was successfully" + feedback + "your subscriptions");
		return null;
	}
}
