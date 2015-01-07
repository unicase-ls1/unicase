/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard.view;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.internal.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.internal.common.model.ModelElementId;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.unicase.dashboard.DashboardNotification;

/**
 * Abstract class for all dashboard entry types.
 * 
 * @author Shterev
 */
public abstract class AbstractDashboardEntry extends Composite {

	private DashboardNotification n;
	private ProjectSpace projectSpace;
	private DashboardPage page;
	private EObject firstModelElement;

	/**
	 * Default constructor.
	 * 
	 * @param parent the parent composite.
	 * @param style the style.
	 * @param notification the notification.
	 * @param projectSpace the project.
	 * @param page a back link to the dashboard page (needed only for layout purposes).
	 */
	public AbstractDashboardEntry(DashboardPage page, Composite parent, int style, DashboardNotification notification,
		ProjectSpace projectSpace) {
		super(parent, style);
		this.page = page;
		this.n = notification;
		this.projectSpace = projectSpace;
		this.setBackgroundMode(SWT.INHERIT_FORCE);
		if (notification.getRelatedModelElements().size() > 0) {
			ModelElementId modelElementId = notification.getRelatedModelElements().get(0);
			this.firstModelElement = projectSpace.getProject().getModelElement(modelElementId);
		}
	}

	/**
	 * Creates the dashboard entry.
	 */
	protected void createEntry() {

	}

	/**
	 * @return the n
	 */
	protected DashboardNotification getNotification() {
		return n;
	}

	/**
	 * @return the project
	 */
	protected ProjectSpace getProjectSpace() {
		return projectSpace;
	}

	/**
	 * @return the page
	 */
	protected DashboardPage getPage() {
		return page;
	}

	/**
	 * Since a lot of features (e.g. notification icon, presentation of comments, etc) depend on the ModelElements which
	 * the notification is based upon, it is useful to have a direct reference to this element. Because a list of
	 * elements can be provided (e.g. from the TaskNotificationProvider), we take the instance for the first element
	 * with the implicit contract that all elements in the notification are either of the same type or share a common
	 * supertype.
	 * 
	 * @return the first modelelement if it exists in the project
	 */
	protected EObject getFirstModelElement() {
		return firstModelElement;
	}
}
