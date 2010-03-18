package org.unicase.rap.ui.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
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
		
		composite.setLayout(new GridLayout(1, false));
	    tabItem.setControl(composite);
	}
	
	public void createPartControl() {
		createTabContent(composite);
	}
	
	private void createTabContent(Composite composite) {
		
		// check whether a project name has been passed
		if (projectSpace == null) {
			Label l = new Label(composite, SWT.NONE);
			l.setText("No project name was set.");
			Color red = new Color(Display.getDefault(), 255, 0, 0);
			l.setForeground(red);
		} else {
			createTab(composite);
		}
	}

	protected abstract void createTab(Composite parent);
		
	protected ProjectSpace getProjectSpace() {
		return projectSpace;
	}
}
