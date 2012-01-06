/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.navigation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.urml.UrmlFactory;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.ui.urml.stakeholders.ChangeObserverAdapter;
import org.unicase.ui.urml.stakeholders.Publisher;

/**
 * Tracks the urml model elements for changes.
 * 
 * @author kterzieva
 */

public class ReviewCountPublisher extends Publisher {

	/**
	 * Listener class for tracking review count changes
	 * when new model elements are added or deleted.
	 * @author kterzieva
	 *
	 */
	private final class CountTrackingOnProjectChangeListener extends ChangeObserverAdapter {
		@Override
		public void modelElementAdded(Project project, EObject modelElement) {
			if (modelElement instanceof UrmlModelElement) {
				UrmlModelElement u = (UrmlModelElement) modelElement;
				adjustOverallCount(u.eClass(), 1);
				if (u.isReviewed()) {
					adjustReviewCount(u.eClass(), 1);
				}
				notifyObservers();
			}
		}

		@Override
		public void modelElementRemoved(Project project, EObject modelElement) {
			if (modelElement instanceof UrmlModelElement) {
				UrmlModelElement u = (UrmlModelElement) modelElement;
				adjustOverallCount(u.eClass(), -1);
				if (u.isReviewed()) {
					adjustReviewCount(u.eClass(), -1);
				}
				notifyObservers();
			}
		}

		@Override
		public void notify(Notification notification, Project project, EObject modelElement) {
			if (notification.getEventType() == Notification.RESOLVE) {
				return;
			}
			if (modelElement instanceof UnicaseModelElement) {
				// if review check box was selected or deselected
				if ((notification.getFeature().equals(REVIEWED_FEATURE))) {
					if (!notification.getOldBooleanValue() && notification.getNewBooleanValue()) {
						// false -> true
						adjustReviewCount(modelElement.eClass(), 1);
						notifyObservers();
					} else if (notification.getOldBooleanValue() && !notification.getNewBooleanValue()) {
						// true -> false
						adjustReviewCount(modelElement.eClass(), -1);
						notifyObservers();
					}
				}
			}
		}
	}

	private static final EStructuralFeature REVIEWED_FEATURE = UrmlFactory.eINSTANCE.getUrmlPackage()
		.getUrmlModelElement().getEStructuralFeature("reviewed");
	private Project project;
	private Map<EClass, Integer> reviewCounts = new HashMap<EClass, Integer>();
	private Map<EClass, Integer> allCounts = new HashMap<EClass, Integer>();
	private int reviewCount, allCount;
	private ChangeObserverAdapter observer;

	/**
	 * 
	 * @param project the project
	 */
	public void init(Project project) {
		if (this.project != null) {
			remove();
		}
		this.project = project;
		Collection<UrmlModelElement> urmlElements = project.getAllModelElementsbyClass(
			UrmlPackage.eINSTANCE.getUrmlModelElement(), new BasicEList<UrmlModelElement>());
		for (UrmlModelElement u : urmlElements) {
			adjustOverallCount(u.eClass(), 1);
			if (u.isReviewed()) {
				adjustReviewCount(u.eClass(), 1);
			}
		}

		notifyObservers();
		
		observer = new CountTrackingOnProjectChangeListener();

		project.addProjectChangeObserver(observer);
	}
	
	private void adjustReviewCount(EClass c, int delta) {
		Integer i = reviewCounts.get(c);
		if (i == null) {
			i = 0;
		}
		i += delta;
		reviewCounts.put(c, i);
		reviewCount += 1;
	}

	private void adjustOverallCount(EClass elementType, int delta) {
		Integer i = allCounts.get(elementType);
		if (i == null) {
			i = 0;
		}
		i += delta;
		allCounts.put(elementType, i);
		allCount += 1;
	}
	
	/**
	 * Removes the observer.
	 */
	public void remove() {
		project.removeProjectChangeObserver(observer);
		project = null;
	}

	/**
	 * Gets the number of model elements from the same model element type included in the active project.
	 * @return reviewCounts the set of number of elements
	 */
	public Map<EClass, Integer> getAllCounts() {
		return allCounts;
	}


	/***
	 * Gets the number of all reviewed elements related to each model element type.
	 * @return reviewCounts the set of number of reviewed elements 
	 */
	public Map<EClass, Integer> getReviewCounts() {
		return reviewCounts;
	}

	/**
	 * Gets the total number of created model elements within the active project.
	 * @return allCount the total number
	 */
	public int getTotalCount() {
		return allCount;
	}

	/**
	 * Gets the number of reviewed model elements within the active project.
	 * @return reviewCount the number of reviewed elements
	 */
	public int getReviewCount() {
		return reviewCount;
	}

	/**
	 * Gets the number of reviewed model elements from the same type.
	 * @param elementType the type of the model element
	 * @return reviewCount the number of reviewed model elements
	 */
	public int getReviewCount(EClass elementType) {
		Integer reviewCount = reviewCounts.get(elementType);
		if (reviewCount == null) {
			return 0;
		}
		return reviewCount;
	}

	/**
	 * Gets the total number model elements from the same type.
	 * @param elementType the type of the model element
	 * @return totalCount the total number
	 */
	
	public int getTotalCount(EClass elementType) {
		Integer totalCount = allCounts.get(elementType);
		if (totalCount == null) {
			return 0;
		}
		return totalCount;
	}

}
