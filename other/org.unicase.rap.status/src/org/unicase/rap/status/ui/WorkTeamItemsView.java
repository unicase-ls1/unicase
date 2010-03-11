package org.unicase.rap.status.ui;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.rwt.graphics.Graphics;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.rap.status.ui.tabs.TeamListTab;
import org.unicase.rap.status.ui.tabs.WorkItemsTab;
import org.unicase.rap.ui.views.ProjectAwareView;

public class WorkTeamItemsView extends ProjectAwareView {
	
	public static final String ID = "org.unicase.ui.web.projectview.ProjectView";
	
	private WorkItemsTab workItemsTab;
	private TeamListTab teamListTab;
	private CTabFolder tabFolder;
	
	public WorkTeamItemsView() {
		super();
	}

	/**
	 * Ensures minimum tab height.
	 * 
	 * @param folder
	 */
	private static void ensureMinTabHeight(final CTabFolder folder) {
		int result = Graphics.getCharHeight(folder.getFont());
		if (result < 18) {
			folder.setTabHeight(18);
		}
	}

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout());
		int style = SWT.TOP | SWT.FLAT | SWT.BORDER;
		
		tabFolder = new CTabFolder(parent, style);
		tabFolder.marginWidth = 8;
		tabFolder.marginHeight = 8;
		ensureMinTabHeight(tabFolder);
		
		workItemsTab = new WorkItemsTab(projectSpace, tabFolder);
		teamListTab = new TeamListTab(projectSpace, tabFolder);
		
		workItemsTab.createTabContent();
		teamListTab.createTabContent();
		
		tabFolder.setSelection(0);
		tabFolder.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent evt) {
				int index = tabFolder.getSelectionIndex();
		
			}
		});
	}

	@Override
	public void setFocus() {
		
	}

	public void modelElementAdded(Project project, ModelElement modelElement) {
		workItemsTab.refreshInput();
		teamListTab.refreshInput();
	}

	public void modelElementDeleteCompleted(Project project,
			ModelElement modelElement) {
		workItemsTab.refreshInput();
		teamListTab.refreshInput();		
	}

	public void modelElementDeleteStarted(Project project,
			ModelElement modelElement) {
		workItemsTab.refreshInput();
		teamListTab.refreshInput();		
	}

	public void notify(Notification notification, Project project,
			ModelElement modelElement) {
		workItemsTab.refreshInput();
		teamListTab.refreshInput();		
	}
}
