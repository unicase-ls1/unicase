/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.notifications;

/**
 * @author schroech
 *
 */
public interface GestureAdapter {

	/**
	 * @param notification The {@link GestureNotification} indicating an gesture state change 
	 */
	void notifyChanged(GestureNotification notification);
	
}