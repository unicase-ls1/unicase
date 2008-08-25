package org.unicase.ui.stem.views.statusview;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.ModelElement;
import org.unicase.model.task.WorkPackage;
import org.unicase.model.task.util.MEState;
import org.unicase.model.task.util.TaxonomyAccess;
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

		createColumns();
		

		tableViewer.setLabelProvider(new TableLabelProvider());
		tableViewer.setContentProvider(new TableContentProvider());

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
				
		TableViewerColumn tclmState = new TableViewerColumn(tableViewer, SWT.LEAD);
		tclmState.getColumn().setText("State");
		tclmState.getColumn().setWidth(80);
	}

	public void setInput(ModelElement me) {
		this.input = me;
		tableViewer.setInput(me);
		for(TableColumn column : tableViewer.getTable().getColumns()){
			column.pack();
		}
	}

	
	
}
