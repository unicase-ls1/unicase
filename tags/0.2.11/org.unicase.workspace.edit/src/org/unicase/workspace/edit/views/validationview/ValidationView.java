package org.unicase.workspace.edit.views.validationview;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.ModelElement;
import org.unicase.ui.common.commands.ActionHelper;

/**
 * Validation view.
 * 
 * @author wesendonk
 */
public class ValidationView extends ViewPart {

	private TableViewer tableViewer;

	/**
	 * Default constructor.
	 */
	public ValidationView() {
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {
		tableViewer = new TableViewer(parent, SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL
				| SWT.FULL_SELECTION);
		createTable();
		hookDoubleClickAction();
	}

	private void createTable() {
		Table table = tableViewer.getTable();
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalSpan = 5;
		table.setLayoutData(gridData);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		TableColumn column = new TableColumn(table, SWT.CENTER, 0);
		column.setText("Severity");
		column.setWidth(100);

		column = new TableColumn(table, SWT.LEFT, 1);
		column.setText("Description");
		column.setWidth(300);

		column = new TableColumn(table, SWT.LEFT, 2);
		column.setText("ModelElement");
		column.setWidth(200);
		
		//content provider
		tableViewer.setContentProvider(new ValidationContentProvider());
		
		//label provider
		tableViewer.setLabelProvider(new ValidationLableProvider());		
	}

	private void hookDoubleClickAction() {
		tableViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				EObject me = ((IConstraintStatus)selection.getFirstElement()).getTarget();
				if(me instanceof ModelElement) {					
					ActionHelper.openModelElement((ModelElement) me, tableViewer.getClass().getName());
				}
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
	}

	/**
	 * Updates the validation view table.
	 * 
	 * @param validationResults validation results.
	 */
	public void updateTable(List<IConstraintStatus> validationResults) {
		tableViewer.setInput(validationResults);
	}

}
