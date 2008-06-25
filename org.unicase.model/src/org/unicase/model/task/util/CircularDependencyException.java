package org.unicase.model.task.util;

import org.unicase.model.ModelElement;

public class CircularDependencyException extends Exception {
	
	private ModelElement modelElement;

	/**
	 * default constructor.
	 * @param modelElement the {@link ModelElement} where the Exception was found.
	 */
	public CircularDependencyException(ModelElement modelElement) {
		super();
		this.modelElement = modelElement;
	}

	public ModelElement getModelElement() {
		return modelElement;
	}

	public void setModelElement(ModelElement modelElement) {
		this.modelElement = modelElement;
	}
	
}
