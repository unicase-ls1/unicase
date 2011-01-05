/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.ui.menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.resources.IFile;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.jdt.configuration.ConfigurationManager;
import org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration;
import org.unicase.emfstore.jdt.configuration.Entry;
import org.unicase.emfstore.jdt.eclipseworkspace.StructuredEMFStoreURI;
import org.unicase.emfstore.jdt.eclipseworkspace.emfstore.EMFStoreUtil;
import org.unicase.emfstore.jdt.exception.EntryNotFoundException;
import org.unicase.emfstore.jdt.exception.NoEMFStoreJDTConfigurationException;
import org.unicase.emfstore.jdt.exception.ProjectSpaceNotFoundException;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;

/**
 * An abstract handler that provides some helper classes for the handler that has to deal if no suitable team provider
 * is registred.
 * 
 * @author Adrian Staudt
 */
public abstract class AbstractNoTeamProviderHandler extends AbstractHandler {

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
				EMFStoreJDTConfiguration emfStoreJDTConfiguration = ConfigurationManager.getConfiguration(selectedFile
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

			} catch (NoEMFStoreJDTConfigurationException e) {
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
