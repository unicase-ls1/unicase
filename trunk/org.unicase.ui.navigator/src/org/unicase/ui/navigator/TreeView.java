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
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.decorators.DecoratorManager;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.ModelElement;
import org.unicase.model.diagram.DiagramType;
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

	/**
	 * . Constructor
	 */
	public TreeView() {

	}

	/**.
	 * {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent);
		IDecoratorManager decoratorManager = new DecoratorManager();
		viewer.setLabelProvider(new DecoratingLabelProvider(new TreeLabelProvider(), decoratorManager.getLabelDecorator()));
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

	/**.
	 * {@inheritDoc}
	 */
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
				TreeSelection selection = (TreeSelection) viewer.getSelection();
				Object object = selection.getFirstElement();
				openME(object);
			}
		};

	}

	
	private void openME(Object object) {
		if (object == null) {
			return;
		}
		if (object instanceof ModelElement) {
			ModelElement modelElement = (ModelElement) object;
			if (object instanceof MEDiagram) {
				openDiagram((MEDiagram) modelElement);
			} else {
				MEEditorInput input = new MEEditorInput(modelElement);
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow()
							.getActivePage().openEditor(input, MEEditor.ID,
									true);
				} catch (PartInitException e) {
					ErrorDialog.openError(PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getShell(), "Error", e
							.getMessage(), e.getStatus());
				}
			}
		}

	}

	private void openDiagram(MEDiagram diagram) {
		String id = null;
		if(diagram.getType().equals(DiagramType.CLASS_DIAGRAM)){
			id="org.unicase.model.classDiagram.part.ModelDiagramEditorID";
		}
		if(diagram.getType().equals(DiagramType.USECASE_DIAGRAM)){
			id="org.unicase.ui.usecaseDiagram.part.ModelDiagramEditorID";
		}
		if(id==null){
			throw new RuntimeException("Unsupported diagram type");
		}
		URIEditorInput input = new URIEditorInput(URI
				.createURI(diagram.eResource().getURIFragment(
						diagram)));
		try {
			PlatformUI
					.getWorkbench()
					.getActiveWorkbenchWindow()
					.getActivePage()
					.openEditor(
							input,
							id,
							true);
		} catch (PartInitException e) {
			ErrorDialog.openError(PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getShell(), "Error", e
					.getMessage(), e.getStatus());
		}
	}
}