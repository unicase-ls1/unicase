package org.eclipse.emf.ecp.editor.mecontrols;

import org.eclipse.emf.common.util.Diagnostic;

/**
 * Controls which are implementing this interface handle the live validation result by themselves.
 * 
 * @author Haunolder
 * 
 */
public interface IValidatableControl {

	/**
	 * Handle live validation.
	 * 
	 * @param diagnostic of type Diagnostic
	 * **/
	void handleValidation(Diagnostic diagnostic);

	/**
	 * Reset the MEControl to its initial state.
	 * **/
	void resetValidation();
}
