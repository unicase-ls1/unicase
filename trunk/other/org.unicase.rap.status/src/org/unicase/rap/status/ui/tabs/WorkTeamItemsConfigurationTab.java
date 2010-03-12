package org.unicase.rap.status.ui.tabs;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.JFaceResources;
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
import org.unicase.model.task.WorkPackage;
import org.unicase.rap.config.AbstractConfigEntity;
import org.unicase.rap.config.ui.ProjectsTableViewer;
import org.unicase.rap.status.config.WorkTeamItemsConfigEntity;
import org.unicase.rap.ui.views.ConfigurationTabView;
import org.unicase.workspace.ProjectSpace;

/**
 * 
 */
public class WorkTeamItemsConfigurationTab extends ConfigurationTabView {

	/**
	 * The table viewer for projects.
	 */
	private ProjectsTableViewer projectsTableViewer;
	
	/**
	 * The config entity used by the configuration tab
	 */
	WorkTeamItemsConfigEntity cfgEntity;
	
	// TODO: for now the project space is used to serve as
	private WorkPackage bugContainer;
		
	private String configEntityId;
	
	private Text crypticElementTextfield;
	
	private Button teamListVisisbleCheckBox;
	
	private Button workItemsVisibleCheckBox;
	
	
	
	/**
	 * Initializes a new instance of the WorkTeamItemsConfigurationTab class.
	 */
	public WorkTeamItemsConfigurationTab() {
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
	protected void createTab(Composite parent) {

		
		// TODO
//		getSite().setSelectionProvider(projectsTableViewer);
				 
		Composite top = new Composite(parent, SWT.BORDER);
		GridLayout layout = new GridLayout();		
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		top.setLayout(layout);
		
		
		// top banner
		Composite banner = new Composite(top, SWT.NONE);
		banner.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL, GridData.VERTICAL_ALIGN_BEGINNING, true, false));
		layout = new GridLayout();
		layout.marginHeight = 5;
		layout.marginWidth = 10;
		layout.numColumns = 2;
		banner.setLayout(layout);
		
		// setup bold font
		Font boldFont = JFaceResources.getFontRegistry().getBold(JFaceResources.DEFAULT_FONT);    
		
		Label l = new Label(banner, SWT.WRAP);
		l.setText("Cryptic element:");
		l.setFont(boldFont);
		crypticElementTextfield = new Text(banner, SWT.BORDER);
		

		l = new Label(banner, SWT.WRAP);
		l.setText("Team list visible:");
		l.setFont(boldFont);
		teamListVisisbleCheckBox = new Button(banner, SWT.CHECK); 
		
		l = new Label(banner, SWT.WRAP);
		l.setText("Work item list visible:");
		l.setFont(boldFont);
		workItemsVisibleCheckBox = new Button(banner, SWT.CHECK); 
		
		l = new Label(banner, SWT.WRAP);
		l.setText("Bug container:");
		
		projectsTableViewer = new ProjectsTableViewer(parent);
		projectsTableViewer.refreshView();
		projectsTableViewer.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				ProjectSpace pSpace = (ProjectSpace) e.item.getData();
				configEntityId = pSpace.getProjectId().getId();
				System.out.println("WorkTeamItems: " + e.item.getData().toString());	
			}
			
			public void widgetDefaultSelected(SelectionEvent e) { }
		});
	}
	
	@Override
	public AbstractConfigEntity getConfigEntity() {
		
		if (bugContainer == null) {
			MessageDialog.openInformation(
					Display.getDefault().getActiveShell(),
					"Bugcontainer missing",
					"You didn't selected any bug container.");
			return null;
		}
		
		cfgEntity = new WorkTeamItemsConfigEntity(configEntityId);
		cfgEntity.setBugContainer(bugContainer.getModelElementId().toString());
		cfgEntity.setCrypticElement(crypticElementTextfield.getText());
		cfgEntity.setTeamListVisible(teamListVisisbleCheckBox.getSelection());
		cfgEntity.setWorkItemsVisible(workItemsVisibleCheckBox.getSelection());

		return cfgEntity;
	}
}
