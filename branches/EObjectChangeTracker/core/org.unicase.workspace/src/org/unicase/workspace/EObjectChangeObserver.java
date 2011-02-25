/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Adrian Staudt
 */
public interface EObjectChangeObserver {

	void notify(Notification notification, EObject eObject);

	void eObjectAdded(EObject eObject);

	void eObjectRemoved(EObject eObject);

	void addOperationConsumer(OperationConsumer operationConsumer);

	void removeOperationConsumer(OperationConsumer operationConsumer);
}
