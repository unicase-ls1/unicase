/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.common.model.impl;

import org.eclipse.emf.emfstore.common.model.NotifiableIdEObjectCollection;
import org.eclipse.emf.emfstore.common.model.util.EObjectChangeObserver;

/**
 * Command for notifying an {@link EObjectChangeObserver} of changes in a {@link NotifiableIdEObjectCollection}.
 * 
 * @author koegel
 */
public interface EObjectChangeObserverNotificationCommand {

	/**
	 * Run the command on a project change observer.
	 * 
	 * @param eObjectChangeObserver the observer
	 */
	void run(EObjectChangeObserver eObjectChangeObserver);
}
