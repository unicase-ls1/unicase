/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.diagram.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateViewAndOptionallyElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This is exactly the same class like {@link CreateViewAndOptionallyElementCommand}. It only changes the
 * {@link CreateViewRequest} creation in <code>doExecuteWithResult</code> from <code>semanticHint = ""</code> to
 * <code>semanticHint = null</code>.
 * 
 * @author Michael Haeger
 */
public class CreateViewCommand extends CreateViewAndOptionallyElementCommand {
	/**
	 * Creates a new <code>CreateViewCommand</code>.
	 * 
	 * @param elementAdapter Adapts to the element, if null at command execution time, an element is to be created.
	 * @param containerEP The container edit part, where the view request is sent.
	 * @param location The location to create the new view. If null, a default location is used
	 * @param preferencesHint The preference hint that is to be used to find the appropriate preference store from which
	 *            to retrieve diagram preference values. The preference hint is mapped to a preference store in the
	 *            preference registry <@link DiagramPreferencesRegistry>.
	 */
	public CreateViewCommand(IAdaptable elementAdapter, IGraphicalEditPart containerEP, Point location,
		PreferencesHint preferencesHint) {
		super(elementAdapter, containerEP, location, preferencesHint);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.commands.CreateViewAndOptionallyElementCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info)
		throws ExecutionException {
		// i could not change the creating of CreateViewRequest so copied the hole method
		EObject element = (EObject) getElementAdapter().getAdapter(EObject.class);
		CreateViewRequest createRequest = new CreateViewRequest(new CreateViewRequest.ViewDescriptor(
			new EObjectAdapter(element), Node.class, null, getPreferencesHint()));
		createRequest.setLocation(getLocation());

		IGraphicalEditPart target = (IGraphicalEditPart) getContainerEP().getTargetEditPart(createRequest);
		if (target != null) {
			Command theCmd = target.getCommand(createRequest);
			setCommand(theCmd);

			View theExistingView = getExistingView(element);

			if (theExistingView != null && useExistingView(theExistingView)) {
				setResult(new EObjectAdapter(theExistingView));
				return CommandResult.newOKCommandResult(getResult());
			}
			// Fall-thru and create a new view
			if (getCommand().canExecute()) {
				ICommand cmd = DiagramCommandStack.getICommand(getCommand());
				cmd.execute(progressMonitor, info);
				if (progressMonitor.isCanceled()) {
					return CommandResult.newCancelledCommandResult();
				} else if (!(cmd.getCommandResult().getStatus().isOK())) {
					return cmd.getCommandResult();
				}
				Object obj = ((List<?>) createRequest.getNewObject()).get(0);
				setResult((IAdaptable) obj);
				return CommandResult.newOKCommandResult(getResult());
			}
		}
		// to allow garbage collection
		setContainerEP(null);
		return CommandResult.newErrorCommandResult(getLabel());
	}
}
