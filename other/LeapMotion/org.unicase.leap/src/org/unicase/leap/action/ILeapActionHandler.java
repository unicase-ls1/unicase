/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.action;

import org.unicase.leap.events.LeapActionEvent;

/**
 * Interface for the leap action extension point. Any extensions defined must also specify an implementation of this
 * interface. Whenever any specified input sequence associated with this handler occurs, the
 * {@link #handleLeapAction(LeapActionEvent)} of the underlying implementation will be called.
 * 
 * @author mharut
 */
public interface ILeapActionHandler {

	/**
	 * This method defines how occurring leap actions shall be handled. The method will be called whenever the
	 * associated input sequence (which has been defined via the extension point) is performed by the user.
	 * 
	 * @param leapEvent the event containing information about the environment while the input sequence was performed
	 */
	void handleLeapAction(LeapActionEvent leapEvent);

}
