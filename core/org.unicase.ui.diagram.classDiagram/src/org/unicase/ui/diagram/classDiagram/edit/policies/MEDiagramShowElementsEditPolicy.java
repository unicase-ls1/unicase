/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.classDiagram.edit.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.ShowRelatedElementsRequest;
import org.unicase.ui.diagram.classDiagram.edit.commands.ShowRelatedElementsCommand;

/**
 * An Edit Policy providing a {@link ShowRelatedElementsCommand} in response to a {@link ShowRelatedElementsRequest}.
 * The command shows representations or previews of classes and associations on the canvas which are semantically
 * connected to the request's class. In the future, this should be extended to generic diagram nodes and connections.
 * 
 * @author schroech
 */
public class MEDiagramShowElementsEditPolicy extends AbstractEditPolicy {

	/**
	 * Default constructor.
	 */
	public MEDiagramShowElementsEditPolicy() {
	}

	/**
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#getCommand(org.eclipse.gef.Request)
	 * @param request the request This edit policy solely responds to {@link ShowRelatedElementsRequest}
	 * @return the command This edit policy solely returns a compound command
	 */
	@Override
	public Command getCommand(Request request) {
		if (RequestConstants.REQ_SHOW_RELATED_ELEMENTS.equals(request.getType())) {
			if (request instanceof ShowRelatedElementsRequest) {
				return new ShowRelatedElementsCommand((ShowRelatedElementsRequest) request);
			}
		}

		return null;
	}
}
