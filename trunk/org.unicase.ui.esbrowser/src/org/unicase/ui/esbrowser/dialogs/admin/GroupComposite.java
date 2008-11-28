package org.unicase.ui.esbrowser.dialogs.admin;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
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

public class GroupComposite extends PropertiesComposite {

	private ACGroup group;
	private OrgUnitManagementGUI orgUnitMgmtGUI;

	public GroupComposite(Composite parent, int style, AdminBroker adminBroker,
			OrgUnitManagementGUI orgUnitMgmtGUI) {
		super(parent, style, adminBroker);
		this.orgUnitMgmtGUI = orgUnitMgmtGUI;
		createControls();
	}

	protected void removeOrgUnit(ACOrgUnit orgUnit) {

		try {
			getAdminBroker().removeMember(group.getId(), orgUnit.getId());

		} catch (EmfStoreException e) {
			// ZH Auto-generated catch block
			e.printStackTrace();
		}
		getTableViewer().refresh();
	}

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

	@Override
	protected void addNewOrgUnit() {
		EList<ACOrgUnit> members = getNewMembers();
		for (ACOrgUnit ou : members) {
			try {
				getAdminBroker().addMember(group.getId(), ou.getId());

			} catch (EmfStoreException e) {
				// ZH Auto-generated catch block
				e.printStackTrace();
			}
		}

		getTableViewer().refresh();
	}

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

	protected void createTableGroup() {
		super.createTableGroup("Members");
	}

	@Override
	public void updateControls(EObject input) {

		super.updateControls(input);
		if (input != null && input instanceof ACGroup) {

			this.group = (ACGroup) input;

			getTxtName().setText(group.getName());
			getTxtDescription().setText(
					(group.getDescription() == null) ? "" : group
							.getDescription());
			getTableViewer().setInput(group);

		}

	}

	@Override
	protected void saveOrgUnitAttributes() {
		if (getTxtName() == null || getTxtDescription() == null) {
			return;
		}
		if (group == null) {
			return;
		}
		if (!(group.getName().equals(getTxtName().getText()) && group
				.getDescription().equals(getTxtDescription().getText()))) {
			try {
				getAdminBroker().changeOrgUnit(group.getId(),
						getTxtName().getText(), getTxtDescription().getText());
				((Form) (this.getParent().getParent())).setText("Group: "
						+ getTxtName().getText());
				orgUnitMgmtGUI.getActiveTabContent().getListViewer().refresh();
			} catch (EmfStoreException e) {
				DialogHandler.showExceptionDialog(e);
			}
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
				if (PropertiesForm.getDragSource().equals("Projects")) {
					event.detail = DND.DROP_NONE;
				} else {
					event.detail = DND.DROP_COPY;
				}
			}
			
			public void drop(DropTargetEvent event) {
				if (PropertiesForm.getDragNDropObject() != null) {
					if (PropertiesForm.getDragNDropObject() instanceof ACOrgUnit) {
						ACOrgUnit orgUnit = (ACOrgUnit) PropertiesForm
								.getDragNDropObject();
						addExistingOrgUnit(orgUnit);
						PropertiesForm.setDragNDropObject(null);
						getTableViewer().refresh();
					}
				}
			}
			public void dragLeave(DropTargetEvent event) {	}
			public void dragOperationChanged(DropTargetEvent event) {		}
			public void dragOver(DropTargetEvent event) {		}
			public void dropAccept(DropTargetEvent event) {		}
		};
		getTableViewer().addDropSupport(ops, transfers, dropListener);

	}

} // GroupComposite

