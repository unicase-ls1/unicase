/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.historybrowserview.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.workspace.ui.views.historybrowserview.HistoryBrowserView;

/**
 * Abstract class for the context menu handlers for the History view.
 * 
 * @author shterev
 */
public abstract class AbstractHistoryViewHandler extends AbstractHandler {

	/**
	 * Default constructor.
	 */
	public AbstractHistoryViewHandler() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		ISelection object = activeWorkbenchWindow.getSelectionService().getSelection();
		if (!(object instanceof IStructuredSelection)) {
			return null;
		}

		IStructuredSelection selection = (IStructuredSelection) object;
		if (!(selection.getFirstElement() instanceof TreeNode)) {
			return null;
		}

		TreeNode node = (TreeNode) selection.getFirstElement();
		if (!(node.getValue() instanceof HistoryInfo)) {
			return null;
		}

		IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
		if (activePage == null) {
			return null;
		}

		if (!(activePage.getActivePart() instanceof HistoryBrowserView)) {
			return null;
		}

		HistoryBrowserView view = (HistoryBrowserView) activePage.getActivePart();
		return run(event, view, node);
	}

	/**
	 * Contains the actual actions.
	 * 
	 * @param event the forwarded event from {@link #execute(ExecutionEvent)}
	 * @param view the resolved instance of the History view
	 * @param node the resolved TreeNode
	 * @return the result or null
	 */
	protected abstract Object run(ExecutionEvent event, HistoryBrowserView view, TreeNode node);

}