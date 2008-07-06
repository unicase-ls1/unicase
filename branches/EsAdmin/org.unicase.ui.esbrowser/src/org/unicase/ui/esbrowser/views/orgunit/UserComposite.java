package org.unicase.ui.esbrowser.views.orgunit;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.widgets.Composite;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.workspace.WorkspaceManager;

public class UserComposite extends FormContents {

	
	private ACUser user;
	
	
	public UserComposite(Composite parent, int style) {
		super(parent, style);
		createControls();
	}

	
   	protected void removeOrgUnit(ACOrgUnit group) {
		WorkspaceManager.getInstance().getAdminConnectionManager().removeGroup(user, (ACGroup)group);
		tableViewer.refresh();
	}

	protected void addOrgUnit(ACOrgUnit group) {
		// 1. show a list of all AcOrgUnits that do not participate in this
		// project
		// (get list of all AcOrgUnits, remove those who take part in this
		// Project)
		// 2. add the selected participant to the project
	
		if (group != null){
			WorkspaceManager.getInstance().getAdminConnectionManager().addGroup(user, (ACGroup)group);
			
		} else {
			EList<ACGroup> groups = getGroups();
			for (ACGroup newGroup : groups) {
				WorkspaceManager.getInstance().getAdminConnectionManager().addGroup(user, newGroup);
			}
		}
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
		allGroups.addAll(WorkspaceManager.getInstance()
						.getAdminConnectionManager().getGroups());

		allGroups.removeAll(WorkspaceManager.getInstance()
				.getAdminConnectionManager().getGroups(user));
		
		Object[] result = showDialog(allGroups, "Select a group");
		
		EList<ACGroup> groups = new BasicEList<ACGroup>();
		for(int i = 0; i < result.length; i++){
			if(result[i] instanceof ACGroup){
				groups.add((ACGroup)result[i]);
			}
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
		txtDescription.setText(user.getDescription());
		tableViewer.setInput(user);

	}
	
	
}
