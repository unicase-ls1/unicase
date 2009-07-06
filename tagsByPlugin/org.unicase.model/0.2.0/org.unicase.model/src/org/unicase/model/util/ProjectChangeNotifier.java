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
		switch (notification.getEventType()) {
		case Notification.ADD:
			handleAddNotification(notification);
			break;
		case Notification.ADD_MANY:
			handleAddAllNotification(notification);
			break;
		case Notification.SET:
			//model element is removed from containment hierachy
			if (isAboutContainer(notification)) {
				ModelElement modelElement = (ModelElement) notification.getNotifier();
				EObject newParent = (EObject) notification.getNewValue();
				if (newParent == null) {
					//check if model element is really removed from project
					if (modelElement.getProject()!=project) {
						//on a remove fire notification first and then the remove
						fireNotification(notification);
						this.projectChangeObserver.modelElementRemoved(project, modelElement);
						return;
					}
				}
			}
			
			//model element is added to containment hierachy
			if (isAboutContainment(notification)) {
				handleSingleAdd((EObject) notification.getNotifier());
			}
			break;
		default:
			// nop
			break;

		}

		fireNotification(notification);

	}

	private void fireNotification(Notification notification) {
		Object notifier = notification.getNotifier();
		if (notifier instanceof ModelElement) {
			this.projectChangeObserver.notify(notification, project,
					(ModelElement) notifier);
		}
	}


	// cast cannot be checked properly, flaw in EMF notification design
	@SuppressWarnings("unchecked")
	private void handleAddAllNotification(Notification notification) {
		if (isAboutContainment(notification)) {
			List<EObject> newValues = (List<EObject>) notification
					.getNewValue();
			for (EObject newElement : newValues) {
				handleSingleAdd(newElement);
			}
		}

	}

	private boolean isAboutContainer(Notification notification) {
		Object feature = notification.getFeature();
		if (feature instanceof EReference) {
			EReference reference = (EReference) feature;
			if (reference.isContainer()) {
				return true;
			}
		}
		return false;
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
			if (!project.contains(modelElement)) {
				newValue.eAdapters().add(this);
				this.projectChangeObserver.modelElementAdded(project,
						(ModelElement) newValue);
			}
		}
	}

}
