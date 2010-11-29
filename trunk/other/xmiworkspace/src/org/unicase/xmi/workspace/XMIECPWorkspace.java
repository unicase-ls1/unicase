/**
 * 
 */
package org.unicase.xmi.workspace;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.unicase.model.document.impl.DocumentFactoryImpl;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.impl.RequirementFactoryImpl;
import org.unicase.ui.navigator.workSpaceModel.ECPProject;
import org.unicase.ui.navigator.workSpaceModel.ECPWorkspace;
import org.unicase.ui.navigator.workSpaceModel.WorkSpaceModelFactory;
import org.unicase.ui.navigator.workSpaceModel.impl.ECPProjectImpl;
import org.unicase.ui.navigator.workSpaceModel.impl.ECPWorkspaceImpl;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.changeTracking.commands.EMFStoreTransactionalCommandStack;
import org.unicase.workspace.impl.ProjectSpaceImpl;
import org.unicase.xmi.exceptions.XMIWorkspaceException;
/**
 * Implements a workspace based on an XMI resource.
 * @author maierma, kraftm
 *
 */
public class XMIECPWorkspace extends ECPWorkspaceImpl implements ECPWorkspace {

	/**
	 * ListenerAdapter that's being called when an object in the model has changed.
	 */
	private AdapterImpl workspaceListenerAdapter;
	
	/**
	 * Holds the path to the xmi resource file.
	 */
	private static URI xmiPath;
	
	/**
	 * Contains the xmi resources needed to persist the workspace contents.
	 */
	private ResourceSet resourceSet;
	
	/**
	 * Copied transactional domain
	 */
	private static final String TRANSACTIONAL_EDITINGDOMAIN_ID = "org.unicase.EditingDomain";
	
	/**
	 * Initializes an workspace with an underlying XMI file.
	 */
	public XMIECPWorkspace() {
		resourceSet = new ResourceSetImpl();
		xmiPath = URI.createFileURI(Platform.getLocation().toString() + "xmiworkspace.ucw");
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.navigator.workSpaceModel.ECPWorkspace#getEditingDomain()
	 */
	@Override
	public TransactionalEditingDomain getEditingDomain() {
		TransactionalEditingDomain editingDomain2 = Configuration.getEditingDomain();
		if (editingDomain2 == null) {
			final TransactionalEditingDomain domain = new TransactionalEditingDomainImpl(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
			TransactionalEditingDomain.Registry.INSTANCE.add(TRANSACTIONAL_EDITINGDOMAIN_ID, domain);
			domain.setID(TRANSACTIONAL_EDITINGDOMAIN_ID);
		}		
		return Configuration.getEditingDomain();
	}
	
	/**
	 * Returns the projects in the workspace with a listener on changes
	 */
	@Override
	public EList<ECPProject> getProjects() {
		// Check whether a xmi resource file exists
		File xmiFile = new File(Configuration.getWorkspacePath());
		Resource xmires; // automatically an XMI Resource
		ECPWorkspace ws; // workspace that's being persisted
		
		if(!xmiFile.exists()) {
			// file does not exists and therefore the workspace has to be build
			xmires = resourceSet.createResource(xmiPath); // creates file
			ws = WorkSpaceModelFactory.eINSTANCE.createECPWorkspace(); // creates a new workspace
			
			xmires.getContents().add(ws); // adds the workspace to the (xmi)resource
			
			// try to persist new workspace, otherwise log failure
			try {
				xmires.save(Configuration.getResourceSaveOptions());
				}
			catch(IOException e) {
				new XMIWorkspaceException("Creating new workspace failed! Delete workspace folder: " + Configuration.getWorkspaceDirectory(), e);
			}
			
			
		}
		else {
			xmires = resourceSet.getResource(xmiPath, true); // tries to get the resource
			ws = (ECPWorkspace) xmires.getContents().get(0); // there is only one object in the resource and that's the workspace
		}
		
		workspaceListenerAdapter = new EContentAdapter() {
			
			/**
			 * This method is being called when an object in the model changes,
			 * it persists the changes instantely to the xmi resource
			 */
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
						new XMIWorkspaceException("Wasn't able to persist object to xmi resource.", e);
					} catch (NullPointerException e) {
						new XMIWorkspaceException("Unable to persist object. Attached resource missing.", e);
					}
				}
				
				// continue
				super.notifyChanged(notification);
			}
		};
		
		// add listener to workspace
		ws.eAdapters().add(workspaceListenerAdapter);
		
		// set the editing domain for the workspace
		ws.setEditingDomain(getEditingDomain());
		
		// set the current projects
		projects = ws.getProjects();
		
		// add projects for testing
		ECPProject proj = new XMIECPProject(getEditingDomain(), DocumentFactoryImpl.init().createCompositeSection());
		FunctionalRequirement freq = RequirementFactoryImpl.init().createFunctionalRequirement();
		proj.getAllModelElement().add(freq);
		projects.add(proj);
		
		return projects;
	}
}
