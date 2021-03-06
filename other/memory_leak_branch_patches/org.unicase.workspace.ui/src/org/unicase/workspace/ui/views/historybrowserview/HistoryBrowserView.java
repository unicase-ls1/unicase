/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.historybrowserview;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.ViewPart;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.HistoryQuery;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.TagVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.events.EventsFactory;
import org.unicase.emfstore.esmodel.versioning.events.ShowHistoryEvent;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationId;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.InvalidVersionSpecException;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.ui.util.DialogHandler;
import org.unicase.ui.util.UiUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ui.Activator;
import org.unicase.workspace.ui.commands.ServerRequestCommandHandler;
import org.unicase.workspace.ui.util.ElementOpenerHelper;
import org.unicase.workspace.ui.views.changes.ChangePackageVisualizationHelper;
import org.unicase.workspace.ui.views.scm.SCMContentProvider;
import org.unicase.workspace.ui.views.scm.SCMLabelProvider;
import org.unicase.workspace.util.ProjectSpaceContainer;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * This the History Browser view.
 * 
 * @author Hodaie
 * @author Wesendonk
 * @author Shterev
 */
public class HistoryBrowserView extends ViewPart implements ProjectSpaceContainer {

	/**
	 * Treeviewer that provides a model element selection for selected operations and mode element ids.
	 * 
	 * @author koegel
	 */
	private final class TreeViewerWithModelElementSelectionProvider extends TreeViewer {
		private TreeViewerWithModelElementSelectionProvider(Composite parent, int style) {
			super(parent, style);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.jface.viewers.AbstractTreeViewer#getSelection()
		 */
		@Override
		public ISelection getSelection() {
			Control control = getControl();
			if (control == null || control.isDisposed()) {
				return super.getSelection();
			}
			Widget[] items = getSelection(getControl());

			if (items.length != 1) {
				return super.getSelection();
			}
			Widget item = items[0];
			Object data = item.getData();
			if (data == null || !(data instanceof TreeNode)) {
				return super.getSelection();
			}
			TreeNode node = (TreeNode) data;
			if (node.getValue() == null) {
				return super.getSelection();
			}
			// now we know that one tree node is selected with a non null value
			Object element = node.getValue();
			EObject selectedModelElement = null;

			if (element instanceof CompositeOperation) {
				CompositeOperation comop = (CompositeOperation) element;
				AbstractOperation mainOperation = comop.getMainOperation();
				if (mainOperation != null) {
					ModelElementId modelElementId = mainOperation.getModelElementId();
					selectedModelElement = projectSpace.getProject().getModelElement(modelElementId);
					return new StructuredSelection(selectedModelElement);
				}
			} else if (element instanceof AbstractOperation) {
				ModelElementId modelElementId = ((AbstractOperation) element).getModelElementId();
				selectedModelElement = projectSpace.getProject().getModelElement(modelElementId);
				return new StructuredSelection(selectedModelElement);
			} else if (element instanceof EObject) {
				if (element instanceof ProjectSpace) {
					selectedModelElement = ((ProjectSpace) element).getProject();
				} else if (element instanceof ModelElementId
					&& projectSpace.getProject().contains((ModelElementId) element)) {
					selectedModelElement = projectSpace.getProject().getModelElement((ModelElementId) element);
				} else if (projectSpace.getProject().containsInstance((EObject) element)) {
					selectedModelElement = (EObject) element;
				} else {
					// TODO: PlainEObjectMode, what happens with deleted elements and stuff like the HistoryInfo node?
					return super.getSelection();
				}

				return new StructuredSelection(selectedModelElement);
			}

			return super.getSelection();
		}
	}

	private static final String VIEW_ID = "org.unicase.workspace.ui.views.historybrowserview";

	private List<HistoryInfo> historyInfos;

	private ProjectSpace projectSpace;

	private int startOffset = 24;

	/**
	 * this should be the UNRESOLVED VersionSpec ID (-1 for HeadVersionSpec).
	 */
	private int currentEnd;

	private int headVersion;

	private EObject modelElement;

	private TreeViewer viewer;
	private Map<Integer, ChangePackage> changePackageCache;

	private ChangePackageVisualizationHelper changePackageVisualizationHelper;

	private SCMContentProvider contentProvider;

	private SCMLabelProvider labelProvider;

	private Action groupByMe;

	private Action showRoots;

	private Label noProjectHint;

	private Composite parent;

	private boolean isUnlinkedFromNavigator;

	private TreeViewerColumn changesColumn;

	private TreeViewerColumn logColumn;

	private LogMessageColumnLabelProvider logLabelProvider;

	/**
	 * Constructor.
	 */
	public HistoryBrowserView() {
		historyInfos = new ArrayList<HistoryInfo>();
		changePackageCache = new HashMap<Integer, ChangePackage>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {
		GridLayoutFactory.fillDefaults().applyTo(parent);
		this.parent = parent;

		noProjectHint = new Label(parent, SWT.WRAP);
		GridDataFactory.fillDefaults().align(SWT.CENTER, SWT.CENTER).grab(true, true).applyTo(noProjectHint);
		noProjectHint.setText("Please call 'Show history' from the context menu of an element in the navigator.");

		viewer = new TreeViewerWithModelElementSelectionProvider(parent, SWT.NONE);

		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.add(new Separator("additions"));
		Control control = viewer.getControl();
		Menu menu = menuMgr.createContextMenu(control);
		control.setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);

		getSite().setSelectionProvider(viewer);

		GridDataFactory.fillDefaults().grab(true, true).applyTo(viewer.getControl());
		ColumnViewerToolTipSupport.enableFor(viewer);
		viewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				if (event.getSelection() instanceof IStructuredSelection) {
					TreeNode node = (TreeNode) ((IStructuredSelection) event.getSelection()).getFirstElement();
					if (node.getValue() instanceof EObject) {
						ElementOpenerHelper.openModelElement((EObject) node.getValue(), VIEW_ID);
					}
				}

			}
		});

		changesColumn = new TreeViewerColumn(viewer, SWT.NONE);
		changesColumn.getColumn().setText("Changes");
		changesColumn.getColumn().setWidth(400);

		logColumn = new TreeViewerColumn(viewer, SWT.NONE);
		logColumn.getColumn().setText("Commit information");
		logColumn.getColumn().setWidth(300);

		Tree tree = viewer.getTree();
		tree.setHeaderVisible(true);

		hookToobar();
	}

	private void hookToobar() {
		IActionBars bars = getViewSite().getActionBars();
		IToolBarManager menuManager = bars.getToolBarManager();

		addExpandAllAndCollapseAllAction(menuManager);

		addRefreshAction(menuManager);

		addGroupByModelElementButton(menuManager);

		addShowRootAction(menuManager);

		addNextAndPreviousAction(menuManager);

		addJumpToRevisionAction(menuManager);

		addLinkWithNavigatorAction(menuManager);

	}

	private void addExpandAllAndCollapseAllAction(IToolBarManager menuManager) {
		final ImageDescriptor expandImg = Activator.getImageDescriptor("icons/expandall.gif");
		final ImageDescriptor collapseImg = Activator.getImageDescriptor("icons/collapseall.gif");

		Action expandAndCollapse = new Action("", SWT.TOGGLE) {
			@Override
			public void run() {
				if (!isChecked()) {
					setImageDescriptor(expandImg);
					viewer.collapseAll();
				} else {
					setImageDescriptor(collapseImg);
					viewer.expandToLevel(2);
				}
			}

		};
		expandAndCollapse.setImageDescriptor(expandImg);
		expandAndCollapse.setToolTipText("Use this toggle to expand or collapse all elements");
		menuManager.add(expandAndCollapse);
	}

	private void addRefreshAction(IToolBarManager menuManager) {
		Action refresh = new Action() {
			@Override
			public void run() {
				refresh();
			}

		};
		refresh.setImageDescriptor(Activator.getImageDescriptor("/icons/refresh.png"));
		refresh.setToolTipText("Refresh");
		menuManager.add(refresh);
	}

	private void addGroupByModelElementButton(IToolBarManager menuManager) {
		boolean isGroupByME = Activator.getDefault().getDialogSettings().getBoolean("GroupByModelElement");
		groupByMe = new Action("", SWT.TOGGLE) {
			@Override
			public void run() {
				boolean showRootsCache = contentProvider.showRootNodes();
				Activator.getDefault().getDialogSettings().put("GroupByModelElement", isChecked());
				if (isChecked()) {
					contentProvider = new SCMContentProvider.Compact(viewer);
				} else {
					contentProvider = new SCMContentProvider.Detailed(viewer);
				}
				contentProvider.setShowRootNodes(showRootsCache);
				viewer.setContentProvider(contentProvider);
				viewer.refresh();
			}

		};

		groupByMe.setImageDescriptor(Activator.getImageDescriptor("/icons/groupByME.png"));
		groupByMe.setToolTipText("Group by model element");
		groupByMe.setChecked(isGroupByME);
		menuManager.add(groupByMe);
	}

	private void addShowRootAction(IToolBarManager menuManager) {
		showRoots = new Action("", SWT.TOGGLE) {
			@Override
			public void run() {
				if (isChecked()) {
					contentProvider.setShowRootNodes(true);
				} else {
					contentProvider.setShowRootNodes(false);
				}
				viewer.setContentProvider(contentProvider);
				viewer.refresh();
			}

		};

		ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
			composedAdapterFactory);

		showRoots.setImageDescriptor(ImageDescriptor.createFromImage(adapterFactoryLabelProvider
			.getImage(VersioningFactory.eINSTANCE.createChangePackage())));
		showRoots.setToolTipText("Show revision nodes");
		showRoots.setChecked(true);
		menuManager.add(showRoots);
		adapterFactoryLabelProvider.dispose();
		composedAdapterFactory.dispose();

	}

	private void addNextAndPreviousAction(IToolBarManager menuManager) {
		Action prev = new Action() {
			@Override
			public void run() {
				int temp = currentEnd + startOffset;
				if (temp <= headVersion) {
					currentEnd = temp;
				}
				refresh();
			}

		};
		prev.setImageDescriptor(Activator.getImageDescriptor("/icons/prev.png"));
		prev.setToolTipText("Previous " + (startOffset + 1) + " items");
		menuManager.add(prev);

		Action next = new Action() {
			@Override
			public void run() {
				int temp = currentEnd - startOffset;
				if (temp > 0) {
					currentEnd = temp;
				}
				refresh();
			}

		};
		next.setImageDescriptor(Activator.getImageDescriptor("/icons/next.png"));
		next.setToolTipText("Next " + (startOffset + 1) + " items");
		menuManager.add(next);
	}

	private void addJumpToRevisionAction(IToolBarManager menuManager) {
		Action jumpTo = new Action() {
			@Override
			public void run() {
				InputDialog inputDialog = new InputDialog(getSite().getShell(), "Go to revision", "Revision", "", null);
				if (inputDialog.open() == Window.OK) {
					try {
						int temp = Integer.parseInt(inputDialog.getValue());
						currentEnd = temp;
						refresh();
					} catch (NumberFormatException e) {
						MessageDialog.openError(getSite().getShell(), "Error", "A numeric value was expected!");
						run();
					}
				}
			}

		};
		jumpTo.setImageDescriptor(Activator.getImageDescriptor("/icons/magnifier.png"));
		jumpTo.setToolTipText("Go to revision...");
		menuManager.add(jumpTo);
	}

	private void addLinkWithNavigatorAction(IToolBarManager menuManager) {
		isUnlinkedFromNavigator = Activator.getDefault().getDialogSettings().getBoolean("LinkWithNavigator");
		Action linkWithNavigator = new Action("Link with navigator", SWT.TOGGLE) {

			@Override
			public void run() {
				Activator.getDefault().getDialogSettings().put("LinkWithNavigator", !this.isChecked());
				isUnlinkedFromNavigator = (!this.isChecked());
			}

		};
		linkWithNavigator.setImageDescriptor(Activator.getImageDescriptor("icons/link_with_editor.gif"));
		linkWithNavigator.setToolTipText("Link with Navigator");
		linkWithNavigator.setChecked(!isUnlinkedFromNavigator);
		menuManager.add(linkWithNavigator);
	}

	/**
	 * Refreshes the view using the current end point.
	 */
	public void refresh() {
		load(currentEnd);
		viewer.setContentProvider(contentProvider);
		viewer.setInput(getHistoryInfos());
	}

	private void load(final int end) {
		ServerRequestCommandHandler handler = new ServerRequestCommandHandler() {

			@Override
			protected Object run() throws EmfStoreException {
				try {
					loadContent(end);
				} catch (InvalidVersionSpecException e) {
					MessageDialog.openError(getShell(), "Invalid revision", "The requested revision was invalid");
					currentEnd = projectSpace.getBaseVersion().getIdentifier();
					refresh();
				}
				return null;
			}

			@Override
			public String getTaskTitle() {
				return "Resolving project versions...";
			}
		};
		try {
			handler.execute(new ExecutionEvent());
		} catch (ExecutionException e) {
			DialogHandler.showErrorDialog(e.getMessage());
		}
	}

	private void loadContent(int end) throws EmfStoreException {
		if (projectSpace == null) {
			historyInfos.clear();
			return;
		}
		HistoryQuery query = getQuery(end);
		List<HistoryInfo> historyInfo = projectSpace.getUsersession()
			.getHistoryInfo(projectSpace.getProjectId(), query);

		// Event logging
		ShowHistoryEvent historyEvent = EventsFactory.eINSTANCE.createShowHistoryEvent();
		historyEvent.setSourceVersion(query.getSource());
		historyEvent.setTargetVersion(query.getTarget());
		historyEvent.setTimestamp(new Date());
		EList<ModelElementId> modelElements = query.getModelElements();
		if (modelElements != null) {
			for (ModelElementId modelElementId : modelElements) {
				historyEvent.getModelElement().add(ModelUtil.clone(modelElementId));
			}
		}
		projectSpace.addEvent(historyEvent);

		if (historyInfo != null) {
			for (HistoryInfo hi : historyInfo) {
				if (hi.getPrimerySpec().equals(projectSpace.getBaseVersion())) {
					TagVersionSpec spec = VersioningFactory.eINSTANCE.createTagVersionSpec();
					spec.setName(VersionSpec.BASE);
					hi.getTagSpecs().add(spec);
					break;
				}
			}
			historyInfos.clear();
			historyInfos.addAll(historyInfo);
		}
		ChangePackage changePackage = VersioningFactory.eINSTANCE.createChangePackage();
		changePackage.getOperations().addAll(ModelUtil.clone(projectSpace.getOperations()));
		changePackageCache.put(-1, changePackage);
		for (HistoryInfo hi : historyInfos) {
			if (hi.getChangePackage() != null) {
				changePackageCache.put(hi.getPrimerySpec().getIdentifier(), hi.getChangePackage());
			}
		}
		changePackageVisualizationHelper = new ChangePackageVisualizationHelper(new ArrayList<ChangePackage>(
			changePackageCache.values()), projectSpace.getProject());
		labelProvider.setChangePackageVisualizationHelper(changePackageVisualizationHelper);
		logLabelProvider.setChangePackageVisualizationHelper(changePackageVisualizationHelper);
		contentProvider.setChangePackageVisualizationHelper(changePackageVisualizationHelper);
		contentProvider.setProjectSpace(projectSpace);
	}

	/**
	 * Set the input for the History Browser.
	 * 
	 * @param projectSpace the input project space
	 */
	public void setInput(ProjectSpace projectSpace) {
		setInput(projectSpace, null);
	}

	/**
	 * Set the input for the History Browser.
	 * 
	 * @param projectSpace the input project space
	 * @param me the input model element
	 */
	public void setInput(ProjectSpace projectSpace, EObject me) {
		noProjectHint.dispose();
		this.parent.layout();
		this.projectSpace = projectSpace;
		modelElement = me;
		currentEnd = -1;
		String label = "History for ";
		Project project = projectSpace.getProject();
		if (me != null) {
			label += UiUtil.getNameForModelElement(me);
			groupByMe.setChecked(false);
			showRoots.setChecked(false);
			contentProvider = new SCMContentProvider.Detailed(viewer);
			contentProvider.setShowRootNodes(false);
		} else {
			label += projectSpace.getProjectName();
			boolean isGroupedByME = Activator.getDefault().getDialogSettings().getBoolean("GroupByModelElement");
			groupByMe.setChecked(isGroupedByME);
			showRoots.setChecked(true);
			if (isGroupedByME) {
				contentProvider = new SCMContentProvider.Compact(viewer);
			} else {
				contentProvider = new SCMContentProvider.Detailed(viewer);
			}
			contentProvider.setShowRootNodes(true);
		}
		setContentDescription(label);
		labelProvider = new SCMLabelProvider(project);
		changesColumn.setLabelProvider(labelProvider);

		logLabelProvider = new LogMessageColumnLabelProvider(project);
		logColumn.setLabelProvider(logLabelProvider);

		refresh();
	}

	private void getHeadVersionIdentifier() throws EmfStoreException {
		PrimaryVersionSpec resolveVersionSpec = projectSpace.resolveVersionSpec(VersionSpec.HEAD_VERSION);
		int identifier = resolveVersionSpec.getIdentifier();
		headVersion = identifier;
	}

	private HistoryQuery getQuery(int end) throws EmfStoreException {
		HistoryQuery query = VersioningFactory.eINSTANCE.createHistoryQuery();

		getHeadVersionIdentifier();
		if (end == -1) {
			end = headVersion;
			currentEnd = -1;
		} else {
			currentEnd = end;
			PrimaryVersionSpec tempVersionSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
			tempVersionSpec.setIdentifier(end);
			end = projectSpace.resolveVersionSpec(tempVersionSpec).getIdentifier();
		}

		int temp = end - startOffset;
		int start = (temp > 0 ? temp : 0);

		PrimaryVersionSpec source = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		source.setIdentifier(start);
		PrimaryVersionSpec target = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		target.setIdentifier(end);
		query.setSource(source);
		query.setTarget(target);
		query.setIncludeChangePackage(true);
		if (modelElement != null && !(modelElement instanceof ProjectSpace)) {
			query.getModelElements().add(ModelUtil.getProject(modelElement).getModelElementId(modelElement));
		}

		return query;
	}

	/**
	 * Returns a list of history infos.
	 * 
	 * @return a list of history infos
	 */
	public List<HistoryInfo> getHistoryInfos() {

		ArrayList<HistoryInfo> revisions = new ArrayList<HistoryInfo>();
		if (projectSpace != null) {
			// TODO: add a feature "hide local revision"
			HistoryInfo localHistoryInfo = VersioningFactory.eINSTANCE.createHistoryInfo();
			ChangePackage changePackage = projectSpace.getLocalChangePackage(false);
			// filter for modelelement
			if (modelElement != null) {
				Set<AbstractOperation> operationsToRemove = new HashSet<AbstractOperation>();
				for (AbstractOperation ao : changePackage.getOperations()) {
					if (!ao.getAllInvolvedModelElements().contains(
						ModelUtil.getProject(modelElement).getModelElementId(modelElement))) {
						operationsToRemove.add(ao);
					}
				}
				changePackage.getOperations().removeAll(operationsToRemove);
			}
			localHistoryInfo.setChangePackage(changePackage);
			PrimaryVersionSpec versionSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
			versionSpec.setIdentifier(-1);
			localHistoryInfo.setPrimerySpec(versionSpec);
			revisions.add(localHistoryInfo);
		}
		revisions.addAll(historyInfos);

		return revisions;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
		WorkspaceUtil.logFocusEvent("org.unicase.ui.repository.views.HistoryView");
	}

	/**
	 * @return the changePackageVisualizationHelper
	 */
	public ChangePackageVisualizationHelper getChangePackageVisualizationHelper() {
		return changePackageVisualizationHelper;
	}

	/**
	 * Highlights the given operations.
	 * 
	 * @param operations the operations
	 */
	public void highlightOperations(List<OperationId> operations) {
		labelProvider.getHighlighted().clear();
		labelProvider.getHighlighted().addAll(operations);
		refresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.util.ProjectSpaceContainer#getProjectSpace()
	 */
	public ProjectSpace getProjectSpace() {
		if (isUnlinkedFromNavigator) {
			return null;
		}
		return this.projectSpace;
	}

}
