package org.unicase.papyrus.custom.services;

import org.eclipse.papyrus.core.services.IServiceFactory;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;

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
