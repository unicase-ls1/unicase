/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.common.commands;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.ModelElement;
import org.unicase.model.classes.Association;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.common.util.UnicaseUiUtil;

/**
 * @author denglerm
 * This class represents a command to add model elements to the diagram,
 * which are not contained in the newElements list of the diagram.
 */
public class DiagramElementAddCommand extends CreateElementCommand {

	/**
	 * The model element, which is added to the diagram.
	 */
	private EObject newElement;
	
	/**
	 * Constructs a command for the <code>request</code>.
	 * 
	 * @param req
	 *            the element creation request
	 */
	public DiagramElementAddCommand(CreateElementRequest req) {
		super(req);
		this.newElement = req.getNewElement();
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	protected EObject getElementToEdit() {
		EObject container = ((CreateElementRequest) getRequest())
				.getContainer();
		if (container instanceof View) {
			container = ((View) container).getElement();
		}
		return container;
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	protected EClass getEClassToEdit() {
		return DiagramPackage.eINSTANCE.getMEDiagram();
	}

	/**
	 * This method adds the new model element to the element list of the diagram. 
	 * @return the new model element that has been added
	 */
	@Override
	protected EObject doDefaultElementCreation() {
	
		MEDiagram childHolder = (MEDiagram) getElementToEdit();
		ArrayList<Association> assocs = UnicaseUiUtil.getDiagramNodeReferences((ModelElement)this.newElement);
		for(Association assoc:assocs){
			if(childHolder.getElements().contains(assoc.getSource()) || childHolder.getElements().contains(assoc.getTarget())){
				childHolder.getElements().add(assoc);
			}
		}
		
		childHolder.getElements().add((ModelElement)this.newElement);
		return this.newElement;
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public boolean canExecute() {
		// Super class checks if Diagram has a containment feature.
		// We don't save the new element in the containment feature.
		return true;
	}

}
