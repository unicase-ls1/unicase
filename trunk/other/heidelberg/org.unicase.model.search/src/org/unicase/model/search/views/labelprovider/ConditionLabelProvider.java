package org.unicase.model.search.views.labelprovider;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.search.model.Condition;

public class ConditionLabelProvider extends LabelProvider implements
		ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		Condition c = (Condition) element;
		switch (columnIndex) {
		case 0:
			return c.getCondition();
		case 1:
			return c.getField();
		case 2:
			return c.getOperator();
		case 3:
			return c.getValue();
		default:
			return null;
		}
	}

}
