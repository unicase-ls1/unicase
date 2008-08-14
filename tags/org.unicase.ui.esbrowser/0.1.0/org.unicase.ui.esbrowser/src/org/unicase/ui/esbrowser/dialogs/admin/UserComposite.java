package org.unicase.ui.esbrowser.dialogs.admin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Form;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.AdminBroker;

public class UserComposite extends FormContents {

	private ACUser user;
	private OrgUnitManagementGUI orgUnitMgmtGUI;

	public UserComposite(Composite parent, int style, AdminBroker adminBroker, OrgUnitManagementGUI orgUnitMgmtGUI) {
		super(parent, style, adminBroker);
		this.orgUnitMgmtGUI = orgUnitMgmtGUI;
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
		
		try{
			if (group != null) {
				adminBroker.addMember(((ACGroup) group).getId(),user.getId());
				
			} else {
				List<ACGroup> groups = getGroups();
				for (ACGroup newGroup : groups) {

					adminBroker
							.addMember( newGroup.getId(), user.getId());
					
										
				}
			} 
		} catch (EmfStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		tableViewer.refresh();
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
			allGroups.addAll(adminBroker.getGroups());
			List<ACGroup> groupsToRemove = new ArrayList<ACGroup>();
			groupsToRemove.addAll(adminBroker.getGroups(user.getId()));
			//its really funnyyyyyyy!!!!!!!! :((
			//you should implement all typical list operations yourself.
			//because contains(), remove(), indexof(), .... all require a test of 
			//equality and here we have a problem.
			
			allGroups.removeAll(groupsToRemove);

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

	@Override
	public void updateControls(EObject input) {
		super.updateControls(input);		
		if(input != null && input instanceof ACUser){
		
			this.user =(ACUser) input;

			txtName.setText(user.getName());
			txtDescription.setText((user.getDescription()== null)? "" : user.getDescription());
			tableViewer.setInput(user);
			orgUnitMgmtGUI.setFormTableViewer(tableViewer);
			
//			IObservableValue model = EMFEditObservables.observeValue(editingDomain,
//					user, AccesscontrolPackage.eINSTANCE.getACOrgUnit_Name());
//			EMFDataBindingContext dbc = new EMFDataBindingContext();
//			dbc.bindValue(SWTObservables.observeText(txtName, SWT.FocusOut), model,
//					null, null);
//			
//			model = EMFEditObservables.observeValue(editingDomain,
//					user, AccesscontrolPackage.eINSTANCE.getACOrgUnit_Description());
//			dbc = new EMFDataBindingContext();
//			dbc.bindValue(SWTObservables.observeText(txtDescription, SWT.FocusOut), model,
//					null, null);
			
			
		}
		

	}
	
	@Override
	protected  void saveOrgUnitAttributes() {
		if(txtName == null || txtDescription == null ){
			return;
		}
		if(user == null) {
			return;
		}
		if (!(user.getName().equals(txtName.getText())
			  && user.getDescription().equals(txtDescription.getText()) )){
			try {
				adminBroker.changeOrgUnit(user.getId(), txtName.getText(), txtDescription.getText());
				((Form)(this.getParent().getParent())).setText("User: " + txtName.getText());
				orgUnitMgmtGUI.getActiveTabContent().getListViewer().refresh();
			
			} catch (EmfStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
