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
import org.eclipse.emf.common.util.BasicEList;
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
import org.unicase.model.Project;
import org.unicase.model.bug.BugReport;
import org.unicase.model.bug.impl.BugFactoryImpl;
import org.unicase.model.document.CompositeSection;
import org.unicase.model.document.LeafSection;
import org.unicase.model.document.impl.DocumentFactoryImpl;
import org.unicase.model.impl.ModelFactoryImpl;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.impl.RequirementFactoryImpl;
import org.unicase.ui.navigator.workSpaceModel.ECPProject;
import org.unicase.ui.navigator.workSpaceModel.ECPWorkspace;
import org.unicase.ui.navigator.workSpaceModel.WorkSpaceModelFactory;
import org.unicase.ui.navigator.workSpaceModel.impl.ECPWorkspaceImpl;
import org.unicase.workspace.Configuration;
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
		File xmiFile = new File(xmiPath.toFileString());
		Resource xmires; // automatically an XMI Resource
		ECPWorkspace ws; // workspace that's being persisted
		
		if(!xmiFile.exists()) {
			// file does not exists and therefore the workspace has to be build
			xmires = resourceSet.createResource(xmiPath); // creates file
			ws = WorkSpaceModelFactory.eINSTANCE.createECPWorkspace(); // creates a new workspace
			
			// add projects for testing
			CompositeSection composite1 = DocumentFactoryImpl.init().createCompositeSection();
			CompositeSection composite2 = DocumentFactoryImpl.init().createCompositeSection();
			LeafSection leaf1 = DocumentFactoryImpl.init().createLeafSection();
			
			FunctionalRequirement freq = RequirementFactoryImpl.init().createFunctionalRequirement();
			BugReport bug1 = BugFactoryImpl.init().createBugReport();
			
			leaf1.getModelElements().add(bug1);
			leaf1.getModelElements().add(freq);
			
			composite1.setLeafSection(leaf1);
			composite1.getIncomingDocumentReferences().add(leaf1);
			composite2.getIncomingDocumentReferences().add(leaf1);
			
			Project projectNode = ModelFactoryImpl.init().createProject();
			projectNode.addModelElement(composite1);
			projectNode.addModelElement(composite2);
			
			ECPProject proj = new XMIECPProject(getEditingDomain(), projectNode);
			projects = new BasicEList<ECPProject>();
			ws.getProjects().add(proj);
			// test end
			
			xmires.getContents().add(ws); // adds the workspace to the (xmi)resource
			
			// try to persist new workspace, otherwise log failure
			try {
				xmires.save(Configuration.getResourceSaveOptions());
				}
			catch(IOException e) {
				new XMIWorkspaceException("Creating new workspace failed! Delete workspace-file: " + Configuration.getWorkspaceDirectory(), e);
			}
		}
		else {
			xmires = resourceSet.getResource(xmiPath, true); // tries to get the resource
			
			// try to load resource
			try {
				xmires.load(Collections.EMPTY_MAP);
			} catch (IOException e) {
				new XMIWorkspaceException("Failed to load workspace-file.", e);
			}
			
			ws = (ECPWorkspace) xmires.getContents().get(0); // there is only one object in the resource and that's the workspace
			projects = ws.getProjects(); // get the projects from the xmi-file-workspace
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
		
		return projects;
	}
}
