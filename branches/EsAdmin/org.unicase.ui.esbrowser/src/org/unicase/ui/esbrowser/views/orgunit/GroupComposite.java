package org.unicase.ui.esbrowser.views.orgunit;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryLabelProvider;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.workspace.WorkspaceManager;

public class GroupComposite extends Composite {

	private Group grpTable;
	private Group grpAttributes;
	private Label lblName;
	private Text txtName;
	private Label lblDescription;
	private Text txtDescription;

	private Table table;
	private TableViewer tableViewer;
	private ACGroup group;

	public GroupComposite(Composite parent, int style) {
		super(parent, style);
		createControls();
	}

	private void createControls() {
		this.setLayout(new GridLayout());

		createSimpleAttributes();
		createMembersGroup();
		createButtons(grpTable);

	}

	private void createButtons(Composite parent) {
		// Create and configure the "Add" button
		Button add = new Button(parent, SWT.PUSH | SWT.CENTER);
		add.setText("Add...");

		GridData gridData = new GridData();
		gridData.widthHint = 80;
		gridData.horizontalAlignment = GridData.END;
		gridData.horizontalSpan = 4;
		add.setLayoutData(gridData);
		add.addSelectionListener(new SelectionAdapter() {

			// Add a task to the ExampleTaskList and refresh the view
			public void widgetSelected(SelectionEvent e) {
				addMember(null);
			}

		});

		// Create and configure the "Delete" button
		Button remove = new Button(parent, SWT.PUSH | SWT.CENTER);
		remove.setText("Remove");
		gridData = new GridData(SWT.END);
		gridData.widthHint = 80;
		remove.setLayoutData(gridData);

		remove.addSelectionListener(new SelectionAdapter() {

			// Remove the selection and refresh the view
			public void widgetSelected(SelectionEvent e) {
				ACOrgUnit member = (ACOrgUnit) ((IStructuredSelection) tableViewer
						.getSelection()).getFirstElement();
				if (member != null) {
					int index = group.getMembers().indexOf(member);
					group.getMembers().remove(index);
					tableViewer.refresh();
				}
			}
		});

	}

	protected void addMember(ACOrgUnit member) {
		// 1. show a list of all AcOrgUnits that do not participate in this
		// project
		// (get list of all AcOrgUnits, remove those who take part in this
		// Project)
		// 2. add the selected participant to the project
		if (member != null){
			if(!member.equals(group)) {
				group.getMembers().add(member);
			}
			
		} else {
			EList<ACOrgUnit> members = getMembers();
			for (ACOrgUnit orgUnit : members) {
				group.getMembers().add(orgUnit);
			}
		}
		tableViewer.refresh();
		
	}

	private EList<ACOrgUnit> getMembers() {
		// 1. show a list of all AcOrgUnits that do not participate in this
		// project
		// (get list of all AcOrgUnits, remove those who take part in this
		// Project)
		// 2. return the selected participant
		// EClass clazz = eReference.getEReferenceType();
		ElementListSelectionDialog dlg = new ElementListSelectionDialog(this
				.getShell(), new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		// JH: fill only with right elements
		Collection<ACOrgUnit> allOrgUnits = new BasicEList<ACOrgUnit>();
		allOrgUnits.addAll(WorkspaceManager.getInstance()
						.getAdminConnectionManager().getOrgUnits());

		allOrgUnits.removeAll(group.getMembers());
		if(allOrgUnits.contains(group)){
			allOrgUnits.remove(group);
		}
		EList<ACOrgUnit> members = new BasicEList<ACOrgUnit>();
		dlg.setElements(allOrgUnits.toArray(new Object[allOrgUnits.size()]));
		dlg.setTitle("Select an OrgUnit");
		dlg.setBlockOnOpen(true);
		dlg.setMultipleSelection(true);
		if (dlg.open() == Window.OK) {
			Object[] result = dlg.getResult();
			for (Object object : result) {
				if (object instanceof ACOrgUnit) {
					ACOrgUnit orgUnit = (ACOrgUnit) object;
					members.add(orgUnit);
				}
			}
		}

		return members;
	}

	private void createMembersGroup() {
		grpTable = new Group(this, SWT.NONE);
		grpTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		grpTable.setText("Members");
		grpTable.setLayout(new GridLayout(5, true));

		createTable(grpTable);
		createTableViewer();
		tableViewer.setContentProvider(new TableContentProvider());
		tableViewer.setLabelProvider(new TableLabelProvider());

	}

	private void createTableViewer() {
		tableViewer = new TableViewer(table);
		tableViewer.setUseHashlookup(true);

		int ops = DND.DROP_COPY;
		Transfer[] transfers = new Transfer[] { LocalSelectionTransfer
				.getTransfer() };
		DropTargetListener dropListener = new DropTargetListener() {

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
				ACOrgUnit newMember = (ACOrgUnit) PropertiesForm.dragNDropObject;
				addMember(newMember);
				PropertiesForm.dragNDropObject = null;
				tableViewer.refresh();
			}

			public void dropAccept(DropTargetEvent event) {
				// TODO Auto-generated method stub
				
			}

		};
		tableViewer.addDropSupport(ops, transfers, dropListener);
		
		ops  = DND.DROP_MOVE;
		DragSourceListener dragListener = new DragSourceListener(){
			public void dragFinished(DragSourceEvent event) {
				tableViewer.refresh();	
			}

			public void dragSetData(DragSourceEvent event) {
				ACOrgUnit orgUnit = (ACOrgUnit)((IStructuredSelection)tableViewer.getSelection()).getFirstElement();
				//event.data = orgUnit;
				PropertiesForm.dragNDropObject = orgUnit;
			}

			public void dragStart(DragSourceEvent event) {
				
			}
		};
		tableViewer.addDragSupport(ops, transfers, dragListener);
	}

	private void createTable(Composite parent) {

		int style = SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL
				| SWT.FULL_SELECTION;

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
		// column.addSelectionListener(new SelectionAdapter() {
		// public void widgetSelected(SelectionEvent e) {
		// tableViewer.setSorter(new ExampleTaskSorter(
		// ExampleTaskSorter.DESCRIPTION));
		// }
		// });

		// 3rd column with task Owner
		column = new TableColumn(table, SWT.LEFT, 2);
		column.setText("Description");
		column.setWidth(200);
		// Add listener to column so tasks are sorted by owner when clicked
		// column.addSelectionListener(new SelectionAdapter() {
		// public void widgetSelected(SelectionEvent e) {
		// tableViewer.setSorter(new ExampleTaskSorter(
		// ExampleTaskSorter.OWNER));
		// }
		// });
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
		//txtName.setEnabled(false);

		lblDescription = new Label(grpAttributes, SWT.NONE);
		lblDescription.setText("Description: ");
		txtDescription = new Text(grpAttributes, SWT.BORDER);
		txtDescription.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		//txtDescription.setEnabled(false);

	}

	public void updateControls(ACGroup group) {
		this.group = group;

		txtName.setText(group.getName());
		txtDescription.setText(group.getDescription());
		tableViewer.setInput(group);
	}

	private class TableContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			EList<ACOrgUnit> members = group.getMembers();
			return members.toArray(new ACOrgUnit[members.size()]);

		}

		public void dispose() {

		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		}

	}// TableContentProvider

	private class TableLabelProvider extends
			TransactionalAdapterFactoryLabelProvider {

		public TableLabelProvider() {
			super(WorkspaceManager.getInstance().getCurrentWorkspace()
					.getEditingDomain(), new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		}

		public Image getColumnImage(Object element, int columnIndex) {
			if (columnIndex == 0) {
				return super.getImage(element);
			} else {
				return null;
			}

		}

		public String getColumnText(Object element, int columnIndex) {
			ACOrgUnit orgUnit = (ACOrgUnit) element;
			String result = "";

			switch (columnIndex) {
			case 0:
				break;
			case 1:
				result = orgUnit.getName();
				break;
			case 2:
				result = orgUnit.getDescription();
				break;
			}

			return result;
		}

	}// TableLabelProvider

} // GroupComposite

