/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.navigator;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
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
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.ModelElement;
import org.unicase.model.diagram.DiagramType;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.common.dnd.UCDropAdapter;
import org.unicase.ui.meeditor.MEEditor;
import org.unicase.ui.meeditor.MEEditorInput;
import org.unicase.ui.navigator.commands.RedoAction;
import org.unicase.ui.navigator.commands.UndoAction;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * The standard navigator tree view.
 * 
 * @author helming
 * 
 */
public class TreeView extends ViewPart {

	private TreeViewer viewer;
	private Action doubleClickAction, undoAction, redoAction;

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
		IDecoratorManager decoratorManager = PlatformUI.getWorkbench()
				.getDecoratorManager();
		viewer.setLabelProvider(new DecoratingLabelProvider(
				new TreeLabelProvider(), decoratorManager.getLabelDecorator()));
		viewer.setContentProvider(new TreeContentProvider());
		viewer.setInput(WorkspaceManager.getInstance().getCurrentWorkspace());

		//this is for workaround for update problem in navigator
		getSite().setSelectionProvider(viewer);

		//set context menu
		MenuManager menuMgr = new MenuManager();
		menuMgr.add(new Separator("additions"));
		getSite().registerContextMenu(menuMgr, viewer);
		Control control = viewer.getControl();
		Menu menu = menuMgr.createContextMenu(control);
		control.setMenu(menu);

		makeActions();
		hookDoubleClickAction();
		addDragNDropSupport();
		addSelectionListener();

		// add global action handlers for undo/redo
		getViewSite().getActionBars().setGlobalActionHandler(
				ActionFactory.UNDO.getId(), undoAction);
		getViewSite().getActionBars().setGlobalActionHandler(
				ActionFactory.REDO.getId(), redoAction);

	}

	private void addSelectionListener() {
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				setActiveProjectSpace(event);
			}
		});
	}

	private void setActiveProjectSpace(SelectionChangedEvent event) {

		if (event.getSelection() instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) event
					.getSelection();
			Object obj = selection.getFirstElement();

			final ProjectSpace projectSpace;
			if (obj instanceof ModelElement) {
				ModelElement me = (ModelElement) obj;
				projectSpace = WorkspaceManager.getProjectSpace(me);
			} else if (obj instanceof ProjectSpace) {
				projectSpace = (ProjectSpace) obj;
			} else {
				projectSpace = null;
			}

			TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
					.getEditingDomain("org.unicase.EditingDomain");
			if (projectSpace != null) {
				domain.getCommandStack().execute(new RecordingCommand(domain) {

					protected void doExecute() {
						WorkspaceManager.getInstance().getCurrentWorkspace()
								.setActiveProjectSpace(projectSpace);

					}

				});
			}
		}
	}

	private void makeActions() {
		undoAction = new UndoAction();
		undoAction.setEnabled(false);
		redoAction = new RedoAction();
		redoAction.setEnabled(false);
	}

	private void addDragNDropSupport() {
		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };

		viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(
				viewer));

		viewer
				.addDropSupport(dndOperations, transfers, new UCDropAdapter(
						TransactionalEditingDomain.Registry.INSTANCE
								.getEditingDomain("org.unicase.EditingDomain"),
						viewer));

	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();

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
		if (diagram.getType().equals(DiagramType.CLASS_DIAGRAM)) {
			id = "org.unicase.model.classDiagram.part.ModelDiagramEditorID";
		}
		if (diagram.getType().equals(DiagramType.USECASE_DIAGRAM)) {
			id = "org.unicase.ui.usecaseDiagram.part.ModelDiagramEditorID";
		}
		if (id == null) {
			throw new RuntimeException("Unsupported diagram type");
		}
		URI uri = EcoreUtil.getURI(diagram);
		uri.appendFragment(diagram.eResource().getURIFragment(diagram));
		URIEditorInput input = new URIEditorInput(uri);

		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().openEditor(input, id, true);
		} catch (PartInitException e) {
			ErrorDialog.openError(PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getShell(), "Error", e
					.getMessage(), e.getStatus());
		}
	}
}