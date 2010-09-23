/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.filters;

import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.refactoring.Activator;
import org.unicase.ui.validation.view.filters.ValidationFilter;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;

/**
 * The severity filter.
 * 
 * @author pfeifferc
 */
public class CreatorFilter extends ValidationFilter {

	/**
	 * default constructor.
	 */
	public CreatorFilter() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription() {
		return "Shows only items created by you";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage() {
		return Activator.getImageDescriptor("icons/defaultfiltericon.png").createImage();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return getClass().getSimpleName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		IConstraintStatus constraintStatus = (IConstraintStatus) element;
		UnicaseModelElement target = (UnicaseModelElement) constraintStatus.getTarget();
		String creator = target.getCreator();
		Workspace workspace =  WorkspaceManager.getInstance().getCurrentWorkspace();
		ProjectSpace activeProjectSpace = workspace.getActiveProjectSpace();
		Usersession usersession = activeProjectSpace.getUsersession();
		String username = usersession.getUsername();
		return creator.equals(username);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean init() {
		return true;
	}
}
