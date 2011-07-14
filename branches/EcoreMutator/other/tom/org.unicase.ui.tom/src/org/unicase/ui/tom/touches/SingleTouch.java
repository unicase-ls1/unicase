/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.touches;

import java.util.Date;

import org.eclipse.draw2d.geometry.PointList;

/**
 * @author schroech
 *
 */
public abstract class SingleTouch extends AbstractTouch{

	private Date touchUpDate = new Date(-1);
	private Date touchDownDate = new Date(-1);
	
	
	/**
	 * Default contructor.
	 */
	public SingleTouch() {
	}
	
	/**
	 * @return The path of the touch in relative coordinates
	 */
	public abstract PointList getPath();

	/**
	 * @return The path of the touch in absolute coordinates
	 */
	public abstract PointList getAbsolutePath();

	/**
	 * @param touchUpDate The date when the touch went up
	 */
	public void setTouchUpDate(Date touchUpDate) {
		this.touchUpDate = touchUpDate;
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.touches.Touch#getTouchUpDate()
	 */
	public Date getTouchUpDate() {
		return touchUpDate;
	}

	/**
	 * @param touchDownDate The date when the touch went down
	 */
	public void setTouchDownDate(Date touchDownDate) {
		this.touchDownDate = touchDownDate;
	}

	/**
	 * @return The date when the touch went down
	 */
	public Date getTouchDownDate() {
		return touchDownDate;
	}
	
	/**
	 * Updates the touch.
	 */
	public abstract void update();

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.touches.Touch#setClaimed(boolean)
	 */
	public void setClaimed(boolean claimed) {
		getMultiTouch().setClaimed(claimed);
	}
	
	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.touches.Touch#isClaimed()
	 */
	public boolean isClaimed() {
		return getMultiTouch().isClaimed();
	}
}
