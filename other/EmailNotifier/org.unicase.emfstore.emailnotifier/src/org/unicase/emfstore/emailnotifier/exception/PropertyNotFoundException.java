/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.emailnotifier.exception;

import org.unicase.emailnotifierpreferences.properties.EMailNotifierKey;

/**
 * 
 * @author staudta
 *
 */
public class PropertyNotFoundException extends Exception {
	
	private static final long serialVersionUID = 4847973293068234059L;
	
	/**
	 * Constructor.
	 * 
	 * @param key EMailNotifierKey that hasn't been found
	 */
	public PropertyNotFoundException(EMailNotifierKey key) {
		super("The property "+key.toString()+" was not found.");
	}
	
}
