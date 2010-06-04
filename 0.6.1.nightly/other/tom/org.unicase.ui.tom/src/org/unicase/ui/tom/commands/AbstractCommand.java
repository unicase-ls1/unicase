/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.commands;

import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.unicase.ui.tom.operations.AbstractOperation;

/**
 * @author schroech
 *
 */
public abstract class AbstractCommand extends AbstractOperation implements Executable{

	private Request request;

	/**
	 * Default constructor.
	 * @param diagramEditPart The {@link DiagramEditPart} on which this operation operates  
	 */
	AbstractCommand(DiagramEditPart diagramEditPart){
		super(diagramEditPart);
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.operations.Operation#finish()
	*/
	public void execute() {
		org.eclipse.gef.commands.Command command = getCommand();
		getDiagramEditPart().getDiagramEditDomain().getDiagramCommandStack().execute(command);
	}
	
	/**
	 * @return The GEF {@link Command} executed by this command
	 */
	public abstract org.eclipse.gef.commands.Command getCommand();
	
	/**
	 * @return
	 * The request associated with this command
	 */
	public Request getRequest() {
		if (request == null) {
			request = createRequest();
		}
		return request;
	}
	

	/**
	 * @return
	 * The created request associated with this command
	 */
	protected abstract Request createRequest();
}
