/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */


package org.unicase.ui.visualization.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.common.model.Project;
import org.unicase.model.UnicaseModelElement;
import ch.randelshofer.tree.TreeNode;

/**
 * Represents a node in a {@link UnicaseTree}. 
 * Normally linked with an {@link EObject}.
 * 
 * @author Julian Sommerfeldt
 *
 */
public class UnicaseNode implements TreeNode, Comparable<UnicaseNode> {

	private ArrayList<TreeNode> children;
	
	private List<UnicaseNode> implicitNodes;
	
	private ArrayList<TreeNode> references;
	
	private boolean isImplicit;
	
	private String name;
	
	private List<String> infos;
	
	private EObject object;
		
	/**
	 * @param obj The {@link EObject}.
	 */
	public UnicaseNode(EObject obj){	
		if(obj instanceof Project){
			obj = obj.eContainer();		
		}
		if(obj instanceof ProjectSpace){
			ProjectSpace projectSpace = (ProjectSpace)obj;
			this.name = projectSpace.getProjectName();
			this.object = projectSpace.getProject();
		} else {
			this.name = ((UnicaseModelElement)obj).getName();
			this.object = obj;
		}	
		
		addInfo("Name: " + this.name);
		addInfo("Type: " + obj.eClass().getName());		
	}
	
	/**
	 * @param name The name.
	 */
	public UnicaseNode(String name){
		this.name = name;
	}
	
	/**
	 * Builds a copy of the Node only containing the references.
	 * 
	 * @return A copy of the Node.
	 */
	public UnicaseNode getReferenceNode(){
		UnicaseNode node = new UnicaseNode(object);
		node.children = references;
		return node;
	}
	
	/**
	 * @param node The node to add.
	 */
	public void addReference(UnicaseNode node){
		if(references == null){
			references = new ArrayList<TreeNode>();
		}
		references.add(node);
	}
		
	/**
	 * Receives the children of the node. Containing also the implicit nodes.
	 * @return the children.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TreeNode> children() {		
		if(children == null){
			return Collections.EMPTY_LIST;
		} else if(implicitNodes != null) {
			List<TreeNode> nodes = new ArrayList<TreeNode>();
			nodes.addAll(implicitNodes);
			nodes.addAll(children);
			return nodes;
		} else {
			return children;
		}
	}
	
	/**
	 * @param child The child.
	 */
	public void addChild(TreeNode child) {
        if (children == null) {
            children = new ArrayList<TreeNode>();
        }
        children.add(child);
    }
	
	/**
	 * @param child The child.
	 */
	public void removeChild(TreeNode child){
		if(children != null){
			children.remove(child);
		}
	}
	
	/**
	 * @param node The node.
	 */
	public void addImplicitNode(UnicaseNode node){
		if(implicitNodes == null){
			implicitNodes = new ArrayList<UnicaseNode>();
		}
		node.setImplicit(true);
		implicitNodes.add(node);
	}

    @Override
    public boolean getAllowsChildren() {
        return children != null;
    }
    
    /**
     * @param info The info to add.
     */
    public void addInfo(String info){
    	if(infos == null){
    		infos = new ArrayList<String>();
    	}
    	infos.add(info);
    }
    
    /**
     * @return all infos.
     */
    public List<String> getInfos(){
    	return infos;
    }
    
    /**
     * @param name the name to set.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return the name.
     */
    public String getName() {
        return name;
    }
        
    @Override
    public String toString(){
    	String ret = "<html>";
    	if(infos != null){
    		for(String s : infos){
    			ret += s + "<br>"; 
    		}
    	}
    	return ret + "</html>";
    }
    
    /**
     * @return the {@link EObject}.
     */
	public EObject getEObject() {
		return object;
	}

	/**
	 * @param isImplicit Is it an implicit node?
	 */
	public void setImplicit(boolean isImplicit) {
		this.isImplicit = isImplicit;
	}

	/**
	 * @return Is it an implicit node?
	 */
	public boolean isImplicit() {
		return isImplicit;
	}
	
	@Override
	public boolean equals(Object o){
		// it its not a unicasenode
		if(!(o instanceof UnicaseNode)){
			return false;
		}
		EObject eObj = ((UnicaseNode)o).getEObject();
		
		// if its the same eobject
		if(eObj.equals(getEObject())){
			return true;
		}
		
		// if its the same eobject, but not the same object 
		if(eObj instanceof UnicaseModelElement && getEObject() instanceof UnicaseModelElement){
			if(((UnicaseModelElement)eObj).getModelElementId().equals( ((UnicaseModelElement)getEObject()).getModelElementId() ) ){
				return true;
			}
		}
		if(eObj instanceof Project && getEObject() instanceof Project){
			if( ((ProjectSpace) ((Project)eObj).eContainer()).getProjectId().equals( ((ProjectSpace) ((Project)getEObject()).eContainer()).getProjectId() ) ){
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public int hashCode(){
		return super.hashCode();
	}
	
	/**
	 * Compares two UnicaseNodes by comparing the creation date of their {@link EObject}s.
	 * 
	 * @param node The node to compare.
	 * @return comparison
	 */
	@Override
	public int compareTo(UnicaseNode node) {
		EObject o = node.getEObject();
		if(o == null || object == null){
			return -1;
		}
		if(object instanceof UnicaseModelElement && o instanceof UnicaseModelElement){
			Date creationDate1 = ((UnicaseModelElement)object).getCreationDate();
			Date creationDate2 = ((UnicaseModelElement)o).getCreationDate();
			if(creationDate1 == null || creationDate2 == null){
				return -1;
			}
			return creationDate1.compareTo(creationDate2);
		}
		throw new IllegalArgumentException("The object has to be a UnicaseModelElement!");
	}
}
