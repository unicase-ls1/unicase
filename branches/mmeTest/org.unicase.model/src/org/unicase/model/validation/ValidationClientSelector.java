package org.unicase.model.validation;

import org.eclipse.emf.validation.model.IClientSelector;

/**
 * ClientSelector, necessary for validation.
 * 
 * @author wesendonk
 */
public class ValidationClientSelector implements IClientSelector {

	private static boolean running;
	
	/**
	 * {@inheritDoc}
	 */
	public boolean selects(Object object) {
		return running;
	}

	/**
	 * running ...
	 * @param running ...
	 */
	public static void setRunning(boolean running) {
		ValidationClientSelector.running = running;
	}

}
