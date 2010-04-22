/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.status.ui.tabs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unicase.model.organization.Group;
import org.unicase.model.task.WorkPackage;
import org.unicase.rap.config.ActivatedProjectsCache;
import org.unicase.rap.config.ConfigEntityStore;
import org.unicase.rap.config.IActivatedProjectsListener;
import org.unicase.rap.status.config.StatusConfigEntity;
import org.unicase.rap.status.ui.SelectUserGroupDialog;
import org.unicase.rap.ui.tabs.ConfigurationTab;
import org.unicase.rap.ui.viewers.ProjectsTableViewer;
import org.unicase.workspace.ProjectSpace;

import config.ConfigEntity;

/**
 * Status configuration tab.
 * 
 * @author Edgar Müller.
 */
public class StatusConfigurationTab extends ConfigurationTab implements IActivatedProjectsListener {

	/**
	 * The table viewer for projects.
	 */
	private ProjectsTableViewer projectsTableViewer;
	
	/**
	 * The configuration entity used by the configuration tab.
	 */
	private StatusConfigEntity cfgEntity;
	
	private Button teamListVisisbleCheckBox;
	
	private Button workItemsVisibleCheckBox;
	
	/**
	 * 
	 */
	private Text teamMembersContainerIdTextField;
	
	/**
	 * The current bug container.
	 */
	private String currentTeamMembersContainerId;

	/**
	 * The currently selected project space.
	 */
	private ProjectSpace currentProjectSpace;
	
	
	/**
	 * Initializes a new instance of the WorkTeamItemsConfigurationTab class.
	 */
	public StatusConfigurationTab() {
		
	}
	
	/**
	 * 
	 */
	public void setFocus() {
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createConfigurationTab(Composite parent) {

		GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 1;
	    GridData data = new GridData();
	    data.horizontalAlignment = SWT.FILL;
	    data.verticalAlignment = SWT.FILL;
	    data.grabExcessHorizontalSpace = true;
	    data.grabExcessVerticalSpace = true;
	    parent.setLayout(gridLayout);
	    parent.setLayoutData(data);

	    Composite tableComposite = new Composite(parent, SWT.NONE);
	    projectsTableViewer = new ProjectsTableViewer(tableComposite);
	    tableComposite.setLayoutData(data);
	    
		List<ProjectSpace> inputList = new ArrayList<ProjectSpace>();
		inputList.addAll(ActivatedProjectsCache.getInstance().getProjects());
		projectsTableViewer.setInput(inputList);
	    
	    ActivatedProjectsCache.getInstance().addListener(this);

		// setup bold font
		Font boldFont = JFaceResources.getFontRegistry().getBold(JFaceResources.DEFAULT_FONT);
		
		data = new GridData();
		data.horizontalAlignment = SWT.FILL;
	
		Composite c = new Composite(parent, SWT.BORDER);
		GridLayout g = new GridLayout();
		g.numColumns = 2;
		c.setLayoutData(data);
		c.setLayout(g);
		
		Label l = new Label(c, SWT.WRAP);
		l.setText("Team list visible:");
		l.setFont(boldFont);
		teamListVisisbleCheckBox = new Button(c, SWT.CHECK); 
		
		l = new Label(c, SWT.WRAP);
		l.setText("Work item list visible:");
		l.setFont(boldFont);
		workItemsVisibleCheckBox = new Button(c, SWT.CHECK); 
		
		Button button = new Button(c, SWT.BORDER);
		button.setText("Select User Group");
		button.setEnabled(false);
		button.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = projectsTableViewer.getTable().getSelectionIndex();
				ProjectSpace projectSpace = (ProjectSpace) projectsTableViewer.getTable().getItem(selectedIndex).getData();
				
			}

			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});
		
		c = new Composite(parent, SWT.BORDER);
		g = new GridLayout();
		g.numColumns = 3;
		c.setLayout(g);
		data = new GridData();
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = SWT.FILL;
		c.setLayoutData(data);
		
		l = new Label(c, SWT.NONE);
		l.setText("Current user group name:");
		
		teamMembersContainerIdTextField = new Text(c, SWT.BORDER);
		teamMembersContainerIdTextField.setEditable(false);
		teamMembersContainerIdTextField.setLayoutData(data);
	
		final Button btSelectBugContainer = new Button(c, SWT.BORDER);
		btSelectBugContainer.setText("Select User Group");
		btSelectBugContainer.setEnabled(false);
		btSelectBugContainer.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = projectsTableViewer.getTable().getSelectionIndex();
				ProjectSpace projectSpace = (ProjectSpace) projectsTableViewer.getTable().getItem(selectedIndex).getData();
				openDialogWindow(projectSpace);
			}

			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});
		
		projectsTableViewer.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				ProjectSpace pSpace = (ProjectSpace) e.item.getData();
				currentProjectSpace = pSpace;
				btSelectBugContainer.setEnabled(true);
				loadSettings();
			}
			
			public void widgetDefaultSelected(SelectionEvent e) { }
		});
		
	}
	
	/**
	 * @param pSpace
	 */
	private void openDialogWindow(final ProjectSpace pSpace) {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				SelectUserGroupDialog dlg = new SelectUserGroupDialog(pSpace,
					"Select work package used as bug container");

				if (dlg.open() == Window.OK) {
					// TODO: 
					Group group = (Group) dlg.getFirstResult();
					currentTeamMembersContainerId = group.getIdentifier();
					teamMembersContainerIdTextField.setText(currentTeamMembersContainerId);
				}

			}
		});
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConfigEntity getConfigEntity() {
		cfgEntity = new StatusConfigEntity(currentProjectSpace);
		cfgEntity.setAssociatedProjectIdentifier(currentProjectSpace.getProjectName());
		cfgEntity.setTeamListVisible(teamListVisisbleCheckBox.getSelection());
		cfgEntity.setWorkItemsVisible(workItemsVisibleCheckBox.getSelection());
		cfgEntity.setUserGroupName(currentTeamMembersContainerId);
		return cfgEntity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void loadSettings() {
		
		StatusConfigEntity configEntity = new StatusConfigEntity(currentProjectSpace);
		
		ConfigEntity cfgEntity = ConfigEntityStore.loadConigEntity(
				configEntity, configEntity.eClass());
		
		// TODO: eliminate code redundancy
		if (cfgEntity != null) {
			Boolean teamListVisible = (Boolean) cfgEntity.getProperties().get(StatusConfigEntity.Keys.TEAMLIST_KEY);
			Boolean workItemsVisible = (Boolean) cfgEntity.getProperties().get(StatusConfigEntity.Keys.WORKITEMLIST_KEY);
			String teamMembersContainerId = (String) cfgEntity.getProperties().get(StatusConfigEntity.Keys.USERGROUP_KEY);
			teamListVisisbleCheckBox.setSelection(teamListVisible);
			workItemsVisibleCheckBox.setSelection(workItemsVisible);
			teamMembersContainerIdTextField.setText(teamMembersContainerId);
			
		} else {
			teamListVisisbleCheckBox.setSelection(false);
			workItemsVisibleCheckBox.setSelection(false);
			teamMembersContainerIdTextField.setText("");
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void activatedProjectsChangd(List<ProjectSpace> projectSpaces) {
		projectsTableViewer.setInput(projectSpaces);
		projectsTableViewer.refresh();
	}
	
}

