/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.action;

import java.awt.AWTException;
import java.awt.Robot;

import com.leapmotion.leap.Pointable;
import com.leapmotion.leap.Vector;

/**
 * Runnable that keeps the mouse cursor updated as long as the executing thread has not been interrupted. The mouse
 * cursor will be updated based on sensor data received from the leap motion {@link com.leapmotion.Controller Controller}.
 * 
 * @author mharut
 */
public class MouseMoverRunnable implements Runnable {

	/**
	 * The helper used to determine the {@link Pointable} responsible for cursor movement as well as computing the
	 * cursor's position.
	 */
	private final LeapHelper helper;

	/**
	 * Constructs a new instance of this runnable for a leap helper object.
	 * 
	 * @param helper the {@link LeapHelper} used to determine the mouse movement
	 */
	public MouseMoverRunnable(LeapHelper helper) {
		this.helper = helper;
	}

	@Override
	public void run() {
		boolean isDefault = true; // flag used to indicate whether or not the default cursor is active
		while (!Thread.currentThread().isInterrupted()) {
			final Pointable pointable = helper.getMainPointable();
			if (pointable != null) {
				if (isDefault) {
					helper.showLeapCursor();
					isDefault = false;
				}
				moveMouseToPointable(pointable);
			} else if (!isDefault) {
				helper.hideLeapCursor();
				isDefault = true;
			}
		}
	}

	/**
	 * Moves the mouse cursor to the tip of a specified {@link Pointable}.
	 * 
	 * @param pointable the {@link Pointable} to move the mouse to
	 */
	private void moveMouseToPointable(Pointable pointable) {
		if (pointable.isValid()) {
			try {
				Robot robot = new Robot();
				Vector leapPosition = helper.getTip(pointable);
				Vector screenPosition = helper.convert(leapPosition, pointable);
				if (screenPosition != null && screenPosition.isValid()) {
					robot.mouseMove((Math.round(screenPosition.getX())), (Math.round(screenPosition.getY())));
				}
			} catch (AWTException e) {
				e.printStackTrace();
			}
		}
	}

}
