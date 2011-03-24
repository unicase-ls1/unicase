/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.model.notification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.preferences.PreferenceManager;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.events.EventsFactory;
import org.unicase.emfstore.esmodel.versioning.events.NotificationGenerationEvent;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.metamodel.util.ModelUtil;

/**
 * Singleton class to generate notifications from change packages.
 * 
 * @author koegel
 * @author shterev
 */
public final class NotificationGenerator {

	private static HashMap<ProjectSpace, NotificationGenerator> instances;

	private ProjectSpace projectSpace;

	private ArrayList<NotificationProvider> allProviders;

	/**
	 * Constructor.
	 * 
	 * @param projectSpace the project space.
	 */
	private NotificationGenerator(ProjectSpace projectSpace) {
		this.projectSpace = projectSpace;

		allProviders = new ArrayList<NotificationProvider>();
		final HashMap<NotificationProvider, Integer> allProvidersMap = new HashMap<NotificationProvider, Integer>();
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.workspace.notification.providers");

		// get all providers from the extension points
		for (IConfigurationElement e : config) {
			Object o;
			try {
				o = e.createExecutableExtension("class");
				if (o instanceof NotificationProvider) {
					NotificationProvider provider = (NotificationProvider) o;
					String position = e.getAttribute("priority");
					try {
						allProvidersMap.put(provider, new Integer(position));
					} catch (NumberFormatException ex) {
						WorkspaceUtil.logException(
							"Wrong priority parameter for NotificationProvider: " + provider.getName(), ex);
					}
				}
			} catch (CoreException e1) {
				WorkspaceUtil.logException(e1.getMessage(), e1);
			}
		}

		// sort the providers
		allProviders.addAll(allProvidersMap.keySet());
		Collections.sort(allProviders, new Comparator<NotificationProvider>() {
			public int compare(NotificationProvider arg0, NotificationProvider arg1) {
				return allProvidersMap.get(arg0).compareTo(allProvidersMap.get(arg1));
			}
		});
	}

	/**
	 * @return the providers that are currently activated in the settings
	 */
	private List<NotificationProvider> getActiveProviders() {
		ArrayList<NotificationProvider> providers = new ArrayList<NotificationProvider>();
		for (NotificationProvider provider : allProviders) {
			OrgUnitProperty property = PreferenceManager.INSTANCE.getProperty(projectSpace, provider.getKey());
			if (property.getBooleanProperty()) {
				providers.add(provider);
			}
		}
		return providers;
	}

	/**
	 * Get the instance of the {@link NotificationGenerator} singleton.
	 * 
	 * @param projectSpace the projetspace
	 * @return the singleton instance
	 */
	public static NotificationGenerator getInstance(ProjectSpace projectSpace) {
		if (instances == null) {
			instances = new HashMap<ProjectSpace, NotificationGenerator>();
		}
		NotificationGenerator notificationGenerator = instances.get(projectSpace);
		if (notificationGenerator == null) {
			notificationGenerator = new NotificationGenerator(projectSpace);
			instances.put(projectSpace, notificationGenerator);
		}
		return notificationGenerator;
	}

	/**
	 * Generate notifications for a list of change packages. Will also generate an event for the generated
	 * notifications.
	 * 
	 * @param changePackages a list of change packages
	 * @param currentUsername the name of the current user
	 * @return a list of notification
	 */
	public List<ESNotification> generateNotifications(List<ChangePackage> changePackages, String currentUsername) {
		return generateNotifications(changePackages, currentUsername, true);
	}

	/**
	 * Generate notifications for a list of change packages.
	 * 
	 * @param changePackages a list of change packages
	 * @param currentUsername the name of the current user
	 * @param createGenerationEvent true if an event should be generated about the notifications
	 * @return a list of notification
	 */
	public List<ESNotification> generateNotifications(List<ChangePackage> changePackages, String currentUsername,
		boolean createGenerationEvent) {
		List<ESNotification> result = new ArrayList<ESNotification>();

		Map<NotificationProvider, List<ESNotification>> generateNotificationsByProvider = generateNotificationsByProvider(
			changePackages, currentUsername, createGenerationEvent);

		for (List<ESNotification> esNotifications : generateNotificationsByProvider.values()) {
			result.addAll(esNotifications);
		}

		return result;
	}

	/**
	 * Generate notifications for a list of change packages, grouped by the notification provider.
	 * 
	 * @param changePackages a list of change packages
	 * @param currentUsername the name of the current user
	 * @param createGenerationEvent true if an event should be generated about the notifications
	 * @return a list of notification
	 */
	public Map<NotificationProvider, List<ESNotification>> generateNotificationsByProvider(
		List<ChangePackage> changePackages, String currentUsername, boolean createGenerationEvent) {

		Map<NotificationProvider, List<ESNotification>> result = new HashMap<NotificationProvider, List<ESNotification>>();

		if (changePackages == null || currentUsername == null) {
			return result;
		}

		// rectify client date if neccessary
		for (ChangePackage changePackage : changePackages) {
			for (AbstractOperation operation : changePackage.getOperations()) {
				if (operation.getClientDate() == null) {
					operation.setClientDate(changePackage.getLogMessage().getDate());
				}
			}
		}

		List<NotificationProvider> activeProviders = getActiveProviders();
		Iterator<NotificationProvider> iterator = activeProviders.iterator();
		NotificationProvider prev = null;
		while (iterator.hasNext()) {
			NotificationProvider current = iterator.next();
			result.put(current, new ArrayList<ESNotification>());

			current.getExcludedOperations().clear();
			if (prev != null) {
				current.getExcludedOperations().addAll(prev.getExcludedOperations());
			}
			try {
				List<ESNotification> provideNotifications = current.provideNotifications(projectSpace, changePackages,
					currentUsername);
				result.get(current).addAll(provideNotifications);
				prev = current;

				// BEGIN SUPRESS CATCH EXCEPTION
			} catch (RuntimeException e) {
				// END SUPRESS CATCH EXCEPTION
				WorkspaceUtil.logException("Notification Provider " + current.getName()
					+ " threw an exception, its notifications where discarded", e);
			}
		}

		// create a notification generation event
		if (createGenerationEvent) {
			NotificationGenerationEvent generationEvent = EventsFactory.eINSTANCE.createNotificationGenerationEvent();
			generationEvent.setTimestamp(new Date());
			for (List<ESNotification> notificationList : result.values()) {
				for (ESNotification notification : notificationList) {
					ESNotification clone = ModelUtil.clone(notification);
					generationEvent.getNotifications().add(clone);
				}
			}
			projectSpace.addEvent(generationEvent);
		}
		return result;

	}
}
