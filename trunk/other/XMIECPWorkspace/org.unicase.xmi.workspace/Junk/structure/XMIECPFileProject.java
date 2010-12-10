package org.unicase.xmi.structure;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import library.Book;
import library.Library;
import library.LibraryFactory;
import library.Writer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.unicase.ecp.model.ECPAssociationClassElement;
import org.unicase.ecp.model.MetaModelElementContext;
import org.unicase.ecp.model.workSpaceModel.ECPProjectListener;
import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;
import org.unicase.ecp.model.workSpaceModel.impl.ECPProjectImpl;
import org.unicase.workspace.Configuration;
import org.unicase.xmi.exceptions.XMIWorkspaceException;
import org.unicase.xmi.workspace.XMIMetaModelElementContext;

/**
 * This class represents one project as one xmi-file
 * @author Markus, Matti
 *
 */
public class XMIECPFileProject extends ECPProjectImpl implements XMIECPProject {

	private static final boolean TEST_RUN = true; // set whether you run in test-mode with library model or not.
	
	private EditingDomain editingDomain;
	private URI xmiFilePath;
	private Resource resource;
	List<ECPProjectListener> listeners = new ArrayList<ECPProjectListener>();
	
	private EContentAdapter listenerAdapter;
	
	/**
	 * Creates a new XMIECPFileProject representing one xmi-file.
	 * @param filePath the path to the file where it should be created/loaded from
	 * @param ws the workspace the project is contained in
	 */
	public XMIECPFileProject(String filePath, ECPWorkspace ws) {
		super();
		
		this.xmiFilePath = URI.createFileURI(filePath);
		this.editingDomain = ws.getEditingDomain();
		
		buildEContentAdapter();
		init();
	}
	
	/**
	 * Initializes project
	 */
	private void init() {
		File xmiFile = new File(xmiFilePath.toFileString());
		if(!xmiFile.exists()) {
			// create the resource
			this.resource = new ResourceSetImpl().createResource(xmiFilePath);
			
			// TEST
			if(TEST_RUN) {
				// build a library with a book and a writer
				LibraryFactory factory = LibraryFactory.eINSTANCE;
				Library library = factory.createLibrary();
				Book book = factory.createBook();
				book.setTitle("bla");
				Writer writer = factory.createWriter();
				writer.setName("him");
				library.getBooks().add(book);
				library.getWriters().add(writer);
				
				// set library as root
				setRootObject(this);
				this.resource.getContents().add(this);
				
				try {
					this.resource.save(Collections.EMPTY_MAP);
				}
				catch(IOException e) {
					new XMIWorkspaceException("Cannot create empty project-file.", e);
				}
			}
			// END TEST
			
			//TODO create new project root node with icon
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
		
		// set the root if the resource contains objects, otherwise build new root
		if(!this.resource.getContents().isEmpty()) {
			setRootObject(this.resource.getContents().get(0)); // first object must be root
		}
		getRootObject().eAdapters().add(listenerAdapter);
	}
	
	/**
	 * Implements listenerAdapter to save resources when they change.
	 */
	private void buildEContentAdapter() {
		listenerAdapter = new EContentAdapter() {
			
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

	public boolean contains(EObject eObject) {
		return getAllModelElements().contains(eObject);
	}

	public Collection<EObject> getAllModelElement() {
		return getAllModelElements();
	}

	public void addECPProjectListener(ECPProjectListener listener) {
		this.listeners.add(listener);
	}

	//TODO check whether needed to call finalize() !!!
	public void dispose() {
		// remove all references, method similar to destructor
		try {
			this.finalize();
		} catch (Throwable e) {
			new XMIWorkspaceException("Cannot dispose XMIFileProject.", new Exception("Cannot dispose."));
		}
	}

	
	/**
	 * Filters the basicEList for objects with the given EClass.
	 * @return Returns only objects with the given EClass.
	 */
	public Collection<EObject> getAllModelElementsbyClass(EClass clazz, BasicEList<EObject> basicEList) {
		EList<EObject> list = new BasicEList<EObject>();
		for(EObject obj: basicEList) {
			if(obj.eClass() == clazz) {
				list.add(obj);
			}
		}
		return list;
	}

	public boolean isNonDomainElement(EObject eObject) {
		// TODO What is this method supposed to do?
		return false;
	}

	public void modelelementDeleted(EObject eobject) {
		// Remove model element from xmi-file -> just save it.
		saveResource();
		
		for(ECPProjectListener listener : listeners) {
			listener.modelelementDeleted(eobject);
		}
	}

	public void projectChanged() {
		// Save all objects into the xmi-file
		saveResource();
		
		for(ECPProjectListener listener : listeners) {
			listener.projectChanged();
		}
	}
	
	/**
	 * Calls save on the resource of this project.
	 */
	private void saveResource() {
		try {
			this.resource.save(Configuration.getResourceSaveOptions());
		} catch (IOException e) {
			new XMIWorkspaceException("Cannot save changes to xmi-project-file.", e);
		}
	}

	public void projectDeleted() {
		for(ECPProjectListener listener : listeners) {
			listener.projectDeleted();
		}
		
		dispose();
	}

	public void removeECPProjectListener(ECPProjectListener listener) {
		this.listeners.remove(listener);
	}

	public Collection<EObject> getAllModelElements() {
		Set<EObject> result = new HashSet<EObject>();
		TreeIterator<EObject> eAllContents = getRootObject().eAllContents();
		while (eAllContents.hasNext()) {
			result.add(eAllContents.next());
		}
		return result;
	}

	public ECPAssociationClassElement getAssociationClassElement(EObject eObject) {
		// TODO What does this do?
		return null;
	}

	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	public MetaModelElementContext getMetaModelElementContext() {
		return new XMIMetaModelElementContext();
	}

	public boolean isAssociationClassElement(EObject eObject) {
		// TODO What does this do?
		return false;
	}

	public String getFilePath() {
		return xmiFilePath.toFileString();
	}

	public void addModelElementToRoot(EObject eObject) {
		// TODO Auto-generated method stub
		
	}
}
