package org.unicase.xmi.structure;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.unicase.ui.common.ECPAssociationClassElement;
import org.unicase.ui.navigator.workSpaceModel.ECPProjectListener;
import org.unicase.ui.navigator.workSpaceModel.ECPWorkspace;
import org.unicase.workspace.Configuration;
import org.unicase.xmi.exceptions.XMIFileTypeException;
import org.unicase.xmi.exceptions.XMIWorkspaceException;

/**
 * This class represents a "real" folder on the 
 * filesystem containing xmi-files
 * @author Markus, Matti
 *
 */
public class XMIECPFolder extends XMIECPContainer {

	private URI xmiFolderPath;
	private ResourceSet resources;
	
	/**
	 * Creates a new XMIECPProject containing all projects from the files in the given folder.
	 * @param ws Workspace containing the XMIECPProject
	 * @param folderPath Path to a folder with xmi-resources/XMIECPProjects.
	 */
	public XMIECPFolder(ECPWorkspace ws, String folderPath) {
		super();
		
		this.workspace = ws;
		this.xmiFolderPath = URI.createURI(folderPath);
		
		//TODO set root and add contentListener
		setContentAdapter();
		
		init();
	}
	
	/**
	 * Inizializing project-container
	 */
	private void init() {
		// creating resources
		File xmiFolder = new File(xmiFolderPath.toFileString());
		resources = new ResourceSetImpl();
		
		// checking whether the file is really a directory
		if(!xmiFolder.isDirectory()) {
			new XMIFileTypeException("The given path " + xmiFolderPath.toPlatformString(false) + " is not a directory.");
		}
		else if(!xmiFolder.exists()) {
			// folder does not exists and must be created
			if(!xmiFolder.mkdir()) {
				// unable to create folder
				new XMIFileTypeException("Unable to create directory " + xmiFolder.getPath());
			}
		}
		else {
			// the file is a directory and therefore the files within the directory are read
			File[] files = xmiFolder.listFiles();
			for(int i = 0; i < files.length; i++) {
				Resource xmiFile = resources.getResource(URI.createFileURI(files[i].getPath()), true);
				
				// try to load the file to see whether it's a valid resource
				try {
					xmiFile.load(Collections.EMPTY_MAP);
					resources.getResources().add(xmiFile);
				}
				catch(IOException e) {
					new XMIFileTypeException(files[i].getPath() + " is not a valid xmi resource and won't be loaded.");
				}
			}
			
			// each valid file has to be build as a XMIECPProject now and added to the internal project management
			for(Resource res: resources.getResources()) {
				XMIECPProject project = new XMIECPFileProject(res.getURI().toFileString(), getWorkspace());
				for(ECPProjectListener l: listeners) {
					project.addECPProjectListener(l);
				}
				internalProjects.add(project);
			}
		}
	} // END init

	/**
	 * Finds the associated project for the EObject.
	 * @param eObject EObject to look for
	 * @return Project in which the EObject is contained
	 */
	private XMIECPProject getProjectForModelElement(EObject eObject) {
		for(XMIECPProject p: internalProjects) {
			if(p.contains(eObject)) return p;
		}
		return null;
	}
	
	public boolean contains(EObject eObject) {
		if(getProjectForModelElement(eObject) == null) return false;
		else return true;
	}

	public boolean isNonDomainElement(EObject eObject) {
		// TODO What is this method supposed to do?
		return false;
	}

	public void modelelementDeleted(EObject eobject) {
		projectChanged(); // !!!LISTENERS GET INFORMED TWICE!!!
		
		for(ECPProjectListener l: listeners) {
			l.modelelementDeleted(eobject);
		}
	}

	public void projectChanged() {
		// TODO Auto-generated method stub
		for(Resource res : resources.getResources()) {
			try {
				res.save(Configuration.getResourceSaveOptions());
			} catch (IOException e) {
				new XMIWorkspaceException("Unable to save resource " + res.getURI().toFileString(), e);
			}
		}
		for(ECPProjectListener l: listeners) {
			l.projectChanged();
		}
	}

	public void projectDeleted() {
		// TODO Delete folder????
		
		for(ECPProjectListener l: listeners) {
			l.projectDeleted();
		}
	}

	public ECPAssociationClassElement getAssociationClassElement(EObject eObject) {
		return getProjectForModelElement(eObject).getAssociationClassElement(eObject);
	}

	public boolean isAssociationClassElement(EObject eObject) {
		return getProjectForModelElement(eObject).isAssociationClassElement(eObject);
	}

	@Override
	protected void setContentAdapter() {
		this.contentAdapter = new EContentAdapter() {
			public void notifyChanged(Notification notification) {
				projectChanged();
				super.notifyChanged(notification);
			}
		};
	}
	
}
