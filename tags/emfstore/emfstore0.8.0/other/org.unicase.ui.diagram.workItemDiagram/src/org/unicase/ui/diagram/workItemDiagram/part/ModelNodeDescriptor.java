package org.unicase.ui.diagram.workItemDiagram.part;

import org.eclipse.emf.ecore.EObject;

/**
 * @generated
 */
public class ModelNodeDescriptor {

	/**
	 * @generated
	 */
	private EObject myModelElement;

	/**
	 * @generated
	 */
	private int myVisualID;

	/**
	 * @generated
	 */
	private String myType;

	/**
	 * @generated
	 */
	public ModelNodeDescriptor(EObject modelElement, int visualID) {
		myModelElement = modelElement;
		myVisualID = visualID;
	}

	/**
	 * @generated
	 */
	public EObject getModelElement() {
		return myModelElement;
	}

	/**
	 * @generated
	 */
	public int getVisualID() {
		return myVisualID;
	}

	/**
	 * @generated
	 */
	public String getType() {
		if (myType == null) {
			myType = org.unicase.ui.diagram.workItemDiagram.part.ModelVisualIDRegistry
					.getType(getVisualID());
		}
		return myType;
	}

}
