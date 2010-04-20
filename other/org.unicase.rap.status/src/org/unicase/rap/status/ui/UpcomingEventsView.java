/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.status.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.emf.common.notify.Notification;

import org.unicase.metamodel.Project;
import org.unicase.metamodel.ModelElement;
import org.unicase.rap.ui.views.ProjectAwareView;
import org.unicase.rap.status.ui.tabs.UpcomingEventsTab;

/**
 * Upcoming events view.
 * 
 * @author Fatih Ulusoy
 */
public class UpcomingEventsView extends ProjectAwareView {

	/** The view ID. */
	public static final String ID = "org.unicase.rap.status.ui.UpcomingEventsView";
	
	private CTabFolder tabFolder;
	
	private UpcomingEventsTab upcomingEventsTab;
	
	/**
	 * The constructor.
	 */
	public UpcomingEventsView() {
		super();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout());
		int style = SWT.TOP | SWT.FLAT | SWT.BORDER;
		
		tabFolder = new CTabFolder(parent, style);
		tabFolder.marginWidth = 8;
		tabFolder.marginHeight = 8;
		
		upcomingEventsTab = new UpcomingEventsTab(projectSpace, tabFolder, "Upcoming Events");
		upcomingEventsTab.createTabContent();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return ID;
	}

	/**
	 * {@inheritDoc}
	 */
	public void notify(Notification notification, Project project, ModelElement modelElement) {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	public void modelElementAdded(Project project, ModelElement modelElement) {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	public void modelElementDeleteStarted(Project project, ModelElement modelElement) {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	public void modelElementDeleteCompleted(Project project, ModelElement modelElement) {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	public void projectDeleted(Project project) {
		// TODO Auto-generated method stub
		
	}

}

