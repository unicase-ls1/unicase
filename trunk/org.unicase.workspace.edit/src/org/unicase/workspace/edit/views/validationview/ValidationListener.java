package org.unicase.workspace.edit.views.validationview;

import org.eclipse.emf.validation.service.IValidationListener;
import org.eclipse.emf.validation.service.ValidationEvent;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.ui.common.exceptions.DialogHandler;

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
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		ValidationView validationView = null;
		try {
			validationView = (ValidationView) page
				.showView("org.unicase.workspace.edit.views.validationview.ValidationView");
		} catch (PartInitException e) {
			DialogHandler.showExceptionDialog(e);
		}
		validationView.updateTable(event.getValidationResults());
	}

}
