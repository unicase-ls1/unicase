package org.unicase.ui.esbrowser.views.orgunit;

import java.util.Arrays;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.workspace.WorkspaceManager;

public class ProjectComposite extends Composite {

	private final String ICON_COLUMN = "Icon";
	private final String NAME_COLUMN = "Name";
	private final String DESCRIPTION_COLUMN = "Description";
	private final String ROLE_COLUMN = "Role";

	// Set column names
	private String[] columnNames = new String[] { 
			ICON_COLUMN, 
			NAME_COLUMN,
			DESCRIPTION_COLUMN,
			ROLE_COLUMN
			};
	
	private Label lblName;
	private Label lblDescription;
	private Label lblVersion;

	private Text txtName;
	private Text txtDescription;
	private Text txtVersion;

	private Group grpAttributes, grpTable;
	private TableViewer tableViewer;
	private Table table;
	private ProjectInfo projectInfo;

	
	
	public ProjectComposite(Composite parent, int style) {
		super(parent, style);
		this.setBackground(PlatformUI.getWorkbench().getDisplay()
				.getSystemColor(SWT.COLOR_GREEN));

		createControls();
	}

	private void createControls() {

		this.setLayout(new GridLayout());

		createSimpleAttributes();
		createParticipantsGroup();
		createButtons(grpTable);

	}

	private void createButtons(Composite parent) {
		// Create and configure the "Add" button
		Button add = new Button(parent, SWT.PUSH | SWT.CENTER);
		add.setText("Add");
		
		GridData gridData = new GridData ();
		gridData.widthHint = 80;
		gridData.horizontalAlignment= GridData.END;
		gridData.horizontalSpan = 4;
		add.setLayoutData(gridData);
		add.addSelectionListener(new SelectionAdapter() {
       	
       		// Add a task to the ExampleTaskList and refresh the view
			public void widgetSelected(SelectionEvent e) {
				
				addParticipant(null);
			}

		});

		//	Create and configure the "Delete" button
		Button remove = new Button(parent, SWT.PUSH | SWT.CENTER);
		remove.setText("Remove");
		gridData = new GridData (SWT.END);
		gridData.widthHint = 80; 
		remove.setLayoutData(gridData); 

		remove.addSelectionListener(new SelectionAdapter() {
       	
			//	Remove the selection and refresh the view
			public void widgetSelected(SelectionEvent e) {
				ACOrgUnit participant = (ACOrgUnit) ((IStructuredSelection) 
						tableViewer.getSelection()).getFirstElement();
				if (participant != null) {
					WorkspaceManager.getInstance().getAdminConnectionManager().removeParticipant(projectInfo, participant);
				} 				
			}
		});
		
	}

	private void addParticipant(ACOrgUnit participant) {
		//1. show a list of all AcOrgUnits that do not participate in this project
		//   (get list of all AcOrgUnits, remove those who take part in this Project)
		//2. add the selected participant to the project
		if ( participant == null){
			participant = getParticipant();
		}
		WorkspaceManager.getInstance().getAdminConnectionManager().addParticipant(projectInfo, participant);
		
	}
	
	private ACOrgUnit getParticipant() {
		//1. show a list of all AcOrgUnits that do not participate in this project
		//   (get list of all AcOrgUnits, remove those who take part in this Project)
		//2. return the selected participant
		return null;
	}

	private void createParticipantsGroup() {

		grpTable = new Group(this, SWT.NONE);
		grpTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		grpTable.setText("Participants");
		grpTable.setLayout(new GridLayout(5, true));

		createTable(grpTable);
		createTableViewer();
		tableViewer.setContentProvider(new TableContentProvider());
		tableViewer.setLabelProvider(new TabelLabelProvider());
		
		
	}


	private void createTable(Composite parent) {

		int style = SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.FULL_SELECTION;

		table = new Table(parent, style);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalSpan = 5;
		table.setLayoutData(gridData);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		// 1st column with image/checkboxes - NOTE: The SWT.CENTER has no
		// effect!!
		TableColumn column = new TableColumn(table, SWT.CENTER, 0);
		column.setText("(/*\\)");
		column.setWidth(20);

		// 2nd column with task Description
		column = new TableColumn(table, SWT.LEFT, 1);
		column.setText("Name");
		column.setWidth(100);
		// Add listener to column so tasks are sorted by description when
		// clicked
//		 column.addSelectionListener(new SelectionAdapter() {
//			public void widgetSelected(SelectionEvent e) {
//				tableViewer.setSorter(new ExampleTaskSorter(
//						ExampleTaskSorter.DESCRIPTION));
//			}
//		});

		// 3rd column with task Owner
		column = new TableColumn(table, SWT.LEFT, 2);
		column.setText("Description");
		column.setWidth(200);
		// Add listener to column so tasks are sorted by owner when clicked
//		column.addSelectionListener(new SelectionAdapter() {
//			public void widgetSelected(SelectionEvent e) {
//				tableViewer.setSorter(new ExampleTaskSorter(
//						ExampleTaskSorter.OWNER));
//			}
//		});

		// 4th column with task PercentComplete
		column = new TableColumn(table, SWT.CENTER, 3);
		column.setText("Role");
		column.setWidth(80);
		// Add listener to column so tasks are sorted by percent when clicked
//		column.addSelectionListener(new SelectionAdapter() {
//			public void widgetSelected(SelectionEvent e) {
//				tableViewer.setSorter(new ExampleTaskSorter(
//						ExampleTaskSorter.PERCENT_COMPLETE));
//			}
//		});
	}
	
	private void createTableViewer() {
		tableViewer = new TableViewer(table);
		tableViewer.setUseHashlookup(true);
		
		tableViewer.setColumnProperties(columnNames);

		// Create the cell editors
		CellEditor[] editors = new CellEditor[columnNames.length];

		// Column 1 : icon 
		editors[0] = null;

		// Column 2 : name (Free text)
		TextCellEditor textEditor = new TextCellEditor(table);
		((Text) textEditor.getControl()).setTextLimit(60);
		editors[1] = textEditor;
		
		// Column 3 : description (Text with digits only)
		textEditor = new TextCellEditor(table);
		editors[2] = textEditor;
		
		// Column 4: role (Combo Box) 
		editors[3] = new ComboBoxCellEditor(table, new String[]{"Reader", "Writer", "ProjectAdmin"}, SWT.READ_ONLY);

		// Assign the cell editors to the viewer 
		tableViewer.setCellEditors(editors);
		// Set the cell modifier for the viewer
		tableViewer.setCellModifier(new TableCellModifier());
		// Set the default sorter for the viewer 
//		tableViewer.setSorter(new ExampleTaskSorter(ExampleTaskSorter.DESCRIPTION));
		
		int ops = DND.DROP_COPY;
		Transfer[] transfers = new Transfer[]{LocalSelectionTransfer.getTransfer()};
		DropTargetListener dropListener = new DropTargetListener(){

			public void dragEnter(DropTargetEvent event) {
				event.detail = DND.DROP_COPY;
				
			}

			public void dragLeave(DropTargetEvent event) {
				// TODO Auto-generated method stub
				
			}

			public void dragOperationChanged(DropTargetEvent event) {
				// TODO Auto-generated method stub
				
			}

			public void dragOver(DropTargetEvent event) {
				// TODO Auto-generated method stub
				
			}

			public void drop(DropTargetEvent event) {
				WorkspaceManager.getInstance().getAdminConnectionManager().addParticipant(projectInfo, (ACOrgUnit)PropertiesForm.dragNDropObject);
				PropertiesForm.dragNDropObject = null;
			}

			public void dropAccept(DropTargetEvent event) {
				// TODO Auto-generated method stub
				
			}
			
		};
		tableViewer.addDropSupport(ops, transfers, dropListener);
		
	}

	private void createSimpleAttributes() {

		grpAttributes = new Group(this, SWT.V_SCROLL);
		grpAttributes.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				false));
		grpAttributes.setText("Properties");

		grpAttributes.setLayout(new GridLayout(2, false));

		lblName = new Label(grpAttributes, SWT.NONE);
		lblName.setText("Name: ");
		txtName = new Text(grpAttributes, SWT.BORDER);
		txtName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		lblDescription = new Label(grpAttributes, SWT.NONE);
		lblDescription.setText("Description: ");
		txtDescription = new Text(grpAttributes, SWT.BORDER);
		txtDescription.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

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
		projectInfo.eAdapters().add(new AdapterImpl(){

			
		});

	}
	
	private class TabelLabelProvider extends LabelProvider
			implements ITableLabelProvider {

		public Image getColumnImage(Object element, int columnIndex) {
			if (columnIndex == 0){
				return super.getImage(element);
			}else {
				return null;
			}
				
		}

		public String getColumnText(Object element, int columnIndex) {
			ACOrgUnit orgUnit = (ACOrgUnit) element;
			String result = "";
			
			switch(columnIndex){
				case 0 :
					break;
				case 1 : 
					result =  orgUnit.getName();
					break;
				case 2 : 
					result = orgUnit.getDescription();
					break;
				case 3 :
					result = "Reader";
					break;
				default :
					break;
			}
			
			return result;
		}

	}
	
	private class TableCellModifier implements ICellModifier {
				
		public boolean canModify(Object element, String property) {
			return true;
		}

		/**
		 * @see org.eclipse.jface.viewers.ICellModifier#getValue(java.lang.Object, java.lang.String)
		 */
		public Object getValue(Object element, String property) {

			// Find the index of the column
			int columnIndex = Arrays.asList(columnNames).indexOf(property);

			Object result = null;
			ACOrgUnit orgUnit = (ACOrgUnit) element;

			switch (columnIndex) {
				case 0 : // Icon 
					break;
				case 1 : // name 
					result = orgUnit.getName();
					break;
				case 2 : // description 
					result = orgUnit.getDescription();
					break;
					
				case 3 : // role 
					result = new Integer(1);					
					break;
				default :
					result = "";
			}
			return result;	
		}

		/**
		 * @see org.eclipse.jface.viewers.ICellModifier#modify(java.lang.Object, java.lang.String, java.lang.Object)
		 */
		public void modify(Object element, String property, Object value) {	

			// Find the index of the column 
			int columnIndex	= Arrays.asList(columnNames).indexOf(property);
				
			TableItem item = (TableItem) element;
			ACOrgUnit orgUnit = (ACOrgUnit) item.getData();
			String valueString;

			switch (columnIndex) {
				case 0 : // icon 
				   
					break;
				case 1 : // name 
					valueString = ((String) value).trim();
					orgUnit.setName(valueString);
					break;
				case 2 : // description 
					valueString = ((String) value).trim();
					orgUnit.setDescription(valueString);
					break;
					
				case 3 : // role
					break;
				default :
			}
		}
	}

	private class TableContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			EList<ACOrgUnit> participants = WorkspaceManager.getInstance()
			.getAdminConnectionManager().getParticipants(
					(ProjectInfo) inputElement);
			return participants.toArray(new ACOrgUnit[participants.size()]);
		}

		public void dispose() {
			
			
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			
			
		}
		
	}

}
