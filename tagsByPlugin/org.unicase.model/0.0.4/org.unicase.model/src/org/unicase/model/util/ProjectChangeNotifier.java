/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
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
import org.unicase.model.Project;

/**
 * Notifies about changes in a project. WARNING: Only for use in Project! Use
 * addProjectObserver of Project to listen for a Project.
 * 
 * @author koegel
 * 
 */
public class ProjectChangeNotifier extends AdapterImpl {

	private ProjectChangeObserver projectChangeObserver;
	private Project project;

	/**
	 * Constructor.
	 * 
	 * @param project
	 *            the project
	 * @param projectChangeObserver
	 *            the listener
	 */
	public ProjectChangeNotifier(Project project,
			ProjectChangeObserver projectChangeObserver) {

		if (!(projectChangeObserver instanceof Project)) {
			throw new IllegalArgumentException(
					"This Notifier is only to be used by Project!");
		}

		this.projectChangeObserver = projectChangeObserver;
		this.project = project;
		TreeIterator<EObject> allContents = project.eAllContents();
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			if (ModelPackage.eINSTANCE.getModelElement().isInstance(next)) {
				ModelElement modelElement = (ModelElement) next;
				modelElement.eAdapters().add(this);
			}
		}
		project.eAdapters().add(this);
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
		if ((notification.getFeature() instanceof EReference)) {
			EReference reference = (EReference) notification.getFeature();
			if (reference.isContainment()) {
				switch (notification.getEventType()) {
				case Notification.ADD:
					handleAddNotification(notification);
					break;
				case Notification.ADD_MANY:
					handleAddAllNotification(notification);
					break;
				case Notification.REMOVE:
					handleRemoveNotification(notification);
					break;
				case Notification.REMOVE_MANY:
					handleRemoveAllNotification(notification);
					break;
				case Notification.SET:
					handleSetNotification(notification);
					break;
				default:
					throw new IllegalStateException(
							"Unknown containment notification received");
				}

			}

		}

		Object notifier = notification.getNotifier();
		if (notifier instanceof ModelElement) {
			this.projectChangeObserver.notify(notification, project,
					(ModelElement) notifier);
		}

	}

	private void handleSetNotification(Notification notification) {
		Object newSetValue = notification.getNewValue();
		Object oldSetValue = notification.getOldValue();
		if (newSetValue != null) {
			if (newSetValue instanceof ModelElement) {
				this.projectChangeObserver.modelElementAdded(project,
						(ModelElement) newSetValue);
			}
		} else {
			if (oldSetValue instanceof ModelElement) {
				this.projectChangeObserver.modelElementRemoved(project,
						(ModelElement) oldSetValue);
			}
		}
	}

	
	private void handleRemoveAllNotification(Notification notification) {
		//cast cannot be checked properly, flaw in EMF notification design
		@SuppressWarnings("unchecked")
		List<EObject> oldValues = (List<EObject>) notification.getOldValue();
		for (EObject newElement : oldValues) {
			if (ModelPackage.eINSTANCE.getModelElement().isInstance(newElement)) {
				ModelElement modelElement = (ModelElement) newElement;
				newElement.eAdapters().remove(this);
				this.projectChangeObserver.modelElementRemoved(project,
						modelElement);
			}

		}
	}

	private void handleRemoveNotification(Notification notification) {
		EObject oldValue = (EObject) notification.getOldValue();
		if (ModelPackage.eINSTANCE.getModelElement().isInstance(oldValue)) {
			oldValue.eAdapters().remove(this);
			this.projectChangeObserver.modelElementRemoved(project,
					(ModelElement) oldValue);
		}
	}

	private void handleAddAllNotification(Notification notification) {
		//cast cannot be checked properly, flaw in EMF notification design
		@SuppressWarnings("unchecked")
		List<EObject> newValues = (List<EObject>) notification.getNewValue();
		for (EObject newElement : newValues) {
			if (ModelPackage.eINSTANCE.getModelElement().isInstance(newElement)) {
				ModelElement modelElement = (ModelElement) newElement;
				if (!project.contains(modelElement)) {
					newElement.eAdapters().add(this);
					this.projectChangeObserver.modelElementAdded(project,
							modelElement);
				}
			}

		}
	}

	private void handleAddNotification(Notification notification) {
		EObject newValue = (EObject) notification.getNewValue();
		if (ModelPackage.eINSTANCE.getModelElement().isInstance(newValue)) {
			ModelElement modelElement = (ModelElement) newValue;
			if (!project.contains(modelElement)) {
				newValue.eAdapters().add(this);
				this.projectChangeObserver.modelElementAdded(project,
						(ModelElement) newValue);
			}
		}
	}

}
