/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.meeditor.mecontrols;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * Interface for all ME controls.
 * 
 * @author helming
 * 
 */
public interface MEControl {

	/**
	 * Creates and renders the control in the parent composite.
	 * 
	 * @param parent
	 *            the parent composite
	 * @param style
	 *            the style for rendering
	 * @return the control
	 */
	Control createControl(Composite parent, int style);

	/**
	 * Disposes the control correctly by removing all model listeners.
	 */
	void dispose();

}
