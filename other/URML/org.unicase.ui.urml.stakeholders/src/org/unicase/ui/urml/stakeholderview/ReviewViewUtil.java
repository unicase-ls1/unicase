/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholderview;

/**
 *  Util class for the review view.
 * 
 * @author kterzieva
 */

public final class ReviewViewUtil {
	
	private ReviewViewUtil() {}
	
	//gibt value of string zurück, wenn aber der Wert null ist, soll leeres string angezeigt bekomme
	//also nix
	/**
	 * .
	 * @param o the object 
	 * @return the string representation of the object
	 */
	
	public static String getValueOfString(Object o){
		if (o == null){
			return "";	
		} else {
			return o.toString();
		}
	}
	
}
