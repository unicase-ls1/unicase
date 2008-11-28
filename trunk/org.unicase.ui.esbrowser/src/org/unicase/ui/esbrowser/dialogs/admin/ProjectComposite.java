package org.unicase.ui.esbrowser.dialogs.admin;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.roles.Role;
import org.unicase.emfstore.esmodel.accesscontrol.roles.RolesPackage;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.AdminBroker;

public class ProjectComposite extends PropertiesComposite {

	private static final int READER_ROLE = 0;
	private static final int WRITER_ROLE = 1;
	private static final int PROJECT_ADMIN_ROLE = 2;
	private static final int SERVER_ADMIN_ROLE = 3;

	// Set column names
	private String[] roleNames = new String[] { "Reader", "Writer",
			"Project Admin", "Server Admin" };

	private Label lblVersion;
	private Text txtVersion;

	private ProjectInfo projectInfo;

	public ProjectComposite(Composite parent, int style, AdminBroker adminBroker) {
		super(parent, style, adminBroker);
		createControls();
	}

	protected void removeOrgUnit(ACOrgUnit orgUnit) {
		try {
			getAdminBroker().removeParticipant(projectInfo.getProjectId(),
					orgUnit.getId());
		} catch (EmfStoreException e) {
			// ZH Auto-generated catch block
			e.printStackTrace();
		}
		getTableViewer().refresh();
	}

	@Override
	protected void addExistingOrgUnit(ACOrgUnit participant) {
		// 1. show a list of all AcOrgUnits that do not participate in this
		// project
		// (get list of all AcOrgUnits, remove those who take part in this
		// Project)
		// 2. add the selected participant to the project
		try {
			if (participant != null) {
				getAdminBroker().addParticipant(projectInfo.getProjectId(),
						participant.getId());
			} else {
				EList<ACOrgUnit> participants = getParticipants();
				for (ACOrgUnit orgUnit : participants) {

					getAdminBroker().addParticipant(projectInfo.getProjectId(),
							orgUnit.getId());

				}
			}
		} catch (EmfStoreException e) {
			DialogHandler.showExceptionDialog(e);
		}
		getTableViewer().refresh();
	}

	@Override
	protected void addNewOrgUnit() {
		try {
			EList<ACOrgUnit> participants = getParticipants();
			for (ACOrgUnit orgUnit : participants) {

				getAdminBroker().addParticipant(projectInfo.getProjectId(),
						orgUnit.getId());

			}

		} catch (EmfStoreException e) {
			DialogHandler.showExceptionDialog(e);
		}
		getTableViewer().refresh();
	}
	
	

	private EList<ACOrgUnit> getParticipants() {
		// 1. show a list of all AcOrgUnits that do not participate in this
		// project
		// (get list of all AcOrgUnits, remove those who take part in this
		// Project)
		// 2. return the selected participant

		Collection<ACOrgUnit> allOrgUnits = new BasicEList<ACOrgUnit>();
		EList<ACOrgUnit> participants = new BasicEList<ACOrgUnit>();

		try {
			allOrgUnits.addAll(getAdminBroker().getOrgUnits());
			allOrgUnits.removeAll(getAdminBroker().getParticipants(
					projectInfo.getProjectId()));

			Object[] result = showDialog(allOrgUnits, "Select a participant");

			for (int i = 0; i < result.length; i++) {
				if (result[i] instanceof ACOrgUnit) {
					participants.add((ACOrgUnit) result[i]);
				}
			}
		} catch (EmfStoreException e) {
			DialogHandler.showExceptionDialog(e);
		}
		return participants;

	}

	
	
	protected void createTableGroup() {

		super.createTableGroup("Participants");

	}

	protected void createTableViewer(Composite parent) {

		super.createTableViewer(parent);

		TableViewerColumn roleColumnViewer = new TableViewerColumn(
				getTableViewer(), SWT.NONE);
		roleColumnViewer.getColumn().setText("Role");
		roleColumnViewer.getColumn().setWidth(120);
		roleColumnViewer.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				ACOrgUnit orgUnit = (ACOrgUnit) element;
				int roleIndex = getCurrentRoleIndex(orgUnit);
				return roleNames[roleIndex];
			}

		});
		roleColumnViewer.setEditingSupport(new RoleEditingSupport(
				getTableViewer()));

	}

	@Override
	protected void addDragNDropSupport() {
		// add drag support
		super.addDragNDropSupport();

		// add drop support
		int ops = DND.DROP_COPY;
		Transfer[] transfers = new Transfer[] { LocalSelectionTransfer
				.getTransfer() };
		DropTargetListener dropListener = new DropTargetListener() {
			public void dragEnter(DropTargetEvent event) {
				if (PropertiesForm.getDragSource().equals("Projects")) {
					event.detail = DND.DROP_NONE;

				} else {
					event.detail = DND.DROP_COPY;
				}
			}

			public void drop(DropTargetEvent event) {
				if (PropertiesForm.getDragNDropObject() != null) {
					if (PropertiesForm.getDragNDropObject() instanceof ACGroup) {
						ACGroup group = (ACGroup) PropertiesForm
								.getDragNDropObject();
						addExistingOrgUnit(group);
						PropertiesForm.setDragNDropObject(null);
						getTableViewer().refresh();
					}
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
		getTableViewer().addDropSupport(ops, transfers, dropListener);
	}

	public void changeRole(ACOrgUnit orgUnit, int role) {
		try {
			switch (role) {
			case READER_ROLE:
				getAdminBroker()
						.changeRole(projectInfo.getProjectId(),
								orgUnit.getId(),
								RolesPackage.eINSTANCE.getReaderRole());

				break;

			case WRITER_ROLE:
				getAdminBroker()
						.changeRole(projectInfo.getProjectId(),
								orgUnit.getId(),
								RolesPackage.eINSTANCE.getWriterRole());
				break;

			case PROJECT_ADMIN_ROLE:
				getAdminBroker().changeRole(projectInfo.getProjectId(),
						orgUnit.getId(),
						RolesPackage.eINSTANCE.getProjectAdminRole());
				break;

			case SERVER_ADMIN_ROLE:
				getAdminBroker().changeRole(projectInfo.getProjectId(),
						orgUnit.getId(),
						RolesPackage.eINSTANCE.getServerAdmin());
				break;

			}
		} catch (EmfStoreException e) {
			DialogHandler.showExceptionDialog(e);
		}
		getTableViewer().refresh();
	}

	protected void createSimpleAttributes() {

		super.createSimpleAttributes();

		getTxtName().setEnabled(false);
		getTxtDescription().setEnabled(false);

		lblVersion = new Label(getAttributesGroup(), SWT.NONE);
		lblVersion.setText("Version: ");
		txtVersion = new Text(getAttributesGroup(), SWT.BORDER);
		txtVersion.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		txtVersion.setEnabled(false);
	}

	public void updateControls(ProjectInfo projectInfo) {
		if (!getAttributesGroup().isVisible()) {
			getAttributesGroup().setVisible(true);
			getTableGroup().setVisible(true);
		}

		this.projectInfo = projectInfo;

		getTxtName().setText(projectInfo.getName());
		getTxtDescription().setText(projectInfo.getDescription());
		txtVersion.setText(String.valueOf(projectInfo.getVersion()
				.getIdentifier()));
		getTableViewer().setInput(projectInfo);

	}

	public int getCurrentRoleIndex(ACOrgUnit orgUnit) {
		int result = 0;
		Role role;
		try {
			role = getAdminBroker().getRole(projectInfo.getProjectId(),
					orgUnit.getId());
			if (role.eClass().equals(RolesPackage.eINSTANCE.getReaderRole())) {
				result = READER_ROLE;
			} else if (role.eClass().equals(
					RolesPackage.eINSTANCE.getWriterRole())) {
				result = WRITER_ROLE;

			} else if (role.eClass().equals(
					RolesPackage.eINSTANCE.getProjectAdminRole())) {
				result = PROJECT_ADMIN_ROLE;
			} else if (role.eClass().equals(
					RolesPackage.eINSTANCE.getServerAdmin())) {
				result = SERVER_ADMIN_ROLE;
			}
		} catch (EmfStoreException e) {
			// ZH Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private class RoleEditingSupport extends EditingSupport {

		private ComboBoxCellEditor cellEditor;

		public RoleEditingSupport(ColumnViewer viewer) {
			super(viewer);
			cellEditor = new ComboBoxCellEditor(getTableViewer().getTable(),
					roleNames, SWT.READ_ONLY);
		}

		@Override
		protected boolean canEdit(Object element) {
			return true;
		}

		@Override
		protected CellEditor getCellEditor(Object element) {
			return cellEditor;
		}

		@Override
		protected Object getValue(Object element) {
			return getCurrentRoleIndex((ACOrgUnit) element);
		}

		@Override
		protected void setValue(Object element, Object value) {
			changeRole((ACOrgUnit) element, ((Integer) value).intValue());
		}

	}

}// ProjectComposite
