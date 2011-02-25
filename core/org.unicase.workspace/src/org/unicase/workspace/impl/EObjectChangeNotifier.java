/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.workspace.EObjectChangeObserver;
import org.unicase.workspace.EObjectChangeObserverNotificationCommand;

/**
 * @author Adrian Staudt
 */
public class EObjectChangeNotifier extends EContentAdapter {

	private boolean isInitializing;
	private EObject removedModelElement;
	private Notification currentNotification;

	private final List<EObjectChangeObserver> observers;
	private boolean isNotifiying;
	private final Set<EObjectChangeObserver> exceptionThrowingObservers;
	private final Set<EObjectChangeObserver> observersToRemove;
	private final Set<EObjectChangeObserver> undetachableObservers;

	/**
	 * Constructor.
	 * 
	 * @param eObjectToTrack The EObject that will inform this notifier about changes.
	 */
	public EObjectChangeNotifier(EObject eObjectToTrack) {
		isInitializing = true;
		eObjectToTrack.eAdapters().add(this);

		observers = new ArrayList<EObjectChangeObserver>();
		isNotifiying = false;
		exceptionThrowingObservers = new HashSet<EObjectChangeObserver>();
		observersToRemove = new HashSet<EObjectChangeObserver>();
		undetachableObservers = new HashSet<EObjectChangeObserver>();

		isInitializing = false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.util.EContentAdapter#addAdapter(org.eclipse.emf.common.notify.Notifier)
	 */
	@Override
	protected void addAdapter(Notifier notifier) {
		if (!isInitializing && notifier instanceof EObject && !ModelUtil.isIgnoredDatatype((EObject) notifier)) {
			EObject eObject = (EObject) notifier;
			handleEMFModelElementAdded(eObject);
		}

		if (!notifier.eAdapters().contains(this)) {
			super.addAdapter(notifier);
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

		if (currentNotification != null && currentNotification.getFeature() instanceof EReference) {
			EReference eReference = (EReference) currentNotification.getFeature();
			if (eReference.isContainment() && eReference.getEOpposite() != null
				&& !eReference.getEOpposite().isTransient()) {
				return;
			}
		}

		if (notifier instanceof EObject) {
			EObject eObject = (EObject) notifier;
			removedModelElement = eObject;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.util.EContentAdapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void notifyChanged(Notification notification) {
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

		if (!notification.isTouch() && notifier instanceof EObject) {
			handleEMFNotification(notification, (EObject) notifier);
		}
		if (removedModelElement != null) {
			handleEMFModelElementRemoved(removedModelElement);
			removedModelElement = null;
		}
	}

	private void handleContainer(Notification notification, EReference eReference) {
		if (notification.getEventType() == Notification.SET) {
			Object newValue = notification.getNewValue();
			Object oldValue = notification.getOldValue();
			if (newValue == null && oldValue != null) {
				removeAdapter((Notifier) notification.getNotifier());
			}
		}
	}

	private void handleEMFModelElementAdded(final EObject eObject) {
		EObjectChangeObserverNotificationCommand command = new EObjectChangeObserverNotificationCommand() {
			public void run(EObjectChangeObserver eObjectChangeObserver) {
				eObjectChangeObserver.eObjectAdded(eObject);
			}
		};
		notifyEObjectChangeObservers(command);

	}

	private void handleEMFModelElementRemoved(final EObject removedModelElement) {
		// removeModelElementAndChildrenFromCache(modelElement);
		EObjectChangeObserverNotificationCommand command = new EObjectChangeObserverNotificationCommand() {
			public void run(EObjectChangeObserver eObjectChangeObserver) {
				eObjectChangeObserver.eObjectRemoved(removedModelElement);
			}
		};
		notifyEObjectChangeObservers(command);
	}

	private void handleEMFNotification(final Notification notification, final EObject notifier) {
		EObjectChangeObserverNotificationCommand command = new EObjectChangeObserverNotificationCommand() {
			public void run(EObjectChangeObserver eObjectChangeObserver) {
				eObjectChangeObserver.notify(notification, notifier);
			}
		};
		notifyEObjectChangeObservers(command);
	}

	private void notifyEObjectChangeObservers(final EObjectChangeObserverNotificationCommand command) {
		// new UnicaseCommand() {
		//
		// @Override
		// protected void doRun() {
		isNotifiying = true;
		for (EObjectChangeObserver eObjectChangeObserver : observers) {
			try {
				command.run(eObjectChangeObserver);
				// BEGIN SUPRESS CATCH EXCEPTION
			} catch (RuntimeException ex) {
				// END SUPRESS CATCH EXCEPTION
				if (exceptionThrowingObservers.contains(eObjectChangeObserver)) {
					if (!undetachableObservers.contains(eObjectChangeObserver)) {
						observersToRemove.add(eObjectChangeObserver);
						ModelUtil.logException(
							"Project Change Observer threw an exception again, it has been detached, UI may not update now: "
								+ eObjectChangeObserver.getClass().getName(), ex);
					} else {
						ModelUtil.logException(
							"Project Change Observer threw an exception again, but it will not be detached."
								+ eObjectChangeObserver.getClass().getName(), ex);
					}
				} else {
					exceptionThrowingObservers.add(eObjectChangeObserver);
					ModelUtil.logWarning("Project Change Observer threw an exception: "
						+ eObjectChangeObserver.getClass().getName(), ex);
				}
			}
		}
		isNotifiying = false;
		for (EObjectChangeObserver observer : observersToRemove) {
			removeEObjectChangeObserver(observer);
		}
		observersToRemove.clear();

		// }
		// }.run(true);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.Project#addProjectChangeObserver(org.unicase.model.util.ProjectChangeObserver)
	 */
	public void addEObjectChangeObserver(EObjectChangeObserver eObjectChangeObserver) {
		this.observers.add(eObjectChangeObserver);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.Project#removeEObjectChangeObserver(org.unicase.model.util.ProjectChangeObserver)
	 */
	public void removeEObjectChangeObserver(EObjectChangeObserver eObjectChangeObserver) {
		if (isNotifiying) {
			observersToRemove.add(eObjectChangeObserver);
			return;
		}
		this.observers.remove(eObjectChangeObserver);
		exceptionThrowingObservers.remove(eObjectChangeObserver);
		undetachableObservers.remove(eObjectChangeObserver);
	}
}
