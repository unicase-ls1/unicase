package org.unicase.xmi.workspace;

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
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreePath;
import org.unicase.ecp.model.workSpaceModel.ECPProject;
import org.unicase.ecp.model.workSpaceModel.ECPProjectListener;
import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;
import org.unicase.ecp.model.workSpaceModel.impl.ECPWorkspaceImpl;
import org.unicase.ui.navigator.TreeView;
import org.unicase.xmi.exceptions.XMIWorkspaceException;
import org.unicase.xmi.workspace.XmiUtil.PROJECT_STATUS;
import org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject;
import org.unicase.xmi.xmiworkspacestructure.XMIECPProject;


public class XMIECPWorkspace extends ECPWorkspaceImpl implements ECPWorkspace {
	
	/**
	 * Copied transactional domain
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
		resource = null;
		
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
					// try to add project to workspace
					XMIECPFileProject pro = (XMIECPFileProject) project;
					pro.setProjectStatus(PROJECT_STATUS.NOTLOADED);
					String path = pro.getXmiFilePath();
					
					// check for duplicate projects
					if(projectPathExists(path)) {
						pro.setProjectStatus(PROJECT_STATUS.DUPLICATED);
					}
					else {
						if(!(new File(path)).exists()) { 
							// set project status to failed
							pro.setProjectStatus(PROJECT_STATUS.FAILED);
						}
					}
					
					// add project to workspace
					pro.setWorkspace(this);
					pro.eAdapters().add(projectListener);
					getProjects().add(pro);
				}
			} // END FOR loop through projects of xmi workspace file
			try {
				this.resource.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				new XMIWorkspaceException("Unable to save projects to workspace xmi-file. Please clean it up.", e);
			}
		} // END ELSE if the workspace file does exist 
		
	} // END loadProjects()
	
	/**
	 * Checks whether a project in the workspace has the same path than the given one.
	 * @param path Path of a xmi file.
	 * @return True if the path is already in the workspace, otherwise false
	 */
	public boolean projectPathExists(String path) {
		// if projects is not set or null just return false
		if(projects == null || projects.isEmpty()) return false;
		
		// iterate over all projects and check for their path		
		for(ECPProject p: projects) {
			if(p instanceof XMIECPFileProject && ((XMIECPFileProject) p).getXmiFilePath().equals(path)) {
				return true;
			}
		}
		return false;
	}

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
		if (TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(TRANSACTIONAL_EDITINGDOMAIN_ID) == null) {
			final TransactionalEditingDomain domain = new TransactionalEditingDomainImpl(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
			TransactionalEditingDomain.Registry.INSTANCE.add(TRANSACTIONAL_EDITINGDOMAIN_ID, domain);
			domain.setID(TRANSACTIONAL_EDITINGDOMAIN_ID);
		}		
		return TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(TRANSACTIONAL_EDITINGDOMAIN_ID);
	}
	
	@Override
	public EList<ECPProject> getProjects() {
		if(projects == null) {
			projects = new BasicEList<ECPProject>();
		}
		return projects;
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
		
		getProjects().add(project);
		setActiveProject(project);
		TreeView.getTreeViewer().refresh();
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
		
		getProjects().remove(project);
		for(ECPProjectListener pl: ((XMIECPFileProject) project).getProjectListeners()) {
			pl.projectDeleted();
		}
		project.dispose();
		TreeView.getTreeViewer().refresh();
	}

	/**
	 * Returns the project that the user is currently working in,
	 * by checking where the current selection is.
	 */
	@Override
	public ECPProject getActiveProject() {
		// get active project is one is set -> usually null
		ECPProject ap = super.getActiveProject();
		
		// get selection from the tree viewer
		ITreeSelection selection = (ITreeSelection) TreeView.getTreeViewer().getSelection();		
		TreePath[] paths = selection.getPaths();
		
		// get the first object in the path of the first selected element
		if(paths != null && paths.length != 0) {
			Object firstObject = paths[0].getFirstSegment();
			if(firstObject instanceof XMIECPFileProject) {
				XMIECPFileProject project = (XMIECPFileProject) firstObject;
				ap = project;
			}
		}
		
		// if the active project is still null, simply return the first project
		if(ap == null) {
			// It should throw an error here, that no project is selected, but it's ignored here.
			return getProjects().get(0);
		}
		
		return ap;
	}
}
