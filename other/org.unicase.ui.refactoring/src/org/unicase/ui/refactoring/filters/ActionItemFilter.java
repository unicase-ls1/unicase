/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.filters;

import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.ui.refactoring.ui.util.RefactoringDialogHelper;
import org.unicase.ui.validation.view.filters.ValidationFilter;

/**
 * @author pfeifferc
 */
public class ActionItemFilter extends ValidationFilter {
	
	private ActionItem actionItem = TaskFactory.eINSTANCE.createActionItem();
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription() {
		return this.getClass().getSimpleName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage() {
		return RefactoringDialogHelper.getLabelProvider().getImage(actionItem);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return this.getClass().getSimpleName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		IConstraintStatus constraintStatus = (IConstraintStatus) element;
		return constraintStatus.getTarget() instanceof ActionItem;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean init() {
		return true;
	}
}
