/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.diagram.commands;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;

/**
 * @author schroech
 */
public class CreateConnectionViewCommandProvider {

	private final EObject object;
	private final DiagramEditPart host;
	private final IAdaptable sourceAdapter;
	private final IAdaptable targetAdapter;

	private ViewDescriptor viewDescriptor;
	private Command command;

	/**
	 * Default constructor.
	 * 
	 * @param host The {@link EditPart} hosting the object
	 * @param object The {@link EObject} for which the command shall be created
	 * @param sourceAdapter The {@link IAdaptable} adapting to the source object of the connection
	 * @param targetAdapter The {@link IAdaptable} adapting to the target object of the connection
	 */
	public CreateConnectionViewCommandProvider(DiagramEditPart host, EObject object, IAdaptable sourceAdapter,
		IAdaptable targetAdapter) {

		if (host == null) {
			throw new IllegalArgumentException();
		}
		if (object == null) {
			throw new IllegalArgumentException();
		}
		if (sourceAdapter == null) {
			throw new IllegalArgumentException();
		}
		if (targetAdapter == null) {
			throw new IllegalArgumentException();
		}

		this.host = host;
		this.object = object;
		this.sourceAdapter = sourceAdapter;
		this.targetAdapter = targetAdapter;

		createViewDescriptor();
		createCommand();
	}

	private void createCommand() {
		if (viewDescriptor != null) {
			command = CreateConnectionViewRequest.getCreateCommand(viewDescriptor, sourceAdapter, targetAdapter, host);
		}
	}

	private void createViewDescriptor() {
		viewDescriptor = CommandFactory.createViewDescriptorForEdge(getObject());
	}

	/**
	 * @return The object for which commands are provided
	 */
	public EObject getObject() {
		return object;
	}

	/**
	 * @return The DiagramEditPart hosting the object
	 */
	public EditPart getHost() {
		return host;
	}

	/**
	 * @return An {@link IAdaptable} adapting to the target object of the connection
	 */
	public IAdaptable getSourceAdapter() {
		return sourceAdapter;
	}

	/**
	 * @return An {@link IAdaptable} adapting to the source object of the connection
	 */
	public IAdaptable getTargetAdapter() {
		return targetAdapter;
	}

	/**
	 * @return The {@link ViewDescriptor} created during the command creation
	 */
	public ViewDescriptor getViewDescriptor() {
		return viewDescriptor;
	}

	/**
	 * @return The created {@link Command}
	 */
	public Command getCommand() {
		return command;
	}
}
