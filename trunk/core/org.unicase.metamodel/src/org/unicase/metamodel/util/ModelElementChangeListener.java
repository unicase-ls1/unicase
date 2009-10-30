/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel.util;

import org.eclipse.emf.common.notify.Notification;

/**
 * Listens to changes on a single model element.
 * 
 * @author koegel
 */
public interface ModelElementChangeListener {

	/**
	 * Handle changes to the model element.
	 * 
	 * @param notification the EMF notification, providing details on the change
	 */
	void onChange(Notification notification);

	/**
	 * Handle a runtime exception that occured in this listeners methods. NOTE: runtime exceptions of this method will
	 * be logged and silently dropped.
	 * 
	 * @param exception the exception
	 */
	void onRuntimeExceptionInListener(RuntimeException exception);
}
