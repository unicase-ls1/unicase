/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholderview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Widget;
import org.unicase.ecp.model.NoWorkspaceException;
import org.unicase.ecp.model.workSpaceModel.ECPProject;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.urml.StakeholderRole;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.ui.urml.stakeholderview.reviewview.input.UrmlTreeHandler;

/**
 * Dialog for managing the stakeholder roles.
 * 
 * @author kterzieva
 */
public class ManageRolesDialog extends TitleAreaDialog {

	private static final String SELECT_STAKEHOLDER_ROLE = "Select stakeholder role.";
	private static final String MANAGE_STAKEHOLDER_ROLES = "Manage stakeholder roles";
	private Table table;
	private Button addButton, removeSelectedButton, editButton;
	private List<StakeholderRole> stakeholderRoles;
	private AdapterFactoryLabelProvider labelProvider;
	private ECPProject activeProject;
	private Collection<StakeholderRole> list;

	/**
	 * The constructor. The list with the created roles is created.
	 * 
	 * @param parentShell the shell
	 */
	public ManageRolesDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		try {
			activeProject = UrmlTreeHandler.getTestProject();
		} catch (NoWorkspaceException e) {
			 ModelUtil.logException(e);
		}
		stakeholderRoles = new ArrayList<StakeholderRole>();
		Collection<EObject> basicList = activeProject.getAllModelElementsbyClass(UrmlPackage.eINSTANCE
			.getStakeholderRole(), new BasicEList<EObject>());
		list = new ArrayList<StakeholderRole>();
		for (EObject role : basicList) {
			list.add((StakeholderRole) role);
		}
		stakeholderRoles.addAll(list);

	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setSize(300, 400);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		setTitle(MANAGE_STAKEHOLDER_ROLES);
		setMessage(SELECT_STAKEHOLDER_ROLE);

		// Create composite
		Composite composite = (Composite) super.createDialogArea(parent);
		// Layout stuff
		GridLayout gridLayout = new GridLayout(3, false);
		composite.setLayout(gridLayout);

		// The table displaying the currently selected assignees
		table = new Table(composite, SWT.BORDER | SWT.MULTI);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		// table.addSelectionListener(listener);

		// Buttons
		addButton = new Button(composite, SWT.PUSH);
		addButton.setText("Add role..");
		addButton.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, false, false, 1, 1));
		addButton.setToolTipText("Add additional assignees or groups of assignees to the list");
		addButton.addListener(SWT.Selection, new ManageRoleDialogListener());

		removeSelectedButton = new Button(composite, SWT.PUSH);
		removeSelectedButton.setText("Remove selected role");
		removeSelectedButton.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, false, false, 1, 1));
		removeSelectedButton.setEnabled(false);
		removeSelectedButton.setToolTipText("Remove the selected role from the list");
		// removeSelectedButton.addListener(SWT.Selection, listener);

		editButton = new Button(composite, SWT.PUSH);
		editButton.setText("Edit role..");
		editButton.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, false, false, 1, 1));
		editButton.setToolTipText("Edit selected stakeholder role.");
		editButton.addListener(SWT.Selection, new ManageRoleDialogListener());

		// Set control, update table (clear it) and show the user-add-dialog
		// setControl(composite);
		updateUI();
		// showUserDialog();

		return composite;
	}

	private void updateUI() {
		// Turn off drawing to avoid flicker
		table.setRedraw(false);

		// Truncate table
		table.removeAll();

		// Repopulate table from selection
		for (StakeholderRole u : stakeholderRoles) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setData(u);
			item.setImage(labelProvider.getImage(u));
			item.setText(u.getName());
		}

		// Turn drawing back on!
		table.setRedraw(true);

		// Since we just rebuilt the table, there cannot be any selected items, so disable the remove selected button
		removeSelectedButton.setEnabled(false);
	}

	/**
	 * Listener of the manage role dialog buttons.
	 * 
	 * @author kterzieva
	 */
	private class ManageRoleDialogListener implements Listener, SelectionListener {

		public void handleEvent(Event event) {
			Widget w = event.widget;
			if (w == addButton) {

			} else if (w == editButton) {
				createEditRoleDialog();
			} else if (w == removeSelectedButton) {
				TableItem[] selects = table.getSelection();
				for (TableItem t : selects) {
					if (t.getData() instanceof StakeholderRole) {
						StakeholderRole u = (StakeholderRole) t.getData();
						stakeholderRoles.remove(u);
					}
				}

				updateUI();
			}
		}

		private void createEditRoleDialog() {
			EditRoleDialog editDialog = new EditRoleDialog(editButton.getShell());
			editDialog.open();
		}

		public void widgetDefaultSelected(SelectionEvent e) {
		}

		public void widgetSelected(SelectionEvent e) {
			// Button is only enabled if objects are selected
			removeSelectedButton.setEnabled(table.getSelection().length > 0);
		}

	}

}
