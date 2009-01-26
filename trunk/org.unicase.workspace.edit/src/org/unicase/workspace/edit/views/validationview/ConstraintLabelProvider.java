package org.unicase.workspace.edit.views.validationview;

import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.jface.viewers.ColumnLabelProvider;

/**
 * ColumnLabelProvider showing the constraint name.
 * 
 * @author naughton
 */
public class ConstraintLabelProvider extends ColumnLabelProvider {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof IConstraintStatus) {
			IConstraintStatus constraint = (IConstraintStatus) element;
			return constraint.getConstraint().getDescriptor().getName();
		}
		return super.getText(element);
	}

}
