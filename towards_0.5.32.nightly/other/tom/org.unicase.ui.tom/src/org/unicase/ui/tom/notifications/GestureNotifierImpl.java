/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.notifications;

import java.util.ArrayList;
import java.util.List;

/**
 * @author schroech
 *
 */
public class GestureNotifierImpl implements GestureNotifier{

	private List<GestureAdapter> adapters;
	private boolean deliver;

	/**
	 *  Default constructor.
	 */
	public GestureNotifierImpl() {
		adapters = new ArrayList<GestureAdapter>();
		setDeliver(true);
	}
	
	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.notifications.GestureNotifier#getAdapters()
	 */
	public List<GestureAdapter> getAdapters() {
		return adapters;
	}

	/**
	 * @param adapters The adapters
	 */
	public void setAdapters(List<GestureAdapter> adapters) {
		this.adapters = adapters;
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.notifications.GestureNotifier#notifyAdapters(org.unicase.ui.tom.notifications.GestureNotification)
	 */
	public void notifyAdapters(GestureNotification notification) {
		List<GestureAdapter> adapters = getAdapters();
		if (adapters != null && deliver())
		{
			for (GestureAdapter gestureAdapter : adapters) {
				gestureAdapter.notifyChanged(notification);
			}
		}
	}

	/**
	 * @param deliver Triggers the delivery of notifications
	 */
	public void setDeliver(boolean deliver) {
		this.deliver = deliver;
	}

	/**
	 * @return true of notifications are delivered, false otherwise
	 */
	public boolean deliver() {
		return deliver;
	}

}
