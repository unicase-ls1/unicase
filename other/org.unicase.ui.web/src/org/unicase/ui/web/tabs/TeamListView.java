package org.unicase.ui.web.tabs;

import java.util.List;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.WritableList;

import org.unicase.metamodel.Project;
import org.unicase.metamodel.ModelElement;
import org.unicase.workspace.ProjectSpace;
import org.unicase.model.organization.User;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationPackage;

/**
 * 
 * @author Edgar Müller
 * @author Fatih Ulusoy
 */
public class TeamListView extends AbstractProjectListView {

	/**
	 * 
	 * @param projectSpace
	 * @param composite
	 */
	public TeamListView(ProjectSpace projectSpace, Composite composite) {
		super(projectSpace, composite);
	}
	
	@Override
	protected void init() {		
		super.init();
		GridData tableData = new GridData(SWT.FILL, SWT.FILL, true, true);
		tableData.horizontalSpan = 2;
		getTable().setLayoutData(tableData);
	}
	

	@Override
	public ArrayList<EStructuralFeature> getFeatureList() {
		ArrayList<EStructuralFeature> list = new ArrayList<EStructuralFeature>();
		list.add(OrganizationPackage.Literals.USER__FIRST_NAME);
		list.add(OrganizationPackage.Literals.USER__LAST_NAME);
		list.add(OrganizationPackage.Literals.USER__EMAIL);
		return list;
	}

	private void setListInput() {		
		
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

	@Override
	public void update(Project project, ModelElement modelElement) {
		if (modelElement instanceof OrgUnit) {
			setListInput();
		}
	}
	
	/**
	 * 
	 * @return
	 */
	private List<OrgUnit> getTeamMembers() {
		List<Group> groups = null;
		List<OrgUnit> teamMembers = new BasicEList<OrgUnit>();

		if (getProject() != null) {
			groups = getProject().getAllModelElementsbyClass(
					OrganizationPackage.eINSTANCE.getGroup(),
					new BasicEList<Group>());
		}

		for (Group group : groups) {
			if (group.getName().toLowerCase().contains(
					getProjectSpace().getProjectName().toLowerCase()))
				teamMembers = group.getOrgUnits();
		}
		return teamMembers;
	}


}
