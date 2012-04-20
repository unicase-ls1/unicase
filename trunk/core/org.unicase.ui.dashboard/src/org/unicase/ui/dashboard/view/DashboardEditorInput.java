/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.server.model.notification.ESNotification;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.unicase.ui.dashboard.Activator;

/**
 * The editor input for the dashboard.
 * 
 * @author Shterev
 */
public class DashboardEditorInput implements IEditorInput {

	private ProjectSpace projectSpace;

	/**
	 * Default constructor.
	 * 
	 * @param ps the projectSpace
	 */
	public DashboardEditorInput(ProjectSpace ps) {
		super();
		this.projectSpace = ps;
	}

	/**
	 * Custom equals() for this class.
	 * 
	 * @param obj the compared object.
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
	public List<ESNotification> getNotifications() {

		List<ESNotification> originalNotifications = projectSpace.getNotificationsFromComposite();
		ArrayList<ESNotification> notifications = new ArrayList<ESNotification>(originalNotifications);
		Collections.sort(notifications, new Comparator<ESNotification>() {
			public int compare(ESNotification arg0, ESNotification arg1) {
				if (arg0 == null) {
					return 1;
				}
				if (arg1 == null) {
					return -1;
				}
				return (arg0.getCreationDate().after(arg1.getCreationDate()) ? -1 : 1);
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
