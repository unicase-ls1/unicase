/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dashboard;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.workspace.ProjectSpace;

/**
 * Abstract class for all dashboard entry types.
 * 
 * @author Shterev
 */
public abstract class AbstractDashboardEntry extends Composite {

	private ESNotification n;
	private ProjectSpace project;
	private DashboardPage page;

	/**
	 * Default constructor.
	 * 
	 * @param parent the parent composite.
	 * @param style the style.
	 * @param notification the notification.
	 * @param project the project.
	 * @param page a back link to the dashboard page (needed only for layout purposes).
	 */
	public AbstractDashboardEntry(DashboardPage page, Composite parent, int style, ESNotification notification,
		ProjectSpace project) {
		super(parent, style);
		this.page = page;
		n = notification;
		this.project = project;
		this.setBackgroundMode(SWT.INHERIT_FORCE);
	}

	/**
	 * Creates the dashboard entry.
	 */
	protected void createEntry() {

	}

	/**
	 * @return the n
	 */
	protected ESNotification getNotification() {
		return n;
	}

	/**
	 * @return the project
	 */
	protected ProjectSpace getProjectSpace() {
		return project;
	}

	/**
	 * @return the page
	 */
	protected DashboardPage getPage() {
		return page;
	}

}
