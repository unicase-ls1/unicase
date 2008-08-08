package org.unicase.ui.esbrowser.dialogs.admin;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TabFolder;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.AdminBroker;

public class TabContent {

	private ListViewer list;
	private Composite tabContents;
	private String tabName;
	private AdminBroker adminBroker;
	private OrgUnitManagementGUI orgUnitMgmtGUI;

	private PropertiesForm frm;

	public TabContent(String tabName, AdminBroker adminBroker, OrgUnitManagementGUI orgUnitManagementGUI) {
		this.tabName = tabName;
		this.adminBroker = adminBroker;
		this.orgUnitMgmtGUI = orgUnitManagementGUI;
	}

	public Composite createContents(TabFolder tabFolder) {

		Control[] controlsOnSash = tabFolder.getParent().getChildren();
		frm = (PropertiesForm) controlsOnSash[1];

		tabContents = new Composite(tabFolder, SWT.NONE);
		tabContents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		tabContents.setLayout(new GridLayout(2, false));

		initList(tabContents);

		if (!tabName.equals("Projects")) {
			createButtons(tabContents);
		}

		return tabContents;

	}

	private void createButtons(Composite tabContents) {
		Button btnNew = new Button(tabContents, SWT.PUSH );
		if (this.tabName.equals("Users")) {
			btnNew.setText("New User");
		} else {
			btnNew.setText("New Group");
		}

		btnNew.addSelectionListener(new SelectionAdapter() {
			// create a new OrgUnit
			public void widgetSelected(SelectionEvent e) {
				newOrgUnit();
			}

		});

		// Create and configure the "Delete" button
		Button btnDelete = new Button(tabContents, SWT.PUSH);
		if (this.tabName.equals("Users")) {
			btnDelete.setText("Delete User");// User");
		} else {
			btnDelete.setText("Delete Group");
		}

		btnDelete.addSelectionListener(new SelectionAdapter() {

			// Remove the selection and refresh the view
			public void widgetSelected(SelectionEvent e) {
//				int selectedIndex = list.getList().getSelectionIndex();
				ACOrgUnit ou = (ACOrgUnit) ((IStructuredSelection) list
						.getSelection()).getFirstElement();
				if (ou != null) {
					deleteOrgUnit(ou);
				}
				if(frm.getCurrentInput() instanceof ACOrgUnit 
						&& ((ACOrgUnit)frm.getCurrentInput()).equals(ou)){
					frm.setInput(null);
					return;
				}
				orgUnitMgmtGUI.getFormTableViewer().refresh();
//				if (selectedIndex != 0){
//					list.getList().setSelection(selectedIndex -1);
//				}else if(list.getList().getItemCount() == 0){
//					frm.setInput(null);
//					return;
//				}else{
//					list.getList().setSelection(0);
//				}
//				frm.setInput((EObject)((IStructuredSelection) list
//						.getSelection()).getFirstElement());
			}
		});
		

	}

	protected void deleteOrgUnit(ACOrgUnit ou) {
		try {
			if (ou instanceof ACGroup) {

				adminBroker.deleteGroup(((ACGroup) ou).getId());

			} else {
				adminBroker.deleteUser(((ACUser) ou).getId());
			}
		} catch (EmfStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list.refresh();
	}

	protected void newOrgUnit() {
		try {
			if (tabName.equals("Users")) {

				adminBroker.createUser("New User");
				
			} else {
				adminBroker.createGroup("New Group");
			}
		} catch (EmfStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list.refresh();
	}

	public void setPropertiesForm(PropertiesForm frm) {
		this.frm = frm;

	}

	public void viewStarted() {
		if (frm.getCurrentInput() == null) {
			frm.setInput((EObject) list.getElementAt(0));
		}

	}

	private void initList(Composite tabPage) {

		list = new ListViewer(tabPage, SWT.V_SCROLL | SWT.BORDER);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true); 
		gridData.horizontalSpan = 2;
		list.getList().setLayoutData(gridData);

		list.setLabelProvider(new ListLabelProvider());
		list.setContentProvider(new ListContentProvider());
		list.setInput(new Object());

		list.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				frm.setInput(getSelectedItem(event));
			}
		});

		addDragNDropSupport();

	}

	private void addDragNDropSupport() {
		int ops = DND.DROP_COPY;
		Transfer[] transfers = new Transfer[] { LocalSelectionTransfer
				.getTransfer() };

		DragSourceListener dragListener = new DragSourceListener() {
			public void dragFinished(DragSourceEvent event) {
				PropertiesForm.dragNDropObject = null;
			}

			public void dragStart(DragSourceEvent event) {
				PropertiesForm.dragSource = getName();
			}

			public void dragSetData(DragSourceEvent event) {
				EObject eObject = getSelectedItem(null);
				if (eObject != null) {
					if (eObject instanceof ACOrgUnit) {
						ACOrgUnit orgUnit = (ACOrgUnit) eObject;
						PropertiesForm.dragNDropObject = orgUnit;
					}
				}
			}
		};
		list.addDragSupport(ops, transfers, dragListener);

		ops = DND.DROP_MOVE;
		DropTargetListener dropListener = new DropTargetListener() {

			public void dragEnter(DropTargetEvent event) {
			}

			public void drop(DropTargetEvent event) {
				if (PropertiesForm.dragNDropObject instanceof ACOrgUnit) {
					ACOrgUnit orgUnit = (ACOrgUnit) PropertiesForm.dragNDropObject;
					doDrop(orgUnit);
					PropertiesForm.dragNDropObject = null;
				}
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
		list.addDropSupport(ops, transfers, dropListener);

	}

	protected void doDrop(ACOrgUnit orgUnit) {
		EObject currentInput = frm.getCurrentInput();
		if (currentInput == null)
			return;
		try {
			if (currentInput instanceof ProjectInfo) {
				ProjectInfo projectInfo = (ProjectInfo) currentInput;

				adminBroker.removeParticipant(projectInfo.getProjectId(),
						orgUnit.getId());

			} else if (currentInput instanceof ACGroup) {
				ACGroup group = (ACGroup) currentInput;
				try {
					adminBroker.removeMember(group.getId(), orgUnit.getId());

				} catch (EmfStoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (currentInput instanceof ACUser) {
				ACUser user = (ACUser) currentInput;
				adminBroker.removeGroup(user.getId(), ((ACGroup) orgUnit)
						.getId());
			}
		} catch (EmfStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getName() {
		return tabName;
	}
	
	public ListViewer getListViewer(){
		return this.list;
	}

	private EObject getSelectedItem(DoubleClickEvent event) {
		EObject result = null;
		ISelection sel;
		if (event != null) {
			sel = event.getSelection();
		} else {
			sel = list.getSelection();
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

	private class ListLabelProvider extends
			AdapterFactoryLabelProvider  {

		public ListLabelProvider() {

			super( new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		}

	}// ListLabelProvider

	private class ListContentProvider extends
			AdapterFactoryContentProvider {

		public ListContentProvider() {

			super( new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		}

		@Override
		public Object[] getElements(Object object) {

			Object[] result = new Object[0];
//			String tabName = (String) object;
			try {
				if (tabName.equals("Projects")) {
					// return a list of Projects in project space
					EList<ProjectInfo> projectInfos = new BasicEList<ProjectInfo>();

					projectInfos.addAll(adminBroker.getProjectInfos());

					result = projectInfos.toArray(new ProjectInfo[projectInfos
							.size()]);

				} else if (tabName.equals("Groups")) {
					// return a list of Groups in project space
					EList<ACGroup> groups = new BasicEList<ACGroup>();
					groups.addAll(adminBroker.getGroups());
					result = groups.toArray(new ACGroup[groups.size()]);
				} else if (tabName.equals("Users")) {
					// return a list of Users in project space
					EList<ACUser> users = new BasicEList<ACUser>();
					users.addAll(adminBroker.getUsers());
					result = users.toArray(new ACUser[users.size()]);
				}
			} catch (EmfStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}

	}// ListContentProvider

}
