package org.unicase.ui.esbrowser.dialogs.admin;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Form;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.AdminBroker;

public class GroupComposite extends FormContents {

	private ACGroup group;
	private OrgUnitManagementGUI orgUnitMgmtGUI;

	public GroupComposite(Composite parent, int style, AdminBroker adminBroker, OrgUnitManagementGUI orgUnitMgmtGUI) {
		super(parent, style, adminBroker);
		this.orgUnitMgmtGUI = orgUnitMgmtGUI;
		createControls();
	}

	protected void removeOrgUnit(ACOrgUnit orgUnit) {
	
		try {
			adminBroker.removeMember(group.getId(),orgUnit.getId());
		
		} catch (EmfStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
				try {
					adminBroker.addMember(group.getId(), orgUnit.getId());
					
				} catch (EmfStoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} else {
			EList<ACOrgUnit> members = getNewMembers();
			for (ACOrgUnit ou : members) {
				try {
					adminBroker.addMember(group.getId(), ou.getId());
					
				} catch (EmfStoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		tableViewer.refresh();

	}

	private EList<ACOrgUnit> getNewMembers() {
		// 1. show a list of all AcOrgUnits that are not member of this group
		// (get list of all AcOrgUnits, remove those who take part in this
		// 2. return the selected ACOrgunits

		Collection<ACOrgUnit> allOrgUnits = new BasicEList<ACOrgUnit>();
		EList<ACOrgUnit> members = new BasicEList<ACOrgUnit>();
		try {
			allOrgUnits.addAll(adminBroker.getOrgUnits());
			allOrgUnits.removeAll(adminBroker
								.getMembers(group.getId()));
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

	@Override
	public void updateControls(EObject input) {
		
		super.updateControls(input);		
		if(input != null && input instanceof ACGroup){
			
			this.group = (ACGroup) input;

			
			
			txtName.setText(group.getName());
			txtDescription.setText((group.getDescription()==null) ? "" : group.getDescription() );
			tableViewer.setInput(group);
			orgUnitMgmtGUI.setFormTableViewer(tableViewer);
			
//			IObservableValue model = EMFEditObservables.observeValue(editingDomain,
//					group, AccesscontrolPackage.eINSTANCE.getACOrgUnit_Name());
//			EMFDataBindingContext dbc = new EMFDataBindingContext();
//			dbc.bindValue(SWTObservables.observeText(txtName, SWT.FocusOut), model,
//					null, null);
//			
//			model = EMFEditObservables.observeValue(editingDomain,
//					group, AccesscontrolPackage.eINSTANCE.getACOrgUnit_Description());
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
		if(group == null) {
			return;
		}
		if (!(group.getName().equals(txtName.getText())
				  && group.getDescription().equals(txtDescription.getText()) )){
				try {
					adminBroker.changeOrgUnit(group.getId(), txtName.getText(), txtDescription.getText());
					((Form)(this.getParent().getParent())).setText("Group: " + txtName.getText());
					orgUnitMgmtGUI.getActiveTabContent().getListViewer().refresh();
				} catch (EmfStoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}

} // GroupComposite

