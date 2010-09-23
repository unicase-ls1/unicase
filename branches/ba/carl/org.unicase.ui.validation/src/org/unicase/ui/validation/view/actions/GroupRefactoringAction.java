/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.validation.view.actions;

import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.dialogs.ListDialog;
import org.unicase.ui.validation.Activator;
import org.unicase.ui.validation.refactoring.RefactoringStrategy;
import org.unicase.ui.validation.view.ValidationView;
import org.unicase.ui.validation.view.util.ValidationViewHelper;

/**
 * The filter dialog action.
 * 
 * @author pfeifferc
 */
public final class GroupRefactoringAction extends Action {

	private static final Image STRATEGY_ICON = Activator.getImageDescriptor("icons/validation.png").createImage();
	private ValidationView validationView;

	/**
	 * Default constructor.
	 * 
	 * @param validationView the
	 */
	public GroupRefactoringAction(ValidationView validationView) {
		this.validationView = validationView;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		ListDialog groupRefactoringDialog = new ListDialog(validationView.getShell());
		groupRefactoringDialog.setTitle("Choose a group refactoring");
		groupRefactoringDialog.setInput(ValidationViewHelper.getGroupRefactoringStrategiesFromExtensionPoint());
		groupRefactoringDialog.setContentProvider(new ArrayContentProvider());
		groupRefactoringDialog.setLabelProvider(new LabelProvider() {

			@Override
			public Image getImage(Object element) {
				return STRATEGY_ICON;
			}

			@Override
			public String getText(Object element) {
				RefactoringStrategy refactoringStrategy = (RefactoringStrategy) element;
				return refactoringStrategy.getName();
			}

		});
		groupRefactoringDialog.open();
		if (groupRefactoringDialog.getReturnCode() == Status.OK && groupRefactoringDialog.getResult().length > 0) {
			RefactoringStrategy refactoringStrategy = (RefactoringStrategy) groupRefactoringDialog.getResult()[0];
			refactoringStrategy.setInvalidEObject(validationView.geteObjectToShowFor());
			refactoringStrategy.startRefactoring();
		}
	}
}