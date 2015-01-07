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
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.unicasecommon.diagram.util.EditPartUtility;

/**
 * This commmand is executed when the users chooses CreateLinkFrom/To existing element This implementation overrides the
 * {@link #useExistingView(View)} method because we don't want to display the message box of the GMF implementation.
 * 
 * @author denglerm
 */
public class CreateViewAndOptionallyElementCommandExt extends CreateViewAndOptionallyElementCommand {

	/**
	 * Creates a new <code>CreateViewAndOptionallyElementCommand</code>.
	 * 
	 * @param elementAdapter Adapts to the element, if null at command execution time, an element is to be created.
	 * @param containerEP The container edit part, where the view request is sent.
	 * @param location The location to create the new view. If null, a default location is used
	 * @param preferencesHint The preference hint that is to be used to find the appropriate preference store from which
	 *            to retrieve diagram preference values. The preference hint is mapped to a preference store in the
	 *            preference registry <@link DiagramPreferencesRegistry>.
	 */
	public CreateViewAndOptionallyElementCommandExt(IAdaptable elementAdapter, IGraphicalEditPart containerEP,
		Point location, PreferencesHint preferencesHint) {
		super(elementAdapter, containerEP, location, preferencesHint);
	}

	/**
	 * . ({@inheritDoc})
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info)
		throws ExecutionException {

		CreateViewRequest createRequest;

		// Create the element first, if one does not exist.
		EObject element = (EObject) getElementAdapter().getAdapter(EObject.class);

		if (element == null) {
			IElementType type = (IElementType) getElementAdapter().getAdapter(IElementType.class);
			if (type == null) {
				return CommandResult.newErrorCommandResult(getLabel());
			}
			createRequest = CreateViewRequestFactory.getCreateShapeRequest(type, getPreferencesHint());
		} else {
			createRequest = new CreateViewRequest(CommandFactory.createViewDescriptorForNode(element));

		}
		createRequest.setLocation(getLocation());

		IGraphicalEditPart target = (IGraphicalEditPart) getContainerEP().getTargetEditPart(createRequest);
		if (target != null) {

			// Command theCmd = CommandFactory.createCreateNodeViewCommand(element, );
			Command theCmd = target.getCommand(createRequest);
			if (element != null
				&& !((MEDiagram) EditPartUtility.getElement(getContainerEP())).getElements().contains(element)) {
				theCmd = theCmd.chain(CommandFactory.createDiagramElementAddCommand(element, getContainerEP(), true));
			}
			setCommand(theCmd);

			View theExistingView = getExistingView(element);

			if (theExistingView != null) {
				setResult(new EObjectAdapter(theExistingView));
				return CommandResult.newOKCommandResult(getResult());
			}

			if (getCommand().canExecute()) {
				ICommand cmd = DiagramCommandStack.getICommand(getCommand());
				cmd.execute(progressMonitor, info);
				if (progressMonitor.isCanceled()) {
					return CommandResult.newCancelledCommandResult();
				} else if (!(cmd.getCommandResult().getStatus().isOK())) {
					return cmd.getCommandResult();
				}
				Object obj = ((List<IAdaptable>) createRequest.getNewObject()).get(0);
				setResult((IAdaptable) obj);
				return CommandResult.newOKCommandResult(getResult());
			}
		}
		return CommandResult.newErrorCommandResult(getLabel());
	}

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	protected boolean useExistingView(View view) {
		return true;
	}

}
