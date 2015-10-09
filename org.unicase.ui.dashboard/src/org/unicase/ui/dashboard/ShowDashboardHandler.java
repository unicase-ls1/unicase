/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.ESUsersession;
import org.eclipse.emf.emfstore.internal.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.internal.client.model.exceptions.UnkownProjectException;
import org.eclipse.emf.emfstore.internal.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.internal.client.model.util.WorkspaceUtil;
import org.eclipse.emf.emfstore.internal.common.model.util.ModelUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.ui.dashboard.view.DashboardEditor;
import org.unicase.ui.dashboard.view.DashboardEditorInput;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;

/**
 * Handler for viewing the dashboard.
 * 
 * @author Shterev
 */
public class ShowDashboardHandler extends AbstractHandler {

	private static final String DASHBOARD_CONTEXT_VARIABLE = "org.unicase.ui.dashboardInput";
	private static final String DASHBOARD_ID = "org.unicase.ui.dashboard";

	/**
	 * {@inheritDoc}
	 */
	public Object execute(final ExecutionEvent event) throws ExecutionException {

		ProjectSpace projectSpace = null;
		final ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		final IStructuredSelection ssel = (IStructuredSelection) selection;
		ESUsersession userSession = null;
		try {
			userSession = OrgUnitHelper.getUserSession((EObject) ssel
					.getFirstElement());
		} catch (UnkownProjectException e) {
			ModelUtil.logWarning(e.getMessage());
		}
		if (userSession == null) {
			return null;
		}
		final ProjectSpace ps = projectSpace;
		new EMFStoreCommand() {

			@Override
			protected void doRun() {
				DashboardEditorInput input = new DashboardEditorInput(ps);
				try {
					IEditorPart openEditor = PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getActivePage()
							.openEditor(input, DASHBOARD_ID, true);
					if (openEditor instanceof DashboardEditor) {
						((DashboardEditor) openEditor).refresh();
					}
				} catch (PartInitException e) {
					WorkspaceUtil.logException(e.getMessage(), e);
				}
			}
		}.run();

		return null;
	}
}
