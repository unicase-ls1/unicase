/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.filters;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.refactoring.Activator;
import org.unicase.ui.validation.view.filters.ValidationFilter;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * A filter to filter workitems lists to a certain ACUser.
 * 
 * @author helming
 */
public class ACUserFilter extends ValidationFilter {

	private ACUser acUser;

	/**
	 * default constructor.
	 */
	public ACUserFilter() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription() {
		return "The access control user filter";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage() {
		return Activator.getImageDescriptor("icons/validation.png").createImage();
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
		EObject target = constraintStatus.getTarget();
		if (target instanceof ModelElement) {
			ModelElement modelElement = (ModelElement) target;
			if (modelElement.getCreator().equals(acUser.getName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean init() {
		ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace();
		if (activeProjectSpace.getUsersession() != null) {
			this.acUser = activeProjectSpace.getUsersession().getACUser();
			return true;
		}
		return false;
	}

}
