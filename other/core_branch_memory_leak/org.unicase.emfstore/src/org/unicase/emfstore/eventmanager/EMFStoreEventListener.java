/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.eventmanager;

import org.unicase.emfstore.esmodel.versioning.events.server.ServerEvent;

/**
 * Interface in order to listen to the {@link EventManager}.
 * 
 * @author wesendon
 */
public interface EMFStoreEventListener {

	/**
	 * Called if an event has occured.
	 * 
	 * @param event the event
	 * @return true if listener wants to stay registered. false if wants to be unregisterd
	 */
	boolean handleEvent(ServerEvent event);
}
