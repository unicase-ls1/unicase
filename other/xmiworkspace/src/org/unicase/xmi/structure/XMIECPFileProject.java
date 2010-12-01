package org.unicase.xmi.structure;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.unicase.ui.common.ECPAssociationClassElement;
import org.unicase.ui.common.MetaModelElementContext;
import org.unicase.ui.navigator.workSpaceModel.ECPProjectListener;
import org.unicase.ui.navigator.workSpaceModel.ECPWorkspace;
import org.unicase.workspace.Configuration;
import org.unicase.xmi.exceptions.XMIWorkspaceException;
import org.unicase.xmi.workspace.XMIMetaModelElementContext;

/**
 * This class represents one project as one xmi-file
 * @author Markus, Matti
 *
 */
public class XMIECPFileProject extends EObjectImpl implements XMIECPProject {

	private EditingDomain editingDomain;
	private ECPWorkspace workspace;
	private URI xmiFilePath;
	private Resource resource;
	List<ECPProjectListener> listeners = new ArrayList<ECPProjectListener>();
	
	private EObject root;
	
	/**
	 * Creates a new XMIECPFileProject representing one xmi-file.
	 * @param filePath the path to the file where it should be created/loaded from
	 * @param ws the workspace the project is contained in
	 */
	public XMIECPFileProject(String filePath, ECPWorkspace ws) {
		super();
		
		this.xmiFilePath = URI.createFileURI(filePath);
		this.workspace = ws;
		this.editingDomain = ws.getEditingDomain();
		
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
			this.root = this.resource.getContents().get(0); // first object must be root
		}
	}

	public ECPWorkspace getWorkspace() {
		return this.workspace;
	}

	public void setWorkspace(ECPWorkspace value) {
		this.workspace = value;
	}

	public boolean contains(EObject eObject) {
		return getAllModelElements().contains(eObject);
	}

	public Collection<EObject> getAllModelElement() {
		return getAllModelElements();
	}

	public EObject getRootObject() {
		return root;
	}

	public void setRootObject(EObject value) {
		this.root = value;
	}

	public void addECPProjectListener(ECPProjectListener listener) {
		this.listeners.add(listener);
	}

	public void dispose() {
		// TODO What is this method supposed to do? Set all references to "null" so it can be collected from the garbage collector?
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
		// TODO Remove model element from xmi-file
		projectChanged();
		
		for(ECPProjectListener listener : listeners) {
			listener.modelelementDeleted(eobject);
		}
	}

	public void projectChanged() {
		// TODO Save all objects into the xmi-file
		try {
			this.resource.save(Configuration.getResourceSaveOptions());
		} catch (IOException e) {
			new XMIWorkspaceException("Cannot save changes to xmi-project-file.", e);
		}
		
		for(ECPProjectListener listener : listeners) {
			listener.projectChanged();
		}
	}

	public void projectDeleted() {
		// TODO Delete xmi-file?!
		
		for(ECPProjectListener listener : listeners) {
			listener.projectDeleted();
		}
	}

	public void removeECPProjectListener(ECPProjectListener listener) {
		this.listeners.remove(listener);
	}

	public Collection<EObject> getAllModelElements() {
		Set<EObject> result = new HashSet<EObject>();
		TreeIterator<EObject> eAllContents = root.eAllContents();
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

}
