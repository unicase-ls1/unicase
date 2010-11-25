/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.dialogs.admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.util.DialogHandler;
import org.unicase.workspace.AdminBroker;
import org.unicase.workspace.ui.Activator;
import org.unicase.workspace.ui.views.emfstorebrowser.dialogs.admin.acimport.wizard.AcUserImportAction;

/**
 * @author gurcankarakoc, deser
 */
public class GroupTabContent extends TabContent implements IPropertyChangeListener {

	/**
	 * @param string the name of tab.
	 * @param adminBroker AdminBroker is needed to communicate with server.
	 * @param frm used to set input to properties form and update its table viewer upon. deletion of OrgUnits.
	 */
	public GroupTabContent(String string, AdminBroker adminBroker, PropertiesForm frm) {
		super(string, adminBroker, frm);
		this.setTab(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ui.views.emfstorebrowser.dialogs.admin.TabContent#initActions()
	 */
	@Override
	protected List<Action> initActions() {

		Action createNewGroup = new Action("Create new group") {
			@Override
			public void run() {
				try {
					getAdminBroker().createGroup("New Group");
				} catch (EmfStoreException e) {
					DialogHandler.showExceptionDialog(e);
				}
				getTableViewer().refresh();
				getForm().getTableViewer().refresh();
			}
		};

		createNewGroup.setImageDescriptor(Activator.getImageDescriptor("icons/Group.gif"));
		createNewGroup.setToolTipText("Create new group");

		Action deleteGroup = new Action("Delete group") {
			@Override
			public void run() {
				IStructuredSelection selection = (IStructuredSelection) getTableViewer().getSelection();
				Iterator<?> iterator = selection.iterator();
				while (iterator.hasNext()) {
					ACGroup ou = (ACGroup) iterator.next();
					if (ou == null) {
						return;
					}
					try {
						getAdminBroker().deleteGroup(ou.getId());
					} catch (EmfStoreException e) {
						DialogHandler.showExceptionDialog(e);
					}

					if (getForm().getCurrentInput() instanceof ACOrgUnit && getForm().getCurrentInput().equals(ou)) {
						getForm().setInput(null);
					}
				}
				getTableViewer().refresh();
			}
		};

		deleteGroup.setImageDescriptor(Activator.getImageDescriptor("icons/delete.gif"));
		deleteGroup.setToolTipText("Delete group");

		Action importOrgUnit = new AcUserImportAction(getAdminBroker());
		importOrgUnit.addPropertyChangeListener(this);

		return Arrays.asList(createNewGroup, deleteGroup, importOrgUnit);
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
				return Activator.getImageDescriptor("icons/Group.gif").createImage();
			}

			public String getColumnText(Object element, int columnIndex) {
				return ((ACGroup) element).getName();
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
				// return a list of Groups in project space
				List<ACGroup> groups = new ArrayList<ACGroup>();
				try {
					groups.addAll(getAdminBroker().getGroups());
				} catch (EmfStoreException e) {
					DialogHandler.showExceptionDialog(e);
				}
				return groups.toArray(new ACGroup[groups.size()]);
			}

			public void dispose() {
			}

			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}
		};
	}

	/**
	 * Refresh the tableViewer after a property change. (Used e.g. after importing users via e.g. CSV.)
	 * 
	 * @param event The event to deal with.
	 */
	public void propertyChange(PropertyChangeEvent event) {
		getTableViewer().refresh();
	}

}
