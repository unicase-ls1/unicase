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
package org.eclipse.emf.emfstore.client.model.observers;

import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.common.observer.IObserver;

/**
 * Share listeners are added to a project space and informed whenever a share is
 * executed.
 * 
 * @author pfeifferc
 */
public interface ShareObserver extends IObserver {

	/**
	 * Share is executed.
	 * 
	 * @param ps
	 *            projectspace
	 */
	void shareDone(ProjectSpace ps);

	/**
	 * Read or modify project before it is shared.
	 * 
	 * @param ps
	 *            projectspace
	 */
	void beforeShare(ProjectSpace ps);
}
