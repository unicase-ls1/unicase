/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigator;

import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.ModelElement;
import org.unicase.ui.common.dnd.UCDragAdapter;
import org.unicase.ui.common.dnd.UCDropAdapter;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * The standard navigator tree view.
 * 
 * @author helming
 */
public class TreeView extends ViewPart { // implements IShowInSource

	private static TreeViewer viewer;
	private MenuManager menuMgr;

	/**
	 * . Constructor
	 */
	public TreeView() {

	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent);
		IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
		viewer.setLabelProvider(new DecoratingLabelProvider(new TreeLabelProvider(), decoratorManager
			.getLabelDecorator()));
		viewer.setContentProvider(new TreeContentProvider());
		viewer.setInput(WorkspaceManager.getInstance().getCurrentWorkspace());

		// this is for workaround for update problem in navigator
		getSite().setSelectionProvider(viewer);

		menuMgr = new MenuManager();
		menuMgr.add(new Separator("additions"));
		getSite().registerContextMenu(menuMgr, viewer);
		Control control = viewer.getControl();
		Menu menu = menuMgr.createContextMenu(control);
		control.setMenu(menu);

		ActionHelper.createKeyHookDCAction(viewer, TreeView.class.getName());
		addDragNDropSupport();
		addSelectionListener();

		if (viewer.getTree().getItems().length > 0) {
			setActiveProjectSpace(viewer.getTree().getItem(0).getData());
			viewer.getTree().select(viewer.getTree().getItem(0));

		}

	}

	private void addSelectionListener() {
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection) event.getSelection();
					Object obj = selection.getFirstElement();
					setActiveProjectSpace(obj);
					if (obj instanceof ModelElement) {
						getViewSite().getActionBars().getStatusLineManager().setMessage(((ModelElement) obj).getName());
					}
				}
			}
		});

	}

	private void setActiveProjectSpace(Object obj) {

		if (obj == null) {
			return;
		}
		final ProjectSpace projectSpace;
		if (obj instanceof ModelElement) {
			ModelElement me = (ModelElement) obj;
			projectSpace = WorkspaceManager.getProjectSpace(me);
		} else if (obj instanceof ProjectSpace) {
			projectSpace = (ProjectSpace) obj;
		} else {
			projectSpace = null;
		}

		if (projectSpace == null) {
			// the active project space should NEVER be null
			return;
		}

		if (WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace() != null) {
			if (WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace().equals(projectSpace)) {
				return;
			}
		}
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				WorkspaceManager.getInstance().getCurrentWorkspace().setActiveProjectSpace(projectSpace);

			}

		});

	}

	private void addDragNDropSupport() {
		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };

		viewer.addDragSupport(dndOperations, transfers, new UCDragAdapter(viewer));

		viewer.addDropSupport(dndOperations, transfers, new UCDropAdapter(TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain"), viewer));

	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
		menuMgr.update();

	}

	/**
	 * This returns TreeViewer of navigator.
	 * 
	 * @return TreeViewer of navigator
	 */
	public static TreeViewer getTreeViewer() {
		return viewer;
	}

}