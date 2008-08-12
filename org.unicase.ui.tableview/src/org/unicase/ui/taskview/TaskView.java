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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.task.TaskPackage;
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
public class TaskView extends ViewPart {

	private METableViewer viewer;
	private final EClass itemMetaClass = TaskPackage.eINSTANCE.getActionItem();
	private boolean restrictedToCurrentUser = false;
	private FilteredItemProviderAdapterFactory adapterFactory;

	@Override
	public void createPartControl(Composite parent) {
		adapterFactory = new FilteredItemProviderAdapterFactory();
		adapterFactory.setFilteredItemProvider(new EClassFilterItemProvider(
				adapterFactory, itemMetaClass));
		viewer = new METableViewer(parent, adapterFactory, itemMetaClass);

		getViewSite().getActionBars().getToolBarManager().add(
				new RestrictTableContentToCurrentUserAction(this));
	}

	@Override
	public void setFocus() {

	}

	/**
	 * Restricts the items in the task view to those owned by the current user.
	 * 
	 * @author schneidf
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
			// FS how can I get the appropriate user from the current user
			// session?
			super.run();

			part.setRestrictedToCurrentUser(isChecked());
			System.out.println(isChecked() ? "checked" : "unchecked");

			if (isChecked()) {
				Workspace workspace = WorkspaceManager.getInstance()
						.getCurrentWorkspace();
				Usersession currentUserSession = workspace
						.getActiveProjectSpace().getUsersession();

				EList<User> projectUsers = workspace.getActiveProjectSpace()
						.getProject().getAllModelElementsbyClass(
								OrganizationPackage.eINSTANCE.getUser(),
								new BasicEList<User>());
				// FS tell the user if the project has no users
				for (User currentUser : projectUsers) {
					if (currentUser.getName().equals(
							currentUserSession.getUsername())) {
						adapterFactory
								.setFilteredItemProvider(new UserAndEClassFilterItemProvider(
										adapterFactory, itemMetaClass,
										currentUser));
						viewer.setAdapterFactory(adapterFactory);
						// first come first serve
						break;
					}
				}
			} else {
				adapterFactory
						.setFilteredItemProvider(new EClassFilterItemProvider(
								adapterFactory, TaskPackage.eINSTANCE
										.getActionItem()));
				viewer.setAdapterFactory(adapterFactory);
			}

		}
	}

	public void setRestrictedToCurrentUser(boolean checked) {
		this.restrictedToCurrentUser = checked;

	}

	public boolean isRestrictedToCurrentUser() {
		return restrictedToCurrentUser;
	}
}
