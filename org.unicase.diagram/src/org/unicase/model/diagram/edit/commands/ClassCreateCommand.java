package org.unicase.model.diagram.edit.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.classes.Class;
import org.unicase.model.classes.ClassesFactory;

/**
 * @generated
 */
public class ClassCreateCommand extends CreateElementCommand {

	/**
	 * @generated
	 */
	public ClassCreateCommand(CreateElementRequest req) {
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
		if (getEClass() != null) {
			return getEClass().isSuperTypeOf(getEClassToEdit());
		}
		return true;
	}

	/**
	 * @generated
	 */
	protected EReference getContainmentFeature() {
		return null;
	}

	/**
	 * @generated
	 */
	protected EObject doDefaultElementCreation() {
		// Uncomment to put "phantom" objects into the diagram file.		
		// org.eclipse.emf.ecore.resource.Resource resource = 
		// 		((org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest) getRequest()).getContainer().eResource();
		// if (resource == null) {
		// 	return null;
		// }
		Resource resource = getElementToEdit().eResource();
		Class newElement = ClassesFactory.eINSTANCE.createClass();

		resource.getContents().add(newElement);
		return newElement;
	}

}
