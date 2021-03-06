/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.teamprovider.ui.menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.teamprovider.configuration.ConfigurationManager;
import org.eclipse.emf.emfstore.teamprovider.configuration.EMFStoreTeamProviderConfiguration;
import org.eclipse.emf.emfstore.teamprovider.configuration.Entry;
import org.eclipse.emf.emfstore.teamprovider.eclipseworkspace.StructuredEMFStoreURI;
import org.eclipse.emf.emfstore.teamprovider.eclipseworkspace.emfstore.EMFStoreUtil;
import org.eclipse.emf.emfstore.teamprovider.exception.EntryNotFoundException;
import org.eclipse.emf.emfstore.teamprovider.exception.NoEMFStoreTeamProviderConfigurationException;
import org.eclipse.emf.emfstore.teamprovider.exception.ProjectSpaceNotFoundException;

/**
 * An abstract handler that provides some helper classes for the handler that has to deal if no suitable team provider
 * is registered.
 * 
 * @author Adrian Staudt
 */
public abstract class AbstractNoTeamProviderHandler extends AbstractCommanHandler {

	/**
	 * The selection provider provides instances of an object. We are only interested in files.
	 * 
	 * @param selectedObjects All selected objects.
	 * @return All selected files.
	 */
	protected Collection<IFile> getSelectedIFiles(Object[] selectedObjects) {
		List<IFile> selectedFiles = new ArrayList<IFile>();
		for (Object selectedObject : selectedObjects) {
			if (selectedObject instanceof IFile) {
				IFile file = (IFile) selectedObject;
				selectedFiles.add(file);
			}
		}

		return selectedFiles;
	}

	/**
	 * Returns a set of ProjectSpaces that holds an EObject of an selected files.
	 * 
	 * @param selectedFiles A collection of selected files.
	 * @return A set of ProjectSpaces.
	 */
	protected Set<ProjectSpace> getProjectSpaces(Collection<IFile> selectedFiles) {
		Set<String> projectSpacesId = new HashSet<String>();
		Set<ProjectSpace> projectSpaces = new HashSet<ProjectSpace>();

		for (IFile selectedFile : selectedFiles) {
			try {
				EMFStoreTeamProviderConfiguration emfStoreJDTConfiguration = ConfigurationManager.getConfiguration(selectedFile
					.getProject());
				Entry entry = ConfigurationManager.getEntry(emfStoreJDTConfiguration, selectedFile);
				StructuredEMFStoreURI emfStoreURI = ConfigurationManager.getEMFStoreURI(entry);
				ServerInfo serverInfo = EMFStoreUtil.getServerInfo(emfStoreURI);
				ProjectInfo projectInfo = emfStoreURI.getProjectInfo();

				// try to update
				ProjectSpace projectSpace = EMFStoreUtil.getProjectSpace(serverInfo, projectInfo);
				String projectSpaceId = projectSpace.getProjectId().getId();
				if (!projectSpacesId.contains(projectSpaceId)) {
					projectSpacesId.add(projectSpaceId);
					projectSpaces.add(projectSpace);
				}

			} catch (NoEMFStoreTeamProviderConfigurationException e) {
				ModelUtil.logException(e);
			} catch (EntryNotFoundException e) {
				ModelUtil.logException(e);
			} catch (ProjectSpaceNotFoundException e) {
				ModelUtil.logException(e);
			}
		}

		return projectSpaces;
	}

}
