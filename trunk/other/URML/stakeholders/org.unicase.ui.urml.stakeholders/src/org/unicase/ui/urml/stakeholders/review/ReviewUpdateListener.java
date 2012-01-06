/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.review;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.jface.viewers.TableViewer;
import org.unicase.metamodel.util.ModelElementChangeListener;
import org.unicase.model.urml.UrmlModelElement;

/**
 * Listener for the review status of the urml model elements.
 * @author kterzieva
 *
 */
public class ReviewUpdateListener implements ModelElementChangeListener {

	private UrmlModelElement urmlElement;
	private TableViewer elementsViewer;

	/**
	 * The construct.
	 * @param urmlElement the model element, whose review status is "listened"
	 * @param elementsViewer the list viewer, which show the model elements
	 */
	public ReviewUpdateListener(UrmlModelElement urmlElement, TableViewer elementsViewer) {
		this.urmlElement = urmlElement;
		this.elementsViewer = elementsViewer;
	}

	@Override
	public void onChange(Notification notification) {
		Object notificationFeature = notification.getFeature();
		if (notification.getEventType() == Notification.RESOLVE) {
			return;
		}
		Object nameFeature = urmlElement.eClass().getEStructuralFeature("name");
		Object reviewedFeature = urmlElement.eClass().getEStructuralFeature("reviewed");
		if (notificationFeature.equals(nameFeature) || notificationFeature.equals(reviewedFeature)) {
			elementsViewer.refresh();
		}
	}

	@Override
	public void onRuntimeExceptionInListener(RuntimeException exception) {
	}
}
