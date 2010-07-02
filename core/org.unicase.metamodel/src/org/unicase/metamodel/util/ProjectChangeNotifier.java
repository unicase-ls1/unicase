/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel.util;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.impl.EObjectToModelElementIdMapImpl;
import org.unicase.metamodel.impl.ProjectImpl;

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

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.util.EContentAdapter#addAdapter(org.eclipse.emf.common.notify.Notifier)
	 */
	@Override
	protected void addAdapter(Notifier notifier) {
		if (!isInitializing && notifier instanceof EObjectToModelElementIdMapImpl) {
			return;
		} else if (!isInitializing && notifier instanceof EObject) {
			EObject modelElement = (EObject) notifier;
			ModelElementId modelElementId = ModelUtil.getProject(modelElement).getModelElementId(modelElement);
			// handle same id but different instance, probably copied element
			if (projectImpl.contains(modelElement) && projectImpl.getModelElement(modelElementId) != modelElement) {
				ModelUtil.reassignModelElementIds(modelElement);
			}

			if (!projectImpl.contains(modelElement) && isInProject(modelElement)) {
				projectImpl.handleEMFModelElementAdded(projectImpl, modelElement);
			}
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
			if (eReference.isContainment() && eReference.getEOpposite() != null) {
				return;
			}
		}

		if (notifier instanceof EObject) {
			EObject modelElement = (EObject) notifier;
			if (!isInProject(modelElement) && projectImpl.contains(modelElement)) {
				removedModelElement = modelElement;
				// super.removeAdapter(modelElement);
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

		if (parent == null) {
			return false;
		}

		EObject parentModelElement = parent;

		if (projectImpl.contains(parentModelElement)) {
			return true;
		}

		return isInProject(parentModelElement);
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

		Object notifier = notification.getNotifier();

		// project is not a valid model element
		if (!notification.isTouch() && notifier instanceof EObject && !(notifier instanceof Project)) {

			if (notification.getNewValue() instanceof EObjectToModelElementIdMapImpl) {
				return;
			}
			if (notifier instanceof EObjectToModelElementIdMapImpl) {
				EObjectToModelElementIdMapImpl map = (EObjectToModelElementIdMapImpl) notifier;
				ModelElementId id = map.getValue();
				projectImpl.handleEMFNotification(notification, projectImpl, id);
			} else {
				projectImpl.handleEMFNotification(notification, projectImpl, (EObject) notifier);
			}
		}
		if (removedModelElement != null) {
			projectImpl.handleEMFModelElementRemoved(projectImpl, removedModelElement);
			// asuper.removeAdapter(removedModelElement);
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

}
