/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.status.ui.tabs;

import java.util.List;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.WritableList;

import org.unicase.metamodel.Project;
import org.unicase.workspace.ProjectSpace;
import org.unicase.model.organization.User;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationPackage;

import org.unicase.rap.ui.tabs.ProjectAwareTab;
import org.unicase.rap.status.ui.viewers.TeamTableViewer;

/**
 * 
 * 
 * @author Edgar Müller, Fatih Ulusoy
 */
public class TeamListTab extends ProjectAwareTab {

	private TeamTableViewer teamTableViewer;
	
	/**
	 * The constructor.
	 * 
	 * @param projectSpace Project space.
	 * @param tabFolder Tab folder.
	 */
	public TeamListTab(ProjectSpace projectSpace, CTabFolder tabFolder) {
		super(projectSpace, tabFolder, "Team Tab");
		teamTableViewer = new TeamTableViewer(composite);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createTab(Composite parent) {
		teamTableViewer.setInput(getProjectSpace().getProject());
	}
	
	/**
	 * 
	 */
	public void refreshInput() {
		List<Group> groups = null;
		List<OrgUnit> teamMembers = new BasicEList<OrgUnit>();
		
		if (projectSpace == null) {
			return;
		}

		if (projectSpace.getProject() != null) {
			groups = projectSpace.getProject().getAllModelElementsbyClass(
					OrganizationPackage.eINSTANCE.getGroup(), new BasicEList<Group>());
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

	/**
	 * 
	 * @param project Project.
	 */
	public void projectDeleted(Project project) {
		refreshInput();
	}
	
}


