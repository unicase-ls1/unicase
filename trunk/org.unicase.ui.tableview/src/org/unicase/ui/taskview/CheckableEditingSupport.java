package org.unicase.ui.taskview;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.unicase.model.task.Checkable;

public class CheckableEditingSupport extends EditingSupport {

	private CheckboxCellEditor ce;

	public CheckableEditingSupport(TableViewer viewer) {
		super(viewer);
	}

	@Override
	protected boolean canEdit(Object element) {
		return (element instanceof Checkable);
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		if (element instanceof Checkable) {
			return new CheckboxCellEditor(getViewer().getTable());
		} else {
			return null;
		}
	}

	@Override
	public TableViewer getViewer() {
		return (TableViewer) super.getViewer();
	}

	@Override
	protected Object getValue(Object element) {
		if (element instanceof Checkable) {
			return ((Checkable) element).isChecked();
		}

		else {
			return null;
		}
	}

	@Override
	protected void setValue(Object element, Object value) {
		if ((element instanceof Checkable) && (value instanceof Boolean)) {
			final Checkable c = (Checkable) element;
			final boolean isChecked = (Boolean) value;
			TransactionalEditingDomain domain = TransactionUtil
					.getEditingDomain(c);
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				protected void doExecute() {
					c.setChecked(isChecked);
				}
			});
		}
		getViewer().refresh(element);
	}
}
