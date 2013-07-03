/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.action;

import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.unicase.leap.listener.LeapInputListener;

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
	 * The leap motion {@link Controller} capturing sensor information.
	 */
	private final Controller controller;
	/**
	 * The ID of the {@link Pointable} responsible for cursor movement.
	 */
	private int mainPointableId;
	/**
	 * The {@link Cursor} which is currently being displayed (may be <code>null</code>).
	 */
	private Cursor cursor;

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
	 * @param pointable the {@link Pointable} to retrieve the tip for
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

	/**
	 * Sets the ID of the {@link Pointable} responsible for cursor movement to a new value.
	 * 
	 * @param id the new ID for the main pointable
	 */
	public void setMainPointable(int id) {
		mainPointableId = id;
	}

	/**
	 * Retrieves the {@link Pointable} which is responsible for cursor movement. If the specified ID is negative or the
	 * pointable belonging to the ID is invalid, <code>null</code> will be returned.
	 * 
	 * @return the main pointable if a valid pointable exists,<br />
	 *         <code>null</code> otherwise
	 */
	public Pointable getMainPointable() {
		if (mainPointableId >= 0) {
			Pointable pointable = controller.frame().pointable(mainPointableId);
			if (pointable.isValid()) {
				return pointable;
			}
		}
		return null;
	}

	/**
	 * Shows the cursor defined for the leap motion sensor. If the leap cursor is already being displayed, this has no
	 * effect.
	 */
	public void showLeapCursor() {
		if (cursor == null) {
			cursor = new Cursor(Display.getDefault(), new ImageData(
				LeapInputListener.class.getResourceAsStream("/images/red.png")), 10, 10);
			setCursor(cursor);
		}
	}

	/**
	 * Hides the cursor defined for the leap motion sensor and replaces it with the default cursor. If the leap cursor
	 * is already hidden, this has no effect.
	 */
	public void hideLeapCursor() {
		if (cursor != null) {
			cursor.dispose();
			cursor = null;
			setCursor(null);
		}
	}

	/**
	 * Sets the {@link Cursor} of the currently active {@link Shell} to a new value.
	 * 
	 * @param cursor the new {@link Cursor}
	 */
	private void setCursor(final Cursor cursor) {
		final Display display = Display.getDefault();
		display.asyncExec(new Runnable() {

			@Override
			public void run() {
				Shell shell = display.getActiveShell();
				if (shell != null && !shell.isDisposed() && (cursor == null || !cursor.isDisposed())) {
					shell.setCursor(cursor);
				}
			}
		});
	}

}
