package org.unicase.workspace.edit.views.validationview;

import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.unicase.model.ModelElement;
import org.unicase.model.organization.User;

/**
 * Filter Validations to user.
 * 
 * @author helming
 */
public class ValidationUserFilter extends ViewerFilter {

	private final User user;

	/**
	 * default constructor.
	 * 
	 * @param user The user on which validations should be filtered
	 */
	public ValidationUserFilter(User user) {
		this.user = user;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (user == null) {
			return true;
		}
		if (element instanceof IConstraintStatus) {
			Object target = ((IConstraintStatus) element).getTarget();
			if (target instanceof ModelElement) {
				String creator = ((ModelElement) target).getCreator();
				if (user.getName().equals(creator)) {
					return true;
				}
			}
		}
		return false;
	}

}
