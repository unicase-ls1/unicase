/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ecpemfstorebridge.validation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EReferenceImpl;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ProjectChangeObserver;
import org.unicase.ui.common.validation.providers.ValidationResultProvider;

/**
 * The {@link EMFStoreValidationResultProvider} offers methods to subscribe to constraint violation changes, and
 * initializes, maintains and provides the results of the live and batch validation runs.
 * 
 * @author pfeifferc
 */
public final class EMFStoreValidationResultProvider extends ValidationResultProvider implements ProjectChangeObserver {

	/**
	 * The constructor.
	 */
	public EMFStoreValidationResultProvider() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.validation.providers.ValidationResultProvider#init(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public synchronized void init(EObject rootElement) {
		setRootElement(rootElement);
		update(validateSimple(getRootElement(), true));
		update(extractConstraintStatiFrom(validateBatch(getRootElement(), true)));
		((Project) rootElement).addProjectChangeObserver(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#modelElementAdded(org.unicase.metamodel.Project,
	 *      org.unicase.metamodel.ModelElement)
	 */
	public void modelElementAdded(Project project, ModelElement modelElement) {
		handleAdded(modelElement);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#modelElementRemoved(org.unicase.metamodel.Project,
	 *      org.unicase.metamodel.ModelElement)
	 */
	public void modelElementRemoved(Project project, ModelElement modelElement) {
		handleRemoved(modelElement);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification,
	 *      org.unicase.metamodel.Project, org.unicase.metamodel.ModelElement)
	 */
	public void notify(Notification notification, Project project, ModelElement modelElement) {
		EObject target = null;
		// find out target
		if (notification.getFeature() instanceof EReferenceImpl && notification.getNewValue() instanceof EObject) {
			target = (EObject) notification.getNewValue();
		} else {
			target = modelElement;
		}
		handleChanged(target);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#projectDeleted(org.unicase.metamodel.Project)
	 */
	public void projectDeleted(Project project) {
		((Project) getRootElement()).removeProjectChangeObserver(this);
		getViolations().clear();
		getValidationListeners().clear();
	}
}
