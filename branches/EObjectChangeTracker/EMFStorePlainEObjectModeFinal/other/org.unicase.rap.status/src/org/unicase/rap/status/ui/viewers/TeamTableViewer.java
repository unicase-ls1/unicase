/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.status.ui.viewers;

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
import org.unicase.model.organization.User;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.rap.config.ConfigEntityStore;
import org.unicase.rap.status.config.StatusConfigEntity;
import org.unicase.rap.ui.viewers.AbstractETableViewer;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.UnkownProjectException;

/**
 * Table viewer for team members.
 * 
 * @author Edgar Müller, Fatih Ulusoy
 */
public class TeamTableViewer extends AbstractETableViewer {
	
	/**
	 * 
	 * @param projectSpace
	 * @param composite Parent composite.
	 */
	public TeamTableViewer(Composite composite) {
		super(composite);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void init() {		
		super.init();
		GridData tableData = new GridData(SWT.FILL, SWT.FILL, false, false);
		getTable().setLayoutData(tableData);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public ArrayList<EStructuralFeature> getFeaturesList() {
		ArrayList<EStructuralFeature> list = new ArrayList<EStructuralFeature>();
		list.add(OrganizationPackage.Literals.USER__FIRST_NAME);
		list.add(OrganizationPackage.Literals.USER__LAST_NAME);
		list.add(OrganizationPackage.Literals.USER__EMAIL);
		return list;
	}

	/**
	 * 
	 * @param project Project
	 */
	public void setInput(Project project) {
		final WritableList oldItems = (WritableList) (this.getInput());
		
		if (oldItems == null) {
			List<OrgUnit> teamMembers = getTeamMembers(project);
			WritableList emfList = new WritableList(Realm.getDefault(), teamMembers, User.class);
			this.setInput(emfList);
		} else {
			final List<OrgUnit> teamMembers = getTeamMembers(project);
			final TeamTableViewer myThis = this;
			oldItems.getRealm().asyncExec(new Runnable() {
				public void run() {
					WritableList emfList = new WritableList(Realm.getDefault(), teamMembers, User.class);
					myThis.setInput(emfList);
					// remove all elements
//					oldItems.retainAll(new BasicEList<OrgUnit>());
//					// adds 
//					oldItems.addAll(teamMembers);
				}
			});
		}
		
	}
	
	private List<OrgUnit> getTeamMembers(Project project) {
		
		List<Group> groups = null;
		List<OrgUnit> teamMembers = new BasicEList<OrgUnit>();
		
		if (project != null) {
			groups = project.getAllModelElementsbyClass(
					OrganizationPackage.eINSTANCE.getGroup(),
					new BasicEList<Group>());
		}
		
		ProjectSpace pSpace = null;
		try {
			pSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpace(project);
		} catch (UnkownProjectException e) {
			e.printStackTrace();
		}
		
		StatusConfigEntity cnfgEntity = new StatusConfigEntity(pSpace);
		ConfigEntityStore.loadConfigEntity(cnfgEntity, cnfgEntity.eClass());
		String groupName = cnfgEntity.getUserGroupName();
		
		for(Group group : groups) {
			if(group.getIdentifier().equals(groupName)) {
				teamMembers = group.getOrgUnits();
			}
		}
		
		return teamMembers;
	}
	
}


