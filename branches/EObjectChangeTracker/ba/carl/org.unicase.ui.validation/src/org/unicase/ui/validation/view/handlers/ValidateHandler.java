/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.validation.view.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.validation.view.ValidationView;

/**
 * Handler to validate the project.
 * 
 * @author pfeifferc
 */
public class ValidateHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		ValidationView validationView = null;
		try {
			EObject selectedEObject = ActionHelper.getSelectedEObject();
			validationView = (ValidationView) page.showView("org.unicase.ui.validation.validationView");
			validationView.updateTable(selectedEObject);
		} catch (PartInitException e) {
			DialogHandler.showExceptionDialog(e);
		}
		return null;
	}
}
