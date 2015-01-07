/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard.notificationProviders;

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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.internal.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.internal.client.model.util.WorkspaceUtil;
import org.eclipse.emf.emfstore.internal.common.model.ModelElementId;
import org.eclipse.emf.emfstore.internal.common.model.util.ModelUtil;
import org.unicase.dashboard.DashboardNotification;
import org.unicase.model.UnicaseModelElement;

/**
 * This class offer helper methods for notifications.
 * 
 * @author helming
 */
public final class NotificationHelper {

	private NotificationHelper() {

	}

	/**
	 * Generates notifications from a list of changes for a certain project space.
	 * 
	 * @param projectSpace the project space to generate notifications for
	 * @param changePackages the changes to generate notifications from
	 * @return all generated notifications as a list
	 */
	public static List<DashboardNotification> generateNotifications(ProjectSpace projectSpace,
		List<ChangePackage> changePackages) {

		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.dashboard.notification.providers");

		final List<NotificationProvider> providers = new ArrayList<NotificationProvider>(config.length);
		final Map<NotificationProvider, Integer> providersByPriority = new HashMap<NotificationProvider, Integer>();

		for (IConfigurationElement e : config) {
			Object o;
			try {
				o = e.createExecutableExtension("class");
				if (o instanceof NotificationProvider) {
					NotificationProvider provider = (NotificationProvider) o;
					String priority = e.getAttribute("priority");
					try {
						providersByPriority.put(provider, new Integer(priority));
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
		providers.addAll(providersByPriority.keySet());
		Collections.sort(providers, new Comparator<NotificationProvider>() {
			public int compare(NotificationProvider arg0, NotificationProvider arg1) {
				return providersByPriority.get(arg0).compareTo(providersByPriority.get(arg1));
			}
		});

		return generateNotificationsByProvider(projectSpace, providers, changePackages);
	}

	/**
	 * Generates notifications from a list of changes using notifications providers for a certain project space.
	 * 
	 * @param projectSpace the project space to generate notifications for
	 * @param providers the providers to use to generate notifications
	 * @param changePackages the changes to generate notifications from
	 * @return all generated notifications as a list
	 */
	public static List<DashboardNotification> generateNotificationsByProvider(ProjectSpace projectSpace,
		List<NotificationProvider> providers, List<ChangePackage> changePackages) {

		List<DashboardNotification> result = new ArrayList<DashboardNotification>();

		String username = projectSpace.getUsersession().getUsername();

		if (changePackages == null || username == null) {
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

		Iterator<NotificationProvider> iterator = providers.iterator();

		NotificationProvider prev = null;
		while (iterator.hasNext()) {
			NotificationProvider current = iterator.next();

			current.getExcludedOperations().clear();
			if (prev != null) {
				current.getExcludedOperations().addAll(prev.getExcludedOperations());
			}
			try {
				List<DashboardNotification> provideNotifications = current.provideNotifications(projectSpace,
					changePackages, username);
				result.addAll(provideNotifications);
				prev = current;

				// BEGIN SUPRESS CATCH EXCEPTION
			} catch (RuntimeException e) {
				// END SUPRESS CATCH EXCEPTION
				WorkspaceUtil.logException("Notification Provider " + current.getName()
					+ " threw an exception, its notifications where discarded", e);
			}
		}

		return result;

	}

	/**
	 * Returns the latest date of a list of operations.
	 * 
	 * @param list a list of AbstractOperations
	 * @return the latest date.
	 */
	public static Date getLastDate(List<AbstractOperation> list) {
		Date date = null;
		for (AbstractOperation operation : list) {
			if (date == null) {
				date = operation.getClientDate();
			} else {
				Date newDate = operation.getClientDate();
				if (newDate.after(date)) {
					date = newDate;
				}

			}
		}
		if (date == null) {
			date = new Date();
		}
		return date;
	}

	/**
	 * This method create a HTML link pointing to a model element for the message of Notifications.
	 * 
	 * @param meId The id of the model element
	 * @param projectSpace the project space
	 * @param active if there should be an actual link, or just the name
	 * @return a HTML link as string
	 */
	public static String getHTMLLinkForModelElement(ModelElementId meId, ProjectSpace projectSpace, boolean active) {

		EObject modelElement = projectSpace.getProject().getModelElement(meId);
		if (modelElement != null && modelElement instanceof UnicaseModelElement) {
			UnicaseModelElement unicaseModelElement = (UnicaseModelElement) modelElement;
			if (active) {
				return getHTMLLinkForModelElement(unicaseModelElement, projectSpace);
			}
			return unicaseModelElement.getName();
		}
		return "(deleted element)";
	}

	/**
	 * This method create a HTML link pointing to a model element for the message of Notifications.
	 * 
	 * @param meId The id of the model element
	 * @param projectSpace the project space
	 * @return a HTML link as string
	 */
	public static String getHTMLLinkForModelElement(ModelElementId meId, ProjectSpace projectSpace) {
		return getHTMLLinkForModelElement(meId, projectSpace, true);
	}

	/**
	 * This method create a HTML link pointing to a model element for the message of Notifications.
	 * 
	 * @param modelElement The model element
	 * @param projectSpace the project space
	 * @return a HTML link as string
	 */
	public static String getHTMLLinkForModelElement(UnicaseModelElement modelElement, ProjectSpace projectSpace) {
		String label = "null";
		if (modelElement != null && modelElement.getName() != null) {
			label = modelElement.getName().replaceAll("\"", "\\'");
		}
		return getHTMLLinkForModelElement(modelElement, projectSpace, label);
	}

	/**
	 * This method create a HTML link pointing to a model element for the message of Notifications.
	 * 
	 * @param modelElement The model element
	 * @param projectSpace the project space
	 * @param label the link's label
	 * @return a HTML link as string
	 */
	public static String getHTMLLinkForModelElement(UnicaseModelElement modelElement, ProjectSpace projectSpace,
		String label) {
		if (modelElement == null) {
			return "";
		}
		if (label.length() > 53) {
			label = label.substring(0, 50) + " ...";
		}
		StringBuilder ret = new StringBuilder("<a href=\"emfstore://current:0/");
		ret.append(projectSpace.getProjectName());
		ret.append("%");
		ret.append(projectSpace.getProjectId().getId());
		ret.append("/");
		String name = "null";
		if (modelElement.getName() != null) {
			name = modelElement.getName().replaceAll("\"", "\\'");
		}
		ret.append(name);
		ret.append("%");
		ret.append(ModelUtil.getProject(modelElement).getModelElementId(modelElement).getId());
		ret.append("\">");
		ret.append(label);
		ret.append("</a>");
		return ret.toString();
	}

}
