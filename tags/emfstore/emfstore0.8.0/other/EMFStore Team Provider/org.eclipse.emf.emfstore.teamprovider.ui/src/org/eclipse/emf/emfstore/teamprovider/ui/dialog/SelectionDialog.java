/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.teamprovider.ui.dialog;

import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.provider.ESBrowserContentProvider;
import org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.provider.ESBrowserLabelProvider;
import org.eclipse.emf.emfstore.client.ui.views.emfstorebrowser.provider.ESBrowserViewerSorter;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.teamprovider.ui.exception.NoProjectSelectedException;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.menus.IMenuService;

/**
 * The SelectionDialog provides the same information as the "EmfStore Browser" view. But it is represented in a dialog.
 * This dialog is used to select a target project where the chosen EObject should be pushed.
 * 
 * @author Adrian Staudt
 */
public class SelectionDialog extends Dialog {

	private TreeViewer viewer;
	private ProjectInfo finallyChosenProjectInfo;
	private ServerInfo finallyChosenServerInfo;

	/**
	 * Constructor.
	 * 
	 * @param parentShell the shell
	 */
	public SelectionDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(final Composite parent) {
		final Composite composite = (Composite) super.createDialogArea(parent);
		composite.getShell().setSize(composite.getShell().computeSize(400, 200));
		composite.setLayout(new FillLayout());

		viewer = new TreeViewer(composite, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new ESBrowserContentProvider());
		IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
		viewer.setLabelProvider(new DecoratingLabelProvider(new ESBrowserLabelProvider(), decoratorManager
			.getLabelDecorator()));
		viewer.setSorter(new ESBrowserViewerSorter());
		viewer.setInput(WorkspaceManager.getInstance().getCurrentWorkspace());

		final MenuManager menuMgr = new MenuManager();
		IMenuService menuService = (IMenuService) PlatformUI.getWorkbench().getService(IMenuService.class);
		menuService.populateContributionManager(menuMgr, "popup:org.unicase.ui.repository.views.RepositoryView");
		viewer.getControl().setMenu(menuMgr.createContextMenu(viewer.getControl()));

		parent.pack();
		return composite;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, true);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
	 */
	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("EMF Store Browser");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#isResizable()
	 */
	@Override
	protected boolean isResizable() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	@Override
	protected void okPressed() {
		saveSelection();
		super.okPressed();
	}

	/**
	 * If the Dialog is closed, the SWT objects get disposed, and it is not longer possible to access these fields.
	 * Therefore user entered input must be saved into other objects.
	 */
	private void saveSelection() {
		ISelection selection = viewer.getSelection();
		if (selection instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection) selection;
			TreeNode treeNode = (TreeNode) treeSelection.getFirstElement();
			Object parentTreeNodeValue = treeNode.getParent().getValue();
			Object treeNodeValue = treeNode.getValue();

			if (parentTreeNodeValue instanceof ServerInfo) {
				finallyChosenServerInfo = (ServerInfo) parentTreeNodeValue;

			}
			if (treeNodeValue instanceof ProjectInfo) {
				finallyChosenProjectInfo = (ProjectInfo) treeNodeValue;
			}
		}
	}

	/**
	 * Retrieves the selected ServerInfo from the SelectionDialog.
	 * 
	 * @return the selected ServerInfo
	 * @throws NoProjectSelectedException if no project has been selected in the dialog
	 */
	public ServerInfo getSelectedServerInfo() throws NoProjectSelectedException {
		if (finallyChosenServerInfo == null) {
			throw new NoProjectSelectedException();
		}
		return finallyChosenServerInfo;
	}

	/**
	 * Retrieves the selected ProjectInfo from the SelectionDialog.
	 * 
	 * @return the selected ProjectInfo
	 * @throws NoProjectSelectedException if no project has been selected in the dialog
	 */
	public ProjectInfo getSelectedProjectInfo() throws NoProjectSelectedException {
		if (finallyChosenProjectInfo == null) {
			throw new NoProjectSelectedException();
		}
		return finallyChosenProjectInfo;
	}
}
