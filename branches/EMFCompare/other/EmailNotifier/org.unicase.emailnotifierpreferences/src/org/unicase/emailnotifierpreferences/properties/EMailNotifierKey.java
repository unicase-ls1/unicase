/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emailnotifierpreferences.properties;


import org.unicase.workspace.preferences.PropertyKey;

/**
 * The keys for the EMail Notifier preferences.
 * 
 * @author fuesescc
 *
 */
public enum EMailNotifierKey implements PropertyKey {
	
	/**
	 * The list of notification groups created by the user.
	 */
	NOTIFICATIONGROUPS,
	
	/**
	 * Whether the EMail Notification is turned on or not.
	 */
	ACTIVATED,

}