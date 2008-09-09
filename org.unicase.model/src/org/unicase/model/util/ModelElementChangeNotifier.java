/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.util;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.unicase.model.ModelElement;

public class ModelElementChangeNotifier extends AdapterImpl {
	
	private ModelElementChangeObserver observer;
	private ModelElement modelElement;
	
	public ModelElementChangeNotifier(ModelElement modelElement, ModelElementChangeObserver observer) {
		this.observer=observer;
		this.modelElement=modelElement;
		modelElement.eAdapters().add(this);
	}
	
	@Override
	public void notifyChanged(Notification notification) {
		observer.notify(notification, modelElement);
	}
}
