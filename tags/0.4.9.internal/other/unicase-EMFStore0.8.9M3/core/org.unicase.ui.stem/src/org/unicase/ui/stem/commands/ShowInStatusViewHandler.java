/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecp.common.util.DialogHandler;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.stem.views.statusview.StatusView;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;

/**
 * This is the handler for ShowInStatusView command.
 * 
 * @author Hodaie
 */
public class ShowInStatusViewHandler extends AbstractHandler implements IPartListener {

	private static final String STATUS_VIEW_ID = "org.unicase.ui.treeview.views.StatusView";
	private static List<StatusView> openStatusViews;
	private IWorkbenchPage page;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#dispose()
	 */
	@Override
	public void dispose() {
		if (page != null) {
			page.removePartListener(this);
			super.dispose();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		if (openStatusViews == null) {
			openStatusViews = new ArrayList<StatusView>();
		}
		page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		page.addPartListener(this);
		UnicaseModelElement newInput = UnicaseActionHelper.getModelElement(event);

		StatusView statusView = (StatusView) page.findView(STATUS_VIEW_ID);
		if (statusView == null) {
			try {
				statusView = (StatusView) page.showView(STATUS_VIEW_ID, newInput.getName(),
					IWorkbenchPage.VIEW_ACTIVATE);
				statusView.setInput(newInput);
				openStatusViews.add(statusView);
			} catch (PartInitException e) {
				DialogHandler.showExceptionDialog(e);
			}

		} else {
			if (!openStatusViews.contains(statusView)) {
				openStatusViews.add(statusView);
			}
			for (StatusView stv : openStatusViews) {
				if (!stv.isPinned()) {
					page.activate(stv);
					stv.setInput(newInput);
					return null;
				}
			}
			try {

				StatusView newStatusView = (StatusView) page.showView(STATUS_VIEW_ID, newInput.getName(),
					IWorkbenchPage.VIEW_ACTIVATE);
				newStatusView.setInput(newInput);
				openStatusViews.add(newStatusView);
			} catch (PartInitException e) {
				DialogHandler.showExceptionDialog(e);
			}

		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IPartListener#partClosed(org.eclipse.ui.IWorkbenchPart)
	 */
	public void partClosed(IWorkbenchPart part) {
		openStatusViews.remove(part);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IPartListener#partActivated(org.eclipse.ui.IWorkbenchPart)
	 */
	public void partActivated(IWorkbenchPart part) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IPartListener#partBroughtToTop(org.eclipse.ui.IWorkbenchPart)
	 */
	public void partBroughtToTop(IWorkbenchPart part) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IPartListener#partDeactivated(org.eclipse.ui.IWorkbenchPart)
	 */
	public void partDeactivated(IWorkbenchPart part) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IPartListener#partOpened(org.eclipse.ui.IWorkbenchPart)
	 */
	public void partOpened(IWorkbenchPart part) {
	}

}
