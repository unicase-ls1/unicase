package org.unicase.ui.stem.views.statusview;


import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.unicase.model.ModelElement;
import org.unicase.model.task.Assignable;
import org.unicase.model.task.util.MEState;
import org.unicase.ui.common.TableViewerColumnSorter;
import org.unicase.ui.common.commands.ActionHelper;

public class FlatTabComposite extends Composite {

	private TableViewer tableViewer;
	private ModelElement input;
	
	public FlatTabComposite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new GridLayout());
		createTable();
	}

	private void createTable() {

		tableViewer = new TableViewer(this, SWT.FULL_SELECTION | SWT.BORDER);
		tableViewer.getTable().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));

		tableViewer.setContentProvider(new FlatTabContentProvider());
		
		
		createColumns();
			

		tableViewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection sel = (IStructuredSelection) event
						.getSelection();
				ActionHelper.openModelElement((ModelElement) sel
						.getFirstElement());
			}

		});
	}

	private void createColumns() {
		Table table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableViewerColumn tclmTodo = new TableViewerColumn(tableViewer, SWT.LEAD);
		tclmTodo.getColumn().setText("Todo");
		tclmTodo.getColumn().setWidth(80);
		FlatTabColumnLabelProvider columnLabelProvider = new FlatTabColumnLabelProvider(){
			@Override
			public Image getImage(Object element) {
				
				return adapterFactoryLabelProvider.getImage(element);
			}
		};
		tclmTodo.setLabelProvider(columnLabelProvider);
		new TableViewerColumnSorter(tableViewer, tclmTodo, columnLabelProvider){
			@Override
			public int category(Object element) {
				if (element instanceof ModelElement) {
					ModelElement me = (ModelElement) element;
					if (me.getState().equals(MEState.CLOSED)) {
						return 2;
					} else {
						return 1;
					}
				}
				return 3;
			}
		};
				
		TableViewerColumn tclmState = new TableViewerColumn(tableViewer, SWT.LEAD);
		tclmState.getColumn().setText("State");
		tclmState.getColumn().setWidth(80);
		columnLabelProvider = new FlatTabColumnLabelProvider(){

			@Override
			public String getText(Object element) {
				return ((ModelElement) element).getState();
			}

		};
		tclmState.setLabelProvider(columnLabelProvider);
		new TableViewerColumnSorter(tableViewer, tclmState, columnLabelProvider);
		
		TableViewerColumn tclmAsignedTo = new TableViewerColumn(tableViewer, SWT.LEAD);
		tclmAsignedTo.getColumn().setText("Assigned to");
		tclmAsignedTo.getColumn().setWidth(80);
		columnLabelProvider = new FlatTabColumnLabelProvider(){

			@Override
			public String getText(Object element) {
				
				if(element instanceof Assignable){
					Assignable assignable = (Assignable) element;
					if(assignable.getAssignee() != null){
						return assignable.getAssignee().getName();
					}else{
						return "N/A";
					}
					
				}else{
					return "N/A";
				}
				
			}

		};
		tclmAsignedTo.setLabelProvider(columnLabelProvider);
		new TableViewerColumnSorter(tableViewer, tclmAsignedTo, columnLabelProvider);
		
	}

	public void setInput(ModelElement me) {
		this.input = me;
		tableViewer.setInput(me);
		for(TableColumn column : tableViewer.getTable().getColumns()){
			column.pack();
		}
	}

	
	
}
