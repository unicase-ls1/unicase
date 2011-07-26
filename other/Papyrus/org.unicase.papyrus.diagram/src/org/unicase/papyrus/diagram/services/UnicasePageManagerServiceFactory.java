package org.unicase.papyrus.diagram.services;

import org.eclipse.papyrus.core.services.IServiceFactory;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.unicase.metamodel.Project;
import org.unicase.papyrus.diagram.services.UnicasePageManager;

public class UnicasePageManagerServiceFactory implements IServiceFactory {
	
	private IPageMngr manager;
	
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		if(servicesRegistry instanceof UnicaseServicesRegistry) {
			Project project = ((UnicaseServicesRegistry) servicesRegistry).getProject();
			manager = new UnicasePageManager(project); 
		}
	}

	public void startService() throws ServiceException {
	}

	public void disposeService() throws ServiceException {
	}

	public Object createServiceInstance() throws ServiceException {
		return manager;
	}

}
