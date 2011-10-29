package org.unicase.ui.urml.stakeholders;

/**
 * Observable in the Observer pattern.
 * This observable always notifies the observers instead
 * of checking for a state change.
 * @author kami
 *
 */
public class Publisher extends java.util.Observable{

	/**
	 * Updates the observers.
	 */
	public void notifyObservers() {
		//Always notify!
		this.setChanged();
		
		super.notifyObservers();
	}
	
	@Override
	public void notifyObservers(Object arg) {
		//Always notify!
		this.setChanged();
		
		super.notifyObservers(arg);
	}
}
