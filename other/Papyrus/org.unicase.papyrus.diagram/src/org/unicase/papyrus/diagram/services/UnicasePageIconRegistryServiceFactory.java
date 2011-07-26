package org.unicase.papyrus.diagram.services;

import org.eclipse.papyrus.core.services.IServiceFactory;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.unicase.papyrus.diagram.services.UnicaseUMLIconRegistry;

public class UnicasePageIconRegistryServiceFactory implements IServiceFactory {

	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
	}

	public void startService() throws ServiceException {
	}

	public void disposeService() throws ServiceException {
	}

	public Object createServiceInstance() throws ServiceException {
		return UnicaseUMLIconRegistry.getInstance();
	}

}
