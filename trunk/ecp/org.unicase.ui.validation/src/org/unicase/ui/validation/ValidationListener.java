/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.unicase.ui.validation;

import org.eclipse.emf.validation.service.IValidationListener;
import org.eclipse.emf.validation.service.ValidationEvent;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.ui.util.DialogHandler;

/**
 * Validation listener for the table.
 * 
 * @author wesendonk
 */
public class ValidationListener implements IValidationListener {

	/**
	 * {@inheritDoc}
	 */
	public void validationOccurred(ValidationEvent event) {
		IWorkbenchPage page = PlatformUI.getWorkbench()
		.getActiveWorkbenchWindow().getActivePage();
		ValidationView validationView = null;
		try {
			validationView = (ValidationView) page
			.showView("org.unicase.ui.validation.validationView");
		} catch (PartInitException e) {
			DialogHandler.showExceptionDialog(e);
		}
		validationView.updateTable(event.getValidationResults());
	}
}
