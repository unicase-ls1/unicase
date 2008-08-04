package org.unicase.ui.esbrowser.dialogs.admin;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.widgets.Composite;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.AdminBroker;
import org.unicase.workspace.WorkspaceManager;

public class GroupComposite extends FormContents {

	private ACGroup group;

	public GroupComposite(Composite parent, int style, AdminBroker adminBroker) {
		super(parent, style, adminBroker);
		createControls();
	}

	protected void removeOrgUnit(ACOrgUnit orgUnit) {
		int index = group.getMembers().indexOf(orgUnit);
		group.getMembers().remove(index);
		tableViewer.refresh();
	}

	protected void addOrgUnit(ACOrgUnit orgUnit) {
		// 1. show a list of all AcOrgUnits that do not participate in this
		// project
		// (get list of all AcOrgUnits, remove those who take part in this
		// Project)
		// 2. add the selected participant to the project
		if (orgUnit != null) {
			if (!orgUnit.equals(group)) {
				group.getMembers().add(orgUnit);
			}

		} else {
			EList<ACOrgUnit> members = getMembers();
			for (ACOrgUnit ou : members) {
				group.getMembers().add(ou);
			}
		}
		tableViewer.refresh();

	}

	private EList<ACOrgUnit> getMembers() {
		// 1. show a list of all AcOrgUnits that are not member of this group
		// (get list of all AcOrgUnits, remove those who take part in this
		// 2. return the selected ACOrgunits

		Collection<ACOrgUnit> allOrgUnits = new BasicEList<ACOrgUnit>();
		EList<ACOrgUnit> members = new BasicEList<ACOrgUnit>();
		try {
			allOrgUnits.addAll(adminBroker.getOrgUnits());
			allOrgUnits.removeAll(group.getMembers());
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return members;
	}

	protected void createTableGroup() {
		super.createTableGroup();
		grpTable.setText("Members");
	}

	public void updateControls(ACGroup group) {
		this.group = group;

		txtName.setText(group.getName());
		txtDescription.setText((group.getDescription()==null) ? "" : group.getDescription() );
		tableViewer.setInput(group);
	}

} // GroupComposite

