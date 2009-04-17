/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.util;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.impl.ProjectImpl;

/**
 * Notifies about changes in a projectImpl. WARNING: Only for use in Project! Use addProjectObserver of Project to
 * listen for a Project.
 * 
 * @author koegel
 */
public final class ProjectChangeNotifier extends AdapterImpl {

	private ProjectImpl projectImpl;

	/**
	 * Constructor.
	 * 
	 * @param projectImpl the projectImpl
	 */
	public ProjectChangeNotifier(ProjectImpl projectImpl) {
		this.projectImpl = projectImpl;
		TreeIterator<EObject> allContents = projectImpl.eAllContents();
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			if (ModelPackage.eINSTANCE.getModelElement().isInstance(next)) {
				ModelElement modelElement = (ModelElement) next;
				modelElement.eAdapters().add(this);
			}
		}
		projectImpl.eAdapters().add(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void notifyChanged(Notification notification) {

		if (notification.isTouch()) {
			return;
		}
		switch (notification.getEventType()) {
		case Notification.ADD:
			handleAddNotification(notification);
			// fire notification must be triggered after a (possible) create!
			fireNotification(notification);
			break;
		case Notification.ADD_MANY:
			handleAddAllNotification(notification);
			// fire notification must be triggered after a (possible) create!
			fireNotification(notification);
			break;
		case Notification.REMOVE:
			// fire notification must be triggered before a (possible) delete!
			fireNotification(notification);
			// model element is removed from containment hierachy
			if (isAboutContainment(notification)) {
				Object oldValue = notification.getOldValue();
				if (oldValue instanceof ModelElement) {
					ModelElement child = (ModelElement) oldValue;
					handleSingleRemove(notification, child);
				}

			}
			break;
		case Notification.SET:
			// model element is added to containment hierachy
			if (isAboutContainment(notification)) {
				handleSingleAdd((EObject) notification.getNotifier());
			}
			// fire notification must be triggered after a (possible) create!
			fireNotification(notification);
			break;
		case Notification.REMOVE_MANY:
			// fire notification must be triggered before a (possible) delete!
			fireNotification(notification);
			if (isAboutContainment(notification)) {
				Object oldValue = notification.getOldValue();
				if (oldValue instanceof List<?>) {
					@SuppressWarnings("unchecked")
					List<ModelElement> list = (List<ModelElement>) oldValue;
					for (ModelElement child : list) {
						handleSingleRemove(notification, child);
					}
				}
			}
			break;
		default:
			// There's no add or delete operation. Just fire notification.
			fireNotification(notification);
			break;
		}
	}

	private void handleSingleRemove(Notification notification, ModelElement child) {
		if (child.getProject() != projectImpl) {
			child.eAdapters().remove(this);
			projectImpl.addModelElement(child);
		}
	}

	private void fireNotification(Notification notification) {
		Object notifier = notification.getNotifier();
		if (notifier instanceof ModelElement) {
			projectImpl.handleEMFNotification(notification, projectImpl, (ModelElement) notifier);
		}
	}

	// cast cannot be checked properly, flaw in EMF notification design
	@SuppressWarnings("unchecked")
	private void handleAddAllNotification(Notification notification) {
		if (isAboutContainment(notification)) {
			List<EObject> newValues = (List<EObject>) notification.getNewValue();
			for (EObject newElement : newValues) {
				handleSingleAdd(newElement);
			}
		}

	}

	private boolean isAboutContainment(Notification notification) {
		Object feature = notification.getFeature();
		if (feature instanceof EReference) {
			EReference reference = (EReference) feature;
			if (reference.isContainment()) {
				return true;
			}
		}
		return false;
	}

	private void handleAddNotification(Notification notification) {
		if (isAboutContainment(notification)) {
			EObject newValue = (EObject) notification.getNewValue();
			handleSingleAdd(newValue);
		}
	}

	private void handleSingleAdd(EObject newValue) {
		if (ModelPackage.eINSTANCE.getModelElement().isInstance(newValue)) {
			ModelElement modelElement = (ModelElement) newValue;
			// this works only because the contains cache is not yet updated
			if (!projectImpl.contains(modelElement)) {
				newValue.eAdapters().add(this);
				projectImpl.handleEMFModelElementAdded(projectImpl, (ModelElement) newValue);
			} else {
				if (projectImpl.getModelElement(modelElement.getModelElementId()) != modelElement) {
					throw new IllegalStateException("Two elements with the same id but different instance detected!");
				}
			}
		}
	}

}
