/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.events;

import com.leapmotion.leap.Frame;

import edu.cmu.sphinx.result.Result;

/**
 * Event used to provide information regarding speech input.
 * 
 * @author mharut
 */
/**
 * 
 *
 * @author mharut
 */
/**
 * @author mharut
 */
public class LeapSpeechEvent extends LeapInputEvent {

	/**
	 * The {@link Result} of the Sphinx speech recognition.
	 */
	private final Result result;

	/**
	 * Constructs a new leap speech event for a frame, a {@link Result} from the Sphinx speech recognition and the time
	 * at which the input was recognized in milliseconds.
	 * 
	 * @param frame the leap motion {@link Frame} at which the speech input was performed
	 * @param result the result of the speech recognition
	 * @param time the time at which the input was recognized in milliseconds
	 */
	public LeapSpeechEvent(Frame frame, Result result, long time) {
		super(frame, time);
		this.result = result;
	}

	/**
	 * Retrieves the result of the Sphinx speech recognition.
	 * 
	 * @return the {@link Result} of the Sphinx speech recognition
	 */
	public Result getResult() {
		return result;
	}

}
