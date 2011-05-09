/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.notifications;

import java.util.HashSet;
import java.util.Set;

/**
 * @author schroech
 *
 */
public class MultiTouchNotifierImpl {

	private Set<MultiTouchAdapter> adapters;
	private boolean deliver = true;

	/**
	 * Default constructor.
	 */
	public MultiTouchNotifierImpl() {
		adapters = new HashSet<MultiTouchAdapter>();
	}
	
	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.notifications.TouchNotifier#getAdapters()
	*/
	public Set<MultiTouchAdapter> getAdapters() {
		return adapters;
	}

	/**
	 * @param adapters The list of {@link SingleTouchAdapter}s
	 */
	public void setAdapters(Set<MultiTouchAdapter> adapters) {
		this.adapters = adapters;
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.notifications.TouchNotifier#notifyAdapters(org.unicase.ui.tom.notifications.SingleTouchNotification)
	*/
	public void notifyAdapters(MultiTouchNotification notification) {
		Set<MultiTouchAdapter> adapters = getAdapters();
		if (adapters != null && deliver())
		{
			for (MultiTouchAdapter touchAdapter : adapters) {
				touchAdapter.notifyChanged(notification);
			}
		}
	}

	/**
	 * Temporarily enables or disabled delivery of notifications.
	 * 
	 * @param deliver The flag indicating if notifications will be delivered
	 */
	public void setDeliver(boolean deliver) {
		this.deliver = deliver;
	}

	/**
	 * @return The flag indicating if notifications will be delivered
	 */
	public boolean deliver() {
		return deliver;
	}
}
