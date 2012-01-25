package org.unicase.papyrus.diagram.services;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.papyrus.core.services.ExtensionServicesRegistry;
import org.eclipse.papyrus.core.services.ServiceException;

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
