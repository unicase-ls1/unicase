/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.navigator;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.ModelElement;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.meeditor.MEEditor;
import org.unicase.ui.meeditor.MEEditorInput;
import org.unicase.workspace.WorkspaceManager;

/**
 * The standard navigator tree view.
 * 
 * @author helming
 * 
 */
public class TreeView extends ViewPart {

	private TreeViewer viewer;
	private Action doubleClickAction;

	public TreeView() {

	}

	@Override
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent);
		viewer.setLabelProvider(new TreeLabelProvider());
		viewer.setContentProvider(new TreeContentProvider());
		viewer.setInput(WorkspaceManager.getInstance().getCurrentWorkspace());

		getSite().setSelectionProvider(viewer);

		MenuManager menuMgr = new MenuManager();
		menuMgr.add(new Separator("additions"));
		getSite().registerContextMenu(menuMgr, viewer);
		Control control = viewer.getControl();
		Menu menu = menuMgr.createContextMenu(control);
		control.setMenu(menu);

		hookDoubleClickAction();
		addDragNDropSupport();
		

	}

	private void addDragNDropSupport() {
		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };
				
		viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(
				viewer));
		
		viewer.addDropSupport(dndOperations, transfers,
				new TreeViewerDropAdapter(
						TransactionalEditingDomain.Registry.INSTANCE
								.getEditingDomain("org.unicase.EditingDomain"),
						viewer));

		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	private void hookDoubleClickAction() {
		
		createDoubleClickAction();
		
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}

	private void createDoubleClickAction() {
		 doubleClickAction = new Action() {
			public void run() {
				TreeSelection selection = (TreeSelection)viewer.getSelection();
				Object object = selection.getFirstElement();
				if (object instanceof ModelElement) {
					if (object instanceof MEDiagram) {
						ModelElement modelElement = (ModelElement) object;
						URIEditorInput input = new URIEditorInput(URI
								.createURI(modelElement.eResource().getURIFragment(
										modelElement)));
						try {
							PlatformUI
									.getWorkbench()
									.getActiveWorkbenchWindow()
									.getActivePage()
									.openEditor(
											input,
											"org.unicase.model.classDiagram.part.ModelDiagramEditorID",
											true);
						} catch (PartInitException e) {
							ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Error", e.getMessage(), e.getStatus());
						}
					} else {
						MEEditorInput input = new MEEditorInput((ModelElement) object);
						try {
							PlatformUI.getWorkbench().getActiveWorkbenchWindow()
									.getActivePage().openEditor(input,MEEditor.ID,
											true);
							
						
						} catch (PartInitException e) {
							ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Error", e.getMessage(), e.getStatus());
						}
					}
				}
			}
		};
		
	}

	

}