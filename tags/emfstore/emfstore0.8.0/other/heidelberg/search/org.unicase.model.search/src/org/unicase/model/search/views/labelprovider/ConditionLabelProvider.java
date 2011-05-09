package org.unicase.model.search.views.labelprovider;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.search.model.Condition;
import org.unicase.model.search.views.editingsupport.ConditionEditingSupport;

/**
 * Label provider for the conditions table.
 * @author Markus Fischer
 *
 */
public class ConditionLabelProvider extends LabelProvider implements
		ITableLabelProvider {

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
	 */
	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
	 */
	@Override
	public String getColumnText(Object element, int columnIndex) {
		Condition c = (Condition) element;
		switch (columnIndex) {
		case ConditionEditingSupport.COLUMN_CONDITION:
			return c.getCondition();
		case ConditionEditingSupport.COLUMN_FIELD:
			return c.getField();
		case ConditionEditingSupport.COLUMN_OPERATOR:
			return c.getOperator();
		case ConditionEditingSupport.COLUMN_VALUE:
			return c.getValue();
		default:
			return null;
		}
	}

}
