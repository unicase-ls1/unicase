/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.util;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.model.impl.ProjectImpl;

/**
 * Notifies about changes in a projectImpl. WARNING: Only for use in Project! Use addProjectObserver of Project to
 * listen for a Project.
 * 
 * @author koegel
 */
public final class ProjectChangeNotifier extends EContentAdapter {

	private boolean initIsCompleted;

	/**
	 * Constructor.
	 * 
	 * @param projectImpl the projectImpl
	 */
	public ProjectChangeNotifier(ProjectImpl projectImpl) {
		initIsCompleted = false;
		this.projectImpl = projectImpl;
		projectImpl.eAdapters().add(this);
		// register at Project to listen for deletes
		projectImpl.addProjectChangeObserver(new ProjectDeleteObserver() {
			@Override
			public void modelElementDeleteStarted(Project project, ModelElement modelElement) {
				isDeleting = true;
			}

			@Override
			public void modelElementDeleteCompleted(Project project, ModelElement modelElement) {
				isDeleting = false;
			}
		});
		initIsCompleted = true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.util.EContentAdapter#addAdapter(org.eclipse.emf.common.notify.Notifier)
	 */
	@Override
	protected void addAdapter(Notifier notifier) {
		super.addAdapter(notifier);

		if (!initIsCompleted || !(notifier instanceof ModelElement)) {
			return;
		}
		ModelElement modelElement = (ModelElement) notifier;
		// this works only because the contains cache is not yet updated
		if (!projectImpl.contains(modelElement)) {
			projectImpl.handleEMFModelElementAdded(projectImpl, modelElement);
		} else {
			if (projectImpl.getModelElement(modelElement.getModelElementId()) != modelElement) {
				throw new IllegalStateException("Two elements with the same id but different instance detected!");
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
		super.removeAdapter(notifier);
		if (!initIsCompleted || !(notifier instanceof ModelElement)) {
			return;
		}
		ModelElement modelElement = (ModelElement) notifier;
		if (!isDeleting && modelElement.getProject() != projectImpl) {
			projectImpl.addModelElement(modelElement);
		}
	}

	private ProjectImpl projectImpl;
	private boolean isDeleting;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		if (notification.isTouch()) {
			return;
		}
		Object notifier = notification.getNotifier();
		if (notifier instanceof ModelElement && ((ModelElement) notifier).getProject() != null) {
			projectImpl.handleEMFNotification(notification, projectImpl, (ModelElement) notifier);
		}
	}

}
