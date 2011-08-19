package org.unicase.papyrus.diagram.services;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.papyrus.core.services.IServiceFactory;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.unicase.metamodel.Project;

public class UnicaseEditingDomainServiceFactory implements IServiceFactory {

	private Project project;

	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		if(servicesRegistry instanceof UnicaseServicesRegistry) {
			project = ((UnicaseServicesRegistry) servicesRegistry).getProject();
		}
	}

	public void startService() throws ServiceException {
	}

	public void disposeService() throws ServiceException {
	}

	public Object createServiceInstance() throws ServiceException {
		return AdapterFactoryEditingDomain.getEditingDomainFor(project);
	}
	
}
