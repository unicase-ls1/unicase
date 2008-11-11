package org.unicase.ui.esbrowser.dialogs.admin;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryLabelProvider;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.AdminBroker;
import org.unicase.workspace.WorkspaceManager;

public abstract class FormContents extends Composite {

	protected AdminBroker adminBroker;
	
	protected Group grpTable;
	protected Group grpAttributes;

	protected Label lblName;
	protected Text txtName;
	protected Label lblDescription;
	protected Text txtDescription;

	protected Table table;
	protected TableViewer tableViewer;

	//protected AdapterFactoryEditingDomain editingDomain;

	public FormContents(Composite parent, int style, AdminBroker adminBroker) {
		super(parent, style);
		this.adminBroker = adminBroker;
//		editingDomain = new AdapterFactoryEditingDomain(
//				new ModelAdapterFactory(), new BasicCommandStack());
	}

	protected void createControls() {
		this.setLayout(new GridLayout());

		createSimpleAttributes();
		createTableGroup();
		createButtons(grpTable);

	}

	protected void createSimpleAttributes() {
		grpAttributes = new Group(this, SWT.V_SCROLL);
		grpAttributes.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				false));
		grpAttributes.setText("Properties");

		grpAttributes.setLayout(new GridLayout(2, false));

		lblName = new Label(grpAttributes, SWT.NONE);
		lblName.setText("Name: ");
		txtName = new Text(grpAttributes, SWT.BORDER);
		
		txtName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		txtName.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
			}

			public void focusLost(FocusEvent e) {
				saveOrgUnitAttributes();

			}

		});
		// txtName.setEnabled(false);

		lblDescription = new Label(grpAttributes, SWT.NONE);
		lblDescription.setText("Description: ");
		txtDescription = new Text(grpAttributes, SWT.BORDER);
		txtDescription.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		txtDescription.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
			}

			public void focusLost(FocusEvent e) {
				saveOrgUnitAttributes();

			}

		});
		// txtDescription.setEnabled(false);

	}

	protected void saveOrgUnitAttributes() {
	}

	protected void createTableGroup() {
		grpTable = new Group(this, SWT.NONE);
		grpTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		grpTable.setText("Table");
		grpTable.setLayout(new GridLayout(5, true));

		createTable(grpTable);
		createTableViewer();

	}

	protected void createTableViewer() {
		tableViewer = new TableViewer(table);
		tableViewer.setUseHashlookup(true);
		tableViewer.setContentProvider(new TableContentProvider());
		tableViewer.setLabelProvider(new TableLabelProvider());
		addDragNDropSupport();

	}

	protected void createTable(Composite parent) {

		int style = SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL
				| SWT.FULL_SELECTION;

		table = new Table(parent, style);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalSpan = 5;
		table.setLayoutData(gridData);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		// 1st column with image
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

	protected void createButtons(Composite parent) {
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
			@Override
			public void widgetSelected(SelectionEvent e) {
				addOrgUnit(null);
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
			@Override
			public void widgetSelected(SelectionEvent e) {
				ACOrgUnit ou = (ACOrgUnit) ((IStructuredSelection) tableViewer
						.getSelection()).getFirstElement();
				if (ou != null) {
					removeOrgUnit(ou);
				}
			}
		});

		// Button btn = new Button(parent, SWT.PUSH | SWT.CENTER);
		// btn.setText("add test users and groups");
		// gridData = new GridData(SWT.END);
		// gridData.widthHint = 80;
		// btn.setLayoutData(gridData);
		//
		// btn.addSelectionListener(new SelectionAdapter() {
		//
		// // Remove the selection and refresh the view
		// public void widgetSelected(SelectionEvent e) {
		// // ACOrgUnit ou = (ACOrgUnit) ((IStructuredSelection) tableViewer
		// // .getSelection()).getFirstElement();
		// // if (ou != null) {
		// // removeOrgUnit(ou);
		// // }
		// MessageDialog.openInformation(getShell(), "",
		// "create test user/groups");
		// }
		// });

	}

	protected void addDragNDropSupport() {
		int ops = DND.DROP_COPY;
		Transfer[] transfers = new Transfer[] { LocalSelectionTransfer
				.getTransfer() };
		DropTargetListener dropListener = new DropTargetListener() {
			public void dragEnter(DropTargetEvent event) {
				if (PropertiesForm.dragSource.equals("Projects")) {
					event.detail = DND.DROP_NONE;
				} else if (PropertiesForm.dragSource.equals("Users")) {
					DropTarget dropTarget = (DropTarget) event.getSource();
					Control targetControl = dropTarget.getControl();
					Composite targetParent = targetControl.getParent();
					String target = "";
					if (targetParent instanceof Group) {
						target = ((Group) targetParent).getText();
					}
					if (target.equals("Groups")) {
						event.detail = DND.DROP_NONE;
					} else {
						event.detail = DND.DROP_COPY;
					}

				} else {
					event.detail = DND.DROP_COPY;
				}
			}

			public void drop(DropTargetEvent event) {
				if (PropertiesForm.dragNDropObject != null) {
					if (PropertiesForm.dragNDropObject instanceof ACOrgUnit) {
						ACOrgUnit orgUnit = (ACOrgUnit) PropertiesForm.dragNDropObject;
						addOrgUnit(orgUnit);
						PropertiesForm.dragNDropObject = null;
						tableViewer.refresh();
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
		tableViewer.addDropSupport(ops, transfers, dropListener);

		ops = DND.DROP_MOVE;
		DragSourceListener dragListener = new DragSourceListener() {
			public void dragFinished(DragSourceEvent event) {
				tableViewer.refresh();
				PropertiesForm.dragNDropObject = null;
			}

			public void dragSetData(DragSourceEvent event) {
				EObject eObject = getSelectedItem();
				if (eObject != null) {
					if (eObject instanceof ACOrgUnit) {
						ACOrgUnit orgUnit = (ACOrgUnit) eObject;
						PropertiesForm.dragNDropObject = orgUnit;
					}
				}
			}

			public void dragStart(DragSourceEvent event) {
			}
		};
		tableViewer.addDragSupport(ops, transfers, dragListener);
	}

	protected abstract void addOrgUnit(ACOrgUnit orgUnit);

	protected abstract void removeOrgUnit(ACOrgUnit orgUnit);

	public void updateControls(EObject input) {
		if (input == null) {
			this.grpAttributes.setVisible(false);
			this.grpTable.setVisible(false);
		} else if (!grpAttributes.isVisible()) {
			this.grpAttributes.setVisible(true);
			this.grpTable.setVisible(true);
		}

	}

	protected Object[] showDialog(Collection<ACOrgUnit> content, String title) {
		ElementListSelectionDialog dlg = new ElementListSelectionDialog(this
				.getShell(), new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));

		dlg.setElements(content.toArray(new Object[content.size()]));
		dlg.setTitle(title);
		dlg.setBlockOnOpen(true);
		dlg.setMultipleSelection(true);
		Object[] result = new Object[0];
		if (dlg.open() == Window.OK) {
			result = dlg.getResult();
		}
		return result;
	}

	private EObject getSelectedItem() {
		EObject result = null;
		ISelection sel = tableViewer.getSelection();
		IStructuredSelection ssel = null;
		if (sel != null) {
			ssel = (IStructuredSelection) sel;
		}

		if (ssel != null) {
			Object obj = ssel.getFirstElement();
			result = (ACOrgUnit) obj;
		}
		return result;
	}

	private class TableContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			Object[] result = new Object[0];
			try {
				if (inputElement instanceof ACUser) {
					List<ACGroup> groups;

					groups = adminBroker.getGroups(((ACUser) inputElement)
							.getId());
					result = groups.toArray(new ACOrgUnit[groups.size()]);

				} else if (inputElement instanceof ACGroup) {
					List<ACOrgUnit> members = adminBroker
							.getMembers(((ACGroup) inputElement).getId());
					result = members.toArray(new ACOrgUnit[members.size()]);

				} else if (inputElement instanceof ProjectInfo) {
					List<ACOrgUnit> participants = adminBroker
							.getParticipants(((ProjectInfo) inputElement)
									.getProjectId());
					result = participants.toArray(new ACOrgUnit[participants
							.size()]);

				}
			} catch (EmfStoreException e) {
				// ZH Auto-generated catch block
				e.printStackTrace();
			}
			return result;
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

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			if (columnIndex == 0) {
				return super.getImage(element);
			} else {
				return null;
			}

		}

		@Override
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

}// FormContent
