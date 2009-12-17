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
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.unicase.metamodel.util.ValidationClientSelector;
import org.unicase.ui.common.util.ActionHelper;
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
		final ProjectSpace projectSpace = ActionHelper.getProjectSpace(event);
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				validateWithoutCommand(projectSpace);
			}
		}.run();
		return null;
	}

	private void validateWithoutCommand(ProjectSpace projectSpace) {

		ValidationClientSelector.setRunning(true);

		IBatchValidator validator = (IBatchValidator) ModelValidationService
				.getInstance().newValidator(EvaluationMode.BATCH);
		validator.setIncludeLiveConstraints(true);

		IStatus status = validator.validate(projectSpace.getProject());

		ValidationClientSelector.setRunning(false);

		// MultiStatus multi = new MultiStatus(
		// "org.unicase.model", 1, status.getChildren(),
		// "Problems were found by validation", null);
		// //
		// try {
		// MarkerUtil.createMarkers(status);
		// } catch (CoreException e) {
		// // log this ...
		// e.printStackTrace();
		// }

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
