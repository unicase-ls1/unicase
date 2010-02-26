package org.unicase.ui.web.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Composite;
import org.unicase.metamodel.util.ProjectChangeObserver;
import org.unicase.workspace.ProjectSpace;

/**
 * Project aware tab.
 * 
 * @author Edgar Mueller
 * @author Fatih Ulusoy
 */
public abstract class ProjectAwareTab implements ProjectChangeObserver {

	protected ProjectSpace projectSpace;
	protected Composite composite;
	private CTabItem tabItem;
	
	/**
	 * Initializes a new instance of a tab.
	 *
	 * @param projectSpace The project space this tab should be aware of.
	 * @param parent The parent tab folder.
	 * @param tabName The name of the tab.
	 */
	public ProjectAwareTab(ProjectSpace projectSpace, CTabFolder parent, String tabName) {
		tabItem = new CTabItem(parent, SWT.NONE);
		this.projectSpace = projectSpace;		
		tabItem.setText(tabName);
		
		composite = new Composite(parent, SWT.NONE);
	}
	
	protected Composite getComposite() {
		return composite;
	}
	
	protected ProjectSpace getProjectSpace() {
		return projectSpace;
	}
}
