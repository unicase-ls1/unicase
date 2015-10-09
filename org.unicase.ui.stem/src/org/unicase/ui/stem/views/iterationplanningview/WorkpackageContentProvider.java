/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.iterationplanningview;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.core.ECPProject;
import org.eclipse.emf.ecp.core.util.ECPUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.emfstore.internal.client.model.ESWorkspaceProviderImpl;
import org.eclipse.emf.emfstore.internal.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.internal.client.model.Workspace;
import org.eclipse.emf.emfstore.internal.common.model.IdEObjectCollection;
import org.eclipse.emf.emfstore.internal.common.model.Project;
import org.eclipse.emf.emfstore.internal.common.model.util.IdEObjectCollectionChangeObserver;
import org.eclipse.jface.viewers.TreeViewer;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

/**
 * . ContentProvider for IterationPlaningView
 * 
 * @author Helming
 */
@SuppressWarnings("restriction")
public class WorkpackageContentProvider extends AdapterFactoryContentProvider
		implements IdEObjectCollectionChangeObserver {

	/**
	 * remove listener.
	 */
	@Override
	public void dispose() {
		if (workspace.getProjectSpaces() != null
				&& !workspace.getProjectSpaces().isEmpty()) {
			activeProject = workspace.getProjectSpaces().get(0).getProject();
			activeProject.removeIdEObjectCollectionChangeObserver(this);
		}
		super.dispose();
	}

	private Backlog backlog;
	private Workspace workspace;
	private Project activeProject;
	private ECPProject ecpProject;

	/**
	 * . Constructor
	 */
	public WorkpackageContentProvider() {
		super(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		workspace = ESWorkspaceProviderImpl.getInstance()
				.getInternalWorkspace();
		if (workspace.getProjectSpaces() != null
				&& !workspace.getProjectSpaces().isEmpty()) {
			activeProject = workspace.getProjectSpaces().get(0).getProject();
			activeProject.addIdEObjectCollectionChangeObserver(this);
		}
		if (activeProject != null && activeProject instanceof Project) {
			ecpProject = ECPUtil.getECPProjectManager().getProject(
					((ProjectSpace) activeProject.eContainer())
							.getProjectName());
		}
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
					.getModelElementsByClass(
							TaskPackage.eINSTANCE.getWorkPackage(),
							new BasicEList<WorkPackage>());
			for (WorkPackage workPackage : allModelElementsbyClass) {
				if (workPackage.getContainingWorkpackage() == null) {
					ret.add(workPackage);
				}
			}

		}
		return ret.toArray();
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public Object[] getChildren(Object object) {
		if (object instanceof Backlog) {
			return getProjectWorkItems(((Backlog) object).getProject())
					.toArray();
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
				.getModelElementsByClass(TaskPackage.eINSTANCE.getWorkItem(),
						new BasicEList<WorkItem>());
		List<WorkItem> ret = new ArrayList<WorkItem>();
		for (WorkItem workItem : allModelElementsbyClass) {
			if (!(workItem instanceof WorkPackage)) {
				if (!(workItem.eContainer() instanceof WorkPackage)) {
					ret.add(workItem);
				}
			}
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 */
	public void modelElementAdded(IdEObjectCollection project,
			EObject modelElement) {
		if (modelElement instanceof WorkItem) {
			WorkPackage containingWorkpackage = ((WorkItem) modelElement)
					.getContainingWorkpackage();
			if (containingWorkpackage == null) {
				TreeViewer treeViewer = (TreeViewer) viewer;
				treeViewer.refresh(backlog, true);
			}
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public void notify(Notification notification, IdEObjectCollection project,
			EObject modelElement) {
		if (notification.isTouch()) {
			return;
		}
		if (notification.getFeatureID(WorkItem.class) == TaskPackage.WORK_ITEM__CONTAINING_WORKPACKAGE) {
			if (notification.getNewValue() == null
					| notification.getOldValue() == null) {
				TreeViewer treeViewer = (TreeViewer) viewer;
				treeViewer.refresh(backlog, true);
			}

		}
	}

	/**
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#modelElementDeleteCompleted(org.unicase.model.UnicaseModelElement)
	 *      {@inheritDoc}
	 */
	public void modelElementRemoved(IdEObjectCollection project,
			EObject modelElement) {
		if (modelElement instanceof WorkItem) {
			WorkPackage containingWorkpackage = ((WorkItem) modelElement)
					.getContainingWorkpackage();
			if (containingWorkpackage == null) {
				TreeViewer treeViewer = (TreeViewer) viewer;
				treeViewer.refresh(backlog, true);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.util.IdEObjectCollectionChangeObserver#collectionDeleted(org.eclipse.emf.emfstore.common.model.IdEObjectCollection)
	 */
	public void collectionDeleted(IdEObjectCollection collection) {
		// nothing to do
	}

}
