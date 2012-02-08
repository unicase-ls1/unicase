/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.diagram.services;

import org.eclipse.papyrus.core.services.IServiceFactory;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;

/**
 * Service factory for page icons in Unicase. Will return an instance of {@link UnicaseUMLIconRegistry}.
 * 
 * @author mharut
 */
public class UnicasePageIconRegistryServiceFactory implements IServiceFactory {

	/**
	 * {@inheritDoc}
	 */
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
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
		return UnicaseUMLIconRegistry.getInstance();
	}

}
