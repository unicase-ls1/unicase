/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel.util;

import org.eclipse.emf.common.notify.Notification;

/**
 * Abstract listener class for inner class declarations.
 * 
 * @author koegel
 */
public abstract class ModelElementChangeListenerImpl implements ModelElementChangeListener {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ModelElementChangeListener#onChange(org.eclipse.emf.common.notify.Notification)
	 */
	public abstract void onChange(Notification notification);

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ModelElementChangeListener#onRuntimeExceptionInListener(java.lang.RuntimeException)
	 */
	public abstract void onRuntimeExceptionInListener(RuntimeException exception);

}
