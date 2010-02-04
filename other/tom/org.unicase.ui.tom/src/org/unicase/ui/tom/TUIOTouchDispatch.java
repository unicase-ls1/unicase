/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom;

import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import org.unicase.ui.tom.touches.SingleTouch;
import org.unicase.ui.tom.touches.TUIOTouch;
import org.unicase.ui.tum.tuio.TuioClient;
import org.unicase.ui.tum.tuio.TuioCursor;
import org.unicase.ui.tum.tuio.TuioListener;
import org.unicase.ui.tum.tuio.TuioObject;

/**
 * @author schroech
 */
public final class TUIOTouchDispatch extends TouchDispatch implements TuioListener {

	/**
	 * The Map relating TuioCursors to touches.
	 */
	private Map<TuioCursor, SingleTouch> touchMap;
	
	/**
	 * Default Constructor.
	 */
	public TUIOTouchDispatch() {
		super();

		TuioClient client = new TuioClient();
		client.addTuioListener(this);
		client.connect();

		setTouchMap(new Hashtable<TuioCursor, SingleTouch>());
	}

	/** {@inheritDoc}
	 * @see org.unicase.ui.tum.tuio.TuioListener#addTuioCursor(org.unicase.ui.tum.tuio.TuioCursor)
	 */
	public void addTuioCursor(TuioCursor tuioCursor) {
		if (getActiveEditor() == null) {
			return;
		}
		if (tuioCursor.getX() < 0 || tuioCursor.getY() < 0) {
			// discard the cursor
		}

		TUIOTouch touch = new TUIOTouch(tuioCursor, getScreenSize());

//		try {
			addTouch(touch);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		getTouchMap().put(tuioCursor, touch);
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tum.tuio.TuioListener#refresh(long)
	 */
	public void refresh(long timestamp) {

	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tum.tuio.TuioListener#removeTuioCursor(org.unicase.ui.tum.tuio.TuioCursor)
	 */
	public void removeTuioCursor(TuioCursor tuioCursor) {
		if (getActiveEditor() == null) {
			return;
		}
		SingleTouch touch = getTouchMap().get(tuioCursor);
		if (touch != null) {
			touch.setTouchUpDate(new Date(tuioCursor.getUpdateTime()));
//			try {
				removeTouch(touch);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}

			getTouchMap().remove(tuioCursor);
		}
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tum.tuio.TuioListener#updateTuioCursor(org.unicase.ui.tum.tuio.TuioCursor)
	 */
	public void updateTuioCursor(TuioCursor tuioCursor) {
		if (getActiveEditor() == null) {
			return;
		}
		SingleTouch touch = getTouchMap().get(tuioCursor);
		if (touch != null) {
//			try {
				updateTouch(touch);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}

		}
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tum.tuio.TuioListener#updateTuioObject(org.unicase.ui.tum.tuio.TuioObject)
	 */
	public void updateTuioObject(TuioObject tuioObject) {
		// don't do anything
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tum.tuio.TuioListener#addTuioObject(org.unicase.ui.tum.tuio.TuioObject)
	 */
	public void addTuioObject(TuioObject tuioObject) {
		// don't do anything
	}

	/*** {@inheritDoc}
	 * @see org.unicase.ui.tum.tuio.TuioListener#removeTuioObject(org.unicase.ui.tum.tuio.TuioObject)
	 */
	public void removeTuioObject(TuioObject tuioObject) {
		// don't do anything
	}

	private void setTouchMap(Map<TuioCursor, SingleTouch> touchMap) {
		this.touchMap = touchMap;
	}

	private Map<TuioCursor, SingleTouch> getTouchMap() {
		return touchMap;
	}

}
