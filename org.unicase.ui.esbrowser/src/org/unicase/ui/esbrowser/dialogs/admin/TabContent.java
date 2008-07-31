package org.unicase.ui.esbrowser.dialogs.admin;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryContentProvider;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryLabelProvider;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
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
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TabFolder;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.WorkspaceManager;

public class TabContent {

	private ListViewer list;
	private Composite tabContents;
	private String tabName;

	private PropertiesForm frm;

	public TabContent(String tabName) {
		this.tabName = tabName;

	}

	public Composite createContents(TabFolder tabFolder) {

		Control[] controlsOnSash = tabFolder.getParent().getChildren();
		frm = (PropertiesForm) controlsOnSash[1];

		tabContents = new Composite(tabFolder, SWT.NONE);
		tabContents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		tabContents.setLayout(new FillLayout());

		initList(tabContents);

		return tabContents;

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
		list.setLabelProvider(new ListLabelProvider());
		list.setContentProvider(new ListContentProvider());
		list.setInput(tabName);

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

				OrgUnitManagementGUI.getInstance().getAdminBroker()
						.removeParticipant(projectInfo.getProjectId(),
								orgUnit.getId());

			} else if (currentInput instanceof ACGroup) {
				ACGroup group = (ACGroup) currentInput;
				if (group.getMembers().contains(orgUnit)) {
					int index = group.getMembers().indexOf(orgUnit);
					group.getMembers().remove(index);
				}
			} else if (currentInput instanceof ACUser) {
				ACUser user = (ACUser) currentInput;
				OrgUnitManagementGUI.getInstance().getAdminBroker()
						.removeGroup(user.getId(), ((ACGroup) orgUnit).getId());
			}
		} catch (EmfStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getName() {
		return tabName;
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
			TransactionalAdapterFactoryLabelProvider implements ILabelProvider {

		public ListLabelProvider() {

			super(WorkspaceManager.getInstance().getCurrentWorkspace()
					.getEditingDomain(), new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		}

	}// ListLabelProvider

	private class ListContentProvider extends
			TransactionalAdapterFactoryContentProvider {

		public ListContentProvider() {

			super(WorkspaceManager.getInstance().getCurrentWorkspace()
					.getEditingDomain(), new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		}

		@Override
		public Object[] getElements(Object object) {

			Object[] result = new Object[0];
			String tabName = (String) object;
			try {
				if (tabName.equals("Projects")) {
					// return a list of Projects in project space
					EList<ProjectInfo> projectInfos = new BasicEList<ProjectInfo>();

					projectInfos.addAll(OrgUnitManagementGUI.getInstance()
							.getAdminBroker().getProjectInfos());

					result = projectInfos.toArray(new ProjectInfo[projectInfos
							.size()]);

				} else if (tabName.equals("Groups")) {
					// return a list of Groups in project space
					EList<ACGroup> groups = new BasicEList<ACGroup>();
					groups.addAll(OrgUnitManagementGUI.getInstance()
							.getAdminBroker().getGroups());
					result = groups.toArray(new ACGroup[groups.size()]);
				} else if (tabName.equals("Users")) {
					// return a list of Users in project space
					EList<ACUser> users = new BasicEList<ACUser>();
					users.addAll(OrgUnitManagementGUI.getInstance()
							.getAdminBroker().getUsers());
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
