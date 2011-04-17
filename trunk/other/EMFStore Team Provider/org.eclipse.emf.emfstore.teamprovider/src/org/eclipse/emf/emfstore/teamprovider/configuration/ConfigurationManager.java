/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.teamprovider.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.teamprovider.eclipseworkspace.StructuredEMFStoreURI;
import org.eclipse.emf.emfstore.teamprovider.exception.EntryNotFoundException;
import org.eclipse.emf.emfstore.teamprovider.exception.NoEMFStoreJDTConfigurationException;

/**
 * Manager class to handle with EMFStoreJDTConfigurations. A EMFStoreJDTConfiguration is only responsible for a project.
 * This class provides an entry point for the whole workspace to get access to the project specific
 * EMFStoreJDTConfigurations. This class provides also caching functionality.
 * 
 * @author Adrian Staudt
 */
public final class ConfigurationManager {

	/**
	 * The file where the meta data of the EMF Store managed files are stored.
	 */
	public static final String EMFSTORECONF = ".emfstoreconf";

	/**
	 * A map of configurations that can be accessed by an eclipse workspace project. This map is used as a cache, so the
	 * configuration file does not need to be re-initialized.
	 */
	private static Map<IProject, EMFStoreJDTConfiguration> configurations = new HashMap<IProject, EMFStoreJDTConfiguration>();

	private ConfigurationManager() {
	}

	/**
	 * Returns the EMF Store JDT configuration for an eclipse workspace project.
	 * 
	 * @param project An eclipse workspace project.
	 * @return An EMF Store JDT configuration.
	 * @throws NoEMFStoreJDTConfigurationException Will be thrown if the project is not managed by an EMF Store.
	 */
	public static EMFStoreJDTConfiguration getConfiguration(IProject project)
		throws NoEMFStoreJDTConfigurationException {
		// if( !configurations.containsKey(project) ) {
		IFile confFile = project.getFile(EMFSTORECONF);
		if (!confFile.exists()) {
			throw new NoEMFStoreJDTConfigurationException();
		}

		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());

		URI uri = URI.createURI(confFile.getLocationURI().toString());
		Resource confResource = resourceSet.createResource(uri);

		try {
			confResource.load(Collections.EMPTY_MAP);
			if (confResource.getContents().size() > 0) {
				EMFStoreJDTConfiguration emfStoreJDTConfiguration = (EMFStoreJDTConfiguration) confResource
					.getContents().get(0);
				configurations.put(project, emfStoreJDTConfiguration);

				return emfStoreJDTConfiguration;
			}

		} catch (IOException e) {
			ModelUtil.logException(e);
		}
		// }

		throw new NoEMFStoreJDTConfigurationException();
	}

	/**
	 * Creates a new EMF Store JDT configuration file.
	 * 
	 * @param project An eclipse workspace project.
	 * @return An EMF Store JDT configuration.
	 */
	public static EMFStoreJDTConfiguration createConfiguration(IProject project) {
		IFile confFile = project.getFile(EMFSTORECONF);

		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

		URI uri = URI.createURI(confFile.getLocationURI().toString());
		Resource confResource = resourceSet.createResource(uri);

		EMFStoreJDTConfiguration emfStoreJDTConfiguration = ConfigurationFactory.eINSTANCE
			.createEMFStoreJDTConfiguration();
		confResource.getContents().add(emfStoreJDTConfiguration);

		configurations.put(project, emfStoreJDTConfiguration);

		return emfStoreJDTConfiguration;
	}

	/**
	 * Adds an EMF Store location to an EMF Store JDT configuration so that the related EMF Store will be committed
	 * independently if a managed file by has been modified or not. This is usually used if an Ecore file get un-managed
	 * and the EMF Store needs to be committed.
	 * 
	 * @param emfStoreJDTConfiguration An EMF Store JDT configuration.
	 * @param emfStoreLocation An EMF Store location.
	 */
	public static void addToAnywayCommit(EMFStoreJDTConfiguration emfStoreJDTConfiguration,
		EMFStoreLocation emfStoreLocation) {
		EList<EMFStoreLocation> anywayCommits = emfStoreJDTConfiguration.getAnywayCommit();
		for (EMFStoreLocation anywayCommit : anywayCommits) {
			if (anywayCommit.equals(emfStoreLocation)) {
				return;
			}
		}

		// no entry found, add new one
		anywayCommits.add(emfStoreLocation);
	}

	/**
	 * Returns the entry from the EMF Store JDT configuration that corresponds to the given file.
	 * 
	 * @param emfStoreJDTConfiguration An EMF Store JDT configuration.
	 * @param file An eclipse workspace file.
	 * @return The corresponding entry.
	 * @throws EntryNotFoundException Will be thrown if no corresponding entry has been found.
	 */
	public static Entry getEntry(EMFStoreJDTConfiguration emfStoreJDTConfiguration, IFile file)
		throws EntryNotFoundException {

		List<Entry> possibleEntries = new ArrayList<Entry>();
		EList<Entry> entryList = emfStoreJDTConfiguration.getEntry();
		for (Entry entry : entryList) {
			String fileLocation = entry.getProjectRelativeLocation();
			if (fileLocation.equals(file.getProjectRelativePath().toString())) {
				possibleEntries.add(entry);
			}
		}

		for (Entry entry : possibleEntries) {
			if (!entry.isMarkedForDeletion()) {
				return entry;
			}
		}

		throw new EntryNotFoundException();
	}

	/**
	 * Returns an EMF Store URI that can identify an EObject in an EMF Store.
	 * 
	 * @param entry The entry that holds the information for that EObject.
	 * @return A distinct URI for an EMF Store JDT entry.
	 */
	public static StructuredEMFStoreURI getEMFStoreURI(Entry entry) {
		EObjectLocation eObjectLocation = entry.getEObjectLocation();
		EMFStoreLocation emfStoreLocation = eObjectLocation.getEMFStoreLocation();
		String host = emfStoreLocation.getHost();
		int port = emfStoreLocation.getPort();
		String certificate = emfStoreLocation.getCertificate();
		String projectID = emfStoreLocation.getProjectID();
		String eObjectID = eObjectLocation.getEObjectID();

		StructuredEMFStoreURI structuredEMFStoreURI = new StructuredEMFStoreURI(host, port, certificate, projectID,
			eObjectID);
		return structuredEMFStoreURI;
	}

	/**
	 * Removes an entry from an EMF Store JDT configuration. The corresponding file gets than un-managed.
	 * 
	 * @param emfStoreJDTConfiguration An EMF Store JDT configuration.
	 * @param entry An EMF Store JDT entry.
	 */
	public static void rejectEntry(EMFStoreJDTConfiguration emfStoreJDTConfiguration, Entry entry) {
		emfStoreJDTConfiguration.getEntry().remove(entry);
		emfStoreJDTConfiguration.save();
	}
}
