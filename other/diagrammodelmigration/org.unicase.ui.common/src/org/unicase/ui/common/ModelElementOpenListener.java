/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common;

import org.eclipse.emf.ecore.EObject;

/**
 * Listens of an open event of Model Element.
 * @author helming
 *
 */
public interface ModelElementOpenListener {
	/**
	 * Called if a certain model element gets opened.
	 * @param opened the opened model element
	 * @param sourceView the view the model element is opened from
	 * @param openView The view, the model element is opened with
	 */
	void onOpen(EObject opened, String sourceView,  String openView);
}
