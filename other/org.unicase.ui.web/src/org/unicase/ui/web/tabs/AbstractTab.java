package org.unicase.ui.web.tabs;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.unicase.metamodel.Project;
import org.unicase.web.util.ExampleUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

public abstract class AbstractTab {
	
	private CTabItem tabItem;
	private CTabFolder tabFolder;
	private Composite tabComposite;
	
	private boolean isContentCreated;
	
	private ProjectSpace projectSpace;
	private Project project;
	
	public AbstractTab(String project, CTabFolder parent, String tabName) {
		setTabFolder(parent);
		tabItem = new CTabItem(getTabFolder(), SWT.NONE);
		tabItem.setText(tabName);
	    
		Composite composite = new Composite(getTabFolder(), SWT.NONE);
		composite.setLayout(ExampleUtil.createGridLayout(1, false, 10, 20));
		
		setTabComposite(new Composite(composite, SWT.NONE));
		getTabComposite().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		getTabComposite().setLayout(new GridLayout(2, false));
		
	    tabItem.setControl(composite);
	    
//	    contentProvider = new ObservableListContentProvider();
	    setContentCreated(false);
	}
	
	public AbstractTab(CTabFolder parent, String tabName) {
		setTabFolder(parent);
	}
	
	protected void resolveProject(String projectName) {
		// TODO: resolve project via projectname directly
		EList<ProjectSpace> projectSpaces = WorkspaceManager.getInstance()
				.getCurrentWorkspace().getProjectSpaces();
		for (ProjectSpace p : projectSpaces) {
			if (p.getProjectName().equalsIgnoreCase(projectName)) {
				setProjectSpace(p);
				setProject(p.getProject());
			}
		}
	}

	
	/**
	 * Creates tab content.
	 */
	public abstract void createTabContent();


	public void setContentCreated(boolean isContentCreated) {
		this.isContentCreated = isContentCreated;
	}


	public boolean isContentCreated() {
		return isContentCreated;
	}

	public void setTabComposite(Composite tabComposite) {
		this.tabComposite = tabComposite;
	}

	public Composite getTabComposite() {
		return tabComposite;
	}

	public void setProjectSpace(ProjectSpace projectSpace) {
		this.projectSpace = projectSpace;
	}

	public ProjectSpace getProjectSpace() {
		return projectSpace;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Project getProject() {
		return project;
	}

	private void setTabFolder(CTabFolder tabFolder) {
		this.tabFolder = tabFolder;
	}

	public CTabFolder getTabFolder() {
		return tabFolder;
	}
	
}
