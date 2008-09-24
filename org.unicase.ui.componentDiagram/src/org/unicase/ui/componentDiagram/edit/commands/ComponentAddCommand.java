package org.unicase.ui.componentDiagram.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.ModelElement;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.MEDiagram;

/**
 * @generated
 */
public class ComponentAddCommand extends CreateElementCommand {

	/**
	 * @generated
	 */
	private EObject newElement;
	public ComponentAddCommand(CreateElementRequest req) {
		super(req);
		this.newElement = req.getNewElement();
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
	
		MEDiagram childHolder = (MEDiagram) getElementToEdit();
		childHolder.getElements().add((ModelElement)this.newElement);

		return newElement;
	}

	@Override
	public boolean canExecute() {
		return true;
	}

}
