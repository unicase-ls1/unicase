package org.unicase.model.search.views.editingsupport;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.unicase.model.search.model.Condition;

public class ConditionEditingSupport extends EditingSupport {
	
	private CellEditor editor;
	private int column;
	
	public ConditionEditingSupport(ColumnViewer viewer, int column) {
		super(viewer);
		
		// TODO: use hashmaps to assign index to value
		String[] conditions = new String[] { "AND", "OR", "NOT" };
		String[] operator = new String[] { "==", "!=" };
		// TODO: fill up with real data
		String[] fields = new String[] { "description", "name" };
		
		switch (column) {
		case 0:
			editor = new ComboBoxCellEditor(((TableViewer) viewer).getTable(), conditions);
			editor.setStyle(SWT.READ_ONLY);
			break;
		case 1:
			editor = new ComboBoxCellEditor(((TableViewer) viewer).getTable(), fields);
			editor.setStyle(SWT.READ_ONLY);
			break;
		case 2:
			editor = new ComboBoxCellEditor(((TableViewer) viewer).getTable(), operator);
			editor.setStyle(SWT.READ_ONLY);
			break;
		case 3:
			editor = new TextCellEditor(((TableViewer) viewer).getTable());
			break;
		}
		this.column = column;
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		return editor;
	}

	@Override
	protected Object getValue(Object element) {
		Condition c = (Condition) element;
		switch (this.column) {
		case 0:
			if (c.getCondition().equals("AND")) {
				return 0;
			} else if (c.getCondition().equals("OR")) {
				return 1;
			} else if (c.getCondition().equals("NOT")) {
				return 2;
			}
		case 1:
			if (c.getField().equals("description")) {
				return 0;
			} else if (c.getField().equals("name")) {
				return 1;
			}
		case 2:
			if (c.getOperator().equals("==")) {
				return 0;
			} else if (c.getOperator().equals("!=")) {
				return 1;
			}
		case 3:
			return c.getValue();
		}
		return null;
	}

	@Override
	protected void setValue(Object element, Object value) {
		Condition c = (Condition) element;
		// TODO: read value from editor!
		switch (this.column) {
		case 0:
			if (((Integer) value) == 0) {
				c.setCondition("AND");
			} else if (((Integer) value) == 1) {
				c.setCondition("OR");
			} else if (((Integer) value) == 2) {
				c.setCondition("NOT");
			}
			break;
		case 1:
			if (((Integer) value) == 0) {
				c.setField("description");
			} else if (((Integer) value) == 1) {
				c.setField("name");
			}
			break;
		case 2:
			if (((Integer) value) == 0) {
				c.setCondition("==");
			} else if (((Integer) value) == 1) {
				c.setCondition("!=");
			}
			break;
		case 3:
			c.setValue(String.valueOf(value));
			break;
		}
		getViewer().update(element, null);
	}

}
