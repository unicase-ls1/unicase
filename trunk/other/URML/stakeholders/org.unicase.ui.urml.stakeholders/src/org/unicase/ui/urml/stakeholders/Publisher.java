/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
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
