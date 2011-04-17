/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.teamprovider;

import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.client.model.changeTracking.commands.CommandObserver;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationManager;
import org.eclipse.emf.emfstore.teamprovider.configuration.EMFStoreJDTConfiguration;
import org.eclipse.emf.emfstore.teamprovider.configuration.Entry;
import org.eclipse.emf.emfstore.teamprovider.eclipseworkspace.ResourceCommitHolder;
import org.eclipse.emf.emfstore.teamprovider.eclipseworkspace.StructuredEMFStoreURI;
import org.eclipse.emf.emfstore.teamprovider.eclipseworkspace.emfstore.ProjectSpaceUtil;
import org.eclipse.emf.emfstore.teamprovider.exception.CannotOpenEObjectException;
import org.eclipse.emf.emfstore.teamprovider.exception.EntryNotFoundException;
import org.eclipse.emf.emfstore.teamprovider.exception.NoEMFStoreJDTConfigurationException;

/**
 * An observer for the EMFStoreCommandStack. If the command invokes a commandCompleted the affected EObjects will be
 * written to the corresponding local file.
 * 
 * @author Adrian Staudt
 */
public class EMFStoreCommandStackObserver implements CommandObserver {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.changeTracking.commands.CommandObserver#commandFailed(org.eclipse.emf.common.command.Command,
	 *      java.lang.Exception)
	 */
	public void commandFailed(Command command, Exception exception) {
		// uninteresting
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.changeTracking.commands.CommandObserver#commandStarted(org.eclipse.emf.common.command.Command)
	 */
	public void commandStarted(Command command) {
		// uninteresting
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.changeTracking.commands.CommandObserver#commandCompleted(org.eclipse.emf.common.command.Command)
	 */
	public void commandCompleted(Command command) {
		Collection<?> affectedObjects = command.getAffectedObjects();
		if (!affectedObjects.isEmpty()) {
			for (Object ob : affectedObjects) {
				if (ob instanceof EObject) {
					EObject eObject = (EObject) ob;
					while (!(eObject == null) && !(eObject instanceof org.eclipse.emf.emfstore.common.model.Project)) {
						handleEObjectIfPossible(eObject);
						eObject = eObject.eContainer();
					}
				}
			}
		}
	}

	/**
	 * Finds out if this EObject is also represented as a file in the workspace. If so, the content of the EObject will
	 * be written to the local file.
	 * 
	 * @param eObject
	 */
	private void handleEObjectIfPossible(EObject eObject) {
		ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(eObject);
		ServerInfo serverInfo = projectSpace.getUsersession().getServerInfo();
		Project project = projectSpace.getProject();
		ModelElementId modelElementId = project.getModelElementId(eObject);
		if (modelElementId == null) {
			return;
		}

		String host = serverInfo.getUrl();
		int port = serverInfo.getPort();
		String certificate = serverInfo.getCertificateAlias();
		String projectID = projectSpace.getProjectId().getId();
		String eObjectID = modelElementId.getId();
		StructuredEMFStoreURI structuredEMFStoreURI = new StructuredEMFStoreURI(host, port, certificate, projectID,
			eObjectID);

		List<IFile> filesInWorkspace = ResourceCommitHolder.getFilesInWorkspace(structuredEMFStoreURI);
		for (IFile fileInWorkspace : filesInWorkspace) {
			writeEObjectToFile(eObject, fileInWorkspace);
			removeIfNecessaryDeletionFlag(fileInWorkspace);
		}
	}

	/**
	 * Copies the content from the EObject to the file.
	 * 
	 * @param file the target
	 * @param eObject the destination
	 */
	private void writeEObjectToFile(EObject eObject, IFile file) {
		try {
			InputStream inputStream = ProjectSpaceUtil.eObjectAsInputStream(eObject);
			file.setContents(inputStream, true, true, new NullProgressMonitor());

		} catch (CannotOpenEObjectException e) {
			ModelUtil.logException(e);

		} catch (CoreException e) {
			ModelUtil.logException(e);
		}
	}

	private void removeIfNecessaryDeletionFlag(IFile file) {
		IProject project = file.getProject();
		try {
			EMFStoreJDTConfiguration emfStoreJDTConfiguration = ConfigurationManager.getConfiguration(project);
			Entry entry = ConfigurationManager.getEntry(emfStoreJDTConfiguration, file);
			entry.setMarkedForDeletion(false);

		} catch (NoEMFStoreJDTConfigurationException e) {
			// ignore
		} catch (EntryNotFoundException e) {
			// ignore
		}

	}
}
