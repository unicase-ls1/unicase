package org.unicase.xmi.workspace;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.SWTException;
import org.unicase.ui.navigator.NoWorkspaceException;
import org.unicase.ui.navigator.WorkspaceManager;
import org.unicase.ui.navigator.workSpaceModel.ECPProject;
import org.unicase.ui.navigator.workSpaceModel.ECPWorkspace;
import org.unicase.ui.navigator.workSpaceModel.impl.ECPWorkspaceImpl;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;


public class XMIECPWorkspace extends ECPWorkspaceImpl implements ECPWorkspace {

	public static final String XMIFILENAME = "resource.xmi";
	private XMIResource xmires;
	private AdapterImpl workspaceListenerAdapter;
	
	public XMIECPWorkspace() {
		// check whether file exists, then try to load it
		File xmi = new File(XMIFILENAME);
		if(xmi.exists()) {
			// file exists
			xmires = new XMIResourceImpl(URI.createFileURI(XMIFILENAME));
		}
		else {
			// file does not exist, make new xmi resource
			xmires = (XMIResource) (new XMIResourceFactoryImpl().createResource(URI.createFileURI(XMIFILENAME)));
			//Q: Why is no file created?
		}
		
		// try to load xmi resource
		try {
			xmires.load(null);
		}
		catch(IOException e) {
			new SWTException(XMIFILENAME + " cannot be loaded.");
		}
	}
	
	@Override
	public EList<ECPProject> getProjects() {

		// get the projects from the xmi resource
		EList<Resource> xmicontent = xmires.getResourceSet().getResources();
		Workspace ws = (Workspace) xmicontent.get(0);
		EList<ProjectSpace> spaces = ws.getProjectSpaces();
		for(ProjectSpace ps: spaces) {
			projects.add((ECPProject) ps.getProject());
		}
		
		// make a new listener to be notified when an object changes
		workspaceListenerAdapter = new AdapterImpl() {
	
			public void notifyChanged(Notification msg) {
				// save all changes into xmi resource
				try {
					Resource clientws = (Resource) WorkspaceManager.getInstance().getWorkSpace();
					clientws.save(null);
					
				} catch (Exception e) {
					new SWTException("Cannot retrieve user's workspace.");
				}
				
				// call super notifyChanged, so the process can continue
				super.notifyChanged(msg);
			}
		};
			
		// attach eAdapters to the workspace manager
		try {
			WorkspaceManager.getInstance().getWorkSpace().eAdapters().add(workspaceListenerAdapter);
		} catch (NoWorkspaceException e) {
			new SWTException("Cannot get projects from resource.");
		}
		
		// return all projects in the persistent(!) workspace
		return projects;
	}
	

	@Override
	public TransactionalEditingDomain getEditingDomain() {
		return Configuration.getEditingDomain(); // note from the author: got this from the EMFCPWorkspace class
	}
}
