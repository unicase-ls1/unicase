/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.review;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.metamodel.util.ModelElementChangeListener;
import org.unicase.model.urml.UrmlFactory;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.model.urml.UrmlPackage;

/**
 * Abstract class for the reviewed listener.
 * 
 * @author kterzieva
 */
public class ReviewCountListener implements ModelElementChangeListener {

	private ReviewCountPublisher publisher;

	private final EStructuralFeature REVIEWED_FEATURE = UrmlFactory.eINSTANCE.getUrmlPackage().getUrmlModelElement().getEStructuralFeature("reviewed");

	/**
	 * The construct.
	 * 
	 * @param urmlElement .
	 * @param reviewedTracker the tracker
	 */
	public ReviewCountListener(ReviewCountPublisher reviewedTracker) {
		this.publisher = reviewedTracker;
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
		//if review check box was selected or deselected
		if ((notification.getFeature().equals(REVIEWED_FEATURE))) {
			publisher.notifyObservers();
		}
	}

	@Override
	public void onRuntimeExceptionInListener(RuntimeException exception) {
	}

}
