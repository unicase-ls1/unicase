package org.unicase.rap.bugreport.config;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
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
	    gridLayout.makeColumnsEqualWidth = true;
	    parent.setLayout(gridLayout);

		projectsTableViewer = new ProjectsTableViewer(parent);		
		projectsTableViewer.refreshView();
		
		
		Composite c = new Composite(parent, SWT.NONE);
		GridLayout g = new GridLayout();
		g.numColumns = 3;
		c.setLayout(g);
		
		Label l = new Label(c, SWT.NONE);
		l.setText("Current bug reporting container:");
		
		bugContainerIdTextField = new Text(c, SWT.BORDER);
	
		Button btSelectBugContainer = new Button(c, SWT.BORDER);
		btSelectBugContainer.setText("Select bug container");
		btSelectBugContainer.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = projectsTableViewer.getTable().getSelectionIndex();
				ProjectSpace projectSpace = (ProjectSpace) projectsTableViewer.getTable().getItem(selectedIndex).getData();
				foo(projectSpace);
			}
			
			public void widgetDefaultSelected(SelectionEvent e) {
				
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
