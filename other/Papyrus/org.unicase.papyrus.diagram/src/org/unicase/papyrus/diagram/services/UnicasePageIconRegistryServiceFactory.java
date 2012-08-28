/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.diagram.services;

import org.osgi.framework.ServiceException;

/**
 * Service factory for page icons in Unicase. Will return an instance of {@link UnicasePapyrusIconRegistry}.
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
		return UnicasePapyrusIconRegistry.getInstance();
	}

}
