package org.unicase.ui.common;

import org.unicase.metamodel.ModelElement;

/**
 * Modelelement opener offer the functionality to open a specific model element. Standard opener is the model element
 * editor. Example for specific opener are the diagrams.
 * 
 * @author helming
 */
public interface ModelElementOpener {
	/**
	 * Checks whether the model element should be opened by this opener, depending on the priority. The model element
	 * will be opened with the registered opener with the highest priority.
	 * 
	 * @param modelElement the model element to check
	 * @return
	 */
	public int canOpen(ModelElement modelElement);

	/**
	 * The action to open the model element.
	 * 
	 * @param modelElement the model element to open
	 */
	public void openModelElement(ModelElement modelElement);
}
