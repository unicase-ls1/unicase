package org.unicase.model.classDiagram.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.classes.Class;
import org.unicase.model.classes.ClassesFactory;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.MEDiagram;

/**
 * @generated
 */
public class MEDiagramCreateCommand extends CreateElementCommand {

	/**
	 * @generated
	 */
	public MEDiagramCreateCommand(CreateElementRequest req) {
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
	public boolean canExecute() {
		MEDiagram container = (MEDiagram) getElementToEdit();
		if (container.getNewElements() != null) {
			return false;
		}
		return true;
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
		Class newElement = ClassesFactory.eINSTANCE.createClass();

		MEDiagram owner = (MEDiagram) getElementToEdit();
		owner.setNewElements(newElement);

		MEDiagram childHolder = (MEDiagram) getElementToEdit();
		childHolder.getElements().add(newElement);

		return newElement;
	}

}
