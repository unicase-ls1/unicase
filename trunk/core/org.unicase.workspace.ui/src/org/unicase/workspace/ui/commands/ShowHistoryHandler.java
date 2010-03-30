/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.commands;

import java.util.Date;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.versioning.events.EventsFactory;
import org.unicase.emfstore.esmodel.versioning.events.PluginFocusEvent;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.ui.views.historybrowserview.HistoryBrowserView;

/**
 * Handler for viewing the history of the current project.
 * 
 * @author Shterev
 */
public class ShowHistoryHandler extends ServerRequestCommandHandler {

	/**
	 * Default constructor.
	 */
	public ShowHistoryHandler() {
		setTaskTitle("Resolving history...");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object run() throws EmfStoreException {
		ProjectSpace projectSpace = getProjectSpace();
		ModelElement modelElement = getModelElement();
		if (projectSpace == null) {
			// ProjectSpace activeProjectSpace = WorkspaceManager.getInstance()
			// .getCurrentWorkspace().getActiveProjectSpace();
			// if (activeProjectSpace == null) {
			// MessageDialog.openInformation(shell, "Information",
			// "You must select the Project");
			// return null;
			// }
			// projectSpace = activeProjectSpace;
			projectSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpace(
				modelElement.getProject());
		}

		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		HistoryBrowserView historyBrowserView = null;
		String viewId = "org.unicase.workspace.ui.views.historybrowserview.HistoryBrowserView";
		try {
			historyBrowserView = (HistoryBrowserView) page.showView(viewId);
		} catch (PartInitException e) {
			DialogHandler.showExceptionDialog(e);
		}
		if (historyBrowserView != null) {
			historyBrowserView.setInput(projectSpace, modelElement);
			logEvent(projectSpace, viewId);
		}
		return null;
	}

	private Shell shell;

	private void logEvent(final ProjectSpace finalProjectSpace, String viewId) {
		PluginFocusEvent historyEvent = EventsFactory.eINSTANCE.createPluginFocusEvent();
		historyEvent.setPluginId(viewId);
		historyEvent.setTimestamp(new Date());
		finalProjectSpace.addEvent(historyEvent);
	}
}