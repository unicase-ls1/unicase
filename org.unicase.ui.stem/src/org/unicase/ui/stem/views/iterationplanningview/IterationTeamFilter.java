/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.iterationplanningview;

import org.eclipse.jface.viewers.Viewer;
import org.unicase.model.organization.User;
import org.unicase.ui.unicasecommon.common.filter.TeamFilter;

/**
 * Class to filter the iteration planning view to my team.
 * 
 * @author helming
 */
public class IterationTeamFilter extends TeamFilter {

	/**
	 * default constructor.
	 * 
	 * @param user The user to whos team should be filtered.
	 */
	public IterationTeamFilter(User user) {
		super(user);
	}

	/**
	 * Backlog is always shown. {@inheritDoc}
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof Backlog) {
			return true;
		}
		return super.select(viewer, parentElement, element);
	}

}
