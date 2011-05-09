/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package scrm.diagram.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;

/**
 * @author schroech
 */
public class CreateNodeViewCommandProvider {

	private final EObject object;
	private final EditPart host;

	private CreateViewRequest request;
	private ViewDescriptor viewDescriptor;
	private Command command;

	/**
	 * Default constructor.
	 * 
	 * @param host The {@link EditPart} which will be asked for the command
	 * @param object The node object
	 */
	public CreateNodeViewCommandProvider(EditPart host, EObject object) {
		if (host == null) {
			throw new IllegalArgumentException();
		}
		if (object == null) {
			throw new IllegalArgumentException();
		}

		this.host = host;
		this.object = object;
	}

	private void createCommand() {
		Request request = getRequest();
		if (request != null) {
			command = getHost().getCommand(request);
		}
	}

	private void createRequest() {
		ViewDescriptor viewDescriptor = getViewDescriptor();
		if (viewDescriptor != null) {
			request = new CreateViewRequest(viewDescriptor);
		}
	}

	private void createViewDescriptor() {
		viewDescriptor = CommandFactory.createViewDescriptorForNode(object);
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
	 * @return The {@link ViewDescriptor} created during the command creation
	 */
	public ViewDescriptor getViewDescriptor() {
		if (viewDescriptor == null) {
			createViewDescriptor();
		}
		return viewDescriptor;
	}

	/**
	 * @return The {@link Request} created during the command creation
	 */
	public CreateViewRequest getRequest() {
		if (request == null) {
			createRequest();
		}
		return request;
	}

	/**
	 * @return The created {@link Command}
	 */
	public Command getCommand() {
		if (command == null) {
			createCommand();
		}
		return command;
	}
}
