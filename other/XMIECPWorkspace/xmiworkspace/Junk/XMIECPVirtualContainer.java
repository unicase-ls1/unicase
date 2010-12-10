package org.unicase.xmi.structure;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.unicase.ui.common.ECPAssociationClassElement;
import org.unicase.ui.navigator.workSpaceModel.ECPProjectListener;
import org.unicase.ui.navigator.workSpaceModel.ECPWorkspace;
import org.unicase.workspace.Configuration;
import org.unicase.xmi.exceptions.XMIWorkspaceException;


/**
 * This class represents multiple ecpprojects within
 * one xmi-file
 * @author Markus, Matti
 *
 */
public class XMIECPVirtualContainer extends XMIECPContainer {
	
	private URI xmiFilePath;
	private Resource resource;
	
	/**
	 * Creates an XMIECPProject from a single xmi-files, but this one contains multiple XMIECPProjects.
	 * @param filePath Path to the xmi-file containing the XMIECPProjects.
	 * @param workspace Workspace this project is contained in.
	 */
	public XMIECPVirtualContainer(String filePath, ECPWorkspace workspace) {
		super();
		
		this.workspace = workspace;
		this.xmiFilePath = URI.createFileURI(filePath);
		
		setContentAdapter();
		init();
	}
	
	/**
	 * Initializes project. 
	 */
	private void init() {
		File xmiFile = new File(xmiFilePath.toFileString());
		
		if(!xmiFile.exists()) {
			// create the resource
			this.resource = new ResourceSetImpl().createResource(xmiFilePath);
		}
		else {
			// get the resource
			this.resource = new ResourceSetImpl().getResource(xmiFilePath, true);
		}
		
		// try to load the resource
		try {
			this.resource.load(Collections.EMPTY_MAP);
		}
		catch(IOException e) {
			new XMIWorkspaceException("Creating new project failed! Delete project-file: " + Configuration.getWorkspaceDirectory(), e);
		}
		
		// set the root if the resource contains objects
		if(!this.resource.getContents().isEmpty()) {
			EObject rootObj = resource.getContents().get(0);
			setRootObject(rootObj);
			
			// get all projects in the file
			for(int i = 1; i < resource.getContents().size(); i++) {
				// this should be XMIECPProjects
				XMIECPProject proj = (XMIECPProject) resource.getContents().get(i);
				internalProjects.add(proj);
			}
		}
		else {
			//TODO set root
		}
		
	} // END init()

	@Override
	protected void setContentAdapter() {
		contentAdapter = new EContentAdapter() {
			public void notifyChanged(Notification notification) {
				if(!resource.getContents().isEmpty()) {
					try {
						resource.save(Configuration.getResourceSaveOptions());
					} catch (IOException e) {
						new XMIWorkspaceException("Unable to save changed objects to " + xmiFilePath.toFileString(), e);
					}
				}
			}
		};
	}

	public boolean contains(EObject eObject) {
		return getAllModelElements().contains(eObject);
	}

	public boolean isNonDomainElement(EObject eObject) {
		// TODO What to do here?
		return false;
	}

	public void modelelementDeleted(EObject eobject) {
		projectChanged(); // !!! LISTENERS CALLED TWICE !!!
		
		for(ECPProjectListener l: listeners) {
			l.modelelementDeleted(eobject);
		}
	}

	public void projectChanged() {
		try {
			resource.save(Configuration.getResourceSaveOptions());
		} catch (IOException e) {
			new XMIWorkspaceException("Unable to save changed objects " + xmiFilePath.toFileString(), e);
		}
		
		for(ECPProjectListener l: listeners) {
			l.projectChanged();
		}
	}

	public void projectDeleted() {
		// TODO Delete xmi-file ???
		
		for(ECPProjectListener l: listeners) {
			l.projectDeleted();
		}
	}

	public ECPAssociationClassElement getAssociationClassElement(EObject eObject) {
		// TODO What does this do?
		return null;
	}

	public boolean isAssociationClassElement(EObject eObject) {
		// TODO What does this do?
		return false;
	}

}
