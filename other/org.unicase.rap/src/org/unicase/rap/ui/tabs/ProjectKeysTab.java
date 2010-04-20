/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.ui.tabs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import config.ConfigEntity;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.rap.config.ActivatedProjectsCache;
import org.unicase.rap.config.ConfigEntityStore;
import org.unicase.rap.config.ProjectKeysConfigEntity;
import org.unicase.rap.ui.viewers.ProjectsTableViewer;


/**
 * 
 * 
 * @author Edgar Müller, Fatih Ulusoy
 */
public class ProjectKeysTab extends ConfigurationTab {
	
	/**
	 * The currently selected project space.
	 */
	private ProjectSpace currentProjectSpace;
	
	/**
	 * The table viewer for projects.
	 */
	private ProjectsTableViewer projectsTableViewer;
	
	private Text crypticElementTextField;
	
	/**
	 * Checkbox for determining whether a project should be observed or not.
	 */
	private Button checkBox;
	
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
		projectsTableViewer.setInput(WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces());
		tableComposite.setLayoutData(data);
		projectsTableViewer.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				ProjectSpace pSpace = (ProjectSpace) e.item.getData();
				currentProjectSpace = pSpace;
				loadSettings();
			}
			
			public void widgetDefaultSelected(SelectionEvent e) { }
		});
		
		crypticElementTextField = new Text(parent, SWT.BORDER);
		checkBox = new Button(parent, SWT.CHECK);
		checkBox.setText("Activated:");
		
		addSaveButtonListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				ActivatedProjectsCache.getInstance().reloadActivatedProjects();
			}
			
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConfigEntity getConfigEntity() {
		// TODO: simplify these calls
		ProjectKeysConfigEntity configEntity = new ProjectKeysConfigEntity();
		ConfigEntityStore.loadConfigEntity(configEntity, configEntity.eClass());
		
		ProjectKeysConfigEntity projectConfigEntity = new ProjectKeysConfigEntity(configEntity);
		
		String projectName = currentProjectSpace.getProjectName();
		projectConfigEntity.addAccessKey(projectName, crypticElementTextField.getText());
		projectConfigEntity.setProjectActivated(projectName, checkBox.getSelection());
		return projectConfigEntity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void loadSettings() {
		
		ProjectKeysConfigEntity configEntity = new ProjectKeysConfigEntity();
		ConfigEntity cfgEntity = ConfigEntityStore.loadConigEntity(configEntity, configEntity.eClass());

		if (cfgEntity != null) {
			ProjectKeysConfigEntity projectConfigEntity = new ProjectKeysConfigEntity(cfgEntity);
			String projectName = currentProjectSpace.getProjectName();
			String accessKey = projectConfigEntity.getAccessKey(projectName);
			boolean isActivated = projectConfigEntity.getProjectActivated(projectName);
				
			// cryptic element may not be set
			if (accessKey != null) {
				crypticElementTextField.setText(accessKey);
			} else {
				crypticElementTextField.setText("");
			}
			
			if (isActivated) {
				checkBox.setSelection(true);
			} else {
				checkBox.setSelection(false);
			}
		} 
	}

}
