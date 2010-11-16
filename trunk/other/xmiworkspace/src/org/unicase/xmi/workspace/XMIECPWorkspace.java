package org.unicase.xmi.workspace;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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


public class XMIECPWorkspace extends ECPWorkspaceImpl implements ECPWorkspace {

	public static final String XMIFILENAME = "resource.xmi";
	private static final String TRANSACTIONAL_EDITINGDOMAIN_ID = "org.unicase.xmi.resource.editingDomain";
	
	private File xmi;
	private XMIResource xmires;
	private AdapterImpl workspaceListenerAdapter;
	
	public XMIECPWorkspace() {
		// check whether file exists, then try to load it
		xmi = new File(XMIFILENAME);
		if(xmi.exists()) {
			// file exists
			xmires = new XMIResourceImpl(URI.createFileURI(XMIFILENAME));
		}
		else {
			// file does not exist, make new xmi resource
			xmires = (XMIResource) new XMIResourceFactoryImpl().createResource(URI.createFileURI(XMIFILENAME));
			if(!xmi.exists()) new SWTException("Unable to create XMI resource file.");
		}
		
		// try to load xmi resource
		try {
			xmires.load(new FileInputStream(xmi), null);
		} catch (FileNotFoundException e) {
			new SWTException(XMIFILENAME + " cannot be found.");
		} catch (IOException e) {
			new SWTException(XMIFILENAME + " cannot be loaded.");
		}
	}
	
	@Override
	public EList<ECPProject> getProjects() {

		//get the projects from the xmi resource
		if(xmires.getContents() == null) {
			projects = super.getProjects();
		}
		else {
			ECPWorkspace ws = (ECPWorkspace) xmires.getContents().get(0);
			projects = ws.getProjects();
		}
		
		// make a new listener to be notified when an object changes
		workspaceListenerAdapter = new AdapterImpl() {
	
			public void notifyChanged(Notification msg) {
				// save all changes into xmi resource
				try {
					Resource clientws = (Resource) WorkspaceManager.getInstance().getWorkSpace();
					clientws.save(new FileOutputStream(xmi), null);
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
		return TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(TRANSACTIONAL_EDITINGDOMAIN_ID);
	}
}
