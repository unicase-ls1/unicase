/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.dialogs.admin;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Form;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.AdminBroker;

/**
 * This shows attributes of a ACGroup (name, description) and show a list of its member OrgUnits. You can use drag and
 * drop to drop a group or a user on memebers list, and it will be added to memebers.
 * 
 * @author Hodaie
 */
public class GroupComposite extends PropertiesComposite {

	private ACGroup group;
	private OrgUnitManagementGUI orgUnitMgmtGUI;

	/**
	 * Constructor.
	 * 
	 * @param parent parent
	 * @param style style
	 * @param adminBroker used to communicate with the server
	 * @param orgUnitMgmtGUI used to find out what which tab is active, so that if needed update its list viewer
	 */
	public GroupComposite(Composite parent, int style, AdminBroker adminBroker, OrgUnitManagementGUI orgUnitMgmtGUI) {
		super(parent, style, adminBroker);
		this.orgUnitMgmtGUI = orgUnitMgmtGUI;
		createControls();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void removeOrgUnit(ACOrgUnit orgUnit) {

		try {
			getAdminBroker().removeMember(group.getId(), orgUnit.getId());

		} catch (EmfStoreException e) {
			DialogHandler.showExceptionDialog(e);
		}
		getTableViewer().refresh();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void addExistingOrgUnit(ACOrgUnit orgUnit) {

		if (orgUnit != null) {
			if (!orgUnit.equals(group)) {
				try {
					getAdminBroker().addMember(group.getId(), orgUnit.getId());

				} catch (EmfStoreException e) {
					DialogHandler.showExceptionDialog(e);
				}
			}

		}
		getTableViewer().refresh();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void addNewOrgUnit() {
		EList<ACOrgUnit> members = getNewMembers();
		for (ACOrgUnit ou : members) {
			try {
				getAdminBroker().addMember(group.getId(), ou.getId());

			} catch (EmfStoreException e) {
				DialogHandler.showExceptionDialog(e);
			}
		}

		getTableViewer().refresh();
	}

	/**
	 * This will be used when adding a new member using add button. It shows a list of ACOrgUnits on the server.
	 * 
	 * @return selected elements
	 */
	private EList<ACOrgUnit> getNewMembers() {
		// 1. show a list of all AcOrgUnits that are not member of this group
		// (get list of all AcOrgUnits, remove those who take part in this
		// 2. return the selected ACOrgunits

		Collection<ACOrgUnit> allOrgUnits = new BasicEList<ACOrgUnit>();
		EList<ACOrgUnit> members = new BasicEList<ACOrgUnit>();
		try {
			allOrgUnits.addAll(getAdminBroker().getOrgUnits());
			allOrgUnits.removeAll(getAdminBroker().getMembers(group.getId()));
			if (allOrgUnits.contains(group)) {
				allOrgUnits.remove(group);
			}

			Object[] result = showDialog(allOrgUnits, "Select a member");

			for (int i = 0; i < result.length; i++) {
				if (result[i] instanceof ACOrgUnit) {
					members.add((ACOrgUnit) result[i]);
				}
			}
		} catch (EmfStoreException e) {
			// ZH Auto-generated catch block
			e.printStackTrace();
		}
		return members;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createTableGroup() {
		super.createTableGroup("Members");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateControls(EObject input) {

		if (input != null && input instanceof ACGroup) {

			this.group = (ACGroup) input;

			getTxtName().setText(group.getName());
			getTxtDescription().setText((group.getDescription() == null) ? "" : group.getDescription());
			getTableViewer().setInput(group);

		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void saveOrgUnitAttributes() {
		if (getTxtName() == null || getTxtDescription() == null) {
			return;
		}
		if (group == null) {
			return;
		}
		if (!(group.getName().equals(getTxtName().getText()) && group.getDescription().equals(
			getTxtDescription().getText()))) {
			try {
				getAdminBroker().changeOrgUnit(group.getId(), getTxtName().getText(), getTxtDescription().getText());
				((Form) (this.getParent().getParent())).setText("Group: " + getTxtName().getText());
				orgUnitMgmtGUI.getActiveTabContent().getTableViewer().refresh();
			} catch (EmfStoreException e) {
				DialogHandler.showExceptionDialog(e);
			}
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void addDragNDropSupport() {

		// add drag support
		super.addDragNDropSupport();

		// add drop support
		int ops = DND.DROP_COPY;
		Transfer[] transfers = new Transfer[] { LocalSelectionTransfer.getTransfer() };
		DropTargetListener dropListener = new DropTargetAdapter() {
			@Override
			public void dragEnter(DropTargetEvent event) {
				if (PropertiesForm.getDragSource().equals("Projects")) {
					event.detail = DND.DROP_NONE;
				} else {
					event.detail = DND.DROP_COPY;
				}
			}

			@Override
			public void drop(DropTargetEvent event) {
				if (PropertiesForm.getDragNDropObject() != null) {
					if (PropertiesForm.getDragNDropObject() instanceof ACOrgUnit) {
						ACOrgUnit orgUnit = (ACOrgUnit) PropertiesForm.getDragNDropObject();
						addExistingOrgUnit(orgUnit);
						PropertiesForm.setDragNDropObject(null);
						getTableViewer().refresh();
					}
				}
			}
		};
		getTableViewer().addDropSupport(ops, transfers, dropListener);

	}

} // GroupComposite

