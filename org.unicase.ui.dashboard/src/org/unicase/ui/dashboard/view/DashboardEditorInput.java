/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.emfstore.internal.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.internal.client.properties.PropertyManager;
import org.eclipse.emf.emfstore.internal.common.model.EMFStoreProperty;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.unicase.dashboard.DashboardNotification;
import org.unicase.dashboard.DashboardNotificationComposite;
import org.unicase.dashboard.util.DashboardPropertyKeys;
import org.unicase.ui.dashboard.Activator;

/**
 * The editor input for the dashboard.
 * 
 * @author Shterev
 */
public class DashboardEditorInput implements IEditorInput {

	private org.eclipse.emf.emfstore.internal.client.model.ProjectSpace projectSpace;

	/**
	 * Default constructor.
	 * 
	 * @param ps
	 *            the projectSpace
	 */
	public DashboardEditorInput(ProjectSpace ps) {
		super();
		this.projectSpace = ps;
	}

	/**
	 * Custom equals() for this class.
	 * 
	 * @param obj
	 *            the compared object.
	 * @return the boolean state. {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DashboardEditorInput) {
			DashboardEditorInput other = (DashboardEditorInput) obj;
			boolean ret = getProjectSpace().equals(other.getProjectSpace());
			return ret;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean exists() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public ImageDescriptor getImageDescriptor() {
		return Activator.getImageDescriptor("/icons/dashboard.png");
	}

	/**
	 * {@inheritDoc}
	 */
	public String getName() {

		String projectName = getProjectSpace().getProjectName();
		if (projectName.length() > 15) {
			projectName = projectName.substring(0, 12) + "...";
		}
		return "Dashboard [" + projectName + "]";
	}

	/**
	 * {@inheritDoc}
	 */
	public IPersistableElement getPersistable() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getToolTipText() {
		return getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapter) {
		return null;
	}

	/**
	 * @return the list of all notifications in the current project space.
	 */
	public List<DashboardNotification> getNotifications() {

		PropertyManager propertyManager = projectSpace.getPropertyManager();
		EMFStoreProperty property = propertyManager
				.getLocalProperty(DashboardPropertyKeys.NOTIFICATION_COMPOSITE);

		if (property == null) {
			return Collections.emptyList();
		}

		DashboardNotificationComposite notificationComposite = (DashboardNotificationComposite) property
				.getValue();

		List<DashboardNotification> originalNotifications = notificationComposite
				.getNotifications();
		ArrayList<DashboardNotification> notifications = new ArrayList<DashboardNotification>(
				originalNotifications);
		Collections.sort(notifications,
				new Comparator<DashboardNotification>() {
					public int compare(DashboardNotification arg0,
							DashboardNotification arg1) {
						if (arg0 == null) {
							return 1;
						}
						if (arg1 == null) {
							return -1;
						}
						return (arg0.getCreationDate().after(
								arg1.getCreationDate()) ? -1 : 1);
					}
				});
		return notifications;
	}

	/**
	 * @return the projectSpace
	 */
	public ProjectSpace getProjectSpace() {
		return projectSpace;
	}
}
