/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.taskview;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.TaskPackage;
import org.unicase.ui.common.commands.ActionHelper;
import org.unicase.ui.tableview.Activator;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;

/**
 * A specialized TableView to display Action Items.
 * 
 * @author Florian Schneider
 * 
 */
public class TaskView extends ViewPart implements ICheckStateListener {

	private METableViewer viewer;
	private final EClass itemMetaClass = TaskPackage.eINSTANCE.getWorkItem();
	private FilteredItemProviderAdapterFactory adapterFactory;

	private boolean restrictedToCurrentUser;
	private Action doubleClickAction;

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
		// viewer.addCheckStateListener(this);
		getSite().setSelectionProvider(viewer);
		hookDoubleClickAction();
		getViewSite().getActionBars().getToolBarManager().add(
				new RestrictTableContentToCurrentUserAction(this));
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
	 * Restricts the items in the task view to those owned by the current user.
	 * 
	 * @author Florian Schneider
	 */
	private class RestrictTableContentToCurrentUserAction extends
			org.eclipse.jface.action.Action {
		private TaskView part;

		public RestrictTableContentToCurrentUserAction(TaskView part) {
			super();
			this.part = part;
			this.setText("Restrict to current user");
			this
					.setToolTipText("Restricts the displayed table items to items owned by the current user.");
			this.setImageDescriptor(Activator
					.getImageDescriptor("icons/User.gif"));
			this.setChecked(part.isRestrictedToCurrentUser());
		}

		@Override
		public void run() {
			super.run();
			part.setRestrictedToCurrentUser(isChecked());
		}
	}

	/**
	 * Triggers a viewer update according to the current user session. As a
	 * result, only action items that are assigned to the user that corresponds
	 * to the current user session are displayed.
	 * 
	 * @param restricted
	 *            determines if this view shall be restricted to a specific user
	 *            instance or not
	 */
	public void setRestrictedToCurrentUser(boolean restricted) {
		this.restrictedToCurrentUser = restricted;

		if (restrictedToCurrentUser) {
			Workspace workspace = WorkspaceManager.getInstance()
					.getCurrentWorkspace();
			Usersession currentUserSession = workspace.getActiveProjectSpace()
					.getUsersession();

			EList<User> projectUsers = workspace.getActiveProjectSpace()
					.getProject().getAllModelElementsbyClass(
							OrganizationPackage.eINSTANCE.getUser(),
							new BasicEList<User>());
			// FS tell the user if the project has no users
			for (User currentUser : projectUsers) {
				// FS how can I get the appropriate user from the current user
				// session?
				if (currentUser.getName().equals(
						currentUserSession.getUsername())) {
					adapterFactory
							.setFilteredItemProvider(new UserAndEClassFilterItemProvider(
									adapterFactory, itemMetaClass, currentUser));
					viewer.setAdapterFactory(adapterFactory);
					// first come first serve
					break;
				}
			}
		} else {
			adapterFactory
					.setFilteredItemProvider(new EClassFilterItemProvider(
							adapterFactory, itemMetaClass));
			viewer.setAdapterFactory(adapterFactory);
		}
	}

	/**
	 * 
	 * @return if the view is currently restricted to the current user session
	 *         or not
	 */
	public boolean isRestrictedToCurrentUser() {
		return restrictedToCurrentUser;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ICheckStateListener#checkStateChanged(org.eclipse.jface.viewers.CheckStateChangedEvent)
	 */
	public void checkStateChanged(CheckStateChangedEvent event) {
		Object source = event.getElement();
		if (source instanceof Checkable) {
			((Checkable) source).setChecked(event.getChecked());
		}
	}
}
