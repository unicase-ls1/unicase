/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.common.model.util;

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
public class ProjectChangeNotifier extends EContentAdapter {

	private final ProjectImpl projectImpl;
	private boolean isInitializing;
	private EObject removedModelElement;
	private Notification currentNotification;
	private int reentrantCallToAddAdapterCounter;
	private boolean notificationDisabled;

	/**
	 * Constructor. Attaches the Adapter to the given {@link ProjectImpl}.
	 * 
	 * @param projectImpl the project
	 */
	public ProjectChangeNotifier(ProjectImpl projectImpl) {
		this.projectImpl = projectImpl;
		isInitializing = true;
		projectImpl.eAdapters().add(this);
		isInitializing = false;
		reentrantCallToAddAdapterCounter = 0;
		notificationDisabled = false;

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
			// any other than the first call in re-entrant calls to addAdapter are going to call the project
			return;
		}

		if (!isInitializing && notifier instanceof EObject && !ModelUtil.isIgnoredDatatype((EObject) notifier)) {
			EObject modelElement = (EObject) notifier;
			if (!projectImpl.containsInstance(modelElement) && isInProject(modelElement)) {
				projectImpl.handleEMFModelElementAdded(projectImpl, modelElement);
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

		if (currentNotification != null && currentNotification.getFeature() instanceof EReference) {
			EReference eReference = (EReference) currentNotification.getFeature();
			if (eReference.isContainment() && eReference.getEOpposite() != null
				&& !eReference.getEOpposite().isTransient()) {
				return;
			}
		}

		if (notifier instanceof EObject) {
			EObject modelElement = (EObject) notifier;
			if (!isInProject(modelElement) && projectImpl.containsInstance(modelElement)) {
				removedModelElement = modelElement;
			}
		}

	}

	private boolean isInProject(EObject modelElement) {
		EObject parent = modelElement.eContainer();
		if (parent == null) {
			return false;
		}

		if (parent == projectImpl) {
			return true;
		}

		if (projectImpl.containsInstance(parent)) {
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
		if (!notification.isTouch() && notifier instanceof EObject && !(notifier instanceof Project)) {
			projectImpl.handleEMFNotification(notification, projectImpl, (EObject) notifier);
		}
		if (removedModelElement != null) {
			projectImpl.handleEMFModelElementRemoved(projectImpl, removedModelElement);
			removedModelElement = null;
		}
	}

	/**
	 * @param notification
	 */
	private void handleContainer(Notification notification, EReference eReference) {
		if (notification.getEventType() == Notification.SET) {
			Object newValue = notification.getNewValue();
			Object oldValue = notification.getOldValue();
			if (newValue == null && oldValue != null) {
				removeAdapter((Notifier) notification.getNotifier());
			}
		}
	}

	/**
	 * @param notificationDisabled the notificationDisabled to set
	 */
	public void disableNotifications(boolean notificationDisabled) {
		this.notificationDisabled = notificationDisabled;
	}

}
