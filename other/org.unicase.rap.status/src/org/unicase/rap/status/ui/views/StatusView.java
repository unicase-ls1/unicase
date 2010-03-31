package org.unicase.rap.status.ui.views;

import org.eclipse.swt.SWT;
import org.eclipse.rwt.graphics.Graphics;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.emf.common.notify.Notification;

import org.unicase.metamodel.Project;
import org.unicase.metamodel.ModelElement;

import config.ConfigEntity;
import org.unicase.rap.config.ConfigEntityStore;
import org.unicase.rap.ui.views.ProjectAwareView;
import org.unicase.rap.status.ui.tabs.TeamListTab;
import org.unicase.rap.status.ui.tabs.WorkItemsTab;
import org.unicase.rap.status.config.StatusConfigEntity;

/**
 * Project specific status view that contains an overview of team members and work items.
 * 
 * @author Edgar Mueller
 * @author Fatih Ulusoy
 */
public class StatusView extends ProjectAwareView {

	/** View ID. */
	public static final String ID = "org.unicase.rap.status.ui.views.StatusView";

	/** Tab Folder. */
	private CTabFolder tabFolder;

	/** Tab that holds an overview of work items and their status. */
	private WorkItemsTab workItemsTab;

	/** Tab that holds an overview of team members. */
	private TeamListTab teamListTab;

	/**
	 * Constructor.
	 */
	public StatusView() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {

		parent.setLayout(new FillLayout());
		int style = SWT.TOP | SWT.FLAT | SWT.BORDER;

		tabFolder = new CTabFolder(parent, style);
		tabFolder.marginWidth = 8;
		tabFolder.marginHeight = 8;
		ensureMinTabHeight(tabFolder);

		if (isTabVisible(StatusConfigEntity.Keys.WORKITEMLIST_KEY)) {
			workItemsTab = new WorkItemsTab(projectSpace, tabFolder);
			workItemsTab.createPartControl();
		}

		if (isTabVisible(StatusConfigEntity.Keys.TEAMLIST_KEY)) {
			teamListTab = new TeamListTab(projectSpace, tabFolder);
			teamListTab.createPartControl();
		}

		tabFolder.setSelection(0);
		tabFolder.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent evt) {
				// int index = tabFolder.getSelectionIndex();
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {

	}

	/**
	 * {@inheritDoc}
	 */
	public void modelElementAdded(Project project, ModelElement modelElement) {
		refreshAllTabs();
	}

	/**
	 * {@inheritDoc}
	 */
	public void modelElementDeleteCompleted(Project project, ModelElement modelElement) {
		refreshAllTabs();
	}

	/**
	 * {@inheritDoc}
	 */
	public void modelElementDeleteStarted(Project project, ModelElement modelElement) {
		refreshAllTabs();
	}

	/**
	 * {@inheritDoc}
	 */
	public void notify(Notification notification, Project project, ModelElement modelElement) {
		refreshAllTabs();
	}

	/**
	 * {@inheritDoc}
	 */
	public void projectDeleted(Project project) {
		refreshAllTabs();
	}

	/**
	 * Refreshes the all tabs in the view.
	 */
	private void refreshAllTabs() {
		if (workItemsTab != null)
			workItemsTab.refreshInput();
		if (teamListTab != null)
			teamListTab.refreshInput();
	}

	/**
	 * Checks if the tab is allowed to be visible.
	 * 
	 * @param tabKey must be one of key values from {@link StatusConfigEntity.Keys}
	 * @return
	 */
	private boolean isTabVisible(String tabKey) {
		StatusConfigEntity configEntity = new StatusConfigEntity(projectSpace);
		ConfigEntity cfgEntity = ConfigEntityStore.loadConigEntity(configEntity, configEntity.eClass());

		Object value = cfgEntity.getProperties().get(tabKey);

		if (value instanceof Boolean)
			return (Boolean) value;

		return false;
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

}
