/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.validationview;

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
