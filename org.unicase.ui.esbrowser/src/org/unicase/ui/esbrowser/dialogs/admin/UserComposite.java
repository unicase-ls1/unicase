package org.unicase.ui.esbrowser.dialogs.admin;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.widgets.Composite;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.AdminBroker;
import org.unicase.workspace.WorkspaceManager;

public class UserComposite extends FormContents {

	private ACUser user;

	public UserComposite(Composite parent, int style, AdminBroker adminBroker) {
		super(parent, style, adminBroker);
		createControls();
	}

	protected void removeOrgUnit(ACOrgUnit group) {
		try {
			adminBroker.removeGroup(
					user.getId(), ((ACGroup) group).getId());
		} catch (EmfStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tableViewer.refresh();
	}

	protected void addOrgUnit(ACOrgUnit group) {
		// 1. show a list of all AcOrgUnits that do not participate in this
		// project
		// (get list of all AcOrgUnits, remove those who take part in this
		// Project)
		// 2. add the selected participant to the project
		//try {
			//FIXME: i changed the interface, please adapt the method usage
			/**
			if (group != null) {
				adminBroker.addGroup(
						user, ((ACGroup) group).getId());

			} else {
				EList<ACGroup> groups = getGroups();
				for (ACGroup newGroup : groups) {

					adminBroker
							.addGroup(user, newGroup.getId());

				}
			} 
		} catch (EmfStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		tableViewer.refresh();
	}

	private EList<ACGroup> getGroups() {
		// 1. show a list of all AcOrgUnits that do not participate in this
		// project
		// (get list of all AcOrgUnits, remove those who take part in this
		// Project)
		// 2. return the selected participant
		// EClass clazz = eReference.getEReferenceType();

		// JH: fill only with right elements
		Collection<ACOrgUnit> allGroups = new BasicEList<ACOrgUnit>();
		EList<ACGroup> groups = new BasicEList<ACGroup>();

		try {
			allGroups.addAll(adminBroker.getGroups());

			allGroups.removeAll(adminBroker.getGroups(user.getId()));

			Object[] result = showDialog(allGroups, "Select a group");

			for (int i = 0; i < result.length; i++) {
				if (result[i] instanceof ACGroup) {
					groups.add((ACGroup) result[i]);
				}
			}
		} catch (EmfStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return groups;
	}

	protected void createTableGroup() {
		super.createTableGroup();
		grpTable.setText("Groups");
	}

	public void updateControls(ACUser user) {
		this.user = user;

		txtName.setText(user.getName());
		txtDescription.setText((user.getDescription()== null)? "" : user.getDescription());
		tableViewer.setInput(user);

	}

}
