package org.unicase.xmi.structure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.unicase.ui.common.MetaModelElementContext;
import org.unicase.ui.navigator.workSpaceModel.ECPProjectListener;
import org.unicase.ui.navigator.workSpaceModel.ECPWorkspace;
import org.unicase.xmi.workspace.XMIMetaModelElementContext;

/**
 * This class represents a container for multiple projects
 * @author Markus, Matti
 *
 */
public abstract class XMIECPContainer extends EObjectImpl implements XMIECPProject {

	/**
	 * Constructor simply calling super().
	 */
	public XMIECPContainer() {
		super();
	}
	
	/**
	 * Contains projects managed by the container.
	 */
	protected EList<XMIECPProject> internalProjects = new BasicEList<XMIECPProject>();
	
	/**
	 * Gives access to all projects in the container.
	 * @return All projects contained in the container.
	 */
	public EList<XMIECPProject> getContainedProjects() {
		return this.internalProjects;
	}
	
	/**
	 * Listener for project changes
	 */
	protected List<ECPProjectListener> listeners = new ArrayList<ECPProjectListener>();
	
	public void addECPProjectListener(ECPProjectListener listener) {
		this.listeners.add(listener);
	}
	
	public void removeECPProjectListener(ECPProjectListener listener) {
		this.listeners.remove(listener);
	}
	
	/**
	 * Workspace the container is in.
	 */
	protected ECPWorkspace workspace;
	
	public void setWorkspace(ECPWorkspace value) {
		this.workspace = value;
	}
	
	public ECPWorkspace getWorkspace() {
		return workspace;
	}
	
	public EditingDomain getEditingDomain() {
		return workspace.getEditingDomain();
	}
	
	/**
	 * Root object of the project-container
	 */
	protected EObject root;
	protected EContentAdapter contentAdapter;
	
	public EObject getRootObject() {
		return root;
	}
	
	public void setRootObject(EObject value) {
		this.root = value;
		
		root.eAdapters().add(contentAdapter);
	}
	
	/**
	 * Implements the contentAdapter which is added to the root-node by setting it.
	 */
	protected abstract void setContentAdapter();
	
	// this method is the same in all subclasses and therefore in this class
	public Collection<EObject> getAllModelElement() {
		return getAllModelElements();
	}
	
	// same implementation for all subclasses
	public Collection<EObject> getAllModelElements() {
		Set<EObject> result = new HashSet<EObject>();
		
		for(XMIECPProject proj : internalProjects) {
			result.addAll(proj.getAllModelElements());
		}
		
		return result;
	}
	
	// this method is the same in all subclasses and therefore in this class
	public MetaModelElementContext getMetaModelElementContext() {
		return new XMIMetaModelElementContext();
	}
	
	public void dispose() {
		// do nothing
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
	
}
