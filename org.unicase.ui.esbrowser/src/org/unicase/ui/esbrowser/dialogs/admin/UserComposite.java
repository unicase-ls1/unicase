package org.unicase.ui.esbrowser.dialogs.admin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Form;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.AdminBroker;

public class UserComposite extends PropertiesComposite {

	private ACUser user;
	private OrgUnitManagementGUI orgUnitMgmtGUI;

	public UserComposite(Composite parent, int style, AdminBroker adminBroker,
			OrgUnitManagementGUI orgUnitMgmtGUI) {
		super(parent, style, adminBroker);
		this.orgUnitMgmtGUI = orgUnitMgmtGUI;
		createControls();
	}

	protected void removeOrgUnit(ACOrgUnit group) {
		try {
			getAdminBroker().removeGroup(user.getId(),
					((ACGroup) group).getId());
		} catch (EmfStoreException e) {
			DialogHandler.showExceptionDialog(e);
		}
		getTableViewer().refresh();
	}

	@Override
	protected void addExistingOrgUnit(ACOrgUnit group) {

		try {
			if (group != null) {
				getAdminBroker().addMember(((ACGroup) group).getId(),
						user.getId());

			}
		} catch (EmfStoreException e) {
			DialogHandler.showExceptionDialog(e);
		}
		getTableViewer().refresh();
	}

	@Override
	protected void addNewOrgUnit() {

		try {
			List<ACGroup> groups = getGroups();
			for (ACGroup newGroup : groups) {

				getAdminBroker().addMember(newGroup.getId(), user.getId());

			}

		} catch (EmfStoreException e) {
			DialogHandler.showExceptionDialog(e);
		}
		getTableViewer().refresh();
	}

	private List<ACGroup> getGroups() {
		// 1. show a list of all AcOrgUnits that do not participate in this
		// project
		// (get list of all AcOrgUnits, remove those who take part in this
		// Project)
		// 2. return the selected participant
		// EClass clazz = eReference.getEReferenceType();

		// JH: fill only with right elements
		Collection<ACOrgUnit> allGroups = new BasicEList<ACOrgUnit>();
		List<ACGroup> groups = new ArrayList<ACGroup>();

		try {
			allGroups.addAll(getAdminBroker().getGroups());
			List<ACGroup> groupsToRemove = new ArrayList<ACGroup>();
			groupsToRemove.addAll(getAdminBroker().getGroups(user.getId()));
			// its really funnyyyyyyy!!!!!!!! :((
			// you should implement all typical list operations yourself.
			// because contains(), remove(), indexof(), .... all require a test
			// of
			// equality and here we have a problem.

			allGroups.removeAll(groupsToRemove);

			Object[] result = showDialog(allGroups, "Select a group");

			for (int i = 0; i < result.length; i++) {
				if (result[i] instanceof ACGroup) {
					groups.add((ACGroup) result[i]);
				}
			}
		} catch (EmfStoreException e) {
			DialogHandler.showExceptionDialog(e);
		}
		return groups;
	}

	protected void createTableGroup() {
		super.createTableGroup("Groups");
	}

	@Override
	public void updateControls(EObject input) {
		super.updateControls(input);
		if (input != null && input instanceof ACUser) {

			this.user = (ACUser) input;

			getTxtName().setText(user.getName());
			getTxtDescription().setText(
					(user.getDescription() == null) ? "" : user
							.getDescription());
			getTableViewer().setInput(user);

		}

	}

	@Override
	protected void addDragNDropSupport() {
		// add drag support
		super.addDragNDropSupport();

		// add drop support
		int ops = DND.DROP_COPY;
		Transfer[] transfers = new Transfer[] { LocalSelectionTransfer
				.getTransfer() };
		DropTargetListener dropListener = new DropTargetListener() {
			public void dragEnter(DropTargetEvent event) {
				if (PropertiesForm.getDragSource().equals("Projects")
						|| PropertiesForm.getDragSource().equals("Users")) {
					event.detail = DND.DROP_NONE;

				} else {
					event.detail = DND.DROP_COPY;
				}
			}

			public void drop(DropTargetEvent event) {
				if (PropertiesForm.getDragNDropObject() != null) {
					if (PropertiesForm.getDragNDropObject() instanceof ACGroup) {
						ACGroup group = (ACGroup) PropertiesForm
								.getDragNDropObject();
						addExistingOrgUnit(group);
						PropertiesForm.setDragNDropObject(null);
						getTableViewer().refresh();
					}
				}
			}

			public void dragLeave(DropTargetEvent event) {
			}

			public void dragOperationChanged(DropTargetEvent event) {
			}

			public void dragOver(DropTargetEvent event) {
			}

			public void dropAccept(DropTargetEvent event) {
			}

		};
		getTableViewer().addDropSupport(ops, transfers, dropListener);

	}

	@Override
	protected void saveOrgUnitAttributes() {
		if (getTxtName() == null || getTxtDescription() == null) {
			return;
		}
		if (user == null) {
			return;
		}
		if (!(user.getName().equals(getTxtName().getText()) && user
				.getDescription().equals(getTxtDescription().getText()))) {
			try {
				getAdminBroker().changeOrgUnit(user.getId(),
						getTxtName().getText(), getTxtDescription().getText());
				((Form) (this.getParent().getParent())).setText("User: "
						+ getTxtName().getText());
				orgUnitMgmtGUI.getActiveTabContent().getListViewer().refresh();

			} catch (EmfStoreException e) {
				// ZH Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
