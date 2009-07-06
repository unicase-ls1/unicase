package org.unicase.workspace.edit.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.validation.marker.MarkerUtil;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.unicase.model.validation.ValidationClientSelector;
import org.unicase.workspace.ProjectSpace;

/**
 * Handler to validate the project.
 * 
 * @author unicase
 * 
 */
public class ValidateHandler extends ProjectActionHandler {

	private static String markerType = "org.unicase.model.validation.marker";

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

		// MultiStatus multi = new MultiStatus(
		// "org.unicase.model", 1, status.getChildren(),
		// "Problems were found by validation", null);
		// //
//		try {
//			MarkerUtil.createMarkers(status);
//		} catch (CoreException e) {
//			// log this ...
//			e.printStackTrace();
//		}

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IResource resource = workspace.getRoot();
		
		try {
			resource.deleteMarkers(markerType, true, 5);
		} catch (CoreException e1) {
			e1.printStackTrace();
		}

		if (status.isMultiStatus()) {
			for (IStatus stat : status.getChildren()) {
				try {
					IMarker marker = (IMarker) resource
							.createMarker(markerType);
					marker.setAttribute(IMarker.MESSAGE, "unicase: "
							+ stat.getMessage());
					marker.setAttribute(IMarker.SEVERITY,
							IMarker.SEVERITY_WARNING);
					System.out.println("type: " + marker.getType());
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
