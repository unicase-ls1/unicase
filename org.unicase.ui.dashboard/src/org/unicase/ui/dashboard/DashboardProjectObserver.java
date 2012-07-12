/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.emfstore.client.model.PostWorkspaceInitiator;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.Workspace;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.observers.CheckoutObserver;
import org.eclipse.emf.emfstore.client.model.observers.DeleteProjectSpaceObserver;
import org.eclipse.emf.emfstore.client.model.observers.UpdateObserver;
import org.eclipse.emf.emfstore.server.model.versioning.ChangePackage;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.dashboard.DashboardFactory;
import org.unicase.dashboard.DashboardNotification;
import org.unicase.dashboard.DashboardNotificationComposite;
import org.unicase.ui.dashboard.notificationProviders.NotificationHelper;
import org.unicase.ui.dashboard.view.DashboardEditorInput;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;

/**
 * Performs a cleanup before a project is deleted.
 * 
 * @author Shterev
 * @author wesendon
 */
public class DashboardProjectObserver implements DeleteProjectSpaceObserver, CheckoutObserver, UpdateObserver,
	PostWorkspaceInitiator {

	private static Map<ProjectSpace, List<ChangePackage>> projectToChanges = new HashMap<ProjectSpace, List<ChangePackage>>();

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.PostWorkspaceInitiator#workspaceInitComplete(org.unicase.workspace.Workspace)
	 */
	public void workspaceInitComplete(Workspace workspace) {
		WorkspaceManager.getObserverBus().register(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.CheckoutObserver#checkoutDone(org.unicase.workspace.ProjectSpace)
	 */
	public void checkoutDone(ProjectSpace projectSpace) {
		generateNotifications(projectSpace);
		UnicaseActionHelper.openDashboard(projectSpace);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.UpdateObserver#updateCompleted(org.unicase.workspace.ProjectSpace)
	 */
	public void updateCompleted(ProjectSpace projectSpace) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				PlatformUI.getWorkbench().getDecoratorManager()
					.update("org.eclipse.emf.emfstore.client.ui.decorators.VersionDecorator");
			}
		});
		generateNotifications(projectSpace);
		UnicaseActionHelper.openDashboard(projectSpace);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.UpdateObserver#inspectChanges(org.unicase.workspace.ProjectSpace,
	 *      java.util.List)
	 */
	public boolean inspectChanges(ProjectSpace projectSpace, List<ChangePackage> changePackages) {
		projectToChanges.put(projectSpace, changePackages);
		return true;
	}

	@SuppressWarnings("unchecked")
	private void generateNotifications(ProjectSpace projectSpace) {
		List<ChangePackage> changePackages = projectToChanges.get(projectSpace);
		List<ChangePackage> changes = changePackages == null ? Collections.EMPTY_LIST : changePackages;
		List<DashboardNotification> notifications = NotificationHelper.generateNotifications(projectSpace, changes);

		DashboardNotificationComposite notificationComposite = DashboardFactory.eINSTANCE
			.createDashboardNotificationComposite();

		notificationComposite.getNotifications().addAll(notifications);

		projectSpace.getProject().getModelElements().add(notificationComposite);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.observers.DeleteProjectSpaceObserver#projectSpaceDeleted(org.eclipse.emf.emfstore.client.model.ProjectSpace)
	 */
	public void projectSpaceDeleted(ProjectSpace projectSpace) {
		// close all open editors before deleting
		IWorkbenchPage wbpage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorReference[] editors = wbpage.getEditorReferences();
		for (IEditorReference editorReference : editors) {
			try {
				if (editorReference.getEditorInput() instanceof DashboardEditorInput) {
					DashboardEditorInput editorInput = (DashboardEditorInput) editorReference.getEditorInput();
					if (projectSpace.equals(editorInput.getProjectSpace())) {
						wbpage.closeEditor(editorReference.getEditor(false), false);
					}
				}
			} catch (PartInitException e) {
				// Just print the stacktrace
				e.printStackTrace();
			}
		}
	}
}
