/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.dialogs.admin;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.AdminBroker;

/**
 * This class sets the contents of tabs on the left side of OrgUnitManagmentGUI.
 * 
 * @author Hodaie, gurcankarakoc
 */
public abstract class TabContent {

	/**
	 * ListViewer lists the element in the tabs.
	 */
	protected ListViewer listViewer;

	/**
	 * 
	 */
	protected String tabName;

	/**
	 * The type of the current tab.
	 */
	public TabContent tab;

	/**
	 * AdminBroker is needed to communicate with server.
	 */
	protected AdminBroker adminBroker;

	/**
	 * used to set input to properties form and update its table viewer upon.
	 * deletion of OrgUnits.
	 */
	protected PropertiesForm form;

	/**
	 * Constructor.
	 * 
	 * @param tabName
	 *            tab name
	 * @param adminBroker
	 *            AdminBroker
	 * @param frm
	 *            ProperitesForm
	 */
	public TabContent(String tabName, AdminBroker adminBroker,
			PropertiesForm frm) {
		this.tabName = tabName;
		this.adminBroker = adminBroker;
		this.form = frm;

	}

	/**
	 * Creates contents of each tab.
	 * 
	 * @param tabFolder
	 *            parent
	 * @return contents composite
	 */
	protected abstract Composite createContents(TabFolder tabFolder);

	/**
	 * @param tabPage
	 *            is the Composite.
	 */
	protected void initList(Composite tabPage) {

		listViewer = new ListViewer(tabPage, SWT.V_SCROLL | SWT.BORDER);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalSpan = 2;
		listViewer.getList().setLayoutData(gridData);

		listViewer.setLabelProvider(new TabLabelProvider());
		listViewer.setContentProvider(new TabContentProvider(tab, adminBroker));
		listViewer.setInput(new Object());

		listViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				form.setInput(getSelectedItem(event));
			}

		});

		addDragNDropSupport();

	}

	/**
	 * @param tabContents
	 *            is the Composite.
	 */
	public abstract void createButtons(Composite tabContents);

	/**
	 * Delete OrgUnit and refresh properties form if needed.
	 */
	protected abstract void deleteOrgUnit();

	/**
	 * You can create a new user or group in this method.
	 */
	protected abstract void newOrgUnit();

	/**
	 * This is used during first creation of tab folder to set initial input to
	 * properties form.
	 */
	public void viewStarted() {
		if (form.getCurrentInput() == null) {
			form.setInput((EObject) listViewer.getElementAt(0));
		}

	}

	private void addDragNDropSupport() {
		int ops = DND.DROP_COPY;
		Transfer[] transfers = new Transfer[] { LocalSelectionTransfer
				.getTransfer() };

		DragSourceListener dragListener = new DragSourceListener() {
			public void dragFinished(DragSourceEvent event) {
				PropertiesForm.setDragNDropObject(null);
				PropertiesForm.setDragSource("");
			}

			public void dragStart(DragSourceEvent event) {
				PropertiesForm.setDragSource(getName());
			}

			public void dragSetData(DragSourceEvent event) {
				EObject eObject = getSelectedItem(null);
				if (eObject != null) {
					if (eObject instanceof ACOrgUnit) {
						ACOrgUnit orgUnit = (ACOrgUnit) eObject;
						PropertiesForm.setDragNDropObject(orgUnit);
					}
				}
			}
		};
		listViewer.addDragSupport(ops, transfers, dragListener);

		ops = DND.DROP_MOVE;
		DropTargetListener dropListener = new DropTargetListener() {
			public void drop(DropTargetEvent event) {
				if (PropertiesForm.getDragNDropObject() instanceof ACOrgUnit) {
					doDrop((ACOrgUnit) PropertiesForm.getDragNDropObject());
					PropertiesForm.setDragNDropObject(null);
				}
			}

			public void dragEnter(DropTargetEvent event) {
			}

			public void dragLeave(DropTargetEvent event) {
			}

			public void dragOperationChanged(DropTargetEvent event) {
			}

			public void dragOver(DropTargetEvent event) {
			}

			public void dropAccept(DropTargetEvent event) {
			}

		};
		listViewer.addDropSupport(ops, transfers, dropListener);

	}

	private void doDrop(ACOrgUnit orgUnit) {
		EObject currentInput = form.getCurrentInput();
		if (currentInput == null) {
			return;
		}
		try {
			if (currentInput instanceof ProjectInfo) {
				ProjectInfo projectInfo = (ProjectInfo) currentInput;

				adminBroker.removeParticipant(projectInfo.getProjectId(),
						orgUnit.getId());

			} else if (currentInput instanceof ACGroup) {
				ACGroup group = (ACGroup) currentInput;
				adminBroker.removeMember(group.getId(), orgUnit.getId());

			} else if (currentInput instanceof ACUser) {
				ACUser user = (ACUser) currentInput;
				adminBroker.removeGroup(user.getId(), ((ACGroup) orgUnit)
						.getId());
			}
		} catch (EmfStoreException e) {
			DialogHandler.showExceptionDialog(e);
		}
	}

	/**
	 * @return name of this tab
	 */
	private String getName() {
		return tabName;
	}

	/**
	 * This is called from user and group properties composites in order to
	 * update ListViewer, For example when name of an OrgUnit is changed.
	 * 
	 * @return listViewer
	 */
	public ListViewer getListViewer() {
		return this.listViewer;
	}

	/**
	 * returns selected item in ListViewer.
	 */
	private EObject getSelectedItem(DoubleClickEvent event) {
		EObject result = null;
		ISelection sel;
		if (event != null) {
			sel = event.getSelection();
		} else {
			sel = listViewer.getSelection();
		}

		IStructuredSelection ssel = null;
		if (sel != null) {
			ssel = (IStructuredSelection) sel;
		}

		if (ssel != null) {
			Object obj = ssel.getFirstElement();
			if (obj instanceof ProjectInfo) {
				result = (ProjectInfo) obj;
			} else if (obj instanceof ACOrgUnit) {
				result = (ACOrgUnit) obj;
			}
		}

		return result;

	}

	/**
	 * This is the ContentProvider for ListViewer.
	 * 
	 * @author Hodaie
	 */
	@SuppressWarnings("unused")
	private class ListContentProvider extends AdapterFactoryContentProvider {

		public ListContentProvider() {

			super(new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		}

		@Override
		public Object[] getElements(Object object) {

			Object[] result = new Object[0];
			try {
				if (tabName.equals("Projects")) {
					// return a list of Projects in project space
					List<ProjectInfo> projectInfos = new ArrayList<ProjectInfo>();
					projectInfos.addAll(adminBroker.getProjectInfos());
					result = projectInfos.toArray(new ProjectInfo[projectInfos
							.size()]);

				} else if (tabName.equals("Groups")) {
					// return a list of Groups in project space
					List<ACGroup> groups = new ArrayList<ACGroup>();
					groups.addAll(adminBroker.getGroups());
					result = groups.toArray(new ACGroup[groups.size()]);
				} else if (tabName.equals("Users")) {
					// return a list of Users in project space
					List<ACUser> users = new ArrayList<ACUser>();
					users.addAll(adminBroker.getUsers());
					result = users.toArray(new ACUser[users.size()]);
				}
			} catch (EmfStoreException e) {
				DialogHandler.showExceptionDialog(e);
			}
			return result;
		}

	}// ListContentProvider

}
