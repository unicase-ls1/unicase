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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.common.model.Project;

/**
 * This abstract class reacts to the changes of individual model elements. It implements the ProjectChangeObserver
 * interface, so you have to register it with the project. You can inherit this class for further filtering of the
 * events, but of course you cannot override the classes own filtering methods.
 * 
 * @author andy
 */
public abstract class ModelElementChangeObserver implements ProjectChangeObserver {

	/**
	 * Notify all model elements listener because a project delete is also deleting all contained model elements.
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.util.ProjectChangeObserver#projectDeleted(org.eclipse.emf.emfstore.common.model.Project)
	 * @param project the deleted project
	 */
	public final void projectDeleted(Project project) {

		List<EObject> elements = new ArrayList<EObject>(observedElements);
		for (EObject modelElement : elements) {
			this.modelElementRemoved(project, modelElement);
		}

	}

	private List<EObject> observedElements;

	/**
	 * @param observedElements the set of elements that will be observed
	 */
	public ModelElementChangeObserver(List<EObject> observedElements) {
		this();
		this.observedElements.addAll(observedElements);
	}

	/**
	 * Empty constructor. You can add elements to observe with {@link #observeElement(EObject)}
	 */
	public ModelElementChangeObserver() {
		this.observedElements = new ArrayList<EObject>();
	}

	/**
	 * Will observe one more element, for example a new child.
	 * 
	 * @param newElement the new element to be observed
	 */
	public void observeElement(EObject newElement) {
		this.observedElements.add(newElement);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.util.ProjectChangeObserver#modelElementAdded(org.eclipse.emf.emfstore.common.model.Project,
	 *      org.eclipse.emf.core.EObject)
	 */
	public final void modelElementAdded(Project project, EObject modelElement) {
		// reacting to new elements would be a contradiction to the idea of this class.
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.util.ProjectChangeObserver#modelElementRemoved(org.eclipse.emf.emfstore.common.model.Project,
	 *      org.eclipse.emf.ecore.EObject)
	 */
	public final void modelElementRemoved(Project project, EObject modelElement) {
		Set<EObject> deletedElements = ModelUtil.getAllContainedModelElements(modelElement, false);
		deletedElements.add(modelElement);
		for (EObject deletedElement : deletedElements) {
			if (isObservedElement(deletedElement)) {
				observedElements.remove(deletedElement);
				this.onElementDeleted(deletedElement);
			}
		}
	}

	/**
	 * Implement this method to react to the deletion of one of the observed elements.
	 * 
	 * @param element the element that was deleted
	 */
	protected abstract void onElementDeleted(EObject element);

	/**
	 * {@inheritDoc}
	 */
	public final void modelElementDeleteStarted(Project project, EObject modelElement) {
		// uninteresting, do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification,
	 *      org.eclipse.emf.emfstore.common.model.Project, org.eclipse.emf.ecore.EObject)
	 */
	public final void notify(Notification notification, Project project, EObject modelElement) {
		if (this.isObservedElement(modelElement)) {
			this.onNotify(notification, modelElement);
		}
	}

	/**
	 * Implement this method to react to a notification of one of the observed elements.
	 * 
	 * @param notification the notification sent
	 * @param element the notifying element
	 */
	protected abstract void onNotify(Notification notification, EObject element);

	/**
	 * Checks if the observer wants to know about changes of the element.
	 * 
	 * @param element to be checked
	 * @return forward change event?
	 */
	private boolean isObservedElement(EObject element) {
		return this.observedElements.contains(element);
	}

}
