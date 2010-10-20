/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
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
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ProjectChangeObserver;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;

/**
 * . ContentProvider for IterationPlaningView
 * 
 * @author Helming
 */
public class WorkpackageContentProvider extends TransactionalAdapterFactoryContentProvider implements
	ProjectChangeObserver {

	/**
	 * remove listener.
	 */
	@Override
	public void dispose() {
		if (WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace() != null
			&& WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace().getProject() != null) {
			WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace().getProject()
				.removeProjectChangeObserver(this);
		}

		super.dispose();
	}

	private Backlog backlog;

	/**
	 * . Constructor
	 */
	public WorkpackageContentProvider() {
		super(WorkspaceManager.getInstance().getCurrentWorkspace().getEditingDomain(), new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		// Listen to active project space change and register as listener
		final WorkpackageContentProvider instance = this;
		final Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		ProjectSpace activeProjectSapce = currentWorkspace.getActiveProjectSpace();
		if (activeProjectSapce != null) {
			activeProjectSapce.getProject().addProjectChangeObserver(this);
		}

		currentWorkspace.eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if ((msg.getFeatureID(Workspace.class)) == WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE) {
					if (currentWorkspace.getActiveProjectSpace() != null) {
						Object oldValue = msg.getOldValue();
						if (oldValue instanceof ProjectSpace) {
							((ProjectSpace) oldValue).getProject().removeProjectChangeObserver(instance);
						}
						Object newValue = msg.getNewValue();
						if (newValue instanceof ProjectSpace) {
							((ProjectSpace) newValue).getProject().addProjectChangeObserver(instance);
						}
					}
				}
			}
		});
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
			EList<WorkPackage> allModelElementsbyClass = project.getAllModelElementsbyClass(TaskPackage.eINSTANCE
				.getWorkPackage(), new BasicEList<WorkPackage>());
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
		EList<WorkItem> allModelElementsbyClass = project.getAllModelElementsbyClass(TaskPackage.eINSTANCE
			.getWorkItem(), new BasicEList<WorkItem>(), true);
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
	public void modelElementAdded(Project project, ModelElement modelElement) {
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
	public void notify(Notification notification, Project project, ModelElement modelElement) {
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
	public void modelElementDeleteCompleted(Project project, ModelElement modelElement) {
		if (modelElement instanceof WorkItem) {
			WorkPackage containingWorkpackage = ((WorkItem) modelElement).getContainingWorkpackage();
			if (containingWorkpackage == null) {
				TreeViewer treeViewer = (TreeViewer) viewer;
				treeViewer.refresh(backlog, true);
			}
		}
	}

	/**
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#modelElementDeleteStarted(org.unicase.model.UnicaseModelElement)
	 *      {@inheritDoc}
	 */
	public void modelElementDeleteStarted(Project project, ModelElement modelElement) {
		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#projectDeleted(org.unicase.metamodel.Project)
	 */
	public void projectDeleted(Project project) {
		// TODO Auto-generated method stub

	}

}
