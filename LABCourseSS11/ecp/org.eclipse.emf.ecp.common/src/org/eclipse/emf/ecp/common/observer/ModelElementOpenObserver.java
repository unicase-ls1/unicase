/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen. All rights
 * reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public
 * License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.common.observer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.common.observer.IObserver;

/**
 * Listens of an open event of Model Element.
 * 
 * @author helming
 */
public interface ModelElementOpenObserver extends IObserver {
	/**
	 * Called if a certain model element gets opened.
	 * 
	 * @param opened the opened model element
	 * @param sourceView the view the model element is opened from
	 * @param openView The view, the model element is opened with
	 */
	void onOpen(EObject opened, String sourceView, String openView);
}
