/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Pointable;
import com.leapmotion.leap.Screen;
import com.leapmotion.leap.ScreenList;
import com.leapmotion.leap.Vector;

/**
 * Helper class responsible for computations regarding information captured by a leap motion controller.
 * 
 * @author mharut
 */
public final class LeapHelper {

	/**
	 * The leap motion controller capturing sensor information.
	 */
	private final Controller controller;

	/**
	 * Constructs a new helper instance for a leap motion controller.
	 * 
	 * @param controller the leap motion {@link Controller} capturing sensor information
	 */
	public LeapHelper(Controller controller) {
		this.controller = controller;
	}

	/**
	 * Retrieves the tip of a {@link Pointable} by intersecting its closest screen with itself.
	 * 
	 * @param pointable the {@link Pointable} to retrieve the tip for.
	 * @return the tip of the pointable relative to the closest screen as a {@link Vector}
	 */
	public Vector getTip(Pointable pointable) {
		if (pointable.isValid()) {
			ScreenList screens = controller.locatedScreens();
			Screen screen = screens.closestScreenHit(pointable);
			if (screen.isValid()) {
				return screen.intersect(pointable, true);
			}
		}
		return null;
	}

	/**
	 * Converts a {@link Vector} relative to the leap motion controller to a Vector relative to the specified
	 * {@link Pointable}'s closest screen.
	 * 
	 * @param leapVector the {@link Vector} to convert
	 * @param pointable the {@link Pointable} to convert the vector for
	 * @return a converted vector providing coordinates relative to the pointable's closest screen.
	 */
	public Vector convert(Vector leapVector, Pointable pointable) {
		ScreenList screens = controller.locatedScreens();
		Screen screen = screens.closestScreenHit(pointable);
		Vector screenVector = new Vector();
		screenVector.setX(leapVector.getX() * screen.widthPixels());
		screenVector.setY((1 - leapVector.getY()) * screen.heightPixels());
		screenVector.setZ(screen.intersect(pointable, true).getZ());
		return screenVector;
	}

}
