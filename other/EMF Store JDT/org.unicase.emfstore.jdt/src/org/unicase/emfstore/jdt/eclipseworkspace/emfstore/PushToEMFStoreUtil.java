/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.eclipseworkspace.emfstore;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.jdt.configuration.ConfigurationFactory;
import org.unicase.emfstore.jdt.configuration.ConfigurationManager;
import org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration;
import org.unicase.emfstore.jdt.configuration.EMFStoreLocation;
import org.unicase.emfstore.jdt.configuration.EObjectLocation;
import org.unicase.emfstore.jdt.configuration.Entry;
import org.unicase.emfstore.jdt.exception.CannotConvertToEObjectException;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.util.UnicaseCommandWithResult;

/**
 * Utility class to add a file to an EMF Store.
 * 
 * @author Adrian Staudt
 */
public final class PushToEMFStoreUtil {

	private PushToEMFStoreUtil() {
	}

	/**
	 * An eclipse workspace file get converted to an EObject.
	 * 
	 * @param file An eclipse workspace file.
	 * @return An EObject.
	 * @throws CannotConvertToEObjectException Will be thrown if the file cannot be instantiated as an EObject.
	 */
	private static EObject iFileToEObject(IFile file) throws CannotConvertToEObjectException {
		ResourceSet resourceSet = new ResourceSetImpl();
		// TODO: CHECK ist das wirklich nötig?
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createURI(file.getLocationURI()
			.toString());
		Resource modelResource = resourceSet.createResource(uri);
		try {
			modelResource.load(Collections.EMPTY_MAP);
			EList<EObject> contents = modelResource.getContents();
			EObject eObject = contents.get(0);
			return eObject;

		} catch (IOException e) {
			throw new CannotConvertToEObjectException(e);
		}
	}

	/**
	 * Adds an eclipse workspace file to a ProjectSpace.
	 * 
	 * @param file An eclipse workspace file.
	 * @param projectSpace An ProjectSpace.
	 * @return Returns the id of that object. By that id the EObject can be identified within a ProjectSpace.
	 * @throws CannotConvertToEObjectException Will be thrown if the file cannot be instantiated as an EObject.
	 */
	public static ModelElementId push(IFile file, ProjectSpace projectSpace) throws CannotConvertToEObjectException {
		EObject eObject = iFileToEObject(file);
		EObject eObjectCopy = EcoreUtil.copy(eObject);
		ModelElementId modelElementId = PushToEMFStoreUtil.push(projectSpace, eObjectCopy);
		return modelElementId;
	}

	/**
	 * After a file has been pushed it must be added a corresponding entry to the EMF Store JDT configuration.
	 * 
	 * @param emfStoreJDTConfiguration An EMF Store JDT configuration.
	 * @param file An eclipse workspace file.
	 * @param serverInfo A ServerInfo.
	 * @param projectId A project id (not a ProjectSpace id).
	 * @param modelElementId An EObject id.
	 */
	public static void addEntry(EMFStoreJDTConfiguration emfStoreJDTConfiguration, IFile file, ServerInfo serverInfo,
		ProjectId projectId, ModelElementId modelElementId) {

		String fileLocation = file.getProjectRelativePath().toString();
		Entry entry = ConfigurationFactory.eINSTANCE.createEntry();
		entry.setProjectRelativeLocation(fileLocation);

		EObjectLocation eObjectLocation = ConfigurationFactory.eINSTANCE.createEObjectLocation();

		EMFStoreLocation emfStoreLocation = ConfigurationFactory.eINSTANCE.createEMFStoreLocation();
		emfStoreLocation.setHost(serverInfo.getUrl());
		emfStoreLocation.setPort(serverInfo.getPort());
		emfStoreLocation.setCertificate(serverInfo.getCertificateAlias());
		emfStoreLocation.setProjectID(projectId.getId());

		eObjectLocation.setEObjectID(modelElementId.getId());
		eObjectLocation.setEMFStoreLocation(emfStoreLocation);

		entry.setEObjectLocation(eObjectLocation);

		emfStoreJDTConfiguration.getEntry().add(entry);

		EMFStoreLocation emfStoreLocationClone = ModelUtil.clone(emfStoreLocation);
		ConfigurationManager.addToAnywayCommit(emfStoreJDTConfiguration, emfStoreLocationClone);
		emfStoreJDTConfiguration.save();
	}

	private static ModelElementId push(final ProjectSpace projectSpace, final EObject eObject) {

		ModelElementId modelElementId = new UnicaseCommandWithResult<ModelElementId>() {
			@Override
			protected ModelElementId doRun() {
				Project project = projectSpace.getProject();
				project.addModelElement(eObject);
				ModelElementId modelElementId = project.getModelElementId(eObject);

				return modelElementId;

			}
		}.run(false);

		return modelElementId;
	}
}
