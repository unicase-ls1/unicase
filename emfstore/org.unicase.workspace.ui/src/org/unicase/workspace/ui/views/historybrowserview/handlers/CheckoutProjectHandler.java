/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.historybrowserview.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.jface.viewers.TreeNode;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.ui.util.DialogHandler;
import org.unicase.workspace.ui.commands.ServerRequestCommandHandler;
import org.unicase.workspace.ui.views.historybrowserview.HistoryBrowserView;

/**
 * Handler for checking out a new project.
 * 
 * @author Shterev
 */
public class CheckoutProjectHandler extends AbstractHistoryViewHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object run(ExecutionEvent event, HistoryBrowserView view, TreeNode node) {
		HistoryInfo historyInfo = (HistoryInfo) node.getValue();
		final PrimaryVersionSpec versionSpec = ModelUtil.clone(historyInfo.getPrimerySpec());
		final ProjectSpace projectSpace = view.getProjectSpace();

		ServerRequestCommandHandler handler = new ServerRequestCommandHandler() {

			@Override
			protected Object run() throws EmfStoreException {
				WorkspaceManager.getInstance().getCurrentWorkspace()
					.checkout(projectSpace.getUsersession(), projectSpace.getProjectInfo(), versionSpec);
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

		return null;
	}

}