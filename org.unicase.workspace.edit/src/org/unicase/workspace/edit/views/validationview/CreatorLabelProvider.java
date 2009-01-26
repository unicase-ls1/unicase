package org.unicase.workspace.edit.views.validationview;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.unicase.model.ModelElement;

/**
 * LabelProvider for the Creator Column.
 * 
 * @author helming
 */
public class CreatorLabelProvider extends ColumnLabelProvider {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof IConstraintStatus) {
			EObject target = ((IConstraintStatus) element).getTarget();
			if (target instanceof ModelElement) {
				return ((ModelElement) target).getCreator();
			}
		}
		return super.getText(element);
	}

}
