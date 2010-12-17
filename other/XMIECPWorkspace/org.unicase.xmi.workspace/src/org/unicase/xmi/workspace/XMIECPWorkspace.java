package org.unicase.xmi.workspace;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.unicase.ecp.model.workSpaceModel.ECPProject;
import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;
import org.unicase.ecp.model.workSpaceModel.impl.ECPWorkspaceImpl;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.util.DefaultWorkspaceLocationProvider;
import org.unicase.xmi.exceptions.XMIWorkspaceException;


public class XMIECPWorkspace extends ECPWorkspaceImpl implements ECPWorkspace {
	
	/**
	 * Copied transactional domain
	 */
	private static final String TRANSACTIONAL_EDITINGDOMAIN_ID = "org.unicase.EditingDomain";
	
	/**
	 * Internal list of projects contained in the workspace.
	 */
	private EList<ECPProject> projects;

	/**
	 * The xmi-file-resource storing the projects of the workspace.
	 */
	private Resource resource;
	
	/**
	 * Filename of the XMI-file storing the projects of the workspace.
	 */
	private String workspaceFile;
	
	/**
	 * Builds new ECPWorkspace being able to hold xmi-persistable projects.
	 */
	public XMIECPWorkspace() {
		projects = new BasicEList<ECPProject>();
		
		workspaceFile = new DefaultWorkspaceLocationProvider().getWorkspaceDirectory() + "xmiworkspace.ucw";
		resource = null;
		
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
		
		// check for existence
		if(!xmiFile.exists()) {
			// if it does not exist, create the file.
			resource = new ResourceSetImpl().createResource(xmiUri);
			
			// in the beginning do not create anything
		}
		else {
			// workspace file does exist and therefore has to be loaded
			resource = new ResourceSetImpl().getResource(xmiUri, true);
			
			// try to load the resource
			try {
				this.resource.load(Collections.EMPTY_MAP);
			}
			catch(IOException e) {
				new XMIWorkspaceException("Failed to load workspace! Delete file: " + workspaceFile, e);
			}
			
			// read projects from resource and add them to the projects-list
			for(EObject project: resource.getContents()) {
				if(project instanceof ECPProject) {
					projects.add((ECPProject) project);
				}
			}
		}
	} // END init()

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.navigator.workSpaceModel.ECPWorkspace#getEditingDomain()
	 */
	@Override
	public TransactionalEditingDomain getEditingDomain() {
		if (Configuration.getEditingDomain() == null) {
			final TransactionalEditingDomain domain = new TransactionalEditingDomainImpl(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
			TransactionalEditingDomain.Registry.INSTANCE.add(TRANSACTIONAL_EDITINGDOMAIN_ID, domain);
			domain.setID(TRANSACTIONAL_EDITINGDOMAIN_ID);
		}		
		return Configuration.getEditingDomain();
	}
	
	@Override
	public EList<ECPProject> getProjects() {
		EList<ECPProject> result = new BasicEList<ECPProject>();
		result.addAll(projects);
		return result;
	}
	
	/**
	 * Adds a project to the workspace.
	 * @param project XMIECPProject that is added to the workspace. 
	 */
	public void addProject(ECPProject project) {
		project.setWorkspace(this);
		resource.getContents().add(project);
		projects.add(project);
	}
	
	/**
	 * Removes a project from the workspace.
	 * @param project XMIECPProject to be removed from the workspace.
	 */
	public void removeProject(ECPProject project) {
		resource.getContents().remove(project);
		projects.remove(project);
		project.dispose();
	}
}
