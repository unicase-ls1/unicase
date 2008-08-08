package org.unicase.ui.esbrowser.dialogs.admin;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.roles.Role;
import org.unicase.emfstore.esmodel.accesscontrol.roles.RolesPackage;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.AdminBroker;

public class ProjectComposite extends FormContents {

	private static final int READER_ROLE = 0;
	private static final int WRITER_ROLE = 1;
	private static final int PROJECT_ADMIN_ROLE = 2;

	// Set column names
	private String[] roleNames = new String[] { "Reader", "Writer",
			"Project Admin" };

	private Label lblVersion;
	private Text txtVersion;

	private ProjectInfo projectInfo;
	private OrgUnitManagementGUI orgUnitMgmtGUI;

	public ProjectComposite(Composite parent, int style, AdminBroker adminBroker, OrgUnitManagementGUI orgUnitMgmtGUI) {
		super(parent, style, adminBroker);
		this.orgUnitMgmtGUI = orgUnitMgmtGUI;
		createControls();
	}

	protected void removeOrgUnit(ACOrgUnit orgUnit) {
		try {
			adminBroker
					.removeParticipant(projectInfo.getProjectId(),
							orgUnit.getId());
		} catch (EmfStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tableViewer.refresh();
	}

	protected void addOrgUnit(ACOrgUnit participant) {
		// 1. show a list of all AcOrgUnits that do not participate in this
		// project
		// (get list of all AcOrgUnits, remove those who take part in this
		// Project)
		// 2. add the selected participant to the project
		try {
			if (participant != null) {
				adminBroker
						.addParticipant(projectInfo.getProjectId(),
								participant.getId());
			} else {
				EList<ACOrgUnit> participants = getParticipants();
				for (ACOrgUnit orgUnit : participants) {

					adminBroker
							.addParticipant(projectInfo.getProjectId(),
									orgUnit.getId());

				}
			}
		} catch (EmfStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tableViewer.refresh();
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
			allOrgUnits.addAll(adminBroker.getOrgUnits());
			allOrgUnits.removeAll(adminBroker.getParticipants(
							projectInfo.getProjectId()));

			Object[] result = showDialog(allOrgUnits, "Select a participant");

			for (int i = 0; i < result.length; i++) {
				if (result[i] instanceof ACOrgUnit) {
					participants.add((ACOrgUnit) result[i]);
				}
			}
		} catch (EmfStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return participants;

	}

	protected void createTableGroup() {

		super.createTableGroup();
		grpTable.setText("Participants");

	}

	protected void createTable(Composite parent) {

		super.createTable(parent);

		// TableColumn column = new TableColumn(table, SWT.LEFT, 3);
		// column.setText("Role");
		// column.setWidth(120);
		// Add listener to column so tasks are sorted by percent when clicked
		// column.addSelectionListener(new SelectionAdapter() {
		// public void widgetSelected(SelectionEvent e) {
		// tableViewer.setSorter(new ExampleTaskSorter(
		// ExampleTaskSorter.PERCENT_COMPLETE));
		// }
		// });
	}

	protected void createTableViewer() {

		super.createTableViewer();

		TableViewerColumn roleColumnViewer = new TableViewerColumn(tableViewer,
				SWT.NONE);
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
		roleColumnViewer.setEditingSupport(new RoleEditingSupport(tableViewer));

		// Create the cell editors
		// CellEditor[] editors = new CellEditor[columnNames.length];
		//
		// // Column 1 : icon
		// editors[0] = null;
		//
		// // // Column 2 : name (Free text)
		// // TextCellEditor textEditor = new TextCellEditor(table);
		// // ((Text) textEditor.getControl()).setTextLimit(60);
		// editors[1] = null;
		//
		// // Column 3 : description (Text with digits only)
		// // textEditor = new TextCellEditor(table);
		// editors[2] = null;
		//
		// // Column 4: role (Combo Box)
		// editors[3] = new ComboBoxCellEditor(table, roleNames, SWT.READ_ONLY);
		//
		// // Assign the cell editors to the viewer
		// tableViewer.setCellEditors(editors);
		// // Set the cell modifier for the viewer
		// tableViewer.setCellModifier(new TableCellModifier());
		// // Set the default sorter for the viewer
		// // tableViewer.setSorter(new
		// // ExampleTaskSorter(ExampleTaskSorter.DESCRIPTION));

	}

	public void changeRole(ACOrgUnit orgUnit, int role) {
		try {
			switch (role) {
			case READER_ROLE:
				adminBroker.changeRole(
						projectInfo.getProjectId(), orgUnit.getId(),
						RolesPackage.eINSTANCE.getReaderRole());

				break;

			case WRITER_ROLE:
				adminBroker.changeRole(
						projectInfo.getProjectId(), orgUnit.getId(),
						RolesPackage.eINSTANCE.getWriterRole());
				break;

			case PROJECT_ADMIN_ROLE:
				adminBroker.changeRole(
						projectInfo.getProjectId(), orgUnit.getId(),
						RolesPackage.eINSTANCE.getProjectAdminRole());
			}
		} catch (EmfStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tableViewer.refresh();
	}

	protected void createSimpleAttributes() {

		super.createSimpleAttributes();

		txtName.setEnabled(false);
		txtDescription.setEnabled(false);

		lblVersion = new Label(grpAttributes, SWT.NONE);
		lblVersion.setText("Version: ");
		txtVersion = new Text(grpAttributes, SWT.BORDER);
		txtVersion.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		txtVersion.setEnabled(false);
	}

	public void updateControls(ProjectInfo projectInfo) {
		if(!grpAttributes.isVisible()){
			grpAttributes.setVisible(true);
			grpTable.setVisible(true);
		}
		
		this.projectInfo = projectInfo;

		txtName.setText(projectInfo.getName());
		txtDescription.setText(projectInfo.getDescription());
		txtVersion.setText(String.valueOf(projectInfo.getVersion()
				.getIdentifier()));
		tableViewer.setInput(projectInfo);
		orgUnitMgmtGUI.setFormTableViewer(tableViewer);

	}

	public int getCurrentRoleIndex(ACOrgUnit orgUnit) {
		int result = 0;
		Role role;
		try {
			role = adminBroker.getRole(
					projectInfo.getProjectId(), orgUnit.getId());
			if (role.eClass().equals(RolesPackage.eINSTANCE.getReaderRole())) {
				result = READER_ROLE;
			} else if (role.eClass().equals(
					RolesPackage.eINSTANCE.getWriterRole())) {
				result = WRITER_ROLE;

			} else if (role.eClass().equals(
					RolesPackage.eINSTANCE.getProjectAdminRole())) {
				result = PROJECT_ADMIN_ROLE;
			}
		} catch (EmfStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private class RoleEditingSupport extends EditingSupport {

		private ComboBoxCellEditor cellEditor;

		public RoleEditingSupport(ColumnViewer viewer) {
			super(viewer);
			cellEditor = new ComboBoxCellEditor(table, roleNames, SWT.READ_ONLY);
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
