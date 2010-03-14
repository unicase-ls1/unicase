package org.unicase.rap.bugreport.config;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unicase.model.task.WorkPackage;
import org.unicase.rap.bugreport.SelectWorkPackageDialog;
import org.unicase.rap.config.AbstractConfigEntity;
import org.unicase.rap.config.ui.ProjectsTableViewer;
import org.unicase.rap.ui.views.ConfigurationTabView;
import org.unicase.workspace.ProjectSpace;

public class BugReportConfigTab extends ConfigurationTabView {
	
	private BugReportingConfigEntity cfgEntity;
	
	/**
	 * Textfield that holds the ID of the container that is used to place
	 * fresh bug reports.
	 */
	private Text bugContainerIdTextField;
	
	/**
	 * A table viewer of all available projects.
	 */
	ProjectsTableViewer projectsTableViewer;
	
	/**
	 * The currently selected project space.
	 */
	ProjectSpace currentProjectSpace;
	
	/**
	 * The current bug container.
	 */
	WorkPackage currentBugContainer;
	
	
	public BugReportConfigTab() {
		
	}
	
	@Override
	protected void createTab(Composite parent) {
		
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
		projectsTableViewer.refreshView();
		projectsTableViewer.getTable().setLayoutData(data);
		
//		data = new GridData();
//		data.horizontalAlignment = SWT.FILL;
//		projectsTableViewer.setLayoutData(data);
		
		final Label currentlySelectedProject = new Label(parent, SWT.BORDER);
		currentlySelectedProject.setLayoutData(data);
		currentlySelectedProject.setText("Selected project:");
		
		Composite c = new Composite(parent, SWT.BORDER);
		GridLayout g = new GridLayout();
		g.numColumns = 3;
		c.setLayout(g);
		data = new GridData();
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = SWT.FILL;
		c.setLayoutData(data);
		
		Label l = new Label(c, SWT.NONE);
		l.setText("Current bug reporting container:");
		
//		data.horizontalAlignment = SWT.FILL;
		bugContainerIdTextField = new Text(c, SWT.BORDER);
		bugContainerIdTextField.setEditable(false);
		bugContainerIdTextField.setLayoutData(data);
	
		final Button btSelectBugContainer = new Button(c, SWT.BORDER);
		btSelectBugContainer.setText("Select bug container");
		btSelectBugContainer.setEnabled(false);
		btSelectBugContainer.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = projectsTableViewer.getTable().getSelectionIndex();
				ProjectSpace projectSpace = (ProjectSpace) projectsTableViewer.getTable().getItem(selectedIndex).getData();
				foo(projectSpace);
			}
			
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
		
		projectsTableViewer.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = projectsTableViewer.getTable().getSelectionIndex();
				ProjectSpace projectSpace = (ProjectSpace) projectsTableViewer.getTable().getItem(selectedIndex).getData();
				currentlySelectedProject.setText("Selected project: " + projectSpace.getProjectName());
				btSelectBugContainer.setEnabled(true);
			}
			
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	private void foo(final ProjectSpace pSpace) {
		Display.getDefault().syncExec(new Runnable() {
			
			public void run() {
				SelectWorkPackageDialog dlg = new SelectWorkPackageDialog(pSpace, "Select work package used as bug container");
				
				if (dlg.open() == Window.OK) {
					WorkPackage workPackage = (WorkPackage) dlg.getFirstResult();
					currentBugContainer = workPackage;
					bugContainerIdTextField.setText(currentBugContainer.getIdentifier());
				}
			
			}
		});		
	}

	@Override
	public AbstractConfigEntity getConfigEntity() {
		cfgEntity = new BugReportingConfigEntity(currentProjectSpace.getProjectName());
		// TODO
		cfgEntity.setBugContainerId(currentBugContainer.getIdentifier());
		return cfgEntity;
	}

}
