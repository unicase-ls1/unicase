package org.unicase.ui.meeditor;

import org.eclipse.emf.ecore.EObject;

public interface StatusMessageProvider {
	/**
	 * If a status message provider can return a message for a certain element.
	 * 
	 * @param modelelement
	 * @return the priority
	 */
	public int canRender(EObject modelelement);

	/**
	 * Return the status message for a certain EObject
	 * 
	 * @return the status message
	 */
	public String getMessage(EObject modelelement);
}
