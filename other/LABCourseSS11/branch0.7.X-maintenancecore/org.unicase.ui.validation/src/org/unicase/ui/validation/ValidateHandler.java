/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.validation;

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
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.ecp.model.NoWorkspaceException;
import org.unicase.ui.common.commands.ECPCommand;
import org.unicase.ui.util.ActionHelper;

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
		try {
			if (ECPWorkspaceManager.getInstance().getWorkSpace().isRootObject(toValidate)) {
				toValidate = ECPWorkspaceManager.getInstance().getWorkSpace().getActiveProject().getRootContainer();
			}
		} catch (NoWorkspaceException e) {
			Activator.getDefault().logException("No Workspace found for validation!", e);
			return null;
		}
		if (toValidate instanceof Object) {
			// ProjectSpace projectSpace = ActionHelper.getEventElementByClass(event, ProjectSpace.class);
			// // check null for project space, when triggering validation run too
			// // many times too quickly in a row, there might be an NPE otherwise.
			// if (projectSpace != null && projectSpace.getProject() != null) {
			// toValidate = projectSpace.getProject();
			// }
		}
		// if still null, do nothing, otherwise trigger validation run
		if (toValidate != null) {
			final EObject validate = toValidate;
			new ECPCommand(validate) {
				@Override
				protected void doRun() {
					validateWithoutCommand(validate);
				}
			}.run(false);
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
			Activator.getDefault().logException("Validate handler encountered an exception", e);
		}
		if (status.isMultiStatus()) {
			for (IStatus stat : status.getChildren()) {
				try {
					IMarker marker = resource.createMarker(markerType);
					marker.setAttribute(IMarker.MESSAGE, "unicase: " + stat.getMessage());
					marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
				} catch (CoreException e) {
					Activator.getDefault().logException("Validate handler encountered an exception", e);
				}
			}
		}
	}
}
