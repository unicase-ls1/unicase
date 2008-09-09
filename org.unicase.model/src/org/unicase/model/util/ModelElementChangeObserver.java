/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.util;

import org.eclipse.emf.common.notify.Notification;
import org.unicase.model.ModelElement;

public interface ModelElementChangeObserver {
	
	/**
	 * Will be called on any change on the model element.
	 * @param notification the EMF change notification
	 * @param modelElement the modelElement
	 */
	void notify(Notification notification, ModelElement modelElement);
}
