/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.ecp.xmiworkspace;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPProject;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPProjectListener;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPWorkspace;
import org.eclipse.emf.ecp.common.model.workSpaceModel.impl.ECPWorkspaceImpl;
import org.eclipse.emf.ecp.xmiworkspace.XmiUtil.PROJECT_STATUS;
import org.eclipse.emf.ecp.xmiworkspace.exceptions.XMIWorkspaceException;
import org.eclipse.emf.ecp.xmiworkspace.structure.XMIECPFileProject;
import org.eclipse.emf.ecp.xmiworkspace.structure.XMIECPProject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;

/**
 * Main class of this plugin. It manages the projects in the workspace.
 * 
 * @author matti, markus
 * @deprecated
 * 
 */
public class XMIECPWorkspace extends ECPWorkspaceImpl implements ECPWorkspace {

	/**
	 * Transactional domain.
	 */
	private static final String TRANSACTIONAL_EDITINGDOMAIN_ID = "org.unicase.EditingDomain";

	/**
	 * The xmi-file-resource storing the projects of the workspace.
	 */
	private Resource resource;

	/**
	 * Filename of the XMI-file storing the projects of the workspace.
	 */
	private String workspaceFile;

	/**
	 * EContentAdapter that listens on changes of the project.
	 */
	private EContentAdapter projectListener;

	/**
	 * Builds new ECPWorkspace being able to hold xmi-persistable projects.
	 */
	public XMIECPWorkspace() {
		workspaceFile = Platform.getLocation() + "/xmiworkspace.ucw";
		buildProjectListener();
		loadProjects();
	}

	/**
	 * <b>Initializes Workspace</b><br />
	 * If necessary creates new file otherwise reads the current file.
	 */
	private void loadProjects() {
		// File needed for file-operations
		File xmiFile = new File(workspaceFile);
		URI xmiUri = URI.createFileURI(workspaceFile);

		// build a correct resource set
		ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		BasicCommandStack commandStack = new BasicCommandStack();
		AdapterFactoryEditingDomain editingDomain = new AdapterFactoryEditingDomain(
				composedAdapterFactory, commandStack);
		ResourceSet resourceSetImpl = editingDomain.getResourceSet();
		resourceSetImpl.eAdapters().add(projectListener);

		// check for existence
		if (!xmiFile.exists()) {
			// if it does not exist, create the file.
			resource = resourceSetImpl.createResource(xmiUri);

			save();
		} else {
			// workspace file does exist and therefore has to be loaded
			resource = resourceSetImpl.getResource(xmiUri, true);

			// try to load the resource
			try {
				this.resource.load(Collections.EMPTY_MAP);
			} catch (IOException e) {
				new XMIWorkspaceException(
						"Failed to load workspace! Delete file: "
								+ workspaceFile, e);
			}

			// read projects from resource and add them to the projects-list
			for (EObject project : resource.getContents()) {
				if (project instanceof XMIECPProject) {
					// try to add project to workspace
					XMIECPFileProject pro = (XMIECPFileProject) project;
					pro.setProjectStatus(PROJECT_STATUS.NOTLOADED);
					String path = pro.getXmiFilePath();

					// check for duplicate projects
					if (projectPathExists(path)) {
						pro.setProjectStatus(PROJECT_STATUS.DUPLICATED);
					} else {
						if (!(new File(path)).exists()) {
							// set project status to failed
							pro.setProjectStatus(PROJECT_STATUS.FAILED);
						}
					}

					// add project to workspace
					pro.setWorkspace(this);
					getProjects().add(pro);
				}
			}
		} // END ELSE if the workspace file does exist

	} // END loadProjects()

	/**
	 * Checks whether a project in the workspace has the same path than the
	 * given one.
	 * 
	 * @param path
	 *            Path of a xmi file.
	 * @return True if the path is already in the workspace, otherwise false
	 */
	public boolean projectPathExists(String path) {
		// if projects is not set or null just return false
		if (projects == null || projects.isEmpty()) {
			return false;
		}

		// iterate over all projects and check for their path
		for (ECPProject p : projects) {
			if (p instanceof XMIECPFileProject
					&& ((XMIECPFileProject) p).getXmiFilePath().equals(path)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Creates the EContentAdapter that will be attached to each project in
	 * order to listen to the project's changes.
	 */
	private void buildProjectListener() {
		projectListener = new EContentAdapter() {

			@Override
			public void notifyChanged(Notification notification) {
				Object changedObj = notification.getNotifier();

				if (!notification.isTouch()) {
					if (changedObj instanceof EObject
							|| (changedObj instanceof Resource && Resource.RESOURCE__CONTENTS == notification
									.getFeatureID(null))) {
						save();
					}
				}

				// also inform the listeners registered on the super class
				super.notifyChanged(notification);
			}
		};
	}

//	/**
//	 * {@inheritDoc}
//	 * 
//	 * @see org.unicase.ui.navigator.workSpaceModel.ECPWorkspace#getEditingDomain()
//	 */
//	@Override
//	public EditingDomain getEditingDomain() {
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EList<ECPProject> getProjects() {
		if (projects == null) {
			projects = new BasicEList<ECPProject>();
		}
		return projects;
	}

	/**
	 * Adds a project to the workspace.
	 * 
	 * @param project
	 *            XMIECPProject that is added to the workspace.
	 */
	public void addProject(ECPProject project) {
		project.setWorkspace(this);
		resource.getContents().add(project);
		getProjects().add(project);
		setActiveProject(project);
	}

	/**
	 * Removes a project from the workspace.
	 * 
	 * @param project
	 *            XMIECPProject to be removed from the workspace.
	 */
	public void removeProject(ECPProject project) {
		resource.getContents().remove(project);
		getProjects().remove(project);
		for (ECPProjectListener pl : ((XMIECPFileProject) project)
				.getProjectListeners()) {
			pl.projectDeleted();
		}
		project.dispose();
	}

	private void save() {
		// simply call save on the resource
		try {
			if (resource == null || resource.getResourceSet() == null) {
				return;
			}
			for (Resource res : resource.getResourceSet().getResources()) {
				res.save(Collections.EMPTY_MAP);
			}
		} catch (IOException e) {
			new XMIWorkspaceException(
					"Unable to persist object to xmi resource.", e);
		}
	}

	/**
	 * Returns the project that the user is currently working in, by checking
	 * where the current selection is.
	 * 
	 * @return Currently selected project.
	 */
	@Override
	public ECPProject getActiveProject() {
		// get active project is one is set -> usually null
		ECPProject ap = super.getActiveProject();

		// get selection from the tree viewer
		// ITreeSelection selection = (ITreeSelection)
		// TreeView.getTreeViewer().getSelection();
		// TreePath[] paths = selection.getPaths();

		// get the first object in the path of the first selected element
		// if(paths != null && paths.length != 0) {
		// Object firstObject = paths[0].getFirstSegment();
		// if(firstObject instanceof XMIECPFileProject) {
		// XMIECPFileProject project = (XMIECPFileProject) firstObject;
		// ap = project;
		// }
		// }

		// if the active project is still null, simply return the first project
		if (ap == null) {
			// It should throw an error here, that no project is selected, but
			// it's ignored here.
			return getProjects().get(0);
		}

		return ap;
	}
}
