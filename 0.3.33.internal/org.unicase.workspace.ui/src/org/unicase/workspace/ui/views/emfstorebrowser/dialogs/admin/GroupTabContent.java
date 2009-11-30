/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.dialogs.admin;

import org.eclipse.draw2d.GridData;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TabFolder;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.AdminBroker;

/**
 * @author gurcankarakoc
 */
public class GroupTabContent extends TabContent {

	/**
	 * @param string
	 *            the name of tab.
	 * @param adminBroker
	 *            AdminBroker is needed to communicate with server.
	 * @param frm
	 *            used to set input to properties form and update its table
	 *            viewer upon. deletion of OrgUnits.
	 */
	public GroupTabContent(String string, AdminBroker adminBroker,
			PropertiesForm frm) {
		super(string, adminBroker, frm);
		this.setTab(this);
	}

	/**
	 * @see org.unicase.ui.esbrowser.dialogs.admin.TabContent#createButtons(org.eclipse.swt.widgets.Composite)
	 * @param tabContent
	 *            is the Composite.
	 */
	@Override
	public void createButtons(Composite tabContent) {
		// Create and configure the "New" button
		Button btnNew = new Button(tabContent, SWT.PUSH);
		btnNew.setText("New Group");

		btnNew.addSelectionListener(new SelectionAdapter() {
			// create a new OrgUnit
			@Override
			public void widgetSelected(SelectionEvent e) {
				newOrgUnit();
				getForm().getTableViewer().refresh();
			}

		});

		// Create and configure the "Delete" button
		Button btnDelete = new Button(tabContent, SWT.PUSH);
		btnDelete.setText("Delete Group");// User");

		btnDelete.addSelectionListener(new SelectionAdapter() {
			// Remove the selection and refresh the view
			@Override
			public void widgetSelected(SelectionEvent e) {

				deleteOrgUnit();
				// If form input is a project, and from users of groups tab one
				// of participants of this project is deleted, then the table
				// viewer on project properties must be updated.
				// Accordingly, if a group is open and one of its users is
				// deleted, or if a user is open and one of its groups is
				// deleted.
				// form.getTableViewer().refresh();
			}
		});

		Button importButton = new Button(tabContent, SWT.PUSH);
		importButton.setText("Import Group");

		importButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AcUserImportWizard wizard = new AcUserImportWizard(
						getAdminBroker(), getListViewer());
				WizardDialog dialog = new WizardDialog(Display.getCurrent()
						.getActiveShell(), wizard);
				dialog.create();
				dialog.open();
			}
		});

	}

	/**
	 * @see org.unicase.ui.esbrowser.dialogs.admin.TabContent#createContents(org.eclipse.swt.widgets.TabFolder)
	 * @param tabFolder
	 *            TabFolder.
	 * @return Composite.
	 */
	@Override
	protected Composite createContents(TabFolder tabFolder) {
		Composite tabContent = new Composite(tabFolder, SWT.NONE);
		tabContent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		tabContent.setLayout(new GridLayout(2, false));

		initList(tabContent);

		createButtons(tabContent);

		return tabContent;
	}

	/**
	 * @see org.unicase.ui.esbrowser.dialogs.admin.TabContent#newOrgUnit()
	 */
	@Override
	protected void newOrgUnit() {
		try {
			getAdminBroker().createGroup("New Group");
		} catch (EmfStoreException e) {

			DialogHandler.showExceptionDialog(e);
		}
		getListViewer().refresh();

	}

	/**
	 * @see org.unicase.ui.esbrowser.dialogs.admin.TabContent#deleteOrgUnit()
	 */
	@Override
	protected void deleteOrgUnit() {

		ACGroup ou = (ACGroup) ((IStructuredSelection) getListViewer()
				.getSelection()).getFirstElement();
		if (ou == null) {
			return;
		}

		try {
			getAdminBroker().deleteGroup(ou.getId());
		} catch (EmfStoreException e) {

			DialogHandler.showExceptionDialog(e);
		}

		getListViewer().refresh();
		if (getForm().getCurrentInput() instanceof ACOrgUnit
				&& getForm().getCurrentInput().equals(ou)) {
			getForm().setInput(null);
		}

	}

}
