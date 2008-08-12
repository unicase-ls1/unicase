package org.unicase.ui.esbrowser.dialogs.admin;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.AdminBroker;

//
//591
//
public class OrgUnitManagementGUI {

	private TabFolder tabFolder;
	private PropertiesForm frm;
	private AdminBroker adminBroker;
	private TabContent activeTabContent;
	private TabContent projectsTabContents;
	private TabContent groupsTabContents;
	private TabContent usersTabContents;
	private TableViewer formTableViewer; 


	public OrgUnitManagementGUI(Composite parent, AdminBroker adminBroker) {

		//parent.setBackground(parent.getShell().getDisplay().getSystemColor(SWT.COLOR_BLUE));
		
		this.adminBroker = adminBroker;
		createSash(parent);
	}

	// public void setAdminBroker(AdminBroker adminBroker) {
	// this.adminBroker = adminBroker;
	// initTabFolder();
	// }

	// public AdminBroker getAdminBroker() {
	// return adminBroker;
	// }

	private void createSash(Composite parent) {
		SashForm sash = new SashForm(parent, SWT.HORIZONTAL);
		sash.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// first create the tab folder, then the form, and then set the TabItems
		// in tab folder.
		// why this order? because
		// 1. tab folder should appear left of form (first control on sash)
		// 2. Tabs shown in TabItems need to be aware of form (first create
		// form, then tabs.)
		createTabFolder(sash);
		createPropertiesForm(sash);
		initTabFolder();

		sash.setWeights(sashWeights());
	}

	private void createTabFolder(SashForm sash) {

		tabFolder = new TabFolder(sash, SWT.NONE);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		tabFolder.addSelectionListener(new SelectionListener(){

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}

			public void widgetSelected(SelectionEvent e) {
				switch (tabFolder.getSelectionIndex()){
				case 0 :
					activeTabContent=projectsTabContents;
					break;
				case 1: 
					activeTabContent = groupsTabContents;
					break;
				case 2: 
					activeTabContent = usersTabContents;
					break;
					
				}
				
			}
			
		});

	}

	private void createPropertiesForm(SashForm sash) {

		FormToolkit toolkit = new FormToolkit(sash.getDisplay());

		frm = new PropertiesForm(sash, SWT.NONE, adminBroker, this);
		frm.setText("Properties");
		frm.setFont(JFaceResources.getHeaderFont());

		toolkit.decorateFormHeading(frm);

	}

	private void initTabFolder() {

		TabItem projectsTab = new TabItem(tabFolder, SWT.NONE);
		projectsTabContents = new TabContent("Projects", adminBroker, this);
		projectsTabContents.setPropertiesForm(frm);
		projectsTab.setControl(projectsTabContents.createContents(tabFolder));
		projectsTab.setText(projectsTabContents.getName());

		TabItem groupsTab = new TabItem(tabFolder, SWT.NONE);
		groupsTabContents = new TabContent("Groups", adminBroker, this);
		groupsTabContents.setPropertiesForm(frm);
		groupsTab.setControl(groupsTabContents.createContents(tabFolder));
		groupsTab.setText(groupsTabContents.getName());

		TabItem usersTab = new TabItem(tabFolder, SWT.NONE);
		usersTabContents = new TabContent("Users", adminBroker, this);
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
		// tabFolder = null;
		// frm = null;

	}
	
	
	public TabContent getActiveTabContent(){
		return this.activeTabContent;
		
	}

	public TableViewer getFormTableViewer() {
		// TODO Auto-generated method stub
		return this.formTableViewer;
	}

	public void setFormTableViewer(TableViewer tableViewer) {
		this.formTableViewer = tableViewer;
		
	}
	
	

}
