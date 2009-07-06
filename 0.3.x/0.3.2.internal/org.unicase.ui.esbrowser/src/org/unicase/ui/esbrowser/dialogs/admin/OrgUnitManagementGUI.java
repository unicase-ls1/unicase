package org.unicase.ui.esbrowser.dialogs.admin;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.unicase.workspace.AdminBroker;

/**
 * This class provides the contents of ManageOrgUnitsDialog. It contains a
 * TabFolder with three tabs for Projects, Groups, and Users. On the right side
 * there is a properties view (PropertisForm). When user double clicks an item
 * in a tab, its details are shown in details view
 * 
 * @author Hodaie
 * 
 */
public class OrgUnitManagementGUI {

	private TabFolder tabFolder;

	// This keeps track of active tab;
	// PropertiesForm need to know the activeTab so that
	// it can refresh its list viewer on property changes
	private TabContent activeTabContent;

	private TabContent projectsTabContents;
	private TabContent groupsTabContents;
	private TabContent usersTabContents;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            Parent
	 * @param adminBroker
	 *            AdminBorker is responsible for retrieving information from
	 *            server.
	 */
	public OrgUnitManagementGUI(Composite parent, AdminBroker adminBroker) {

		createSash(parent, adminBroker);
	}

	/**
	 * Create the SashForm. On the left hand is a TabFolder with tree tabs, and
	 * on the right hand the properties are shown.
	 * 
	 * @param parent
	 */
	private void createSash(Composite parent, AdminBroker adminBroker) {
		SashForm sash = new SashForm(parent, SWT.HORIZONTAL);
		sash.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// ATTENTION: the creation order is important!
		// first create the tab folder, then the form, and then set the TabItems
		// in tab folder.
		// why this order? because
		// 1. tab folder should appear left of form (first control on sash)
		// 2. Tabs shown in TabItems need to be aware of form (first create
		// form, then tabs.)
		createTabFolder(sash);
		PropertiesForm frm = createPropertiesForm(sash, adminBroker);
		initTabFolder(adminBroker, frm);

		sash.setWeights(sashWeights());
	}

	/**
	 * Create a TabFolder with three tabs for Project, Groups, and Users.
	 * 
	 * @param sash
	 */
	private void createTabFolder(SashForm sash) {

		tabFolder = new TabFolder(sash, SWT.NONE);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		tabFolder.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}

			public void widgetSelected(SelectionEvent e) {
				switch (tabFolder.getSelectionIndex()) {
				case 0:
					activeTabContent = projectsTabContents;
					break;
				case 1:
					activeTabContent = groupsTabContents;
					break;
				case 2:
					activeTabContent = usersTabContents;
					break;
				default:
					break;

				}

			}

		});

	}

	private PropertiesForm createPropertiesForm(SashForm sash,
			AdminBroker adminBroker) {

		FormToolkit toolkit = new FormToolkit(sash.getDisplay());

		PropertiesForm frm = new PropertiesForm(sash, SWT.NONE, adminBroker,
				this);
		frm.setText("Properties");
		frm.setFont(JFaceResources.getHeaderFont());

		toolkit.decorateFormHeading(frm);

		return frm;

	}

	/**
	 * This creates the tabs within tab folder and sets sets AdminBorker and
	 * PropertiesForm for them. Tab items need to be aware of properties form in
	 * order to set its input on double click or do a drag and drop operation.
	 * 
	 * @param adminBroker
	 * @param frm
	 */
	private void initTabFolder(AdminBroker adminBroker, PropertiesForm frm) {

		TabItem projectsTab = new TabItem(tabFolder, SWT.NONE);
		projectsTabContents = new TabContent("Projects", adminBroker, frm);
		projectsTab.setControl(projectsTabContents.createContents(tabFolder));
		projectsTab.setText(projectsTabContents.getName());

		TabItem groupsTab = new TabItem(tabFolder, SWT.NONE);
		groupsTabContents = new TabContent("Groups", adminBroker, frm);
		groupsTab.setControl(groupsTabContents.createContents(tabFolder));
		groupsTab.setText(groupsTabContents.getName());

		TabItem usersTab = new TabItem(tabFolder, SWT.NONE);
		usersTabContents = new TabContent("Users", adminBroker, frm);
		usersTab.setControl(usersTabContents.createContents(tabFolder));
		usersTab.setText(usersTabContents.getName());

		tabFolder.setSelection(projectsTab);

		// set initial input to properties form
		projectsTabContents.viewStarted();
	}

	private int[] sashWeights() {
		return new int[] { 25, 75 };
	}

	/**
	 * {@inheritDoc}
	 */
	public void setFocus() {
		tabFolder.setFocus();
	}

	/**
	 * This will be used by GroupComposite and UserComposite. When name of a
	 * group or user is changed, this must be reflected in corresponding tab.
	 * This done by refreshing the ListViewer on a tab.
	 * 
	 * @return Active tab of TabFolder
	 */
	public TabContent getActiveTabContent() {
		return this.activeTabContent;

	}

}
