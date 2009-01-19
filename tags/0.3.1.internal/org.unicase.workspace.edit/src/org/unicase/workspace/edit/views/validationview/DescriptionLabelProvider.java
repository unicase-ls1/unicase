package org.unicase.workspace.edit.views.validationview;

import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.jface.viewers.ColumnLabelProvider;

/**
 * LbaleProvider for the Description Column.
 * 
 * @author helming
 * 
 */
public class DescriptionLabelProvider extends ColumnLabelProvider {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof IConstraintStatus) {
			IConstraintStatus constraint = (IConstraintStatus) element;
			return constraint.getMessage();
		}
		return super.getText(element);
	}

}
