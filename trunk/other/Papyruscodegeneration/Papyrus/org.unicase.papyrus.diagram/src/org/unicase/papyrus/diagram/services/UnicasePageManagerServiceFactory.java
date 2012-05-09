/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.diagram.services;

import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.papyrus.core.services.IServiceFactory;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;

/**
 * Service factory for unicase page manager regarding Papyrus UML diagrams. This factory will return a
 * {@link UnicasePageManager} instance.
 * 
 * @author mharut
 */
public class UnicasePageManagerServiceFactory implements IServiceFactory {

	private IPageMngr manager;

	/**
	 * {@inheritDoc}
	 */
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		if (servicesRegistry instanceof UnicaseServicesRegistry) {
			Project project = ((UnicaseServicesRegistry) servicesRegistry).getProject();
			manager = new UnicasePageManager(project);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void startService() throws ServiceException {
	}

	/**
	 * {@inheritDoc}
	 */
	public void disposeService() throws ServiceException {
	}

	/**
	 * {@inheritDoc}
	 */
	public Object createServiceInstance() throws ServiceException {
		return manager;
	}

}
