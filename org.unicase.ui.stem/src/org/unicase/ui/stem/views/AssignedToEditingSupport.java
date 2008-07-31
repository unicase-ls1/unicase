package org.unicase.ui.stem.views;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;

public class AssignedToEditingSupport extends EditingSupport {

	public AssignedToEditingSupport(ColumnViewer viewer) {
		super(viewer);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean canEdit(Object element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object getValue(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setValue(Object element, Object value) {
		// TODO Auto-generated method stub

	}

}
