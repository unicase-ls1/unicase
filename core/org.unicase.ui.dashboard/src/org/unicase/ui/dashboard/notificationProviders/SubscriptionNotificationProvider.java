/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard.notificationProviders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.notification.NotificationFactory;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.metamodel.util.SerializationException;
import org.unicase.model.UnicaseModelElement;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.preferences.DashboardKey;
import org.unicase.workspace.preferences.PreferenceManager;

/**
 * Provides notifications for subscribed MEs.
 * 
 * @author shterev
 */
public class SubscriptionNotificationProvider extends
		AbstractNotificationProvider {

	private ArrayList<ESNotification> result;
	private List<EObject> subscriptionIds;

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
	@Override
	public List<ESNotification> provideNotifications(ProjectSpace projectSpace,
			List<ChangePackage> changePackages, String currentUsername) {
		result = new ArrayList<ESNotification>();
		OrgUnitProperty property = PreferenceManager.INSTANCE.getProperty(
				projectSpace, DashboardKey.SUBSCRIPTIONS);
		
		subscriptionIds = new ArrayList<EObject>();
		try {
			EObject[] arrayProperty = property.getEObjectArrayProperty();
			subscriptionIds.addAll(Arrays.asList(arrayProperty));
		}
		catch (SerializationException e) {
			//ignore but log
			ModelUtil.logException("Subscription Ids could not be collected!", e);
		}
		if (subscriptionIds.isEmpty()) {
			return result;
		}
		return super.provideNotifications(projectSpace, changePackages,
				currentUsername);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.dashboard.notificationProviders.AbstractNotificationProvider#handleOperation(org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation)
	 */
	@Override
	protected void handleOperation(AbstractOperation op) {

		if (subscriptionIds.contains(op.getModelElementId())) {
			createOperation(op.getModelElementId(), op);
		} else if (op instanceof ReferenceOperation) {
			ReferenceOperation rop = (ReferenceOperation) op;
			for (ModelElementId mid : rop.getAllInvolvedModelElements()) {
				if (subscriptionIds.contains(mid)) {
					createOperation(op.getModelElementId(), rop);
				}
			}
		}
	}

	private void createOperation(ModelElementId mid, AbstractOperation op) {
		ModelElement modelElement = getProjectSpace().getProject()
				.getModelElement(mid);
		if (modelElement == null
				|| !(modelElement instanceof UnicaseModelElement)) {
			return;
		}
		UnicaseModelElement unicaseModelElement = (UnicaseModelElement) modelElement;
		getExcludedOperations().add(op.getOperationId());
		ESNotification notification = NotificationFactory.eINSTANCE
				.createESNotification();
		notification.setName("Subscriptions");
		notification.setProject(ModelUtil.clone(getProjectSpace()
				.getProjectId()));
		notification.setRecipient(getUser().getName());
		notification.setSeen(false);
		notification.setProvider(getName());
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("An element on your watch list has changed: ");
		stringBuilder.append(NotificationHelper.getHTMLLinkForModelElement(
				unicaseModelElement, getProjectSpace()));
		notification.setMessage(stringBuilder.toString());
		notification.setCreationDate(op.getClientDate());
		notification.getRelatedOperations().add(op.getOperationId());
		notification.getRelatedModelElements().add(mid);
		result.add(notification);
	}

	/**
	 * {@inheritDoc}
	 */
	public DashboardKey getKey() {
		return DashboardKey.SUBSCRIPTION_PROVIDER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected List<ESNotification> createNotifications() {
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.dashboard.notificationProviders.AbstractNotificationProvider#init()
	 */
	@Override
	protected void init() {
		super.init();
		result.clear();
	}

}
