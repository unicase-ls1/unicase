/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.ecp.xmiworkspace;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPProject;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPWorkspace;
import org.eclipse.emf.ecp.common.model.workSpaceModel.WorkSpaceModelFactory;
import org.eclipse.emf.ecp.common.model.workSpaceModel.impl.ECPWorkspaceImpl;
import org.eclipse.emf.ecp.xmiworkspace.XmiUtil.PROJECT_STATUS;
import org.eclipse.emf.ecp.xmiworkspace.exceptions.XMIWorkspaceException;
import org.eclipse.emf.ecp.xmiworkspace.structure.XMIECPFileProject;
import org.eclipse.emf.ecp.xmiworkspace.structure.XMIECPProject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;

/**
 * This workspace manager handles loading of the workspace and replaces the
 * original implementation of (@link {@link XMIECPWorkspace}). namespaces.
 * 
 * @author wesendon
 * 
 */
public class XMIECPWorkspaceManager extends ECPWorkspaceImpl implements
		ECPWorkspace {

	/**
	 * Transactional domain.
	 */
	private static final String TRANSACTIONAL_EDITINGDOMAIN_ID = "org.unicase.EditingDomain";

	private static ECPWorkspace workspace;

	/**
	 * Load the workspace.
	 * 
	 * @param path
	 *            path to workspace
	 * @return workspace
	 * @throws XMIWorkspaceException
	 *             in case of error
	 */
	public static ECPWorkspace loadWorkspace(String path)
			throws XMIWorkspaceException {
		if (workspace != null) {
			return workspace;
		}
		ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		BasicCommandStack commandStack = new BasicCommandStack();
		AdapterFactoryEditingDomain editingDomain = new AdapterFactoryEditingDomain(
				composedAdapterFactory, commandStack);
		ResourceSet resourceSetImpl = editingDomain.getResourceSet();
		Resource resource = resourceSetImpl.createResource(URI
				.createFileURI(path));
		EList<EObject> contents = null;
		try {
			if (!new File(path).exists()) {
				resource.save(null);
			}
			resource.load(Collections.EMPTY_MAP);
			contents = resource.getContents();
		} catch (IOException e) {
			throw new XMIWorkspaceException("Failed to load workspace!", e);
		}

		if (contents.size() == 0) {
			workspace = WorkSpaceModelFactory.eINSTANCE.createECPWorkspace();
			contents.add(workspace);
			save();
		}

		if (contents.get(0) instanceof ECPWorkspace) {
			workspace = (ECPWorkspace) contents.get(0);
		} else {
			throw new XMIWorkspaceException(
					"Corrupted file, no workspace found.");
		}

		workspace.setEditingDomain(editingDomain);

		addAutoSaveListener();

		// copied and ported from original implementaion
		for (EObject tmp : getWorkspace().getProjects()) {
			if (tmp instanceof XMIECPProject) {
				XMIECPFileProject project = (XMIECPFileProject) tmp;

				project.setProjectStatus(PROJECT_STATUS.NOTLOADED);

				// check for duplicate projects
				if (projectPathExists(project.getXmiFilePath())) {
					project.setProjectStatus(PROJECT_STATUS.DUPLICATED);
				} else {
					if (!(new File(project.getResolvedXmiFilePath())).exists()) {
						// set project status to failed
						project.setProjectStatus(PROJECT_STATUS.FAILED);
					}
				}
				project.loadContents();
			}
		}

		if (workspace.getProjects().size() > 0) {
			workspace.setActiveProject(workspace.getProjects().get(0));
		}
		return workspace;
	}

	/**
	 * Returns workspace.
	 * 
	 * @return workspace or null
	 */
	public static ECPWorkspace getWorkspace() {
		return workspace;
	}

	/**
	 * Checks whether a project in the workspace has the same path than the
	 * given one.
	 * 
	 * @param path
	 *            Path of a xmi file.
	 * @return True if the path is already in the workspace, otherwise false
	 */
	public static boolean projectPathExists(String path) {
		// if projects is not set or null just return false
		if (getWorkspace().getProjects() == null
				|| getWorkspace().getProjects().isEmpty()) {
			return false;
		}

		// iterate over all projects and check for their path
		for (ECPProject project : getWorkspace().getProjects()) {
			if (project instanceof XMIECPFileProject
					&& ((XMIECPFileProject) project).getXmiFilePath().equals(
							path)) {
				return true;
			}
		}
		return false;
	}

	private static void save() throws XMIWorkspaceException {
		try {
			if (workspace == null || workspace.eResource() == null) {
				return;
			}
			workspace.eResource().save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			throw new XMIWorkspaceException(
					"Unable to persist object to xmi resource.", e);
		}
	}

	private static void addAutoSaveListener() {
		getWorkspace().eResource().eAdapters().add(new EContentAdapter() {

			@Override
			public void notifyChanged(Notification notification) {
				super.notifyChanged(notification);

				Object changedObj = notification.getNotifier();
				if (!notification.isTouch()) {
					if (changedObj instanceof EObject
							|| (changedObj instanceof Resource && Resource.RESOURCE__CONTENTS == notification
									.getFeatureID(null))) {
						try {
							save();
						} catch (XMIWorkspaceException e) {
							// fail silently
						}
					}
				}
			}
		});
	}

//	private static EditingDomain createEditingDomain() {
//		if (TransactionalEditingDomain.Registry.INSTANCE
//				.getEditingDomain(TRANSACTIONAL_EDITINGDOMAIN_ID) == null) {
//			final TransactionalEditingDomain domain = new TransactionalEditingDomainImpl(
//					new ComposedAdapterFactory(
//							ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
//			TransactionalEditingDomain.Registry.INSTANCE.add(
//					TRANSACTIONAL_EDITINGDOMAIN_ID, domain);
//			domain.setID(TRANSACTIONAL_EDITINGDOMAIN_ID);
//		}
//		return TransactionalEditingDomain.Registry.INSTANCE
//				.getEditingDomain(TRANSACTIONAL_EDITINGDOMAIN_ID);
//	}

}
