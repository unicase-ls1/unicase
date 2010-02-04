package org.unicase.ui.web.tabs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.emf.common.util.EList;

import org.unicase.metamodel.Project;
import org.unicase.web.util.ExampleUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * 
 * @author Edgar Müller
 * @author Fatih Ulusoy
 */
public abstract class AbstractTab {

	private CTabItem tabItem;
	private CTabFolder tabFolder;
	private Composite tabComposite;

	private Project project;

	private ProjectSpace projectSpace;

	private boolean isContentCreated;

	/**
	 * 
	 * @param project
	 * @param parent
	 * @param tabName
	 */
	public AbstractTab(String project, CTabFolder parent, String tabName) {
		tabFolder = parent;
		tabItem = new CTabItem(getTabFolder(), SWT.NONE);
		tabItem.setText(tabName);

		Composite composite = new Composite(getTabFolder(), SWT.NONE);
		composite.setLayout(ExampleUtil.createGridLayout(1, false, 10, 20));

		tabComposite = new Composite(composite, SWT.NONE);
		tabComposite
				.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		tabComposite.setLayout(new GridLayout(2, false));

		tabItem.setControl(composite);
		
		resolveProject(project);
		
		isContentCreated = false;
	}

	/**
	 * 
	 * @param parent
	 * @param tabName
	 */
	public AbstractTab(CTabFolder parent, String tabName) {
		tabFolder = parent;
	}

	/**
	 * Creates tab content.
	 */
	public abstract void createTabContent();

	/**
	 * 
	 * @param projectName
	 */
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

	private void setProjectSpace(ProjectSpace projectSpace) {
		this.projectSpace = projectSpace;
	}

	public ProjectSpace getProjectSpace() {
		return projectSpace;
	}

	private void setProject(Project project) {
		this.project = project;
	}
	
	public void setProject(String projectName) {
		resolveProject(projectName);
	}
	
	public Project getProject() {
		return project;
	}

	public CTabFolder getTabFolder() {
		return tabFolder;
	}

}
