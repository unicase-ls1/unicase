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
import org.unicase.rap.ui.viewers.AbstractETableViewer;

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
		GridData tableData = new GridData(SWT.FILL, SWT.FILL, true, true);
		tableData.horizontalSpan = 2;
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
	
	private List<OrgUnit> getTeamMembers(Project project) {
		
		List<Group> groups = null;
		List<OrgUnit> teamMembers = new BasicEList<OrgUnit>();
		
		if (project != null) {
			groups = project.getAllModelElementsbyClass(
					OrganizationPackage.eINSTANCE.getGroup(),
					new BasicEList<Group>());
		}
		
		for(Group group : groups) {
			// TODO: group name will be got from configuration
			if(group.getName().toLowerCase().contains("myproject")) {
				teamMembers = group.getOrgUnits();
			}
		}
		
		return teamMembers;
	}
	
}


