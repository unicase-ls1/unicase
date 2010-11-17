package org.unicase.xmi.workspace;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
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

/**
 * XMIECPWorkspace implementation
 * @author matti
 *
 */
public class XMIECPWorkspace extends ECPWorkspaceImpl implements ECPWorkspace {

	/**
	 * Filename of the xmi-resource,
	 * additionally you can set a path here
	 */
	public static final String XMIFILENAME = "resource.xmi";
	
	/**
	 * Editing domain
	 */
	private static final String TRANSACTIONAL_EDITINGDOMAIN_ID = "org.unicase.xmi.resource.editingDomain";
	
	/**
	 * File object needed to get filesystem-access
	 */
	private File xmi; //Q0: Do I need the org.eclipse.core.internal.resources File? -> line 3
	
	/**
	 * XMIResource object
	 */
	private XMIResource xmires;
	
	/**
	 * Adapter that is attached to the modelelements and listens on changes
	 */
	private AdapterImpl workspaceListenerAdapter;
	
	/**
	 * Creates a new workspace with an XMIResource in the background to persist changes locally on the harddrive.
	 */
	public XMIECPWorkspace() {
		// check whether file exists, then try to load it
		xmi = new File(XMIFILENAME);
		if(xmi.exists()) {
			// file exists
			xmires = new XMIResourceImpl(URI.createFileURI(XMIFILENAME));
		}
		else {
			// file does not exist, make new xmi resource
			try {
				xmi.createNewFile(); //Q2: Is this correct???
			} catch (IOException e) {
				new SWTException("Check permissions on files. Unable to write a new resource-file.");
			}
			xmires = (XMIResource) new XMIResourceFactoryImpl().createResource(URI.createFileURI(XMIFILENAME)); //Q1: Why is no file created here? That's why I added the lines above
			if(!xmi.exists()) new SWTException("Unable to create XMI resource file.");
		}
		
		// try to load xmi resource
		try {
			xmires.load(new FileInputStream(xmi), Collections.EMPTY_MAP);
		} catch (FileNotFoundException e) {
			new SWTException(XMIFILENAME + " cannot be found.");
		} catch (IOException e) {
			new SWTException(XMIFILENAME + " cannot be loaded.");
		}
	}
	
	@Override
	public EList<ECPProject> getProjects() {

		//get the projects from the xmi resource
		EList<EObject> xmicontent = xmires.getContents();
		
		if(xmicontent == null || xmicontent.isEmpty()) {
			projects = super.getProjects();
			
			try {
				xmicontent.add(WorkspaceManager.getInstance().getWorkSpace()); //Q3: Isn't this like xmicontent.add(this)?
			} catch (NoWorkspaceException e) {
				new SWTException("Cannot add workspace to xmi resource.");
			}
		}
		else {
			ECPWorkspace ws = (ECPWorkspace) xmicontent.get(0);
			projects = ws.getProjects();
		}
		
		// make a new listener to be notified when an object changes
		workspaceListenerAdapter = new AdapterImpl() {
	
			/**
			 * This method is being called when a modelelement has changed and therefore
			 * persists the changes instantly into the XMIResource
			 */
			public void notifyChanged(Notification msg) {
				// save all changes into xmi resource
				try {
					xmires.save(new FileOutputStream(xmi), Collections.EMPTY_MAP);
				} catch (Exception e) {
					new SWTException("Cannot retrieve user's workspace.");
				}
				
				// call super notifyChanged, so the process can continue
				super.notifyChanged(msg);
			}
		};
			
		// attach eAdapters to the workspace manager
		try {
			WorkspaceManager.getInstance().getWorkSpace().eAdapters().add(workspaceListenerAdapter); //Q4: Do we have to attach the eAdapter to this workspace?
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
