/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.iterationplanningview;

import java.io.IOException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.organization.User;
import org.unicase.ui.common.dnd.ComposedDropAdapter;
import org.unicase.ui.common.dnd.UCDragAdapter;
import org.unicase.ui.common.util.CannotMatchUserInProjectException;
import org.unicase.ui.common.util.EventUtil;
import org.unicase.ui.stem.Activator;
import org.unicase.ui.stem.views.AssignedToLabelProvider;
import org.unicase.ui.tableview.labelproviders.StatusLabelProvider;
import org.unicase.ui.unicasecommon.UnicaseActionHelper;
import org.unicase.ui.unicasecommon.common.TreeViewerColumnSorter;
import org.unicase.ui.unicasecommon.common.filter.UserFilter;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;
import org.unicase.workspace.util.NoCurrentUserException;

/**
 * This view helps managing WorkPackages (sprints) contained in a project. It shows the WorkPackages of active project
 * space (the project currently selected in navigator)
 * 
 * @author Hodaie
 */
public class IterationPlanningView extends ViewPart {
	/**
	 * Action to create a window with a ganttchart.
	 * 
	 * @author helming
	 */
	public class GantAction extends Action {

		/**
		 * Default constructor.
		 */
		public GantAction() {
			super("Show Gantt Chart", Activator.getImageDescriptor("icons/ganttChart.png"));
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void run() {
			Shell shell = new Shell(PlatformUI.getWorkbench().getDisplay());
			shell.setSize(900, 500);
			shell.setLayout(new FillLayout());
			new GantChart(shell);
			shell.open();
		}

	}

	private TreeViewer viewer;
	private WorkpackageContentProvider workpackageContentProvider;
	private Project project;
	private DialogSettings settings;
	private String filename;
	private Action filterToMyTeam;
	private ViewerFilter teamFilter;
	private UserFilter userFilter;
	private Action filterToMe;

	/**
	 * The constructor.
	 */
	public IterationPlanningView() {
		IPath path = Activator.getDefault().getStateLocation();
		filename = path.append("settings.txt").toOSString();
		settings = new DialogSettings("Top");
		try {
			settings.load(filename);
		} catch (IOException e) {
			// Do nothing.
		}
		final Workspace workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		workspace.eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if ((msg.getFeatureID(Workspace.class)) == WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE) {
					initFilters();
				}
			}
		});
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {

		// create a TreeViewer for WorkPackages.
		// Root nodes are WorkPackage and children are their WorkItems
		// The tree has columns showing annotated model element and
		// Assignee of a WorkItem
		createTreeViewer(parent);

		IActionBars bars = getViewSite().getActionBars();
		IToolBarManager menuManager = bars.getToolBarManager();

		initFilters();

		menuManager.add(filterToMe);
		menuManager.add(filterToMyTeam);
		menuManager.add(new GantAction());

		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "org.unicase.ui.treeview.viewer");

		hookDoubleClickAction();
		addDNDSupport();

		// respond to change of active ProjectSpace
		final Workspace workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		workspace.eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if ((msg.getFeatureID(Workspace.class)) == WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE) {
					if (workspace.getActiveProjectSpace() != null) {
						project = workspace.getActiveProjectSpace().getProject();
					} else {
						project = null;
					}
					setInput();
				}
				super.notifyChanged(msg);
			}
		});

		// set input when showing the view for the first time.
		if (workspace.getActiveProjectSpace() != null) {
			project = workspace.getActiveProjectSpace().getProject();
		} else {
			project = null;
		}
		setInput();

	}

	private void initFilters() {
		User user;
		try {
			user = OrgUnitHelper.getCurrentUser(WorkspaceManager.getInstance().getCurrentWorkspace());
			createTeamFilter(user);
			createUserFilter(user);
		} catch (NoCurrentUserException e) {
			createTeamFilter(null);
			createUserFilter(null);
		} catch (CannotMatchUserInProjectException e) {
			createTeamFilter(null);
			createUserFilter(null);
		}

	}

	private void createUserFilter(User user) {
		// Create User filter

		if (filterToMe == null) {
			filterToMe = new Action("", SWT.TOGGLE) {
				@Override
				public void run() {
					setUserFilter(isChecked());
				}

			};
			filterToMe.setImageDescriptor(Activator.getImageDescriptor("/icons/filtertouser.png"));
		}
		if (user == null) {
			setUserFilter(false);
			filterToMe.setEnabled(false);
			return;
		}
		filterToMe.setEnabled(true);
		Boolean isFilter = Boolean.parseBoolean(settings.get("UserFilter"));
		userFilter = new UserFilter(user);
		filterToMe.setChecked(isFilter);
		setUserFilter(isFilter);
	}

	private void createTeamFilter(User user) {
		// Create Team filter
		if (filterToMyTeam == null) {
			filterToMyTeam = new Action("", SWT.TOGGLE) {
				@Override
				public void run() {
					setTeamFilter(isChecked());
				}

			};
			filterToMyTeam.setImageDescriptor(Activator.getImageDescriptor("/icons/filtertomyteam.png"));
		}
		if (user == null) {
			setTeamFilter(false);
			filterToMyTeam.setEnabled(false);
			return;
		}
		filterToMyTeam.setEnabled(true);
		teamFilter = new IterationTeamFilter(user);
		Boolean isteamFilter = Boolean.parseBoolean(settings.get("TeamFilter"));
		filterToMyTeam.setChecked(isteamFilter);
		setTeamFilter(isteamFilter);
	}

	/**
	 * Sets if the user filter is turned on.
	 * 
	 * @param checked if the filter is turned on.
	 */
	protected void setUserFilter(boolean checked) {
		if (checked) {
			viewer.addFilter(userFilter);
		} else {
			if (userFilter != null) {
				viewer.removeFilter(userFilter);
			}
		}

	}

	/**
	 * Sets the team filter.
	 * 
	 * @param checked if the team filter is turned on.
	 */
	protected void setTeamFilter(boolean checked) {
		if (checked) {
			viewer.addFilter(teamFilter);
		} else {
			if (teamFilter != null) {
				viewer.removeFilter(teamFilter);
			}
		}

	}

	private void createTreeViewer(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		workpackageContentProvider = new WorkpackageContentProvider();
		viewer.setContentProvider(workpackageContentProvider);
		IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
		viewer.setLabelProvider(new DecoratingLabelProvider(new LabelProvider(), decoratorManager.getLabelDecorator()));

		createColumns(viewer);

	}

	private void createColumns(TreeViewer viewer2) {
		Tree tree = viewer.getTree();
		tree.setHeaderVisible(true);

		// root nodes (WorkPackage) and their contained WorkItems
		TreeViewerColumn tclmWorkItem = new TreeViewerColumn(viewer, SWT.NONE);
		tclmWorkItem.getColumn().setText("WorkItem");
		tclmWorkItem.getColumn().setWidth(400);
		WorkPackageColumnLabelProvider emfColumnLabelProvider = new WorkPackageColumnLabelProvider();
		tclmWorkItem.setLabelProvider(emfColumnLabelProvider);
		new TreeViewerColumnSorter(viewer, tclmWorkItem, emfColumnLabelProvider);

		TreeViewerColumn status = new TreeViewerColumn(viewer, SWT.NONE);
		status.getColumn().setWidth(20);
		status.setLabelProvider(new StatusLabelProvider());
		// status.setEditingSupport(new StatusEditingSupport(viewer));
		// new TreeViewerColumnSorter(viewer, tclmWorkItem,
		// emfColumnLabelProvider);

		// annotated model element
		TreeViewerColumn tclmAnnotatedME = new TreeViewerColumn(viewer, SWT.NONE);
		tclmAnnotatedME.getColumn().setText("Annotated");
		tclmAnnotatedME.getColumn().setWidth(100);
		TaskObjectLabelProvider taskObjectLabelProvider = new TaskObjectLabelProvider();
		tclmAnnotatedME.setLabelProvider(taskObjectLabelProvider);
		tclmAnnotatedME.setEditingSupport(new TaskObjectEditingSupport(viewer));
		new TreeViewerColumnSorter(viewer, tclmAnnotatedME, taskObjectLabelProvider);

		// Assignee
		TreeViewerColumn tclmAssignedTo = new TreeViewerColumn(viewer, SWT.NONE);
		tclmAssignedTo.getColumn().setText("Assigned to");
		tclmAssignedTo.getColumn().setWidth(100);
		AssignedToLabelProvider assignedToLabelProvider = new AssignedToLabelProvider();
		tclmAssignedTo.setLabelProvider(assignedToLabelProvider);
		tclmAssignedTo.setEditingSupport(new AssignedToEditingSupport(viewer));
		new TreeViewerColumnSorter(viewer, tclmAssignedTo, assignedToLabelProvider);
		// Status of model elements

	}

	/**
	 * . This sets the input of viewer on change of active ProjectSpace. The project is a field being set when
	 * activeProjectSpace is changed
	 */
	protected void setInput() {
		viewer.setInput(project);
		// //I thought this might help making tree columns look better.
		// //Currently the width of tree columns are hard coded.
		// for (TreeColumn column : viewer.getTree().getColumns()) {
		// column.pack();
		// }
	}

	/**
	 * open WorkItem on double-click.
	 */
	private void hookDoubleClickAction() {
		final String viewId = getClass().getName();
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				TreeSelection selection = (TreeSelection) viewer.getSelection();
				Object object = selection.getFirstElement();
				if (object instanceof UnicaseModelElement) {
					UnicaseActionHelper.openModelElement((UnicaseModelElement) object, viewId);
				}
			}

		});
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {
		viewer.getTree().setFocus();
		EventUtil.logFocusEvent("org.unicase.ui.treeview.views.IterationPlanningView");
	}

	private void addDNDSupport() {
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
	public void dispose() {

		settings.put("TeamFilter", filterToMyTeam.isChecked());
		try {
			settings.save(filename);
		} catch (IOException e) {
			// JH Auto-generated catch block
			e.printStackTrace();
		}
		workpackageContentProvider.dispose();
		super.dispose();
	}

}