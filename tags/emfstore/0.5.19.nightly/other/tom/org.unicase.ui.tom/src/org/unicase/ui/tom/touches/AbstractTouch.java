/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.touches;


/**
 * @author schroech
 *
 */
public abstract class AbstractTouch implements Touch {

	private MultiTouch multiTouch;

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.touches.Touch#setMultiTouch(org.unicase.ui.tom.touches.MultiTouch)
	 */
	public void setMultiTouch(MultiTouch multiTouch) {
		this.multiTouch = multiTouch;
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.touches.Touch#getMultiTouch()
	 */
	public MultiTouch getMultiTouch() {
		return multiTouch;
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tom.touches.Touch#getLifeSpan()
	 */
	public long getLifeSpan() {

		long downTime = getTouchDownDate().getTime();
		long upTime = getTouchUpDate().getTime();

		return upTime - downTime;
	}


}
