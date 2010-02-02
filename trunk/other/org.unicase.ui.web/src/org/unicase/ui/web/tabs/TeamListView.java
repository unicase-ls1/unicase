package org.unicase.ui.web.tabs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.workspace.ProjectSpace;

public class TeamListView extends AbstractListView {

	public TeamListView(ProjectSpace projectSpace, Composite composite) {
		super(projectSpace, composite);
	}

	@Override
	public ArrayList<EStructuralFeature> getFeatureList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected void init() {		
		super.init();
		GridData tableData = new GridData(SWT.FILL, SWT.FILL, true, true);
		tableData.horizontalSpan = 2;
		getTable().setLayoutData(tableData);
		setListInput();
	}
	

	private List<OrgUnit> getTeamMembers() {
		
		List<Group> groups = null;
		List<OrgUnit> teamMembers = new BasicEList<OrgUnit>();
		
		if (getProject() != null) {
			groups = getProject().getAllModelElementsbyClass(
					OrganizationPackage.eINSTANCE.getGroup(),
					new BasicEList<Group>());
		}
		
		for(Group group : groups) {
			if(group.getName().toLowerCase().contains(getProjectSpace().getProjectName().toLowerCase()))
				teamMembers = group.getOrgUnits();
		}
		
		return teamMembers;
	}
	
	@Override
	public void setListInput() {		

		final WritableList oldItems = (WritableList) (getInput());
		
		if (oldItems == null) {
			List<OrgUnit> teamMembers = getTeamMembers();
			WritableList emfList = new WritableList(Realm.getDefault(), teamMembers, User.class);
			setInput(emfList);
		} else {
			final List<OrgUnit> teamMembers = getTeamMembers();
			
			oldItems.getRealm().asyncExec(new Runnable() {
				public void run() {
					// remove all elements
					oldItems.retainAll(new BasicEList<OrgUnit>());
					// adds 
					oldItems.addAll(teamMembers);
				}
			});
		}
		
	}
}
