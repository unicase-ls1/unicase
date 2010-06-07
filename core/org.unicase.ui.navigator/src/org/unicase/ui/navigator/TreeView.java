/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.ui.common.dnd.ComposedDropAdapter;
import org.unicase.ui.common.dnd.UCDragAdapter;
import org.unicase.ui.meeditor.MEEditor;
import org.unicase.ui.navigator.commands.AltKeyDoubleClickAction;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;
import org.unicase.workspace.observers.SimpleOperationListener;
import org.unicase.workspace.util.ProjectSpaceContainer;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * The standard navigator tree view.
 * 
 * @author helming
 */
public class TreeView extends ViewPart implements ISelectionListener { // implements
	// IShowInSource

	private static TreeViewer viewer;
	private MenuManager menuMgr;

	private boolean isLinkedWithEditor;
	private Action linkWithEditor;
	private PartListener partListener;
	private Workspace currentWorkspace;
	private AdapterImpl workspaceListenerAdapter;
	private SimpleOperationListener simpleOperationListener;
	private boolean internalSelectionEvent;

	/**
	 * Constructor.
	 */
	public TreeView() {
		createOperationListener();
		currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		for (ProjectSpace projectSpace : currentWorkspace.getProjectSpaces()) {
			projectSpace.addOperationListener(simpleOperationListener);
		}
		workspaceListenerAdapter = new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				if ((msg.getFeatureID(Workspace.class)) == WorkspacePackage.WORKSPACE__PROJECT_SPACES) {
					if (msg.getEventType() == Notification.ADD
						&& WorkspacePackage.eINSTANCE.getProjectSpace().isInstance(msg.getNewValue())) {
						ProjectSpace projectSpace = (ProjectSpace) msg.getNewValue();
						projectSpace.addOperationListener(simpleOperationListener);
					} else if (msg.getEventType() == Notification.REMOVE
						&& WorkspacePackage.eINSTANCE.getProjectSpace().isInstance(msg.getOldValue())) {
						ProjectSpace projectSpace = (ProjectSpace) msg.getOldValue();
						projectSpace.removeOperationListener(simpleOperationListener);
					}
				}
				super.notifyChanged(msg);
			}
		};
		currentWorkspace.eAdapters().add(workspaceListenerAdapter);

	}

	/**
	 * We need to refresh the Navigator on every Operation so that dirty decorators on individual model elements are
	 * updated. The refresh happens asynchronously and currently is no performance problem.
	 */
	private void createOperationListener() {
		simpleOperationListener = new SimpleOperationListener() {

			@Override
			public void operationPerformed(AbstractOperation operation) {
				Display.getDefault().asyncExec(new Runnable() {

					public void run() {

						viewer.refresh();
					}

				});
			}

		};
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#dispose()
	 */
	@Override
	public void dispose() {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().removeSelectionListener(this);
		getSite().getPage().removePartListener(partListener);
		currentWorkspace.eAdapters().remove(workspaceListenerAdapter);
		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI);
		IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
		viewer.setLabelProvider(new DecoratingLabelProvider(new TreeLabelProvider(), decoratorManager
			.getLabelDecorator()));
		viewer.setContentProvider(new TreeContentProvider());
		viewer.setInput(currentWorkspace);
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().addSelectionListener(this);

		// this is for workaround for update problem in navigator
		getSite().setSelectionProvider(viewer);
		partListener = new PartListener();

		menuMgr = new MenuManager();
		menuMgr.add(new Separator("additions"));
		getSite().registerContextMenu(menuMgr, viewer);
		Control control = viewer.getControl();
		Menu menu = menuMgr.createContextMenu(control);
		control.setMenu(menu);

		createActions();

		new AltKeyDoubleClickAction(viewer, TreeView.class.getName());

		addDragNDropSupport();
		addSelectionListener();

		if (viewer.getTree().getItems().length > 0) {
			setActiveProjectSpace(viewer.getTree().getItem(0).getData());
			viewer.getTree().select(viewer.getTree().getItem(0));

		}

	}

	private void createActions() {
		isLinkedWithEditor = getDialogSettings().getBoolean("LinkWithEditor");
		if (isLinkedWithEditor) {
			getSite().getPage().addPartListener(partListener);
		}

		linkWithEditor = new Action("Link with editor", SWT.TOGGLE) {

			@Override
			public void run() {
				if (isLinkedWithEditor) {
					isLinkedWithEditor = false;
					getSite().getPage().removePartListener(partListener);
				} else {
					isLinkedWithEditor = true;
					getSite().getPage().addPartListener(partListener);
					IEditorPart editor = getSite().getPage().getActiveEditor();
					if (editor != null) {
						editorActivated(editor);
					}
				}

				getDialogSettings().put("LinkWithEditor", this.isChecked());
			}

		};

		linkWithEditor.setImageDescriptor(Activator.getImageDescriptor("icons/link_with_editor.gif"));
		linkWithEditor.setToolTipText("Link with editor");
		linkWithEditor.setChecked(getDialogSettings().getBoolean("LinkWithEditor"));

		IToolBarManager toolBarManager = getViewSite().getActionBars().getToolBarManager();
		Separator additionsSeperator = new Separator("additions");
		additionsSeperator.setVisible(true);
		toolBarManager.add(additionsSeperator);
		toolBarManager.insertAfter("additions", linkWithEditor);

	}

	private IDialogSettings getDialogSettings() {
		return Activator.getDefault().getDialogSettings();
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

		// hack
		if (!viewer.getExpandedState(me)) {
			viewer.expandToLevel(2);
		}

		// we could easily use the following method.
		// but it has the problem that it shows the first occurrence of and element.
		// for example if we have the same element somewhere else linked, and shown as a child (e.g. in
		// ActionItemMeetingSection),
		// it just show the first one that it finds. We want only the real containment to be shown.
		// // TreeView.getTreeViewer().setSelection(new StructuredSelection(me), true);

		EObject container = me.eContainer();
		internalSelectionEvent = true;
		viewer.setSelection(new StructuredSelection(container), true);

		TreeSelection treeSelection = (TreeSelection) viewer.getSelection();
		if (treeSelection.getPaths().length > 0) {
			TreePath treePath = treeSelection.getPaths()[0].createChildPath(me);

			TreeSelection newTreeSeleciton = new TreeSelection(treePath);
			viewer.setSelection(newTreeSeleciton, true);
		}
		internalSelectionEvent = false;
	}

	private void addSelectionListener() {
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection) event.getSelection();
					Object obj = selection.getFirstElement();
					setActiveProjectSpace(obj);

					// activate MEEditor if this obj is already open.
					if (isLinkedWithEditor && !internalSelectionEvent) {
						linkWithEditor(obj);
					}

					if (obj instanceof ModelElement) {
						getViewSite().getActionBars().getStatusLineManager().setMessage(
							((ModelElement) obj).getIdentifier());
					}
				}
			}

		});

	}

	/**
	 * This checks if there is a MEEditor for selected ME open. If so, calls activateEditor to show editor.
	 * 
	 * @param selectedME
	 */
	private void linkWithEditor(Object selectedME) {
		if (selectedME == null) {
			return;
		}
		if (!(selectedME instanceof ModelElement)) {
			return;
		}

		ModelElement me = (ModelElement) selectedME;
		if (!isEditorOpen(me)) {
			return;
		} else {
			activateEditor(me);
		}
	}

	/**
	 * If there is a MEEditor for selected ME open, it shows the editor.
	 * 
	 * @param selectedME
	 */
	private void activateEditor(ModelElement selectedME) {
		for (IEditorReference editorRef : getSite().getPage().getEditorReferences()) {
			Object editorInput = null;
			try {

				editorInput = editorRef.getEditorInput().getAdapter(ModelElement.class);
			} catch (PartInitException e) {
				e.printStackTrace();
			}
			if (selectedME.equals(editorInput)) {
				getSite().getPage().bringToTop(editorRef.getPart(true));
				return;
			}
		}
	}

	/**
	 * This checks if selectedME is already open in a MEEditor.
	 * 
	 * @param selectedME
	 * @return
	 */
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
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				WorkspaceManager.getInstance().getCurrentWorkspace().setActiveProjectSpace(projectSpace);
			}
		}.run();

	}

	private void addDragNDropSupport() {
		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };

		viewer.addDragSupport(dndOperations, transfers, new UCDragAdapter(viewer));

		viewer.addDropSupport(dndOperations, transfers, new ComposedDropAdapter(Configuration.getEditingDomain(),
			viewer));

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

	/**
	 * This is a prart listener for navigator. I had to implement it in a separate class, because of check style warning
	 * about anonymous classes greater than 30 lines.
	 * 
	 * @author Hodaie
	 */
	private class PartListener implements IPartListener2 {

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.ui.IPartListener2#partActivated(org.eclipse.ui.IWorkbenchPartReference)
		 */
		public void partActivated(IWorkbenchPartReference partRef) {
			if (partRef instanceof IEditorReference) {
				TreeView.this.editorActivated(((IEditorReference) partRef).getEditor(true));
			}
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.ui.IPartListener2#partBroughtToTop(org.eclipse.ui.IWorkbenchPartReference)
		 */
		public void partInputChanged(IWorkbenchPartReference partRef) {
			if (partRef instanceof IEditorReference) {
				TreeView.this.editorActivated(((IEditorReference) partRef).getEditor(true));
			}
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.ui.IPartListener2#partBroughtToTop(org.eclipse.ui.IWorkbenchPartReference)
		 */
		public void partBroughtToTop(IWorkbenchPartReference partRef) {
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.ui.IPartListener2#partBroughtToTop(org.eclipse.ui.IWorkbenchPartReference)
		 */
		public void partClosed(IWorkbenchPartReference partRef) {
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.ui.IPartListener2#partBroughtToTop(org.eclipse.ui.IWorkbenchPartReference)
		 */
		public void partDeactivated(IWorkbenchPartReference partRef) {
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.ui.IPartListener2#partBroughtToTop(org.eclipse.ui.IWorkbenchPartReference)
		 */
		public void partHidden(IWorkbenchPartReference partRef) {
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.ui.IPartListener2#partBroughtToTop(org.eclipse.ui.IWorkbenchPartReference)
		 */
		public void partOpened(IWorkbenchPartReference partRef) {
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.ui.IPartListener2#partBroughtToTop(org.eclipse.ui.IWorkbenchPartReference)
		 */
		public void partVisible(IWorkbenchPartReference partRef) {
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (part == this) {
			return;
		}
		if (part instanceof ProjectSpaceContainer) {
			updateSelectionfromProjectSpaceContainer(selection, (ProjectSpaceContainer) part);
		}
	}

	private void updateSelectionfromProjectSpaceContainer(ISelection selection,
		ProjectSpaceContainer projectSpaceContainer) {
		ProjectSpace projectSpace = projectSpaceContainer.getProjectSpace();
		if (projectSpace == null) {
			return;
		}
		Project project = projectSpace.getProject();
		if (project == null) {
			return;
		}
		Object element = extractObjectFromSelection(selection);
		if (element == null) {
			return;
		}
		if (element instanceof ModelElement) {
			ModelElementId modelElementId = ((ModelElement) element).getModelElementId();
			revealME(project.getModelElement(modelElementId));
		} else if (element instanceof CompositeOperation) {
			CompositeOperation comop = (CompositeOperation) element;
			AbstractOperation mainOperation = comop.getMainOperation();
			if (mainOperation != null) {
				ModelElementId modelElementId = mainOperation.getModelElementId();
				revealME(project.getModelElement(modelElementId));
			}
		} else if (element instanceof AbstractOperation) {
			ModelElementId modelElementId = ((AbstractOperation) element).getModelElementId();
			revealME(project.getModelElement(modelElementId));
		}

	}

	private Object extractObjectFromSelection(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.size() == 1) {
				Object node = structuredSelection.getFirstElement();
				if (node instanceof TreeNode) {
					Object element = ((TreeNode) node).getValue();
					return element;
				}
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#projectDeleted(org.unicase.metamodel.Project)
	 */
	public void projectDeleted(Project project) {
		viewer.refresh();

	}

}