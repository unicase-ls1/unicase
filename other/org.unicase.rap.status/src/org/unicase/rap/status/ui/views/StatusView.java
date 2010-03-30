package org.unicase.rap.status.ui.views;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.rwt.graphics.Graphics;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.rap.config.ConfigEntityStore;
import org.unicase.rap.status.config.StatusConfigEntity;
import org.unicase.rap.status.ui.tabs.TeamListTab;
import org.unicase.rap.status.ui.tabs.WorkItemsTab;
import org.unicase.rap.ui.views.ProjectAwareView;

import config.ConfigEntity;

/**
 * Project specific status view that contains an overview of team members and work items.
 * 
 * @author emueller
 *
 */
public class StatusView extends ProjectAwareView {
	
	public static final String ID = "org.unicase.rap.status.ui.views.StatusView";
	
	/**
	 * Tab that holds an overview of workitems and their status.
	 */
	private WorkItemsTab workItemsTab;
	
	/**
	 * Tab that holds an overview of team members.
	 */
	private TeamListTab teamListTab;
	
	private CTabFolder tabFolder;
	
	public StatusView() {
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
//		String crypticElement = getHttpRequest().getParameter("key");
//		
//		StatusConfigEntity configEntity = new StatusConfigEntity(projectSpace);
//		ConfigEntity cfgEntity = ConfigEntityStore.loadConigEntity(configEntity, configEntity.eClass());
//		
//		Object savedCrypticElement = cfgEntity.getProperties().get(StatusConfigEntity.Keys.CRYPTIC_ELEMENT_KEY); 
//		
//		// if savedCrypticElement == null, we assume that this has been set intentional
//		if (savedCrypticElement != null && !((String) savedCrypticElement).equals(crypticElement)) {
//			MessageDialog.openInformation(Display.getDefault().getActiveShell(), 
//					"Access denied", "You aren't allowed to view this project.");
//			return;
//		}
//		
		parent.setLayout(new FillLayout());
		int style = SWT.TOP | SWT.FLAT | SWT.BORDER;
		
		tabFolder = new CTabFolder(parent, style);
		tabFolder.marginWidth = 8;
		tabFolder.marginHeight = 8;
		ensureMinTabHeight(tabFolder);
		
		workItemsTab = new WorkItemsTab(projectSpace, tabFolder);
		teamListTab = new TeamListTab(projectSpace, tabFolder);
		
		workItemsTab.createPartControl();
		teamListTab.createPartControl();
		
		tabFolder.setSelection(0);
		tabFolder.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent evt) {
//				int index = tabFolder.getSelectionIndex();
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
		workItemsTab.refreshInput();
		teamListTab.refreshInput();
	}

	/**
	 * {@inheritDoc}
	 */
	public void modelElementDeleteCompleted(Project project,
			ModelElement modelElement) {
		workItemsTab.refreshInput();
		teamListTab.refreshInput();		
	}

	/**
	 * {@inheritDoc}
	 */
	public void modelElementDeleteStarted(Project project,
			ModelElement modelElement) {
		workItemsTab.refreshInput();
		teamListTab.refreshInput();		
	}

	/**
	 * {@inheritDoc}
	 */
	public void notify(Notification notification, Project project,
			ModelElement modelElement) {
		workItemsTab.refreshInput();
		teamListTab.refreshInput();		
	}

	/**
	 * {@inheritDoc}
	 */
	public void projectDeleted(Project project) {
		workItemsTab.refreshInput();
		teamListTab.refreshInput();
	}
}
