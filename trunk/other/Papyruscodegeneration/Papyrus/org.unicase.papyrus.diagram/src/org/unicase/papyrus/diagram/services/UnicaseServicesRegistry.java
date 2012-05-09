/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.diagram.services;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.papyrus.core.services.ExtensionServicesRegistry;
import org.eclipse.papyrus.core.services.ServiceException;

/**
 * Services registry for UML papyrus diagrams in unicase.
 * 
 * @author mharut
 */
public class UnicaseServicesRegistry extends ExtensionServicesRegistry {

	private Project project;

	/**
	 * Creates a new services registry for a certain {@link EObject} in some extension point namespace.
	 * 
	 * @param extensionPointNamespace the namespace of the extension points to filter
	 * @param element the EObject to create the registry for
	 * @throws ServiceException if initializing one of the services fails
	 */
	public UnicaseServicesRegistry(String extensionPointNamespace, EObject element) throws ServiceException {
		super(extensionPointNamespace);
		project = ModelUtil.getProject(element);
	}

	/**
	 * Retrieves the {@link Project} of this services registry.
	 * 
	 * @return the corresponding project
	 */
	public Project getProject() {
		return project;
	}

}
