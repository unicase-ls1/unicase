package org.unicase.iterationplanner.ui.wizard.input;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;

public class UserAvailabilityEditingSupport extends EditingSupport {

	private int iterNumber;
	private TextCellEditor textCellEditor;

	public UserAvailabilityEditingSupport(TableViewer viewer, int iterNumber) {
		super(viewer);
		this.iterNumber = iterNumber;
		this.textCellEditor = new TextCellEditor(viewer.getTable());
	}

	@Override
	protected boolean canEdit(Object element) {
		return element instanceof UserAvailability;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		return textCellEditor;
	}

	@Override
	protected Object getValue(Object element) {
		if(element instanceof UserAvailability){
			return String.valueOf(((UserAvailability) element).getAvailability(iterNumber));
		}
		return "";
	}

	@Override
	protected void setValue(Object element, Object value) {
		if(element instanceof UserAvailability){
			if (value instanceof String) {
				String strValue = value.toString();
				if (!strValue.equals("") && strValue.matches("[0-9]*")) {
					int parseInt = Integer.parseInt(strValue);
					((UserAvailability) element).setAvailability(iterNumber, parseInt);
					getViewer().refresh();
				}
			}
		}
	}

}
