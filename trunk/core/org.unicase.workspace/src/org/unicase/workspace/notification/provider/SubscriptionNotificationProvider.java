/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.notification.provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.notification.NotificationFactory;
import org.unicase.emfstore.esmodel.util.EsModelUtil;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.organization.User;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.exceptions.CannotMatchUserInProjectException;
import org.unicase.workspace.notification.NotificationProvider;
import org.unicase.workspace.preferences.DashboardKey;
import org.unicase.workspace.preferences.PreferenceManager;
import org.unicase.workspace.util.NoCurrentUserException;
import org.unicase.workspace.util.OrgUnitHelper;

/**
 * Provides notifications for subscribed MEs.
 * 
 * @author shterev
 */
public class SubscriptionNotificationProvider implements NotificationProvider {

	private ArrayList<ESNotification> result;
	private List<EObject> subscriptionIds;
	private User user;

	/**
	 * The name.
	 */
	public static final String NAME = "Subscription Notification Provider";

	/**
	 * Default constructor.
	 */
	public SubscriptionNotificationProvider() {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#getName()
	 */
	public String getName() {
		return NAME;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#provideNotifications(org.unicase.workspace.ProjectSpace,
	 *      java.util.List, java.lang.String)
	 */
	public List<ESNotification> provideNotifications(ProjectSpace projectSpace, List<ChangePackage> changePackages,
		String currentUsername) {
		result = new ArrayList<ESNotification>();
		OrgUnitProperty property = PreferenceManager.INSTANCE.getProperty(projectSpace, DashboardKey.SUBSCRIPTIONS);
		subscriptionIds = Arrays.asList(property.getEObjectArrayProperty());
		if (subscriptionIds.isEmpty()) {
			return result;
		}
		try {
			user = OrgUnitHelper.getUser(projectSpace);
		} catch (NoCurrentUserException e) {
			return result;
		} catch (CannotMatchUserInProjectException e) {
			return result;
		}

		if (projectSpace == null || user == null) {
			return result;
		}

		if (!projectSpace.hasProperty(DashboardKey.SUBSCRIPTIONS)) {
			return result;
		}
		for (ChangePackage changePackage : changePackages) {
			for (AbstractOperation operation : changePackage.getOperations()) {
				if (operation instanceof CompositeOperation) {
					for (AbstractOperation op : ((CompositeOperation) operation).getSubOperations()) {
						handleOperation(projectSpace, op);
					}
				} else if (operation instanceof CreateDeleteOperation) {
					for (AbstractOperation op : ((CreateDeleteOperation) operation).getSubOperations()) {
						handleOperation(projectSpace, op);
					}
				} else {
					handleOperation(projectSpace, operation);
				}
			}
		}
		return result;
	}

	private void handleOperation(ProjectSpace projectSpace, AbstractOperation op) {

		if (subscriptionIds.contains(op.getModelElementId())) {
			createOperation(projectSpace, op.getModelElementId(), op);
		} else if (op instanceof ReferenceOperation) {
			ReferenceOperation rop = (ReferenceOperation) op;
			for (ModelElementId mid : rop.getAllInvolvedModelElements()) {
				if (subscriptionIds.contains(mid)) {
					createOperation(projectSpace, op.getModelElementId(), rop);
				}
			}
		}
	}

	private void createOperation(ProjectSpace projectSpace, ModelElementId mid, AbstractOperation op) {
		ModelElement modelElement = projectSpace.getProject().getModelElement(mid);
		if (modelElement == null) {
			return;
		}
		ESNotification notification = NotificationFactory.eINSTANCE.createESNotification();
		notification.setName("Subscriptions");
		notification.setProject(EsModelUtil.clone(projectSpace.getProjectId()));
		notification.setRecipient(user.getName());
		notification.setSeen(false);
		notification.setProvider(getName());
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("An element on your watch list has changed: ");
		stringBuilder.append(NotificationHelper.getHTMLLinkForModelElement(modelElement, projectSpace));
		notification.setMessage(stringBuilder.toString());
		notification.setCreationDate(op.getClientDate());
		notification.getRelatedOperations().add(op.getOperationId());
		notification.getRelatedModelElements().add(mid);
		result.add(notification);
	}
}
