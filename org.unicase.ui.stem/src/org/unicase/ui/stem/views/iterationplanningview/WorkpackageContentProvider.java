/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views.iterationplanningview;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryContentProvider;
import org.unicase.model.Project;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkPackage;
import org.unicase.workspace.WorkspaceManager;

/**
 * . ContentProvider for IterationPlaningView
 * 
 * @author Helming
 * 
 */
public class WorkpackageContentProvider extends
		TransactionalAdapterFactoryContentProvider {

	boolean teamFilter = false;

	/**
	 * . Constructor
	 */
	public WorkpackageContentProvider() {
		super(WorkspaceManager.getInstance().getCurrentWorkspace()
				.getEditingDomain(), new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	/**
	 * . {@inheritDoc} returns WorkPackages contained in a Project
	 */
	@Override
	public Object[] getElements(Object object) {
		List<WorkPackage> ret = new ArrayList<WorkPackage>();
		if (object instanceof Project) {
			EList<WorkPackage> allModelElementsbyClass = ((Project) object)
					.getAllModelElementsbyClass(TaskPackage.eINSTANCE
							.getWorkPackage(), new BasicEList<WorkPackage>());
			for (WorkPackage workPackage : allModelElementsbyClass) {
				if (workPackage.getContainingWorkpackage() == null) {
					ret.add(workPackage);
				}
			}

			if (teamFilter) {
				filterByTeam(ret);
			}

		}
		return ret.toArray();
	}

	private void filterByTeam(List<WorkPackage> ret) {
		// JH. Activate after model reviewed
		// List<WorkPackage> cache = new ArrayList<WorkPackage>();
		// List<OrgUnit> team = new ArrayList<OrgUnit>();
		// for(WorkPackage workPackage: ret){
		// if(team.contains(workPackage.getAssignedto())){
		// cache.add(workPackage);
		// }
		// }
		//		
		// ret=cache;
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public Object[] getChildren(Object object) {
		return super.getChildren(object);
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public boolean hasChildren(Object object) {

		return super.hasChildren(object);

	}

	/**
	 * sets if the workpackages are filtered to the team of the current user.
	 * 
	 * @param checked
	 *            If the filter is turned on
	 */
	public void setTeamFilter(boolean checked) {
		teamFilter = checked;
		viewer.refresh();
	}

}
