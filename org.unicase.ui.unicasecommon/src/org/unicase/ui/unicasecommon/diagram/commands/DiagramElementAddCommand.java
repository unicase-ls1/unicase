/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.diagram.commands;

import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.classes.Association;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.state.Transition;

/**
 * @author denglerm This class represents a command to add model elements to the diagram, which are not yet contained in
 *         the elements list of the diagram.
 */
public class DiagramElementAddCommand extends CreateElementCommand {

	/**
	 * The model element, which is added to the diagram.
	 */
	private EObject newElement;

	/**
	 * Constructs a command for the <code>request</code>.
	 * 
	 * @param req the element creation request
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
		EObject container = ((CreateElementRequest) getRequest()).getContainer();
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
	 * 
	 * @return the new model element that has been added
	 */
	// dengler reuse get all cross references
	@Override
	protected EObject doDefaultElementCreation() {
		MEDiagram childHolder = (MEDiagram) getElementToEdit();
		childHolder.getElements().add((UnicaseModelElement) this.newElement);

		if (!(getRequest() instanceof DiagramElementAddRequest)
			|| ((DiagramElementAddRequest) getRequest()).getAddReferences()) {

			Set<ModelElement> diagramNodeReferences = ((ModelElement) this.newElement)
				.getCrossReferencedModelElements();
			for (ModelElement object : diagramNodeReferences) {
				if (object instanceof Association) {
					if (childHolder.getElements().contains(((Association) object).getSource())
						&& childHolder.getElements().contains(((Association) object).getTarget())) {
						childHolder.getElements().add((Association) object);
					}
				} else if (object instanceof org.unicase.model.state.Transition) {
					if (childHolder.getElements().contains(((org.unicase.model.state.Transition) object).getSource())
						&& childHolder.getElements()
							.contains(((org.unicase.model.state.Transition) object).getTarget())) {
						childHolder.getElements().add((Transition) object);
					}
				} else if (object instanceof org.unicase.model.activity.Transition) {
					if (childHolder.getElements()
						.contains(((org.unicase.model.activity.Transition) object).getSource())
						&& childHolder.getElements().contains(
							((org.unicase.model.activity.Transition) object).getTarget())) {
						childHolder.getElements().add((org.unicase.model.activity.Transition) object);
					}
				}
			}
		}

		return this.newElement;
	}
}
