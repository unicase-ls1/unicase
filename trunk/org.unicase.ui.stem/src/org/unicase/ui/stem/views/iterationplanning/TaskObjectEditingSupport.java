package org.unicase.ui.stem.views.iterationplanning;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;

public class TaskObjectEditingSupport extends EditingSupport {

	public TaskObjectEditingSupport(ColumnViewer viewer) {
		super(viewer);
		// JH Auto-generated constructor stub
	}

	@Override
	protected boolean canEdit(Object element) {
		// JH Auto-generated method stub
		return false;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		// JH Auto-generated method stub
		return null;
	}

	@Override
	protected Object getValue(Object element) {
		// JH Auto-generated method stub
		return null;
	}

	@Override
	protected void setValue(Object element, Object value) {
		//JH Auto-generated method stub

	}

}
