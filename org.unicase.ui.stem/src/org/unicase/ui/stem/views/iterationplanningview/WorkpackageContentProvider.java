/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views.iterationplanningview;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.unicase.model.Project;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.workspace.WorkspaceManager;

/**
 * . ContentProvider for IterationPlaningView
 * 
 * @author Helming
 * 
 */
public class WorkpackageContentProvider extends
		TransactionalAdapterFactoryContentProvider  {

	private boolean teamFilter;
	private AdapterImpl adapterImpl;
	private Backlog backlog;

	/**
	 * . Constructor
	 */
	public WorkpackageContentProvider() {
		super(WorkspaceManager.getInstance().getCurrentWorkspace()
				.getEditingDomain(), new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		adapterImpl = new AdapterImpl(){

			@Override
			public void notifyChanged(Notification msg) {
				if(msg.getFeatureID(WorkItem.class)==TaskPackage.WORK_ITEM__CONTAINING_WORKPACKAGE){
					TreeViewer treeViewer=(TreeViewer) viewer;
					treeViewer.refresh(backlog, true);
					EObject notifier = (EObject) msg.getNotifier();
					notifier.eAdapters().remove(this);
					
				}
			}
			
		};
	}

	/**
	 * . {@inheritDoc} returns WorkPackages contained in a Project
	 */
	@Override
	public Object[] getElements(Object object) {
		List<EObject> ret = new ArrayList<EObject>();
		if (object instanceof Project) {
			Project project = (Project) object;
			backlog = new Backlog(project);
			ret.add(backlog);
			EList<WorkPackage> allModelElementsbyClass = project
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

	private void filterByTeam(List<EObject> ret) {
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
		if (object instanceof Backlog) {
			return getProjectWorkItems(((Backlog) object).getProject()).toArray();
		}
		return super.getChildren(object);
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public boolean hasChildren(Object object) {
		if (object instanceof Backlog) {
			return (getProjectWorkItems(((Backlog) object).getProject()).size() > 0);
		}
		return super.hasChildren(object);
	}

	private List<WorkItem> getProjectWorkItems(Project project) {
		EList<WorkItem> allModelElementsbyClass = project
				.getAllModelElementsbyClass(
						TaskPackage.eINSTANCE.getWorkItem(),
						new BasicEList<WorkItem>(), true);
		List<WorkItem> ret = new ArrayList<WorkItem>();
		for (WorkItem workItem : allModelElementsbyClass) {
			if (!(workItem instanceof WorkPackage)) {
				if (!(workItem.eContainer() instanceof WorkPackage)) {
					ret.add(workItem);
					workItem.eAdapters().add(adapterImpl);
				}
			}
		}
		return ret;
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
