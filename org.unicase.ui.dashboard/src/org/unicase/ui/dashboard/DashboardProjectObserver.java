/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.emfstore.client.ESLocalProject;
import org.eclipse.emf.emfstore.client.ESWorkspace;
import org.eclipse.emf.emfstore.client.observer.ESCheckoutObserver;
import org.eclipse.emf.emfstore.client.observer.ESUpdateObserver;
import org.eclipse.emf.emfstore.client.observer.ESWorkspaceInitObserver;
import org.eclipse.emf.emfstore.internal.client.model.ESWorkspaceProviderImpl;
import org.eclipse.emf.emfstore.internal.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.internal.client.model.Workspace;
import org.eclipse.emf.emfstore.internal.client.observers.DeleteProjectSpaceObserver;
import org.eclipse.emf.emfstore.internal.client.properties.PropertyManager;
import org.eclipse.emf.emfstore.internal.common.model.EMFStoreProperty;
import org.eclipse.emf.emfstore.internal.server.model.versioning.ChangePackage;
import org.eclipse.emf.emfstore.server.model.ESChangePackage;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.dashboard.DashboardFactory;
import org.unicase.dashboard.DashboardNotification;
import org.unicase.dashboard.DashboardNotificationComposite;
import org.unicase.dashboard.util.DashboardPropertyKeys;
import org.unicase.ui.dashboard.notificationProviders.NotificationHelper;
import org.unicase.ui.dashboard.view.DashboardEditorInput;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;

/**
 * Performs a cleanup before a project is deleted.
 * 
 * @author Shterev
 * @author wesendon
 */
public class DashboardProjectObserver implements DeleteProjectSpaceObserver,
		ESCheckoutObserver, ESUpdateObserver, ESWorkspaceInitObserver {

	private static Map<ProjectSpace, List<ChangePackage>> projectToChanges = new HashMap<ProjectSpace, List<ChangePackage>>();

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.PostWorkspaceInitiator#workspaceInitComplete(org.unicase.workspace.Workspace)
	 */
	public void workspaceInitComplete(Workspace workspace) {
		ESWorkspaceProviderImpl.getInstance().getObserverBus().register(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.CheckoutObserver#checkoutDone(org.unicase.workspace.ProjectSpace)
	 */
	public void checkoutDone(ProjectSpace projectSpace) {
		runDashboardCommand(projectSpace);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.UpdateObserver#updateCompleted(org.unicase.workspace.ProjectSpace)
	 */
	public void updateCompleted(ProjectSpace projectSpace) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				PlatformUI
						.getWorkbench()
						.getDecoratorManager()
						.update("org.eclipse.emf.emfstore.client.ui.decorators.VersionDecorator");
			}
		});
		runDashboardCommand(projectSpace);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.UpdateObserver#inspectChanges(org.unicase.workspace.ProjectSpace,
	 *      java.util.List)
	 */
	public boolean inspectChanges(ProjectSpace projectSpace,
			List<ChangePackage> changePackages) {
		projectToChanges.put(projectSpace, changePackages);
		return true;
	}

	@SuppressWarnings("unchecked")
	private void generateNotifications(ProjectSpace projectSpace) {
		List<ChangePackage> changePackages = projectToChanges.get(projectSpace);
		List<ChangePackage> changes = changePackages == null ? Collections.EMPTY_LIST
				: changePackages;
		List<DashboardNotification> notifications = NotificationHelper
				.generateNotifications(projectSpace, changes);

		PropertyManager propertyManager = projectSpace.getPropertyManager();
		EMFStoreProperty property = propertyManager
				.getLocalProperty(DashboardPropertyKeys.NOTIFICATION_COMPOSITE);
		DashboardNotificationComposite notificationComposite;
		if (property != null) {
			notificationComposite = (DashboardNotificationComposite) property
					.getValue();
			notificationComposite.getNotifications().addAll(notifications);
		} else {
			notificationComposite = DashboardFactory.eINSTANCE
					.createDashboardNotificationComposite();
		}

		notificationComposite.getNotifications().addAll(notifications);
		propertyManager.setLocalProperty(
				DashboardPropertyKeys.NOTIFICATION_COMPOSITE,
				notificationComposite);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.observers.DeleteProjectSpaceObserver#projectSpaceDeleted(org.eclipse.emf.emfstore.client.model.ProjectSpace)
	 */
	public void projectSpaceDeleted(ProjectSpace projectSpace) {
		// close all open editors before deleting
		IWorkbenchPage wbpage = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		IEditorReference[] editors = wbpage.getEditorReferences();
		for (IEditorReference editorReference : editors) {
			try {
				if (editorReference.getEditorInput() instanceof DashboardEditorInput) {
					DashboardEditorInput editorInput = (DashboardEditorInput) editorReference
							.getEditorInput();
					if (projectSpace.equals(editorInput.getProjectSpace())) {
						wbpage.closeEditor(editorReference.getEditor(false),
								false);
					}
				}
			} catch (PartInitException e) {
				// Just print the stacktrace
				e.printStackTrace();
			}
		}
	}

	private void runDashboardCommand(final ProjectSpace projectSpace) {
		checkProperties(projectSpace);
		generateNotifications(projectSpace);
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				UnicaseActionHelper.openDashboard(projectSpace);
			}
		});

	}

	private void checkProperties(ProjectSpace projectSpace) {
		PropertyManager propertyManager = projectSpace.getPropertyManager();

		checkProviderProperties(propertyManager);

		if (propertyManager
				.getLocalStringProperty(DashboardPropertyKeys.DASHBOARD_SIZE) == null) {
			propertyManager.setLocalStringProperty(
					DashboardPropertyKeys.DASHBOARD_SIZE, "10");
		}
		if (propertyManager
				.getLocalStringProperty(DashboardPropertyKeys.HIGHLIGHT_PUSHED_COMMENTS) == null) {
			propertyManager.setLocalStringProperty(
					DashboardPropertyKeys.HIGHLIGHT_PUSHED_COMMENTS, "true");
		}
		if (propertyManager
				.getLocalStringProperty(DashboardPropertyKeys.SHOW_CONTAINMENT_REPLIES) == null) {
			propertyManager.setLocalStringProperty(
					DashboardPropertyKeys.SHOW_CONTAINMENT_REPLIES, "true");
		}
		if (propertyManager
				.getLocalStringProperty(DashboardPropertyKeys.TASKTRACE_LENGTH) == null) {
			propertyManager.setLocalStringProperty(
					DashboardPropertyKeys.TASKTRACE_LENGTH, "5");
		}
	}

	private void checkProviderProperties(PropertyManager propertyManager) {
		if (propertyManager
				.getLocalStringProperty(DashboardPropertyKeys.TASK_PROVIDER) == null) {
			propertyManager.setLocalStringProperty(
					DashboardPropertyKeys.TASK_PROVIDER, "true");
		}
		if (propertyManager
				.getLocalStringProperty(DashboardPropertyKeys.TASK_CHANGE_PROVIDER) == null) {
			propertyManager.setLocalStringProperty(
					DashboardPropertyKeys.TASK_CHANGE_PROVIDER, "true");
		}
		if (propertyManager
				.getLocalStringProperty(DashboardPropertyKeys.TASK_REVIEW_PROVIDER) == null) {
			propertyManager.setLocalStringProperty(
					DashboardPropertyKeys.TASK_REVIEW_PROVIDER, "true");
		}
		if (propertyManager
				.getLocalStringProperty(DashboardPropertyKeys.TASK_TRACE_PROVIDER) == null) {
			propertyManager.setLocalStringProperty(
					DashboardPropertyKeys.TASK_TRACE_PROVIDER, "true");
		}
		if (propertyManager
				.getLocalStringProperty(DashboardPropertyKeys.SUBSCRIPTION_PROVIDER) == null) {
			propertyManager.setLocalStringProperty(
					DashboardPropertyKeys.SUBSCRIPTION_PROVIDER, "true");
		}
		if (propertyManager
				.getLocalStringProperty(DashboardPropertyKeys.COMMENTS_PROVIDER) == null) {
			propertyManager.setLocalStringProperty(
					DashboardPropertyKeys.COMMENTS_PROVIDER, "true");
		}
	}

	public void workspaceInitComplete(ESWorkspace currentWorkspace) {
		// TODO Auto-generated method stub

	}

	public boolean inspectChanges(ESLocalProject project,
			List<ESChangePackage> changePackages, IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return false;
	}

	public void updateCompleted(ESLocalProject project, IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	public void checkoutDone(ESLocalProject project) {
		// TODO Auto-generated method stub

	}
}
