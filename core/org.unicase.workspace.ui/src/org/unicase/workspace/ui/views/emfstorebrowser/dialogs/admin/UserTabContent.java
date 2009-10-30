/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.dialogs.admin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.GridData;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.ToolBar;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.AdminBroker;
import org.unicase.workspace.ui.Activator;

/**
 * @author gurcankarakoc, deser
 */
public class UserTabContent extends TabContent implements
		IPropertyChangeListener {

	/**
	 * Action to delete a user.
	 * 
	 * @author koegel
	 * 
	 */
	private final class DeleteUserAction extends Action {
		private DeleteUserAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			IStructuredSelection selection = (IStructuredSelection) getTableViewer()
					.getSelection();
			Iterator<?> iterator = selection.iterator();

			while (iterator.hasNext()) {
				ACUser ou = (ACUser) iterator.next();
				if (ou == null) {
					return;
				}

				try {
					getAdminBroker().deleteUser(ou.getId());
				} catch (EmfStoreException e) {
					DialogHandler.showExceptionDialog(e);
				}

				if (getForm().getCurrentInput() instanceof ACOrgUnit
						&& getForm().getCurrentInput().equals(ou)) {
					getForm().setInput(null);
				}
			}
			getTableViewer().refresh();
		}
	}

	/**
	 * @param string
	 *            the name of tab.
	 * @param adminBroker
	 *            AdminBroker is needed to communicate with server.
	 * @param frm
	 *            used to set input to properties form and update its table
	 *            viewer upon. deletion of OrgUnits.
	 */
	public UserTabContent(String string, AdminBroker adminBroker,
			PropertiesForm frm) {
		super(string, adminBroker, frm);
		this.setTab(this);
	}

	/**
	 * @see org.unicase.ui.esbrowser.dialogs.admin.TabContent#createContents(org.eclipse.swt.widgets.TabFolder)
	 * @return Composite.
	 * @param tabFolder
	 *            TabFolder.
	 */
	@Override
	protected Composite createContents(TabFolder tabFolder) {
		Composite tabContent = new Composite(tabFolder, SWT.NONE);
		tabContent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		tabContent.setLayout(new GridLayout(2, false));

		ToolBar toolBar = new ToolBar(tabContent, SWT.FLAT | SWT.RIGHT);
		ToolBarManager toolBarManager = new ToolBarManager(toolBar);

		Action createNewUser = new Action("Create new user") {

			@Override
			public void run() {
				try {
					getAdminBroker().createUser("New User");

				} catch (EmfStoreException e) {

					DialogHandler.showExceptionDialog(e);
				}
				getTableViewer().refresh();

				getForm().getTableViewer().refresh();

			}

		};

		createNewUser.setImageDescriptor(Activator
				.getImageDescriptor("icons/user.png"));
		createNewUser.setToolTipText("Create new user");

		Action deleteUser = new DeleteUserAction("Delete user");

		deleteUser.setImageDescriptor(Activator
				.getImageDescriptor("icons/delete.gif"));
		deleteUser.setToolTipText("Delete user");

		Action importOrgUnit = new AcUserImportAction(getAdminBroker());
		importOrgUnit.addPropertyChangeListener(this);

		toolBarManager.add(createNewUser);
		toolBarManager.add(deleteUser);
		toolBarManager.add(importOrgUnit);
		toolBarManager.update(true);

		initList(tabContent);

		return tabContent;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ITableLabelProvider getLabelProvider() {
		return new ITableLabelProvider() {

			public void addListener(ILabelProviderListener listener) {
			}

			public boolean isLabelProperty(Object element, String property) {
				return false;
			}

			public void removeListener(ILabelProviderListener listener) {
			}

			public void dispose() {
			}

			public Image getColumnImage(Object element, int columnIndex) {
				return Activator.getImageDescriptor("icons/user.png")
						.createImage();
			}

			public String getColumnText(Object element, int columnIndex) {
				return ((ACUser) element).getName();
			}

		};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStructuredContentProvider getContentProvider() {
		return new IStructuredContentProvider() {

			public Object[] getElements(Object inputElement) {
				// return a list of Users in project space
				List<ACUser> users = new ArrayList<ACUser>();
				try {
					users.addAll(getAdminBroker().getUsers());
				} catch (EmfStoreException e) {
					DialogHandler.showExceptionDialog(e);
				}
				return users.toArray(new ACUser[users.size()]);
			}

			public void dispose() {
			}

			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
			}
		};
	}

	/**
	 * Refresh the tableViewer after a property change. (Used e.g. after
	 * importing users via e.g. CSV.)
	 * 
	 * @param event
	 *            The event to deal with.
	 */
	public void propertyChange(PropertyChangeEvent event) {
		getTableViewer().refresh();
	}

}
