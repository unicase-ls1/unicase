/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom;

import java.util.List;

import org.unicase.ui.tom.gestures.Gesture;

/**
 * @author schroech
 *
 */
public class PriorityExecutionStrategy extends GestureExecutionStrategy {

	/**
	 * Default constructor.
	 * @param gestures The gestures to be prioritized
	 */
	public PriorityExecutionStrategy(List<Gesture> gestures) {
		super(gestures);
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.GestureExecutionStrategy#getExecutableGestures()
	 */
	@Override
	public List<Gesture> getExecutableGestures() {
		
		return null;
	}

}
