package org.unicase.papyrus.diagram.services;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.core.services.ExtensionServicesRegistry;
import org.eclipse.papyrus.core.services.ServiceException;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;

public class UnicaseServicesRegistry extends ExtensionServicesRegistry {
	
	private Project project;

	public UnicaseServicesRegistry(String extensionPointNamespace, EObject element)
			throws ServiceException {
		super(extensionPointNamespace);
		project = ModelUtil.getProject(element);
	}
	
	public Project getProject() {
		return project;
	}
	
}
