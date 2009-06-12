package org.unicase.ui.stateDiagram.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.state.StateEnd;
import org.unicase.model.state.StateFactory;

/**
 * @generated
 */
public class StateEndCreateCommand extends CreateElementCommand {

	/**
	 * @generated
	 */
	public StateEndCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * @generated
	 */
	protected EObject getElementToEdit() {
		EObject container = ((CreateElementRequest) getRequest())
				.getContainer();
		if (container instanceof View) {
			container = ((View) container).getElement();
		}
		return container;
	}

	/**
	 * @generated
	 */
	protected EClass getEClassToEdit() {
		return DiagramPackage.eINSTANCE.getMEDiagram();
	}

	/**
	 * @generated
	 */
	protected EObject doDefaultElementCreation() {
		StateEnd newElement = StateFactory.eINSTANCE.createStateEnd();

		newElement.setName("new " + newElement.eClass().getName());

		MEDiagram owner = (MEDiagram) getElementToEdit();
		owner.getNewElements().add(newElement);

		MEDiagram childHolder = (MEDiagram) getElementToEdit();
		childHolder.getElements().add(newElement);

		return newElement;
	}

}
