/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.dialogs.admin;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.Table;
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
 * @author Hodaie, gurcankarakoc, deser
 */
public abstract class TabContent {

	/**
	 * @author deser
	 */
	private final class SimpleAlphabeticSorter extends ViewerSorter {

		private int dir = SWT.UP;

		public SimpleAlphabeticSorter(int dir) {
			super();
			this.dir = dir;
		}

		@Override
		public int compare(Viewer viewer, Object e1, Object e2) {
			int returnValue = 0;
			if (e1 instanceof ProjectInfo) {
				ProjectInfo pi1 = (ProjectInfo) e1;
				ProjectInfo pi2 = (ProjectInfo) e2;
				returnValue = pi1.getName().compareTo(pi2.getName());
			}
			if (e1 instanceof ACUser) {
				ACUser u1 = (ACUser) e1;
				ACUser u2 = (ACUser) e2;
				returnValue = u1.getName().compareTo(u2.getName());
			}

			if (e1 instanceof ACGroup) {
				ACGroup g1 = (ACGroup) e1;
				ACGroup g2 = (ACGroup) e2;
				returnValue = g1.getName().compareTo(g2.getName());
			}
			if (this.dir == SWT.DOWN) {
				returnValue = returnValue * -1;
			}
			return returnValue;
		}
	}

	private TableViewer tableViewer;
	private String tabName;

	/**
	 * The type of the current tab.
	 */
	private TabContent tab;

	/**
	 * AdminBroker is needed to communicate with server.
	 */
	private AdminBroker adminBroker;

	/**
	 * used to set input to properties form and update its table viewer upon. deletion of OrgUnits.
	 */
	private PropertiesForm form;

	/**
	 * Constructor.
	 * 
	 * @param tabName tab name
	 * @param adminBroker AdminBroker
	 * @param frm ProperitesForm
	 */
	public TabContent(String tabName, AdminBroker adminBroker, PropertiesForm frm) {
		this.tabName = tabName;
		this.adminBroker = adminBroker;
		this.form = frm;
	}

	/**
	 * Creates contents of each tab.
	 * 
	 * @param tabFolder parent
	 * @return contents composite
	 */
	protected abstract Composite createContents(TabFolder tabFolder);

	/**
	 * @param tabPage is the Composite.
	 */
	protected void initList(Composite tabPage) {

		tableViewer = new TableViewer(tabPage, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);

		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalSpan = 2;
		tableViewer.getTable().setLayoutData(gridData);

		Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableViewerColumn column = new TableViewerColumn(tableViewer, SWT.NONE);

		column.getColumn().setWidth(100);
		column.getColumn().setResizable(true);
		column.getColumn().setMoveable(true);

		// The getContentProvider-method fetches the specific ContentProvider.
		// Therefore this method has to be overridden in children of this class!
		tableViewer.setContentProvider(getContentProvider());

		// The same with the LabelProvider.
		tableViewer.setLabelProvider(getLabelProvider());
		tableViewer.setInput(new Object());

		tableViewer.getTable().setSortColumn(tableViewer.getTable().getColumn(0));
		tableViewer.getTable().setSortDirection(SWT.UP);

		Listener sortListener = new Listener() {
			public void handleEvent(Event e) {
				int dir = tableViewer.getTable().getSortDirection();
				dir = dir == SWT.UP ? SWT.DOWN : SWT.UP;
				tableViewer.getTable().setSortDirection(dir);
				tableViewer.setSorter(new SimpleAlphabeticSorter(dir));
			}

		};

		// connect the listener to the (first) column
		column.getColumn().addListener(SWT.Selection, sortListener);

		tableViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				form.setInput(getSelectedItem(event));
			}

		});

		addDragNDropSupport();

	}

	/**
	 * @return The LabelProvider for the concrete TabContent.
	 */
	public abstract ITableLabelProvider getLabelProvider();

	/**
	 * @return The ContentProvider for the concrete TabContent.
	 */
	public abstract IStructuredContentProvider getContentProvider();

	/**
	 * This is used during first creation of tab folder to set initial input to properties form.
	 */
	public void viewStarted() {
		if (form.getCurrentInput() == null) {
			form.setInput((EObject) tableViewer.getElementAt(0));
		}

	}

	private void addDragNDropSupport() {
		int ops = DND.DROP_COPY;
		Transfer[] transfers = new Transfer[] { LocalSelectionTransfer.getTransfer() };

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
		tableViewer.addDragSupport(ops, transfers, dragListener);

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
		tableViewer.addDropSupport(ops, transfers, dropListener);

	}

	private void doDrop(ACOrgUnit orgUnit) {
		EObject currentInput = form.getCurrentInput();
		if (currentInput == null) {
			return;
		}
		try {
			if (currentInput instanceof ProjectInfo) {
				ProjectInfo projectInfo = (ProjectInfo) currentInput;

				adminBroker.removeParticipant(projectInfo.getProjectId(), orgUnit.getId());

			} else if (currentInput instanceof ACGroup) {
				ACGroup group = (ACGroup) currentInput;
				adminBroker.removeMember(group.getId(), orgUnit.getId());

			} else if (currentInput instanceof ACUser) {
				ACUser user = (ACUser) currentInput;
				adminBroker.removeGroup(user.getId(), ((ACGroup) orgUnit).getId());
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
	 * This is called from user and group properties composites in order to update TableViewer, For example when name of
	 * an OrgUnit is changed.
	 * 
	 * @return tableViewer
	 */
	public TableViewer getTableViewer() {
		return this.tableViewer;
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
			sel = tableViewer.getSelection();
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
	 * @return the name of the tab.
	 */
	public String getTabName() {
		return tabName;
	}

	/**
	 * @param tabName set the name of current tab.
	 */
	public void setTabName(String tabName) {
		this.tabName = tabName;
	}

	/**
	 * @return get the type of the current tab.
	 */
	public TabContent getTab() {
		return tab;
	}

	/**
	 * @param tab set the type of current tab.
	 */
	public void setTab(TabContent tab) {
		this.tab = tab;
	}

	/**
	 * @return get the AdminBroker.
	 */
	public AdminBroker getAdminBroker() {
		return adminBroker;
	}

	/**
	 * @param adminBroker set the AdminBroker.
	 */
	public void setAdminBroker(AdminBroker adminBroker) {
		this.adminBroker = adminBroker;
	}

	/**
	 * @return get the PropertiesForm.
	 */
	public PropertiesForm getForm() {
		return form;
	}

	/**
	 * @param form set the PropertiesForm.
	 */
	public void setForm(PropertiesForm form) {
		this.form = form;
	}

	/**
	 * @param tableViewer The tableViewer to set.
	 */
	public void setTableViewer(TableViewer tableViewer) {
		this.tableViewer = tableViewer;
	}

}
