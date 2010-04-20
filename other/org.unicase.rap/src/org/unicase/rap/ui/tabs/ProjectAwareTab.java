/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.ui.tabs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import org.unicase.workspace.ProjectSpace;

/**
 * An single project aware tab.
 * 
 * @author Edgar Müller, Fatih Ulusoy
 */
public abstract class ProjectAwareTab {

	private CTabItem tabItem;
	
	/**  */
	protected Composite composite;
	
	/**  */
	protected ProjectSpace projectSpace;
	
	/**
	 * Initializes a new instance of a tab.
	 * 
	 * @param projectSpace The project space this tab should be aware of.
	 * @param parent The parent tab folder.
	 * @param tabName The name of the tab.
	 */
	public ProjectAwareTab(ProjectSpace projectSpace, CTabFolder parent, String tabName) {
		tabItem = new CTabItem(parent, SWT.NONE);
		this.projectSpace = projectSpace;
		tabItem.setText(tabName);

		composite = new Composite(parent, SWT.NONE);

		composite.setLayout(new GridLayout(1, false));
		tabItem.setControl(composite);
	}
	
	/**
	 * 
	 */
	public void createPartControl() {
		createTabContent(composite);
	}
	
	private void createTabContent(Composite composite) {
		
		// check whether a project name has been passed
		if (projectSpace == null) {
			Label l = new Label(composite, SWT.NONE);
			l.setText("No project name was set.");
			Color red = new Color(Display.getDefault(), 255, 0, 0);
			l.setForeground(red);
		} else {
			createTab(composite);
		}
	}

	/**
	 * Creates the tab content.
	 * @param parent The composite upon the the tab can place its content.
	 */
	protected abstract void createTab(Composite parent);
		
	/**
	 * Gets the project space this tab is aware of.
	 * @return The project this tab is aware of.
	 */
	protected ProjectSpace getProjectSpace() {
		return projectSpace;
	}
}

