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
import org.unicase.util.ActionHelper;
import org.unicase.util.ValidationClientSelector;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Handler to validate the project.
 * 
 * @author pfeifferc
 */
public class ValidateHandler extends AbstractHandler {

	/**
	 * The marker type.
	 */
	private static String markerType = "org.unicase.model.validation.marker";

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// the object that is to be validated
		EObject toValidate = ActionHelper.getModelElement(event);
		// check if null, in which case the project will be used instead
		if (toValidate == null) {
			ProjectSpace projectSpace = ActionHelper.getEventElementByClass(event, ProjectSpace.class);
			// check null for project space, when triggering validation run too
			// many times too quickly in a row, there might be an NPE otherwise.
			if (projectSpace != null && projectSpace.getProject() != null) {
				toValidate = projectSpace.getProject();
			}
		}
		// if still null, do nothing, otherwise trigger validation run
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

	/**
	 * Perform validation run.
	 * 
	 * @param object the
	 */
	private void validateWithoutCommand(EObject object) {
		ValidationClientSelector.setRunning(true);
		IBatchValidator validator = (IBatchValidator) ModelValidationService.getInstance().newValidator(
			EvaluationMode.BATCH);
		validator.setIncludeLiveConstraints(true);
		IStatus status = validator.validate(object);
		ValidationClientSelector.setRunning(false);
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IResource resource = workspace.getRoot();
		try {
			resource.deleteMarkers(markerType, true, 5);
		} catch (CoreException e) {
			WorkspaceUtil.logException("Validate handler encountered an exception", e);
		}
		if (status.isMultiStatus()) {
			for (IStatus stat : status.getChildren()) {
				try {
					IMarker marker = resource.createMarker(markerType);
					marker.setAttribute(IMarker.MESSAGE, "unicase: " + stat.getMessage());
					marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
				} catch (CoreException e) {
					WorkspaceUtil.logException("Validate handler encountered an exception", e);
				}
			}
		}
	}
}
