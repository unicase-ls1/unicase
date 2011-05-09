/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.emailnotifier.client.util;

/**
 * This class deals almost like the object Boolean. But you can't assign to the Boolean object a new value.
 * If you assign a new value, a new object will be created.
 * 
 * <code>
 * 	Boolean b = new Boolean(false); // first instance of b
 *  b = true; // second instance of b
 * </code>
 * 
 * @author staudta
 *
 */
public class Flag {
	
	private boolean flag;
	
	/**
	 * Constructor.
	 * 
	 * @param b set the flag to an initial value.
	 */
	public Flag(boolean b) {
		flag = b;
	}
	
	/**
	 * Changes the value of the flag.
	 * 
	 * @param b the new value
	 */
	public void setFlag(boolean b) {
		flag = b;
	}
	
	/**
	 * Returns the value of the flag.
	 * 
	 * @return the flag
	 */
	public boolean getFlag() {
		return flag;
	}
	
}
