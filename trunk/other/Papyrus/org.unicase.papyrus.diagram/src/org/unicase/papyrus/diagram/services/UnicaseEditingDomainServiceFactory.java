/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.diagram.services;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.papyrus.core.services.IServiceFactory;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.osgi.framework.ServiceException;

/**
 * Service factory for editing domains. This will return the editing domain of the corresponding project.
 * 
 * @author mharut
 */
public class UnicaseEditingDomainServiceFactory implements IServiceFactory {

	private Project project;

	/**
	 * {@inheritDoc}
	 */
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		if (servicesRegistry instanceof UnicaseServicesRegistry) {
			project = ((UnicaseServicesRegistry) servicesRegistry).getProject();
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
		return AdapterFactoryEditingDomain.getEditingDomainFor(project);
	}

}
