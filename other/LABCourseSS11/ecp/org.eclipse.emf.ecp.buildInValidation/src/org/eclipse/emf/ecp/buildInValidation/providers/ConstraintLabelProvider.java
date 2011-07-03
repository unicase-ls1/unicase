package org.eclipse.emf.ecp.buildInValidation.providers;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.viewers.ColumnLabelProvider;

/**
 * ColumnLabelProvider showing the constraint name.
 * 
 * @author Carmen Carlan
 * 
 */
public class ConstraintLabelProvider extends ColumnLabelProvider {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof IStatus) {
			IStatus constraint = (IStatus) element;
			return constraint.getMessage();
		}
		return super.getText(element);
	}

}
