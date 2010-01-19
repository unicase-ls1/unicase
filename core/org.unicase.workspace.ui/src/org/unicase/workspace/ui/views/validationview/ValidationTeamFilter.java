/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.validationview;

import java.util.Set;

import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;

/**
 * Filter Validations to Team.
 * 
 * @author helming
 */
public class ValidationTeamFilter extends ViewerFilter {

	private Set<OrgUnit> team;

	/**
	 * default constructor.
	 * 
	 * @param user
	 *            The user to whos team it should be filtered.
	 */
	public ValidationTeamFilter(User user) {
		team = OrgUnitHelper.getTeam(user);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (team == null) {
			return true;
		}
		if (element instanceof IConstraintStatus) {
			Object target = ((IConstraintStatus) element).getTarget();
			if (target instanceof ModelElement) {
				String creator = ((ModelElement) target).getCreator();
				for (OrgUnit orgUnit : team) {
					if (orgUnit.getName().equals(creator)) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
