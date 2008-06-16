package org.unicase.emfstore.storage;

import java.io.IOException;
import java.util.Properties;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.unicase.emfstore.ServerConfiguration;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;

public class XMLStorage implements ResourceStorage {

	public URI init(Properties properties) throws FatalEmfStoreException {
		ResourceSet resourceSet = new ResourceSetImpl();
		String pathName = ServerConfiguration.getServerHome()+"storage";
		URI fileURI = URI.createFileURI(pathName);
		Resource resource = resourceSet.createResource(fileURI);
		try {
			resource.save(null);
		} catch (IOException e) {
			throw new FatalEmfStoreException("Could not init XMLRessource",e);
		}
		return fileURI;
	}

}
