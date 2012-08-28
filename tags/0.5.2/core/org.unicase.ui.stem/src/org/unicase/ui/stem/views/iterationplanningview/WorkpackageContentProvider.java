/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.iterationplanningview;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.model.ECPWorkspaceManager;
import org.eclipse.emf.ecp.common.model.NoWorkspaceException;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPProject;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPWorkspace;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.emfstore.common.model.IdEObjectCollection;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.IdEObjectCollectionChangeObserver;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.jface.viewers.TreeViewer;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

/**
 * . ContentProvider for IterationPlaningView
 * 
 * @author Helming
 */
public class WorkpackageContentProvider extends AdapterFactoryContentProvider implements
	IdEObjectCollectionChangeObserver {

	/**
	 * remove listener.
	 */
	@Override
	public void dispose() {
		try {
			if (ECPWorkspaceManager.getInstance().getWorkSpace().getActiveProject() != null
				&& ECPWorkspaceManager.getInstance().getWorkSpace().getActiveProject().getRootContainer() != null) {
				((Project) ECPWorkspaceManager.getInstance().getWorkSpace().getActiveProject().getRootContainer())
					.removeIdEObjectCollectionChangeObserver(this);
			}
		} catch (NoWorkspaceException e) {
			ModelUtil.logException("Failed to receive Project!", e);
		}

		super.dispose();
	}

	private Backlog backlog;

	/**
	 * . Constructor
	 */
	public WorkpackageContentProvider() {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		// Listen to active project space change and register as listener
		final WorkpackageContentProvider instance = this;
		try {
			final ECPWorkspace currentWorkspace = ECPWorkspaceManager.getInstance().getWorkSpace();

			ECPProject activeProject = currentWorkspace.getActiveProject();
			if (activeProject != null) {
				((Project) activeProject.getRootContainer()).addIdEObjectCollectionChangeObserver(this);
			}

			currentWorkspace.eAdapters().add(new AdapterImpl() {
				@Override
				public void notifyChanged(Notification msg) {
					if ((msg.getFeatureID(ECPWorkspace.class)) == org.eclipse.emf.ecp.common.model.workSpaceModel.WorkSpaceModelPackage.ECP_WORKSPACE__ACTIVE_PROJECT) {
						if (currentWorkspace.getActiveProject() != null) {
							Object oldValue = msg.getOldValue();
							if (oldValue instanceof ECPProject) {
								((Project) ((ECPProject) oldValue).getRootContainer())
									.removeIdEObjectCollectionChangeObserver(instance);
							}
							Object newValue = msg.getNewValue();
							if (newValue instanceof ECPProject) {
								((Project) ((ECPProject) oldValue).getRootContainer())
									.addIdEObjectCollectionChangeObserver(instance);
							}
						}
					}
				}
			});
		} catch (NoWorkspaceException e) {
			ModelUtil.logException("Failed to receive Project!", e);
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
			EList<WorkPackage> allModelElementsbyClass = project.getAllModelElementsbyClass(
				TaskPackage.eINSTANCE.getWorkPackage(), new BasicEList<WorkPackage>());
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
		EList<WorkItem> allModelElementsbyClass = project.getAllModelElementsbyClass(
			TaskPackage.eINSTANCE.getWorkItem(), new BasicEList<WorkItem>(), true);
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
	public void modelElementAdded(IdEObjectCollection project, EObject modelElement) {
		if (modelElement instanceof WorkItem) {
			WorkPackage containingWorkpackage = ((WorkItem) modelElement).getContainingWorkpackage();
			if (containingWorkpackage == null) {
				TreeViewer treeViewer = (TreeViewer) viewer;
				treeViewer.refresh(backlog, true);
			}
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public void notify(Notification notification, IdEObjectCollection project, EObject modelElement) {
		if (notification.isTouch()) {
			return;
		}
		if (notification.getFeatureID(WorkItem.class) == TaskPackage.WORK_ITEM__CONTAINING_WORKPACKAGE) {
			if (notification.getNewValue() == null | notification.getOldValue() == null) {
				TreeViewer treeViewer = (TreeViewer) viewer;
				treeViewer.refresh(backlog, true);
			}

		}
	}

	/**
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#modelElementDeleteCompleted(org.unicase.model.UnicaseModelElement)
	 *      {@inheritDoc}
	 */
	public void modelElementRemoved(IdEObjectCollection project, EObject modelElement) {
		if (modelElement instanceof WorkItem) {
			WorkPackage containingWorkpackage = ((WorkItem) modelElement).getContainingWorkpackage();
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
