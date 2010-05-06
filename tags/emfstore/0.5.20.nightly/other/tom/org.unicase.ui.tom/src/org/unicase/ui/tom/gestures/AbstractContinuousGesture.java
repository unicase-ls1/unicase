/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.gestures;

import org.unicase.ui.tom.TouchDispatch;

/**
 * @author schroech
 *
 */
public abstract class AbstractContinuousGesture extends AbstractGesture implements
		ContinuousGesture {

	private boolean isExecuting; 
	
	/**
	 * Default constructor.
	 * 
	 * @param dispatch The {@link TouchDispatch} at which the gesture will register for touch events
	 */
	public AbstractContinuousGesture(TouchDispatch dispatch) {
		super(dispatch);
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.gestures.ContinuousGesture#isExecuting()
	*/
	public boolean isExecuting() {
		return isExecuting;
	}

	/**
	 * @param isExecuting True if the {@link Gesture} is executing, false otherwise
	 */
	public void setExecuting(boolean isExecuting) {
		this.isExecuting = isExecuting;
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.gestures.AbstractMomentaryGesture#reset()
	*/
	@Override
	public void reset() {
		super.reset();
		
		setExecuting(false);
	}
}
	