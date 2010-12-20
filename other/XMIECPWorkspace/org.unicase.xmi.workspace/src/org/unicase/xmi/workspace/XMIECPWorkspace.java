package org.unicase.xmi.workspace;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.unicase.ecp.model.workSpaceModel.ECPProject;
import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;
import org.unicase.ecp.model.workSpaceModel.impl.ECPWorkspaceImpl;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.util.DefaultWorkspaceLocationProvider;
import org.unicase.xmi.exceptions.XMIWorkspaceException;
import org.unicase.xmi.xmiworkspacestructure.XMIECPFolder;
import org.unicase.xmi.xmiworkspacestructure.XMIECPProject;
import org.unicase.xmi.xmiworkspacestructure.XMIECPProjectContainer;


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
	 * Internal list of folders contained in the workspace.
	 */
	private EList<XMIECPProjectContainer> folders;

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
		projects = new BasicEList<ECPProject>();
		folders = new BasicEList<XMIECPProjectContainer>();
		
		workspaceFile = new DefaultWorkspaceLocationProvider().getWorkspaceDirectory() + "xmiworkspace.ucw";
		resource = null;
		
		buildProjectListener();
		loadProjects();
		loadFolders();
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
		ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		BasicCommandStack commandStack = new BasicCommandStack();
		AdapterFactoryEditingDomain editingDomain = new AdapterFactoryEditingDomain(composedAdapterFactory, commandStack);
		ResourceSet resourceSetImpl = editingDomain.getResourceSet();
		
		// check for existence
		if(!xmiFile.exists()) {
			// if it does not exist, create the file.
			resource = resourceSetImpl.createResource(xmiUri);
			
			// in the beginning just save the resource without any content
			try {
				resource.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				new XMIWorkspaceException("Could not create new workspace. Please check your permissions.", e);
			}
		}
		else {
			// workspace file does exist and therefore has to be loaded
			resource = resourceSetImpl.getResource(xmiUri, true);
			
			// try to load the resource
			try {
				this.resource.load(Collections.EMPTY_MAP);
			}
			catch(IOException e) {
				new XMIWorkspaceException("Failed to load workspace! Delete file: " + workspaceFile, e);
			}
			
			// read projects from resource and add them to the projects-list
			for(EObject project: resource.getContents()) {
				if(project instanceof XMIECPProject) {
					((ECPProject) project).setWorkspace(this);
					project.eAdapters().add(projectListener);
					projects.add((ECPProject) project);
				}
			}
		}
	} // END loadProjects()
	
	/**
	 * Initializes workspace with the folders contained in the xmi-resource.
	 */
	private void loadFolders() {		
		// read folders from resource
		for(EObject folder: resource.getContents()) {
			if(folder instanceof XMIECPFolder) {
				((XMIECPFolder) folder).setWorkspace(this);
				folder.eAdapters().add(projectListener);
				folders.add((XMIECPFolder) folder);
			}
		}
	} // END loadFolders()
	
	private void buildProjectListener() {
		projectListener = new EContentAdapter() {
			
			@Override
			public void notifyChanged(Notification notification) {
				// save the changed objects
				Object changedObj = notification.getNotifier();
				
				if(changedObj instanceof EObject) {
					EObject changedEObj = (EObject) changedObj; // cast the object to an EObject
					
					// try to save object to the attached resource
					try {
						changedEObj.eResource().save(Collections.EMPTY_MAP); // save changes into resource
					} catch (IOException e) {
						new XMIWorkspaceException("Unable to persist object to xmi resource.", e);
					} catch (NullPointerException e) {
						new XMIWorkspaceException("Unable to persist object. Attached resource missing.", e);
					}
				}
				
				// continue
				super.notifyChanged(notification);
			}
			
		};
	}

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
		result.addAll(folders);
		return result;
	}
	
	/**
	 * Adds a project to the workspace.
	 * @param project XMIECPProject that is added to the workspace. 
	 */
	public void addProject(ECPProject project) {
		project.setWorkspace(this);
		project.eAdapters().add(projectListener);
		resource.getContents().add(project);
		
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			new XMIWorkspaceException("Could not add new project to workspace. Unable to write to workspace file.", e);
		}
		
		projects.add(project);
		setActiveProject(project);
	}
	
	/**
	 * Removes a project from the workspace.
	 * @param project XMIECPProject to be removed from the workspace.
	 */
	public void removeProject(ECPProject project) {
		resource.getContents().remove(project);
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			new XMIWorkspaceException("Could not delete project. Error while writing workspace-file.", e);
		}
		
		projects.remove(project);
		project.dispose();
	}

	@Override
	public ECPProject getActiveProject() {
		ECPProject ap = super.getActiveProject();
		
		// added this to avoid errors
		if(ap == null) {
			// It should throw an error here, that no project is selected, but it's ignored here.
			return projects.get(0);
		}
		
		return ap;
	}

	@Override
	public void setActiveProject(ECPProject newActiveProject) {
		super.setActiveProject(newActiveProject);
	}
	
	/**
	 * Adds a directory to the workspace.
	 * @param dir XMIECPFolder-object representing a real folder on the hard-drive.
	 */
	public void addFolder(XMIECPProjectContainer dir) {
		dir.setWorkspace(this);
		dir.eAdapters().add(projectListener);
		resource.getContents().add(dir);
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			new XMIWorkspaceException("Could not save folder. Error while writing workspace-file.", e);
		}
		
		folders.add(dir);
	}
	
	/**
	 * Removes a directory from the workspace.
	 * @param dir XMIECPFolder-object representing a read folder on the hard-drive.
	 */
	public void removeFolder(XMIECPProjectContainer dir) {
		resource.getContents().remove(dir);
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			new XMIWorkspaceException("Could not remove folder. Error while writing workspace-file.", e);
		}
		folders.remove(dir);
		dir.dispose();
	}
}
