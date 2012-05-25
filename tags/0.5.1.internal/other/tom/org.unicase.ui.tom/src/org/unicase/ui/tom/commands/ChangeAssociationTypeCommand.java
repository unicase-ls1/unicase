/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.commands;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author schroech
 *
 */
public class ChangeAssociationTypeCommand extends AbstractCommand {

	/**
	 * Default constructor.
	 * @param diagramEditPart The diagram edit part
	 * @param targetEditPart The association on which this command operates
	 */
	public ChangeAssociationTypeCommand(DiagramEditPart diagramEditPart,
			GraphicalEditPart targetEditPart) {
		super(diagramEditPart);
		
		Object model = targetEditPart.getModel();
		if (!(model instanceof View)) {
			return;
		}
		
		EObject element = ((View)model).getElement();
		
		EList<EAttribute> allAttributes = element.eClass().getEAllAttributes();
		for (EAttribute attribute : allAttributes) {
			EClassifier type = attribute.getEType();
			type.getName();
		}
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.commands.AbstractCommand#createRequest()
	 */
	@Override
	protected Request createRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.commands.AbstractCommand#getCommand()
	 */
	@Override
	public Command getCommand() {
		// TODO Auto-generated method stub
		return null;
	}

}
