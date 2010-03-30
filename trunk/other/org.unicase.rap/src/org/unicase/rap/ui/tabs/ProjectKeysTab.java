package org.unicase.rap.ui.tabs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.unicase.rap.config.ConfigEntityStore;
import org.unicase.rap.config.ProjectKeysConfigEntity;
import org.unicase.rap.ui.viewers.ProjectsTableViewer;
import org.unicase.workspace.ProjectSpace;

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
//		top.setLayout(layout);
		
		
		// top banner
//		Composite banner = new Composite(parent, SWT.NONE);
//		banner.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL, GridData.VERTICAL_ALIGN_BEGINNING, true, false));
//		layout = new GridLayout();
//		layout.marginHeight = 5;
//		layout.marginWidth = 10;
//		layout.numColumns = 2;
//		banner.setLayout(layout);
	    
	    projectsTableViewer = new ProjectsTableViewer(parent);
		projectsTableViewer.refreshView();
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
				
	}

	@Override
	public ConfigEntity getConfigEntity() {
		ProjectKeysConfigEntity cfgEntity = new ProjectKeysConfigEntity();
		cfgEntity.addAccessKey(currentProjectSpace.getProjectName(), crypticElementTextField.getText());
		return cfgEntity;
	}

	@Override
	public void loadSettings() {
		ProjectKeysConfigEntity configEntity = new ProjectKeysConfigEntity();
		ConfigEntity cfgEntity = ConfigEntityStore.loadConigEntity(configEntity, configEntity.eClass());
		
		if (cfgEntity != null) {
			String crypticElement = (String) cfgEntity.getProperties().get(currentProjectSpace.getProjectName());
			
			// cryptic element may not be set
			if (crypticElement != null) {
				crypticElementTextField.setText(crypticElement);
				return;
			}
		} 
			
		crypticElementTextField.setText("");

		
	}

}
