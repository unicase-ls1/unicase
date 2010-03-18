package org.unicase.rap.status.ui.viewers.tabs;

import java.util.List;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.rap.status.ui.viewers.TeamTableViewer;
import org.unicase.rap.ui.views.ProjectAwareTab;
import org.unicase.workspace.ProjectSpace;

/**
 * 
 * @author Edgar Mueller
 * @author Fatih Ulusoy
 */
public class TeamListTab extends ProjectAwareTab {

	private TeamTableViewer teamTableViewer;
	
	/**
	 * 
	 * @param projectName
	 * @param tabFolder
	 */
	public TeamListTab(ProjectSpace projectSpace, CTabFolder tabFolder) {
		super(projectSpace, tabFolder, "Team Tab");
		teamTableViewer = new TeamTableViewer(composite);
	}
	
	@Override
	public void createTab(Composite parent) {
		teamTableViewer.setInput(getProjectSpace().getProject());
	}

	// TODO: Provide more efficient update methods
	public void modelElementAdded(Project project, ModelElement modelElement) {
		refreshInput();	
	}

	public void modelElementDeleteCompleted(Project project,
			ModelElement modelElement) {
		refreshInput();	
	}

	public void modelElementDeleteStarted(Project project,
			ModelElement modelElement) {
		refreshInput();
	}

	public void notify(Notification notification, Project project,
			ModelElement modelElement) {
		refreshInput();
	}
	
	public void refreshInput() {
		List<Group> groups = null;
		List<OrgUnit> teamMembers = new BasicEList<OrgUnit>();
		
		if (projectSpace == null) {
			return;
		}

		if (projectSpace.getProject() != null) {
			groups = projectSpace.getProject().getAllModelElementsbyClass(
					OrganizationPackage.eINSTANCE.getGroup(),
					new BasicEList<Group>());
		}

		for (Group group : groups) {
			if (group.getName().toLowerCase().contains(
					projectSpace.getProjectName().toLowerCase())) {
				teamMembers = group.getOrgUnits();
			}
		}
		
		final WritableList oldItems = (WritableList) (teamTableViewer.getInput());
		
		if (oldItems == null) {
			WritableList emfList = new WritableList(Realm.getDefault(), teamMembers, User.class);
			teamTableViewer.setInput(emfList);
		} else {
			final List<OrgUnit> members = teamMembers;
			
			oldItems.getRealm().asyncExec(new Runnable() {
				public void run() {
					// remove all elements
					oldItems.retainAll(new BasicEList<OrgUnit>());
					// adds 
					oldItems.addAll(members);
				}
			});
		}
	}
	
}


