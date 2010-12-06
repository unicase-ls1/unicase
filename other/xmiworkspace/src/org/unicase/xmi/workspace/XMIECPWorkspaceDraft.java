/**
 * 
 */
package org.unicase.xmi.workspace;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import library.Book;
import library.Library;
import library.LibraryFactory;
import library.Writer;

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
import org.unicase.ui.navigator.workSpaceModel.ECPProject;
import org.unicase.ui.navigator.workSpaceModel.ECPWorkspace;
import org.unicase.ui.navigator.workSpaceModel.impl.ECPWorkspaceImpl;
import org.unicase.workspace.Configuration;
import org.unicase.xmi.exceptions.XMIWorkspaceException;
/**
 * Implements a workspace based on an XMI resource.
 * !!! This is a test implementation and only works when the PERSIST_PROJECT-flg is false !!!
 * @author maierma, kraftm
 *
 */
public class XMIECPWorkspaceDraft extends ECPWorkspaceImpl implements ECPWorkspace {

	// FLAG FOR DEBUGGING
	private static final boolean PERSIST_PROJECT = false; // in case of true the project is persisted instead of the model-element(s)
	
	/**
	 * ListenerAdapter that's being called when an object in the model has changed.
	 */
	private static AdapterImpl workspaceListenerAdapter;
	
	/**
	 * Holds the path to the xmi resource file.
	 */
	private static URI xmiPath;
	
	/**
	 * Contains the xmi resources needed to persist the workspace contents.
	 */
	private static ResourceSet resourceSet;
	
	/**
	 * Copied transactional domain
	 */
	private static final String TRANSACTIONAL_EDITINGDOMAIN_ID = "org.unicase.EditingDomain";
	
	/**
	 * Initializes an workspace with an underlying XMI file.
	 */
	public XMIECPWorkspaceDraft() {
		resourceSet = new ResourceSetImpl();
		xmiPath = URI.createFileURI(Platform.getLocation().toString() + "xmiworkspace.ucw");
		
		buildEContentAdapter();
	}
	
	/**
	 * Sets the workspaceListenerAdapter as a new EContentAdapter with the content of saving the resource when changed.
	 */
	private void buildEContentAdapter() {
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
		
		if(!xmiFile.exists()) {
			// file does not exists and therefore the workspace has to be build
			xmires = resourceSet.createResource(xmiPath); // creates file
			
			// add projects for testing -> library model
			projects = new BasicEList<ECPProject>();			
			
			LibraryFactory factory = LibraryFactory.eINSTANCE;
			Library library = factory.createLibrary();
			Book book = factory.createBook();
			book.setTitle("bla");
			Writer writer = factory.createWriter();
			writer.setName("him");
			library.getBooks().add(book);
			library.getWriters().add(writer);
			
			XMIECPProject project = new XMIECPProject(getEditingDomain(), library);
			
			if(PERSIST_PROJECT) { // for debugging
				project.eAdapters().add(workspaceListenerAdapter);
				xmires.getContents().add(project);
			}
			else {
				library.eAdapters().add(workspaceListenerAdapter);
				xmires.getContents().add(library);
			}
			
			projects.add(project);
			
			// test end
			
			// try to persist new workspace, otherwise log failure
			try {
				xmires.save(Collections.EMPTY_MAP);
				}
			catch(IOException e) {
				new XMIWorkspaceException("Creating new workspace failed! Delete workspace-file: " + Configuration.getWorkspaceDirectory(), e);
			}
		}
		else {
			xmires = resourceSet.getResource(xmiPath, true);
			
			// try to load resource
			try {
				xmires.load(Collections.EMPTY_MAP);
			} catch (IOException e) {
				new XMIWorkspaceException("Failed to load workspace-file.", e);
			}
			
			EList<EObject> xmicontents = xmires.getContents();
			projects = new BasicEList<ECPProject>();
			
			for(EObject eo: xmicontents) {
				XMIECPProject ecpp = null;
				
				if(PERSIST_PROJECT) {
					if(eo instanceof XMIECPProject) {
						ecpp = (XMIECPProject) eo;
						ecpp.eAdapters().add(workspaceListenerAdapter);
					}
				}
				else {
					if(eo instanceof Library) {
						Library lib = (Library) eo;
						lib.eAdapters().add(workspaceListenerAdapter);
						ecpp = new XMIECPProject(getEditingDomain(), lib);
					}
				}
				projects.add(ecpp);
				super.setActiveProject(ecpp);
			}
		}
		
		return projects;
	}
}
