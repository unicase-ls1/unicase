/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholderview;

import java.util.Arrays;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.unicase.model.urml.UrmlModelElement;

/**
 * @author kterzieva
 */
public class ReviewedListener extends Listener {

	/**
	 * .
	 * 
	 * @param reviewedTracker .
	 * @param urmlElement .
	 */
	public ReviewedListener(ReviewedTracker reviewedTracker, UrmlModelElement urmlElement) {
		super(reviewedTracker, urmlElement);

	}

	@Override
	protected boolean wantResetReviewed(Notification notification) {
		if (featureWasChanged(notification, Arrays.asList("reviewed", "creator", "creation date"))) {
			return false;
		}
		return true;
	}


	private boolean featureWasChanged(Notification notification, Collection<String> featureNames) {
		for (String name : featureNames) {
			Object feature = getUrmlElement().eClass().getEStructuralFeature(name);
			if ((notification.getEventType() != Notification.RESOLVE) && 
				(notification.getFeature().equals(feature))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void onRuntimeExceptionInListener(RuntimeException exception) {

	}

}
