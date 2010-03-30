package org.unicase.rap.status.ui.tabs;

import java.util.List;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unicase.rap.config.ActivatedProjectsCache;
import org.unicase.rap.config.ConfigEntityStore;
import org.unicase.rap.config.IActivatedProjectsListener;
import org.unicase.rap.status.config.StatusConfigEntity;
import org.unicase.rap.ui.tabs.ConfigurationTab;
import org.unicase.rap.ui.viewers.ProjectsTableViewer;
import org.unicase.workspace.ProjectSpace;

import config.ConfigEntity;

/**
 * 
 */
public class StatusConfigurationTab extends ConfigurationTab implements IActivatedProjectsListener {

	/**
	 * The table viewer for projects.
	 */
	private ProjectsTableViewer projectsTableViewer;
	
	/**
	 * The config entity used by the configuration tab
	 */
	StatusConfigEntity cfgEntity;
	
	private Text crypticElementTextfield;
	
	private Button teamListVisisbleCheckBox;
	
	private Button workItemsVisibleCheckBox;
	

	/**
	 * The currently selected project space.
	 */
	ProjectSpace currentProjectSpace;
	
	
	/**
	 * Initializes a new instance of the WorkTeamItemsConfigurationTab class.
	 */
	public StatusConfigurationTab() {
	}

	
	
	public void setFocus() {
	}

	/*
	private void loadConfig(String projectName) {
		String loadPath = new File(SAVE_PATH).getAbsolutePath() + File.pathSeparatorChar + projectName; 
		try {
			WorkTeamItemsConfigEntity cfgEntity = (WorkTeamItemsConfigEntity) 
				ConfigEntityStore.loadObject(loadPath);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	@Override
	public void createConfigurationTab(Composite parent) {

		
		// TODO
//		getSite().setSelectionProvider(projectsTableViewer);
				 
//		Composite top = new Composite(parent, SWT.BORDER);
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
	    projectsTableViewer.setInput(ActivatedProjectsCache.getInstance().getProjects());
		ActivatedProjectsCache.getInstance().addListener(this);
		projectsTableViewer.getTable().setLayoutData(data);
		projectsTableViewer.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				ProjectSpace pSpace = (ProjectSpace) e.item.getData();
				currentProjectSpace = pSpace;
				loadSettings();
			}
			
			public void widgetDefaultSelected(SelectionEvent e) { }
		});
		
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
		l.setText("Cryptic element:");
		l.setFont(boldFont);
		crypticElementTextfield = new Text(c, SWT.BORDER);
		data = new GridData();
		data.horizontalAlignment = SWT.FILL;
		crypticElementTextfield.setLayoutData(data);
		
		l = new Label(c, SWT.WRAP);
		l.setText("Team list visible:");
		l.setFont(boldFont);
		teamListVisisbleCheckBox = new Button(c, SWT.CHECK); 
		
		l = new Label(c, SWT.WRAP);
		l.setText("Work item list visible:");
		l.setFont(boldFont);
		workItemsVisibleCheckBox = new Button(c, SWT.CHECK); 
	}
	
	@Override
	public ConfigEntity getConfigEntity() {
		cfgEntity = new StatusConfigEntity(currentProjectSpace);
		cfgEntity.setAssociatedProjectIdentifier(currentProjectSpace.getProjectName());
		cfgEntity.setCrypticElement(crypticElementTextfield.getText());
		cfgEntity.setTeamListVisible(teamListVisisbleCheckBox.getSelection());
		cfgEntity.setWorkItemsVisible(workItemsVisibleCheckBox.getSelection());

		return cfgEntity;
	}

	

	@Override
	public void loadSettings() {
		
		StatusConfigEntity configEntity = new StatusConfigEntity(currentProjectSpace);
		
		ConfigEntity cfgEntity = ConfigEntityStore.loadConigEntity(
				configEntity, configEntity.eClass());
		
		// TODO: eliminate code redundancy
		if (cfgEntity != null) {
			String crypticElement = (String) cfgEntity.getProperties().get(StatusConfigEntity.Keys.CRYPTIC_ELEMENT_KEY);
			Boolean teamListVisible = (Boolean) cfgEntity.getProperties().get(StatusConfigEntity.Keys.TEAMLIST_KEY);
			Boolean workItemsVisible = (Boolean) cfgEntity.getProperties().get(StatusConfigEntity.Keys.WORKITEMLIST_KEY);
			teamListVisisbleCheckBox.setSelection(teamListVisible);
			workItemsVisibleCheckBox.setSelection(workItemsVisible);
			crypticElementTextfield.setText(crypticElement);
		} else {
			teamListVisisbleCheckBox.setSelection(false);
			workItemsVisibleCheckBox.setSelection(false);
			crypticElementTextfield.setText("");
		}
	}



	public void activatedProjectsChangd(List<ProjectSpace> projectSpaces) {
		projectsTableViewer.setInput(projectSpaces);
	}
}
