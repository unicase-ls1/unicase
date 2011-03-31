/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.eventmanager;

import org.eclipse.emf.emfstore.server.model.versioning.events.server.ServerEvent;

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
