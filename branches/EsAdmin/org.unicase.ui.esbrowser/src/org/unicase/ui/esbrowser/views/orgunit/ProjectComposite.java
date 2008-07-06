package org.unicase.ui.esbrowser.views.orgunit;

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
import org.unicase.workspace.WorkspaceManager;

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

	public ProjectComposite(Composite parent, int style) {
		super(parent, style);
		createControls();
	}

	protected void removeOrgUnit(ACOrgUnit orgUnit) {
		WorkspaceManager.getInstance().getAdminConnectionManager()
				.removeParticipant(projectInfo, orgUnit);
		tableViewer.refresh();
	}

	protected void addOrgUnit(ACOrgUnit participant) {
		// 1. show a list of all AcOrgUnits that do not participate in this
		// project
		// (get list of all AcOrgUnits, remove those who take part in this
		// Project)
		// 2. add the selected participant to the project
		if (participant != null) {
			WorkspaceManager.getInstance().getAdminConnectionManager()
					.addParticipant(projectInfo, participant);
		} else {
			EList<ACOrgUnit> participants = getParticipants();
			for (ACOrgUnit orgUnit : participants) {
				WorkspaceManager.getInstance().getAdminConnectionManager()
						.addParticipant(projectInfo, orgUnit);
			}
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
		allOrgUnits.addAll(WorkspaceManager.getInstance()
				.getAdminConnectionManager().getOrgUnits());
		allOrgUnits.removeAll(WorkspaceManager.getInstance()
				.getAdminConnectionManager().getParticipants(projectInfo));

		Object[] result = showDialog(allOrgUnits, "Select a participant");

		EList<ACOrgUnit> participants = new BasicEList<ACOrgUnit>();

		for (int i = 0; i < result.length; i++) {
			if (result[i] instanceof ACOrgUnit) {
				participants.add((ACOrgUnit) result[i]);
			}
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
		switch (role) {
		case READER_ROLE:
			WorkspaceManager.getInstance().getAdminConnectionManager()
					.changeRole(projectInfo, orgUnit,
							RolesPackage.eINSTANCE.getReaderRole());
			break;

		case WRITER_ROLE:
			WorkspaceManager.getInstance().getAdminConnectionManager()
					.changeRole(projectInfo, orgUnit,
							RolesPackage.eINSTANCE.getWriterRole());
			break;

		case PROJECT_ADMIN_ROLE:
			WorkspaceManager.getInstance().getAdminConnectionManager()
					.changeRole(projectInfo, orgUnit,
							RolesPackage.eINSTANCE.getProjectAdminRole());
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
		this.projectInfo = projectInfo;

		txtName.setText(projectInfo.getName());
		txtDescription.setText(projectInfo.getDescription());
		txtVersion.setText(String.valueOf(projectInfo.getVersion()
				.getIdentifier()));
		tableViewer.setInput(projectInfo);

	}

	public int getCurrentRoleIndex(ACOrgUnit orgUnit) {
		int result = 0;
		Role role = WorkspaceManager.getInstance().getAdminConnectionManager()
				.getRole(projectInfo, orgUnit);
		if (role.eClass().equals(RolesPackage.eINSTANCE.getReaderRole())) {
			result = READER_ROLE;
		} else if (role.eClass().equals(RolesPackage.eINSTANCE.getWriterRole())) {
			result = WRITER_ROLE;

		} else if (role.eClass().equals(
				RolesPackage.eINSTANCE.getProjectAdminRole())) {
			result = PROJECT_ADMIN_ROLE;
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
