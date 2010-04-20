/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.config;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import org.unicase.metamodel.util.ModelUtil;

import config.ConfigEntity;

/**
 * Class for saving and loading configuration entities. 
 * Currently the configuration settings are saved file-based 
 * within the user's home directory.
 * 
 * @author Edgar Müller, Fatih Ulusoy
 */
public final class ConfigEntityStore {
	
	private static ConfigEntityStore instance;
		
	/**
	 * Returns an instance of the entity store.
	 * @return Instance of <code>ConfigEntityStore</code>
	 */
	public static ConfigEntityStore getInstance() {
		
		if (instance == null) {
			instance = new ConfigEntityStore();
		}
		return instance;
	}
	
	/**
	 * Private constructor.
	 */
	private ConfigEntityStore() {
		// nothing to do
	}
		
	/**
	 * Saves the given configuration entity.
	 * 
	 * @param entity Entity that will be saved.
	 */
	public static void saveEntity(ConfigEntity entity) {
		
		String filePath = System.getProperty("user.home") + File.separatorChar
			+ (entity.getAssociatedProjectIdentifier() == null ? "" : entity.getAssociatedProjectIdentifier() + ".")
			+ entity.getClass().getCanonicalName();
						
		try {
			ModelUtil.saveObjectToResource(entity, URI.createFileURI(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Loads the given configuration entity.
	 * 
	 * @param configEntity The configuration entity whose 
	 * @param eClass The type of class the configuration entity actually is.
	 * @return Loaded configuration entity.
	 */
	public static ConfigEntity loadConigEntity(ConfigEntity configEntity, EClass eClass) {
	
		String filename = System.getProperty("user.home") 
									+ File.separatorChar + configEntity.getConfigFilename();
		File f = new File(filename);
		if (!f.exists()) {
			return null;
		}

		try {
			ConfigEntity cfgEntity = loadEObjectFromResource(eClass , URI.createFileURI(filename));			
			return cfgEntity;
		} catch (IOException e) {
			return null;
		}				
	}

	// TODO: should we remove return value? method sets properties of argument configEntity.
	// don't need any more return value??
	/**
	 * Loads the given configuration entity.
	 * 
	 * @param configEntity The configuration entity whose 
	 * @param eClass The type of class the configuration entity actually is.
	 * @return Loaded configuration entity.
	 */
	public static ConfigEntity loadConfigEntity(ConfigEntity configEntity, EClass eClass) {

		String filename = System.getProperty("user.home") 
									+ File.separatorChar + configEntity.getConfigFilename();
		File f = new File(filename);
		if (!f.exists()) {
			return null;
		}
		try {
			ConfigEntity cfgEntity = loadEObjectFromResource(eClass, URI.createFileURI(filename));
			configEntity.getProperties().addAll(cfgEntity.getProperties());
			
			return cfgEntity;
		} catch (IOException e) {
			return null;
		}				
}
	
	@SuppressWarnings("unchecked")
	private static <T extends EObject> T loadEObjectFromResource(EClass eClass, URI resourceURI) throws IOException {

		ResourceSet resourceSet = new ResourceSetImpl();
		// TODO: HACK: second parameter has been changed for our purpose
		Resource resource = resourceSet.getResource(resourceURI, true);
		EList<EObject> contents = resource.getContents();
		if (contents.size() > 1) {
			throw new IOException("Resource containes multiple objects!");
		}
		if (contents.size() < 1) {
			throw new IOException("Resource contains no objects");
		}
		EObject eObject = contents.get(0);
		if (!(eClass.isInstance(eObject))) {
			throw new IOException("Resource contains no objects of given class");
		}
		return (T) eObject;

	}
	
}



