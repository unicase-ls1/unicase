/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.notifications;

import java.util.Set;

/**
 * @author schroech
 *
 */
public interface TouchNotifier {

	/**
	 * @return The observers
	 */
	Set<TouchAdapter> getAdapters();
	
	/**
	 * @param notification The notification
	 */
	void notifyAdapters(SingleTouchNotification notification);
	
}
