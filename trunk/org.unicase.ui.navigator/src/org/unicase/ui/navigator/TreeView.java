/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.ModelElement;
import org.unicase.ui.common.dnd.UCDragAdapter;
import org.unicase.ui.common.dnd.UCDropAdapter;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.meeditor.MEEditor;
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

	private boolean linkedWithEditor;

	private Action linkWithEditor;
	private PartListener partListener;

	/**
	 * Constructor.
	 */
	public TreeView() {
	}

	/**
	 * Reveals the editor input in navigator. Or if navigator selection is open in an editor, activates the editor.
	 * 
	 * @param link
	 */
	private void linkWithEditor(boolean linkEnabled) {
		if (linkEnabled) {

			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().addPartListener(partListener);
		} else {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().removePartListener(partListener);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#dispose()
	 */
	@Override
	public void dispose() {
		getSite().getPage().removePartListener(partListener);
		super.dispose();
	}

	/**
	 * {@inheritDoc}
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
		partListener = new PartListener(this);

		createActions();

		IToolBarManager toolBarManager = getViewSite().getActionBars().getToolBarManager();
		toolBarManager.add(linkWithEditor);

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

	private void createActions() {
		linkWithEditor = new Action("Link with editor", IAction.AS_CHECK_BOX) {

			@Override
			public void run() {
				if (linkedWithEditor) {
					linkedWithEditor = false;
					linkWithEditor(false);
				} else {
					linkedWithEditor = true;
					linkWithEditor(true);
					IEditorPart editor = getSite().getPage().getActiveEditor();
					if (editor != null) {
						editorActivated(editor);
					}
				}
			}

		};

		linkWithEditor.setImageDescriptor(Activator.getImageDescriptor("icons/link_with_editor.gif"));
		linkWithEditor.setToolTipText("Link with editor");

	}

	/**
	 * @param editor editor
	 */
	public void editorActivated(IEditorPart editor) {
		if (!(editor instanceof MEEditor)) {
			return;
		}

		MEEditor meEditor = (MEEditor) editor;
		ModelElement me = (ModelElement) meEditor.getEditorInput().getAdapter(ModelElement.class);
		if (me != null) {
			revealME(me);
		}

	}

	private void revealME(ModelElement me) {

		if (me == null) {
			return;
		}

		// we could easily use the following method.
		// but it has the problem that it shows the first occurrence of and element.
		// for example if we have the same element somewhere else linked, and shown as a child (e.g. in
		// ActionItemMeetingSection),
		// it just show the first one that it finds. We want only the real containment to be shown.
		// // TreeView.getTreeViewer().setSelection(new StructuredSelection(me), true);

		EObject container = me.eContainer();
		viewer.setSelection(new StructuredSelection(container));

		TreeSelection treeSelection = (TreeSelection) viewer.getSelection();
		if (treeSelection.getPaths().length > 0) {
			TreePath treePath = treeSelection.getPaths()[0].createChildPath(me);

			TreeSelection newTreeSeleciton = new TreeSelection(treePath);
			viewer.setSelection(newTreeSeleciton, true);
		}
	}

	private void addSelectionListener() {
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection) event.getSelection();
					Object obj = selection.getFirstElement();
					setActiveProjectSpace(obj);
					if (linkedWithEditor) {
						linkWithEditor(obj);
					}

					if (obj instanceof ModelElement) {
						getViewSite().getActionBars().getStatusLineManager().setMessage(((ModelElement) obj).getName());
					}
				}
			}

		});

	}

	private void linkWithEditor(Object obj) {
		if (obj == null) {
			return;
		}
		if (!(obj instanceof ModelElement)) {
			return;
		}

		ModelElement me = (ModelElement) obj;
		if (!isEditorOpen(me)) {
			return;
		} else {
			activateEditor(me);
		}
	}

	private void activateEditor(ModelElement selectedME) {
		for (IEditorReference editorRef : getSite().getPage().getEditorReferences()) {
			Object editorInput = null;
			try {

				editorInput = editorRef.getEditorInput().getAdapter(ModelElement.class);
			} catch (PartInitException e) {
				e.printStackTrace();
			}
			if (selectedME.equals(editorInput)) {
				getSite().getPage().activate(editorRef.getPart(true));
				return;
			}
		}
	}

	private boolean isEditorOpen(ModelElement selectedME) {
		for (IEditorReference editorRef : getSite().getPage().getEditorReferences()) {
			Object editorInput = null;
			try {

				editorInput = editorRef.getEditorInput().getAdapter(ModelElement.class);
			} catch (PartInitException e) {
				e.printStackTrace();
			}
			if (selectedME.equals(editorInput)) {
				return true;
			}
		}
		return false;

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
	 * {@inheritDoc}
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