/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.input;

import com.leapmotion.leap.Gesture.Type;

/**
 * Class representing leap {@link com.leapmotion.leap.Gesture Gesture} input. Every gesture input has a {@link Type
 * gesture type} and can be enabled for {@link com.leapmotion.leap.Finger Fingers}, {@link com.leapmotion.leap.Tool
 * Tools} or both.
 * 
 * @author mharut
 */
public class GestureInput extends ActionInput {

	/**
	 * The type of the {@link com.leapmotion.leap.Gesture Gesture}.
	 */
	private final Type gestureType;
	/**
	 * Whether or not {@link com.leapmotion.leap.Finger Fingers} are enabled for this gesture.
	 */
	private final boolean fingersEnabled;
	/**
	 * Whether or not {@link com.leapmotion.leap.Tool Tools} are enabled for this gesture.
	 */
	private final boolean toolsEnabled;

	/**
	 * Constructs a new gesture input instance for a {@link Type gesture type}, flags to indicate whether or not
	 * {@link com.leapmotion.leap.Finger Fingers} and {@link com.leapmotion.leap.Tool Tools} are enabled and a timeout
	 * after which this input is discarded.
	 * 
	 * @param gestureType the type of the {@link com.leapmotion.leap.Gesture Gesture} this input is defined for
	 * @param fingersEnabled whether or not fingers are enabled for this input
	 * @param toolsEnabled whether or not tools are enabled for this input
	 * @param timeout the timeout in milliseconds, after which this input is discarded - if this is 0 or less, there
	 *            will be no timeout
	 */
	public GestureInput(Type gestureType, boolean fingersEnabled, boolean toolsEnabled, int timeout) {
		super(timeout);
		this.gestureType = gestureType;
		this.fingersEnabled = fingersEnabled;
		this.toolsEnabled = toolsEnabled;
	}

	/**
	 * The {@link Type} for which this input's gesture is defined.
	 * 
	 * @return the gesture type of this input
	 */
	public Type getInputType() {
		return gestureType;
	}

	/**
	 * Whether or not {@link com.leapmotion.leap.Finger Fingers} are enabled for this input.
	 * 
	 * @return whether or not fingers are enabled
	 */
	public boolean isFingersEnabled() {
		return fingersEnabled;
	}

	/**
	 * Whether or not {@link com.leapmotion.leap.Tool Tools} are enabled for this input.
	 * 
	 * @return whether or not tools are enabled
	 */
	public boolean isToolsEnabled() {
		return toolsEnabled;
	}

}
