/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.taskview;

import java.io.IOException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.organization.User;
import org.unicase.model.task.TaskPackage;
import org.unicase.ui.common.commands.ActionHelper;
import org.unicase.ui.common.filter.TeamFilter;
import org.unicase.ui.common.filter.UserFilter;
import org.unicase.ui.tableview.Activator;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.OrgUnitHelper;

/**
 * A specialized TableView to display Action Items.
 * 
 * @author Florian Schneider
 * 
 */
public class TaskView extends ViewPart {

	private METableViewer viewer;
	private final EClass itemMetaClass = TaskPackage.eINSTANCE.getWorkItem();
	private FilteredItemProviderAdapterFactory adapterFactory;

	private Action doubleClickAction;
	private UncheckedElementsViewerFilter uncheckedFilter;
	private UserFilter userFilter;
	private Action filterToMe;
	private DialogSettings settings;
	private Action filterToUnchecked;
	private TeamFilter teamFilter;
	private Action filterToMyTeam;
	private String filename;

	/**
	 * default constructor.
	 */

	public TaskView() {
		super();
		IPath path = Activator.getDefault().getStateLocation();
		filename = path.append("settings.txt").toOSString();
		settings = new DialogSettings("Top");
		try {
			settings.load(filename);
		} catch (IOException e) {
			// Do nothing.
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		adapterFactory = new FilteredItemProviderAdapterFactory();
		adapterFactory.setFilteredItemProvider(new EClassFilterItemProvider(
				adapterFactory, itemMetaClass));
		viewer = new METableViewer(parent, adapterFactory, itemMetaClass);
		// the task view shall only display objects that are instance of
		// Checkable
		viewer.addFilter(new CheckableViewerFilter());

		IActionBars bars = getViewSite().getActionBars();
		IToolBarManager menuManager = bars.getToolBarManager();
		User user = OrgUnitHelper.getCurrentUser(WorkspaceManager.getInstance()
				.getCurrentWorkspace());

		// Create User filter

		createUserFilter(user);
		menuManager.add(filterToMe);

		// Create Team Filter

		createTeamFilter(user);
		menuManager.add(filterToMyTeam);

		// Create Checked filter

		createCheckedFilter();
		menuManager.add(filterToUnchecked);

		getSite().setSelectionProvider(viewer);
		hookDoubleClickAction();
	}

	private void createTeamFilter(User user) {
		teamFilter = new TeamFilter(user);
		filterToMyTeam = new Action("", SWT.TOGGLE) {
			@Override
			public void run() {
				setTeamFilter(isChecked());
			}

		};
		filterToMyTeam.setImageDescriptor(Activator
				.getImageDescriptor("/icons/filtertomyteam.png"));
		Boolean teamFilter = Boolean.parseBoolean(settings.get("TeamFilter"));
		filterToMyTeam.setChecked(teamFilter);
		setTeamFilter(teamFilter);
	}

	/**
	 * Sets the teamfilter.
	 * 
	 * @param checked
	 *            if filtered
	 */
	protected void setTeamFilter(boolean checked) {
		if (checked) {
			viewer.addFilter(teamFilter);
		} else {
			viewer.removeFilter(teamFilter);
		}

	}

	private void createCheckedFilter() {
		uncheckedFilter = new UncheckedElementsViewerFilter();
		filterToUnchecked = new Action("", SWT.TOGGLE) {
			@Override
			public void run() {
				setUncheckedFilter(isChecked());
			}

		};
		filterToUnchecked.setImageDescriptor(Activator
				.getImageDescriptor("/icons/tick.png"));
		Boolean uncheckedFilter = Boolean.parseBoolean(settings
				.get("UncheckedFilter"));
		filterToUnchecked.setChecked(uncheckedFilter);
		filterToUnchecked
				.setToolTipText("Besides the unchecked elements, the checked ones will be shown as well.");
		setUserFilter(uncheckedFilter);
	}

	private void createUserFilter(User user) {
		userFilter = new UserFilter(user);
		filterToMe = new Action("", SWT.TOGGLE) {
			@Override
			public void run() {
				setUserFilter(isChecked());
			}

		};
		filterToMe.setImageDescriptor(Activator
				.getImageDescriptor("/icons/filtertouser.png"));
		Boolean userFilter = Boolean.parseBoolean(settings.get("UserFilter"));
		filterToMe.setChecked(userFilter);
		filterToMe
				.setToolTipText("Restricts the displayed table items to items owned by the current user.");
		setUserFilter(userFilter);
	}

	/**
	 * sets the uncheckd filter.
	 * 
	 * @param checked
	 *            if filtered
	 */
	protected void setUncheckedFilter(boolean checked) {
		if (checked) {
			viewer.removeFilter(uncheckedFilter);
		} else {
			viewer.addFilter(uncheckedFilter);
		}

	}

	/**
	 * sets the userfilter.
	 * 
	 * @param checked
	 *            if fileterd.
	 */
	protected void setUserFilter(boolean checked) {
		if (checked) {
			viewer.addFilter(userFilter);
		} else {
			viewer.removeFilter(userFilter);
		}

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
			@Override
			public void run() {
				ActionHelper.openModelElement(ActionHelper
						.getSelectedModelElement());
			}
		};
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		viewer.refresh();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {

		settings.put("TeamFilter", filterToMyTeam.isChecked());
		settings.put("UncheckedFilter", filterToUnchecked.isChecked());
		settings.put("UserFilter", filterToMe.isChecked());
		try {
			settings.save(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		super.dispose();
	}

}
