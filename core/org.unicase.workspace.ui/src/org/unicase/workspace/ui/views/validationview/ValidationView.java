/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.validationview;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.ViewPart;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.organization.User;
import org.unicase.ui.common.TableViewerColumnSorter;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.common.util.CannotMatchUserInProjectException;
import org.unicase.ui.common.util.EventUtil;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;
import org.unicase.workspace.util.NoCurrentUserException;

/**
 * Validation view.
 * 
 * @author wesendonk
 */
public class ValidationView extends ViewPart {

	private TableViewer tableViewer;
	private Action filterToMyTeam;
	private ValidationTeamFilter teamFilter;
	private ValidationUserFilter userFilter;
	private Action filterToMe;
	private DialogSettings settings;
	private String filename;
	private final String viewId = getClass().getName();
	private Workspace workspace;
	private AdapterImpl workspaceListenerAdapter;

	/**
	 * Default constructor.
	 */
	public ValidationView() {
		IPath path = org.unicase.ui.common.Activator.getDefault().getStateLocation();
		filename = path.append("settings.txt").toOSString();
		settings = new DialogSettings("Top");
		try {
			settings.load(filename);
		} catch (IOException e) {
			// Do nothing.
		}

		workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		workspaceListenerAdapter = new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				if ((msg.getFeatureID(Workspace.class)) == WorkspacePackage.WORKSPACE__PROJECT_SPACES) {
					if (msg.getOldValue() != null
						&& (msg.getOldValue() instanceof List<?> || msg.getOldValue() instanceof ProjectSpace)) {
						tableViewer.setInput(new ArrayList<IConstraintStatus>());
					}

				}
				super.notifyChanged(msg);
			}
		};
		workspace.eAdapters().add(workspaceListenerAdapter);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {
		tableViewer = new TableViewer(parent, SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL
			| SWT.FULL_SELECTION);
		createTable();
		initFilters();

		IActionBars bars = getViewSite().getActionBars();
		IToolBarManager menuManager = bars.getToolBarManager();
		menuManager.add(filterToMe);
		menuManager.add(filterToMyTeam);
		hookDoubleClickAction();
	}

	private void createTable() {
		Table table = tableViewer.getTable();
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalSpan = 5;
		table.setLayoutData(gridData);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		TableViewerColumn column = new TableViewerColumn(tableViewer, SWT.CENTER, 0);
		column.getColumn().setText("Severity");
		column.getColumn().setWidth(50);
		ColumnLabelProvider labelProvider = new SeverityLabelProvider();
		column.setLabelProvider(labelProvider);
		ViewerComparator comp = new TableViewerColumnSorter(tableViewer, column, labelProvider);
		column.getViewer().setComparator(comp);

		column = new TableViewerColumn(tableViewer, SWT.LEFT, 1);
		column.getColumn().setText("Constraint");
		column.getColumn().setWidth(200);
		labelProvider = new ConstraintLabelProvider();
		column.setLabelProvider(labelProvider);
		comp = new TableViewerColumnSorter(tableViewer, column, labelProvider);
		column.getViewer().setComparator(comp);

		column = new TableViewerColumn(tableViewer, SWT.LEFT, 2);
		column.getColumn().setText("Description");
		column.getColumn().setWidth(400);
		labelProvider = new DescriptionLabelProvider();
		column.setLabelProvider(labelProvider);
		comp = new TableViewerColumnSorter(tableViewer, column, labelProvider);
		column.getViewer().setComparator(comp);

		column = new TableViewerColumn(tableViewer, SWT.LEFT, 3);
		column.getColumn().setText("Affected ModelElement");
		column.getColumn().setWidth(200);
		labelProvider = new ValidationLableProvider();
		column.setLabelProvider(labelProvider);
		comp = new TableViewerColumnSorter(tableViewer, column, labelProvider);
		column.getViewer().setComparator(comp);

		column = new TableViewerColumn(tableViewer, SWT.LEFT, 4);
		column.getColumn().setText("Creator");
		column.getColumn().setWidth(100);
		labelProvider = new CreatorLabelProvider();
		column.setLabelProvider(labelProvider);
		comp = new TableViewerColumnSorter(tableViewer, column, labelProvider);
		column.getViewer().setComparator(comp);

		// content provider
		tableViewer.setContentProvider(new ValidationContentProvider());
		initFilters();

	}

	private void hookDoubleClickAction() {
		tableViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				IConstraintStatus constraintStatus = (IConstraintStatus) selection.getFirstElement();

				EObject me = constraintStatus.getTarget();
				Iterator<EObject> iterator = constraintStatus.getResultLocus().iterator();
				if (me instanceof ModelElement) {
					EStructuralFeature errorLocation = null;
					errorLocation = getErrorLocation(iterator, errorLocation);
					if (errorLocation != null) {
						ActionHelper.openModelElement((ModelElement) me, errorLocation, viewId);
					} else {
						ActionHelper.openModelElement((ModelElement) me, viewId);
					}
				}
			}
		});
	}

	private EStructuralFeature getErrorLocation(Iterator<EObject> iterator, EStructuralFeature errorLocation) {
		while (iterator.hasNext()) {
			EObject next = iterator.next();
			if (next instanceof EStructuralFeature) {
				errorLocation = (EStructuralFeature) next;
				break;
			}
		}
		return errorLocation;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
		EventUtil.logFocusEvent(viewId);
	}

	/**
	 * Updates the validation view table.
	 * 
	 * @param validationResults validation results.
	 */
	public void updateTable(List<IConstraintStatus> validationResults) {
		tableViewer.setInput(validationResults);

		// this is added to fix the bug regarding context menu not being shown
		// correctly in navigator, after validation viewer was shown.
		tableViewer.getTable().setFocus();
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
			filterToMe
				.setImageDescriptor(org.unicase.ui.common.Activator.getImageDescriptor("/icons/filtertouser.png"));
		}
		if (user == null) {
			setUserFilter(false);
			filterToMe.setEnabled(false);
			return;
		}
		filterToMe.setEnabled(true);
		Boolean isFilter = Boolean.parseBoolean(settings.get("UserFilter"));
		userFilter = new ValidationUserFilter(user);
		filterToMe.setChecked(isFilter);
		setUserFilter(isFilter);
	}

	/**
	 * Sets if the user filter is turned on.
	 * 
	 * @param checked if the filter is turned on.
	 */
	protected void setUserFilter(boolean checked) {
		if (checked) {
			EventUtil.logPresentationSwitchEvent(viewId, "UserFilter");
			tableViewer.addFilter(userFilter);
		} else {
			if (userFilter != null) {
				EventUtil.logPresentationSwitchEvent(viewId, "NoUserFilter");
				tableViewer.removeFilter(userFilter);
			}
		}

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
			filterToMyTeam.setImageDescriptor(org.unicase.ui.common.Activator
				.getImageDescriptor("/icons/filtertomyteam.png"));
		}
		if (user == null) {
			setTeamFilter(false);
			filterToMyTeam.setEnabled(false);
			return;
		}
		filterToMyTeam.setEnabled(true);
		teamFilter = new ValidationTeamFilter(user);
		Boolean isteamFilter = Boolean.parseBoolean(settings.get("TeamFilter"));
		filterToMyTeam.setChecked(isteamFilter);
		setTeamFilter(isteamFilter);
	}

	/**
	 * Sets the team filter.
	 * 
	 * @param checked if the team filter is turned on.
	 */
	protected void setTeamFilter(boolean checked) {
		if (checked) {
			EventUtil.logPresentationSwitchEvent(viewId, "TeamFilter");
			tableViewer.addFilter(teamFilter);
		} else {
			if (teamFilter != null) {
				EventUtil.logPresentationSwitchEvent(viewId, "NoTeamFilter");
				tableViewer.removeFilter(teamFilter);
			}
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		workspace.eAdapters().remove(workspaceListenerAdapter);
		super.dispose();
	}
}
