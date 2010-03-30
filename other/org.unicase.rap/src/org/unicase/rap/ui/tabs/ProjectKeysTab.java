package org.unicase.rap.ui.tabs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.unicase.rap.config.ActivatedProjectsCache;
import org.unicase.rap.config.ConfigEntityStore;
import org.unicase.rap.config.ProjectKeysConfigEntity;
import org.unicase.rap.ui.viewers.ProjectsTableViewer;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

import config.ConfigEntity;

public class ProjectKeysTab extends ConfigurationTab {
	
	/**
	 * The currently selected project space.
	 */
	ProjectSpace currentProjectSpace;
	
	/**
	 * The table viewer for projects.
	 */
	private ProjectsTableViewer projectsTableViewer;
	
	private Text crypticElementTextField;
	
	/**
	 * Checkbox for determining whether a project should be observed or not.
	 */
	private Button checkBox;
	

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
	    
	    projectsTableViewer = new ProjectsTableViewer(parent);
		projectsTableViewer.setInput(WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces());
		projectsTableViewer.getTable().setLayoutData(data);
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

	@Override
	public ConfigEntity getConfigEntity() {
		// TODO: simplify these calls
		ProjectKeysConfigEntity configEntity = new ProjectKeysConfigEntity();
		ConfigEntity cfgEntity = ConfigEntityStore.loadConigEntity(configEntity, configEntity.eClass());
		ProjectKeysConfigEntity projectConfigEntity = new ProjectKeysConfigEntity(cfgEntity);
		
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
