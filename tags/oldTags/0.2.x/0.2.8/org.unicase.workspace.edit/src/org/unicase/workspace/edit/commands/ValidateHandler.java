package org.unicase.workspace.edit.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.unicase.model.validation.ValidationClientSelector;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.ProjectSpace;

/**
 * Handler to validate the project.
 * 
 * @author unicase
 * 
 */
public class ValidateHandler extends ProjectActionHandler {
	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		final ProjectSpace projectSpace = getProjectSpace(event);

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				validateWithoutCommand(projectSpace);
			}

		});
		return null;
	}

	private void validateWithoutCommand(ProjectSpace projectSpace) {

		ValidationClientSelector.setRunning(true);
		
		IBatchValidator validator = (IBatchValidator) ModelValidationService
				.getInstance().newValidator(EvaluationMode.BATCH);
		validator.setIncludeLiveConstraints(true);

		IStatus status = validator.validate(projectSpace);
		
		ValidationClientSelector.setRunning(false);
		
		DialogHandler.showErrorDialog(status.toString());
	}
}
