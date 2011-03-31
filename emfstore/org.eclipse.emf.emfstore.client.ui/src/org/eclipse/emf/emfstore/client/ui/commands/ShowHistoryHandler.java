/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.ui.commands;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.ui.views.historybrowserview.HistoryBrowserView;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.versioning.events.EventsFactory;
import org.eclipse.emf.emfstore.server.model.versioning.events.PluginFocusEvent;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.ui.util.DialogHandler;

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
		EObject modelElement = getModelElement();
		if (projectSpace == null) {
			projectSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpace(
				ModelUtil.getProject(modelElement));
		}

		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		HistoryBrowserView historyBrowserView = null;
		String viewId = "org.eclipse.emf.emfstore.client.ui.views.historybrowserview.HistoryBrowserView";
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

	private void logEvent(final ProjectSpace finalProjectSpace, String viewId) {
		PluginFocusEvent historyEvent = EventsFactory.eINSTANCE.createPluginFocusEvent();
		historyEvent.setPluginId(viewId);
		historyEvent.setTimestamp(new Date());
		finalProjectSpace.addEvent(historyEvent);
	}
}
