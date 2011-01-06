/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholderview;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.metamodel.util.ModelElementChangeListener;
import org.unicase.model.urml.UrmlModelElement;

/**
 * Abstract class for the reviewed listener.
 * 
 * @author kterzieva
 */
public abstract class Listener implements ModelElementChangeListener {

	private UrmlModelElement urmlElement;

	/**
	 * The construct.
	 * 
	 * @return urmlElement the urml element
	 */
	public UrmlModelElement getUrmlElement() {
		return urmlElement;
	}

	private ReviewedTracker tracker;

	/**
	 * The construct.
	 * 
	 * @param urmlElement .
	 * @param reviewedTracker the tracker
	 */
	public Listener(ReviewedTracker reviewedTracker, UrmlModelElement urmlElement) {
		this.tracker = reviewedTracker;
		this.urmlElement = urmlElement;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ModelElementChangeListener#onChange(org.eclipse.emf.common.notify.Notification)
	 */
	public void onChange(Notification notification) {
		if (notification.getEventType() == Notification.RESOLVE) {
			return;
		}
		if (wantResetReviewed(notification) && urmlElement.isReviewed()) {
			urmlElement.setReviewed(false);
			tracker.recalculate();
		}
		EStructuralFeature feature = getUrmlElement().eClass().getEStructuralFeature("reviewed");
		if ((notification.getFeature().equals(feature))) {
			tracker.recalculate();
		}
	}

	/**
	 * @param notification the notification
	 * @return if the listener wants to send notification to the tracker
	 */
	protected abstract boolean wantResetReviewed(Notification notification);
}
