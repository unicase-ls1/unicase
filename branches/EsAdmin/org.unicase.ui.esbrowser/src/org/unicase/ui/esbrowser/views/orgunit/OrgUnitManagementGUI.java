package org.unicase.ui.esbrowser.views.orgunit;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class OrgUnitManagementGUI {

	private TabFolder tabFolder;
	private PropertiesForm frm;
	private SashForm sash;
	private Composite parent;

	public OrgUnitManagementGUI(Composite parent) {
		this.parent = parent;
		createSash();
	}

	private void createSash() {
		sash = new SashForm(parent, SWT.HORIZONTAL);

		/* Create the "layout" and "control" columns */
		createTabFolder();
		createPropertiesForm();
		initTabFolder();
		
		sash.setWeights(sashWeights());
	}

	
	private void createTabFolder() {

		tabFolder = new TabFolder(sash, SWT.NONE);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		}
	
	private void initTabFolder() {
		
		TabItem projectsTab = new TabItem(tabFolder, SWT.NONE);
		Tab projectsTabPage = new Tab("Projects");
		projectsTab.setControl(projectsTabPage.createTabFolderPage(tabFolder));
		projectsTab.setText(projectsTabPage.getName());

		TabItem groupsTab = new TabItem(tabFolder, SWT.NONE);
		Tab groupsTabPage = new Tab("Groups");
		groupsTab.setControl(groupsTabPage.createTabFolderPage(tabFolder));
		groupsTab.setText(groupsTabPage.getName());

		TabItem usersTab = new TabItem(tabFolder, SWT.NONE);
		Tab usersTabPage = new Tab("Users");
		usersTab.setControl(usersTabPage.createTabFolderPage(tabFolder));
		usersTab.setText(usersTabPage.getName());

	}


	private void createPropertiesForm() {

		FormToolkit toolkit = new FormToolkit(sash.getDisplay());
		// Form frm = toolkit.createForm(sash);

		frm = new PropertiesForm(sash, SWT.NONE);
		//frm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		frm.setText("Properties");
		frm.setFont(JFaceResources.getHeaderFont());

		toolkit.decorateFormHeading(frm);

	}
	

	private int[] sashWeights() {
		return new int[] { 25, 75 };
	}

	public void setFocus() {
		tabFolder.setFocus();
	}

	public void dispose() {
		tabFolder = null;

	}

}
