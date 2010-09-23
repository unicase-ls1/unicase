/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.validation.view.actions;

import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.unicase.ui.validation.view.filters.ValidationFilter;
import org.unicase.ui.validation.view.providers.ValidationFilterLabelProvider;
import org.unicase.ui.validation.view.util.ValidationViewHelper;

/**
 * The filter dialog action.
 * 
 * @author pfeifferc
 */
public final class OpenFilterDialogAction extends Action {

	private Shell shell;
	private TableViewer tableViewer;

	/**
	 * The {@link OpenFilterDialogAction} constructor.
	 * 
	 * @param shell the {@link Shell}
	 * @param tableViewer the {@link TableViewer}
	 */
	public OpenFilterDialogAction(Shell shell, TableViewer tableViewer) {
		this.shell = shell;
		this.tableViewer = tableViewer;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		ListSelectionDialog validationFilterList = new ListSelectionDialog(
			shell,
			ValidationViewHelper.getFiltersFromExtensionPoint(),
			new ArrayContentProvider(),
			new ValidationFilterLabelProvider(),
			"Please choose one or more filters. The filters are additive. \nThe violation will only be excluded if all filters filter it.");
		validationFilterList.setTitle("Choose one or more filters");
		validationFilterList.setInitialSelections(tableViewer.getFilters());
		validationFilterList.open();
		if (validationFilterList.getReturnCode() == Status.OK) {
			removeAllFilters();
			for (Object object : validationFilterList.getResult()) {
				if (object instanceof ValidationFilter) {
					ValidationFilter validationFilter = (ValidationFilter) object;
					applyFilter(validationFilter);
				}
			}
		}
	}

	private void applyFilter(ValidationFilter validationFilter) {
		tableViewer.addFilter(validationFilter);
	}

	private void removeAllFilters() {
		tableViewer.resetFilters();
	}
}