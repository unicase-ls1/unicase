package org.unicase.ui.componentDiagram.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.component.ComponentFactory;
import org.unicase.model.component.ComponentService;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.MEDiagram;

/**
 * @generated
 */
public class Component2CreateCommand extends CreateElementCommand {

	/**
	 * @generated
	 */
	public Component2CreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * @generated
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
	 * @generated
	 */
	@Override
	protected EClass getEClassToEdit() {
		return DiagramPackage.eINSTANCE.getMEDiagram();
	}

	/**
	 * @generated NOT
	 */
	@Override
	protected EObject doDefaultElementCreation() {
		ComponentService newElement = ComponentFactory.eINSTANCE.createComponentService();
		newElement.setName("new ComponentService");

		MEDiagram owner = (MEDiagram) getElementToEdit();
		owner.getNewElements().add(newElement);

		MEDiagram childHolder = (MEDiagram) getElementToEdit();
		childHolder.getElements().add(newElement);

		return newElement;
	}

}
