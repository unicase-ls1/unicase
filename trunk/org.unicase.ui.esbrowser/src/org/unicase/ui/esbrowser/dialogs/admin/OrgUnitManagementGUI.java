package org.unicase.ui.esbrowser.dialogs.admin;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.unicase.workspace.AdminBroker;

//
//591
//
public class OrgUnitManagementGUI {

	private TabFolder tabFolder;
	private PropertiesForm frm;
	private AdminBroker adminBroker;

	private static OrgUnitManagementGUI instance;

	public static synchronized OrgUnitManagementGUI createInstance(
			Composite parent) {
		if (instance == null) {
			instance = new OrgUnitManagementGUI(parent);
		}
		return instance;
	}

	public static OrgUnitManagementGUI getInstance() {
		if (instance != null) {
			return instance;
		} else {
			return null;
		}
	}

	private OrgUnitManagementGUI(Composite parent) {
		createSash(parent);
//		parent
//				.setBackground(parent.getDisplay().getSystemColor(
//						SWT.COLOR_BLUE));

	}

	public void setAdminBroker(AdminBroker adminBroker) {
		this.adminBroker = adminBroker;
		initTabFolder();
	}

	public AdminBroker getAdminBroker() {
		return adminBroker;
	}

	private void createSash(Composite parent) {
		SashForm sash = new SashForm(parent, SWT.HORIZONTAL);

		// first create the tab folder, then the form, and then set the TabItems
		// in tab folder.
		// why this order? because
		// 1. tab folder should appear left of form (first control on sash)
		// 2. Tabs shown in TabItems need to be aware of form (first create
		// form, then tabs.)
		createTabFolder(sash);
		createPropertiesForm(sash);
	

		sash.setWeights(sashWeights());
	}

	private void createTabFolder(SashForm sash) {

		tabFolder = new TabFolder(sash, SWT.NONE);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

	}

	private void createPropertiesForm(SashForm sash) {

		FormToolkit toolkit = new FormToolkit(sash.getDisplay());

		frm = new PropertiesForm(sash, SWT.NONE);
		frm.setText("Properties");
		frm.setFont(JFaceResources.getHeaderFont());

		toolkit.decorateFormHeading(frm);

	}

	private void initTabFolder() {

		TabItem projectsTab = new TabItem(tabFolder, SWT.NONE);
		TabContent projectsTabContents = new TabContent("Projects");
		projectsTabContents.setPropertiesForm(frm);
		projectsTab.setControl(projectsTabContents.createContents(tabFolder));
		projectsTab.setText(projectsTabContents.getName());

		TabItem groupsTab = new TabItem(tabFolder, SWT.NONE);
		TabContent groupsTabContents = new TabContent("Groups");
		groupsTabContents.setPropertiesForm(frm);
		groupsTab.setControl(groupsTabContents.createContents(tabFolder));
		groupsTab.setText(groupsTabContents.getName());

		TabItem usersTab = new TabItem(tabFolder, SWT.NONE);
		TabContent usersTabContents = new TabContent("Users");
		usersTabContents.setPropertiesForm(frm);
		usersTab.setControl(usersTabContents.createContents(tabFolder));
		usersTab.setText(usersTabContents.getName());

		tabFolder.setSelection(projectsTab);
		projectsTabContents.viewStarted();
	}

	private int[] sashWeights() {
		return new int[] { 25, 75 };
	}

	public void setFocus() {
		tabFolder.setFocus();
	}

	public void dispose() {
		tabFolder = null;
		frm = null;

	}

}
