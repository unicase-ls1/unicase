/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tableview;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.util.ProjectChangeObserver;
import org.unicase.ui.common.dialogs.METypeTreeSelectionDialog;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.common.util.UnicaseUiUtil;
import org.unicase.ui.tableview.viewer.METableViewer;
import org.unicase.ui.taskview.TaskView;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;

/**
 * A specialized UnicaseTableView to display all Attributes of model element.
 * 
 * @author Abdelhamid Barzali.
 */
public class UnicaseTableView extends ViewPart implements ProjectChangeObserver {

	private METableViewer viewer;

	private Project activeProject;
	private Workspace workspace;
	private AdapterImpl workspaceListenerAdapter;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		viewer = new METableViewer(parent, ModelPackage.eINSTANCE.getModelElement());
		viewer.createColumns(ModelPackage.eINSTANCE.getModelElement(), null, false);

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
		}
		viewer.setInput(activeProject);
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
				EClass meType = UnicaseUiUtil.showMETypeSelectionDialog(getSite().getShell(), true);
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
	 * Helper method to show METypeSelectionDialog.
	 * 
	 * @return a list of eclasses
	 */
	protected EClass[] showMETypeSelectionDialog() {
		EClass[] result = null;

		METypeTreeSelectionDialog dialog = new METypeTreeSelectionDialog(getSite().getShell(), false);
		dialog.open();
		result = dialog.getResult();
		return result;
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
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementAdded(org.unicase.model.Project,
	 *      org.unicase.model.ModelElement)
	 */
	public void modelElementAdded(Project project, ModelElement modelElement) {
		viewer.refresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementDeleteCompleted(org.unicase.model.ModelElement)
	 */
	public void modelElementDeleteCompleted(ModelElement modelElement) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementDeleteStarted(org.unicase.model.ModelElement)
	 */
	public void modelElementDeleteStarted(ModelElement modelElement) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementRemoved(org.unicase.model.Project,
	 *      org.unicase.model.ModelElement)
	 */
	public void modelElementRemoved(Project project, ModelElement modelElement) {
		viewer.refresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification,
	 *      org.unicase.model.Project, org.unicase.model.ModelElement)
	 */
	public void notify(Notification notification, Project project, ModelElement modelElement) {
		viewer.getTableViewer().update(modelElement, null);
	}

}
