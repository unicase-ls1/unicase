/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.requirementexport;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.metamodel.Project;
import org.unicase.model.document.LeafSection;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.NonFunctionalRequirement;
import org.unicase.workspace.ProjectSpace;

/**
 * Handler for the ExportRequirement command. This handler will copy the selected requirement to a project or section
 * that the user chooses in a {@link ExportRequirementDialog dialog}.
 * 
 * @author mharut
 */
public class ExportRequirementHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		Object selectedObject = validateSelection(event);

		if (selectedObject instanceof FunctionalRequirement) {
			FunctionalRequirement req = (FunctionalRequirement) selectedObject;

			// open dialog to let user choose a target
			ExportRequirementDialog dialog = new ExportRequirementDialog(Display.getCurrent().getActiveShell());
			if (dialog.open() == Window.OK) {
				Object result = dialog.getFirstResult();
				if (result instanceof ProjectSpace) {
					// project space was selected -> use its project as target
					Project project = ((ProjectSpace) result).getProject();
					new RequirementExportOperation().copyFunctionalRequirement(req, project);
				} else if (result instanceof LeafSection) {
					new RequirementExportOperation().copyFunctionalRequirement(req, (LeafSection) result);
				}
			}
		} else if (selectedObject instanceof NonFunctionalRequirement) {
			NonFunctionalRequirement req = (NonFunctionalRequirement) selectedObject;

			// open dialog to let user choose a target
			ExportRequirementDialog dialog = new ExportRequirementDialog(Display.getCurrent().getActiveShell());
			if (dialog.open() == Window.OK) {
				Object result = dialog.getFirstResult();
				if (result instanceof ProjectSpace) {
					// project space was selected -> use its project as target
					Project project = ((ProjectSpace) result).getProject();
					new RequirementExportOperation().copyNonFunctionalRequirement(req, project);
				} else if (result instanceof LeafSection) {
					new RequirementExportOperation().copyNonFunctionalRequirement(req, (LeafSection) result);
				}
			}
		} else {
			throw new IllegalArgumentException("Selected object was no requirement!");
		}

		return null;
	}

	private Object validateSelection(ExecutionEvent event) {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection strucSelection = (IStructuredSelection) selection;
			if (!strucSelection.isEmpty()) {
				return strucSelection.getFirstElement();
			}
		}
		throw new IllegalArgumentException("Selection was invalid!");
	}

}
