/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.review;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.unicase.metamodel.util.ModelElementChangeListener;
import org.unicase.model.urml.UrmlModelElement;

/**
 * Abstract class for the reviewed listener.
 * 
 * @author kterzieva
 */
public class ReviewResetListener implements ModelElementChangeListener {

	private UrmlModelElement urmlElement;

	/**
	 * 
	 * 
	 * @return urmlElement the urml element
	 */
	public UrmlModelElement getUrmlElement() {
		return urmlElement;
	}

	/**
	 * The construct.
	 * 
	 * @param urmlElement .
	 * @param reviewedTracker the tracker
	 */
	public ReviewResetListener(UrmlModelElement urmlElement) {
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
		//if any model element properties was changed
		if (wantResetReviewed(notification)) {
			urmlElement.setReviewed(false);
		}
	}
	
	private boolean wantResetReviewed(Notification notification) {
		if (featureWasChanged(notification, Arrays.asList("reviewed", "creator", "creationDate"))) {
			return false;
		}
		return true;
	}


	private boolean featureWasChanged(Notification notification, Collection<String> featureNames) {
		for (String name : featureNames) {
			System.out.println(notification.getFeature().toString());
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
