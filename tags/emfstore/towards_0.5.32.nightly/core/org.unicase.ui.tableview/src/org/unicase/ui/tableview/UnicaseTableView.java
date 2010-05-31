/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tableview;

import java.util.List;
import java.util.regex.PatternSyntaxException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.part.ViewPart;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ProjectChangeObserver;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.tableview.viewer.METableViewer;
import org.unicase.ui.taskview.TaskView;
import org.unicase.ui.unicasecommon.common.util.UnicaseUiUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;

/**
 * A specialized UnicaseTableView to display all Attributes of model element.
 * 
 * @author Abdelhamid Barzali, Hodaie
 */
public class UnicaseTableView extends ViewPart implements ProjectChangeObserver {

	/**
	 * Filter model elements by name in table viewer.
	 * 
	 * @author hodaie
	 */
	public class ModelElementNameFilter extends ViewerFilter {

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object,
		 *      java.lang.Object)
		 */
		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			// true = show; false = do not show
			if (!(element instanceof UnicaseModelElement)) {
				return false;
			}
			UnicaseModelElement me = (UnicaseModelElement) element;

			if (me.getName() != null && match(me.getName(), txtFilter.getText())) {
				return true;
			}
			return false;
		}

		private boolean match(String name, String filter) {
			filter = filter.replace("*", ".*").toLowerCase().trim().concat(".*");
			boolean result = false;
			try {
				result = name.toLowerCase().matches(filter);
			} catch (PatternSyntaxException e) {
				// do nothing
			}
			return result;
		}

	}

	private METableViewer viewer;

	private Project activeProject;
	private Workspace workspace;
	private AdapterImpl workspaceListenerAdapter;

	private Text txtFilter;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout());
		createFilterText(parent);

		viewer = new METableViewer(parent, MetamodelPackage.eINSTANCE.getModelElement());
		viewer.getTableViewer().getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		viewer.createColumns(MetamodelPackage.eINSTANCE.getModelElement(), null, false);

		workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		workspaceListenerAdapter = new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				if ((msg.getFeatureID(Workspace.class)) == WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE) {
					ProjectSpace activeProjectSpace = workspace.getActiveProjectSpace();
					if (activeProjectSpace != null) {
						activeProject = activeProjectSpace.getProject();
						activeProject.addProjectChangeObserver(UnicaseTableView.this);

						viewer.setInput(activeProject);
					} else {
						activeProject = null;
						viewer.setInput(activeProject);
					}

				}
				super.notifyChanged(msg);
			}
		};
		workspace.eAdapters().add(workspaceListenerAdapter);

		createActions();

		getSite().setSelectionProvider(viewer.getTableViewer());

		hookDoubleClickAction();

		if (workspace.getActiveProjectSpace() != null) {
			activeProject = workspace.getActiveProjectSpace().getProject();
			activeProject.addProjectChangeObserver(UnicaseTableView.this);
		}
		viewer.setInput(activeProject);
		viewer.addFilter(new ModelElementNameFilter());
	}

	private void createFilterText(Composite parent) {
		txtFilter = new Text(parent, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtFilter.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		txtFilter.setText("");

		Listener listener = new Listener() {

			public void handleEvent(Event event) {
				viewer.refresh();
			}

		};
		txtFilter.addListener(SWT.Modify, listener);

		txtFilter.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.ARROW_DOWN) {
					viewer.getTableViewer().getTable().setFocus();
				}
			}

			public void keyReleased(KeyEvent e) {
			}

		});

	}

	private void hookDoubleClickAction() {
		final Action doubleClickAction = new Action() {
			@Override
			public void run() {
				ActionHelper.openModelElement(ActionHelper.getSelectedModelElement(), TaskView.class.getName());
			}
		};
		viewer.setDoubleClickAction(doubleClickAction);
	}

	private void createActions() {
		IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();

		// filter to model element type action
		Action filterToMETypeAction = new Action() {
			@Override
			public void run() {
				EClass meType = UnicaseUiUtil.showMETypeSelectionDialog(getSite().getShell(), true, false);
				if (meType != null) {
					viewer.setInput(activeProject, meType);
				}
			}

		};
		filterToMETypeAction.setToolTipText("Filter to a specific model element type");
		filterToMETypeAction.setImageDescriptor(Activator.getImageDescriptor("/icons/filter.png"));
		toolbarManager.add(filterToMETypeAction);

		// addition separator
		toolbarManager.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		Separator separator2 = new Separator("separator2");
		toolbarManager.insertAfter(IWorkbenchActionConstants.MB_ADDITIONS, separator2);

		// show/hide columns action
		Action showHideColumnsAction = new Action() {
			@Override
			public void run() {
				List<String> columnsToShow = viewer.displayShowHideColumnsDialog();
				viewer.showColumns(columnsToShow);
			}

		};
		showHideColumnsAction.setToolTipText("Show/Hide columns");
		showHideColumnsAction.setImageDescriptor(Activator.getImageDescriptor("/icons/table.png"));
		toolbarManager.add(showHideColumnsAction);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		viewer.getTableViewer().getTable().setFocus();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		workspace.eAdapters().remove(workspaceListenerAdapter);
		if (activeProject != null) {
			workspace.getActiveProjectSpace().getProject().removeProjectChangeObserver(this);
		}

		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#modelElementAdded(org.unicase.metamodel.Project,
	 *      org.unicase.model.UnicaseModelElement)
	 */
	public void modelElementAdded(Project project, ModelElement modelElement) {
		viewer.refresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#modelElementDeleteCompleted(org.unicase.model.UnicaseModelElement)
	 */
	public void modelElementRemoved(Project project, ModelElement modelElement) {
		viewer.refresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification,
	 *      org.unicase.metamodel.Project, org.unicase.model.UnicaseModelElement)
	 */
	public void notify(Notification notification, Project project, ModelElement modelElement) {
		viewer.getTableViewer().update(modelElement, null);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#projectDeleted(org.unicase.metamodel.Project)
	 */
	public void projectDeleted(Project project) {
		// TODO Auto-generated method stub

	}

}
