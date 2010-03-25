/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.common.util.ValidationClientSelector;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Handler to validate the project.
 * 
 * @author unicase
 */
public class ValidateHandler extends AbstractHandler {

	private static String markerType = "org.unicase.model.validation.marker";

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EObject toValidate = ActionHelper.getModelElement(event);
		if (toValidate == null) {
			ProjectSpace projectSpace = ActionHelper.getProjectSpace(event);
			if (projectSpace != null && projectSpace.getProject() != null) {
				toValidate = projectSpace.getProject();
			}
		}
		if (toValidate != null) {
			final EObject validate = toValidate;
			new UnicaseCommand() {

				@Override
				protected void doRun() {
					validateWithoutCommand(validate);
				}

			}.run();
		}
		return null;
	}

	private void validateWithoutCommand(EObject object) {
		ValidationClientSelector.setRunning(true);
		IBatchValidator validator = (IBatchValidator) ModelValidationService
				.getInstance().newValidator(EvaluationMode.BATCH);
		validator.setIncludeLiveConstraints(true);
		IStatus status = validator.validate(object);
		ValidationClientSelector.setRunning(false);
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
					IMarker marker = resource.createMarker(markerType);
					marker.setAttribute(IMarker.MESSAGE, "unicase: "
							+ stat.getMessage());
					marker.setAttribute(IMarker.SEVERITY,
							IMarker.SEVERITY_WARNING);
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
