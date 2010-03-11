package org.unicase.rap.status.ui.tabs;



import java.io.File;

import org.eclipse.jface.dialogs.MessageDialog;
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
import org.unicase.emfstore.esmodel.url.ProjectUrlFragment;
import org.unicase.emfstore.esmodel.url.UrlFactory;
import org.unicase.emfstore.esmodel.url.impl.ProjectUrlFragmentImpl;
import org.unicase.model.task.WorkPackage;
import org.unicase.rap.config.ConfigEntityStore;
import org.unicase.rap.status.config.WorkTeamItemsConfigEntity;
import org.unicase.rap.status.ui.ProjectsTableViewer;
import org.unicase.rap.status.ui.SelectWorkPackageDialog;
import org.unicase.rap.ui.views.ConfigurationTabView;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;

/**
 * 
 */
public class WorkTeamItemsConfigurationTab extends ConfigurationTabView {

	private ProjectsTableViewer projectsTableViewer;
	public static final String ID = "org.unicase.ui.web.projectview.ProjectConfigurationTab";
	
	// TODO: for now the project space is used to serve as
	private WorkPackage bugContainer;
	
	private ProjectSpace projectSpace;
	
	public WorkTeamItemsConfigurationTab() {
		
	}

	private void foo(final ProjectSpace pSpace) {
		Display.getDefault().syncExec(new Runnable() {
			
			public void run() {
				SelectWorkPackageDialog dlg = new SelectWorkPackageDialog(pSpace, "Select work package used as bug container");
				
				if (dlg.open() == Window.OK) {
					WorkPackage workPackage = (WorkPackage) dlg.getFirstResult();
					bugContainer = workPackage;
				}
			
			}
		});		
	}
	
	public void setFocus() {
	}

	@Override
	protected void createTab() {

		
		// TODO
//		getSite().setSelectionProvider(projectsTableViewer);
				 
		Composite top = new Composite(getComposite(), SWT.BORDER);
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
		final Text tfCrypticElement = new Text(banner, SWT.BORDER);
		//tf.

		l = new Label(banner, SWT.WRAP);
		l.setText("Team list visible:");
		l.setFont(boldFont);
		final Button cbTeamListVisisble = new Button(banner, SWT.CHECK); 
		
		l = new Label(banner, SWT.WRAP);
		l.setText("Work item list visible:");
		l.setFont(boldFont);
		final Button cbWorkItemListVisisble = new Button(banner, SWT.CHECK); 
		
		l = new Label(banner, SWT.WRAP);
		l.setText("Bug container:");
		Button btSelectBugContainer = new Button(banner, SWT.BORDER);
		btSelectBugContainer.setText("Select bug container");
		btSelectBugContainer.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = projectsTableViewer.getTable().getSelectionIndex();
				projectSpace = (ProjectSpace) projectsTableViewer.getTable().getItem(selectedIndex).getData();
				foo(projectSpace);
			}
			
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
		
		
		projectsTableViewer = new ProjectsTableViewer(getComposite());
		projectsTableViewer.refreshView();
		
		Button saveButton = new Button(getComposite(), SWT.NONE); 
		saveButton.setText("Save settings");
		saveButton.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				WorkTeamItemsConfigEntity cfgEntity = new WorkTeamItemsConfigEntity();
				cfgEntity.setBugContainer(bugContainer.getModelElementId().toString());
				cfgEntity.setCrypticElement(tfCrypticElement.getText());
				cfgEntity.setTeamListVisible(cbTeamListVisisble.getSelection());
				cfgEntity.setWorkItemsVisible(cbWorkItemListVisisble.getSelection());
				
				
				String filename = new File(System.getProperty("user.home")).getAbsolutePath() 
					+ File.separatorChar + "org.unicase.ui.web." + projectSpace.getProjectName();
				
				ConfigEntityStore.getInstance().saveEntity(cfgEntity, filename);

				MessageDialog.openInformation(Display.getDefault().getActiveShell(),
						"Settings saved", "The settings were successfully saved.");

				// TODO: retrieve bug container via..
//				ProjectUrlFragment projUrlFrag = UrlFactory.eINSTANCE.createProjectUrlFragment();
//				projUrlFrag.setName(projectName);
//				WorkspaceManager.getInstance().getCurrentWorkspace().resolve(projUrlFrag);
//				ProjectSpace p = null;
//				p.getProject().contains(modelElementId)
			}
			
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
