/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.storage;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.unicase.emfstore.ServerConfiguration;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;

/**
 * Implementation of a {@link ResourceStorage} backed by an XMLResource.
 * 
 * @author koegel
 */
public class XMLStorage implements ResourceStorage {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.storage.ResourceStorage#init(java.util.Properties)
	 */
	public URI init(Properties properties) throws FatalEmfStoreException {
		ResourceSet resourceSet = new ResourceSetImpl();
		String pathName = ServerConfiguration.getServerMainFile();
		URI fileURI = URI.createFileURI(pathName);
		File serverFile = new File(pathName);
		if (!serverFile.exists()) {
			try {
				Resource resource = resourceSet.createResource(fileURI);
				resource.save(null);
			} catch (IOException e) {
				throw new FatalEmfStoreException("Could not init XMLRessource", e);
			}
		}
		return fileURI;
	}
}
