/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.ui.views.historybrowserview.handlers;

import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecp.common.util.DialogHandler;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.ui.commands.ServerRequestCommandHandler;
import org.eclipse.emf.emfstore.client.ui.views.historybrowserview.HistoryBrowserView;
import org.eclipse.emf.emfstore.client.ui.views.historybrowserview.HistoryCompare;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * Handler for comparing two revisions.
 * 
 * @author Engelmann
 * @author Stute
 */
public class CompareRevisionsHandler extends AbstractHistoryViewHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object run(ExecutionEvent event, HistoryBrowserView view,
			TreeNode node) {

		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		IStructuredSelection object = (IStructuredSelection) activeWorkbenchWindow
				.getSelectionService().getSelection();
		List list = object.toList();
		// Project project1 = null;
		// Project project2 = null;
		// ProjectSpace projectSpace1 = null;
		// ProjectSpace projectSpace2 = null;

		if (list.size() == 2) {
			// for (int i = 0; i < list.size(); i++) {
			// TreeNode element = (TreeNode) list.get(i);
			// HistoryInfo historyInfo = (HistoryInfo) element.getValue();
			// final PrimaryVersionSpec versionSpec = ModelUtil
			// .clone(historyInfo.getPrimerySpec());
			// final ProjectSpace projectSpace = view.getProjectSpace();
			// ProjectSpace projectSpaceVersion = ModelUtil
			// .clone(projectSpace);
			//
			// if (i == 0) {
			// projectSpaceVersion.setBaseVersion(versionSpec);
			// projectSpace1 = projectSpaceVersion;
			// project1 = projectSpace1.getProject();
			// } else {
			// projectSpaceVersion.setBaseVersion(versionSpec);
			// projectSpace2 = projectSpaceVersion;
			// project2 = projectSpace2.getProject();
			// }
			// }
			// if (HistoryCompare.hasRegisteredExtensions()) {
			// // TODO replace null by the two EObjects representing the two
			// // Project Revisions
			// HistoryCompare.handleRegisteredExtensions(project1, project2);
			// }

			TreeNode element1 = (TreeNode) list.get(0);
			HistoryInfo historyInfo1 = (HistoryInfo) element1.getValue();
			final PrimaryVersionSpec versionSpec1 = ModelUtil
					.clone(historyInfo1.getPrimerySpec());
			final ProjectSpace projectSpace1 = view.getProjectSpace();

			TreeNode element2 = (TreeNode) list.get(1);
			HistoryInfo historyInfo2 = (HistoryInfo) element2.getValue();
			final PrimaryVersionSpec versionSpec2 = ModelUtil
					.clone(historyInfo2.getPrimerySpec());
			final ProjectSpace projectSpace2 = view.getProjectSpace();

			ServerRequestCommandHandler handler = new ServerRequestCommandHandler() {

				@Override
				protected Object run() throws EmfStoreException {
					ProjectSpace pSpace1 = WorkspaceManager
							.getInstance()
							.getCurrentWorkspace()
							.getRevision(projectSpace1.getUsersession(),
									projectSpace1.getProjectInfo(),
									versionSpec1);

					ProjectSpace pSpace2 = WorkspaceManager
							.getInstance()
							.getCurrentWorkspace()
							.getRevision(projectSpace2.getUsersession(),
									projectSpace2.getProjectInfo(),
									versionSpec2);
					if (HistoryCompare.hasRegisteredExtensions()) {
						HistoryCompare.handleRegisteredExtensions(
								pSpace1.getProject(), pSpace2.getProject());
					}
					return null;
				}

				@Override
				public String getTaskTitle() {
					return "Resolving project versions...";
				}
			};

			try {
				handler.execute(new ExecutionEvent());
			} catch (ExecutionException e) {
				DialogHandler.showErrorDialog(e.getMessage());
			}
		}

		return null;
	}
}
