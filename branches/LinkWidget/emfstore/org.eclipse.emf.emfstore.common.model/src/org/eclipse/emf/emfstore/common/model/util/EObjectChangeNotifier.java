/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.common.model.util;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.impl.ProjectImpl;

/**
 * Notifies the project about changes in its containment hierachy.
 * 
 * @author koegel
 */
public class EObjectChangeNotifier extends EContentAdapter {

	private final NotifiableIdEObjectCollection collection;
	private boolean isInitializing;
	private Set<EObject> removedModelElements;
	private Notification currentNotification;
	private int reentrantCallToAddAdapterCounter;
	private boolean notificationDisabled;

	/**
	 * Constructor. Attaches the Adapter to the given {@link ProjectImpl}.
	 * 
	 * @param collection
	 *            the project
	 */
	public EObjectChangeNotifier(NotifiableIdEObjectCollection collection) {
		this.collection = collection;
		isInitializing = true;
		collection.eAdapters().add(this);
		isInitializing = false;
		reentrantCallToAddAdapterCounter = 0;
		notificationDisabled = false;
		removedModelElements = new HashSet<EObject>();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.util.EContentAdapter#addAdapter(org.eclipse.emf.common.notify.Notifier)
	 */
	@Override
	protected void addAdapter(Notifier notifier) {

		try {
			reentrantCallToAddAdapterCounter += 1;
			if (!notifier.eAdapters().contains(this)) {
				super.addAdapter(notifier);
			}
		} finally {
			reentrantCallToAddAdapterCounter -= 1;
		}
		if (reentrantCallToAddAdapterCounter > 0) {
			// any other than the first call in re-entrant calls to addAdapter
			// are going to call the project
			return;
		}

		if (currentNotification != null && !currentNotification.isTouch()
				&& !isInitializing && notifier instanceof EObject
				&& !ModelUtil.isIgnoredDatatype((EObject) notifier)) {
			EObject modelElement = (EObject) notifier;
			if (!collection.containsInstance(modelElement)
					&& isInProject(modelElement)) {
				collection.modelElementAdded(collection, modelElement);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.util.EContentAdapter#removeAdapter(org.eclipse.emf.common.notify.Notifier)
	 */
	@Override
	protected void removeAdapter(Notifier notifier) {
		if (isInitializing) {
			return;
		}
		if (currentNotification != null && currentNotification.isTouch()) {
			return;
		}

		if (currentNotification != null
				&& currentNotification.getFeature() instanceof EReference) {
			EReference eReference = (EReference) currentNotification
					.getFeature();
			if (eReference.isContainment() && eReference.getEOpposite() != null
					&& !eReference.getEOpposite().isTransient()) {
				return;
			}
		}

		if (notifier instanceof EObject) {
			EObject modelElement = (EObject) notifier;
			if (!isInProject(modelElement)
					&& collection.containsInstance(modelElement)) {
				removedModelElements.add(modelElement);
			}
		}

	}

	private boolean isInProject(EObject modelElement) {
		EObject parent = modelElement.eContainer();
		if (parent == null) {
			return false;
		}

		if (parent == collection) {
			return true;
		}

		if (collection.containsInstance(parent)) {
			return true;
		}

		return isInProject(parent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.util.EContentAdapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void notifyChanged(Notification notification) {

		if (notificationDisabled) {
			return;
		}

		currentNotification = notification;
		Object feature = notification.getFeature();
		Object notifier = notification.getNotifier();

		if (feature instanceof EReference) {
			EReference eReference = (EReference) feature;

			// Do not create notifications for transient features
			if (eReference.isTransient()) {
				return;
			}

			if (eReference.isContainer()) {
				handleContainer(notification, eReference);
			}
		}

		super.notifyChanged(notification);

		// project is not a valid model element
		if (!notification.isTouch() && notifier instanceof EObject
				&& !(notifier instanceof Project)) {
			collection.notify(notification, collection, (EObject) notifier);
		}
		for (EObject removedModelElement : removedModelElements) {
			collection.modelElementRemoved(collection, removedModelElement);
		}
		removedModelElements.clear();
	}

	/**
	 * @param notification
	 */
	private void handleContainer(Notification notification,
			EReference eReference) {
		if (notification.getEventType() == Notification.SET) {
			Object newValue = notification.getNewValue();
			Object oldValue = notification.getOldValue();
			if (newValue == null && oldValue != null) {
				removeAdapter((Notifier) notification.getNotifier());
			}
		}
	}

	/**
	 * @param notificationDisabled
	 *            the notificationDisabled to set
	 */
	public void disableNotifications(boolean notificationDisabled) {
		this.notificationDisabled = notificationDisabled;
	}

}
