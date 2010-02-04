/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.gestures;

import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.touches.Touch;

/**
 * @author schroech
 *
 */
public abstract class CreateGesture extends AbstractGesture{

	/**
	 * The maximum time the creation touch is allowed to remain on 
	 * the table before it is no longer classified as the creation touch.
	 */
	protected static final long CREATION_TOUCH_LIFESPAN = 400;

	private Touch creationTouch;

	/**
	 * @param dispatch The {@link TouchDispatch} at which the gesture will register for touch events
	 */
	public CreateGesture(TouchDispatch dispatch) {
		super(dispatch);
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#reset()
	 */
	@Override
	public void reset() {
		super.reset();

		setCreationTouch(null);
	}

	/**
	 * @param creationTouch The creation touch  
	 */
	public void setCreationTouch(Touch creationTouch) {
		this.creationTouch = creationTouch;
	}


	/**
	 * @return The creation touch or null, if such does not exist.
	 */
	public Touch getCreationTouch() {
		return creationTouch;
	}
}
