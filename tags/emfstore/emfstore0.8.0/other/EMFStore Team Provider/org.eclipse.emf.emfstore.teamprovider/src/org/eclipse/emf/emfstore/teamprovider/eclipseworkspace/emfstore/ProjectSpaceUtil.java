/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen. All rights
 * reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public
 * License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.teamprovider.eclipseworkspace.emfstore;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.ModelFactory;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.teamprovider.eclipseworkspace.StructuredEMFStoreURI;
import org.eclipse.emf.emfstore.teamprovider.exception.CannotOpenEObjectException;
import org.eclipse.emf.emfstore.teamprovider.exception.EMFStoreURIMalformedException;
import org.eclipse.emf.emfstore.teamprovider.exception.EObjectNotFoundException;
import org.eclipse.emf.emfstore.teamprovider.exception.ProjectSpaceNotFoundException;

/**
 * A utility class to handle with project spaces.
 * 
 * @author Adrian Staudt
 */
public final class ProjectSpaceUtil {

	private ProjectSpaceUtil() {
	}

	/**
	 * Returns a ProjectSpace by a projectId (not a ProjectSpaceId).
	 * 
	 * @param projectID The project id.
	 * @return A project space.
	 * @throws ProjectSpaceNotFoundException Will be thrown if no ProjectSpace can be found.
	 */
	public static synchronized ProjectSpace getProjectSpace(String projectID) throws ProjectSpaceNotFoundException {
		EList<ProjectSpace> projectSpaces = WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces();
		for (ProjectSpace projectSpace : projectSpaces) {
			if (projectSpace.getProjectId().getId().equals(projectID)) {
				return projectSpace;
			}
		}

		throw new ProjectSpaceNotFoundException();
	}

	/**
	 * Gets an EObject by an URI.
	 * 
	 * @param uri The URI.
	 * @return An EObject.
	 * @throws EMFStoreURIMalformedException Will be thrown if the URI is malformed.
	 * @throws ProjectSpaceNotFoundException Will be thrown if no ProjectSpace can be found.
	 * @throws EObjectNotFoundException Will be thrown if the EObject does not exist in the ProjectSpace.
	 */
	public static EObject getEObject(URI uri) throws EMFStoreURIMalformedException, ProjectSpaceNotFoundException,
		EObjectNotFoundException {
		StructuredEMFStoreURI structuredEMFStoreURI = new StructuredEMFStoreURI(uri);
		EObject eObject = ProjectSpaceUtil.getEObject(structuredEMFStoreURI);
		return eObject;
	}

	/**
	 * Gets an EObject by an structured EMF Store URI.
	 * 
	 * @param structuredEMFStoreURI The structured EMF Store URI.
	 * @return An EObject.
	 * @throws ProjectSpaceNotFoundException Will be thrown if no ProjectSpace can be found.
	 * @throws EObjectNotFoundException Will be thrown if the EObject does not exist in the ProjectSpace.
	 */
	public static EObject getEObject(StructuredEMFStoreURI structuredEMFStoreURI) throws EObjectNotFoundException,
		ProjectSpaceNotFoundException {
		String eObjectID = structuredEMFStoreURI.getEObjectID();
		ProjectSpace projectSpace = getProjectSpace(structuredEMFStoreURI.getProjectID());
		return getEObject(projectSpace, eObjectID);
	}

	private static EObject getEObject(ProjectSpace projectSpace, String eObjectID) throws EObjectNotFoundException {
		ModelElementId modelElementId = ModelFactory.eINSTANCE.createModelElementId();
		modelElementId.setId(eObjectID);

		EObject eObject = projectSpace.getProject().getModelElement(modelElementId);
		if (eObject != null) {
			return eObject;
		}

		throw new EObjectNotFoundException();
	}

	/**
	 * Returns the content of an EObject as an InputStream.
	 * 
	 * @param eObject The eObject
	 * @return The content as an InputStream.
	 * @throws CannotOpenEObjectException Will be thrown if the EObject cannot be serialized into an InputStream.
	 */
	public static InputStream eObjectAsInputStream(EObject eObject) throws CannotOpenEObjectException {
		try {
			String eObjectToString = ModelUtil.eObjectToString(eObject, true, true);

			return new ByteArrayInputStream(eObjectToString.getBytes());

		} catch (org.eclipse.emf.emfstore.common.model.util.SerializationException e) {
			throw new CannotOpenEObjectException();
		}
	}

	/**
	 * The EObject behind the structured EMF Store URI will be removed from its ProjectSpace.
	 * 
	 * @param structuredEMFStoreURI An structured EMF Store URI.
	 */
	public static void removeEObject(StructuredEMFStoreURI structuredEMFStoreURI) {
		new RemoveEObjectCommand(structuredEMFStoreURI).run(false);
	}

	/**
	 * UnicaseCommand to remove an EObject from its ProjectSpace.
	 */
	private static class RemoveEObjectCommand extends EMFStoreCommand {

		private final StructuredEMFStoreURI structuredEMFStoreURI;

		public RemoveEObjectCommand(StructuredEMFStoreURI structuredEMFStoreURI) {
			this.structuredEMFStoreURI = structuredEMFStoreURI;
		}

		@Override
		protected void doRun() {
			ServerInfo serverInfo = EMFStoreUtil.getServerInfo(structuredEMFStoreURI);
			try {
				ProjectSpace projectSpace = EMFStoreUtil.getProjectSpace(serverInfo,
					structuredEMFStoreURI.getProjectInfo());
				EObject eObject = ProjectSpaceUtil.getEObject(structuredEMFStoreURI);
				Project project = projectSpace.getProject();
				project.deleteModelElement(eObject);

			} catch (ProjectSpaceNotFoundException e) {
				ModelUtil.logException(e);

			} catch (EObjectNotFoundException e) {
				ModelUtil.logException(e);
			}
		}
	}
}
