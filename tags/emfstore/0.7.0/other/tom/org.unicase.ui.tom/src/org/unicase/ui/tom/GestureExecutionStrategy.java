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
public abstract class GestureExecutionStrategy {

	private final List<Gesture> gestures;
	
	/**
	 * @param gestures The gestures being examined
	 */
	public GestureExecutionStrategy(List<Gesture> gestures) {
		this.gestures = gestures;
	}
	
	/**
	 * @return The gestures which should be executed
	 */
	public abstract List<Gesture> getExecutableGestures();

	/**
	 * @return The gestures being examined
	 */
	public List<Gesture> getGestures() {
		return gestures;
	}
}
