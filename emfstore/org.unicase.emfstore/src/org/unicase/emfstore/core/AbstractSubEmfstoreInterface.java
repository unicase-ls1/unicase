/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.core;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.common.model.Project;
import org.unicase.emfstore.accesscontrol.AuthorizationControl;
import org.unicase.emfstore.core.helper.ResourceHelper;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;

/**
 * This is the super class for all subinterfaces of emfstore. Main interfaces, such as {@link EmfStoreImpl}, check and
 * than delegates method calls to these subinterfaces, where the actual functionality is implemented. Subinterfaces
 * shouldn't be accessed without the corresponding main interface, because they rely on the sanity checks of the main
 * interfaces. The idea behind subinterfaces is to divide an emfstore interface into logical pieces and to avoid huge
 * classes.
 * 
 * @author wesendon
 */
public abstract class AbstractSubEmfstoreInterface {

	private final AbstractEmfstoreInterface parentInterface;
	private ResourceHelper resourceHelper;

	/**
	 * Default constructor.
	 * 
	 * @param parentInterface parentInterface
	 * @throws FatalEmfStoreException if parent interface is null
	 */
	public AbstractSubEmfstoreInterface(AbstractEmfstoreInterface parentInterface) throws FatalEmfStoreException {
		if (parentInterface == null) {
			throw new FatalEmfStoreException();
		}
		this.parentInterface = parentInterface;
	}

	/**
	 * This method is called after the initialisation of the parent interface.
	 * 
	 * @throws FatalEmfStoreException exception
	 */
	protected void initSubInterface() throws FatalEmfStoreException {
		resourceHelper = new ResourceHelper(parentInterface.getServerSpace());
	}

	/**
	 * Returns the ResourceHelper.
	 * 
	 * @return resourceHelper
	 */
	public ResourceHelper getResourceHelper() {
		return resourceHelper;
	}

	/**
	 * Saves an eObject.
	 * 
	 * @param object the object
	 * @throws FatalEmfStoreException in case of failure
	 */
	protected void save(EObject object) throws FatalEmfStoreException {
		resourceHelper.save(object);
	}

	/**
	 * Saves an eObject together with all model element IDs of the given project.
	 * 
	 * @param object the object
	 * @param project the project, that contains the model element IDs to be saved
	 * @throws FatalEmfStoreException in case of failure
	 */
	protected void saveWithProject(EObject object, Project project) throws FatalEmfStoreException {
		resourceHelper.saveWithProject(object, project);
	}

	/**
	 * Returns the serverspace. Please always use a monitor ({@link #getMonitor()}) when operating on the serverspace.
	 * 
	 * @return serverspace
	 */
	protected ServerSpace getServerSpace() {
		return parentInterface.getServerSpace();
	}

	/**
	 * Return a monitor object which should be used when operating on the serverspace.
	 * 
	 * @return monitor object
	 */
	protected Object getMonitor() {
		return parentInterface.getMonitor();
	}

	/**
	 * Returns the authorizationControl.
	 * 
	 * @return authorizationControl
	 */
	protected AuthorizationControl getAuthorizationControl() {
		return parentInterface.getAuthorizationControl();
	}

	/**
	 * This method gets a subinterface from the parent interface. Can be used if you need some functionality from
	 * another subinterface.
	 * 
	 * @param <T> subinterface type
	 * @param clazz class of subinterface
	 * @return subinterface
	 */
	protected <T> T getSubInterface(Class<T> clazz) {
		return parentInterface.getSubInterface(clazz);
	}
}
